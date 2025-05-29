package services;

import model.EnderecoPet;
import model.Pet;
import model.PetGender;
import model.TipoPet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CadastrarPet {
    private Pet pet = new Pet();
    private EnderecoPet enderecoPet = new EnderecoPet();

    public void CadastroDePets(){

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMDD'T'HH:mm");
        String format = dtf.format(localDateTime);

        pet.setNome("Filisteu");
        pet.setEnderecoPet(enderecoPet);
        pet.setTipoPet(TipoPet.GATO);
        pet.setPetGender(PetGender.FEMEA);
        enderecoPet.setRuaEncontrada("Corbiniano Freire");
        enderecoPet.setNumeroDaCasa("171");
        enderecoPet.setCidadeEncontrada("Itabuna");
        pet.setIdade("4");
        pet.setPesoAproximado("48");
        pet.setPetRace("siames");
        pet.criarArquivo();

        Pet pet1 = new Pet();
        EnderecoPet enderecoPet1 = new EnderecoPet();


        pet1.setEnderecoPet(enderecoPet1);
        enderecoPet1.setCidadeEncontrada("Itabuna");
        enderecoPet1.setRuaEncontrada("Corbiniano");
        pet1.criarArquivo();

    }


}

