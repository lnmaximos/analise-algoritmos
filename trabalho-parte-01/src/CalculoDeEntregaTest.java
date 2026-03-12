import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculoDeEntregaTest {

    private Pedido criarPedidoComPeso(int gramas) {
        Produto produtoFicticio = new Produto("Livro", new BigDecimal("50.00"), new Peso(gramas));
        Produtos produtos = new Produtos(List.of(produtoFicticio));
        return new Pedido(produtos);
    }

    // TESTES DO PAC

    @Test
    public void pac_DeveCustar10_QuandoPesoAte1Kg() {
        Pedido pedido = criarPedidoComPeso(800);
        BigDecimal custo = pedido.calcularValorDaEntrega(new EntregaPac());
        assertEquals(new BigDecimal("10.00"), custo);
    }

    @Test
    public void pac_DeveCustar15_QuandoPesoEntre1KgE2Kg() {
        Pedido pedido = criarPedidoComPeso(1500);
        BigDecimal custo = pedido.calcularValorDaEntrega(new EntregaPac());
        assertEquals(new BigDecimal("15.00"), custo);
    }

    @Test
    public void pac_DeveLancarExcecao_QuandoPesoAcimaDe2Kg() {
        Pedido pedido = criarPedidoComPeso(2500);
        assertThrows(IllegalArgumentException.class, () -> {
            pedido.calcularValorDaEntrega(new EntregaPac());
        });
    }

    // TESTES DO SEDEX

    @Test
    public void sedex_DeveCustar12E50_QuandoPesoAte500g() {
        Pedido pedido = criarPedidoComPeso(400);
        BigDecimal custo = pedido.calcularValorDaEntrega(new EntregaSedex());
        assertEquals(new BigDecimal("12.50"), custo);
    }

    @Test
    public void sedex_DeveCustar20_QuandoPesoEntre500gE1Kg() {
        Pedido pedido = criarPedidoComPeso(800);
        BigDecimal custo = pedido.calcularValorDaEntrega(new EntregaSedex());
        assertEquals(new BigDecimal("20.00"), custo);
    }

    @Test
    public void sedex_DeveCalcularFracoesAdicionais_QuandoPesoAcimaDe1Kg() {
        Pedido pedido = criarPedidoComPeso(1250);
        BigDecimal custo = pedido.calcularValorDaEntrega(new EntregaSedex());
        assertEquals(new BigDecimal("51.00"), custo);
    }

    // TESTE DE RETIRADA NA LOJA

    @Test
    public void retiradaNaLoja_DeveSempreCustarZero() {
        Pedido pedido = criarPedidoComPeso(5000);
        BigDecimal custo = pedido.calcularValorDaEntrega(new RetiradaNaLoja());
        assertEquals(BigDecimal.ZERO, custo);
    }
}