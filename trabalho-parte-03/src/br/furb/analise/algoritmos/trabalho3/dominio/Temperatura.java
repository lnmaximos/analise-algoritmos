package br.furb.analise.algoritmos.trabalho3.dominio;

public record Temperatura(int valor) {
    public Temperatura {
        if (valor < 16 || valor > 30) {
            throw new IllegalArgumentException("Temperatura fora do limite permitido (16 a 30).");
        }
    }

    public Temperatura aumentar() {
        return new Temperatura(this.valor + 1);
    }

    public Temperatura diminuir() {
        return new Temperatura(this.valor - 1);
    }

    public boolean isMaiorQue(Temperatura outra) {
        return this.valor > outra.valor;
    }

    public boolean isMenorQue(Temperatura outra) {
        return this.valor < outra.valor;
    }

    public boolean isIgual(Temperatura outra) {
        return this.valor == outra.valor;
    }
}