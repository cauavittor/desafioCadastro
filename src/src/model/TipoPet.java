package model;

public enum TipoPet {

    GATO("gato"),
    CACHORRO("cachorro");

    private String nome;
    TipoPet (String nome){
        this.nome = nome;
    }

}
