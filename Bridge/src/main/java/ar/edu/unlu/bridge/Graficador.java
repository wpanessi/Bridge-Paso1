package ar.edu.unlu.bridge;

import ar.edu.unlu.bridge.figuras.Figura;
import ar.edu.unlu.bridge.figuras.Linea;
import ar.edu.unlu.bridge.figuras.Rectangulo;
import ar.edu.unlu.bridge.figuras.TrianguloRectangulo;
import ar.edu.unlu.bridge.graficador.DefPuntos;
import ar.edu.unlu.bridge.graficador.Lienzo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graficador {
    public JPanel window;
    private JButton btnLinea;
    private JButton btnRectangulo;
    private JButton btnTriangulo;
    private JPanel panelCentral;

    public static void main(String[] args) {
        JFrame window = new JFrame("Graficador");
        Graficador app = new Graficador();
        app.initialize();
        window.setContentPane(app.window);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(100, 100, 650, 500);
        window.setVisible(true);
    }
    private void initialize(){
        btnLinea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLinea();
            }
        });
        btnRectangulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRectangulo();
            }
        });
        btnTriangulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onTriangulo();
            }
        });
    }
    private void onLinea() {
        Integer[] param = getPuntos();
        if (param[0] != -1 || param[1] != -1 || param[2] != -1  || param[3] != -1){
            Figura fig = new Linea();
            ((Lienzo) panelCentral).addFigura(fig, param);
        };
    }
    private void onRectangulo() {
        Integer[] param = getPuntos();
        if (param[0] != -1 || param[1] != -1 || param[2] != -1  || param[3] != -1){
            Figura fig = new Rectangulo();
            ((Lienzo) panelCentral).addFigura(fig, param);
        };
    }
    private void onTriangulo() {
        Integer[] param = getPuntos();
        if (param[0] != -1 || param[1] != -1 || param[2] != -1  || param[3] != -1){
            Figura fig = new TrianguloRectangulo();
            ((Lienzo) panelCentral).addFigura(fig, param);
        };
    }

    private Integer[] getPuntos() {
        DefPuntos puntos = new DefPuntos();
        puntos.setTitle("Coordenadas");
        puntos.setModal(true);
        Integer[] param = puntos.showDialog();
        return param;
    }

    private void createUIComponents() {
        panelCentral = new Lienzo();
    }
}
