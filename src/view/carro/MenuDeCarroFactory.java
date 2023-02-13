package view.carro;


import business.GerenciadorDeCarro;
import view.MenuComSubmenus;
import view.MenuFactory;

public class MenuDeCarroFactory implements MenuFactory {

    private final GerenciadorDeCarro gerenciadorDeCarro;

    public MenuDeCarroFactory(GerenciadorDeCarro gerenciadorDeCarro) {
        this.gerenciadorDeCarro = gerenciadorDeCarro;
    }

    @Override
    public MenuComSubmenus create() {
        MenuComSubmenus menuDeCarros = new MenuComSubmenus("Menu de Carro");
        menuDeCarros.adicionarSubMenu(new MenuAdicionarCarro(gerenciadorDeCarro));
        menuDeCarros.adicionarSubMenu(new MenuConsultaCarro(gerenciadorDeCarro));
        menuDeCarros.adicionarSubMenu(new MenuListarCarro(gerenciadorDeCarro));
        return menuDeCarros;
    }
}
