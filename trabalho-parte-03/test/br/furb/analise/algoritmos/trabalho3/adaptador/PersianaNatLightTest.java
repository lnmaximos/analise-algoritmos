package br.furb.analise.algoritmos.trabalho3.adaptador;

import br.furb.analise.algoritmos.PersianaNatLight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersianaNatLightTest {

    @Test
    public void deveAbrirPalhetasAntesDeSubirPersianaNatLight() {
        var persianaReal = new PersianaNatLight();

        var adapter = new PersianaNatLightAdapter(persianaReal);

        adapter.abrir();

        Assertions.assertTrue(persianaReal.estaPalhetaAberta());
        Assertions.assertTrue(persianaReal.estaPalhetaErguida());
    }
}