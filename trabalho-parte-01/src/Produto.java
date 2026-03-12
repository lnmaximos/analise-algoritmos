import java.math.BigDecimal;

public class Produto {
    private final String nome;
    private final BigDecimal valor;
    private final Peso peso;

    public Produto(String nome, BigDecimal valor, Peso peso) {
        this.nome = nome;
        this.valor = valor;
        this.peso = peso;
    }

    public Peso peso() {
        return this.peso;
    }
}