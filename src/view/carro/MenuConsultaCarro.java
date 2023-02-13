package view.carro;


import business.GerenciadorDeCarro;
import view.CapturadorDeEntrada;
import view.Submenu;

public class MenuConsultaCarro extends Submenu {

    private final GerenciadorDeCarro gerenciadorDeCarro;

    public MenuConsultaCarro(GerenciadorDeCarro gerenciadorDeCarro) {
        super("Consultar " + GerenciadorDeCarro.CARRO_DESCRICAO_CLASSE + " por nome");
        this.gerenciadorDeCarro = gerenciadorDeCarro;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarString("o nome");
        var carros = gerenciadorDeCarro.consultarByNome(nome);
        if (carros.isEmpty()) {
            System.out.println("Não existe carros com esse nome");
            return;
        }
        System.out.println("Carros encontrados: ");
        carros.forEach(System.out::println);
    }
}
