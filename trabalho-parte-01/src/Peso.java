public class Peso {
    private final int gramas;

    public Peso(int gramas) {
        if (gramas < 0) {
            throw new IllegalArgumentException("O peso não pode ser negativo.");
        }
        this.gramas = gramas;
    }

    public Peso somar(Peso outro) {
        return new Peso(this.gramas + outro.gramas);
    }

    public boolean isMenorOuIgual(int limiteEmGramas) {
        return this.gramas <= limiteEmGramas;
    }

    public boolean isMaiorQue(int limiteEmGramas) {
        return this.gramas > limiteEmGramas;
    }

    public int contarFracoesDe100gExcedentes(int limiteEmGramas) {
        if (!isMaiorQue(limiteEmGramas)) {
            return 0;
        }
        return (int) Math.ceil((this.gramas - limiteEmGramas) / 100.0);
    }
}