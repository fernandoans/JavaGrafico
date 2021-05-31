import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.embed.swing.JFXPanel;

public class Modelo extends JFrame {

    public Modelo() {
        super("Exemplo do Scatter Plot");
        this.setSize(300,250);
        final JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                iniciarFX(fxPanel);
            }
        });
    }
    
    private void iniciarFX(JFXPanel fxPanel) {
        Scene cena = criarCena();
        fxPanel.setScene(cena);
    }
    
    private Scene criarCena() {
        return null;
    }
    
    public static void main(String [] args) {
        new Modelo();
    }
}
