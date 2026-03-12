import java.math.BigDecimal;

public class Pedido {
    private final Produtos produtos;

    public Pedido(Produtos produtos) {
        this.produtos = produtos;
    }

    public BigDecimal calcularValorDaEntrega(MetodoDeEntrega metodoDeEntrega) {
        Peso pesoTotal = this.produtos.pesoTotal();
        return metodoDeEntrega.calcularCustoPara(pesoTotal);
    }
}