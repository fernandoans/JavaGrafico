import javax.swing.*;

public class MeuScatter extends JFrame {

    private Ponto[] pontos = {
        new Ponto(50, 20),
        new Ponto(100, 40),
        new Ponto(150, 60),
        new Ponto(200, 80),
        new Ponto(250, 100),
        new Ponto(300, 120),
        new Ponto(350, 140)
    };
    
    public MeuScatter() {
        super("Scatterplot");
        this.setSize(800, 350);
        this.add(new ScatterPlot(pontos));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);       
    }
    
    public static void main(String [] args) {
        new MeuScatter();
    }
            
}
