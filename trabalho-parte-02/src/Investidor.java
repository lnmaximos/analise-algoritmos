import java.util.ArrayList;
import java.util.List;

public class Investidor implements ObservadorDeAcao {
    private final Nome nome;
    private final List<String> historicoNotificacoes = new ArrayList<>();

    public Investidor(Nome nome) {
        this.nome = nome;
    }

    @Override
    public void precoAlterado(Acao acao, Valor novoPreco) {
        String mensagem = "Investidor " + nome.texto() + " notificado: Ação " + acao.nome().texto() + " atualizou para " + novoPreco.formatado();
        historicoNotificacoes.add(mensagem);
    }

    public void enviarOrdem(Acao acao, TipoOrdem tipo, Valor valor) {
        acao.registrarOrdem(new Ordem(this, tipo, valor));
    }

    // Método de apoio para os testes unitários
    public boolean recebeuNotificacaoContendo(String textoEsperado) {
        for (String notificacao : historicoNotificacoes) {
            if (notificacao.contains(textoEsperado)) {
                return true;
            }
        }
        return false;
    }
}