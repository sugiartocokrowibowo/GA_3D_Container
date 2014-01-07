package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
import java.lang.Math;
public class RandomBetween {
	public RandomBetween(int lower_Bound, int upper_Bound) {
		super();
		Lower_Bound = lower_Bound;
		Upper_Bound = upper_Bound;
	}
	public RandomBetween() {
		super();
		// TODO Auto-generated constructor stub
	}
	int Lower_Bound; 
	int Upper_Bound; 
	public int hasilRandom(int Lower_Bound, int Upper_Bound){
	int r= (int) (Lower_Bound + Math.random() * ( Upper_Bound - Lower_Bound) );
	return r;
	}	
}
