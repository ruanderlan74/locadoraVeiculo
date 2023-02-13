package view.cliente.pessoa;

import business.GerenciadorDeCliente;
import view.MenuComSubmenus;
import view.MenuFactory;
import view.cliente.MenuAdicionarCliente;

public class MenuDeTipoPessoaFactory implements MenuFactory {

    private final GerenciadorDeCliente gerenciadorDeCliente;

    public MenuDeTipoPessoaFactory(GerenciadorDeCliente gerenciadorDeCliente) {
        this.gerenciadorDeCliente = gerenciadorDeCliente;
    }

    @Override
    public MenuComSubmenus create() {
        MenuComSubmenus menuDeAutores = new MenuComSubmenus("Cadastrar Cliente");
        menuDeAutores.adicionarSubMenu(new MenuAdicionarCliente(gerenciadorDeCliente, true));
        menuDeAutores.adicionarSubMenu(new MenuAdicionarCliente(gerenciadorDeCliente, false));

        return menuDeAutores;
    }
}
