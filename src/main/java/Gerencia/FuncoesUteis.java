package Gerencia;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.Icon;

public class FuncoesUteis {
    //converter Icone para Bytes
    public static byte[] IconToBytes(Icon icon) {
        if (icon == null) {
            return null;
        }
        BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        icon.paintIcon(null, g2d, 0, 0);
        g2d.dispose();
        byte[] bFile = null;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ImageOutputStream ios = ImageIO.createImageOutputStream(baos)) {
                ImageIO.write(img, "png", ios);
                // Set a flag to indicate that the write was successful
            }
            bFile = baos.toByteArray();
        } catch (IOException ex) {
            bFile = null;
            System.out.println(ex);
        } finally {
            return bFile;
        }
    }
    
    //converter String para Data e 
    //Data para String
    public static Date strToDate(String strDt) throws ParseException {
        DateFormat dtForm = new SimpleDateFormat("dd/MM/yyyy");
        dtForm.setLenient(false);
        return dtForm.parse(strDt);
    }
    public static String dateToStr(Date dt) throws ParseException {
        DateFormat dtForm = new SimpleDateFormat("dd/MM/yyyy");
        dtForm.setLenient(false);
        return dtForm.format(dt);
    }
    
    //converter string em numero
    public static int stringToInt(String str) {
        int num = Integer.parseInt(str);
        return num;
    }
    public static double stringToDouble(String str) {
        double num = Double.parseDouble(str);
        return num;
    }
    
    
}
