/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa113022020;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 082170007
 */
public class Tanque {

    private String nome;
    private double pH;
    private double temperatura;
    private String peixe;

    public List<Tanque> tanques = new ArrayList<Tanque>();

    public Tanque(String nome) {
        this.nome = nome;
        tanques.add(this);
    }


    public void changeNome(String oldNome, String newNome) {
        int index = 0;
        boolean found = false;
        while (tanques.size() > index && found == false)
        {
            if(tanques.get(index).nome==oldNome)
            {
                found = true;
                tanques.get(index).nome = newNome;
            }
            else
            {
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
