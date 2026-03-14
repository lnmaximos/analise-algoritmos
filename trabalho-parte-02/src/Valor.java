import java.math.BigDecimal;

public record Valor(BigDecimal quantia) {
    public Valor {
        if (quantia == null || quantia.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
    }

    public Valor(String quantia) {
        this(new BigDecimal(quantia));
    }

    public boolean isIgual(Valor outro) {
        return this.quantia.compareTo(outro.quantia) == 0;
    }

    public String formatado() {
        return "R$ " + this.quantia.toString();
    }
}