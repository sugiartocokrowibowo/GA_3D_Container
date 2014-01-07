package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
public class Generasi {
	
	int nomorGenerasi;//index nomor generasi
	
	//	input
	int[][][] generasiIn;
	double[][] fitnessGenerasiIn;//fitness input adalah fitness yang telah di sorting
	int[][][] representasiGenerasiIn;
	
	//	output
	public int[][][] generasiOut;
	public double[][] fitnessGenerasiOut;//fitness output = fitnes input
	public int[][][] representasiGenerasiOut;
	
	public Generasi(int nomorGenerasi, int[][][] generasiIn, double[][] fitnessGenerasiIn, int[][][] representasiGenerasiIn) {
		super();
		this.nomorGenerasi = nomorGenerasi;
		this.generasiIn = generasiIn;
		this.fitnessGenerasiIn = fitnessGenerasiIn;
		this.representasiGenerasiIn = representasiGenerasiIn;
		
		//----melakukan proses dlm metode konstruktor-----
		int jumlahIndividu=this.fitnessGenerasiIn.length;
		int[] indexFitness=new int[jumlahIndividu];
		for(int i=0;i<jumlahIndividu;i++){
			indexFitness[i]=(int) this.fitnessGenerasiIn[i][4];
		}
		
		//menyusun kembali individu dalam Generasi bedasarkan nilai fitness yang telah di urutkan
		//Individu dengan nilai fitness terbaik ada pada urutan pertama		
		this.generasiOut=new int[jumlahIndividu][2][];
		this.fitnessGenerasiOut=new double[jumlahIndividu][4];
		this.representasiGenerasiOut=new int[jumlahIndividu][9][];
		for(int ic=0;ic<jumlahIndividu;ic++){			
			for(int a=0;a<4;a++){this.fitnessGenerasiOut[ic][a]=this.fitnessGenerasiIn[ic][a];}
			int index=indexFitness[ic];
			for(int ha=0;ha<2;ha++){
				this.generasiOut[ic][ha]=this.generasiIn[index][ha].clone();
			}//end of for(int ha=0;ha<2;ha++)
			for(int ha=0;ha<9;ha++){
				this.representasiGenerasiOut[ic][ha]=this.representasiGenerasiIn[index][ha].clone();				
			}//end of for(int ha=0;ha<2;ha++)
		}//end of for(int ic=0;ic<jumlahIndividu;ic++)
		//----proses selesai---------------------------------
	}

	public int[][][] getGenerasiOut() {
		return generasiOut;
	}

	public double[][] getFitnessGenerasiOut() {
		return fitnessGenerasiOut;
	}

	public int[][][] getRepresentasiGenerasiOut() {
		return representasiGenerasiOut;
	}	

}//end of class generasi
