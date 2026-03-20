package br.furb.analise.algoritmos.trabalho3.adaptador;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import br.furb.analise.algoritmos.trabalho3.contrato.ArCondicionado;
import br.furb.analise.algoritmos.trabalho3.dominio.Temperatura;

public class ArCondicionadoVentoBaumnAdapter implements ArCondicionado {
    private final ArCondicionadoVentoBaumn ar;

    public ArCondicionadoVentoBaumnAdapter(ArCondicionadoVentoBaumn ar) {
        this.ar = ar;
    }

    @Override
    public void ligar() {
        ar.ligar();
    }

    @Override
    public void desligar() {
        ar.desligar();
    }

    @Override
    public void aumentarTemperatura() {
        Temperatura atual = getTemperatura();
        ar.definirTemperatura(atual.aumentar().valor());
    }

    @Override
    public void diminuirTemperatura() {
        Temperatura atual = getTemperatura();
        ar.definirTemperatura(atual.diminuir().valor());
    }

    @Override
    public void definirTemperatura(Temperatura temperatura) {
        ar.definirTemperatura(temperatura.valor());
    }

    @Override
    public Temperatura getTemperatura() {
        return new Temperatura(ar.getTemperatura());
    }
}