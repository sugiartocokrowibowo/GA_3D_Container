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
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JTextArea;

public class Report extends JFrame {

	private static final long serialVersionUID = 1L;

	//private JPanel jContentPane = null;
	
	private JPanel jContentPane3 = null;

	private JPanel jPanel3 = null;

	private JButton jButtonAll = null;

	private JButton jButtonTerbaikG = null;

	private JButton jButtonTerbaik = null;

	private JScrollPane jScrollPaneIndividu = null;

	private JTextArea jTextAreaIndividu = null;

	private JScrollPane jScrollPaneFitness = null;

	private JTextArea jTextAreaFitness = null;

	/**
	 * This method initializes jButtonAll	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAll() {
		if (jButtonAll == null) {
			jButtonAll = new JButton();
			jButtonAll.setLocation(new Point(290, 0));
			jButtonAll.setIcon(new ImageIcon(getClass().getResource("/res/reporti_02.png")));
			jButtonAll.setRolloverIcon(new ImageIcon(getClass().getResource("/res/reports_02.png")));
			jButtonAll.setSize(new Dimension(122, 35));
			jButtonAll.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						ReadFileReport individu= new ReadFileReport("Save/individu.txt");					
						jTextAreaIndividu.setText(individu.hasilBacaFile);
						
						ReadFileReport fitnessIndividu=new ReadFileReport("Save/fitness.txt");
						jTextAreaFitness.setText(fitnessIndividu.hasilBacaFile);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonAll;
	}

	/**
	 * This method initializes jButtonTerbaikG	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonTerbaikG() {
		if (jButtonTerbaikG == null) {
			jButtonTerbaikG = new JButton();
			jButtonTerbaikG.setLocation(new Point(412, 0));
			jButtonTerbaikG.setIcon(new ImageIcon(getClass().getResource("/res/reporti_03.png")));
			jButtonTerbaikG.setRolloverIcon(new ImageIcon(getClass().getResource("/res/reports_03.png")));
			jButtonTerbaikG.setSize(new Dimension(181, 35));
			jButtonTerbaikG.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						ReadFileReport individu=new ReadFileReport("Terbaik/individuTerbaikGenerasi.txt");
						jTextAreaIndividu.setText(individu.hasilBacaFile);
						
						ReadFileReport fitnessIndividu=new ReadFileReport("Terbaik/fitnessTerbaikGenerasi.txt");
						jTextAreaFitness.setText(fitnessIndividu.hasilBacaFile);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonTerbaikG;
	}

	/**
	 * This method initializes jButtonTerbaik	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonTerbaik() {
		if (jButtonTerbaik == null) {
			jButtonTerbaik = new JButton();
			jButtonTerbaik.setLocation(new Point(593, 0));
			jButtonTerbaik.setIcon(new ImageIcon(getClass().getResource("/res/reporti_04.png")));
			jButtonTerbaik.setRolloverIcon(new ImageIcon(getClass().getResource("/res/reports_04.png")));
			jButtonTerbaik.setSize(new Dimension(121, 35));
			jButtonTerbaik.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						ReadFileReport individu=new ReadFileReport("Terbaik/individuTerbaik.txt");
						jTextAreaIndividu.setText(individu.hasilBacaFile);
						
						ReadFileReport fitnessIndividu=new ReadFileReport("Terbaik/fitnessIndividuTerbaik.txt");
						jTextAreaFitness.setText(fitnessIndividu.hasilBacaFile);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonTerbaik;
	}

	/**
	 * This method initializes jScrollPaneIndividu	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneIndividu() {
		if (jScrollPaneIndividu == null) {
			jScrollPaneIndividu = new JScrollPane();
			jScrollPaneIndividu.setBounds(new Rectangle(8, 46, 402, 388));
			jScrollPaneIndividu.setBackground(Color.darkGray);
			jScrollPaneIndividu.setViewportView(getJTextAreaIndividu());
			jScrollPaneIndividu.setBorder(BorderFactory.createTitledBorder(null, "Individu", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), Color.white));
		}
		return jScrollPaneIndividu;
	}

	/**
	 * This method initializes jTextAreaIndividu	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaIndividu() {
		if (jTextAreaIndividu == null) {
			jTextAreaIndividu = new JTextArea();
		}
		return jTextAreaIndividu;
	}

	/**
	 * This method initializes jScrollPaneFitness	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneFitness() {
		if (jScrollPaneFitness == null) {
			jScrollPaneFitness = new JScrollPane();
			jScrollPaneFitness.setBounds(new Rectangle(415, 48, 289, 384));
			jScrollPaneFitness.setBorder(BorderFactory.createTitledBorder(null, "Fitness", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), Color.white));
			jScrollPaneFitness.setViewportView(getJTextAreaFitness());
			jScrollPaneFitness.setBackground(Color.darkGray);
		}
		return jScrollPaneFitness;
	}

	/**
	 * This method initializes jTextAreaFitness	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaFitness() {
		if (jTextAreaFitness == null) {
			jTextAreaFitness = new JTextArea();
		}
		return jTextAreaFitness;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Report thisClass = new Report();
				thisClass.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public Report() {
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
		this.setTitle("Report");
		this.setLocation(new Point(286, 12));
		//this.setLocationRelativeTo(null);
		this.setSize(new Dimension(720, 480));
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
			jPanel3 = new BackgroundPanel("/res/report.png");
			jPanel3.setLayout(null);
			jPanel3.setLocation(new Point(0, 0));
			jPanel3.setSize(new Dimension(720, 480));
			jPanel3.add(getJButtonAll(), null);
			jPanel3.add(getJButtonTerbaikG(), null);
			jPanel3.add(getJButtonTerbaik(), null);
			jPanel3.add(getJScrollPaneIndividu(), null);
			jPanel3.add(getJScrollPaneFitness(), null);
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
