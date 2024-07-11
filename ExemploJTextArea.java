import javax.swing.*;

public class ExemploJTextArea {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo JTextArea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JTextArea textArea = new JTextArea();
        
        // Adicione o texto com saltos de linha
        String teste = "Isso é a linha 1.\nIsso é a linha 2.";
        textArea.setText(teste);

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}