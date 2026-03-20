package br.furb.analise.algoritmos.trabalho3.contrato;

import br.furb.analise.algoritmos.trabalho3.dominio.Temperatura;

public interface ArCondicionado {
    void ligar();
    void desligar();
    void aumentarTemperatura();
    void diminuirTemperatura();
    void definirTemperatura(Temperatura temperatura);
    Temperatura getTemperatura();
}