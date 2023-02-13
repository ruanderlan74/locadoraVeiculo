package model.carro;

import model.Entidade;
import model.cliente.Cliente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Carro implements Entidade {
    private String placa;

    private String nome;
    private LocalDateTime dataAlugel;
    private Tipo tipo;
    private Cliente cliente;

    public Carro(String placa, String nome, Tipo tipo) {
        this.placa = placa;
        this.nome=nome;
        this.tipo = tipo;
    }

    @Override
    public String getId() {
        return placa;
    }
    @Override
    public String getNomeEntidade() {
        return "Carro";
    }

    public String getPlaca() {
        return placa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataAlugel() {
        return dataAlugel;
    }

    public void setDataAlugel(LocalDateTime dataAlugel) {
        this.dataAlugel = dataAlugel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    private String aluguelToString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataAlugel!=null?" alugado em "+ dataAlugel.format(formatter)+ " por "+ cliente.getNome() : " disponivel";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Carro:"+placa+", Nome: "+nome+ ", Tipo: "+ tipo +""+aluguelToString() ;
    }
}
