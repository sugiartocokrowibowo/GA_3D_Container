package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
public class Keadaan {
	/**
	 * @author SCWMath92040111H42506891A557KPAERNLMTSKM
	 *
	 */	
	
	int posisi;
	int panjangIn;
	int lebarIn;
	int tinggiIn;
	
	public Keadaan(int posisi, int panjangIn, int lebarIn, int tinggiIn) {
		super();
		this.posisi = posisi;
		this.panjangIn = panjangIn;
		this.lebarIn = lebarIn;
		this.tinggiIn = tinggiIn;
	}
	
	
	int panjangOut;
	int lebarOut;
	int tinggiOut;
	
	public void aturPosisi(){
		int pos=this.posisi;
		//atur panjang
		if      (pos==0){
			this.panjangOut=this.panjangIn;
			this.lebarOut=this.lebarIn;
			this.tinggiOut=this.tinggiIn;
		}
		else if (pos==1){
			this.panjangOut=this.lebarIn;
			this.lebarOut=this.panjangIn;
			this.tinggiOut=this.tinggiIn;
		}
		else if (pos==2){
			this.panjangOut=this.tinggiIn;
			this.lebarOut=this.lebarIn;
			this.tinggiOut=this.panjangIn;
		}
		else if (pos==3){
			this.panjangOut=this.lebarIn;
			this.lebarOut=this.tinggiIn;
			this.tinggiOut=this.panjangIn;
		}
		else if (pos==4){
			this.panjangOut=this.panjangIn;
			this.lebarOut=this.tinggiIn;
			this.tinggiOut=this.lebarIn;
		}
		else if (pos==5){
			this.panjangOut=this.tinggiIn;
			this.lebarOut=this.panjangIn;
			this.tinggiOut=this.lebarIn;
		}
						
	}//end of atur Posisi

	

}//end of class
