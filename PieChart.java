import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class PieChart extends JComponent {

    private Slice [] slices;
    
    public PieChart(Slice [] slices) {
        this.slices = slices;
    }
    
    @Override
    public void paint(Graphics g) {
        drawPie((Graphics2D) g, getBounds());
    }

    public void drawPie(Graphics2D g, Rectangle area) {
        float total = 0.0f;
        for (Slice sc : slices) {
            total += sc.getValor();
        }
        float curValor = 0.0f;
        short inAngulo = 0;
        short tmAngulo = 0;
        for (Slice sc : slices) {
            inAngulo = (short)(curValor * 360 / total);
            tmAngulo = (short)(sc.getValor() * 360 / total);
            g.setColor(sc.getCor());
            g.fillArc(area.x, area.y, area.width, area.height, inAngulo, tmAngulo);
            curValor += sc.getValor();
        }
    }
    
}
