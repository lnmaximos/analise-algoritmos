import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroDeOfertas {
    private final List<Ordem> compras = new ArrayList<>();
    private final List<Ordem> vendas = new ArrayList<>();

    public Optional<Valor> registrarEBuscarAcordo(Ordem ordem) {
        adicionarNaListaCorreta(ordem);
        return realizarAcordoSeExistir();
    }

    private void adicionarNaListaCorreta(Ordem ordem) {
        if (ordem.isCompra()) {
            compras.add(ordem);
            return;
        }
        vendas.add(ordem);
    }

    private Optional<Valor> realizarAcordoSeExistir() {
        for (Ordem compra : compras) {
            Ordem vendaCompativel = encontrarVendaCompativelCom(compra);
            if (vendaCompativel != null) {
                return efetivarMatch(compra, vendaCompativel);
            }
        }
        return Optional.empty();
    }

    private Ordem encontrarVendaCompativelCom(Ordem compra) {
        for (Ordem venda : vendas) {
            if (venda.valor().isIgual(compra.valor())) {
                return venda;
            }
        }
        return null;
    }

    private Optional<Valor> efetivarMatch(Ordem compra, Ordem venda) {
        compras.remove(compra);
        vendas.remove(venda);
        return Optional.of(compra.valor());
    }
}