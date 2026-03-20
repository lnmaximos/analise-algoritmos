package br.furb.analise.algoritmos.trabalho3.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemperaturaTest {

    @Test
    public void naoDevePermitirTemperaturaAbaixoDe16Graus() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Temperatura(15);
        });
    }

    @Test
    public void naoDevePermitirTemperaturaAcimaDe30Graus() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Temperatura(31);
        });
    }
}