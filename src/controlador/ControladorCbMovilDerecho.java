/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ConeccionBD;
import vista.Proyecto;

/**
 * Controlador para cargar los modelos de moviles de la marca seleccionada en el
 * comboboz derecho
 *
 * @author sastian
 */
public class ControladorCbMovilDerecho implements ItemListener {

//declaracion de constantes y variables
    private Proyecto ventana;
    private static String Movil;
    ConeccionBD bd = new ConeccionBD();

    public ControladorCbMovilDerecho(Proyecto vent) {
        this.ventana = vent;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //Comprobamos que el item seleccionado en el combobox ha cambiado
        if (e.getStateChange() == ItemEvent.SELECTED) {
            //almacenamos el nombre del modelo en una variable
            Movil = e.getItem().toString();
            ResultSet resultado;

            try {
                //Realizamos la consulta de los modelos de esa marca
                resultado = bd.realizarConsulta("select * from MOVILES where NOMBRE='" + Movil + "';");
                while (resultado.next()) {
                    ventana.setImagenDerecha(resultado.getString("FOTO"));
                }

            } catch (SQLException ex) {
                //En caso de no poder realizar la consulta saltara un mensaje informandonos de ello
                JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta correctamente", "Error Al realizar consulta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
