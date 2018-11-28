/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Proyecto;

/**
 *
 * @author DAM-2
 */
public class Controlador implements ActionListener {

    private Proyecto ventana;

    public Controlador(Proyecto ven) {
        ventana = ven;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "salir":
                System.exit(0);
                break;

        }

    }

}
