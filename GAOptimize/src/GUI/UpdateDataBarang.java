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
import javax.swing.JTextField;
import javax.swing.JLabel;

import Database.Data;

import java.awt.Color;

public class UpdateDataBarang extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane6 = null;

	private JPanel jPanel6 = null;
	
	private JButton jButtonClearUpdate = null;

	private JButton jButtonUpdate = null;

	private JButton jButtonCari = null;

	private JTextField jTextFieldID = null;

	private JTextField jTextFieldPanjang = null;

	private JTextField jTextFieldLebar = null;

	private JTextField jTextFieldTinggi = null;

	private JLabel jLabelID = null;

	private JLabel jLabelPanjang = null;

	private JLabel jLabelLebar = null;

	private JLabel jLabelTinggi = null;

	private JLabel jLabelDM1 = null;

	private JLabel jLabelDM2 = null;

	private JLabel jLabelDM3 = null;

	/**
	 * This method initializes jButtonCari	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCari() {
		if (jButtonCari == null) {
			jButtonCari = new JButton();
			jButtonCari.setText("");
			jButtonCari.setLocation(new Point(88, 55));
			jButtonCari.setIcon(new ImageIcon(getClass().getResource("/res/cariBarang.png")));
			jButtonCari.setSize(new Dimension(58, 48));
			jButtonCari.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int ID=Integer.parseInt(jTextFieldID.getText().trim());
					Data data=new Data();
					jTextFieldPanjang.setText(data.cariPanjangByID(ID));
					jTextFieldLebar.setText(data.cariLebarByID(ID));
					jTextFieldTinggi.setText(data.cariTinggiByID(ID));
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonCari;
	}

	/**
	 * This method initializes jTextFieldID	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldID() {
		if (jTextFieldID == null) {
			jTextFieldID = new JTextField();
			jTextFieldID.setSize(new Dimension(43, 20));
			jTextFieldID.setLocation(new Point(10, 78));
			///jTextFieldPanjang.setLocation(new Point(10, 78));
		}
		return jTextFieldID;
	}

	/**
	 * This method initializes jTextFieldPanjang	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldPanjang() {
		if (jTextFieldPanjang == null) {
			jTextFieldPanjang = new JTextField();
			jTextFieldPanjang.setSize(new Dimension(53, 20));
			jTextFieldPanjang.setLocation(new Point(162, 78));
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
			jTextFieldLebar.setSize(new Dimension(52, 20));
			jTextFieldLebar.setLocation(new Point(268, 78));
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
			jTextFieldTinggi.setSize(new Dimension(59, 20));
			jTextFieldTinggi.setLocation(new Point(374, 78));
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
				UpdateDataBarang thisClass = new UpdateDataBarang();
				thisClass.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public UpdateDataBarang() {
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
		this.setTitle("Update Data Barang");
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
			jLabelDM3 = new JLabel();
			jLabelDM3.setText("dm");
			jLabelDM3.setSize(new Dimension(18, 16));
			jLabelDM3.setLocation(new Point(438, 81));
			jLabelDM3.setForeground(Color.white);
			jLabelDM2 = new JLabel();
			jLabelDM2.setText("dm");
			jLabelDM2.setSize(new Dimension(18, 16));
			jLabelDM2.setLocation(new Point(325, 81));
			jLabelDM2.setForeground(Color.white);
			jLabelDM1 = new JLabel();
			jLabelDM1.setText("dm");
			jLabelDM1.setSize(new Dimension(27, 16));
			jLabelDM1.setLocation(new Point(220, 81));
			jLabelDM1.setForeground(Color.white);
			jLabelTinggi = new JLabel();
			jLabelTinggi.setText("Tinggi Barang");
			jLabelTinggi.setLocation(new Point(374, 54));
			jLabelTinggi.setSize(new Dimension(104, 16));
			jLabelTinggi.setForeground(Color.white);
			jLabelLebar = new JLabel();
			jLabelLebar.setText("Lebar Barang");
			jLabelLebar.setLocation(new Point(268, 54));
			jLabelLebar.setSize(new Dimension(104, 16));
			jLabelLebar.setForeground(Color.white);
			jLabelPanjang = new JLabel();
			jLabelPanjang.setText("Panjang Barang");
			jLabelPanjang.setSize(new Dimension(104, 16));
			jLabelPanjang.setLocation(new Point(162, 54));
			jLabelPanjang.setForeground(Color.white);
			jLabelID = new JLabel();
			jLabelID.setForeground(Color.white);
			jLabelID.setSize(new Dimension(69, 16));
			jLabelID.setLocation(new Point(10, 54));
			jLabelID.setText("ID Barang");
			jPanel6 = new BackgroundPanel("/res/update.png");
			jPanel6.setLayout(null);
			jPanel6.setLocation(new Point(0, 0));
			jPanel6.setSize(new Dimension(490, 142));
			jPanel6.add(getJButtonClearUpdate(), null);
			jPanel6.add(getJButtonUpdate(), null);
			jPanel6.add(getJButtonCari(), null);
			jPanel6.add(getJTextFieldID(), null);
			jPanel6.add(getJTextFieldPanjang(), null);
			jPanel6.add(getJTextFieldLebar(), null);
			jPanel6.add(getJTextFieldTinggi(), null);
			jPanel6.add(jLabelID, null);
			jPanel6.add(jLabelPanjang, null);
			jPanel6.add(jLabelLebar, null);
			jPanel6.add(jLabelTinggi, null);
			jPanel6.add(jLabelDM1, null);
			jPanel6.add(jLabelDM2, null);
			jPanel6.add(jLabelDM3, null);
		}
		return jPanel6;
	}
	
	/**
	 * This method initializes jButtonClearUpdate	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonClearUpdate() {
		if (jButtonClearUpdate == null) {
			jButtonClearUpdate = new JButton();
			jButtonClearUpdate.setIcon(new ImageIcon(getClass().getResource("/res/iconUpdate_02.png")));
			jButtonClearUpdate.setSize(new Dimension(68, 35));
			jButtonClearUpdate.setLocation(new Point(347, 0));
			jButtonClearUpdate.setRolloverIcon(new ImageIcon(getClass().getResource("/res/iconUpdates_02.png")));
			jButtonClearUpdate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextFieldID.setText("");
					jTextFieldPanjang.setText("");
					jTextFieldLebar.setText("");
					jTextFieldTinggi.setText("");
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonClearUpdate;
	}

	/**
	 * This method initializes jButtonUpdate	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonUpdate() {
		if (jButtonUpdate == null) {
			jButtonUpdate = new JButton();
			jButtonUpdate.setRolloverIcon(new ImageIcon(getClass().getResource("/res/iconUpdates_03.png")));
			jButtonUpdate.setSize(new Dimension(72, 35));
			jButtonUpdate.setLocation(new Point(415, 0));
			jButtonUpdate.setIcon(new ImageIcon(getClass().getResource("/res/iconUpdate_03.png")));
			jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int ID=Integer.parseInt(jTextFieldID.getText().trim());
					Data data=new Data();
					int panjang,lebar,tinggi;
					panjang=Integer.parseInt(jTextFieldPanjang.getText().trim());
					lebar=Integer.parseInt(jTextFieldLebar.getText().trim());
					tinggi=Integer.parseInt(jTextFieldTinggi.getText().trim());
					data.update(ID, panjang, lebar, tinggi);					
					jTextFieldID.setText("");
					jTextFieldPanjang.setText("");
					jTextFieldLebar.setText("");
					jTextFieldTinggi.setText("");
					jTextFieldID.requestFocus();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonUpdate;
	}
	
	public void tutup(){
		this.setVisible(false);
	}
	
	public void buka(){
		this.setVisible(true);
	}

}//end of class
