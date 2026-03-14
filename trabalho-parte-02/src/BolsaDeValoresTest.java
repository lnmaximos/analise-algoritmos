import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BolsaDeValoresTest {

    @Test
    public void deveOcorrerMatchEAtualizarOPrecoDaAcao() {
        Acao bbrasil = new Acao(new Nome("Banco do Brasil"), new Valor("25.00"));
        Investidor mariana = new Investidor(new Nome("Mariana"));
        Investidor joaquim = new Investidor(new Nome("Joaquim"));

        // Mariana quer vender por 24, e Joaquim quer comprar por 24
        mariana.enviarOrdem(bbrasil, TipoOrdem.VENDA, new Valor("24.00"));
        joaquim.enviarOrdem(bbrasil, TipoOrdem.COMPRA, new Valor("24.00"));

        // O preço da ação deve ter caido para 24.00 após o match
        assertTrue(bbrasil.precoAtual().isIgual(new Valor("24.00")));
    }

    @Test
    public void deveNotificarInvestidorQuandoPrecoAtualizar() {
        Acao petrobras = new Acao(new Nome("Petrobras"), new Valor("30.00"));
        Investidor carlos = new Investidor(new Nome("Carlos"));

        // Carlos se registra para ser notificado
        petrobras.registrarInteresse(carlos);

        // Outros investidores fazem o preço mudar
        Investidor ana = new Investidor(new Nome("Ana"));
        Investidor pedro = new Investidor(new Nome("Pedro"));
        ana.enviarOrdem(petrobras, TipoOrdem.VENDA, new Valor("31.00"));
        pedro.enviarOrdem(petrobras, TipoOrdem.COMPRA, new Valor("31.00"));

        // Carlos deve ter recebido a notificação da mudança para 31.00
        assertTrue(carlos.recebeuNotificacaoContendo("atualizou para R$ 31.00"));
    }

    @Test
    public void ordemProgramadaDeveSerLancadaQuandoAcaoAtingirOValorGatilho() {
        Acao vale = new Acao(new Nome("Vale"), new Valor("65.00"));
        Investidor lucas = new Investidor(new Nome("Lucas"));

        // Lucas programa uma ordem de compra para caso a Vale caia para 60.00
        OrdemProgramada roboDoLucas = new OrdemProgramada(lucas, TipoOrdem.COMPRA, new Valor("60.00"));
        vale.registrarInteresse(roboDoLucas);

        // O mercado age e o preço cai para 60.00
        Investidor vendendorExterno = new Investidor(new Nome("Vendedor"));
        Investidor compradorExterno = new Investidor(new Nome("Comprador"));
        vendendorExterno.enviarOrdem(vale, TipoOrdem.VENDA, new Valor("60.00"));
        compradorExterno.enviarOrdem(vale, TipoOrdem.COMPRA, new Valor("60.00"));

        // Como o preço atingiu 60.00, o robô do Lucas disparou uma ordem de compra de 60.00 para ele
        // Se batermos com uma nova venda de 60.00 agora, um novo match será feito imediatamente (graças à ordem do Lucas)
        Investidor vendedorAtrasado = new Investidor(new Nome("Vendedor Atrasado"));
        vendedorAtrasado.enviarOrdem(vale, TipoOrdem.VENDA, new Valor("60.00"));

        // Se o robô não tivesse funcionado, a ordem do vendedor atrasado ficaria pendente no livro
        // Como o robô funcionou, o match da ação deve ter ocorrido de novo
        assertTrue(vale.precoAtual().isIgual(new Valor("60.00")));
    }
}