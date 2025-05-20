package menu;

import java.util.Scanner;

public class Menu {
    public void opcoesMenu() throws IllegalArgumentException {
        Scanner scanner = new Scanner (System.in);
        System.out.println("\n1 - Cadastrar um novo pet");
        System.out.println("2 - Alterar os dados do pet cadastrado");
        System.out.println("3 - Deletar um pet cadastrado");
        System.out.println("4 - Listar todos os pets cadastrados");
        System.out.println("5 - Listar pets por algum critério (idade, nome, raça)");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();

        try {
            switch (opcao) {
                case 1:
                    System.out.println("opcao 1 - cadastrar pet");
                    break;
                case 2:
                    System.out.println("opcao 2");
                    break;
                case 3:
                    System.out.println("opcao 3");
                    break;
                case 4:
                    System.out.println("opcao 4");
                    break;
                case 5:
                    System.out.println("opcao 5");
                    break;
                case 6:
                    System.out.println("opcao 6");
                    break;
            }
            if (opcao < 1 || opcao > 6) {
                System.out.println("Opção inválida, tente novamente.");
                opcoesMenu();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }


}
