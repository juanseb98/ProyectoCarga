/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ConeccionBD;
import vista.Proyecto;

/**
 *
 * @author DAM-2
 */
public class ControladorVentana extends WindowAdapter {

//declaracion de constantes y variables
    private final Proyecto ventana;
    private static final String CONSULTA_MARCAS = "select NOMBRE from MARCA;";
    ConeccionBD bd = new ConeccionBD();

    public ControladorVentana(Proyecto vent) {
        ventana = vent;
    }

    /**
     * Al iniciar nuestro programa cargara la lista de marcas que hay en nuestra
     * base de datos
     *
     * @param e
     */
    @Override
    public void windowOpened(WindowEvent e) {

        ResultSet resultado;
        try {
            //realizamos la consulta a la base de datos y guardamos los datos
            resultado = bd.realizarConsulta(CONSULTA_MARCAS);

            //Limpiamos los combobox de las marcas
            ventana.limpiarItems(ventana.getCbMarcaDerecho());
            ventana.limpiarItems(ventana.getCbMarcaIzquierdo());

            //aniadimos un item de identificativo
            ventana.addMarcaDerecho("Marca...");
            ventana.addMarcaIzquierdo("Marca...");

            while (resultado.next()) {
                //aniadimos el resultado de la consulta a los combobox de modelo
                ventana.addMarcaDerecho(resultado.getString(1));
                ventana.addMarcaIzquierdo(resultado.getString(1));
            }
        } catch (SQLException ex) {
            //En caso de no poder realizar la consulta saltara un mensaje informandonos de ello
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta correctamente", "Error Al realizar consulta", JOptionPane.ERROR_MESSAGE);
        }

    }

}
