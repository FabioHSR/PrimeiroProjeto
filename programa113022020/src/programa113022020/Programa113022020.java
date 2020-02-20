/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa113022020;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author 082170007
 */
public class Programa113022020 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a opção desejada e de Enter:");
        System.out.println("1 - Novo tanque");
        System.out.println("2 - Listar tanques");
        System.out.println("3 - Salvar tanques em txt");
        System.out.println("4 - Carregar tanques de um txt");
        boolean inputValido = false;
        int escolha = 0;
        while (!inputValido) {
            String input = sc.nextLine();
            boolean parsable = Metodos.isParsableInt(input);
            if (parsable) {
                escolha = Integer.parseInt(input);
                if (escolha >= 1 && escolha <= 2) {
                    inputValido = true;
                } else {
                    System.out.println("Favor selecionar uma opção do menu.");
                }
            } else {
                System.out.println("Favor selecionar uma opção do menu.");
            }
        }

        switch (escolha) {
            case 1:
                Tanque.novoTanque();
                break;
            case 2:
                Tanque.listaTanques();
                break;
            case 3:
                Tanque.tanquesToTXT();
                break;
            case 4:
                Tanque.carregaTanquesDoTXT();;
                break;
        }

        main(null);

    }
}
