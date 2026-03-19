import java.util.Optional;

public class Acao {
    private final Nome nome;
    private Valor precoAtual;
    private final LivroDeOfertas livroDeOfertas = new LivroDeOfertas();
    private final Observadores observadores = new Observadores();

    public Acao(Nome nome, Valor precoInicial) {
        this.nome = nome;
        this.precoAtual = precoInicial;
    }

    public void registrarInteresse(ObservadorDeAcao observador) {
        observadores.registrar(observador);
    }

    public void registrarOrdem(Ordem ordem) {
        Optional<Valor> possivelAcordo = livroDeOfertas.registrarEBuscarAcordo(ordem);
        possivelAcordo.ifPresent(this::atualizarPreco);
    }

    private void atualizarPreco(Valor novoPreco) {
        this.precoAtual = novoPreco;
        observadores.notificarTodos(this, novoPreco);
    }

    public Nome nome() {
        return this.nome;
    }

    public Valor precoAtual() {
        return this.precoAtual;
    }
}