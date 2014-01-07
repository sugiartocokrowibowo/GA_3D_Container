package GUI;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */

import java.awt.Cursor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

import javax.swing.SwingWorker;

import Proses.Generasi;
import Proses.GenerasiAwal;
import Proses.ProsesCrossover;
import Proses.ProsesMutasi;
import Proses.ProsesSeleksi;
import Proses.SortingFitness;
import Proses.VRMLContainer;
import Proses.Validasi;

public class GoProsesGenetika extends SwingWorker {	
	//	i n p u t   (Parameter Algoritma Genetika)   
	int jumlahGenerasi;
	int jumlahIndividu;
	int jumlahIndividuTerseleksi;
	double probabilitasMutasi;	
	int panjangContainer,lebarContainer, tinggiContainer;
	
	/////////////////////////////////////////////////////////
	double waktuKomputasi=0;	
	
	////////////////////////////////////////////////////////
	//output proses evolusi genetik akan disimpan dalam file dalam folder Save	
	File dir = new File("Save");
	FileOutputStream individu,fitness,representasiIndividu;	
	
	File dir1 = new File("Terbaik");
	FileOutputStream individuTerbaikGenerasi,fitnessTerbaikGenerasi,representasiIndividuTerbaikGenerasi;
	FileOutputStream individuTerbaikf,fitnessIndividuTerbaikf,representasiIndividuTerbaikf;
	FileOutputStream visualisasiIndividuTerbaik;
	
	//o u t p u t
	int[][][] individuTerbaikGenerasiOut;		
	double[][] fitnessIndividuTerbaikGenerasiOut;
	int[][][] representasiIndividuTerbaikGenerasiOut;
	
	int[][] individuTerbaik;		
	double[] fitnessIndividuTerbaik;
	int[][] representasiIndividuTerbaik;
	
	
	@Override
	//menjalankan thread di background
	protected Void doInBackground() throws Exception {
		float stepPoint=100/this.jumlahGenerasi;
		ControlPanel.jLabelWaktuKomputasi.setText("Waktu Komputasi: "+this.waktuKomputasi+" detik");
		ControlPanel.jPanel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		ControlPanel.jLabelWaktuKomputasi.setText("Proses: Begin...");
		Date waktu1=new Date();long waktuMulai=waktu1.getTime();
		//--reset Directory--
		reset();
		//Menciptakan file tempat penyimpanan hasil ---	
		try {
			individu			=new FileOutputStream("Save/individu.txt");		
			fitness				=new FileOutputStream("Save/fitness.txt");
			representasiIndividu=new FileOutputStream("Save/representasiIndividu.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[][][] individuTerbaikGenerasii = new int[(this.jumlahGenerasi+1)][][];		
		double[][] fitnessTerbaikGenerasii= new double[(this.jumlahGenerasi+1)][];
		int[][][] representasiIndividuTerbaikGenerasii= new int[(this.jumlahGenerasi+1)][][];
		
		//Inisiasi Generasi Awal----------------------------
		GenerasiAwal generasi0=new GenerasiAwal(this.jumlahIndividu);		
		Validasi validasi0=new Validasi(generasi0.getIndividuOut(), this.panjangContainer, this.lebarContainer, this.tinggiContainer);
		SortingFitness sorting0=new SortingFitness(validasi0.getFitnessIndividuOut());
		//akhir dari proses	Inisiasi Generasi Awal------------	
		
		//Proses Evolusi Generasi-----------------------------
		int[][][] individuIn=validasi0.getIndividuOut();
		double[][] fitnessIndividuIn=sorting0.getFitnessGenerasiOut();
		Generasi generasi=new Generasi(0, individuIn, fitnessIndividuIn, validasi0.getRepresentasiIndividuOut());
			
		//---------------simpan hasil perolehan sementara ke dalam direktori Save-----------------
		try {
			PrintStream outIndividu				= new PrintStream(individu);
			PrintStream outFitness 				= new PrintStream(fitness);
			PrintStream outRepresentasiIndividu	= new PrintStream(representasiIndividu);
			outIndividu.println("Generasi Awal ");
			for(int i=0;i<(generasi.generasiOut.length);i++){
				outIndividu.println("Individu ("+(i+1)+")");
				for(int j=0;j<(generasi.generasiOut[i].length);j++){
					for(int k=0;k<(generasi.generasiOut[i][j].length);k++){
						outIndividu.print(generasi.generasiOut[i][j][k]+":");
					}//end of for k
					outIndividu.println();
				}//end of for j		
				outIndividu.println();
			}//end of for i
			
			outFitness.println("Fitness Generasi Awal");
			outFitness.println("Individu:Fit 1:Fit 1/4:Fit 1/2:Fit 3/4");
			for(int i=0;i<(generasi.fitnessGenerasiOut.length);i++){
				outFitness.print((i+1)+":");
				for(int j=0;j<(generasi.fitnessGenerasiOut[i].length);j++){
					outFitness.print(generasi.fitnessGenerasiOut[i][j]+":");
				}//end of for j
				outFitness.println();
			}//end of for i
						
			outRepresentasiIndividu.println("Representasi Generasi Awal");			
			for(int i=0;i<(generasi.representasiGenerasiOut.length);i++){
				outRepresentasiIndividu.println("Individu "+(i));
				for(int j=0;j<(generasi.representasiGenerasiOut[i].length);j++){
					for(int k=0;k<(generasi.representasiGenerasiOut[i][j].length);k++){
						outRepresentasiIndividu.print(generasi.representasiGenerasiOut[i][j][k]+":");
					}//end of for k
					outRepresentasiIndividu.println();
				}//end of for j		
				outRepresentasiIndividu.println();
			}//end of for i
			
			individuTerbaikGenerasii[0]=generasi.generasiOut[0].clone(); 		
			fitnessTerbaikGenerasii[0]=generasi.fitnessGenerasiOut[0].clone(); 
			representasiIndividuTerbaikGenerasii[0]=generasi.representasiGenerasiOut[0].clone(); 
			//save individu terbaik- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
			individuTerbaik=individuTerbaikGenerasii[0];		
			fitnessIndividuTerbaik=fitnessTerbaikGenerasii[0];
			representasiIndividuTerbaik=representasiIndividuTerbaikGenerasii[0];
		
		//iterasi Generasi ke-g-----------------------------------------------------------------------------
		for(int g=1;g<(this.jumlahGenerasi+1);g++){
			System.out.println("Proses: Generasi Ke-"+g);
			ControlPanel.jLabelWaktuKomputasi.setText("Proses: Generasi Ke-"+g);
			ProsesSeleksi seleksi=new ProsesSeleksi(individuIn, fitnessIndividuIn, jumlahIndividuTerseleksi);
			ControlPanel.jLabelWaktuKomputasi.setText("Proses: Generasi Ke-"+g+"...");
			ProsesCrossover crossover=new ProsesCrossover(seleksi.getIndividuOut(), this.jumlahIndividu);
			//ControlPanel.jLabelWaktuKomputasi.setText("Proses: Generasi Ke-"+g+".");
			ProsesMutasi mutasi=new ProsesMutasi(crossover.getIndividuOut(), this.probabilitasMutasi);
			//ControlPanel.jLabelWaktuKomputasi.setText("Proses: Generasi Ke-"+g+"......");
			Validasi validasi=new Validasi(mutasi.getIndividuOut(),this.panjangContainer, this.lebarContainer, this.tinggiContainer);
			//ControlPanel.jLabelWaktuKomputasi.setText("Proses: Generasi Ke-"+g+"...");
			SortingFitness sorting=new SortingFitness(validasi.getFitnessIndividuOut());
			//ControlPanel.jLabelWaktuKomputasi.setText("Proses: Generasi Ke-"+g+".............");
			individuIn=validasi.getIndividuOut();
			ControlPanel.jLabelWaktuKomputasi.setText("Proses: Generasi Ke-"+g+".....");
			fitnessIndividuIn=sorting.getFitnessGenerasiOut();
			ControlPanel.jLabelWaktuKomputasi.setText("Proses: Generasi Ke-"+g+"...........");
			generasi=new Generasi(g, individuIn, fitnessIndividuIn, validasi.getRepresentasiIndividuOut());		
			
			//-------------------
			ControlPanel.jLabelWaktuKomputasi.setText("Proses: Generasi Ke-"+g);
			//ControlPanel.jLabelWaktuKomputasi.setText("Progress: "+(100*(g/this.jumlahGenerasi))+"%");
			//---Save------------
			//---------------simpan hasil perolehan sementara ke dalam direktori Save-----------------
			outIndividu.println();
			outIndividu.println("Generasi "+g);
			for(int i=0;i<(generasi.generasiOut.length);i++){
				outIndividu.println("Individu ("+(i+1)+")");
				for(int j=0;j<(generasi.generasiOut[i].length);j++){
					for(int k=0;k<(generasi.generasiOut[i][j].length);k++){
						outIndividu.print(generasi.generasiOut[i][j][k]+":");
					}//end of for k
					outIndividu.println();
				}//end of for j		
				outIndividu.println();
			}//end of for i
			
			outFitness.println();
			outFitness.println("Fitness Generasi "+g);
			outFitness.println("Individu:Fit 1:Fit 1/4:Fit 1/2:Fit 3/4");
			for(int i=0;i<(generasi.fitnessGenerasiOut.length);i++){
				outFitness.print((i+1)+":");
				for(int j=0;j<(generasi.fitnessGenerasiOut[i].length);j++){
					outFitness.print(generasi.fitnessGenerasiOut[i][j]+":");
				}//end of for j
				outFitness.println();
			}//end of for i
			
			outRepresentasiIndividu.println();
			outRepresentasiIndividu.println("Representasi Individu Generasi "+g);			
			for(int i=0;i<(generasi.representasiGenerasiOut.length);i++){
				outRepresentasiIndividu.println("Individu "+(i));
				for(int j=0;j<(generasi.representasiGenerasiOut[i].length);j++){
					for(int k=0;k<(generasi.representasiGenerasiOut[i][j].length);k++){
						outRepresentasiIndividu.print(generasi.representasiGenerasiOut[i][j][k]+":");
					}//end of for k
					outRepresentasiIndividu.println();
				}//end of for j		
				outRepresentasiIndividu.println();
			}//end of for i					
			//---End Of Save-----
			
			individuTerbaikGenerasii[g]=generasi.generasiOut[0].clone(); 		
			fitnessTerbaikGenerasii[g]=generasi.fitnessGenerasiOut[0].clone(); 
			representasiIndividuTerbaikGenerasii[g]=generasi.representasiGenerasiOut[0].clone(); 			
			//seleksi dan save individu terbaik- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
			boolean tukar=false;
			if(fitnessIndividuTerbaik[0]<fitnessTerbaikGenerasii[g][0]){tukar=true;}//end of if(fitnessIndividuTerbaik[0]<fitnessTerbaikGenerasii[g][0])
			if(fitnessIndividuTerbaik[0]==fitnessTerbaikGenerasii[g][0]){
				if(fitnessIndividuTerbaik[1]<fitnessTerbaikGenerasii[g][1]){tukar=true;}//end of if(fitnessIndividuTerbaik[1]<fitnessTerbaikGenerasii[g][1])
				if(fitnessIndividuTerbaik[1]==fitnessTerbaikGenerasii[g][1]){
					if(fitnessIndividuTerbaik[2]<fitnessTerbaikGenerasii[g][2]){tukar=true;}//end of if(fitnessIndividuTerbaik[2]<fitnessTerbaikGenerasii[g][2])
					if(fitnessIndividuTerbaik[2]==fitnessTerbaikGenerasii[g][2]){
						if(fitnessIndividuTerbaik[3]<fitnessTerbaikGenerasii[g][3]){tukar=true;}//end of if(fitnessIndividuTerbaik[3]<fitnessTerbaikGenerasii[g][3])
					}//end of if(fitnessIndividuTerbaik[2]==fitnessTerbaikGenerasii[g][2])
				}//end of if(fitnessIndividuTerbaik[1]==fitnessTerbaikGenerasii[g][1])
			}//end of if(fitnessIndividuTerbaik[0]=fitnessTerbaikGenerasii[g][0])
			if(tukar==true){
				individuTerbaik=individuTerbaikGenerasii[g];		
				fitnessIndividuTerbaik=fitnessTerbaikGenerasii[g];
				representasiIndividuTerbaik=representasiIndividuTerbaikGenerasii[g];
			}//catat data individu terbaik yang baru			
			
		}//end of for(int g=1;g<(this.jumlahGenerasi+1);g++)-------------------------------------------------
		
		this.individuTerbaikGenerasiOut=individuTerbaikGenerasii;		
		this.fitnessIndividuTerbaikGenerasiOut=fitnessTerbaikGenerasii;
		this.representasiIndividuTerbaikGenerasiOut=representasiIndividuTerbaikGenerasii;
		
		
		//Close File
		outIndividu.close();
		outFitness.close();
		outRepresentasiIndividu.close();		
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		//end of simpan individu
		
		///- - - - - - - - -  - -
		//Menciptakan file tempat penyimpanan Individu terbaik---	
		try {
			individuTerbaikGenerasi				=new FileOutputStream("Terbaik/individuTerbaikGenerasi.txt");		
			fitnessTerbaikGenerasi				=new FileOutputStream("Terbaik/fitnessTerbaikGenerasi.txt");
			representasiIndividuTerbaikGenerasi	=new FileOutputStream("Terbaik/representasiIndividuTerbaikGenerasi.txt");
			individuTerbaikf					=new FileOutputStream("Terbaik/individuTerbaik.txt");
			fitnessIndividuTerbaikf				=new FileOutputStream("Terbaik/fitnessIndividuTerbaik.txt");
			representasiIndividuTerbaikf		=new FileOutputStream("Terbaik/representasiIndividuTerbaik.txt");
			visualisasiIndividuTerbaik			=new FileOutputStream("Terbaik/individuTerbaik.wrl");
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		//memulai menuliskan data ke dalam file yang telah dideklarasikan
		try {
			PrintStream outindividuTerbaikGenerasi				= new PrintStream(individuTerbaikGenerasi);
			PrintStream outfitnessTerbaikGenerasi				= new PrintStream(fitnessTerbaikGenerasi);
			PrintStream outrepresentasiIndividuTerbaikGenerasi	= new PrintStream(representasiIndividuTerbaikGenerasi);
			PrintStream outindividuTerbaik						= new PrintStream(individuTerbaikf);
			PrintStream outfitnessIndividuTerbaik				= new PrintStream(fitnessIndividuTerbaikf);
			PrintStream outrepresentasiIndividuTerbaik			= new PrintStream(representasiIndividuTerbaikf);
			PrintStream outvisualisasiIndividuTerbaik			= new PrintStream(visualisasiIndividuTerbaik);
			
			//menuliskan data outindividuTerbaikGenerasi			
			outindividuTerbaikGenerasi.println("Individu Terbaik Generasi");
			for(int i=0;i<(this.individuTerbaikGenerasiOut.length);i++){
				outindividuTerbaikGenerasi.println("Generasi ("+(i+1)+")");
				for(int j=0;j<(this.individuTerbaikGenerasiOut[i].length);j++){
					for(int k=0;k<(this.individuTerbaikGenerasiOut[i][j].length);k++){
						outindividuTerbaikGenerasi.print(this.individuTerbaikGenerasiOut[i][j][k]+":");
					}//end of for k
					outindividuTerbaikGenerasi.println();
				}//end of for j		
				outindividuTerbaikGenerasi.println();
			}//end of for i
			
			//menuliskan data outfitnessTerbaikGenerasi
			outfitnessTerbaikGenerasi.println("Fitness Terbaik Generasi");
			outfitnessTerbaikGenerasi.println("Generasi:Fit 1:Fit 1/4:Fit 1/2:Fit 3/4");
			for(int i=0;i<(this.fitnessIndividuTerbaikGenerasiOut.length);i++){
				outfitnessTerbaikGenerasi.print((i)+":");//(1+i)
				for(int j=0;j<(this.fitnessIndividuTerbaikGenerasiOut[i].length);j++){
					outfitnessTerbaikGenerasi.print(this.fitnessIndividuTerbaikGenerasiOut[i][j]+":");
				}//end of for j
				outfitnessTerbaikGenerasi.println();
			}//end of for i
			
			//menuliskan data outrepresentasiIndividuTerbaikGenerasi
			outrepresentasiIndividuTerbaikGenerasi.println("Representasi Individu Terbaik Generasi ");			
			for(int i=0;i<(this.representasiIndividuTerbaikGenerasiOut.length);i++){
				outrepresentasiIndividuTerbaikGenerasi.println("Individu Terbaik Generasi "+(i+1));
				for(int j=0;j<(this.representasiIndividuTerbaikGenerasiOut[i].length);j++){
					for(int k=0;k<(this.representasiIndividuTerbaikGenerasiOut[i][j].length);k++){
						outrepresentasiIndividuTerbaikGenerasi.print(this.representasiIndividuTerbaikGenerasiOut[i][j][k]+":");
					}//end of for k
					outrepresentasiIndividuTerbaikGenerasi.println();
				}//end of for j		
				outrepresentasiIndividuTerbaikGenerasi.println();
			}//end of for i	
			
			//-------------------------------------------------------------------
			//menuliskan data outindividuTerbaik
			outindividuTerbaik.println("Individu Terbaik");
			for(int i=0;i<(this.individuTerbaik.length);i++){
				for(int j=0;j<(this.individuTerbaik[i].length);j++){
					outindividuTerbaik.print(this.individuTerbaik[i][j]+":");
				}//end of for j		
				outindividuTerbaik.println();
			}//end of for i
			
			//menuliskan data outfitnessIndividuTerbaik
			outfitnessIndividuTerbaik.println("Fitness Terbaik");
			outfitnessIndividuTerbaik.println("Fit 1:Fit 1/4:Fit 1/2:Fit 3/4");
			for(int i=0;i<(this.fitnessIndividuTerbaik.length);i++){				
				outfitnessIndividuTerbaik.print(this.fitnessIndividuTerbaik[i]+":");				
			}//end of for i
			
			//menuliskan data outrepresentasiIndividuTerbaik
			outrepresentasiIndividuTerbaik.println("Representasi Individu Terbaik");
			for(int i=0;i<(this.representasiIndividuTerbaik.length);i++){
				for(int j=0;j<(this.representasiIndividuTerbaik[i].length);j++){
					outrepresentasiIndividuTerbaik.print(this.representasiIndividuTerbaik[i][j]+":");
				}//end of for j		
				outrepresentasiIndividuTerbaik.println();
			}//end of for i
			
			//menuliskan data outvisualisasiIndividuTerbaik
			VRMLContainer Kontainer=new VRMLContainer(this.representasiIndividuTerbaik,this.panjangContainer,this.lebarContainer,this.tinggiContainer);
			String visualisasi=Kontainer.visualisasi;
			outvisualisasiIndividuTerbaik.print(visualisasi);
			//menutup file---------------------------------
			
			//menutup file-------------------------------------------------------
			outindividuTerbaikGenerasi.close();
			outfitnessTerbaikGenerasi.close();
			outrepresentasiIndividuTerbaikGenerasi.close();
			outindividuTerbaik.close();
			outfitnessIndividuTerbaik.close();
			outrepresentasiIndividuTerbaik.close();
			outvisualisasiIndividuTerbaik.close();	
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}		
		//akhir proses penyimpanan Individu terbaik ke file	
		
		//hitung waktu komputasi
		Date waktu2=new Date();long waktuSelesai=waktu2.getTime();
		long selisihWaktu=waktuSelesai-waktuMulai;
		this.waktuKomputasi=(selisihWaktu/1000);	
		
		ControlPanel.loading.setVisible(false);		
		return null;		
	}//end doInBackground()

	public GoProsesGenetika(int jumlahGenerasi, int jumlahIndividu, int jumlahIndividuTerseleksi, double probabilitasMutasi, int panjangContainer, int lebarContainer, int tinggiContainer) {
		super();
		this.jumlahGenerasi = jumlahGenerasi;
		this.jumlahIndividu = jumlahIndividu;
		this.jumlahIndividuTerseleksi = jumlahIndividuTerseleksi;
		this.probabilitasMutasi = probabilitasMutasi;
		this.panjangContainer = panjangContainer;
		this.lebarContainer = lebarContainer;
		this.tinggiContainer = tinggiContainer;
		//this.execute();
	}

	public void done(){
		ControlPanel.jLabelWaktuKomputasi.setText("Waktu Komputasi: "+this.waktuKomputasi+" detik");
		ControlPanel.jPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		ControlPanel.loading.setVisible(false);
	}//end of done()
	
	
	//////////////////////////////////////////////////////////////
	//metode-metode getter
	public int[][][] getIndividuTerbaikGenerasiOut() {
		return individuTerbaikGenerasiOut;
	}

	public double[][] getFitnessIndividuTerbaikGenerasiOut() {
		return fitnessIndividuTerbaikGenerasiOut;
	}

	public int[][][] getRepresentasiIndividuTerbaikGenerasiOut() {
		return representasiIndividuTerbaikGenerasiOut;
	}

	public int[][] getIndividuTerbaik() {
		return individuTerbaik;
	}

	public double[] getFitnessIndividuTerbaik() {
		return fitnessIndividuTerbaik;
	}

	public int[][] getRepresentasiIndividuTerbaik() {
		return representasiIndividuTerbaik;
	}	
	
	//////////////////////////////////////////////////////////////
	public static boolean delDir(File dir) {//---------------------------------------------------------------
		if (dir.exists()) {
			// Mendapatkan objek File (representasi file atau dir)
			File[] fls = dir.listFiles();

			for (File fl : fls) {
			// Jika direktori, proses secara rekursif
			// Guna mengetahui apakah ada isinya
				if (fl.isDirectory()) {
					 delDir(fl);
				} else {
					// Hapus file atau direktori tunggal
					 fl.delete();
				}
			}
		}
		return dir.delete();
	}//------------------------------------------------------------------------------------------------------

	public void reset(){
		// Memeriksa apakah direktori Save eksis
		if (dir.exists() && dir.isDirectory()) {
		}else{dir.mkdir();}
		///------------------------------------------------------
		if (dir1.exists() && dir1.isDirectory()) {		
		}else{dir1.mkdir();}
	}//end of reset()
	
	
	
}//end of class GoProsesGenetikaPBar
