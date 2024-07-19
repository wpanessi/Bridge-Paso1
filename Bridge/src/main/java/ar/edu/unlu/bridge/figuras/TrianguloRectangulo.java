package ar.edu.unlu.bridge.figuras;

import java.awt.*;


public class TrianguloRectangulo extends Figura{
    private Figura lineas[] = new Figura[3];
    public TrianguloRectangulo(){
        for (int i = 0; i < 3; i ++) {
            lineas[i] = new Linea();
        }
    }
    @Override
    public void dibujar(Graphics2D g2, Integer[] param) {

        if (param.length == 4) {
            Integer x = param[0];
            Integer y = param[1];
            Integer x1 = param[2];
            Integer y1 = param[3];
            // Coordenadas de los lados
            Integer[] hipotenusa = {x,y,x1,y1};
            Integer[] altura = {x,y,x,y1};
            Integer[] base = {x,y1,x1,y1};
            // Lineas
            lineas[0].dibujar(g2, hipotenusa);
            lineas[1].dibujar(g2, altura);
            lineas[2].dibujar(g2, base);
        }

    }
}

