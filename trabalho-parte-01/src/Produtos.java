import java.util.ArrayList;
import java.util.List;

public class Produtos {
    private final List<Produto> itens;

    public Produtos(List<Produto> itens) {
        this.itens = new ArrayList<>(itens);
    }

    public Peso pesoTotal() {
        Peso total = new Peso(0);
        for (Produto produto : itens) {
            total = total.somar(produto.peso());
        }
        return total;
    }
}