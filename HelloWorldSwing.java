import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.embed.swing.JFXPanel;

public class HelloWorldSwing extends JFrame {
    
    public HelloWorldSwing() {
        super("Hello World Swing");
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
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);
        return scene;
    }
    
    
    public static void main(String [] args) {
        new HelloWorldSwing();
    }

}
