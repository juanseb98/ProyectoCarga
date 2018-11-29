package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

/**
 *
 * @author sastian
 */
public class VentanaDeCarga extends javax.swing.JPanel {

    /**
     * Metodo de creacion del panel de Carga
     */
    public VentanaDeCarga() {
        initComponents();
        lbCarga.setForeground(Color.red);//asignamos el color al texto que hemos puesto en la pantalla
        imagen = new ImageIcon(getClass().getResource("../img/foto1.jpg")); // se obtiene la imagen de fondo
        this.setSize(400, 300); // se establece el tamaño del panel

    }

    /**
     * Metodo paintComponent para dibujar la imagen
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen.getImage(), 0, 0, imagen.getIconWidth(), imagen.getIconHeight(), this); // se dibuja la imagen
        this.setOpaque(false); // se establece el panel transparente para que se pueda ver la imagen
    }

    /**
     * Metodo encargado de controlar la velocidad de carga de la barra de carga
     * y devolver el frame principal de la aplicacion
     *
     * @param p Pantalla principal de la aplicacion
     * @return devuelve la pantalla ya inicializada
     * @throws InterruptedException
     */
    public Proyecto velocidadDeCarga(Proyecto p) throws InterruptedException { // motodo para controlar la barra
        for (int i = 0; i <= 100; i++) { // establece el recorrido de la barra de progreso

            if (i != 40) {//evitamos que a la hora de cargar la pantalla espere de mas
                Thread.sleep(50); // pausas para dar el efecto de carga
            }

            progreso.setValue(i); // se asigna el valor de la barra

            if (i == 0) {//iniciamos el cambio de imagenes de fondo al inicio de la barra
                cambiarImagen();
            }

            if (i == 40) {
                lbCarga.setText("Cargando moviles...");
                p = new Proyecto();
            }

            if (i == 50) {
                progreso.setForeground(Color.GREEN);
            }

            if (i == 75) {
                lbCarga.setText("Dando ultimos retoques...");
            }

            if (i == 100) {
                timer.cancel();
            }
        }
        return p;
    }

    private void cambiarImagen() {
        int velmil = velocidad * 1000;

        TimerTask tarea;

        tarea = new TimerTask() {
            @Override
            public void run() {
                switch (contador) {
                    case 0:
                        ImageIcon a = new ImageIcon(getClass().getResource("../img/foto2.jpg"));
                        fondo.setIcon(a);
                        contador = 1;
                        break;

                    case 1:
                        ImageIcon b = new ImageIcon(getClass().getResource("../img/foto3.jpg"));
                        fondo.setIcon(b);
                        contador = 2;
                        break;
                    case 2:
                        ImageIcon c = new ImageIcon(getClass().getResource("../img/foto4.jpg"));
                        fondo.setIcon(c);
                        contador = 3;
                        break;

                    case 3:
                        ImageIcon d = new ImageIcon(getClass().getResource("../img/foto5.jpg"));
                        fondo.setIcon(d);
                        contador = 4;
                        break;
                    case 4:
                        ImageIcon e = new ImageIcon(getClass().getResource("../img/foto1.jpg"));
                        fondo.setIcon(e);
                        contador = 0;
                        break;
                }
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(tarea, velmil, velmil);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progreso = new javax.swing.JProgressBar();
        lbCarga = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(progreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 400, -1));

        lbCarga.setText("Cargando archivos...");
        add(lbCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 160, -1));
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 290));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lbCarga;
    private javax.swing.JProgressBar progreso;
    // End of variables declaration//GEN-END:variables
    private static int contador = 0;
    private static ImageIcon imagen;
    private static Timer timer;
    private static final int velocidad = 2;
}
