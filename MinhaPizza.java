import javax.swing.JFrame;
import java.awt.Color;

public class MinhaPizza extends JFrame {

    private Slice[] slices = {
        new Slice(5.4f, Color.BLUE),
        new Slice(20.3f, Color.GREEN),
        new Slice(33.2f, Color.YELLOW),
        new Slice(20.0f, Color.RED)
    };
    
    
    public MinhaPizza() {
        super("Minhas Compras");
        this.setSize(300, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new PieChart(slices));
        this.setVisible(true);
    }
    
    
    public static void main(String [] args) {
        new MinhaPizza();
    }

}
