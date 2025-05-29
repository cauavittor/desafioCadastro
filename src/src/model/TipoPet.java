package model;

public enum TipoPet {

    GATO("Gato", 2) {
        String numeroEscolhido(Integer number) {
           String pet = String.valueOf(number);
            if (number == 2) {
            pet = TipoPet.GATO.nome;
            }
            return pet;
        }
    },
    CACHORRO("Cachorro", 1) {
        @Override
        String numeroEscolhido(Integer number) {
            String pet = String.valueOf(number);
            if (number == 1){
                pet = TipoPet.CACHORRO.nome;
            }
            return pet;
        }
    };

    private final String nome;
    private Integer number;

    TipoPet(final String nome, Integer number) {
        this.nome = nome;
        this.number = number;
    }

    abstract String numeroEscolhido(Integer number);

    @Override
    public String toString() {
        return nome;
    }
}
