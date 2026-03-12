import java.math.BigDecimal;

public class EntregaSedex implements MetodoDeEntrega {
    private static final BigDecimal PRECO_BASE_ACIMA_1KG = new BigDecimal("46.50");
    private static final BigDecimal CUSTO_ADICIONAL_POR_100G = new BigDecimal("1.50");

    @Override
    public BigDecimal calcularCustoPara(Peso peso) {
        if (peso.isMenorOuIgual(500)) {
            return new BigDecimal("12.50");
        }

        if (peso.isMenorOuIgual(1000)) {
            return new BigDecimal("20.00");
        }

        return calcularCustoExcessoPeso(peso);
    }

    private BigDecimal calcularCustoExcessoPeso(Peso peso) {
        int fracoesAdicionais = peso.contarFracoesDe100gExcedentes(1000);
        BigDecimal custoExtra = CUSTO_ADICIONAL_POR_100G.multiply(new BigDecimal(fracoesAdicionais));
        return PRECO_BASE_ACIMA_1KG.add(custoExtra);
    }
}