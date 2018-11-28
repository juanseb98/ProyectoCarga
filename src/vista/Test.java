/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {

    public static void main(String args[]) throws UnknownHostException, IOException, InterruptedException {

        JFrame carga = new JFrame("Cargar");
        JPanel pane = new JPanel(new BorderLayout());
        JLabel progreso = new JLabel();
        pane.add(progreso);
        carga.add(pane);
        carga.setSize(300, 300);
        carga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        carga.setVisible(true);

        progreso.setText("cargando mierda");
        Thread hr = new Thread(new Proyecto());
        progreso.setText("cargando mierda infinita");
        Thread.sleep(1000);
        progreso.setText("la mierda esta cargada pero te hago esperar");
        Thread.sleep(1000);
        carga.setVisible(false);
        hr.start();

    }
}
