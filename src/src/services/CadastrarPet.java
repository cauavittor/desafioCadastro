package services;

import menu.FileMenu;
import menu.Menu;
import model.EnderecoPet;
import model.Pet;
import model.PetGender;
import model.TipoPet;
import utils.Funcionalidades;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CadastrarPet {
    private Pet pet = new Pet();
    private EnderecoPet enderecoPet = new EnderecoPet();
    private TipoPet tipoPet;
    private FileMenu fileMenu = new FileMenu();
    Funcionalidades funcionalidades = new Funcionalidades();

    public void CadastroDePets(Scanner scanner){

        fileMenu.leitorDeLinhas(1);
        scanner.nextLine();
        pet.setNome(scanner.nextLine());

        fileMenu.leitorDeLinhas(2);
        System.out.println("1 = Cachorro 2 = Gato");
        pet.escolhaTipoPet(funcionalidades.lerNvalido(scanner));

        fileMenu.leitorDeLinhas(3);
        System.out.println("1 = Macho 2 = Femea");
        pet.escolhaGenero(funcionalidades.lerNvalido(scanner));


        fileMenu.leitorDeLinhas(4);
        scanner.nextLine();
        System.out.println("Rua: ");
        enderecoPet.setRuaEncontrada(funcionalidades.ruaInvlaida(scanner));

        System.out.println("Cidade onde o pet foi encontrado: ");
        enderecoPet.setCidadeEncontrada(funcionalidades.cidadeValida(scanner));

        System.out.println("numero da casa: ");
        enderecoPet.setNumeroDaCasa(funcionalidades.validarNumeroCasa(scanner));

        pet.setEnderecoPet(enderecoPet);

        fileMenu.leitorDeLinhas(5);
        pet.setIdade(funcionalidades.idadeValida(scanner));

        fileMenu.leitorDeLinhas(6);
        pet.setPesoAproximado(funcionalidades.pesoValido(scanner));

        fileMenu.leitorDeLinhas(7);
        pet.setPetRace(funcionalidades.racaValida(scanner));

        System.out.println("Cadastrando pet...");
        System.out.println("Pet cadastrado.");
        pet.criarArquivo();
    }


}

