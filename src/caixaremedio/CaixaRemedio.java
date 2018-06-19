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
        printAlarmes();
        DAOAlarmes al = new DAOAlarmes();
        DAOAcionado ac = new DAOAcionado();

//        List<Alarmes> als = al.list();
//        alarmeAcionado(als.get(1));
        printAcionado();
        
//        List<Acionado> acs = ac.list();
//        alarmeDesligado(acs.get(0));
        printDesligado();

    }

    public static void inserirAlarme(int dia, int mes, int ano, String hora) {
        DAOAlarmes al = new DAOAlarmes();
        int aux = 0;

        List<Alarmes> als = al.list();
        for (Alarmes a : als) {
            if (a.getIdAlarmes() > aux) {
                aux = a.getIdAlarmes();
            }
        }

        Alarmes alN = new Alarmes(aux + 1);
        Date data = new Date(1);
        data.setDate(dia);
        data.setMonth(mes - 1);
        data.setYear(ano - 1900);

        alN.setDataAlarmes(data);
        alN.setHoraAlarmes(hora);
        al.inserir(alN);
    }

    public static void alarmeAcionado(Alarmes a) {
        DAOAcionado dac = new DAOAcionado();

        Date data = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        String hora = "" + hours + ":" + minute;

        Acionado ac = new Acionado(a.getIdAlarmes());
        ac.setAlarmesidAlarmes(a);
        ac.setDataAcionado(data);
        ac.setHoraAcionado(hora);
        ac.setDesligadoAcionado(Boolean.FALSE);
        dac.inserir(ac);

    }

    public static void alarmeDesligado(Acionado ac){
        DAODesligado dd = new DAODesligado();
        
        Date data = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        String hora = "" + hours + ":" + minute;

        Desligado d = new Desligado(ac.getIdAcionado());
        d.setAcionadoidAcionado(ac);
        d.setDataDesligado(data);
        d.setHoraDesligado(hora);
        dd.inserir(d);
    }
    
    public static void printAlarmes() {
        DAOAlarmes al = new DAOAlarmes();

        List<Alarmes> als = al.list();
        for (Alarmes a : als) {
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
