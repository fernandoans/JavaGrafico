import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.embed.swing.JFXPanel;

public abstract class PaiGrafico extends JFrame {

    private JFXPanel fxPanel = new JFXPanel();
    
    protected JFXPanel getJFXPanel() {
        return fxPanel;
    }
    
    public PaiGrafico(String titulo, int w, int h) {
        super(titulo);
        this.setSize(w, h);
        this.add(fxPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                iniciarFX(getJFXPanel());
            }
        });
    }

    protected void iniciarFX(JFXPanel fxPanel) {
        Scene cena = criarCena();
        fxPanel.setScene(cena);
    }

    public abstract Scene criarCena();
    
}
