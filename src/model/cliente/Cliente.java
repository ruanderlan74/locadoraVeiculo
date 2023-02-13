package model.cliente;

import model.Entidade;
import model.carro.Carro;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente implements Entidade {

    private String nome;


    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNomeEntidade() {
        return "Cliente";
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente: "+nome;
    }
}
