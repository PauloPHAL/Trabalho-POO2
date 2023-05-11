package Gerencia;

import java.awt.Component;
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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

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
    
    //verifica o CPF
    public static boolean isCPF(String parCpf) {           
        // considera-se erro cpf's formados por uma sequencia de numeros iguais
        String cpf;
        cpf = parCpf.replace(".", "");
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");    
        if (cpf.equals("00000000000")
                || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999")
                || (cpf.length() != 11)) {        
            return (false);
        }
        char dig10, dig11;
        int sm, i, r, num, peso;
        // Calculo do 1o. Digito Verificador
        sm = 0;
        peso = 10;
        for (i = 0; i < 9; i++) {
            // converte o i-esimo caractere do cpf em um numero:
            // por exemplo, transforma o caractere '0' no inteiro 0         
            // (48 eh a posicao de '0' na tabela ASCII)         
            num = (int) (cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }
        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) {
            dig10 = '0';
        } else {
            dig10 = (char) (r + 48); // converte no respectivo caractere numerico
        }
        // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 11;
        for (i = 0; i < 10; i++) {
            num = (int) (cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }
        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) {
            dig11 = '0';
        } else {
            dig11 = (char) (r + 48);
        }
        // Verifica se os digitos calculados conferem com os digitos informados.
        if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
            return (true);
        } else {
            return (false);
        }      
    }
    
    //verificar Email/Gmail
    public static boolean isEmail_Gmail(String str){      
        return (str.indexOf("@") > 0);
    }
    
    //Foto em uma coluna expecifica
    public static void colocarFotoNaTabela(JTable tabela, int coluna){
        tabela.getColumnModel().getColumn(coluna).setCellRenderer( 
            new TableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                    // OBJETO FINAL
                    JLabel label = new JLabel();
                    if ( o != null)
                        label.setIcon( new ImageIcon( (byte[]) o) );
                    return label;
                }
            } 
        );
    }
}
