package main;

import menu.FileMenu;
import menu.Menu;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Menu menu = new Menu();
    menu.opcoesMenu();
        FileMenu fileMenu = new FileMenu();
        fileMenu.ArquivoCadastro();
    }
}