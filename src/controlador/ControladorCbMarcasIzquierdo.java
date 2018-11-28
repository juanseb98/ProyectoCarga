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
 * comboboz izquierdo
 *
 * @author sastian
 */
public class ControladorCbMarcasIzquierdo implements ItemListener {

    //Declaracion de variables y constantes
    private Proyecto ventana;
    private static String MARCA;
    ConeccionBD bd = new ConeccionBD();

    public ControladorCbMarcasIzquierdo(Proyecto vent) {
        this.ventana = vent;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //Comprobamos que el item seleccionado en el combobox ha cambiado
        if (e.getStateChange() == ItemEvent.SELECTED) {
            //limpiamos el combobox de modelo correspondiente al combobox de marca modificado
            ventana.limpiarItems(ventana.getCbModeloIzquierdo());
            //almacenamos el nombre del modelo en una variable
            MARCA = e.getItem().toString();

            ResultSet resultado;
            try {
                //Realizamos la consulta de los modelos de esa marca
                resultado = bd.realizarConsulta("select NOMBRE from MOVILES where MARCA = (select ID_MARCA from MARCA where NOMBRE = '" + MARCA + "');");

                while (resultado.next()) {
                    //aniadimos cada modelo a nuestro combobox
                    ventana.addModeloIzquierdo(resultado.getString("NOMBRE"));
                }

            } catch (SQLException ex) {
                //En caso de no poder realizar la consulta saltara un mensaje informandonos de ello
                JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta correctamente", "Error Al realizar consulta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
