import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.embed.swing.JFXPanel;
// Grafico
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

public class ScatterFX extends PaiGrafico {

    public ScatterFX() {
        super("Meus Investimentos", 500, 400);
    }
    
    public Scene criarCena() {
        final NumberAxis xAxis = new NumberAxis(0, 10, 1);
        final NumberAxis yAxis = new NumberAxis(-100, 500, 100);
        final ScatterChart<Number, Number> sc = 
            new ScatterChart<>(xAxis, yAxis);
        xAxis.setLabel("Tempo (Anos)");
        yAxis.setLabel("ROI");
       
        XYChart.Series serie1 = getSerie("Imoveis");
        XYChart.Series serie2 = getSerie("Fundo Açoes");
        XYChart.Series serie3 = getSerie("Tecnologia");
        
        sc.getData().addAll(serie1, serie2, serie3);
        Scene cena = new Scene(sc, 500, 400);        
        return cena;
    }
    
    private XYChart.Series getSerie(String nome) {
        XYChart.Series serie = new XYChart.Series();
        serie.setName(nome);
        for (byte i = 0; i < 10; i++) {
            serie.getData().add(new XYChart.Data(
                Math.random()*10, // Axis X
                Math.random()*600-100)  // Axis Y
            );
        }   
        return serie;
    }
    
    public static void main(String [] args) {
        new ScatterFX();
    }
}
