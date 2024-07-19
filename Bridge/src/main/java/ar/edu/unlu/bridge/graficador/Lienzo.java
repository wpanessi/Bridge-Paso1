package ar.edu.unlu.bridge.graficador;

import ar.edu.unlu.bridge.figuras.Figura;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Lienzo extends JPanel {
    class FiguraGrafica {
        public Figura figura;
        public Integer[] parametros;
        public FiguraGrafica(Figura figura, Integer[] parametros) {
            this.figura = figura;
            this.parametros = parametros;
        }
    }

    private ArrayList<FiguraGrafica> figuras = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (FiguraGrafica f : figuras) {
            f.figura.dibujar(g2,f.parametros);
        }
    }

    private void repintar() {
        repaint();
        revalidate();
    }

    public void addFigura(Figura f, Integer[] parametros) {
        figuras.add(new FiguraGrafica(f,parametros));
        this.repintar();
    }
}
