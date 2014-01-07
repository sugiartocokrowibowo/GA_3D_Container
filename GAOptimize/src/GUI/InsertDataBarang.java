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
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Database.Data;

import java.awt.Color;

public class InsertDataBarang extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane6 = null;

	private JPanel jPanel6 = null;
	
	private JButton jButtonClearInsert = null;

	private JButton jButtonInsert = null;

	private JTextField jTextFieldJumlah = null;

	private JTextField jTextFieldPanjang = null;

	private JTextField jTextFieldLebar = null;

	private JTextField jTextFieldTinggi = null;

	private JLabel jLabelJumlah = null;

	private JLabel jLabelPanjang = null;

	private JLabel jLabelLebar = null;

	private JLabel jLabelTinggi = null;

	private JLabel jLabelCM1 = null;

	private JLabel jLabelCM11 = null;

	private JLabel jLabelCM12 = null;

	/**
	 * This method initializes jTextFieldJumlah	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldJumlah() {
		if (jTextFieldJumlah == null) {
			jTextFieldJumlah = new JTextField();
			jTextFieldJumlah.setSize(new Dimension(60, 20));
			jTextFieldJumlah.setLocation(new Point(383, 78));
			jTextFieldJumlah.setText("1");
		}
		return jTextFieldJumlah;
	}

	/**
	 * This method initializes jTextFieldPanjang	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldPanjang() {
		if (jTextFieldPanjang == null) {
			jTextFieldPanjang = new JTextField();
			jTextFieldPanjang.setSize(new Dimension(60, 20));
			jTextFieldPanjang.setLocation(new Point(18, 78));
		}
		return jTextFieldPanjang;
	}

	/**
	 * This method initializes jTextFieldLebar	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldLebar() {
		if (jTextFieldLebar == null) {
			jTextFieldLebar = new JTextField();
			jTextFieldLebar.setSize(new Dimension(60, 20));
			jTextFieldLebar.setLocation(new Point(144, 78));
		}
		return jTextFieldLebar;
	}

	/**
	 * This method initializes jTextFieldTinggi	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldTinggi() {
		if (jTextFieldTinggi == null) {
			jTextFieldTinggi = new JTextField();
			jTextFieldTinggi.setSize(new Dimension(60, 20));
			jTextFieldTinggi.setLocation(new Point(262, 78));
		}
		return jTextFieldTinggi;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InsertDataBarang thisClass = new InsertDataBarang();
				thisClass.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public InsertDataBarang() {
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
		this.setLocation(new Point(290, 388));
		this.setSize(new Dimension(490, 142));
		this.setVisible(true);
		this.setContentPane(getJContentPane6());
		this.setTitle("Insert Data Barang");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	/**
	 * This method initializes jContentPane6	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane6() {
		if (jContentPane6 == null) {
			jContentPane6 = new JPanel();
			jContentPane6.setLayout(null);
			jContentPane6.add(getJPanel6(), null);
		}
		return jContentPane6;
	}

	/**
	 * This method initializes jPanel6	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jLabelCM12 = new JLabel();
			jLabelCM12.setBounds(new Rectangle(329, 81, 18, 16));
			jLabelCM12.setText("dm");
			jLabelCM12.setForeground(Color.white);
			jLabelCM11 = new JLabel();
			jLabelCM11.setText("dm");
			jLabelCM11.setSize(new Dimension(18, 16));
			jLabelCM11.setLocation(new Point(211, 81));
			jLabelCM11.setForeground(Color.white);
			jLabelCM1 = new JLabel();
			jLabelCM1.setText("dm");
			jLabelCM1.setSize(new Dimension(27, 16));
			jLabelCM1.setLocation(new Point(83, 81));
			jLabelCM1.setForeground(Color.white);
			jLabelTinggi = new JLabel();
			jLabelTinggi.setText("Tinggi Barang");
			jLabelTinggi.setLocation(new Point(262, 54));
			jLabelTinggi.setSize(new Dimension(104, 16));
			jLabelTinggi.setForeground(Color.white);
			jLabelLebar = new JLabel();
			jLabelLebar.setText("Lebar Barang");
			jLabelLebar.setLocation(new Point(144, 54));
			jLabelLebar.setSize(new Dimension(104, 16));
			jLabelLebar.setForeground(Color.white);
			jLabelPanjang = new JLabel();
			jLabelPanjang.setText("Panjang Barang");
			jLabelPanjang.setSize(new Dimension(104, 16));
			jLabelPanjang.setLocation(new Point(18, 54));
			jLabelPanjang.setForeground(Color.white);
			jLabelJumlah = new JLabel();
			jLabelJumlah.setForeground(Color.white);
			jLabelJumlah.setSize(new Dimension(69, 16));
			jLabelJumlah.setLocation(new Point(383, 54));
			jLabelJumlah.setText("Jumlah");
			jPanel6 = new BackgroundPanel("/res/insert.png");
			jPanel6.setLayout(null);
			jPanel6.setLocation(new Point(0, 0));
			jPanel6.setSize(new Dimension(490, 142));
			jPanel6.add(getJButtonClearInsert(), null);
			jPanel6.add(getJButtonInsert(), null);
			jPanel6.add(getJTextFieldJumlah(), null);
			jPanel6.add(getJTextFieldPanjang(), null);
			jPanel6.add(getJTextFieldLebar(), null);
			jPanel6.add(getJTextFieldTinggi(), null);
			jPanel6.add(jLabelJumlah, null);
			jPanel6.add(jLabelPanjang, null);
			jPanel6.add(jLabelLebar, null);
			jPanel6.add(jLabelTinggi, null);
			jPanel6.add(jLabelCM1, null);
			jPanel6.add(jLabelCM11, null);
			jPanel6.add(jLabelCM12, null);
		}
		return jPanel6;
	}
	
	/**
	 * This method initializes jButtonClearInsert	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonClearInsert() {
		if (jButtonClearInsert == null) {
			jButtonClearInsert = new JButton();
			jButtonClearInsert.setIcon(new ImageIcon(getClass().getResource("/res/iconInsert_02.png")));
			jButtonClearInsert.setSize(new Dimension(68, 35));
			jButtonClearInsert.setLocation(new Point(347, 0));
			jButtonClearInsert.setRolloverIcon(new ImageIcon(getClass().getResource("/res/iconInserts_02.png")));
			jButtonClearInsert.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextFieldJumlah.setText("1");
					jTextFieldPanjang.setText("");
					jTextFieldLebar.setText("");
					jTextFieldTinggi.setText("");
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonClearInsert;
	}

	/**
	 * This method initializes jButtonInsert	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonInsert() {
		if (jButtonInsert == null) {
			jButtonInsert = new JButton();
			jButtonInsert.setRolloverIcon(new ImageIcon(getClass().getResource("/res/iconInserts_03.png")));
			jButtonInsert.setSize(new Dimension(72, 35));
			jButtonInsert.setLocation(new Point(415, 0));
			jButtonInsert.setIcon(new ImageIcon(getClass().getResource("/res/iconInsert_03.png")));
			jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Data data=new Data();
					int panjang,lebar,tinggi,jumlah;
					panjang=Integer.parseInt(jTextFieldPanjang.getText().trim());
					lebar=Integer.parseInt(jTextFieldLebar.getText().trim());
					tinggi=Integer.parseInt(jTextFieldTinggi.getText().trim());
					jumlah=Integer.parseInt(jTextFieldJumlah.getText().trim());
					for(int i=0;i<jumlah;i++){
						data.insert(panjang, lebar, tinggi);
					}//end of for
					jTextFieldPanjang.setText("");
					jTextFieldLebar.setText("");
					jTextFieldTinggi.setText("");					
					jTextFieldJumlah.setText("1");
					jTextFieldJumlah.requestFocus();
					ControlPanel.refreshDataBarang();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonInsert;
	}
	
	public void tutup(){
		this.setVisible(false);
	}
	
	public void buka(){
		this.setVisible(true);
	}

}//end of class
