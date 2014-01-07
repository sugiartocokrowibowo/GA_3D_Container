package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
import Database.Data;

public class GenerasiAwal {
	int jumlahIndividu;
	int[][][] individu;

	int[][][] individuOut;
	
	public GenerasiAwal(int jumlahIndividu) {
		super();
		this.jumlahIndividu = jumlahIndividu;		
		Data data=new Data();
		//		
		int jumlahBarang=data.length();
		this.individu=new int[this.jumlahIndividu][2][jumlahBarang];
		
		for(int s=0;s<jumlahIndividu;s++){
			/**Generate kromosom pertama(kromosom ID barang) sebanyak jumlah individu */
			//=======================================================================================================
			//random gen ID barang
			int[] dataId=new int[jumlahBarang];
			for(int i=0;i<jumlahBarang;i++){dataId[i]=i+1;}
			int a[] = RandomId.random(dataId);
			
			for(int i=0;i<a.length;i++){
				this.individu[s][0][i]=a[i];
			}
			
			/**Generate kromosom kedua(kromosom Posisi barang) sebanyak jumlah individu */
			//=======================================================================================================
			RandomBetween acakposisi=new RandomBetween();
			//inisiasi posisi untuk kromosom		
				for (int i=0;i<jumlahBarang;i++){
					this.individu[s][1][i]=acakposisi.hasilRandom(0,6);
				}
			//=======================================================================================================
						
		}//end of for(int s=0;s<jumlahIndividu;s++)		
		this.individuOut=this.individu;	
		}//--------------------------------------------------------------------------
	//}//end of constructor

	public int[][][] getIndividuOut() {
		return individuOut;
	}

}//end of class
