package view.cliente;


import business.GerenciadorDeCliente;
import model.cliente.Cliente;
import view.CapturadorDeEntrada;
import view.Submenu;

public class MenuAdicionarCliente extends Submenu {

    private final GerenciadorDeCliente gerenciadorDeCliente;
    private final boolean isPessoaFisica;

    public MenuAdicionarCliente(GerenciadorDeCliente gerenciadorDeCliente, boolean isPessoaFisica) {
        super("Cadastrar " + GerenciadorDeCliente.CLIENTE_DESCRICAO_CLASSE +", Pessoa "+tipoPessoa(isPessoaFisica));
        this.gerenciadorDeCliente = gerenciadorDeCliente;
        this.isPessoaFisica = isPessoaFisica;
    }

    private static String tipoPessoa(boolean isPessoaFisica) {
       return isPessoaFisica?"Fisica":"Juridica";
    }
    private static String tipoDocumento(boolean isPessoaFisica) {
        return isPessoaFisica?"CPF":"CNPJ";
    }

    @Override
    public void acao() {
        String cpfCnpj = CapturadorDeEntrada.capturarString("o "+tipoDocumento(isPessoaFisica));

        if (gerenciadorDeCliente.existeCliente(cpfCnpj)) {
            System.out.println("Já existe um cliente com esse "+tipoDocumento(isPessoaFisica));
            return;
        }

        String nome = CapturadorDeEntrada.capturarString("o nome");

        Cliente clienteAdicionado = gerenciadorDeCliente.adicionarCliente(cpfCnpj,nome, isPessoaFisica );

        System.out.println(GerenciadorDeCliente.CLIENTE_DESCRICAO_CLASSE + " adicionado com sucesso");
        System.out.println(clienteAdicionado);
    }
}
