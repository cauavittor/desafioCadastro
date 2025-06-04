package menu;

import model.Pet;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileMenu {
    Pet pet = new Pet();

    public void escreverArquivo() {
        Path paths = Paths.get("C:\\Users\\CAUA\\IdeaProjects\\desafioCadastro\\src\\src\\data\\formulario.txt");
        try (FileWriter fw = new FileWriter(String.valueOf(paths))) {
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet?\n3 - Qual o sexo do animal?\n4 - Qual endereço e bairro que ele foi encontrado?");
            bfw.write("\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet?");
            bfw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void lerArquivo() {
        Path path = Paths.get("C:\\Users\\CAUA\\IdeaProjects\\desafioCadastro\\src\\src\\data\\formulario.txt");
        try (FileReader fr = new FileReader(path.toString())) {
            BufferedReader bfr = new BufferedReader(fr);
            String linha;
            for (int i = 1; i < 7; i++) {

                String string = String.valueOf(i);
                while ((linha = bfr.readLine()) != string) {
                    System.out.println(linha);
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void leitorDeLinhas(int numero) {
        Path path = Paths.get("C:\\Users\\CAUA\\IdeaProjects\\desafioCadastro\\src\\src\\data\\formulario.txt");
        try (FileReader fr = new FileReader(String.valueOf(path))) {
            BufferedReader bfr = new BufferedReader(fr);
            String linha;
            int i = 1;
            while ((linha = bfr.readLine()) != null) {
                if (numero == i) {
                    System.out.println(linha);
                    return;

                }
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
