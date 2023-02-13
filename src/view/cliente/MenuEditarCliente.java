package view.cliente;

import business.GerenciadorDeCliente;
import model.cliente.Cliente;
import view.CapturadorDeEntrada;
import view.Submenu;

public class MenuEditarCliente extends Submenu {

    private final GerenciadorDeCliente gerenciadorDeCliente;

    public MenuEditarCliente(GerenciadorDeCliente gerenciadorDeCliente) {
        super("Alterar " + GerenciadorDeCliente.CLIENTE_DESCRICAO_CLASSE);
        this.gerenciadorDeCliente = gerenciadorDeCliente;
    }

    @Override
    public void acao() {
        String cpfcnpj = CapturadorDeEntrada.capturarString("o documento");

        if (!gerenciadorDeCliente.existeCliente(cpfcnpj)) {
            System.out.println("Não existe um cliente com esse documento");
            return;
        }

        String nome = CapturadorDeEntrada.capturarString("o nome");
        Cliente clienteAlterado = gerenciadorDeCliente.editarCliente(cpfcnpj, nome);

        System.out.println(GerenciadorDeCliente.CLIENTE_DESCRICAO_CLASSE + " alterado com sucesso");
        System.out.println(clienteAlterado);
    }
}
