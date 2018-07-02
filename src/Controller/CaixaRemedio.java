/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Arduino.AcessaArduino;
import Model.Acionado;
import DAOs.DAOAcionado;
import DAOs.DAOAlarmes;
import DAOs.DAODesligado;
import DAOs.DB_Direct;
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
public class CaixaRemedio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Observador o = new Observador();
        
        DB_Direct db = new DB_Direct("src/DAOs/local.txt");
        DAOAlarmes al = new DAOAlarmes();
        DAOAcionado ac = new DAOAcionado();
//        inserirAlarme(2, 7, 2018, "13:00", "Estomazil");
        o.printAlarme();

//        List<Alarme> als = al.list();
//        inserirAcionado(als.get(0));
//        o.printAcionado();

//        List<Acionado> acs = ac.list();
//        inserirDesligado(acs.get(0));
//        o.printDesligado();
    }

}
