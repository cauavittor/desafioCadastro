package model;

public enum TipoPet {

    GATO("Gato", 2) {
    },
    CACHORRO("Cachorro", 1) {
    };

    private final String nome;
    private Integer number;

    TipoPet(final String nome, Integer number) {
        this.nome = nome;
        this.number = number;
    }

    public String getNome() {
        return nome;
    }


    @Override
    public String toString() {
        return nome;
    }
}
