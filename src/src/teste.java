import model.Pet;
import services.ListarPet;
import utils.Funcionalidades;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        ListarPet listarPet = new ListarPet();
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("C:\\Users\\CAUA\\IdeaProjects\\desafioCadastro\\src\\petsCadastrados");
        File file = new File(String.valueOf(path));
        File[] files = file.listFiles();

       listarPet.listarPets();
    }
}