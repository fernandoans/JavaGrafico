import javax.swing.*;
import java.awt.geom.*;
import java.awt.Graphics;
import java.util.*;

public class ScatterPlot extends JPanel {

    private Ponto [] dados;

    public ScatterPlot(Ponto [] dados) {
        this.dados = dados;
    }

    public void paintComponent(Graphics g) {
        for (Ponto p : dados) {
           g.drawString("*", p.getPX() + 40, (getHeight() - p.getPY()) - 30);
        }

        int width = getWidth();
        int height = getHeight();

        // Linha do X
        g.drawLine(0, height - 40, width - 30, height - 40);
        // Linha do Y
        g.drawLine(40, height - 270, 40, height);

        // Valores do Eixo y
        byte p;
        for (int a = 1; a < 11; a++) {
            p = (byte)((20*a < 100)?20:11);
            String temp = 20*a + "--";
            g.drawString(temp, p, height - (36 + 20*(a)));
        }
        
        // Valores do Eixo x
        for (int a = 1; a < 11; a++) {
            g.drawString("|", 40 + 50*a, height - 30);
            int x = 50*a;
            String temp = x + " ";
            g.drawString(temp, 30 + 50*a, height - 18);
        }
    }
}