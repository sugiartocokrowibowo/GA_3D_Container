package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
public class ProsesSeleksi {
	int[][][] individuIn;
	double[][] fitnessIndividuIn;//fitness yang telah disorting
	int jumlahIndividuTerseleksi;
	//-------------------------------
	public int[][][] individuOut;
	
	public ProsesSeleksi(int[][][] individuIn, double[][] fitnessIndividuIn, int jumlahIndividuTerseleksi) {
		super();
		this.individuIn = individuIn;
		this.fitnessIndividuIn = fitnessIndividuIn;
		this.jumlahIndividuTerseleksi = jumlahIndividuTerseleksi;
		//awal proses seleksi------------------------------------------------------------------------------
		int jumlahIndividu=this.fitnessIndividuIn.length;
		
		int[] cek=new int[jumlahIndividu];
		
		int[] indexFitness=new int[jumlahIndividu];
		for(int i=0;i<jumlahIndividu;i++){
			indexFitness[i]=(int) this.fitnessIndividuIn[i][4];
		}
		
		double[] fitnessKomulatif=new double[jumlahIndividu];		
		fitnessKomulatif[0]=this.fitnessIndividuIn[0][0];
		for(int i=1;i<jumlahIndividu;i++){
			fitnessKomulatif[i]=fitnessKomulatif[i-1]+this.fitnessIndividuIn[i][0];			
		}
		double fitnessTotal=fitnessKomulatif[(jumlahIndividu-1)];
		
		int[] indexIndividuTerseleksi=new int[this.jumlahIndividuTerseleksi];
		
		int terseleksi=0;
		while(terseleksi<this.jumlahIndividuTerseleksi){
			double fitnessRandom=fitnessTotal*Math.random();
			
			int terpilih=0;
			for(int i=0;i<jumlahIndividu;i++){
				if(fitnessRandom<=fitnessKomulatif[i]){
					terpilih=i;
					break;
				}//end of 
			}//end of for(int i=0;i<jumlahIndividu;i++)
			
			if (cek[terpilih]!=1){
				indexIndividuTerseleksi[terseleksi]=indexFitness[terpilih];
				cek[terpilih]=1;				
				if(this.individuIn[indexIndividuTerseleksi[terseleksi]][0].length>0){//kromosom dg panjang=0 (jika ada) sudah pasti tidak lolos seleksi.
					terseleksi++;
				}//end of if(this.individuIn[indexIndividuTerseleksi[terseleksi]][0].length>0)
			}//end of if (cek[terpilih]!=1)
			
		}//end of while(terseleksi<this.jumlahKromosomTerseleksi) 
		
		//menyusun kembali individu yang terseleksi berdasarkan indeksIndividuTerseleksi
		this.individuOut=new int[this.jumlahIndividuTerseleksi][2][];
		for(int ic=0;ic<this.jumlahIndividuTerseleksi;ic++){
			for(int ha=0;ha<2;ha++){
				int a=indexIndividuTerseleksi[ic];
				//this.individuOut[ic][ha]=new int[this.individuIn[a][ha].length];
				this.individuOut[ic][ha]=this.individuIn[a][ha].clone();
			}//end of for(int ha=0;ha<2;ha++)
		}//end of for(int ic=0;ic<this.jumlahIndividuTerseleksi;ic++)
		//Proses Seleksi Individu selesai. selanjutnya Individu Terseleksi ini akan dijadikan sebagai Parents dalam Proses Crossover
		
		//akhir proses seleksi-----------------------------------------------------------------------------
	}//end of constructor

	public void start(){
		
		//
	}//end of public void start()

	public int[][][] getIndividuOut() {
		return individuOut;
	}

}
