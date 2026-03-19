package br.furb.analise.algoritmos.trabalho3.colecao;

import br.furb.analise.algoritmos.trabalho3.contrato.Lampada;

import java.util.ArrayList;
import java.util.List;

public class Lampadas {
    private final List<Lampada> itens = new ArrayList<>();

    public void adicionar(Lampada lampada) {
        itens.add(lampada);
    }

    public void ligarTodas() {
        itens.forEach(Lampada::ligar);
    }

    public void desligarTodas() {
        itens.forEach(Lampada::desligar);
    }
}