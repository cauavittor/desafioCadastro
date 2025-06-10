package utils;

import model.Pet;

import java.util.Scanner;

public class Funcionalidades {
    Pet pet = new Pet();
    public final String NAO_INFORMADO = "Não informado";

    public int lerNvalido(Scanner scanner) {
        int numero = scanner.nextInt();
        if (numero < 1 || numero > 2) {
            System.out.println("Numero invalido. Tente novamente.");
            System.out.println("Digite um número válido entre 1 e 2.");
            return lerNvalido(scanner);
        }
        return numero;
    }

    public String ruaInvlaida(Scanner scanner) {

        String rua = scanner.nextLine();

        if (rua == null || rua.trim().isEmpty()) {
            System.out.println("A rua em que o pet foi encontrado deve ser informado. Digite novamente");
            return ruaInvlaida(scanner);
        }
        return rua;
    }

    public String cidadeValida(Scanner scanner) {
        String cidade = scanner.nextLine();
        if (cidade == null || cidade.isEmpty()) {
            System.out.println("A cidade em que o pet foi encontrado deve ser informado. Tente novamente");
            return cidadeValida(scanner);
        }

        return cidade;
    }

    public String validarNumeroCasa(Scanner scanner) {
        String numeroCasa = scanner.nextLine();
        if (numeroCasa == null || numeroCasa.contains(" ") || numeroCasa.trim().isEmpty()) {
            numeroCasa = NAO_INFORMADO;
            return numeroCasa;
        }
        if (!numeroCasa.matches("^[0-9]$")) {
            numeroCasa = NAO_INFORMADO;
            return numeroCasa;
        }

        return numeroCasa;
    }

    public String idadeValida(Scanner scanner) {
        String idade = scanner.nextLine();
        if (idade == null || idade.contains(" ") || idade.trim().isEmpty()) {
            idade = NAO_INFORMADO;
            return idade;
        }
        int idadeInt = Integer.parseInt(idade);
        if (idadeInt < 0 || idadeInt > 20) {
            System.out.println("Idade inválida. O pet não pode ter idade negativa ou maior que 20");
            return idadeValida(scanner);
        }
        return idade;
    }

    public String pesoValido(Scanner scanner){
        String peso = scanner.nextLine();
        Float pesoFloat = Float.parseFloat(peso);
        if (pesoFloat < 0.5 || pesoFloat > 60){
            System.out.println("Peso inválido.");
            System.out.println("O peso do pet não pode ser definido por numeros negativos ou maiores que 60 kg");
            return pesoValido(scanner);
        }
        String peso1 = String.valueOf(pesoFloat);
        return peso1;
    }

    public String racaValida(Scanner scanner){
        String race = scanner.nextLine();
        if (race.matches(".*\\d.*") || race.contains(" ") || race.trim().isEmpty()){
            System.out.println("A raça do pet não pode conter numeros ou espaços.");
            System.out.println("Digte novamente.");
            return racaValida(scanner);
        }
        return race;
    }

}

