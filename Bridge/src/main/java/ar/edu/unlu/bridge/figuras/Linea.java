package ar.edu.unlu.bridge.figuras;

import java.awt.*;
import java.awt.geom.Line2D;

public class Linea extends Figura {
    @Override
    public void dibujar(Graphics2D g2, Integer[] param) {
        if (param.length == 4) {
            Shape line = new Line2D.Double(param[0], param[1], param[2],param[3]);
            g2.draw(line);
        }
    }

}
