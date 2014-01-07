package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
import java.lang.Math;
/**
 * @author SCWMath92040111H42506891A557KPAERNLMTSKM
 *
 */
public class RandomBetweenDouble {

	/**
	 * 
	 */
	
	public RandomBetweenDouble(double lower_Bound, double upper_Bound) {
		super();
		Lower_Bound = lower_Bound;
		Upper_Bound = upper_Bound;
	}
	public RandomBetweenDouble() {
		super();
		// TODO Auto-generated constructor stub
	}
	double Lower_Bound; 
	double Upper_Bound; 
	public double hasilRandom(double Lower_Bound, double Upper_Bound){
	double r= (double) (Lower_Bound + Math.random() * ( Upper_Bound - Lower_Bound) );
	return r;
	

}
	
}
