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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class SetParameter extends JFrame {

	private static final long serialVersionUID = 1L;

	//private JPanel jContentPane = null;
	
	private JPanel jContentPane3 = null;

	private JPanel jPanel3 = null;
	
	private JLabel jLabelSetJumlahGenerasi = null;

	private JLabel jLabelSetJumlahIndividu = null;

	private JLabel jLabelSetJumlahIndividuTerseleksi = null;

	private JLabel jLabelSetProbabilitasMutasi = null;

	private JLabel jLabelSetPanjangKontainer = null;

	private JLabel jLabelSetLebarKontainer = null;

	private JLabel jLabelSetTinggiKontainer = null;

	private JTextField jTextFieldSetJumlahGenerasi = null;

	private JTextField jTextFieldSetJumlahIndividu = null;

	private JTextField jTextFieldSetJumlahIndividuTerseleksi = null;

	private JTextField jTextFieldSetProbabilitasMutasi = null;

	private JTextField jTextFieldSetPanjangKontainer = null;

	private JTextField jTextFieldSetLebarKontainer = null;

	private JTextField jTextFieldSetTinggiKontainer = null;

	private JLabel jLabelSetTinggiKontainer1 = null;

	private JLabel jLabelSetTinggiKontainer11 = null;

	private JLabel jLabelSetTinggiKontainer111 = null;
	
	private JButton jButtonCancelSetParameter = null;

	private JButton jButtonApplySetParameter = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SetParameter thisClass = new SetParameter();
				thisClass.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public SetParameter() {
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
		this.setTitle("Set Parameter");
		this.setLocation(new Point(300, 83));
		this.setSize(new Dimension(490, 367));
		this.setVisible(true);
		this.setContentPane(getJContentPane3());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jTextFieldSetJumlahGenerasi.setText(String.valueOf(ControlPanel.getJumlahGenerasi()));
		jTextFieldSetJumlahIndividu.setText(String.valueOf(ControlPanel.getJumlahIndividu()));
		jTextFieldSetJumlahIndividuTerseleksi.setText(String.valueOf(ControlPanel.getJumlahIndividuTerseleksi()));
		jTextFieldSetProbabilitasMutasi.setText(String.valueOf(ControlPanel.getProbabilitasMutasi()));
		jTextFieldSetPanjangKontainer.setText(String.valueOf(ControlPanel.getPanjangKontainer()));
		jTextFieldSetLebarKontainer.setText(String.valueOf(ControlPanel.getLebarKontainer()));
		jTextFieldSetTinggiKontainer.setText(String.valueOf(ControlPanel.getTinggiKontainer()));
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
			//jPanel3 = new JPanel();
			jLabelSetTinggiKontainer111 = new JLabel();
			jLabelSetTinggiKontainer111.setBounds(new Rectangle(344, 188, 34, 16));
			jLabelSetTinggiKontainer111.setText("meter");
			jLabelSetTinggiKontainer111.setForeground(Color.white);
			jLabelSetTinggiKontainer11 = new JLabel();
			jLabelSetTinggiKontainer11.setBounds(new Rectangle(344, 219, 34, 16));
			jLabelSetTinggiKontainer11.setText("meter");
			jLabelSetTinggiKontainer11.setForeground(Color.white);
			jLabelSetTinggiKontainer1 = new JLabel();
			jLabelSetTinggiKontainer1.setText("meter");
			jLabelSetTinggiKontainer1.setSize(new Dimension(39, 16));
			jLabelSetTinggiKontainer1.setLocation(new Point(344, 251));
			jLabelSetTinggiKontainer1.setForeground(Color.white);
			jLabelSetTinggiKontainer = new JLabel();
			jLabelSetTinggiKontainer.setText("Tinggi Kontainer:");
			jLabelSetTinggiKontainer.setSize(new Dimension(94, 16));
			jLabelSetTinggiKontainer.setLocation(new Point(108, 250));
			jLabelSetTinggiKontainer.setForeground(Color.white);
			jLabelSetLebarKontainer = new JLabel();
			jLabelSetLebarKontainer.setText("Lebar Kontainer:");
			jLabelSetLebarKontainer.setSize(new Dimension(107, 16));
			jLabelSetLebarKontainer.setLocation(new Point(108, 220));
			jLabelSetLebarKontainer.setForeground(Color.white);
			jLabelSetPanjangKontainer = new JLabel();
			jLabelSetPanjangKontainer.setText("Panjang Kontainer:");
			jLabelSetPanjangKontainer.setSize(new Dimension(109, 16));
			jLabelSetPanjangKontainer.setLocation(new Point(108, 190));
			jLabelSetPanjangKontainer.setForeground(Color.white);
			jLabelSetProbabilitasMutasi = new JLabel();
			jLabelSetProbabilitasMutasi.setText("Probabilitas Mutasi:");
			jLabelSetProbabilitasMutasi.setSize(new Dimension(154, 16));
			jLabelSetProbabilitasMutasi.setLocation(new Point(108, 160));
			jLabelSetProbabilitasMutasi.setForeground(Color.white);
			jLabelSetJumlahIndividuTerseleksi = new JLabel();
			jLabelSetJumlahIndividuTerseleksi.setText("Jumlah Individu Terseleksi:");
			jLabelSetJumlahIndividuTerseleksi.setSize(new Dimension(169, 16));
			jLabelSetJumlahIndividuTerseleksi.setLocation(new Point(108, 130));
			jLabelSetJumlahIndividuTerseleksi.setForeground(Color.white);
			jLabelSetJumlahIndividu = new JLabel();
			jLabelSetJumlahIndividu.setText("Jumlah Individu:");
			jLabelSetJumlahIndividu.setSize(new Dimension(99, 16));
			jLabelSetJumlahIndividu.setLocation(new Point(108, 100));
			jLabelSetJumlahIndividu.setForeground(Color.white);
			jLabelSetJumlahGenerasi = new JLabel();
			jLabelSetJumlahGenerasi.setText("Jumlah Generasi:");
			jLabelSetJumlahGenerasi.setSize(new Dimension(99, 16));
			jLabelSetJumlahGenerasi.setLocation(new Point(108, 70));
			jLabelSetJumlahGenerasi.setForeground(Color.white);
			jPanel3 = new BackgroundPanel("/res/setParameter.png");
			jPanel3.setLayout(null);
			jPanel3.setLocation(new Point(0, 0));
			jPanel3.setSize(new Dimension(490, 367));
			jPanel3.add(getJButtonCancelSetParameter(), null);
			jPanel3.add(getJButtonApplySetParameter(), null);
			jPanel3.add(jLabelSetJumlahGenerasi, null);
			jPanel3.add(jLabelSetJumlahIndividu, null);
			jPanel3.add(jLabelSetJumlahIndividuTerseleksi, null);
			jPanel3.add(jLabelSetProbabilitasMutasi, null);
			jPanel3.add(jLabelSetPanjangKontainer, null);
			jPanel3.add(jLabelSetLebarKontainer, null);
			jPanel3.add(jLabelSetTinggiKontainer, null);			
			jPanel3.add(getJTextFieldSetJumlahGenerasi(), null);
			jPanel3.add(getJTextFieldSetJumlahIndividu(), null);
			jPanel3.add(getJTextFieldSetJumlahIndividuTerseleksi(), null);
			jPanel3.add(getJTextFieldSetProbabilitasMutasi(), null);
			jPanel3.add(getJTextFieldSetPanjangKontainer(), null);
			jPanel3.add(getJTextFieldSetLebarKontainer(), null);
			jPanel3.add(getJTextFieldSetTinggiKontainer(), null);
			jPanel3.add(jLabelSetTinggiKontainer1, null);
			jPanel3.add(jLabelSetTinggiKontainer11, null);
			jPanel3.add(jLabelSetTinggiKontainer111, null);
		}
		return jPanel3;
	}
	
	/**
	 * This method initializes jButtonCancelSetParameter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelSetParameter() {
		if (jButtonCancelSetParameter == null) {
			jButtonCancelSetParameter = new JButton();
			jButtonCancelSetParameter.setRolloverIcon(new ImageIcon(getClass().getResource("/res/iconSetParameters_02.png")));
			jButtonCancelSetParameter.setLocation(new Point(342, 0));
			jButtonCancelSetParameter.setSize(new Dimension(68, 35));
			jButtonCancelSetParameter.setIcon(new ImageIcon(getClass().getResource("/res/iconSetParameter_02.png")));
			jButtonCancelSetParameter
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							jTextFieldSetJumlahGenerasi.setText(String.valueOf(ControlPanel.getJumlahGenerasi()));
							jTextFieldSetJumlahIndividu.setText(String.valueOf(ControlPanel.getJumlahIndividu()));
							jTextFieldSetJumlahIndividuTerseleksi.setText(String.valueOf(ControlPanel.getJumlahIndividuTerseleksi()));
							jTextFieldSetProbabilitasMutasi.setText(String.valueOf(ControlPanel.getProbabilitasMutasi()));
							jTextFieldSetPanjangKontainer.setText(String.valueOf(ControlPanel.getPanjangKontainer()));
							jTextFieldSetLebarKontainer.setText(String.valueOf(ControlPanel.getLebarKontainer()));
							jTextFieldSetTinggiKontainer.setText(String.valueOf(ControlPanel.getTinggiKontainer()));
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return jButtonCancelSetParameter;
	}

	/**
	 * This method initializes jButtonApplySetParameter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonApplySetParameter() {
		if (jButtonApplySetParameter == null) {
			jButtonApplySetParameter = new JButton();
			jButtonApplySetParameter.setRolloverIcon(new ImageIcon(getClass().getResource("/res/iconSetParameters_03.png")));
			jButtonApplySetParameter.setSize(new Dimension(72, 35));
			jButtonApplySetParameter.setLocation(new Point(410, 0));
			jButtonApplySetParameter.setIcon(new ImageIcon(getClass().getResource("/res/iconSetParameter_03.png")));
			jButtonApplySetParameter.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ControlPanel.setJumlahGenerasi(Integer.parseInt(jTextFieldSetJumlahGenerasi.getText().trim()));
					ControlPanel.setJumlahIndividu(Integer.parseInt(jTextFieldSetJumlahIndividu.getText().trim()));
					ControlPanel.setJumlahIndividuTerseleksi(Integer.parseInt(jTextFieldSetJumlahIndividuTerseleksi.getText().trim()));
					ControlPanel.setProbabilitasMutasi(Double.parseDouble(jTextFieldSetProbabilitasMutasi.getText().trim()));
					ControlPanel.setPanjangKontainer(Integer.parseInt(jTextFieldSetPanjangKontainer.getText().trim()));
					ControlPanel.setLebarKontainer(Integer.parseInt(jTextFieldSetLebarKontainer.getText().trim()));
					ControlPanel.setTinggiKontainer(Integer.parseInt(jTextFieldSetTinggiKontainer.getText().trim()));
					ControlPanel.refreshParameter();
					
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonApplySetParameter;
	}
	
	/**
	 * This method initializes jTextFieldSetJumlahGenerasi	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSetJumlahGenerasi() {
		if (jTextFieldSetJumlahGenerasi == null) {
			jTextFieldSetJumlahGenerasi = new JTextField();
			jTextFieldSetJumlahGenerasi.setLocation(new Point(280, 68));
			jTextFieldSetJumlahGenerasi.setSize(new Dimension(54, 20));
		}
		return jTextFieldSetJumlahGenerasi;
	}

	/**
	 * This method initializes jTextFieldSetJumlahIndividu	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSetJumlahIndividu() {
		if (jTextFieldSetJumlahIndividu == null) {
			jTextFieldSetJumlahIndividu = new JTextField();
			jTextFieldSetJumlahIndividu.setLocation(new Point(280, 97));
			jTextFieldSetJumlahIndividu.setSize(new Dimension(54, 20));
		}
		return jTextFieldSetJumlahIndividu;
	}

	/**
	 * This method initializes jTextFieldSetJumlahIndividuTerseleksi	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSetJumlahIndividuTerseleksi() {
		if (jTextFieldSetJumlahIndividuTerseleksi == null) {
			jTextFieldSetJumlahIndividuTerseleksi = new JTextField();
			jTextFieldSetJumlahIndividuTerseleksi.setLocation(new Point(280, 128));
			jTextFieldSetJumlahIndividuTerseleksi.setSize(new Dimension(54, 20));
		}
		return jTextFieldSetJumlahIndividuTerseleksi;
	}

	/**
	 * This method initializes jTextFieldSetProbabilitasMutasi	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSetProbabilitasMutasi() {
		if (jTextFieldSetProbabilitasMutasi == null) {
			jTextFieldSetProbabilitasMutasi = new JTextField();
			jTextFieldSetProbabilitasMutasi.setLocation(new Point(280, 158));
			jTextFieldSetProbabilitasMutasi.setSize(new Dimension(54, 20));
		}
		return jTextFieldSetProbabilitasMutasi;
	}

	/**
	 * This method initializes jTextFieldSetPanjangKontainer	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSetPanjangKontainer() {
		if (jTextFieldSetPanjangKontainer == null) {
			jTextFieldSetPanjangKontainer = new JTextField();
			jTextFieldSetPanjangKontainer.setLocation(new Point(280, 187));
			jTextFieldSetPanjangKontainer.setSize(new Dimension(54, 20));
		}
		return jTextFieldSetPanjangKontainer;
	}

	/**
	 * This method initializes jTextFieldSetLebarKontainer	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSetLebarKontainer() {
		if (jTextFieldSetLebarKontainer == null) {
			jTextFieldSetLebarKontainer = new JTextField();
			jTextFieldSetLebarKontainer.setLocation(new Point(280, 219));
			jTextFieldSetLebarKontainer.setSize(new Dimension(54, 20));
		}
		return jTextFieldSetLebarKontainer;
	}

	/**
	 * This method initializes jTextFieldSetTinggiKontainer	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSetTinggiKontainer() {
		if (jTextFieldSetTinggiKontainer == null) {
			jTextFieldSetTinggiKontainer = new JTextField();
			jTextFieldSetTinggiKontainer.setLocation(new Point(280, 248));
			jTextFieldSetTinggiKontainer.setSize(new Dimension(54, 20));
		}
		return jTextFieldSetTinggiKontainer;
	}
	
	public void tutup(){
		this.setVisible(false);
	}
	
	public void buka(){
		this.setVisible(true);
	}

}//end of class
