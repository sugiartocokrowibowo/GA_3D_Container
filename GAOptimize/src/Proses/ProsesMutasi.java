package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
import Database.Data;

/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
public class ProsesMutasi {
	//input class---------------------------
	int[][][] individuIn;
	double probabilitasMutasi;
	int jumlahData=new Data().length();
	//output class--------------------------
	public int[][][] individuOut;
	
	
	public ProsesMutasi(int[][][] individuIn, double probabilitasMutasi) {
		super();
		this.individuIn = individuIn;
		this.probabilitasMutasi = probabilitasMutasi;
		//awal proses mutasi------------------------------------------------
		int jumlahIndividu=this.individuIn.length;
		this.individuOut=new int[jumlahIndividu][2][];
		
		int[][][] individuProsesMutasi=this.individuIn;
		
		RandomBetweenDouble acakProbabilitasMutasi=new RandomBetweenDouble();
		
		for(int i=0;i<jumlahIndividu;i++){
			double randomProbabilitasMutasiKromsom=acakProbabilitasMutasi.hasilRandom(0,1);
			if(randomProbabilitasMutasiKromsom<=this.probabilitasMutasi){
				RandomBetween acak=new RandomBetween();
				int titikMutasi=acak.hasilRandom(0,individuProsesMutasi[i][0].length);
				int gen=acak.hasilRandom(1,this.jumlahData);
				int posisi=acak.hasilRandom(0,6);				
				individuProsesMutasi[i][0][titikMutasi]=gen;
				individuProsesMutasi[i][1][titikMutasi]=posisi;				
			}//end of if(randomProbabilitasMutasiKromsom<=this.probabilitasMutasi)
		}//end of for(int i=0;i<jumlahIndividu;i++)
		
		this.individuOut=individuProsesMutasi;
		//akhir proses mutasi-----------------------------------------------
	}


	public int[][][] getIndividuOut() {
		return individuOut;
	}

}//end of class  ProsesMutasi
