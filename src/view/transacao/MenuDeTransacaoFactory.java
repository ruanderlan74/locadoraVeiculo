package view.transacao;

import business.GerenciadorDeTransacao;
import persistence.CarroRepository;
import persistence.ClienteRepository;
import view.MenuComSubmenus;
import view.MenuFactory;


public class MenuDeTransacaoFactory implements MenuFactory {

    private final GerenciadorDeTransacao gerenciadorDeTransacao;

    public MenuDeTransacaoFactory(GerenciadorDeTransacao gerenciadorDeTransacao) {
        this.gerenciadorDeTransacao = gerenciadorDeTransacao;
    }

    @Override
    public MenuComSubmenus create() {
        MenuComSubmenus menuDeTranscao = new MenuComSubmenus("Menu de Transação");
        menuDeTranscao.adicionarSubMenu(new MenuAlugar(gerenciadorDeTransacao));
        menuDeTranscao.adicionarSubMenu(new MenuDevolver(gerenciadorDeTransacao));

        return menuDeTranscao;
    }
}
