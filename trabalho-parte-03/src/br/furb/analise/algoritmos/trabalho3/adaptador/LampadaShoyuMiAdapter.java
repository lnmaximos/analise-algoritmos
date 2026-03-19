package br.furb.analise.algoritmos.trabalho3.adaptador;

import br.furb.analise.algoritmos.LampadaShoyuMi;
import br.furb.analise.algoritmos.trabalho3.contrato.Lampada;

public class LampadaShoyuMiAdapter implements Lampada {
    private final LampadaShoyuMi lampada;

    public LampadaShoyuMiAdapter(LampadaShoyuMi lampada) {
        this.lampada = lampada;
    }

    @Override
    public void ligar() {
        lampada.ligar();
    }

    @Override
    public void desligar() {
        lampada.desligar();
    }
}