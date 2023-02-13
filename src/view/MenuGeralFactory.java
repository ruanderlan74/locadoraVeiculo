package view;


import view.carro.MenuDeCarroFactory;
import view.cliente.MenuDeClienteFactory;
import view.transacao.MenuDeTransacaoFactory;

public class MenuGeralFactory implements MenuFactory {

    private final MenuDeClienteFactory menuDeClienteFactory;
    private final MenuDeCarroFactory menuDeCarroFactory;
    private final MenuDeTransacaoFactory menuDeTransacaoFactory;


    public MenuGeralFactory(MenuDeClienteFactory menuDeClienteFactory, MenuDeCarroFactory MenuDeCarroFactory, MenuDeTransacaoFactory menuDeTransacaoFactory) {
        this.menuDeClienteFactory = menuDeClienteFactory;
        this.menuDeCarroFactory = MenuDeCarroFactory;
        this.menuDeTransacaoFactory = menuDeTransacaoFactory;
    }

    @Override
    public MenuComSubmenus create() {
        MenuGeral menuGeral = new MenuGeral();
        menuGeral.adicionarSubMenu(menuDeClienteFactory.create());
        menuGeral.adicionarSubMenu(menuDeCarroFactory.create());
        menuGeral.adicionarSubMenu(menuDeTransacaoFactory.create());

        menuGeral.adicionarSubMenu(new MenuEncerrar());
        return menuGeral;
    }
}
