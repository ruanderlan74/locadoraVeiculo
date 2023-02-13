package model.carro;


import java.math.BigDecimal;
import java.util.Optional;

public enum Tipo {
    PEQUENO(1, 100), MEDIO(2, 150), SUV(3, 200);

    private int id;
    private int valor;


    Tipo(int id, int valor) {
        this.id = id;
        this.valor = valor;
    }


    public static Optional<Tipo> getTipoById(int id){
        for(Tipo tipo : Tipo.values()){
            if(tipo.id == id){
                return Optional.of(tipo);
            }
        }
        return Optional.empty();
    }

    public static String allTipoToString(){
        var sb = new StringBuilder();
        for(Tipo tipo : Tipo.values()){
            sb.append(tipo.id+". "+tipo+",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(".");
        return sb.toString();
    }

    public int getValor() {
        return valor;
    }
}
