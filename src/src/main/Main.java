package main;

import menu.FileMenu;
import menu.Menu;
import model.EnderecoPet;
import model.Pet;
import model.PetGender;
import model.TipoPet;
import services.CadastrarPet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Menu menu = new Menu();

        FileMenu fileMenu = new FileMenu();


        Pet pet = new Pet();
        EnderecoPet enderecoPet = new EnderecoPet();
        CadastrarPet cd = new CadastrarPet();
        cd.CadastroDePets();



    }
}