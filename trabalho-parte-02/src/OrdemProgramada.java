public class OrdemProgramada implements ObservadorDeAcao {
    private final Investidor investidor;
    private final TipoOrdem tipoOrdem;
    private final Valor valorGatilho;
    private boolean jaExecutada = false;

    public OrdemProgramada(Investidor investidor, TipoOrdem tipoOrdem, Valor valorGatilho) {
        this.investidor = investidor;
        this.tipoOrdem = tipoOrdem;
        this.valorGatilho = valorGatilho;
    }

    @Override
    public void precoAlterado(Acao acao, Valor novoPreco) {
        if (jaExecutada) {
            return;
        }

        if (novoPreco.isIgual(valorGatilho)) {
            acao.registrarOrdem(new Ordem(investidor, tipoOrdem, valorGatilho));
            jaExecutada = true;
        }
    }
}