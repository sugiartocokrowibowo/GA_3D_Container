package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
import java.util.Random;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 *
 */
public class RandomId {
 private static Random rd = null;
 
  public static int[] random(int[] src){
    if(src == null){
   return null; 
  }
  
  rd = new Random();
   int[] tmp = new int[src.length];
  
  int num = src.length;
  
 
  int index;

  for(int i = 0;i < src.length;i++)
  {
  
   index = Math.abs(rd.nextInt()) % num;
    tmp[i] = src[index];
      src[index] = src[num - 1];
      num--;
  }
  return tmp;
 }
}