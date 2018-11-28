/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 *
 * @author sastian
 */
public class BarraMenu extends JMenuBar {

    private JMenu mArchivo, mOperaciones;
    private JMenuItem iSalir, iAnalizar;

    public BarraMenu() {

        initVariables();
        add(mArchivo);
        mArchivo.add(iSalir);

        add(mOperaciones);
        iAnalizar.setMnemonic('A');
        mOperaciones.add(iAnalizar);

    }

    public void controlador(ActionListener crt) {
        iSalir.addActionListener(crt);
        iSalir.setActionCommand("salir");
        iAnalizar.addActionListener(crt);
        iAnalizar.setActionCommand("Aniadir");

    }

    private void initVariables() {
        mArchivo = new JMenu("Archivo");
        mOperaciones = new JMenu("Funciones");

        iSalir = new JMenuItem("Salir");
        iAnalizar = new JMenuItem("Analizar un solo movil");
    }

}
