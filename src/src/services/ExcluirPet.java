package services;

import model.Pet;
import utils.Funcionalidades;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formattable;
import java.util.List;
import java.util.Scanner;

public class ExcluirPet {

    public void excluirPet(){
        Funcionalidades funcionalidades = new Funcionalidades();
        ListarPet listarPet = new ListarPet();
        Scanner scanner = new Scanner (System.in);
        List<Pet> pets = listarPet.adicionarPet();
        Path path = Paths.get("C:\\Users\\CAUA\\IdeaProjects\\desafioCadastro\\src\\petsCadastrados");
        File file = new File(String.valueOf(path.toAbsolutePath()));
        File [] files = file.listFiles();

        listarPet.printarPets(pets);
        System.out.println("Escolha um número correspondente ao pet que você deseja excluir.");
        int escolha = scanner.nextInt();
        Pet petEscolhido = pets.get(escolha - 1);
        String nome = petEscolhido.getNome().replaceAll("\\s+", "").toUpperCase();

        System.out.println("Você realmente deseja excluir o pet: " + petEscolhido.getNome() + "?");
        System.out.println("Digite 'sim' ou 'não'");
        String resposta = funcionalidades.lerRespostaValida(scanner);

        if (!resposta.equals("sim")){
            System.out.println("Exclusão cancelada.");
            return;
        }
        if (escolha < 1 || escolha > pets.size()){
            System.out.println("Número inválido. Digite novamente.");
            excluirPet();
            return;

        }

        for (File arquivo : files){
            if (arquivo.getName().toUpperCase().endsWith("5-" + nome + ".TXT")){
                if (arquivo.delete()){
                    System.out.println("Pet deletado com sucesso.");
                } else {
                    System.out.println("Falha ao deletar pet.");
                }
            }
        }



    }

}
