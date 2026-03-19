package br.furb.analise.algoritmos.trabalho3.adaptador;

import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.trabalho3.contrato.Persiana;

public class PersianaNatLightAdapter implements Persiana {
    private final PersianaNatLight persiana;

    public PersianaNatLightAdapter(PersianaNatLight persiana) {
        this.persiana = persiana;
    }

    @Override
    public void abrir() {
        try {
            if (!persiana.estaPalhetaAberta()) {
                persiana.abrirPalheta();
            }
            persiana.subirPalheta();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao tentar abrir a persiana NatLight:" + e.getMessage(), e);
        }
    }

    @Override
    public void fechar() {
        try {
            if (persiana.estaPalhetaErguida()) {
                persiana.descerPalheta();
            }
            persiana.fecharPalheta();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao tentar fechar a persiana NatLight" + e.getMessage(), e);
        }
    }
}