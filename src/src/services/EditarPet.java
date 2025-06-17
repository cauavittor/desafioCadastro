package services;


import model.Pet;
import utils.Funcionalidades;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class EditarPet {
    Scanner scanner = new Scanner(System.in);
    Pet pet = new Pet();
    ListarPet listarPet = new ListarPet();
    Funcionalidades funcionalidades = new Funcionalidades();


    public void editarPet() {

        ArrayList<Pet> pets = listarPet.adicionarPet();
        listarPet.listarTodosOsPets();
        System.out.println("Escolha o numero do pet que você deseja editar: ");
        int numero = scanner.nextInt();

        if (numero < 1 || numero > pets.size()) {
            System.out.println("Digite um número válido.");
            editarPet();
            return;
        }


        Pet petEscolhido = pets.get(numero - 1);
        String nomeAntigo = petEscolhido.getNome();
        System.out.println("Pet escolhido: " + nomeAntigo);
        System.out.println("Você realmente deseja editar o pet " + nomeAntigo + "?");
        System.out.println("Digite 'sim' para prosseguir e 'não' para retornar.");
        String resposta = funcionalidades.lerRespostaValida(scanner);

        if (resposta.equals("nao") || resposta.equals("não")) {
            System.out.println("Selecione o número correspondente ao pet que você deseja editar: ");
            editarPet();
            return;
        }

        System.out.println("Prosseguindo com o processo de edição.");

        System.out.println("Digite um novo nome valido para a alteração, caso contrário, apenas aperte a tecla enter e o nome sera mantido.");
        scanner.nextLine();
        String nomeEditado = scanner.nextLine();
        scanner.nextLine();

        if (nomeEditado.isBlank() || nomeEditado.equals(" ")) {
            System.out.println("o nome antigo '" + petEscolhido.getNome() + "' será mantido!!");

        } else {
            petEscolhido.setNome(nomeEditado);
            System.out.println("Novo nome: " + petEscolhido.getNome());
        }

        System.out.println("Digite um novo endereço para o pet escolhido no formato (rua, numero e cidade) ou aperte a tecla 'Enter' para manter o mesmo endereço.");
        String novoEndereco = scanner.nextLine();

        if (novoEndereco.isBlank() || novoEndereco.contains(" ")) {
            System.out.println("O endereço: " + petEscolhido.getEnderecoPet().getRuaEncontrada() + ", " + petEscolhido.getEnderecoPet().getNumeroDaCasa() + " - " + petEscolhido.getEnderecoPet().getCidadeEncontrada() + " será mantido.");
        } else {
            String[] enderecos = novoEndereco.split(", ");
            petEscolhido.getEnderecoPet().setRuaEncontrada(enderecos[0]);
            petEscolhido.getEnderecoPet().setNumeroDaCasa(enderecos[1]);
            petEscolhido.getEnderecoPet().setCidadeEncontrada(enderecos[2]);
            for (int i = 0; i < enderecos.length; i++) {
                System.out.println("os endereços foram atualizados para ");
                System.out.print(enderecos[i]);
            }
        }

        System.out.println("Digite uma nova idade para o pet ou pressione a tecla 'Enter' para manter o antigo.");
        String idade = funcionalidades.idadeValida(scanner);

        if (idade.isBlank() || idade.contains(" ")) {
            System.out.println("A idade " + petEscolhido.getIdade() + " será mantida.");

        } else {
            petEscolhido.setIdade(idade);
            System.out.println("A idade do pet foi atualizada para: " + idade);
        }


        System.out.println("Digite um novo peso para o pet ou pressione a tecla 'Enter' para manter.");
        String novoPeso = funcionalidades.pesoValido(scanner);

        if (novoPeso.isBlank()) {
            System.out.println("O peso do pet " + petEscolhido.getPesoAproximado() + " será mantido.");
        } else {
            petEscolhido.setPesoAproximado(novoPeso);
            System.out.println("O peso do pet foi atualizado para: " + novoPeso);
        }

        System.out.println("Digite uma nova raça para o animal ou pressione a tecla 'Enter' para manter.");
        String novaRaca = funcionalidades.racaValida(scanner);

        if (novaRaca.isBlank()) {
            System.out.println("A raça do pet " + petEscolhido.getPetRace() + " será mantido.");
        } else {
            petEscolhido.setPetRace(novaRaca);
            System.out.println("A raça do pet foi atualizada para: " + novaRaca);
        }

        deletarArquivo(nomeAntigo);

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String format = dtf.format(localDateTime);
        String nomeFormatado = format + " - " + petEscolhido.getNome().toUpperCase() + ".txt";

        Path path = Paths.get("C:\\Users\\CAUA\\IdeaProjects\\desafioCadastro\\src\\petsCadastrados");
        File caminho = new File(String.valueOf(path.toAbsolutePath()));
        File diretorio = new File(caminho, nomeFormatado);

        try (BufferedWriter bff = new BufferedWriter(new FileWriter(diretorio))) {

            bff.write("1 - " + petEscolhido.getNome());
            bff.newLine();
            bff.write("2 - " + petEscolhido.getTipoPet());
            bff.newLine();
            bff.write("3 - " + petEscolhido.getPetGender());
            bff.newLine();
            bff.write("4 - " + petEscolhido.getEnderecoPet().getRuaEncontrada() + ", " + petEscolhido.getEnderecoPet().getNumeroDaCasa() + ", " + petEscolhido.getEnderecoPet().getCidadeEncontrada() + ".");
            bff.newLine();
            bff.write("5 - " + petEscolhido.getIdade() + " ano(s)");
            bff.newLine();
            bff.write("6 - " + petEscolhido.getPesoAproximado() + "kg");
            bff.newLine();
            bff.write("7 - " + petEscolhido.getPetRace());
            bff.flush();

        } catch (FileNotFoundException e) {
            System.out.println("Erro ao editar arquivo. ");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void deletarArquivo(String nome) {
        Path arquivoPets = Paths.get("C:\\Users\\CAUA\\IdeaProjects\\desafioCadastro\\src\\petsCadastrados");
        File file = new File(String.valueOf(arquivoPets.toAbsolutePath()));
        File[] files = file.listFiles();

        String nomeFormatado = nome.replaceAll("\\s+", "").toUpperCase();

        for (File file1 : files) {
            if (file1.getName().toUpperCase().contains(nomeFormatado + ".TXT")) {
                if (file1.delete()) {
                    System.out.println("Arquivo deletado com sucesso.");
                } else {
                    System.out.println("Falha ao deletar o arquivo: " + file1.getName());
                }
            }
            return;
        }


    }


}
