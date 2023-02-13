package business;

import business.exception.RegistroAluguelException;
import business.exception.RegistroNaoEncontradoException;
import model.carro.Carro;
import model.cliente.Cliente;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;
import persistence.CarroRepository;
import persistence.ClienteRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class GerenciadorDeTransacao {
    public static final String TRANSACAO_DESCRICAO_CLASSE = "Transacao";
    private final ClienteRepository clienteRepository;
    private final CarroRepository carroRepository;


    public GerenciadorDeTransacao(ClienteRepository clienteRepository, CarroRepository carroRepository) {
        this.clienteRepository = clienteRepository;
        this.carroRepository = carroRepository;
    }

    public void alugar(String cpfCnpj, String placa, int ano, int mes, int dia, int hora, int minuto, int segundo) {

        Cliente cliente = clienteRepository.consultar(cpfCnpj);
        boolean clienteNaoExiste = cliente == null;

        if (clienteNaoExiste) {
            throw new RegistroNaoEncontradoException(GerenciadorDeCliente.CLIENTE_DESCRICAO_CLASSE, cpfCnpj);
        }
        Carro carro = carroRepository.consultar(placa);
        boolean carroNaoExiste = carro == null;
        if (carroNaoExiste) {
            throw new RegistroNaoEncontradoException(GerenciadorDeCarro.CARRO_DESCRICAO_CLASSE, placa);
        }
        if(carro.getDataAlugel()!=null){
            throw new RegistroAluguelException("Carro já está alugado");
        }

        carro.setDataAlugel(LocalDateTime.of(ano,mes,dia,hora,minuto,segundo));
        carro.setCliente(cliente);

        System.out.println(cliente.toString()+", alugou o Carro: " + carro.getNome()+", Placa:"+ carro.getPlaca());
    }
    public void devolver(String placa,  int ano, int mes, int dia, int hora, int minuto, int segundo) {

        Carro carro = carroRepository.consultar(placa);
        boolean carroNaoExiste = carro == null;
        if (carroNaoExiste) {
            throw new RegistroNaoEncontradoException(GerenciadorDeCarro.CARRO_DESCRICAO_CLASSE, placa);
        }
        if(carro.getDataAlugel()==null){
            throw new RegistroAluguelException("Carro não está alugado");
        }
        var dataDevolucao = LocalDateTime.of(ano,mes,dia,hora,minuto,segundo);
        var valor = calculoDoValorAluguel(carro, dataDevolucao);
        System.out.println(carro.getCliente().toString()+", devolveu o Carro: " + carro.getNome()+", Placa:"+ carro.getPlaca() + " deve pagar R$ "+valor);
        carro.setCliente(null);
        carro.setDataAlugel(null);


    }

    private double calculoDoValorAluguel(Carro carro, LocalDateTime dataDevolucao) {
        Duration duration = Duration.between(carro.getDataAlugel(), dataDevolucao);
        var diasAlugados = duration.toDays() + 1;
        var valorPrelimilar =  carro.getTipo().getValor() * (diasAlugados);
        return valorPrelimilar - cacalcularDesconto(valorPrelimilar, carro.getCliente(), diasAlugados);
    }

    private double cacalcularDesconto(long valorPrelimilar, Cliente cliente, Long diasAlugados) {
        if(cliente.getClass().equals(PessoaFisica.class) && diasAlugados > 5 ){
            return valorPrelimilar * 0.05;
        }
        if(cliente.getClass().equals(PessoaJuridica.class) && diasAlugados > 3){
            return valorPrelimilar * 0.10;
        }
        return 0;
    }


    public boolean existeCliente(String cpfCnpj) {
        return clienteRepository.consultar(cpfCnpj) != null;
    }

    public boolean existeCarro(String placa) {
        return carroRepository.consultar(placa) != null;
    }

    public List<Carro> disponiveisParaAluguel() {
        return carroRepository.disponiveisParaAluguel();
    }


}
