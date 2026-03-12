import java.math.BigDecimal;

public class RetiradaNaLoja implements MetodoDeEntrega {
    @Override
    public BigDecimal calcularCustoPara(Peso peso) {
        return BigDecimal.ZERO;
    }
}