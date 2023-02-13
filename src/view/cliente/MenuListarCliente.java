package view.cliente;


import business.GerenciadorDeCliente;
import model.cliente.Cliente;
import view.Submenu;

import java.util.List;

public class MenuListarCliente extends Submenu {

    private final GerenciadorDeCliente gerenciadorDeCliente;


    public MenuListarCliente(GerenciadorDeCliente gerenciadorDeCliente) {
        super("Listar todos " + GerenciadorDeCliente.CLIENTE_DESCRICAO_CLASSE);
        this.gerenciadorDeCliente = gerenciadorDeCliente;
    }

    @Override
    public void acao() {
        List<Cliente> clientes = gerenciadorDeCliente.listarTodos();

        if (clientes.isEmpty()) {
            System.out.println("Não existem cliente cadastrados!");
            return;
        }

        System.out.println("Cliente encontrados: ");
        clientes.forEach(System.out::println);

    }
}
