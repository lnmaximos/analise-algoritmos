package br.furb.analise.algoritmos.trabalho3.facade;

import br.furb.analise.algoritmos.trabalho3.colecao.ArCondicionados;
import br.furb.analise.algoritmos.trabalho3.colecao.Lampadas;
import br.furb.analise.algoritmos.trabalho3.colecao.Persianas;
import br.furb.analise.algoritmos.trabalho3.dominio.Temperatura;

public class CasaInteligente {
    private final Lampadas lampadas;
    private final Persianas persianas;
    private final ArCondicionados arCondicionados;

    public CasaInteligente(Lampadas lampadas, Persianas persianas, ArCondicionados arCondicionados) {
        this.lampadas = lampadas;
        this.persianas = persianas;
        this.arCondicionados = arCondicionados;
    }

    public void ativarModoSono() {
        lampadas.desligarTodas();
        arCondicionados.desligarTodos();
        persianas.fecharTodas();
    }

    public void ativarModoTrabalho() {
        lampadas.ligarTodas();
        arCondicionados.ligarTodos();
        arCondicionados.definirTemperaturaParaTodos(new Temperatura(25));
        persianas.abrirTodas();
    }
}