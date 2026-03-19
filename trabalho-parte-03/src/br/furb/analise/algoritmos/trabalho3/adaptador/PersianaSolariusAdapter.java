package br.furb.analise.algoritmos.trabalho3.adaptador;

import br.furb.analise.algoritmos.PersianaSolarius;
import br.furb.analise.algoritmos.trabalho3.contrato.Persiana;

public class PersianaSolariusAdapter implements Persiana {
    private final PersianaSolarius persiana;

    public PersianaSolariusAdapter(PersianaSolarius persiana) {
        this.persiana = persiana;
    }

    @Override
    public void abrir() {
        persiana.subirPersiana();
    }

    @Override
    public void fechar() {
        persiana.descerPersiana();
    }
}