public record Ordem(Investidor investidor, TipoOrdem tipo, Valor valor) {
    public boolean isCompra() {
        return this.tipo == TipoOrdem.COMPRA;
    }
}