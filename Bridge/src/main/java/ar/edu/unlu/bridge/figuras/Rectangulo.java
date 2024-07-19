package ar.edu.unlu.bridge.figuras;

import java.awt.*;


public class Rectangulo extends Figura{
    private Figura lineas[] = new Figura[4];
    public Rectangulo(){
        for (int i = 0; i < 4; i ++) {
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
            Integer[] izquierda = {x,y,x,y1};
            Integer[] inferior = {x,y1,x1,y1};
            Integer[] derecha = {x1,y,x1,y1};
            Integer[] superior = {x,y,x1,y};
            // Lineas
            lineas[0].dibujar(g2, izquierda);
            lineas[1].dibujar(g2, superior);
            lineas[2].dibujar(g2, derecha);
            lineas[3].dibujar(g2, inferior);
        }

    }

}
