package view.transacao;

import business.GerenciadorDeCarro;
import business.GerenciadorDeTransacao;
import model.carro.Carro;
import model.carro.Tipo;
import model.cliente.Cliente;
import persistence.CarroRepository;
import persistence.ClienteRepository;
import view.CapturadorDeEntrada;
import view.Submenu;

import java.util.List;

public class MenuAlugar extends Submenu {

    private final GerenciadorDeTransacao gerenciadorDeTransacao;


    public MenuAlugar(GerenciadorDeTransacao gerenciadorDeTransacao) {
        super("Alugar Carro");
        this.gerenciadorDeTransacao = gerenciadorDeTransacao;
    }


    @Override
    public void acao() {

        List<Carro> carros = gerenciadorDeTransacao.disponiveisParaAluguel();

        if (carros.isEmpty()) {
            System.out.println("Não existem carros disponiveis para alugar!");
            return;
        }
        System.out.println("Carros diponiveis para o aluguel :");
        carros.forEach(System.out::println);


        String placa = CapturadorDeEntrada.capturarString("a placa do carro que será alugado");

        String cpfCnpj = CapturadorDeEntrada.capturarString("o cpf ou cnpj do cliente");

        String ano = CapturadorDeEntrada.capturarString("o ano do aluguel");
        String mes = CapturadorDeEntrada.capturarString("o mes do aluguel");
        String dia = CapturadorDeEntrada.capturarString("o dia do aluguel");
        String hora = CapturadorDeEntrada.capturarString("o hora do aluguel");
        String minuto = CapturadorDeEntrada.capturarString("o minuto do aluguel");
        String segundo = CapturadorDeEntrada.capturarString("o segundo do aluguel");


        gerenciadorDeTransacao.alugar(cpfCnpj, placa, Integer.parseInt(ano),Integer.parseInt(mes),Integer.parseInt(dia),Integer.parseInt(hora),Integer.parseInt(minuto),Integer.parseInt(segundo));

    }
}
