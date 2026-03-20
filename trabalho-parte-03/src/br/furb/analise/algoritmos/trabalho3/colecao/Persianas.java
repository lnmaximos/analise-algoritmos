package br.furb.analise.algoritmos.trabalho3.colecao;

import br.furb.analise.algoritmos.trabalho3.contrato.Persiana;

import java.util.ArrayList;
import java.util.List;

public class Persianas {
    private final List<Persiana> itens = new ArrayList<>();

    public void adicionar(Persiana persiana) {
        itens.add(persiana);
    }

    public void abrirTodas() {
        itens.forEach(Persiana::abrir);
    }

    public void fecharTodas() {
        itens.forEach(Persiana::fechar);
    }
}