package persistence;

import model.carro.Carro;

import java.util.List;
import java.util.stream.Collectors;

public class CarroRepository extends Repository<Carro> {
    public List<Carro> findByNome(String nome){
    return listarTodos().stream()
            .filter(carro -> carro.getNome().contains(nome))
            .collect(Collectors.toList());
    }

    public List<Carro> disponiveisParaAluguel(){
        return listarTodos().stream()
                .filter(carro -> carro.getDataAlugel() ==null)
                .collect(Collectors.toList());
    }


}
