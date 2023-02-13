package view.carro;


import business.GerenciadorDeCarro;
import model.carro.Carro;
import view.Submenu;

import java.util.List;

public class MenuListarCarro extends Submenu {

    private final GerenciadorDeCarro gerenciadorDeCarro;


    public MenuListarCarro(GerenciadorDeCarro gerenciadorDeCarro) {
        super("Listar todos " + GerenciadorDeCarro.CARRO_DESCRICAO_CLASSE);
        this.gerenciadorDeCarro = gerenciadorDeCarro;
    }

    @Override
    public void acao() {
        List<Carro> carros = gerenciadorDeCarro.listarTodos();

        if (carros.isEmpty()) {
            System.out.println("Não existem carros cadastrados!");
            return;
        }

        System.out.println("Carros encontrados: ");
        carros.forEach(System.out::println);

    }
}
