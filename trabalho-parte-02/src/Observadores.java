import java.util.ArrayList;
import java.util.List;

public class Observadores {
    private final List<ObservadorDeAcao> inscritos = new ArrayList<>();

    public void registrar(ObservadorDeAcao observador) {
        this.inscritos.add(observador);
    }

    public void notificarTodos(Acao acao, Valor novoPreco) {
        for (ObservadorDeAcao observador : inscritos) {
            observador.precoAlterado(acao, novoPreco);
        }
    }
}