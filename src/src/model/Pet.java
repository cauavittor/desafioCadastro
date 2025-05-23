package model;


public class Pet {
    private String nome;
    private String pesoAproximado;
    private String idade;
    private String petRace;
    private EnderecoPet enderecoPet;
    private TipoPet tipoPet;
    private PetGender petGender;
    private final String NAO_INFORMADO = "NAO_INFORMADO";


    public String getNome() {
        return nome;
    }

    public String getPesoAproximado() {
        return pesoAproximado;
    }

    public String getIdade() {
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

    public String getPetRace() {
        return petRace;
    }

    public String setNome(String nome) {
        if (nome.matches("^[A-Za-zÀ-ÿ]")) {
            throw new IllegalArgumentException("Nome inválido, tente novamente.");
        }
        if (nome == null) {
            this.nome = "NAO_INFORMADO";
            return nome;
        }
        this.nome = nome.trim();
        return nome;
    }

    public Float setPesoAproximado(Float pesoAproximado) {
        if (pesoAproximado > 60 || pesoAproximado < 0.5) {
            throw new IllegalArgumentException("Peso invalido tente novamente.");
        }
        if (pesoAproximado == null || pesoAproximado.equals(" ")) {
            this.pesoAproximado = NAO_INFORMADO;
        }
        return pesoAproximado;
    }

    public String setIdade(String idade) {
        if (Integer.parseInt(idade) > 20 || Integer.parseInt(idade) < 0) {
            throw new IllegalArgumentException("idade invalda. Tente novamnte.");
        }
        if (Integer.parseInt(idade) < 1) {
            this.idade = "0." + idade;
        }
        if (idade == null) {
            this.idade = NAO_INFORMADO;
        }
        if (idade.matches("^[a-zA-ZÃ-ÿ]")) {
            throw new IllegalArgumentException("A idade do pet so pode ser definida por números.");
        }
        return idade;
    }

    public void setEnderecoPet(EnderecoPet enderecoPet) {
        if (enderecoPet.getNumeroDaCasa() == null) {
            enderecoPet.setNumeroDaCasa(NAO_INFORMADO);
        }
        this.enderecoPet = enderecoPet;
    }

    public void setTipoPet(TipoPet tipoPet) {
        this.tipoPet = tipoPet;


        public void setPetGender (PetGender petGender){
            this.petGender = petGender;
        }

        public void setPetRace (String petRace){
            if (petRace == null) {
                this.petRace = NAO_INFORMADO;
            }
            if (!petRace.matches("^[a-zA-ZÃ-ÿ]")) {
                throw new IllegalArgumentException("A raça do pet nao pode conter numeros, espaços ou caracteres especiais.");
            }
            this.petRace = petRace;
        }
    }

