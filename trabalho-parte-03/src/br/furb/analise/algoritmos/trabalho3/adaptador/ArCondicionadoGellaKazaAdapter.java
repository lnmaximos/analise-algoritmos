package br.furb.analise.algoritmos.trabalho3.adaptador;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.trabalho3.contrato.ArCondicionado;
import br.furb.analise.algoritmos.trabalho3.dominio.Temperatura;

public class ArCondicionadoGellaKazaAdapter implements ArCondicionado {
    private final ArCondicionadoGellaKaza ar;

    public ArCondicionadoGellaKazaAdapter(ArCondicionadoGellaKaza ar) {
        this.ar = ar;
    }

    @Override
    public void ligar() {
        ar.ativar();
    }

    @Override
    public void desligar() {
        ar.desativar();
    }

    @Override
    public void aumentarTemperatura() {
        ar.aumentarTemperatura();
    }

    @Override
    public void diminuirTemperatura() {
        ar.diminuirTemperatura();
    }

    @Override
    public void definirTemperatura(Temperatura temperaturaAlvo) {
        Temperatura atual = getTemperatura();

        while (atual.isMenorQue(temperaturaAlvo)) {
            aumentarTemperatura();
            atual = getTemperatura();
        }

        while (atual.isMaiorQue(temperaturaAlvo)) {
            diminuirTemperatura();
            atual = getTemperatura();
        }
    }

    @Override
    public Temperatura getTemperatura() {
        return new Temperatura(ar.getTemperatura());
    }
}