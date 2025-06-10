package services;

import model.EnderecoPet;
import model.Pet;
import model.PetGender;
import model.TipoPet;
import utils.Funcionalidades;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ListarPet {
    Scanner scanner = new Scanner(System.in);
    Path path = Paths.get("C:\\Users\\CAUA\\IdeaProjects\\desafioCadastro\\src\\petsCadastrados");
    Funcionalidades funcionalidades = new Funcionalidades();


    public ArrayList<Pet> adicionarPet() {
        File fileGetPath = new File(String.valueOf(path));
        File[] files = fileGetPath.listFiles();
        ArrayList<Pet> pets = null;

        if (files != null) {
            pets = new ArrayList<>();

            for (int i = 0; i < files.length; i++) {


                if (files[i].getName().endsWith(".txt")) {


                    try (FileReader fr = new FileReader(files[i])) {
                        BufferedReader bfr = new BufferedReader(fr);
                        String nome = bfr.readLine().split(" - ")[1];
                        String tipo = bfr.readLine().split(" - ")[1];
                        String sexo = bfr.readLine().split(" - ")[1];
                        String idade = bfr.readLine().split(" - ")[1];
                        String peso = bfr.readLine().split(" - ")[1];
                        String raca = bfr.readLine().split(" - ")[1];
                        String enderecoRua = bfr.readLine().split(" - ")[1];
                        String enderecoN = bfr.readLine().split(" - ")[1];
                        String enderecoCidade = bfr.readLine().split(" - ")[1];

                        Pet pet = new Pet();
                        EnderecoPet enderecoPet = new EnderecoPet();

                        pet.setNome(nome);
                        pet.setTipoPet(TipoPet.valueOf(tipo.toUpperCase()));
                        pet.setPetGender(PetGender.valueOf(sexo.toUpperCase()));
                        pet.setIdade(idade.split(" ")[0]);
                        pet.setPesoAproximado(peso.split("kg")[0].trim());
                        pet.setPetRace(raca);
                        enderecoPet.setRuaEncontrada(enderecoRua);
                        enderecoPet.setNumeroDaCasa(enderecoN);
                        enderecoPet.setCidadeEncontrada(enderecoCidade);

                        pets.add(pet);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return pets;
    }

    public void listarPets(){
        ArrayList<Pet> pet = adicionarPet();
        for (Pet pets : pet){
            System.out.println(pets);
        }
    }




    public int menuBusca(Scanner scanner) {
        int op1;
        int op2;
        System.out.println("Escolha quantos criterios você deseja para buscar o pet cadastrado.");
        int escolha = funcionalidades.lerNvalido(scanner);
        switch (escolha) {
            case 1:
                menuPetCadastrado();
                op1 = scanner.nextInt();
                break;
            case 2:
                menuPetCadastrado();
                op1 = scanner.nextInt();
                System.out.println("Escolha a outra opcao");
                menuPetCadastrado();
                op2 = scanner.nextInt();
        }

        return escolha;
    }

    public void menuPetCadastrado() {
        System.out.println("Escolha uma das opcções abaixo: ");
        System.out.println("1 - Nome");
        System.out.println("2 - Sexo");
        System.out.println("3 - idade");
        System.out.println("4 - Peso");
        System.out.println("5 - Raça");
        System.out.println("6 - Endereço");
        System.out.print("Digite o numero correspondente a opção desejada: ");


    }

    public void principal() {
        menuBusca(scanner);
    }
}
