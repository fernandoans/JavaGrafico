public class Decodificar {

    String [] mens = {
        "01000100", "01101111", "00100000", "01111001", 
        "01101111", "01110101", "00100000", "01100110", 
        "01001001", "01010100", "00111111"};
    
    // trocar 105 e 116
    
    
    public static void main(String [] args) {
        new Decodificar().processar();
    }
    
    public void processar() {
        byte valor;
        for (String let : mens) {
           valor = Byte.parseByte(let,2);
           System.out.print((char)valor);
        }
    }
}
