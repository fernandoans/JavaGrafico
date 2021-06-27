import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.embed.swing.JFXPanel;
// Grafico
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;

public class ScatterFX extends PaiGrafico {
    
    private JComboBox<String> cbTipo;

    public ScatterFX() {
        super("Meus Investimentos", 500, 400);
        JPanel pnEscolha = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cbTipo = new JComboBox<>(new String[]{"Scatter", "Line", "Area"});
        cbTipo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                mudarGrafico();
            }
        });
        pnEscolha.add(new JLabel("Graficos disponiveis: "));
        pnEscolha.add(cbTipo);
        this.add(pnEscolha, BorderLayout.NORTH);
    }

    private void mudarGrafico() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                iniciarFX(getJFXPanel());
            }
        });
        this.repaint(); // Refresh de Tela
    }
    
    public Scene criarCena() {
        final NumberAxis xAxis = new NumberAxis(0, 10, 1);
        final NumberAxis yAxis = new NumberAxis(-100, 500, 100);
        XYChart<Number, Number> sc;
        switch (String.valueOf(cbTipo.getSelectedItem())) {
            case "Scatter": sc = new ScatterChart<>(xAxis, yAxis); break;
            case "Line": sc = new LineChart<>(xAxis, yAxis); break;
            default: sc = new AreaChart<>(xAxis, yAxis); break;
        }
        
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
        switch (nome) {
            case "Imoveis": 
                serie.getData().add(new XYChart.Data(5, 200));
                serie.getData().add(new XYChart.Data(6, 220));
                serie.getData().add(new XYChart.Data(8, 280));
                serie.getData().add(new XYChart.Data(2, 270));
                serie.getData().add(new XYChart.Data(4, 260));
                serie.getData().add(new XYChart.Data(3, 250));
                serie.getData().add(new XYChart.Data(4, 255));
                serie.getData().add(new XYChart.Data(8, 240));
                serie.getData().add(new XYChart.Data(10, 100));
                serie.getData().add(new XYChart.Data(8, 50));
                break;
            case "Fundo Açoes": 
                serie.getData().add(new XYChart.Data(7, 200));
                serie.getData().add(new XYChart.Data(8, 210));
                serie.getData().add(new XYChart.Data(10, 220));
                serie.getData().add(new XYChart.Data(10, 230));
                serie.getData().add(new XYChart.Data(5, 240));
                serie.getData().add(new XYChart.Data(5, 250));
                serie.getData().add(new XYChart.Data(4, 260));
                serie.getData().add(new XYChart.Data(3, 270));
                serie.getData().add(new XYChart.Data(2, 280));
                serie.getData().add(new XYChart.Data(1, 290));
                break;
            default: 
                serie.getData().add(new XYChart.Data(1, 200));
                serie.getData().add(new XYChart.Data(2, 300));
                serie.getData().add(new XYChart.Data(3, 220));
                serie.getData().add(new XYChart.Data(4, 320));
                serie.getData().add(new XYChart.Data(5, 400));
                serie.getData().add(new XYChart.Data(6, 500));
                serie.getData().add(new XYChart.Data(7, 100));
                serie.getData().add(new XYChart.Data(8, 110));
                serie.getData().add(new XYChart.Data(9, 120));
                serie.getData().add(new XYChart.Data(10, 200));
                break;
        }
//        for (byte i = 0; i < 10; i++) {
//            serie.getData().add(new XYChart.Data(
//                Math.random()*10, // Axis X
//                Math.random()*600-100)  // Axis Y
//            );
        return serie;
    }
    
    public static void main(String [] args) {
        new ScatterFX();
    }
}
