package view.cliente;


import business.GerenciadorDeCliente;
import view.MenuComSubmenus;
import view.MenuFactory;
import view.cliente.pessoa.MenuDeTipoPessoaFactory;

public class MenuDeClienteFactory implements MenuFactory {

    private final GerenciadorDeCliente gerenciadorDeCliente;

    public MenuDeClienteFactory(GerenciadorDeCliente gerenciadorDeCliente) {
        this.gerenciadorDeCliente = gerenciadorDeCliente;
    }

    @Override
    public MenuComSubmenus create() {
        MenuComSubmenus menuDeClientes = new MenuComSubmenus("Menu de Cliente");
        menuDeClientes.adicionarSubMenu(new MenuDeTipoPessoaFactory(gerenciadorDeCliente).create());
        menuDeClientes.adicionarSubMenu(new MenuEditarCliente(gerenciadorDeCliente));
        menuDeClientes.adicionarSubMenu(new MenuListarCliente(gerenciadorDeCliente));
        return menuDeClientes;
    }
}
