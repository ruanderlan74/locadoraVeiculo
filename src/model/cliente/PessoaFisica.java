package model.cliente;

import java.time.LocalDate;

public class PessoaFisica extends Cliente{

    private String cpf;

    public PessoaFisica(String cpf, String nome) {
        super(nome);
        this.cpf = cpf;
    }

    @Override
    public String getId() {
        return cpf;
    }

    @Override
    public String toString() {
        return super.toString()+", CPF: "+cpf+".";
    }
}
