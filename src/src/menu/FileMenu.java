package menu;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileMenu {

    public void escreverArquivo() {
        Path paths = Paths.get("C:\\Users\\CAUA\\IdeaProjects\\desafioCadastro\\src\\src\\data\\formulario.txt");
        try (FileWriter fw = new FileWriter(String.valueOf(paths))) {
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet (Cachorro/Gato)?\n3 - Qual o sexo do animal?\n4 - Qual endereço e bairro que ele foi encontrado?");
            bfw.write("\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet?");
            bfw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void lerArquivo(){
        Path path = Paths.get("C:\\Users\\CAUA\\IdeaProjects\\desafioCadastro\\src\\src\\data\\formulario.txt");
        try(FileReader fr = new FileReader(path.toString())){
            BufferedReader bfr = new BufferedReader(fr);
            bfr.readLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
