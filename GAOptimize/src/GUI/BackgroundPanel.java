package GUI;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
class BackgroundPanel extends javax.swing.JPanel {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
  * @author : Fajar Saptono
 **/
    Image bgimage = null;
    BackgroundPanel(String namaGambar){
        if(namaGambar != null) {
            MediaTracker mt = new MediaTracker(this);
            bgimage = Toolkit.getDefaultToolkit().getImage(getClass().getResource(namaGambar));//namaGambar
            mt.addImage(bgimage, 0);
            try {
                mt.waitForAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(bgimage != null) {
            int imwidth = bgimage.getWidth(null);
            int imheight = bgimage.getHeight(null);
            if((imwidth > 0) && (imheight > 0)) {
                for(int y = 0; y<getHeight(); y+=imheight) {
                    for(int x = 0; x<getWidth(); x+=imwidth) {
                        g.drawImage(bgimage, x, y, null);
                    }
                }
            }
        }
    }
}