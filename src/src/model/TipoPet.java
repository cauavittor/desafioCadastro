package model;

public enum TipoPet {

    GATO("Gato"),
    CACHORRO("Cachorro");

    private final String nome;

    TipoPet(final String nome) {
        this.nome = nome;
    }

}
