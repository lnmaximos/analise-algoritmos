public record Nome(String texto) {
    public Nome {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
    }
}