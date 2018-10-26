package Resources;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
public class Fuente {
    private Font font = null;

    public Fuente() {
        String fontName = "../Resources/arial.ttf" ;
        try {
            InputStream is =  getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException ex) {
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 16);
        }
    }
    public Font MyFont( int estilo, float tamanio)
    {
        Font tfont = font.deriveFont(estilo, tamanio);
        return tfont;
    }
}
