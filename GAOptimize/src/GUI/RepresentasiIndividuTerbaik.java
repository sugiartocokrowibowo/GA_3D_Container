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
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RepresentasiIndividuTerbaik extends JFrame {

	private static final long serialVersionUID = 1L;

	//private JPanel jContentPane = null;
	
	private JPanel jContentPane3 = null;

	private JPanel jPanel3 = null;

	private JScrollPane jScrollPaneRepresentasi = null;

	private JTable jTableRepresentasi = null;
	
	private String[] namaField={"No. Barang","Posisi","Panjang(dm)","Lebar(dm)","Tinggi(dm)","x0","y0","z0","x1","y1","z1"};
	
	private ModelTabelBarang mtb=new ModelTabelBarang(new ReadRepresentasiIndividuTerbaik().representasiOut(),namaField); 

	/**
	 * This method initializes jScrollPaneRepresentasi	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneRepresentasi() {
		if (jScrollPaneRepresentasi == null) {
			jScrollPaneRepresentasi = new JScrollPane();
			jScrollPaneRepresentasi.setBounds(new Rectangle(11, 50, 998, 465));
			jScrollPaneRepresentasi.setViewportView(getJTableRepresentasi());
		}
		return jScrollPaneRepresentasi;
	}

	/**
	 * This method initializes jTableRepresentasi	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableRepresentasi() {
		if (jTableRepresentasi == null) {
			//jTableRepresentasi = new JTable();
			jTableRepresentasi = new JTable(mtb);
			jTableRepresentasi.setBackground(Color.decode("#0a5db3"));
			jTableRepresentasi.setDefaultRenderer(Object.class, new RenderWarnaWarni(Color.decode("#095eb7"), Color.decode("#e1e1e3")));// Color.WHITE));
		}
		return jTableRepresentasi;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RepresentasiIndividuTerbaik thisClass = new RepresentasiIndividuTerbaik();
				thisClass.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public RepresentasiIndividuTerbaik() {
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
		this.setTitle("Representasi Individu Terbaik");
		//this.setLocation(new Point(286, 12));
		//this.setLocationRelativeTo(null);
		this.setLocation(4, 4);
		this.setSize(new Dimension(1024, 560));
		this.setVisible(true);
		this.setContentPane(getJContentPane3());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	/**
	 * This method initializes jContentPane3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane3() {
		if (jContentPane3 == null) {
			jContentPane3 = new JPanel();
			jContentPane3.setLayout(null);
			jContentPane3.add(getJPanel3(), null);
		}
		return jContentPane3;
	}

	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new BackgroundPanel("/res/representasi individu terbaik1.png");
			jPanel3.setLayout(null);
			jPanel3.setLocation(new Point(0, 0));
			jPanel3.setSize(new Dimension(1024, 600));
			jPanel3.add(getJScrollPaneRepresentasi(), null);
		}
		return jPanel3;
	}
	
	public void tutup(){
		this.setVisible(false);
	}
	
	public void buka(){
		this.setVisible(true);
	}

}//end of class
