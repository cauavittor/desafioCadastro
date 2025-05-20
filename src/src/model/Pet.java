package model;

public class Pet {
    private String nome;
    private Float pesoAproximado;
    private Float idade;
    private EnderecoPet enderecoPet;
    private TipoPet tipoPet;
    private PetGender petGender;
    private final String NAO_INFORMADO = "NAO_INFORMADO";


    public Pet(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Float getPesoAproximado() {
        return pesoAproximado;
    }

    public Float getIdade() {
        return idade;
    }

    public EnderecoPet getEnderecoPet() {
        return enderecoPet;
    }

    public TipoPet getTipoPet() {
        return tipoPet;
    }

    public PetGender getPetGender() {
        return petGender;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPesoAproximado(Float pesoAproximado) {
        this.pesoAproximado = pesoAproximado;
        if (pesoAproximado > 60 || pesoAproximado < 0.5) {
            throw new IllegalArgumentException("Peso invalido tente novamente.");
        }
    }

    public void setIdade(Float idade) {
        this.idade = idade;
        if (idade > 20 || idade < 0) {
            throw new IllegalArgumentException("idade invalda. Tente novamnte.");
        }
        if (idade < 1) {
            float meses = idade / 12;
        }
    }

    public void setEnderecoPet(EnderecoPet enderecoPet) {
        this.enderecoPet = enderecoPet;
    }

    public void setTipoPet(TipoPet tipoPet) {

        this.tipoPet = tipoPet;
    }

    public void setPetGender(PetGender petGender) {
        this.petGender = petGender;
    }
}
