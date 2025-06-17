package menu;

import services.CadastrarPet;
import services.EditarPet;
import services.ExcluirPet;
import services.ListarPet;
import utils.Funcionalidades;

import javax.xml.stream.events.EntityReference;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    FileMenu fileMenu;
    public void opcoesMenu() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        CadastrarPet cadastrarPet = new CadastrarPet();
        ListarPet listarPet = new ListarPet();
        EditarPet editarPet = new EditarPet();
        ExcluirPet excluirPet = new ExcluirPet();
        Funcionalidades funcionalidades = new Funcionalidades();
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
                    System.out.println("opcão 1 - CADASTRAR PET");
                    cadastrarPet.CadastroDePets(scanner);
                    System.out.println("Você deseja realizar mais alguma alteração?");
                    String conf = funcionalidades.lerRespostaValida(scanner);
                    if (conf.equals("sim")){
                        opcoesMenu();
                        return;
                    }
                    break;
                case 2:
                    System.out.println("opcão 2");
                    editarPet.editarPet();
                    System.out.println("Você deseja realizar mais alguma alteração?");
                    String conf1 = funcionalidades.lerRespostaValida(scanner);
                    if (conf1.equals("sim")){
                        opcoesMenu();
                        return;
                    }
                    break;
                case 3:
                    System.out.println("opcão 3");
                    excluirPet.excluirPet();
                    System.out.println("Você deseja realizar mais alguma alteração?");
                    String conf2 = funcionalidades.lerRespostaValida(scanner);
                    if (conf2.equals("sim")){
                        opcoesMenu();
                        return;
                    }
                    break;
                case 4:
                    System.out.println("opcão 4");
                    listarPet.listarTodosOsPets();
                    System.out.println("Você deseja realizar mais alguma alteração?");
                    String conf3 = funcionalidades.lerRespostaValida(scanner);
                    if (conf3.equals("sim")){
                        opcoesMenu();
                        return;
                    }
                    break;
                case 5:
                    System.out.println("opcão 5");
                    listarPet.menuBusca(scanner);
                    System.out.println("Você deseja realizar mais alguma alteração?");
                    String conf4 = funcionalidades.lerRespostaValida(scanner);
                    if (conf4.equals("sim")){
                        opcoesMenu();
                        return;
                    }
                    break;
                case 6:
                    System.out.println("opcão 6");
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
