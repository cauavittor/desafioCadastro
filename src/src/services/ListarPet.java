package services;

import model.EnderecoPet;
import model.Pet;
import model.PetGender;
import model.TipoPet;
import utils.Funcionalidades;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
                        String endereco = bfr.readLine().split(" - ")[1];
                        String idade = bfr.readLine().split(" - ")[1];
                        String peso = bfr.readLine().split(" - ")[1];
                        String raca = bfr.readLine().split(" - ")[1];


                        Pet pet = new Pet();
                        EnderecoPet enderecoPet = new EnderecoPet();

                        String[] enderecos = endereco.split(", ");
                        enderecoPet.setRuaEncontrada(enderecos[0].trim());
                        enderecoPet.setNumeroDaCasa(enderecos[1].trim());
                        enderecoPet.setCidadeEncontrada(enderecos[2].trim());

                        pet.setNome(nome);
                        pet.setTipoPet(TipoPet.valueOf(tipo.toUpperCase()));
                        pet.setPetGender(PetGender.valueOf(sexo.toUpperCase()));
                        pet.setIdade(idade.split(" ")[0]);
                        pet.setPesoAproximado(peso.split("kg")[0].trim());
                        pet.setPetRace(raca);




                        pet.setEnderecoPet(enderecoPet);
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


    public void menuBusca(Scanner scanner) {
        ArrayList<Pet> listaDePets = adicionarPet();

        List<Pet> listaFiltrada = null;
        System.out.println("Escolha quantos criterios você deseja para buscar o pet cadastrado.");

        menuPetCadastrado();
        int op1 = scanner.nextInt();

        System.out.println("Escolha a segunda opcao");
        menuPetCadastrado();
        int op2 = scanner.nextInt();
        if (op1 == op2) {
            System.out.println("As opções escolhidas não podem ser iguais.");
            menuPetCadastrado();
        }

        System.out.println("Escolha o tipo do pet: ");
        System.out.println("1 - Cachorro | 2 - Gato");
        int escolhaTipoPet = funcionalidades.lerNvalido(scanner);

        TipoPet tipoPet = null;
        if (escolhaTipoPet == 1) {
            tipoPet = TipoPet.CACHORRO;
        }

        if (escolhaTipoPet == 2) {
            tipoPet = TipoPet.GATO;
        }

        TipoPet finalTipoPet = tipoPet;
        listaFiltrada = listaDePets.stream().filter(pet -> pet.getTipoPet() == finalTipoPet).toList();

        if (op1 == 1 || op2 == 1) {
            //filtrar por nome
            System.out.print("Digite o nome e sobrenome do pet: ");
            String nomeEscolhido = scanner.nextLine().toLowerCase();

            while (nomeEscolhido.isBlank()) {
                System.out.println("Nome inválido. Tente novamente.");

                if (!nomeEscolhido.isBlank()) {
                    listaFiltrada = filtrarPorNome(nomeEscolhido, listaFiltrada);
                }
            }


        }
        if (op1 == 2 || op2 == 2) {
            //sexo
            System.out.println("Escolha o gênero do pet desejado.");
            System.out.println("1 - Macho || 2 - Fêmea");
            int escolha = funcionalidades.lerNvalido(scanner);
            PetGender generoPet = null;
            if (escolha == 1) {
                generoPet = PetGender.MACHO;

            } else {
                generoPet = PetGender.FEMEA;
            }

            PetGender finalGeneroPet = generoPet;
            listaFiltrada = listaFiltrada.stream().filter(pet -> pet.getPetGender() == finalGeneroPet).toList();

        }
        if (op1 == 3 || op2 == 3) {
            //idade
            System.out.print("Digite a idade para buscar o pet desejado: ");
            int idade = scanner.nextInt();
            listaFiltrada = filtrarPorIdade(idade, listaFiltrada);

        }
        if (op1 == 4 || op2 == 4) {
            //peso
            System.out.println("Digite o peso aproximado do pet.");
            System.out.println("OBS: O PESO DO PET NÃO PODE SER MAIOR QUE 60KG OU MENOR 0,5KG");
            String peso = funcionalidades.pesoValido(scanner);
            float pesoFloat = Float.parseFloat(peso);
            listaFiltrada = filtrarPorPeso(pesoFloat, listaFiltrada);
        }
        if (op1 == 5 || op2 == 5) {
            //raca
            System.out.print("Digite a raça do pet desejado: ");
            String racaPet = funcionalidades.racaValida(scanner);
            listaFiltrada = filtrarPorRaca(racaPet, listaFiltrada);

        }
        if (op1 == 6 || op2 == 6) {
            //endereco
            System.out.print("Digite o endereço do pet desejado para realizar a busca: ");
            String endereco = funcionalidades.ruaInvlaida(scanner);
            listaFiltrada = filtrarEndereco(endereco, listaFiltrada);


        }
        printarPets(listaFiltrada);

    }

    private List<Pet> filtrarPorNome(String nomeEscolhido, List<Pet> nomeFiltrado) {
        List<Pet> listaFiltradaNome = nomeFiltrado.stream().filter(pet -> pet.getNome().toLowerCase().contains(nomeEscolhido)).toList();
        return listaFiltradaNome;
    }

    private List<Pet> filtrarPorIdade(int idade, List<Pet> idadeFiltrada) {
        List<Pet> listaFiltradaPorIdade = idadeFiltrada.stream().filter(pet -> {
            try {
                return Integer.parseInt(pet.getIdade()) == idade;
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }

        }).toList();


        return listaFiltradaPorIdade;
    }


    private List<Pet> filtrarPorPeso(Float peso, List<Pet> pesoFiltrado) {
        List<Pet> listraFiltradaPorPeso = pesoFiltrado.stream().filter(pet -> {
                    try {
                        return Float.parseFloat(pet.getPesoAproximado()) == peso;
                    } catch (NumberFormatException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).toList();
        return listraFiltradaPorPeso;
    }

    private List<Pet> filtrarPorRaca(String racaPet, List<Pet> racaFiltrada) {
        List<Pet> listaFiltradaPorRaca = racaFiltrada.stream().filter(pet -> pet.getPetRace().contains(racaPet)).toList();
        return listaFiltradaPorRaca;

    }

    private List<Pet> filtrarEndereco(String endereco, List<Pet> enderecoFiltrado) {
        return enderecoFiltrado.stream()
                .filter(pet -> String.valueOf(pet.getEnderecoPet().getRuaEncontrada()).contains(endereco) ||
                        String.valueOf(pet.getEnderecoPet().getCidadeEncontrada()).contains(endereco))
                .toList();
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

    public void printarPets(List<Pet> petsArmazenados) {
        if (petsArmazenados == null) {
            petsArmazenados = adicionarPet();
        }
        int contador = 0;
        for (Pet pet : petsArmazenados) {
            System.out.println(String.format("%d - %s - %s - %s - %s, %s - %s - %s anos - %s kg - %s",
                    contador += 1,
                    pet.getNome(),
                    pet.getTipoPet(),
                    pet.getPetGender(),
                    pet.getEnderecoPet().getRuaEncontrada(),
                    pet.getEnderecoPet().getNumeroDaCasa(),
                    pet.getEnderecoPet().getCidadeEncontrada(),
                    pet.getIdade(),
                    pet.getPesoAproximado(),
                    pet.getPetRace()

            ));
        }
    }
        public void listarTodosOsPets(){
        printarPets(null);
        }

}
