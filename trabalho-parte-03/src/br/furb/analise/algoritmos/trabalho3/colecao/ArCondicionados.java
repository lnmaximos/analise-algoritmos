package br.furb.analise.algoritmos.trabalho3.colecao;

import br.furb.analise.algoritmos.trabalho3.contrato.ArCondicionado;
import br.furb.analise.algoritmos.trabalho3.dominio.Temperatura;

import java.util.ArrayList;
import java.util.List;

public class ArCondicionados {
    private final List<ArCondicionado> itens = new ArrayList<>();

    public void adicionar(ArCondicionado ar) {
        itens.add(ar);
    }

    public void ligarTodos() {
        itens.forEach(ArCondicionado::ligar);
    }

    public void desligarTodos() {
        itens.forEach(ArCondicionado::desligar);
    }

    public void definirTemperaturaParaTodos(Temperatura temperatura) {
        itens.forEach(ar -> ar.definirTemperatura(temperatura));
    }
}