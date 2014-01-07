package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
import java.sql.*;

import Database.Data;

public class DatabaseBarang {

	public DatabaseBarang() {
		super();
		int[][] dataBarang=new Data().view();
		this.data=new int[dataBarang.length][4];
		for(int i=0;i<dataBarang.length;i++){
			int a=i;
			this.data[i][0]=(a+1);
			this.data[i][1]=dataBarang[i][0];
			this.data[i][2]=dataBarang[i][1];
			this.data[i][3]=dataBarang[i][2];			
		}//end of while	
		jumlahData=dataBarang.length;	
	}
	
	int[][] data;	
	int jumlahData;
	
}
