/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import vista.VentanaDeCarga;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JWindow;
import javax.swing.UIManager;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.UnsupportedLookAndFeelException;
import vista.Proyecto;

public class Main extends JWindow {

    private VentanaDeCarga ventanaDeCarga;
    private Proyecto ventana;

    public static void main(String args[]) throws InterruptedException {
        new Main(); // se invoca a la ventana RunSplash
    }

    /**
     * Creates new form RunSplash
     *
     * @throws InterruptedException
     */
    public Main() throws InterruptedException {
        ventanaDeCarga = new VentanaDeCarga(); // se crea el objeto Panel

        this.add(ventanaDeCarga, BorderLayout.CENTER); // se añade el panel en el centro
        this.setSize(ventanaDeCarga.getWidth(), ventanaDeCarga.getHeight());
        this.setLocationRelativeTo(null);// se muestra la ventana de carga en el centro
        setVisible(true); // se visualiza la ventana de carga
        darEsteticaPantalla();
        ventana = ventanaDeCarga.velocidadDeCarga(ventana);

        this.dispose();// se cierra la ventana de carga cuando termina el recorrido de la barra
        ventana.setVisible(true);

    }

    private void darEsteticaPantalla() {
        try {
            for (UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
