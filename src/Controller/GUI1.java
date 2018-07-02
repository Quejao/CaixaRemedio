package Controller;

/**
 *
 * @author radames
 */
import Arduino.AcessaArduino;
import gnu.io.SerialPort;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class GUI1 extends JFrame implements Observer {
    String comando = "";

    public void setComando(String comando) {
        this.comando = comando;
    }
   
    AcessaArduino acessaArduino;
   
    public GUI1() {
        //buscar parâmetros salvos
        try {
            acessaArduino = new AcessaArduino(this); //passa como parâmetro a classe GUI (this) para informar quem é o Observador
            System.out.println("Porta detectada: " + acessaArduino.getPortaSelecionada());

        } catch (Exception e) {
            System.out.println("Erro ao acionar o Arduino");

        }
        
        SerialPort p = acessaArduino.getSerialPort();
        acessaArduino.setDataToArduino(p, comando);
    }

    
    @Override
    public void update(Observable o, Object arg) {
        
    }
}