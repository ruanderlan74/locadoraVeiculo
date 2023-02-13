package business;


import business.exception.RegistroJaExistenteException;
import business.exception.RegistroNaoEncontradoException;
import model.cliente.Cliente;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;
import persistence.ClienteRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class GerenciadorDeCliente {

    public static final String CLIENTE_DESCRICAO_CLASSE = "Cliente";
    private final ClienteRepository repository;

    public GerenciadorDeCliente(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente adicionarCliente(String nome, String cpfCnpj, boolean isPessoaFissica) {

        if (existeCliente(cpfCnpj)) {
            throw new RegistroJaExistenteException(CLIENTE_DESCRICAO_CLASSE, cpfCnpj);
        }
        Cliente novoCliente;
        if (isPessoaFissica) {
            novoCliente = new PessoaFisica(nome, cpfCnpj);
        }else{
            novoCliente = new PessoaJuridica(nome, cpfCnpj);
        }
            Cliente clienteSalvo = repository.salvar(novoCliente);
            return clienteSalvo;
        }

    public Cliente editarCliente(String cpfCnpf, String nome) {

        Cliente cliente = repository.consultar(cpfCnpf);
        boolean clienteNaoExiste = cliente == null;

        if (clienteNaoExiste) {
            throw new RegistroNaoEncontradoException(CLIENTE_DESCRICAO_CLASSE, cpfCnpf);
        }
        if(nome!=null){
            cliente.setNome(nome);
        }
        repository.atualizar(cliente);
        return cliente;
    }

    public boolean existeCliente(String nome) {
        return repository.consultar(nome) != null;
    }

    public List<Cliente> listarTodos() {
        return repository.listarTodos();
    }
}
