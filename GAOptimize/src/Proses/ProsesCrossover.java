package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
public class ProsesCrossover {
	//input class
	int[][][] individuIn;
	int jumlahIndividu;
	//------------------------
	//output class
	public int[][][] individuOut;
	
	
	public ProsesCrossover(int[][][] individuIn, int jumlahIndividu) {
		super();
		this.individuIn = individuIn;//individu terseleksi
		this.jumlahIndividu = jumlahIndividu;//jumlah individu untuk setiap generasi
		//awal proses crossover
		int jumlahIndividuTerseleksi=this.individuIn.length;
		int jumlahIndividuHasilCrossover=this.jumlahIndividu-jumlahIndividuTerseleksi;
		int JP=Math.round((jumlahIndividuHasilCrossover+1)/2);
		
		int[][] father=new int[2][],mother=new int[2][];		
		int[][][] child=new int[(2*JP)][2][];
		
		//Operator Random untuk mencari Pasangan Parent dan Titik Potong.				
		RandomBetween acakparent=new RandomBetween();
		RandomBetween acakTitikPotong=new RandomBetween();
		        
		///Memulai Proses Crossover menggunakan single point crossover
		for(int i=0;i<JP;i++){
			int indexFather,indexMother;
			int panjangKromosomFather=0, panjangKromosomMother=0, titikPotongFather=0,titikPotongMother=0;
			
			//memilih Father secara acak---------------------------------------------
			indexFather=acakparent.hasilRandom(0,jumlahIndividuTerseleksi);
			for(int j=0;j<2;j++){
				father[j]=this.individuIn[indexFather][j].clone();
			}//
			panjangKromosomFather=father[0].length;
			titikPotongFather=acakTitikPotong.hasilRandom(0,(panjangKromosomFather-1));
			
			//memilih Mother secara acak dan harus berbeda dengan Father----------------
			boolean next=true;
			while(next==true){
				indexMother=acakparent.hasilRandom(0,jumlahIndividuTerseleksi);
				if(indexFather!=indexMother){
					for(int j=0;j<2;j++){
						mother[j]=this.individuIn[indexMother][j].clone();
					}//
					panjangKromosomMother=mother[0].length;
					titikPotongMother=acakTitikPotong.hasilRandom(0,(panjangKromosomMother-1));
					next=false;
				}//end of if(indexFather!=indexMother) 								
			}//end of while(next==true) 
			
			//inisiasi kromosom anak/child
			int a=titikPotongFather;
			int b=titikPotongMother;
			int panjangChild1=(a+1)+(panjangKromosomMother-(b+1));
			int panjangChild2=(b+1)+(panjangKromosomFather-(a+1));	
			int[][] child1=new int[2][panjangChild1],child2=new int[2][panjangChild2];
			
			//menyilangkan kromosom father dan mother
			for(int k=0;k<2;k++){
				//generate individu child1----------------------------------------------------------
				for(int l=0;l<(a+1);l++){child1[k][l]=father[k][l];}//end of for(int l=0;l<(a+1);l++)
				for(int l=(a+1);l<panjangChild1;l++){child1[k][l]=mother[k][((l-(a+1))+(b+1))];}//end of for(int l=(a+1);l<panjangChild1;l++) 
				
				//generate individu child1----------------------------------------------------------
				for(int l=0;l<(b+1);l++){child2[k][l]=mother[k][l];}//end of for(int l=0;l<(b+1);l++) 
				for(int l=(b+1);l<panjangChild2;l++){child2[k][l]=father[k][((l-(b+1))+(a+1))];}//end of for(int l=(b+1);l<panjangChild2;l++) 
				
				//menyimpan hasil persilangan kedalam array child[][][]------------------------------
				//for(int l=0;l<panjangChild1;l++){//child[(2*i)][k][l]=child1[k][l];}	
				//for(int l=0;l<panjangChild2;l++){child[((2*i)+1)][k][l]=child2[k][l];}
				child[(2*i)][k]=child1[k].clone();
				child[((2*i)+1)][k]=child2[k].clone();
			}//end of for(int k=0;k<2;k++) 						
		}//end of for(int i=0;i<JP;i++)
		///Proses C r o s s o v e r selesai 
		
		this.individuOut=new int[this.jumlahIndividu][2][];
		for(int i=0;i<jumlahIndividuTerseleksi;i++){
			for(int cha=0;cha<2;cha++){
				this.individuOut[i][cha]=this.individuIn[i][cha].clone();
			}//end of for(int cha=0;cha<2;cha++)
		}//end of for(int i=0;i<jumlahIndividuTerseleksi;i++)
		for(int i=jumlahIndividuTerseleksi;i<this.jumlahIndividu;i++){
			for(int cha=0;cha<2;cha++){
				this.individuOut[i][cha]=child[i-jumlahIndividuTerseleksi][cha].clone();
			}//end of for(int cha=0;cha<2;cha++)
		}//end of for(int i=jumlahIndividuTerseleksi;i<this.jumlahIndividu;i++) 
		//akhir proses crossover
	}


	public int[][][] getIndividuOut() {
		return individuOut;
	}

}//end of public class ProsesCrossover 
