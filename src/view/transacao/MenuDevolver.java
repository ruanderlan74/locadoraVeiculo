package view.transacao;

import business.GerenciadorDeTransacao;
import business.exception.RegistroNaoEncontradoException;
import model.carro.Carro;
import persistence.CarroRepository;
import persistence.ClienteRepository;
import view.CapturadorDeEntrada;
import view.Submenu;

import java.util.List;

public class MenuDevolver extends Submenu {

    private final GerenciadorDeTransacao gerenciadorDeTransacao;


    public MenuDevolver(GerenciadorDeTransacao gerenciadorDeTransacao) {
        super("Devolver Carro");
        this.gerenciadorDeTransacao = gerenciadorDeTransacao;
    }


    @Override
    public void acao() {

        String placa = CapturadorDeEntrada.capturarString("a placa do carro que será devolvido");

        if (!gerenciadorDeTransacao.existeCarro(placa)) {
           throw new RegistroNaoEncontradoException("Carro", placa);
        }
        String ano = CapturadorDeEntrada.capturarString("o ano da devolução");
        String mes = CapturadorDeEntrada.capturarString("o mes da devolução");
        String dia = CapturadorDeEntrada.capturarString("o dia da devolução");
        String hora = CapturadorDeEntrada.capturarString("o hora da devolução");
        String minuto = CapturadorDeEntrada.capturarString("o minuto da devolução");
        String segundo = CapturadorDeEntrada.capturarString("o segundo da devolução");


        gerenciadorDeTransacao.devolver(placa, Integer.parseInt(ano),Integer.parseInt(mes),Integer.parseInt(dia),Integer.parseInt(hora),Integer.parseInt(minuto),Integer.parseInt(segundo));

    }
}
