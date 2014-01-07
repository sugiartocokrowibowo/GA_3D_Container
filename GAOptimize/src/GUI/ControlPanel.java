package GUI;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */

import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.UIManager;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JLabel;

import Database.Data;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Rectangle;
import javax.swing.JMenuItem;

public class ControlPanel extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	static JPanel jPanel = null;
	
	private JButton jButtonDataBarang = null;

	private JButton jButtonParameterGA = null;

	private JButton jButtonReport = null;

	private JButton jButtonViewDataBarang = null;

	private JButton jButtonInsertDataBarang = null;

	private JButton jButtonUpdateDataBarang = null;

	private JButton jButtonDeleteDataBarang = null;

	private JButton jButtonResetDataBarang = null;

	private JButton jButtonSetParameterGenetika = null;

	private JButton jButtonGO = null;

	private JButton jButtonViewResult = null;
	
	//===========================================================|
	//I N I S I A S I   P A R A M E T E R   G  A
	private static int jumlahGenerasi=4;	
	private static int jumlahIndividu=10;		
	private static int jumlahIndividuTerseleksi=8;	
	private static double probabilitasMutasi=0.01;		
	private static int panjangKontainer=10;	
	private static int lebarKontainer=10;	
	private static int tinggiKontainer=10;
	//===========================================================|
	
	//===========================================================|
	//metode getter and setter parameter genetika
	public static int getJumlahGenerasi() {
		return jumlahGenerasi;
	}

	public static void setJumlahGenerasi(int jumlahGenerasi) {
		ControlPanel.jumlahGenerasi = jumlahGenerasi;
	}

	public static int getJumlahIndividu() {
		return jumlahIndividu;
	}

	public static void setJumlahIndividu(int jumlahIndividu) {
		ControlPanel.jumlahIndividu = jumlahIndividu;
	}

	public static int getJumlahIndividuTerseleksi() {
		return jumlahIndividuTerseleksi;
	}

	public static void setJumlahIndividuTerseleksi(int jumlahIndividuTerseleksi) {
		ControlPanel.jumlahIndividuTerseleksi = jumlahIndividuTerseleksi;
	}

	public static double getProbabilitasMutasi() {
		return probabilitasMutasi;
	}

	public static void setProbabilitasMutasi(double probabilitasMutasi) {
		ControlPanel.probabilitasMutasi = probabilitasMutasi;
	}

	public static int getLebarKontainer() {
		int nilaiKembalian=(int)(ControlPanel.lebarKontainer*0.1);
		return nilaiKembalian;
	}

	public static void setLebarKontainer(int lebarKontainer) {		
		ControlPanel.lebarKontainer = (lebarKontainer*10);
		//Home.lebarKontainer =(lebarKontainer);
	}

	public static int getPanjangKontainer() {
		int nilaiKembalian=(int)(ControlPanel.panjangKontainer*0.1);
		return nilaiKembalian;
	}

	public static void setPanjangKontainer(int panjangKontainer) {
		ControlPanel.panjangKontainer =(panjangKontainer*10);
	}


	public static int getTinggiKontainer() {
		int nilaiKembalian=(int)(ControlPanel.tinggiKontainer*0.1);
		return nilaiKembalian;
	}

	public static void setTinggiKontainer(int tinggiKontainer) {
		ControlPanel.tinggiKontainer = (tinggiKontainer*10);
		//Home.tinggiKontainer=tinggiKontainer;
	}
	//end of metode getter and setter parameter genetika
	
	public void jalankan(String pathApp) throws IOException{
        String cmd = "cmd.exe /k start ";
		Runtime.getRuntime().exec(cmd + pathApp);

    }
	//===========================================================|	

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
//			jPanel = new JPanel();
			jLabelWaktuKomputasi = new JLabel();
			jLabelWaktuKomputasi.setBounds(new Rectangle(16, 500, 191, 14));
			jLabelWaktuKomputasi.setText("Waktu Komputasi");
			jLabelDate = new JLabelTime();
			((JLabelTime) jLabelDate).start();
			jLabelDate.setText("Date");
			jLabelDate.setLocation(new Point(109, 40));
			jLabelDate.setSize(new Dimension(147, 14));
			jPanel = new BackgroundPanel("/res/bg2d.png");
			jPanel.setLayout(null);
			jPanel.setSize(new Dimension(269, 570));
			jPanel.setLocation(new Point(0, 0));
			jPanel.add(jLabelDate, null);
			jPanel.add(getJButtonDataBarang(), null);
			jPanel.add(getJButtonParameterGA(), null);
			jPanel.add(getJButtonReport(), null);
			jPanel.add(getJButtonViewDataBarang(), null);
			jPanel.add(getJButtonInsertDataBarang(), null);
			jPanel.add(getJButtonUpdateDataBarang(), null);
			jPanel.add(getJButtonDeleteDataBarang(), null);
			jPanel.add(getJButtonResetDataBarang(), null);
			jPanel.add(getJButtonSetParameterGenetika(), null);
			jPanel.add(getJButtonGO(), null);
			jPanel.add(getJButtonViewResult(), null);
			jPanel.add(jLabelWaktuKomputasi, null);
		}
		return jPanel;
	}
	
	/**
	 * This method initializes jButtonDataBarang	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDataBarang() {
		if (jButtonDataBarang == null) {
			jButtonDataBarang = new JButton();
			jButtonDataBarang.setLocation(new Point(32, 0));
			jButtonDataBarang.setIcon(new ImageIcon(getClass().getResource("/res/btnPanelA_02.png")));
			jButtonDataBarang.setRolloverIcon(new ImageIcon(getClass().getResource("/res/btnPanelB_02.png")));
			jButtonDataBarang.setSize(new Dimension(68, 42));
			jButtonDataBarang.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.buka();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonDataBarang;
	}
	

	/**
	 * This method initializes jButtonParameterGA	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonParameterGA() {
		if (jButtonParameterGA == null) {
			jButtonParameterGA = new JButton();
			jButtonParameterGA.setLocation(new Point(100, 0));
			jButtonParameterGA.setIcon(new ImageIcon(getClass().getResource("/res/btnPanelA_03.png")));
			jButtonParameterGA.setRolloverIcon(new ImageIcon(getClass().getResource("/res/btnPanelB_03.png")));
			jButtonParameterGA.setSize(new Dimension(93, 42));
			jButtonParameterGA.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.buka();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonParameterGA;
	}

	/**
	 * This method initializes jButtonReport	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonReport() {
		if (jButtonReport == null) {
			jButtonReport = new JButton();
			jButtonReport.setLocation(new Point(193, 0));
			jButtonReport.setIcon(new ImageIcon(getClass().getResource("/res/btnPanelA_04.png")));
			jButtonReport.setRolloverIcon(new ImageIcon(getClass().getResource("/res/btnPanelB_04.png")));
			jButtonReport.setSize(new Dimension(76, 42));
			jButtonReport.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.buka();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonReport;
	}

	/**
	 * This method initializes jButtonViewDataBarang	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonViewDataBarang() {
		if (jButtonViewDataBarang == null) {
			jButtonViewDataBarang = new JButton();
			jButtonViewDataBarang.setLocation(new Point(7, 142));
			jButtonViewDataBarang.setIcon(new ImageIcon(getClass().getResource("/res/btnPanelA_09.png")));
			jButtonViewDataBarang.setRolloverIcon(new ImageIcon(getClass().getResource("/res/btnPanelB_09.png")));
			jButtonViewDataBarang.setMnemonic(KeyEvent.VK_UNDEFINED);
			jButtonViewDataBarang.setSize(new Dimension(198, 32));
			jButtonViewDataBarang.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.buka();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonViewDataBarang;
	}

	/**
	 * This method initializes jButtonInsertDataBarang	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonInsertDataBarang() {
		if (jButtonInsertDataBarang == null) {
			jButtonInsertDataBarang = new JButton();
			jButtonInsertDataBarang.setSize(new Dimension(198, 38));
			jButtonInsertDataBarang.setIcon(new ImageIcon(getClass().getResource("/res/btnPanelA_12.png")));
			jButtonInsertDataBarang.setRolloverIcon(new ImageIcon(getClass().getResource("/res/btnPanelB_12.png")));
			jButtonInsertDataBarang.setLocation(new Point(7, 174));
			jButtonInsertDataBarang.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.buka();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonInsertDataBarang;
	}

	/**
	 * This method initializes jButtonUpdateDataBarang	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonUpdateDataBarang() {
		if (jButtonUpdateDataBarang == null) {
			jButtonUpdateDataBarang = new JButton();
			jButtonUpdateDataBarang.setSize(new Dimension(198, 36));
			jButtonUpdateDataBarang.setIcon(new ImageIcon(getClass().getResource("/res/btnPanelA_15.png")));
			jButtonUpdateDataBarang.setRolloverIcon(new ImageIcon(getClass().getResource("/res/btnPanelB_15.png")));
			jButtonUpdateDataBarang.setLocation(new Point(7, 212));
			jButtonUpdateDataBarang.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.buka();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonUpdateDataBarang;
	}

	/**
	 * This method initializes jButtonDeleteDataBarang	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDeleteDataBarang() {
		if (jButtonDeleteDataBarang == null) {
			jButtonDeleteDataBarang = new JButton();
			jButtonDeleteDataBarang.setSize(new Dimension(198, 37));
			jButtonDeleteDataBarang.setIcon(new ImageIcon(getClass().getResource("/res/btnPanelA_18.png")));
			jButtonDeleteDataBarang.setRolloverIcon(new ImageIcon(getClass().getResource("/res/btnPanelB_18.png")));
			jButtonDeleteDataBarang.setLocation(new Point(7, 248));
			jButtonDeleteDataBarang.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.buka();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonDeleteDataBarang;
	}

	/**
	 * This method initializes jButtonResetDataBarang	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonResetDataBarang() {
		if (jButtonResetDataBarang == null) {
			jButtonResetDataBarang = new JButton();
			jButtonResetDataBarang.setSize(new Dimension(198, 35));
			jButtonResetDataBarang.setRolloverIcon(new ImageIcon(getClass().getResource("/res/btnPanelB_21.png")));
			jButtonResetDataBarang.setIcon(new ImageIcon(getClass().getResource("/res/btnPanelA_21.png")));
			jButtonResetDataBarang.setLocation(new Point(7, 285));
			jButtonResetDataBarang.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					new Data().reset();
					ControlPanel.refreshDataBarang();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonResetDataBarang;
	}

	/**
	 * This method initializes jButtonSetParameterGenetika	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSetParameterGenetika() {
		if (jButtonSetParameterGenetika == null) {
			jButtonSetParameterGenetika = new JButton();
			jButtonSetParameterGenetika.setSize(new Dimension(198, 48));
			jButtonSetParameterGenetika.setIcon(new ImageIcon(getClass().getResource("/res/btnPanelA_24.png")));
			jButtonSetParameterGenetika.setRolloverIcon(new ImageIcon(getClass().getResource("/res/btnPanelB_24.png")));
			jButtonSetParameterGenetika.setLocation(new Point(7, 320));
			jButtonSetParameterGenetika
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							viewDataBarang.tutup();
							insertDataBarang.tutup();
							updateDataBarang.tutup();
							deleteDataBarang.tutup();
							viewParameter.tutup();
							setParameter.buka();
							representasiIndividuTerbaik.tutup();
							report.tutup();
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return jButtonSetParameterGenetika;
	}

	/**
	 * This method initializes jButtonGO	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGO() {
		if (jButtonGO == null) {
			jButtonGO = new JButton();
			jButtonGO.setSize(new Dimension(198, 63));
			jButtonGO.setMnemonic(KeyEvent.VK_UNDEFINED);
			jButtonGO.setIcon(new ImageIcon(getClass().getResource("/res/btnPanelA_27.png")));
			jButtonGO.setRolloverIcon(new ImageIcon(getClass().getResource("/res/btnPanelB_27.png")));
			jButtonGO.setLocation(new Point(7, 368));
			jButtonGO.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					loading.setVisible(true);
					Go();
					
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonGO;
	}

	/**
	 * This method initializes jButtonViewResult	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonViewResult() {
		if (jButtonViewResult == null) {
			jButtonViewResult = new JButton();
			jButtonViewResult.setSize(new Dimension(198, 58));
			jButtonViewResult.setIcon(new ImageIcon(getClass().getResource("/res/btnPanelA_30.png")));
			jButtonViewResult.setRolloverIcon(new ImageIcon(getClass().getResource("/res/btnPanelB_30.png")));
			jButtonViewResult.setLocation(new Point(7, 431));
			jButtonViewResult.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					refreshRepresentasiIndividuTerbaik();
					representasiIndividuTerbaik.buka();
					refreshReport();
					report.tutup();
					try{
						jalankan("Terbaik/individuTerbaik.wrl");
						
					}catch(IOException axc){}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonViewResult;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenuFile());
			jJMenuBar.add(getJMenuDataBarang());
			jJMenuBar.add(getJMenuParameter());
			jJMenuBar.add(getJMenuGo());
			jJMenuBar.add(getJMenuHelp());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenuFile	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuFile() {
		if (jMenuFile == null) {
			jMenuFile = new JMenu();
			jMenuFile.setText("File");
			jMenuFile.add(getJMenuItemOpenAllWindow());
			jMenuFile.add(getJMenuItemCloseAll());
			jMenuFile.add(getJMenuItemExit());
		}
		return jMenuFile;
	}

	/**
	 * This method initializes jMenuDataBarang	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuDataBarang() {
		if (jMenuDataBarang == null) {
			jMenuDataBarang = new JMenu();
			jMenuDataBarang.setText("Data Barang");
			jMenuDataBarang.add(getJMenuItemViewData());
			jMenuDataBarang.add(getJMenuItemInsert());
			jMenuDataBarang.add(getJMenuItemUpdate());
			jMenuDataBarang.add(getJMenuItemDelete());
			jMenuDataBarang.add(getJMenuItemReset());
		}
		return jMenuDataBarang;
	}

	/**
	 * This method initializes jMenuParameter	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuParameter() {
		if (jMenuParameter == null) {
			jMenuParameter = new JMenu();
			jMenuParameter.setText("Parameter");
			jMenuParameter.add(getJMenuItemViewParameter());
			jMenuParameter.add(getJMenuItemSetParameter());
		}
		return jMenuParameter;
	}

	/**
	 * This method initializes jMenuGo	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuGo() {
		if (jMenuGo == null) {
			jMenuGo = new JMenu();
			jMenuGo.setText("GO");
			jMenuGo.add(getJMenuItemProses());
			jMenuGo.add(getJMenuItemVisualisasi());
			jMenuGo.add(getJMenuItemIndividuTerbaik());
			jMenuGo.add(getJMenuItemReport());
		}
		return jMenuGo;
	}

	/**
	 * This method initializes jMenuHelp	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuHelp() {
		if (jMenuHelp == null) {
			jMenuHelp = new JMenu();
			jMenuHelp.setText("Help");
			jMenuHelp.add(getJMenuItemAboutThisApplication());
			jMenuHelp.add(getJMenuItemAboutUs());
		}
		return jMenuHelp;
	}

	/**
	 * This method initializes jMenuItemOpenAllWindow	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemOpenAllWindow() {
		if (jMenuItemOpenAllWindow == null) {
			jMenuItemOpenAllWindow = new JMenuItem();
			jMenuItemOpenAllWindow.setText("Open All Window");
			jMenuItemOpenAllWindow.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.buka();
					insertDataBarang.buka();
					updateDataBarang.buka();
					deleteDataBarang.buka();
					viewParameter.buka();
					setParameter.buka();
					//representasiIndividuTerbaik.buka();
					//report.buka();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemOpenAllWindow;
	}

	/**
	 * This method initializes jMenuItemCloseAll	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemCloseAll() {
		if (jMenuItemCloseAll == null) {
			jMenuItemCloseAll = new JMenuItem();
			jMenuItemCloseAll.setText("Close All But Control Panel");
			jMenuItemCloseAll.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemCloseAll;
	}

	/**
	 * This method initializes jMenuItemExit	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemExit() {
		if (jMenuItemExit == null) {
			jMenuItemExit = new JMenuItem();
			jMenuItemExit.setText("Exit");
			jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(1);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemExit;
	}

	/**
	 * This method initializes jMenuItemViewData	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemViewData() {
		if (jMenuItemViewData == null) {
			jMenuItemViewData = new JMenuItem();
			jMenuItemViewData.setText("View Data Barang");
			jMenuItemViewData.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.buka();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemViewData;
	}

	/**
	 * This method initializes jMenuItemInsert	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemInsert() {
		if (jMenuItemInsert == null) {
			jMenuItemInsert = new JMenuItem();
			jMenuItemInsert.setText("Insert Data Barang");
			jMenuItemInsert.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.buka();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemInsert;
	}

	/**
	 * This method initializes jMenuItemUpdate	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemUpdate() {
		if (jMenuItemUpdate == null) {
			jMenuItemUpdate = new JMenuItem();
			jMenuItemUpdate.setText("Update Data Barang");
			jMenuItemUpdate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.buka();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemUpdate;
	}

	/**
	 * This method initializes jMenuItemDelete	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemDelete() {
		if (jMenuItemDelete == null) {
			jMenuItemDelete = new JMenuItem();
			jMenuItemDelete.setText("Delete Data Barang");
			jMenuItemDelete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.buka();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemDelete;
	}

	/**
	 * This method initializes jMenuItemReset	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemReset() {
		if (jMenuItemReset == null) {
			jMenuItemReset = new JMenuItem();
			jMenuItemReset.setText("Reset Data Barang");
			jMenuItemReset.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					new Data().reset();
					ControlPanel.refreshDataBarang();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemReset;
	}

	/**
	 * This method initializes jMenuItemViewParameter	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemViewParameter() {
		if (jMenuItemViewParameter == null) {
			jMenuItemViewParameter = new JMenuItem();
			jMenuItemViewParameter.setText("View Parameter Algoritma Genetika");
			jMenuItemViewParameter.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.buka();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemViewParameter;
	}

	/**
	 * This method initializes jMenuItemSetParameter	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemSetParameter() {
		if (jMenuItemSetParameter == null) {
			jMenuItemSetParameter = new JMenuItem();
			jMenuItemSetParameter.setText("Set Parameter Algoritma Genetika");
			jMenuItemSetParameter.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.buka();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemSetParameter;
	}

	/**
	 * This method initializes jMenuItemProses	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemProses() {
		if (jMenuItemProses == null) {
			jMenuItemProses = new JMenuItem();
			jMenuItemProses.setText("Proses");
			jMenuItemProses.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					loading.setVisible(true);
					Go();
					
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemProses;
	}

	/**
	 * This method initializes jMenuItemVisualisasi	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemVisualisasi() {
		if (jMenuItemVisualisasi == null) {
			jMenuItemVisualisasi = new JMenuItem();
			jMenuItemVisualisasi.setText("Visualisasi");
			jMenuItemVisualisasi.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.tutup();
					try{
						jalankan("Terbaik/individuTerbaik.wrl");
						
					}catch(IOException axc){}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemVisualisasi;
	}

	/**
	 * This method initializes jMenuItemIndividuTerbaik	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemIndividuTerbaik() {
		if (jMenuItemIndividuTerbaik == null) {
			jMenuItemIndividuTerbaik = new JMenuItem();
			jMenuItemIndividuTerbaik.setText("Solusi Terbaik");
			jMenuItemIndividuTerbaik.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.buka();
					refreshRepresentasiIndividuTerbaik();
					report.tutup();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemIndividuTerbaik;
	}

	/**
	 * This method initializes jMenuItemReport	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemReport() {
		if (jMenuItemReport == null) {
			jMenuItemReport = new JMenuItem();
			jMenuItemReport.setText("Report");
			jMenuItemReport.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewDataBarang.tutup();
					insertDataBarang.tutup();
					updateDataBarang.tutup();
					deleteDataBarang.tutup();
					viewParameter.tutup();
					setParameter.tutup();
					representasiIndividuTerbaik.tutup();
					report.buka();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItemReport;
	}

	/**
	 * This method initializes jMenuItemAboutThisApplication	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemAboutThisApplication() {
		if (jMenuItemAboutThisApplication == null) {
			jMenuItemAboutThisApplication = new JMenuItem();
			jMenuItemAboutThisApplication.setText("About This Application");
		}
		return jMenuItemAboutThisApplication;
	}

	/**
	 * This method initializes jMenuItemAboutUs	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemAboutUs() {
		if (jMenuItemAboutUs == null) {
			jMenuItemAboutUs = new JMenuItem();
			jMenuItemAboutUs.setText("About Us");
		}
		return jMenuItemAboutUs;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ControlPanel thisClass = new ControlPanel();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
				//=======================================================
				viewDataBarang.tutup();
				insertDataBarang.tutup();
				updateDataBarang.tutup();
				deleteDataBarang.tutup();
				viewParameter.tutup();
				//setParameter.tutup();
				representasiIndividuTerbaik.tutup();
				report.tutup();
				//=======================================================				
			}
		});
	}//end of main

	/**
	 * This is the default constructor
	 */
	public ControlPanel() {
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
		this.setSize(269, 580);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("GA Kontainer");
		this.setResizable(false);
		//=======================================================
		viewParameter.tutup();
		viewDataBarang.tutup();
		insertDataBarang.tutup();
		updateDataBarang.tutup();
		deleteDataBarang.tutup();
		loading.setVisible(false);
		//=======================================================	
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
		}
		return jContentPane;
	}
	
	//instantiasi Kotak Dialog	
	public static Loading loading=new Loading();
	public static ViewDataBarang viewDataBarang=new ViewDataBarang();
	public static InsertDataBarang insertDataBarang=new InsertDataBarang();
	public static UpdateDataBarang updateDataBarang=new UpdateDataBarang();
	public static DeleteDataBarang deleteDataBarang=new DeleteDataBarang();
	public static ViewParameter viewParameter=new ViewParameter();
	public static SetParameter setParameter=new SetParameter();
	public static Report report=new Report();
	public static RepresentasiIndividuTerbaik representasiIndividuTerbaik=new RepresentasiIndividuTerbaik();
	//akhir dari instantiasi Kotak dialog

	private JLabel jLabelDate = null;

	private JMenuBar jJMenuBar = null;

	private JMenu jMenuFile = null;

	private JMenu jMenuDataBarang = null;

	private JMenu jMenuParameter = null;

	private JMenu jMenuGo = null;

	private JMenu jMenuHelp = null;

	private JMenuItem jMenuItemOpenAllWindow = null;

	private JMenuItem jMenuItemCloseAll = null;

	private JMenuItem jMenuItemExit = null;

	private JMenuItem jMenuItemViewData = null;

	private JMenuItem jMenuItemInsert = null;

	private JMenuItem jMenuItemUpdate = null;

	private JMenuItem jMenuItemDelete = null;

	private JMenuItem jMenuItemReset = null;

	private JMenuItem jMenuItemViewParameter = null;

	private JMenuItem jMenuItemSetParameter = null;

	private JMenuItem jMenuItemProses = null;

	private JMenuItem jMenuItemVisualisasi = null;

	private JMenuItem jMenuItemIndividuTerbaik = null;

	private JMenuItem jMenuItemReport = null;

	private JMenuItem jMenuItemAboutThisApplication = null;

	private JMenuItem jMenuItemAboutUs = null;

	static JLabel jLabelWaktuKomputasi = null;

	//refreshParameter()
	public static void refreshParameter(){
		viewParameter.dispose();
		viewParameter=new ViewParameter();
		viewParameter.buka();
	}///end of public static void refreshParameter()
	
	//refreshDataBarang()
	public static void refreshDataBarang(){
		viewDataBarang.dispose();
		viewDataBarang=new ViewDataBarang();
		viewDataBarang.buka();
	}///end of public static void refreshParameter()
	
	//refreshRepresentasiIndividuTerbaik()
	public static void refreshRepresentasiIndividuTerbaik(){
		representasiIndividuTerbaik.dispose();
		representasiIndividuTerbaik=new RepresentasiIndividuTerbaik();
		representasiIndividuTerbaik.buka();		
	}//end of refreshRepresentasiIndividuTerbaik()
	
	//refreshReport()
	public static void refreshReport(){
		report.dispose();
		report=new Report();
		report.buka();		
	}//end of refreshReport()
	
	//Go()
	public static void Go(){		
		viewDataBarang.tutup();
		insertDataBarang.tutup();
		updateDataBarang.tutup();
		deleteDataBarang.tutup();
		viewParameter.tutup();
		setParameter.tutup();
		representasiIndividuTerbaik.tutup();
		report.tutup();
		int jumlahGenerasi=ControlPanel.jumlahGenerasi; 
		int jumlahIndividu=ControlPanel.jumlahIndividu; 
		int jumlahIndividuTerseleksi=ControlPanel.jumlahIndividuTerseleksi;
		double probabilitasMutasi=ControlPanel.probabilitasMutasi; 
		int panjangContainer=ControlPanel.panjangKontainer; 
		int lebarContainer=ControlPanel.lebarKontainer;
		int tinggiContainer=ControlPanel.tinggiKontainer;
		GoProsesGenetika goProsesGenetika=new GoProsesGenetika(jumlahGenerasi, jumlahIndividu, jumlahIndividuTerseleksi, probabilitasMutasi, panjangContainer, lebarContainer, tinggiContainer); 		
		goProsesGenetika.execute();
		//GoProsesGenetikaPBar goProsesGenetika=new GoProsesGenetikaPBar(jumlahGenerasi, jumlahIndividu, jumlahIndividuTerseleksi, probabilitasMutasi, panjangContainer, lebarContainer, tinggiContainer); 		
		//goProsesGenetika.execute();
		refreshRepresentasiIndividuTerbaik();representasiIndividuTerbaik.tutup();
		refreshReport();report.tutup();
		//loading.setVisible(false);
		
	}//end of Go()

}
