/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa113022020;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import static java.nio.file.Files.lines;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.shape.Path;

/**
 *
 * @author 082170007
 */
public class Tanque {

    static void listaTanques() {
        System.out.println("\nNome;pH;Temp");
        System.out.println(Tanque.tanquesToString());
    }

    static String carregaTanquesDoTXT() {
        try {
            File myObj = new File("tanques.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String array[] = new String[3];
                array = data.split(";");
                Tanque t = new Tanque(
                        array[0],
                        Double.parseDouble(array[1]),
                        Double.parseDouble(array[2]));
            }
            myReader.close();
            return "Dados carregados";
        } catch (FileNotFoundException e) {            
            return("Ocorreu um erro ao carregar os dados, verifique o TXT (nome(string);ph(double);temperatura(double).");
        }
    }

    private String nome;
    private double pH = -1;
    private double temperatura = -1;

    public static List<Tanque> tanques = new ArrayList<Tanque>();

    public Tanque(String nome, double pH, double temperatura) {
        this.nome = nome;
        this.pH = pH;
        this.temperatura = temperatura;
        tanques.add(this);
    }

    public static void novoTanque() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do Tanque:");
        String nome = sc.nextLine();
        while (nome.trim().isEmpty()) {
            System.out.println("Nome não pode ser vazio.");
            System.out.println("Digite o nome do Tanque:");
            nome = sc.nextLine();
        }

        System.out.println("Digite o pH do Tanque:");
        boolean pHvalido = false;
        double pH = -1;
        while (!pHvalido) {
            String inputpH = sc.nextLine();
            boolean parsable = Metodos.isParsableDouble(inputpH);
            if (parsable) {
                pH = Double.parseDouble(inputpH);
                if (pH >= 0 && pH <= 14) {
                    pHvalido = true;
                } else {
                    System.out.println("O pH deve ser entre 0 e 14:");
                }
            } else {
                System.out.println("O pH deve ser entre 0 e 14:");
            }
        }

        System.out.println("Digite a temperatura do Tanque:");
        boolean tempValida = false;
        double temp = -1;
        while (!tempValida) {
            String inputTemp = sc.nextLine();
            boolean parsable = Metodos.isParsableDouble(inputTemp);
            if (parsable) {
                temp = Double.parseDouble(inputTemp);
                if (temp >= 1 && temp <= 40) {
                    tempValida = true;
                } else {
                    System.out.println("A temperatura deve ser entre 1 e 40");
                }
            } else {
                System.out.println("A temperatura deve ser entre 1 e 40");
            }
        }

        Tanque t = new Tanque(nome, pH, temp);
    }

    public static String tanquesToString() {
        String linha = "";
        for (int n = 0; n < tanques.size(); n++) {

            Tanque t = tanques.get(n);
            linha += t.nome;
            if (t.pH != -1) {
                linha += ";" + t.pH;
            }
            if (t.temperatura != -1) {
                linha += ";" + t.temperatura;
            }
            linha += "\n";
        }
        linha=linha.trim();
        return linha;
    }

    public static void tanquesToTXT() throws FileNotFoundException {
        String linha = Tanque.tanquesToString();
        try (PrintWriter out = new PrintWriter("tanques.txt")) {
            out.println(linha);
        }
    }

    public void changeNome(String oldNome, String newNome) {
        int index = 0;
        boolean found = false;
        while (tanques.size() > index && found == false) {
            if (tanques.get(index).nome == oldNome) {
                found = true;
                tanques.get(index).nome = newNome;
            } else {
                index++;
            }
        }
    }

    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public double getTemperatura() {
        return pH;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

}
