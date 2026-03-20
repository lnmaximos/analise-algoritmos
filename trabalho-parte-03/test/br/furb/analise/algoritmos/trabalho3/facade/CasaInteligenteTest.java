package br.furb.analise.algoritmos.trabalho3.facade;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import br.furb.analise.algoritmos.PersianaSolarius;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import br.furb.analise.algoritmos.trabalho3.dominio.Temperatura;
import br.furb.analise.algoritmos.trabalho3.colecao.Lampadas;
import br.furb.analise.algoritmos.trabalho3.colecao.Persianas;
import br.furb.analise.algoritmos.trabalho3.colecao.ArCondicionados;
import br.furb.analise.algoritmos.trabalho3.adaptador.*;

public class CasaInteligenteTest {

    @Test
    public void deveAtivarModoTrabalhoCorretamente() {
        Lampadas lampadas = new Lampadas();
        Persianas persianas = new Persianas();
        ArCondicionados ares = new ArCondicionados();
        
        var lampadaReal = new LampadaShoyuMi();
        var persianaReal = new PersianaSolarius();
        var arReal = new ArCondicionadoVentoBaumn();

        lampadas.adicionar(new LampadaShoyuMiAdapter(lampadaReal));
        persianas.adicionar(new PersianaSolariusAdapter(persianaReal));
        ares.adicionar(new ArCondicionadoVentoBaumnAdapter(arReal));

        CasaInteligente casa = new CasaInteligente(lampadas, persianas, ares);

        casa.ativarModoTrabalho();

        assertTrue(lampadaReal.estaLigada());
        assertTrue(persianaReal.estaAberta());
        assertEquals(25, arReal.getTemperatura());
    }

    @Test
    public void deveAtivarModoSonoCorretamente() {
        Lampadas lampadas = new Lampadas();
        Persianas persianas = new Persianas();
        ArCondicionados ares = new ArCondicionados();

        var lampadaReal = new LampadaShoyuMi();
        lampadaReal.ligar();

        var persianaReal = new PersianaSolarius();
        try { persianaReal.subirPersiana(); } catch (Exception e) {}

        var arReal = new ArCondicionadoGellaKaza();
        arReal.ativar();

        lampadas.adicionar(new LampadaShoyuMiAdapter(lampadaReal));
        persianas.adicionar(new PersianaSolariusAdapter(persianaReal));
        ares.adicionar(new ArCondicionadoGellaKazaAdapter(arReal));

        CasaInteligente casa = new CasaInteligente(lampadas, persianas, ares);

        casa.ativarModoSono();

        assertFalse(lampadaReal.estaLigada());
        assertFalse(persianaReal.estaAberta());
        assertFalse(arReal.estaLigado());
    }

    @Test
    public void gellaKazaAdapterDeveAtingirTemperaturaAlvoViaLacoDeRepeticao() {
        var gellaKazaReal = new ArCondicionadoGellaKaza();
        gellaKazaReal.ativar();

        ArCondicionadoGellaKazaAdapter adapter = new ArCondicionadoGellaKazaAdapter(gellaKazaReal);

        adapter.definirTemperatura(new Temperatura(25));

        assertEquals(25, adapter.getTemperatura().valor());
        assertEquals(25, gellaKazaReal.getTemperatura());
    }
}