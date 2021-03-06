/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Arduino.AcessaArduino;
import DAOs.DAOAcionado;
import DAOs.DAOAlarmes;
import DAOs.DAODesligado;
import Model.Acionado;
import Model.Alarme;
import Model.Desligado;
import gnu.io.SerialPort;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author lcorra
 */
public class Observador implements Observer{
    AcessaArduino acessaArduino;
    
    
    public Observador() {//buscar parâmetros salvos
        try {
            acessaArduino = new AcessaArduino(this); //passa como parâmetro a classe GUI (this) para informar quem é o Observador
            System.out.println("Porta detectada: " + acessaArduino.getPortaSelecionada());

        } catch (Exception e) {
            System.out.println("Erro ao acionar o Arduino");

        }
        
    }
    public void inserirAlarme(int dia, int mes, int ano, String hora, String remedio) {
        DAOAlarmes al = new DAOAlarmes();
        int aux = 0;

        List<Alarme> als = al.list();
        for (Alarme a : als) {
            if (a.getIdalarme() > aux) {
                aux = a.getIdalarme();
            }
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(ano, mes, dia));
        int semana = cal.get(Calendar.DAY_OF_WEEK) + 3;
        if (semana > 7) {
            semana = semana - 7;
        }
        Alarme alN = new Alarme(aux + 1);
        String data = "" + ano + "-" + mes + "-" + dia + "/" + semana;

        alN.setDataalarme(data);
        alN.setHoraalarme(hora);
        alN.setRemedioalarme(remedio);
        al.inserir(alN);
    }

    public void inserirAcionado(Alarme a) {
        DAOAcionado dac = new DAOAcionado();

        Calendar cal = Calendar.getInstance();
        int semana = cal.get(Calendar.DAY_OF_WEEK) + 3;
        if (semana > 7) {
            semana = semana - 7;
        }
        String data = "" + cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DAY_OF_MONTH) + "/" + semana;

        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        String hora = "" + hours + ":" + minute;

        Acionado ac = new Acionado(a.getIdalarme());
        ac.setDataacionado(data);
        ac.setHoraacionado(hora);
        ac.setRemedioacionado(a.getRemedioalarme());
        dac.inserir(ac);

    }

    public void inserirDesligado(Acionado ac) {
        DAODesligado dd = new DAODesligado();

        Calendar cal = Calendar.getInstance();
        int semana = cal.get(Calendar.DAY_OF_WEEK) + 3;
        if (semana > 7) {
            semana = semana - 7;
        }
        String data = "" + cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.DAY_OF_WEEK) + "/" + semana;
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        String hora = "" + hours + ":" + minute;

        Desligado d = new Desligado(ac.getIdacionado());
        d.setDatadesligado(data);
        d.setHoradesligado(hora);
        d.setRemediodesligado(ac.getRemedioacionado());
        dd.inserir(d);
    }

    public void printAlarme() {
        DAOAlarmes al = new DAOAlarmes();
        String comando = "";
        
        SerialPort p = acessaArduino.getSerialPort();

        List<Alarme> als = al.list();
        for (Alarme a : als) {
            String v[] = a.toString().split("/");
            String c[] = a.toString().split(":");
            comando = "a"+v[1]+","+c[0]+":"+c[1];
            acessaArduino.setDataToArduino(p, "a2,18,12");
            System.out.println(a);
        }
    }

    public void printAcionado() {
        DAOAcionado ac = new DAOAcionado();

        List<Acionado> acs = ac.list();
        for (Acionado a : acs) {
            System.out.println(a);
        }
    }

    public void printDesligado() {
        DAODesligado dc = new DAODesligado();

        List<Desligado> ds = dc.list();
        for (Desligado d : ds) {
            System.out.println(d);
        }
    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
