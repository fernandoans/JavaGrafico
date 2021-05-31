import java.awt.Color;

public class Slice {

    private float valor;
    private Color cor;
    
    public Slice(float valor, Color cor) {
        this.valor = valor;
        this.cor = cor;
    }
    
    public float getValor() {
        return valor;
    }
        
    public Color getCor() {
        return cor;
    }
}
