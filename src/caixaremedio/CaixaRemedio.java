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
import Model.Alarme;
import Model.Desligado;
import java.util.Calendar;
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
        DAOAlarmes al = new DAOAlarmes();
        DAOAcionado ac = new DAOAcionado();
        inserirAlarme(2, 7, 2018, "16:30", "Estomazil");
        printAlarme();

//        List<Alarmes> als = al.list();
//        alarmeAcionado(als.get(1));
        printAcionado();
        
//        List<Acionado> acs = ac.list();
//        alarmeDesligado(acs.get(0));
        printDesligado();

    }

    public static void inserirAlarme(int dia, int mes, int ano, String hora, String remedio) {
        DAOAlarmes al = new DAOAlarmes();
        int aux = 0;

        List<Alarme> als = al.list();
        for (Alarme a : als) {
            if (a.getIdalarme() > aux) {
                aux = a.getIdalarme();
            }
        }
        
        Alarme alN = new Alarme(aux + 1);
        String data = ""+ano+"-"+mes+"-"+dia;

        alN.setDataalarme(data);
        alN.setHoraalarme(hora);
        alN.setRemedioalarme(remedio);
        al.inserir(alN);
    }

    public static void alarmeAcionado(Alarme a) {
        DAOAcionado dac = new DAOAcionado();

        Calendar cal = Calendar.getInstance();
        cal.toString();
        String data = "" + cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH);
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        String hora = "" + hours + ":" + minute;

        Acionado ac = new Acionado(a.getIdalarme());
        ac.setDataacionado(data);
        ac.setHoraacionado(hora);
        dac.inserir(ac);

    }

    public static void alarmeDesligado(Acionado ac){
        DAODesligado dd = new DAODesligado();
        
        Calendar cal = Calendar.getInstance();
        cal.toString();
        String data = "" + cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH);
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        String hora = "" + hours + ":" + minute;

        Desligado d = new Desligado(ac.getIdacionado());
        d.setDatadesligado(data);
        d.setHoradesligado(hora);
        dd.inserir(d);
    }
    
    public static void printAlarme() {
        DAOAlarmes al = new DAOAlarmes();

        List<Alarme> als = al.list();
        for (Alarme a : als) {
            System.out.println(a);
        }
    }

    public static void printAcionado() {
        DAOAcionado ac = new DAOAcionado();

        List<Acionado> acs = ac.list();
        for (Acionado a : acs) {
            System.out.println(a);
        }
    }

    public static void printDesligado() {
        DAODesligado dc = new DAODesligado();

        List<Desligado> ds = dc.list();
        for (Desligado d : ds) {
            System.out.println(d);
        }
    }

}
