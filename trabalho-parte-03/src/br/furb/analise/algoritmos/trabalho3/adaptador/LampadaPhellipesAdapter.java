package br.furb.analise.algoritmos.trabalho3.adaptador;

import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.trabalho3.contrato.Lampada;

public class LampadaPhellipesAdapter implements Lampada {
    private final LampadaPhellipes lampada;

    public LampadaPhellipesAdapter(LampadaPhellipes lampada) {
        this.lampada = lampada;
    }

    @Override
    public void ligar() {
        lampada.setIntensidade(100);
    }

    @Override
    public void desligar() {
        lampada.setIntensidade(0);
    }
}