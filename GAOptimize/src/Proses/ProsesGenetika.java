package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ProsesGenetika {
	//	i n p u t   (Parameter Algoritma Genetika)   
	int jumlahGenerasi;
	int jumlahIndividu;
	int jumlahIndividuTerseleksi;
	double probabilitasMutasi;	
	int panjangContainer,lebarContainer, tinggiContainer;
	
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
	
	public ProsesGenetika(int jumlahGenerasi, int jumlahIndividu, int jumlahIndividuTerseleksi, double probabilitasMutasi, int panjangContainer, int lebarContainer, int tinggiContainer) {
		super();
		this.jumlahGenerasi = jumlahGenerasi;
		this.jumlahIndividu = jumlahIndividu;
		this.jumlahIndividuTerseleksi = jumlahIndividuTerseleksi;
		this.probabilitasMutasi = probabilitasMutasi;
		this.panjangContainer = panjangContainer;
		this.lebarContainer = lebarContainer;
		this.tinggiContainer = tinggiContainer;
		//awal proses Genetika-------------------------------------------------------------------------------
		//====Inisiasi direktori Save dan file-file untuk menyimpan data====
		// Memeriksa apakah direktori Save eksis
		if (dir.exists() && dir.isDirectory()) {			
			//Mendapatkan objek File (representasi file atau dir)
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
		}else{dir.mkdir();}
		
		//Menciptakan file tempat penyimpanan hasil sementara---	
		try {
			individu			=new FileOutputStream("Save/individu.txt");		
			fitness				=new FileOutputStream("Save/fitness.txt");
			representasiIndividu=new FileOutputStream("Save/representasiIndividu.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//====Akhir proses Inisiasi direktori Save dan file-file untuk menyimpan data====
		
		//Inisiasi Generasi Awal----------------------------
		GenerasiAwal generasi0=new GenerasiAwal(this.jumlahIndividu);		
		Validasi validasi0=new Validasi(generasi0.getIndividuOut(), this.panjangContainer, this.lebarContainer, this.tinggiContainer);
				
		SortingFitness sorting0=new SortingFitness(validasi0.fitnessIndividuOut);
		
		//akhir dari proses	Inisiasi Generasi Awal------------		
		
		//Proses Evolusi Generasi-----------------------------
		int[][][] individuIn=validasi0.individuOut;
		double[][] fitnessIndividuIn=sorting0.fitnessGenerasiOut;
		
		int[][][] individuTG = new int[(this.jumlahGenerasi)][][];		
		double[][] fitnessIndividuTG= new double[(this.jumlahGenerasi)][];
		int[][][] representasiIndividuTG= new int[(this.jumlahGenerasi)][][];
		
		//---------------simpan hasil perolehan sementara ke dalam direktori Save-----------------
		try {
			PrintStream outIndividu				= new PrintStream(individu);
			PrintStream outFitness 				= new PrintStream(fitness);
			PrintStream outRepresentasiIndividu	= new PrintStream(representasiIndividu);
									
			Generasi generasiTerurut=new Generasi(0, individuIn, fitnessIndividuIn, validasi0.representasiIndividuOut);
			outIndividu.println("Generasi Awal ");
			for(int i=0;i<(generasiTerurut.generasiOut.length);i++){
				outIndividu.println("Individu ("+(i+1)+")");
				for(int j=0;j<(generasiTerurut.generasiOut[i].length);j++){
					for(int k=0;k<(generasiTerurut.generasiOut[i][j].length);k++){
						outIndividu.print(generasiTerurut.generasiOut[i][j][k]+":");
					}//end of for k
					outIndividu.println();
				}//end of for j		
				outIndividu.println();
			}//end of for i
			
			outFitness.println("Fitness Generasi Awal");
			outFitness.println("Individu:Fit 1:Fit 1/4:Fit 1/2:Fit 3/4");
			for(int i=0;i<(generasiTerurut.fitnessGenerasiOut.length);i++){
				outFitness.print((i+1)+":");
				for(int j=0;j<(generasiTerurut.fitnessGenerasiOut[i].length);j++){
					outFitness.print(generasiTerurut.fitnessGenerasiOut[i][j]+":");
				}//end of for j
				outFitness.println();
			}//end of for i
						
			outRepresentasiIndividu.println("Representasi Generasi Awal");			
			for(int i=0;i<(generasiTerurut.representasiGenerasiOut.length);i++){
				outRepresentasiIndividu.println("Individu "+(i));
				for(int j=0;j<(generasiTerurut.representasiGenerasiOut[i].length);j++){
					for(int k=0;k<(generasiTerurut.representasiGenerasiOut[i][j].length);k++){
						outRepresentasiIndividu.print(generasiTerurut.representasiGenerasiOut[i][j][k]+":");
					}//end of for k
					outRepresentasiIndividu.println();
				}//end of for j		
				outRepresentasiIndividu.println();
			}//end of for i
			
		//---------------generasi0 telah disimpan ke dalam direktori Save--------------------------
						
		for(int g=1;g<(this.jumlahGenerasi+1);g++){
		System.out.println("Proses "+g);
		ProsesSeleksi seleksi=new ProsesSeleksi(individuIn, fitnessIndividuIn, jumlahIndividuTerseleksi);
		seleksi.start();
		ProsesCrossover crossover=new ProsesCrossover(seleksi.individuOut, this.jumlahIndividu);
		
		ProsesMutasi mutasi=new ProsesMutasi(crossover.individuOut, this.probabilitasMutasi);
		
		Validasi validasi=new Validasi(mutasi.individuOut,this.panjangContainer, this.lebarContainer, this.tinggiContainer);
					
		SortingFitness sorting=new SortingFitness(validasi.fitnessIndividuOut);
					
		individuIn=validasi.individuOut;
		fitnessIndividuIn=sorting.fitnessGenerasiOut;	
		
		Generasi generasiTerurutg=new Generasi(g, individuIn, fitnessIndividuIn, validasi.representasiIndividuOut);		
		//---------------simpan hasil perolehan sementara ke dalam direktori Save-----------------
		outIndividu.println();
		outIndividu.println("Generasi "+g);
		for(int i=0;i<(generasiTerurutg.generasiOut.length);i++){
			outIndividu.println("Individu ("+(i+1)+")");
			for(int j=0;j<(generasiTerurutg.generasiOut[i].length);j++){
				for(int k=0;k<(generasiTerurutg.generasiOut[i][j].length);k++){
					outIndividu.print(generasiTerurutg.generasiOut[i][j][k]+":");
				}//end of for k
				outIndividu.println();
			}//end of for j		
			outIndividu.println();
		}//end of for i
		
		outFitness.println();
		outFitness.println("Fitness Generasi "+g);
		outFitness.println("Individu:Fit 1:Fit 1/4:Fit 1/2:Fit 3/4");
		for(int i=0;i<(generasiTerurutg.fitnessGenerasiOut.length);i++){
			outFitness.print((i+1)+":");
			for(int j=0;j<(generasiTerurutg.fitnessGenerasiOut[i].length);j++){
				outFitness.print(generasiTerurutg.fitnessGenerasiOut[i][j]+":");
			}//end of for j
			outFitness.println();
		}//end of for i
		
		outRepresentasiIndividu.println();
		outRepresentasiIndividu.println("Representasi Individu Generasi "+g);			
		for(int i=0;i<(generasiTerurutg.representasiGenerasiOut.length);i++){
			outRepresentasiIndividu.println("Individu "+(i));
			for(int j=0;j<(generasiTerurutg.representasiGenerasiOut[i].length);j++){
				for(int k=0;k<(generasiTerurutg.representasiGenerasiOut[i][j].length);k++){
					outRepresentasiIndividu.print(generasiTerurutg.representasiGenerasiOut[i][j][k]+":");
				}//end of for k
				outRepresentasiIndividu.println();
			}//end of for j		
			outRepresentasiIndividu.println();
		}//end of for i		
		
		individuTG[g-1]				=generasiTerurut.generasiOut[0].clone();
		representasiIndividuTG[g-1]	=generasiTerurut.representasiGenerasiOut[0].clone();
		fitnessIndividuTG[g-1]		=generasiTerurut.fitnessGenerasiOut[0].clone();
		//---------------generasi0 telah disimpan ke dalam direktori Save-------------------------
		
		}//end of for(int g=1;g<(this.jumlahGenerasi+1);g++)		
				
		this.individuTerbaikGenerasiOut=individuTG;		
		this.fitnessIndividuTerbaikGenerasiOut=fitnessIndividuTG;
		this.representasiIndividuTerbaikGenerasiOut=representasiIndividuTG;
				
		//Close File
		outIndividu.close();
		outFitness.close();
		outRepresentasiIndividu.close();		
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		//Akhir dari Proses Evolusi Generasi------------------
		
		SortingFitness sortingTerbaikGenerasi=new SortingFitness(this.fitnessIndividuTerbaikGenerasiOut);
					
		GenerasiTerbaik gt=new GenerasiTerbaik(this.individuTerbaikGenerasiOut, sortingTerbaikGenerasi.fitnessGenerasiOut, this.representasiIndividuTerbaikGenerasiOut);
		this.individuTerbaik=gt.generasiOut[0].clone();		
		this.fitnessIndividuTerbaik=gt.fitnessGenerasiOut[0].clone();
		this.representasiIndividuTerbaik=gt.representasiGenerasiOut[0].clone();
		
		//menyimpan hasil Individu terbaik ke file dalam direktori Terbaik
		//Memeriksa apakah direktori Save eksis
		if (dir1.exists() && dir1.isDirectory()) {			
			//Mendapatkan objek File (representasi file atau dir)
			File[] fls = dir1.listFiles();
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
		}else{dir1.mkdir();}
		
		//Menciptakan file tempat penyimpanan Individu terbaik---	
		try {
			individuTerbaikGenerasi				=new FileOutputStream("Terbaik/individuTerbaikGenerasi.txt");		
			fitnessTerbaikGenerasi				=new FileOutputStream("Terbaik/fitnessTerbaikGenerasi.txt");
			representasiIndividuTerbaikGenerasi	=new FileOutputStream("Terbaik/representasiIndividuTerbaikGenerasi.txt");
			individuTerbaikf					=new FileOutputStream("Terbaik/individuTerbaik.txt");
			fitnessIndividuTerbaikf				=new FileOutputStream("Terbaik/fitnessIndividuTerbaik.txt");
			representasiIndividuTerbaikf		=new FileOutputStream("Terbaik/representasiIndividuTerbaik.txt");
			visualisasiIndividuTerbaik			=new FileOutputStream("Terbaik/individuTerbaik.wrl");
			/*
			FileOutputStream individuTerbaikGenerasi,fitnessTerbaikGenerasi,representasiIndividuTerbaikGenerasi;
			FileOutputStream individuTerbaikf,fitnessIndividuTerbaikf,representasiIndividuTerbaikf;
			FileOutputStream visualisasiIndividuTerbaik;
			*/
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
				outfitnessTerbaikGenerasi.print((1+i)+":");
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
			for(int i=0;i<(this.fitnessIndividuTerbaik.length-1);i++){				
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
		/////////////////////////////////////////////
		//akhir proses Genetika------------------------------------------------------------------------------
	}
	
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

}//end of class ProsesGenetika
