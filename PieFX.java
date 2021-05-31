import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.embed.swing.JFXPanel;
// Grafico
import javafx.geometry.Side;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

public class PieFX extends PaiGrafico {

    public PieFX() {
        super("Top 8 Linguagens do TIOBE", 700, 500);
    }
    
    public Scene criarCena() {
        PieChart chart = new PieChart();
        chart.setData(getObservacoes());
        chart.setLabelLineLength(10);
        chart.setLegendSide(Side.LEFT);
        StackPane root = new StackPane();
        root.getChildren().add(chart);
        Scene cena = new Scene(root, 500, 400);        
        return cena;
    }
    
    private ObservableList<PieChart.Data> getObservacoes() {
        ObservableList<PieChart.Data> observacoes =
            FXCollections.observableArrayList(
                new PieChart.Data("C", 13.38),
                new PieChart.Data("Python", 11.87),
                new PieChart.Data("Java", 11.74),
                new PieChart.Data("C++", 7.81),
                new PieChart.Data("C#", 4.41),
                new PieChart.Data("Visual Basic", 4.02),
                new PieChart.Data("JavaScript", 2.45),
                new PieChart.Data("Assembly", 2.43)
            );
        return observacoes;
    }
    
    public static void main(String [] args) {
        new PieFX();
    }
}
