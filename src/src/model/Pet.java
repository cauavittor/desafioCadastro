package model;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pet {
    private String nome;
    private String pesoAproximado;
    private String idade;
    private String petRace;
    private EnderecoPet enderecoPet;
    private TipoPet tipoPet;
    private PetGender petGender;
    private static final String NAO_INFORMADO = "Não informado";


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
        if (nome == null || nome.isEmpty() || nome.contains(" ")) {
            this.nome = NAO_INFORMADO;
            return this.nome;
        }
        if (!nome.matches("^[A-Za-zÀ-ÿ\\s]+$")) {
            throw new IllegalArgumentException("Nome inválido, tente novamente.");
        }
        this.nome = nome.trim();
        return this.nome;
    }

    public String setPesoAproximado(String pesoAproximado) {
        if (pesoAproximado == null || pesoAproximado.isEmpty() || pesoAproximado.contains(" ")) {
            this.pesoAproximado = NAO_INFORMADO;
            return pesoAproximado;
        }
        float pesoFloat = Float.parseFloat(pesoAproximado);
        if (pesoFloat > 60 || pesoFloat < 0.5) {
            throw new IllegalArgumentException("Peso invalido tente novamente.");
        }
        this.pesoAproximado = pesoAproximado;
        return pesoAproximado;
    }

    public void setIdade(String idade) {
        if (idade == null || idade.trim().isEmpty() || idade.contains(" ")) {
            this.idade = NAO_INFORMADO;
            return;
        }
        try{
        int idadeInt = Integer.parseInt(idade);

        if (idadeInt > 20 || idadeInt < 0) {
            throw new IllegalArgumentException("idade invalida. Tente novamente.");
        }
        }catch (NumberFormatException e){
            this.idade = NAO_INFORMADO;
            return;
        }

        this.idade = idade;
    }

    public void setEnderecoPet(EnderecoPet enderecoPet) {
        if (enderecoPet.getNumeroDaCasa() == null) {
            enderecoPet.setNumeroDaCasa(NAO_INFORMADO);
        }
        this.enderecoPet = enderecoPet;
    }

    public void setTipoPet(TipoPet tipoPet) {
        this.tipoPet = tipoPet;
    }

    public void setPetGender(PetGender petGender) {
        this.petGender = petGender;
    }

    public String setPetRace(String petRace) {
        if (petRace == null || petRace.isEmpty() || petRace.contains(" ")) {
            this.petRace = NAO_INFORMADO;
            return this.petRace;
        }
        this.petRace = petRace;
        return petRace;
    }

    public void criarArquivo() {
        Path path = Paths.get("C:\\Users\\CAUA\\IdeaProjects\\desafioCadastro\\src\\petsCadastrados");

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String format = dtf.format(localDateTime);
        String nomeArquivo = format + "-" + (getNome() != null ? getNome().toUpperCase() : setNome(NAO_INFORMADO.replace(" ", "").toUpperCase().trim())) + ".txt";


        File pastaCadastro = new File(String.valueOf(path.toAbsolutePath()));
        File pastaPrincipal = new File(pastaCadastro, nomeArquivo);
        if (!pastaCadastro.exists()) {
            if (pastaCadastro.mkdir()) {
                System.out.println("O diretorio foi criado.");
            } else {
                System.out.println("O diretorio não foi criado.");
            }
        }


        try (
                FileWriter fw = new FileWriter(pastaPrincipal)) {
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write("1 - " + getNome());
            bf.newLine();
            bf.write("2 - " + getTipoPet());
            bf.newLine();
            bf.write("3 - " + getPetGender());
            bf.newLine();
            bf.write("4 - " + getEnderecoPet().getRuaEncontrada() + ", " + getEnderecoPet().getNumeroDaCasa() + ", " + getEnderecoPet().getCidadeEncontrada() + ".");
            bf.newLine();
            bf.write("5 - " + getIdade());
            bf.newLine();
            bf.write("6 - " + getPesoAproximado());
            bf.newLine();
            bf.write("7 - " + getPetRace());
            bf.flush();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }


}

