import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;
import java.util.Locale;

public class Soma extends JFrame {
    private JTextField valor1, valor2;
    private MeuTextField resultado;
    private JButton botaoSoma;

    public Soma() {
        super("Soma de Valores");

        // Define o layout da janela
        this.setLayout(new GridLayout(4,1));

        // Cria os campos de entrada de valores
        valor1 = new JTextField(10);
        valor1.setDocument(new PlainDocument());
        ((PlainDocument)valor1.getDocument()).setDocumentFilter(new InteiroFilter());
        
        valor2 = new JTextField(10);
        ((PlainDocument)valor2.getDocument()).setDocumentFilter(new InteiroFilter());        valor2.setDocument(new PlainDocument());

        // Cria o botão de soma
        botaoSoma = new JButton("Somar");
        /*
        botaoSoma.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                executar();
            }
        });
        */
        botaoSoma.addActionListener(e -> {
            executar();
        });

        // Cria o campo de resultado
        resultado = new MeuTextField();
        resultado.setEditable(false);
        resultado.setFont(new Font("SansSerif", Font.PLAIN, 20));

        // Adiciona os componentes à janela
        JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel val1 = new JLabel("Valor 1:");
        val1.setFont(new Font("SansSerif", Font.PLAIN, 20));
        pn1.add(val1);
        pn1.add(valor1);
        JPanel pn2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel val2 = new JLabel("Valor 2:");
        val2.setFont(new Font("SansSerif", Font.PLAIN, 20));
        pn2.add(val2);
        pn2.add(valor2);
        JPanel pn3 = new JPanel();
        pn3.add(botaoSoma);
        JPanel pn4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel res1 = new JLabel("Resultado:");
        res1.setFont(new Font("SansSerif", Font.PLAIN, 20));
        pn4.add(res1);
        pn4.add(resultado);

        this.add(pn1);
        this.add(pn2);
        this.add(pn3);
        this.add(pn4);

        // Configura a janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void executar() {
        // Lê os valores dos campos de entrada
        int v1 = Integer.parseInt(valor1.getText());
        int v2 = Integer.parseInt(valor2.getText());

        // Calcula a soma dos valores
        String soma = ""+(v1 + v2);

        // Mostra o resultado no campo de resultado
        resultado.setText(soma);
    }

    public static void main(String[] args) {
        new Soma();
    }
}

class InteiroFilter extends DocumentFilter {
    
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        // Verifica se a string inserida contém somente dígitos
        if (string.matches("\\d+")) {
            super.insertString(fb, offset, string, attr); // Insere a string no documento
        }
    }
    
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        // Verifica se o texto substituto contém somente dígitos
        if (text.matches("\\d+")) {
            super.replace(fb, offset, length, text, attrs); // Substitui o texto no documento
        }
    }
}

class MeuTextField extends JFormattedTextField {
    
    private static final int DEFAULT_WIDTH = 200;
    private static final int DEFAULT_HEIGHT = 30;
    
    public MeuTextField() {
        setHorizontalAlignment(JFormattedTextField.RIGHT); // alinha o texto à direita
        
        // Cria uma instância do Locale para o Brasil
        Locale brasil = new Locale("pt", "BR");
        
        // Cria uma instância de NumberFormat para formatar o valor como moeda
        NumberFormat format = NumberFormat.getCurrencyInstance(brasil);
        
        // Cria um NumberFormatter com o NumberFormat criado anteriormente
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class); // define a classe de valores como Integer
        
        // Define a fábrica de formatadores para o JFormattedTextField
        setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(formatter));
    }
    
    @Override
    public void setValue(Object valor) {
        this.setValue((int)valor);
    }
    
    @Override
    public void setText(String texto) {
        super.setText(texto);
        
        if (texto != null && texto.length() > 0 && !texto.substring(0,2).equals("R$")) {
            this.setValue(Integer.parseInt(texto));
        }
    }
    
    public void setValue(int valor) {
        super.setValue(valor); // Define o valor do componente
        String valorFormatado = this.getText(); // Obtém o valor formatado
        super.setText(valorFormatado); // Define o valor formatado no componente
    }    

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}