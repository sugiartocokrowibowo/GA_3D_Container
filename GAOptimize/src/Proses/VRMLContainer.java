package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
public class VRMLContainer {
	int[][] representasiIndividu;
	int panjangContainer,lebarContainer,tinggiContainer;
	public String visualisasi;
	
	public VRMLContainer(int[][] representasiIndividu, int panjangContainer, int lebarContainer, int tinggiContainer) {
		super();
		this.representasiIndividu = representasiIndividu;
		this.panjangContainer = panjangContainer;
		this.lebarContainer = lebarContainer;
		this.tinggiContainer = tinggiContainer;
		
		//create BOX---------------------------------
//		mendefinisikan string2 node VRML
		String Header	="#VRML V2.0 utf8 \n";
		String icha1	="Transform {translation ";
		//0 0 0 
		String icha2	=" children [ \n          Shape{appearance Appearance {material Material {diffuseColor ";		
		//0 1 0 
		String icha3	=" transparency ";  
		//0.9
		String icha4	=" }}\n               geometry Box{size "; 
		//10 10 40
		String icha5	=" }}]} \n\n";
		
		visualisasi=Header;
		
		//menggambar Kontainer
		String as			=""+(0+(0.5*this.panjangContainer))+" "+(0+(0.5*this.lebarContainer))+" "+(0+(0.5*this.tinggiContainer))+"";
		//String as			=""+(0+(0.5*this.panjangContainer))+" "+0+" "+0+"";
		String color		=""+1+" "+1+" "+1+"";
		String transparency	="0.8";
		String size			=""+this.panjangContainer+" "+this.lebarContainer+" "+this.tinggiContainer+"";
		visualisasi=visualisasi.concat(icha1.concat(as.concat(icha2.concat(color.concat(icha3.concat(transparency.concat(icha4.concat(size.concat(icha5)))))))));
		
		//menggambar Text Tampak Atas dengan ukuran 2
		String asta				=""+(0+(0.5*this.panjangContainer))+" "+(0+(0.5*this.lebarContainer))+" "+(this.tinggiContainer+1)+"";		
		String colorta			=""+0+" "+0+" "+0+"";		
		String transparencyta	="0";
		String texta			=" }}\n               geometry Text{string \"Tampak Atas\"fontStyle FontStyle {size 0.5  }"; 		
		visualisasi=visualisasi.concat(icha1.concat(asta.concat(icha2.concat(colorta.concat(icha3.concat(transparencyta.concat(texta.concat(icha5))))))));
		
		
		//menggambar box
		int jumlahBox=this.representasiIndividu[0].length;
		for(int i=0;i<jumlahBox;i++){
			//int pBox=this.representasiIndividu[0][i];
			//int lBox=this.representasiIndividu[1][i];
			//int tBox=this.representasiIndividu[2][i];
			
			int x0=this.representasiIndividu[3][i];
			int y0=this.representasiIndividu[4][i];
			int z0=this.representasiIndividu[5][i];
			
			int x1=this.representasiIndividu[6][i];
			int y1=this.representasiIndividu[7][i];
			int z1=this.representasiIndividu[8][i];
			
			int pBox=x1-x0;;
			int lBox=y1-y0;
			int tBox=z1-z0;
			
			as				=""+(x0+(0.5*pBox))+" "+(y0+(0.5*lBox))+" "+(z0+(0.5*tBox))+"";
			double w1=0,w2=0,w3=1;
			w1=Math.random();
			w2=Math.random();
			w3=Math.random();
			color			=""+w1+" "+w2+" "+w3+"";
			transparency	="0.1";
			size			=""+pBox+" "+lBox+" "+tBox+"";
			visualisasi=visualisasi.concat(icha1.concat(as.concat(icha2.concat(color.concat(icha3.concat(transparency.concat(icha4.concat(size.concat(icha5)))))))));
						
		}//end of for i
		//-------------------------------------------
		
	}//end of contruktor

	

}//end of class visualisasi
