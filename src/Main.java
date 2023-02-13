import business.GerenciadorDeCarro;
import business.GerenciadorDeCliente;
import business.GerenciadorDeTransacao;
import persistence.CarroRepository;
import persistence.ClienteRepository;
import view.MenuComSubmenus;
import view.MenuGeralFactory;
import view.carro.MenuDeCarroFactory;
import view.cliente.MenuDeClienteFactory;
import view.transacao.MenuDeTransacaoFactory;

public class Main {
    public static void main(String[] args) {

        ClienteRepository repositoryCliente = new ClienteRepository();
        CarroRepository repositoryCarro = new CarroRepository();

        GerenciadorDeCliente gerenciadorDeCliente = new GerenciadorDeCliente(repositoryCliente);
        GerenciadorDeCarro gerenciadorDeCarro = new GerenciadorDeCarro(repositoryCarro);

        MenuDeClienteFactory menuDeClienteFactory = new MenuDeClienteFactory(gerenciadorDeCliente);
        MenuDeCarroFactory menuDeCarroFactory = new MenuDeCarroFactory(gerenciadorDeCarro);

        GerenciadorDeTransacao gerenciadorDeTransacao = new GerenciadorDeTransacao(repositoryCliente,repositoryCarro);
        MenuDeTransacaoFactory menuDeTransacaoFactory = new MenuDeTransacaoFactory(gerenciadorDeTransacao);

        MenuComSubmenus menuteste = new MenuGeralFactory(menuDeClienteFactory, menuDeCarroFactory, menuDeTransacaoFactory).create();
        menuteste.agir();
    }
}