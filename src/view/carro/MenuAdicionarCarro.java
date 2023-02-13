package view.carro;


import business.GerenciadorDeCarro;
import model.carro.Carro;
import model.carro.Tipo;

import view.CapturadorDeEntrada;
import view.Submenu;

public class MenuAdicionarCarro extends Submenu {

    private final GerenciadorDeCarro gerenciadorDeCarro;

    public MenuAdicionarCarro(GerenciadorDeCarro gerenciadorDeCarro) {
        super("Cadastrar " + GerenciadorDeCarro.CARRO_DESCRICAO_CLASSE);
        this.gerenciadorDeCarro = gerenciadorDeCarro;
    }

    @Override
    public void acao() {
        String placa = CapturadorDeEntrada.capturarString("a placa");

        if (gerenciadorDeCarro.existeCarro(placa)) {
            System.out.println("Já existe um carro com essa placa");
            return;
        }

        String nome = CapturadorDeEntrada.capturarString("o nome");

        String idtipo = CapturadorDeEntrada.capturarString("o tipo entre ("+Tipo.allTipoToString()+")");

        var tipoOp = Tipo.getTipoById(Integer.parseInt(idtipo));

        if (tipoOp.isEmpty()) {
            System.out.println("Tipo não identificado");
            return;
        }
        Carro carroAdicionado = gerenciadorDeCarro.adicionarCarro(placa,nome, tipoOp.get() );

        System.out.println(GerenciadorDeCarro.CARRO_DESCRICAO_CLASSE + " adicionado com sucesso");
        System.out.println(carroAdicionado);
    }
}
