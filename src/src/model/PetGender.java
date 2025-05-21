package model;

public enum PetGender {
    MACHO("Macho"),
    FEMEA("Femea");
    private String descricao;

    PetGender(String descricao) {
        this.descricao = descricao;
    }


    public String getDescricao() {
        return descricao;
    }
}
