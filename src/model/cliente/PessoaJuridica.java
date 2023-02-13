package model.cliente;

import java.time.LocalDate;

public class PessoaJuridica extends Cliente{

    private String cnpj;

    public PessoaJuridica(String cnpj, String nome) {
        super(nome);
        this.cnpj = cnpj;
    }

    @Override
    public String getId() {
        return cnpj;
    }
    @Override
    public String toString() {
        return super.toString()+", CNPJ: "+cnpj+".";
    }

}
