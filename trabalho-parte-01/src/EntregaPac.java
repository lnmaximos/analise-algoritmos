import java.math.BigDecimal;

public class EntregaPac implements MetodoDeEntrega {
    @Override
    public BigDecimal calcularCustoPara(Peso peso) {
        if (peso.isMaiorQue(2000)) {
            throw new IllegalArgumentException("Encomenda PAC não aceita pedidos acima de 2 kg.");
        }

        if (peso.isMaiorQue(1000)) {
            return new BigDecimal("15.00");
        }

        return new BigDecimal("10.00");
    }
}