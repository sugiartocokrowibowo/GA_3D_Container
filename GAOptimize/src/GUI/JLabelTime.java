package GUI;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
import java.awt.event.ActionEvent;	
import java.awt.event.ActionListener;	
import java.text.SimpleDateFormat;	
import java.util.Date;	
import javax.swing.JLabel;	
import javax.swing.Timer;	

public class JLabelTime extends JLabel implements ActionListener {	

	private String pattern = "dd MMMM yyyy, HH:m:ss";
	private SimpleDateFormat format;
	private Timer timer;
	private Date date;
	
	public JLabelTime() {
		timer = new Timer(1000, this);
		format = new SimpleDateFormat(pattern);
		date = new Date();
		}
	
	public String getPattern() {
		return pattern;
		}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
		format = new SimpleDateFormat(pattern);
		}
	
	public void start() {
		timer.start();
		}	
	
	public void stop() {
		timer.stop();
		}
	
	public void actionPerformed(ActionEvent e) {
		date.setTime(System.currentTimeMillis());
		setText(format.format(date));
		}	
}	
