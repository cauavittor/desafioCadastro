package menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileMenu {
    public void ArquivoCadastro() {
        try (FileWriter fw = new FileWriter("C:\\Users\\CAUA\\IdeaProjects\\desafioCadastro\\src\\src\\data\\formulario.txt")) {
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet (Cachorro/Gato)?\n3 - Qual o sexo do animal?\n4 - Qual endereço e bairro que ele foi encontrado?");
            bfw.write("\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet?");
            bfw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
public static void main(String[] args){
}

}
