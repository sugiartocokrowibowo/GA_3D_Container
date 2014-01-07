package GUI;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Database.Data;

public class ViewDataBarang extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane1 = null;

	private JPanel jPanel1 = null;

	private JButton jButtonViewRefresh = null;

	private JButton jButtonViewReset = null;

	private JScrollPane jScrollPane = null;

	private JTable jTableDataBarang = null;
	
	private String[] namaField={"Nomor Barang","Panjang(dm)","Lebar(dm)","Tinggi(dm)"};
	
	private ModelTabelBarang mtb=new ModelTabelBarang(new Data().stringViewWithID(),namaField); 

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setLocation(new Point(50, 38));
			jScrollPane.setSize(new Dimension(391, 294));
			jScrollPane.setBackground(Color.decode("#0a5db3"));
			jScrollPane.setForeground(Color.decode("#0a5db3"));
			jScrollPane.setViewportView(getJTableDataBarang());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTableDataBarang	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableDataBarang() {
		if (jTableDataBarang == null) {
			//jTableDataBarang = new JTable();
			jTableDataBarang = new JTable(mtb);
			jTableDataBarang.setBackground(Color.decode("#0a5db3"));
			jTableDataBarang.setDefaultRenderer(Object.class, new RenderWarnaWarni(Color.decode("#095eb7"), Color.decode("#e1e1e3")));// Color.WHITE));
		}
		return jTableDataBarang;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ViewDataBarang thisClass = new ViewDataBarang();
				thisClass.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public ViewDataBarang() {
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
		this.setLocation(new Point(286, 12));
		this.setSize(new Dimension(490, 367));
		this.setVisible(true);
		this.setContentPane(getJContentPane1());
		this.setTitle("View Data Barang");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	/**
	 * This method initializes jContentPane1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane1() {
		if (jContentPane1 == null) {
			jContentPane1 = new JPanel();
			jContentPane1.setLayout(null);
			jContentPane1.add(getJPanel1(), null);
		}
		return jContentPane1;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			//jPanel1 = new JPanel();
			jPanel1 = new BackgroundPanel("/res/view.png");
			jPanel1.setLayout(null);
			jPanel1.setSize(new Dimension(490, 367));
			jPanel1.setLocation(new Point(0, 0));
			jPanel1.add(getJButtonViewRefresh(), null);
			jPanel1.add(getJButtonViewReset(), null);
			jPanel1.add(getJScrollPane(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jButtonViewRefresh	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonViewRefresh() {
		if (jButtonViewRefresh == null) {
			jButtonViewRefresh = new JButton();
			jButtonViewRefresh.setIcon(new ImageIcon(getClass().getResource("/res/iconView_02.png")));
			jButtonViewRefresh.setLocation(new Point(358, 0));
			jButtonViewRefresh.setSize(new Dimension(71, 35));
			jButtonViewRefresh.setRolloverIcon(new ImageIcon(getClass().getResource("/res/iconViews_02.png")));
			jButtonViewRefresh.setText("");
			jButtonViewRefresh.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ControlPanel.refreshDataBarang();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonViewRefresh;
	}

	/**
	 * This method initializes jButtonViewReset	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonViewReset() {
		if (jButtonViewReset == null) {
			jButtonViewReset = new JButton();
			jButtonViewReset.setIcon(new ImageIcon(getClass().getResource("/res/iconView_03.png")));
			jButtonViewReset.setLocation(new Point(429, 0));
			jButtonViewReset.setSize(new Dimension(54, 35));
			jButtonViewReset.setRolloverIcon(new ImageIcon(getClass().getResource("/res/iconViews_03.png")));
			jButtonViewReset.setText("");
			jButtonViewReset.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new Data().reset();
					ControlPanel.refreshDataBarang();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonViewReset;
	}
	
	public void tutup(){
		this.setVisible(false);
	}
	
	public void buka(){
		this.setVisible(true);
	}

}//end of class
