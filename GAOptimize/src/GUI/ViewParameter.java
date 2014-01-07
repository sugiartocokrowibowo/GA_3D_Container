package GUI;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class ViewParameter extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane2 = null;

	private JPanel jPanel2 = null;
	
	private JLabel jLabelJumlahGenerasi = null;

	private JLabel jLabelJumlahIndividu = null;

	private JLabel jLabelJumlahIndividuTerseleksi = null;

	private JLabel jLabelProbabilitasMutasi = null;

	private JLabel jLabelPanjangKontainer = null;

	private JLabel jLabelLebarKontainer = null;

	private JLabel jLabelTinggiKontainer = null;

	private JLabel jLabelJumlahGenerasi1 = null;

	private JLabel jLabelJumlahIndividu1 = null;

	private JLabel jLabelJumlahIndividuTerseleksi1 = null;

	private JLabel jLabelJumlahIndividuTerseleksi2 = null;

	private JLabel jLabelPanjangKontainer1 = null;

	private JLabel jLabelLebarKontainer1 = null;

	private JLabel jLabelTinggiKontainer1 = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ViewParameter thisClass = new ViewParameter();
				thisClass.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public ViewParameter() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		//L&F Windows
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}catch(Exception e){System.err.println("Tidak berhasi menerapkan L&F: "+e);}
		this.setFocusable(true);
		this.setVisible(true);
		this.setLocation(new Point(718, 152));
		this.setSize(new Dimension(288, 367));
		this.setContentPane(getJContentPane2());
		this.setTitle("View Parameter");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */

	
	/**
	 * This method initializes jContentPane2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane2() {
		if (jContentPane2 == null) {
			jContentPane2 = new JPanel();
			jContentPane2.setLayout(null);
			jContentPane2.add(getJPanel2(), null);
		}
		return jContentPane2;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jLabelTinggiKontainer1 = new JLabel();
			jLabelTinggiKontainer1.setText(String.valueOf(ControlPanel.getTinggiKontainer())+" meter");
			jLabelTinggiKontainer1.setSize(new Dimension(73, 16));
			jLabelTinggiKontainer1.setLocation(new Point(189, 271));
			jLabelTinggiKontainer1.setForeground(Color.white);
			jLabelLebarKontainer1 = new JLabel();
			jLabelLebarKontainer1.setText(String.valueOf(ControlPanel.getLebarKontainer())+" meter");
			jLabelLebarKontainer1.setLocation(new Point(189, 237));
			jLabelLebarKontainer1.setSize(new Dimension(73, 16));
			jLabelLebarKontainer1.setForeground(Color.white);
			jLabelPanjangKontainer1 = new JLabel();
			jLabelPanjangKontainer1.setText(String.valueOf(ControlPanel.getPanjangKontainer())+" meter");
			jLabelPanjangKontainer1.setLocation(new Point(189, 206));
			jLabelPanjangKontainer1.setSize(new Dimension(73, 16));
			jLabelPanjangKontainer1.setForeground(Color.white);
			jLabelJumlahIndividuTerseleksi2 = new JLabel();
			jLabelJumlahIndividuTerseleksi2.setText(String.valueOf(ControlPanel.getProbabilitasMutasi()));
			jLabelJumlahIndividuTerseleksi2.setLocation(new Point(189, 176));
			jLabelJumlahIndividuTerseleksi2.setSize(new Dimension(73, 16));
			jLabelJumlahIndividuTerseleksi2.setForeground(Color.white);
			jLabelJumlahIndividuTerseleksi1 = new JLabel();
			jLabelJumlahIndividuTerseleksi1.setText(String.valueOf(ControlPanel.getJumlahIndividuTerseleksi()));
			jLabelJumlahIndividuTerseleksi1.setLocation(new Point(189, 143));
			jLabelJumlahIndividuTerseleksi1.setSize(new Dimension(73, 16));
			jLabelJumlahIndividuTerseleksi1.setForeground(Color.white);
			jLabelJumlahIndividu1 = new JLabel();
			jLabelJumlahIndividu1.setText(String.valueOf(ControlPanel.getJumlahIndividu()));
			jLabelJumlahIndividu1.setLocation(new Point(189, 113));
			jLabelJumlahIndividu1.setSize(new Dimension(73, 16));
			jLabelJumlahIndividu1.setForeground(Color.white);
			jLabelJumlahGenerasi1 = new JLabel();
			jLabelJumlahGenerasi1.setText(String.valueOf(ControlPanel.getJumlahGenerasi()));
			jLabelJumlahGenerasi1.setLocation(new Point(189, 84));
			jLabelJumlahGenerasi1.setSize(new Dimension(73, 16));
			jLabelJumlahGenerasi1.setForeground(Color.white);
			jLabelTinggiKontainer = new JLabel();
			jLabelTinggiKontainer.setText("Tinggi Kontainer:");
			jLabelTinggiKontainer.setSize(new Dimension(164, 16));
			jLabelTinggiKontainer.setLocation(new Point(14, 271));
			jLabelTinggiKontainer.setForeground(Color.white);
			jLabelLebarKontainer = new JLabel();
			jLabelLebarKontainer.setText("Lebar Kontainer : ");
			jLabelLebarKontainer.setSize(new Dimension(164, 16));
			jLabelLebarKontainer.setLocation(new Point(14, 237));
			jLabelLebarKontainer.setForeground(Color.white);
			jLabelPanjangKontainer = new JLabel();
			jLabelPanjangKontainer.setText("Panjang Kontainer: ");
			jLabelPanjangKontainer.setSize(new Dimension(164, 16));
			jLabelPanjangKontainer.setLocation(new Point(14, 206));
			jLabelPanjangKontainer.setForeground(Color.white);
			jLabelProbabilitasMutasi = new JLabel();
			jLabelProbabilitasMutasi.setText("Probabilitas Mutasi: ");
			jLabelProbabilitasMutasi.setSize(new Dimension(164, 16));
			jLabelProbabilitasMutasi.setLocation(new Point(14, 176));
			jLabelProbabilitasMutasi.setForeground(Color.white);
			jLabelJumlahIndividuTerseleksi = new JLabel();
			jLabelJumlahIndividuTerseleksi.setText("Jumlah Individu Terseleksi:");
			jLabelJumlahIndividuTerseleksi.setSize(new Dimension(164, 16));
			jLabelJumlahIndividuTerseleksi.setLocation(new Point(14, 143));
			jLabelJumlahIndividuTerseleksi.setForeground(Color.white);
			jLabelJumlahIndividu = new JLabel();
			jLabelJumlahIndividu.setText("Jumlah Individu:");
			jLabelJumlahIndividu.setSize(new Dimension(164, 16));
			jLabelJumlahIndividu.setLocation(new Point(14, 113));
			jLabelJumlahIndividu.setForeground(Color.white);
			jLabelJumlahGenerasi = new JLabel();
			jLabelJumlahGenerasi.setForeground(Color.white);
			jLabelJumlahGenerasi.setSize(new Dimension(164, 16));
			jLabelJumlahGenerasi.setLocation(new Point(14, 84));
			jLabelJumlahGenerasi.setText("Jumlah Generasi:");
			jPanel2 = new BackgroundPanel("/res/viewParameter.png");
			jPanel2.setLayout(null);
			jPanel2.setLocation(new Point(0, 0));
			jPanel2.setSize(new Dimension(288, 367));
			jPanel2.add(jLabelJumlahGenerasi, null);
			jPanel2.add(jLabelJumlahIndividu, null);
			jPanel2.add(jLabelJumlahIndividuTerseleksi, null);
			jPanel2.add(jLabelProbabilitasMutasi, null);
			jPanel2.add(jLabelPanjangKontainer, null);
			jPanel2.add(jLabelLebarKontainer, null);
			jPanel2.add(jLabelTinggiKontainer, null);
			jPanel2.add(jLabelJumlahGenerasi1, null);
			jPanel2.add(jLabelJumlahIndividu1, null);
			jPanel2.add(jLabelJumlahIndividuTerseleksi1, null);
			jPanel2.add(jLabelJumlahIndividuTerseleksi2, null);
			jPanel2.add(jLabelPanjangKontainer1, null);
			jPanel2.add(jLabelLebarKontainer1, null);
			jPanel2.add(jLabelTinggiKontainer1, null);
		}
		return jPanel2;
	}
	
	public void tutup(){
		this.setVisible(false);
	}
	
	public void buka(){
		this.setVisible(true);
	}
	
}//end of class
