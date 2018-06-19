/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaremedio;

import Model.Acionado;
import DAOs.DAOAcionado;
import DAOs.DAOAlarmes;
import DAOs.DAODesligado;
import DAOs.DB_Direct;
import Model.Alarmes;
import Model.Desligado;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author lcorra
 */
public class CaixaRemedio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DB_Direct db = new DB_Direct("src/DAOs/local.txt");
        printAlarmes();
        
    }
    
    public static void inserirAlarme(int dia, int mes, int ano, String hora) {
        DAOAlarmes al = new DAOAlarmes();
        int aux = 0;
        
        List<Alarmes> als = al.list();
        for(Alarmes a : als){
            if(a.getIdAlarmes() > aux){
                aux = a.getIdAlarmes();
            }
        }
        
        Alarmes alN = new Alarmes(aux+1);
        Date data = new Date(1);
        data.setDate(dia);
        data.setMonth(mes - 1);
        data.setYear(ano - 1900);
        
        alN.setDataAlarmes(data);
        alN.setHoraAlarmes(hora);
        al.inserir(alN);
    }
    
    public static void printAlarmes(){
        DAOAlarmes al = new DAOAlarmes();
        
        List<Alarmes> als = al.list();
        for(Alarmes a : als){
            System.out.println(a);
        }
    }
    
    public static void printAcionado(){
        DAOAcionado ac = new DAOAcionado();
       
        List<Acionado> acs = ac.list();
        for(Acionado a : acs){
            System.out.println(a);
        }
    }
    
    public static void printDesligado(){
        DAODesligado dc = new DAODesligado();
        
        List<Desligado> ds = dc.list();
        for(Desligado d : ds){
            System.out.println(d);
        }
    }
    
}

