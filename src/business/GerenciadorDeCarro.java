package business;


import business.exception.RegistroJaExistenteException;
import business.exception.RegistroNaoEncontradoException;
import model.carro.Carro;
import model.carro.Tipo;
import model.cliente.Cliente;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;
import persistence.CarroRepository;
import persistence.ClienteRepository;

import java.time.LocalDateTime;
import java.util.List;

public class GerenciadorDeCarro {

    public static final String CARRO_DESCRICAO_CLASSE = "Carro";
    private final CarroRepository repository;

    public GerenciadorDeCarro(CarroRepository repository) {
        this.repository = repository;
    }

    public Carro adicionarCarro(String placa, String nome, Tipo tipo) {

        if (existeCarro(placa)) {
            throw new RegistroJaExistenteException(CARRO_DESCRICAO_CLASSE, placa);
        }
        Carro novoCarro = new Carro(placa, nome, tipo);

        Carro carroSalvo = repository.salvar(novoCarro);
            return carroSalvo;
        }

    public Carro editarCarro(String placa, String nome, Tipo tipo) {

        Carro carro = repository.consultar(placa);
        boolean carroNaoExiste = carro == null;

        if (carroNaoExiste) {
            throw new RegistroNaoEncontradoException(CARRO_DESCRICAO_CLASSE, nome);
        }
        if(nome!=null){
            carro.setNome(nome);
        }
        if(tipo!=null){
            carro.setTipo(tipo);
        }

        repository.atualizar(carro);
        return carro;
    }

    public List<Carro> consultarByNome(String nome) {
        return repository.findByNome(nome);
    }

    public boolean existeCarro(String nome) {
        return repository.consultar(nome) != null;
    }

    public List<Carro> listarTodos() {
        return repository.listarTodos();
    }
}
