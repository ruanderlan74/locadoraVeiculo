package persistence;

import model.Entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repository<T extends Entidade>  {

        private final List<T> dados;

        public Repository() {
            this.dados = new ArrayList<>();
        }

        public T salvar(T entidade) {
            if (existe(entidade)) {
                throw new IllegalArgumentException("Já existe um "+entidade.getNomeEntidade()+" com esse id cadastrado");
            }
            dados.add(entidade);
            return entidade;
        }

        private boolean existe(T entidade) {
            String id = entidade.getId();
            return existe(id);
        }

        private boolean existe(String id) {
            return consultar(id) != null;
        }

        public void atualizar(T entidade) {
            if (!existe(entidade)) {
                throw new IllegalArgumentException("Não existe um "+entidade.getNomeEntidade()+" com esse ID cadastrado para atualizar");
            }

            salvar(entidade);
        }

        public T consultar(String id) {
        Optional<T> entidade = dados.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return entidade.orElse(null);
        }

        public List<T> listarTodos() {
            return new ArrayList<>(dados);
        }
    }
