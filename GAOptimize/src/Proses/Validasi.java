package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */

public class Validasi {
	int[][][] individuIn;
	int panjangContainer,lebarContainer,tinggiContainer;
	
	//	--------------------------------------------------
	int[][] dataBarang=new DatabaseBarang().data;
	int[][][] individu;
	public int[][][] individuOut;
	public int[][][] representasiIndividuOut;
	public double[][] fitnessIndividuOut; /**variabel untuk menyimpan nilai fitnes 1,1/4,1/2,3/4 Kontainer */
	int[] panjangIndividuOut;
	
	public Validasi(int[][][] individuIn, int panjangContainer, int lebarContainer, int tinggiContainer) {
		super();
		this.individuIn = individuIn;
		this.panjangContainer = panjangContainer;
		this.lebarContainer = lebarContainer;
		this.tinggiContainer = tinggiContainer;
		//awal validasi------------------------------------------------------------------------------------
		/** Melakukan Validasi Kromosom */
		int jumlahIndividu=this.individuIn.length;
		this.individu=new int[jumlahIndividu][11][];
		this.individuOut=new int[jumlahIndividu][2][];
		this.representasiIndividuOut=new int[jumlahIndividu][9][];
		this.fitnessIndividuOut=new double[jumlahIndividu][4];
		this.panjangIndividuOut=new int[jumlahIndividu];
		

		//periksa ID kembar----------------------
		int[] duplicates=new int[jumlahIndividu];
		for(int j=0;j<jumlahIndividu;j++){
			int panjangIndividuIn=this.individuIn[j][0].length;
			int duplicate=0;
			for(int k=0;k<panjangIndividuIn;k++){
				int key=this.individuIn[j][0][k];
				if(key>0){
				for(int l=k+1;l<panjangIndividuIn;l++){
					if(key==this.individuIn[j][0][l]){this.individuIn[j][0][l]=0;duplicate=duplicate+1;}
				}//end of for(int l=k+1;l<panjangIndividuIn;l++)
				}//end of if(key>0)
			}//end of for(int k=0;k<panjangIndividuIn;k++)
			duplicates[j]=duplicate;
		}//end of for(int j=0;j<jumlahIndividu;j++)
		
			for(int j=0;j<jumlahIndividu;j++){
			int panjangIndividuIn=this.individuIn[j][0].length;
			int panjangIndividu=panjangIndividuIn-duplicates[j];
			this.individu[j][0]=new int[panjangIndividu];
			this.individu[j][1]=new int[panjangIndividu];
			//this.Individu[j]=new int[11][panjangIndividu];
			
			int m=0;
			for(int k=0;k<panjangIndividuIn;k++){
				if(this.individuIn[j][0][k]>0){
					this.individu[j][0][m]=this.individuIn[j][0][k];
					this.individu[j][1][m]=this.individuIn[j][1][k];
					m++;
				}//end of if(this.IndividuIn!=0)
			}//for(int k=0;k<panjangIndividuIn;k++)			
		}//end of for(int j=0;j<jumlahIndividu;j++)
		//periksa ID kembar----------------------
			
			
		/** Validasi Representasi individu */
		//validasi representasi Individu---------------------
			for(int j=0;j<jumlahIndividu;j++){
				int panjangIndividu=this.individu[j][1].length;
				//-------------------------------------------
				this.individu[j][2]=new int[panjangIndividu];
				this.individu[j][3]=new int[panjangIndividu];
				this.individu[j][4]=new int[panjangIndividu];
				this.individu[j][5]=new int[panjangIndividu];
				this.individu[j][6]=new int[panjangIndividu];
				this.individu[j][7]=new int[panjangIndividu];
				this.individu[j][8]=new int[panjangIndividu];
				this.individu[j][9]=new int[panjangIndividu];
				this.individu[j][10]=new int[panjangIndividu];
				//-------------------------------------------
				
				for(int pk=0;pk<panjangIndividu;pk++){
					int ID=this.individu[j][0][pk];
					int fID=ID-1;
					Keadaan posisiBarang=new Keadaan(0,this.dataBarang[fID][1], this.dataBarang[fID][2], this.dataBarang[fID][3]);
					posisiBarang.aturPosisi();
					this.individu[j][2][pk]=posisiBarang.panjangOut;
					this.individu[j][3][pk]=posisiBarang.lebarOut;
					this.individu[j][4][pk]=posisiBarang.tinggiOut;					
					
				}//end of for(int pk=0;pk<panjangIndividu;pk++)			
			}//end of for(int j=0;j<jumlahIndividu;j++
			
			//============================================
			//panjangKontainer=pCt;lebarKontainer=lCt;tinggiKontainer=tCt;
			int pCt=this.panjangContainer,lCt=this.lebarContainer,tCt=this.tinggiContainer;
			int[][][] Container=new int[pCt][lCt][tCt];
		    int infinity=99999;	
		    /**Angka 99999 digunakan sebagai penanda infinity disini karena diasumsikan tidak ada ukuran pCt atau lCt atau tCt yang lebih besar dari 99999 */
		    //============================================
		    
		    //memulai validasi/peletakan barang ke kontainer
		    for(int j=0;j<jumlahIndividu;j++){
		    	///
		    	int panjangIndividu=this.individu[j][0].length;
		    	int br=0;
				boolean full=false;
				boolean status=true;
				
				do{
					//
					//cari koordinat kosong-------------------------------------------------------------------
					boolean isAnyFreeSpaces=this.isAnyFreeSpaces(Container,panjangContainer,lebarContainer,tinggiContainer);
					boolean titikKosong=false;
			    	int u=0,v=0,w=0;
			    	
			    	for (int x=0;x<pCt;x++){
			    		for (int z=0;z<tCt;z++){
			    			for (int y=0;y<lCt;y++){
			    				if (Container[x][y][z]==0){u=x;v=y;w=z;titikKosong=true;break;}//menandai koordinat kosong (x,y,z=0);			    				
			    			}//end of y
			    			if(titikKosong==true){break;}
			    		}//end of for z
			    		if(titikKosong==true){break;}
			    	}//end of for x
			    	//koordinat kosong yang ditemukan yaitu (u,v,w);
			    	
			    	int x0=u,y0=v,z0=w,x1,y1,z1,X=0,Y=0,Z=0;
			    	
			    	int IdBarang=this.individu[j][0][br];
			    	int posisi=this.individu[j][1][br];
			    	int pBarang=this.individu[j][2][br];
			    	int lBarang=this.individu[j][3][br];
			    	int tBarang=this.individu[j][4][br];
			    	
			    	int terkecil=infinity;
			    	if(pBarang<terkecil){terkecil=pBarang;}
			    	if(lBarang<terkecil){terkecil=lBarang;}
			    	if(tBarang<terkecil){terkecil=tBarang;}
			    	
			    	if(((x0+terkecil)>=pCt)&&((y0+terkecil)>=lCt)&&((z0+terkecil)>=tCt)){full=true;}
			    	
			    	boolean[] statusPenuh=new boolean[6];
			    	int jsPenuh=0;
			    	int close=0;
			    	for(int sp=0;sp<6;sp++){statusPenuh[sp]=false;}                                  
			    	boolean pengisian=false;
			    	boolean isDimuat=true;
			    	//pemeriksaan ruang kosong seukuran barang di kontainer---------------------
			    	//boolean nl=true,nt=true,np=true;
			    	for(int p=0;p<6;p++){
			    		int pos=(posisi+p)%6;
			    		int p_baru,l_baru,t_baru;
			    		Keadaan keadaan=new Keadaan(pos,pBarang,lBarang,tBarang);
			    		keadaan.aturPosisi();
			    		p_baru=keadaan.panjangOut;
			    		l_baru=keadaan.lebarOut;
			    		t_baru=keadaan.tinggiOut;
			    		
			    		x1=x0+p_baru;
			    		y1=y0+l_baru;
			    		z1=z0+t_baru;
			    		
			    		//System.out.println("====== "+x0+" : "+y0+" : "+z0+" : "+x1+" : "+y1+" : "+z1+" : "+pos+" : "+pBarang+" : "+lBarang+" : "+tBarang);
			    		
			    		if(y1>=lCt){if(z1>=tCt){if(x1>=pCt){statusPenuh[p]=true;jsPenuh=jsPenuh+1;}}}
			    	
			    		
			    		if(x1<=pCt){
					    if(z1<=tCt){	
					    if(y1<=lCt){
					    	//memeriksa apakah ruangkosong dapat memuat barang------------------
					    	int count=0;
					    	for (int x=x0;x<x1;x++){
					    		for (int y=y0;y<y1;y++){
					    			for (int z=z0;z<z1;z++){
					    				if (Container[x][y][z]==0){count++;}
					    			}//end of for z
					    		}//end of for y
					    	}//end of for x
					    	//--------------------------
					    	if (count==(pBarang*lBarang*tBarang)){
					    		X=x1;
					    		Y=y1;
					    		Z=z1;
					    		posisi=pos;							    		
					    		pengisian=true;				    		
					    	}//end of if terdapat ruang kosong sebesar barang yang terpiih (count=volume barang terpilih)
					    	else if(count<(pBarang*lBarang*tBarang)){
					    		pengisian=false;
					    		isDimuat=false;
					    	}
					    	else{pengisian=false;}				    	
					    	
					    }//end of if(y1<lCt)
					    else{pengisian=false;}
					    }//end of if(z1<tCt)
					    else{pengisian=false;}
			    		}//end of if(x1<pCt) 
			    		else{pengisian=false;}		    		
			    		
			    		if(pengisian==true){break;}		    		
			    		close++;
			    	}//end of for(int p=0;p<6;p++)
			    	
			    	//cek kontainer full
			    	if(jsPenuh==6){full=true;}
			    	if(close==6){Container[x0][y0][z0]=infinity;}//if(isDimuat==false&&np==false){br++;}}
			    	
			    	
			    	//---------------------------------------------------------------------------------------------------------		    	
			    	if (pengisian==true){
			    		//
			    		for (int x=x0;x<X;x++){
				    		for (int y=y0;y<Y;y++){
				    			for (int z=z0;z<Z;z++){
				    				Container[x][y][z]=IdBarang;//menandai ruang kosong seukuran barang dengan id barang					    				
				    			}//end of for z		    			
				    		}//end of for y
				    	}//end of for x
			    		this.individu[j][1][br]=posisi;
			    		//mengisi matriks koordinat awal dan akhir barang;(Representasi Barang)--------------------		    				
	    				this.individu[j][5][br]=x0;this.individu[j][6][br]=y0;this.individu[j][7][br]=z0;//(x0,y0,z0)
	    				this.individu[j][8][br]=X;this.individu[j][9][br]=Y;this.individu[j][10][br]=Z;//(x1,y1,z1)		    				            
	    				//mengisi matriks koordinat awal dan akhir barang;-----------------------------------------
			    	
			    		br++;
			    	}//end of if (pengisian==true)
			    	else{Container[x0][y0][z0]=infinity;}//end of else		    	
			    
			    	//---------------------------------------------------------------------------------------------------------	
			    	if(br<panjangIndividu){if(full==false){status=true;}else{status=false;}}else{status=false;}
			    	if(isAnyFreeSpaces==false){status=false;}
			    	//---------------------------------------------------------------------------------------------------------	
			    		    	
				}//end  of do while				
				while (status==true);//mengakhiri proses validasi	
				
				
				//menghitung panjangIndividu, Individu,IndividuValid, jangkauanGen    
				int panjangIndividuOut=br;
				this.panjangIndividuOut[j]=panjangIndividuOut;
				this.individuOut[j]=new int[2][panjangIndividuOut];
				this.representasiIndividuOut[j]=new int[9][panjangIndividuOut];
				//representasiIndividuOut:(panjang Barang)(lebar Barang)(tinggi Barang)(x0)(y0)(z0)(x1)(y1)(z1)
				
				for (int pk=0;pk<panjangIndividuOut;pk++){
					for(int i=0;i<2;i++){this.individuOut[j][i][pk]=this.individu[j][i][pk];}//end of for i
					for(int i=0;i<9;i++){this.representasiIndividuOut[j][i][pk]=this.individu[j][i+2][pk];}//end of for i
				}//end of for pk
				
				
				/**Menghitung nilai Fitness untuk 1/4 Kontainer 2/4 Kontainer dan 3/4 Kontainer 1 Kontainer   */
								
				int satuTCt=tCt;
				int satuPer4TCt=Math.round(tCt*1/4);
				int duaPer4TCt=Math.round(tCt*2/4);
				int tigaPer4TCt=Math.round(tCt*3/4);
				
				int volumeSatuContainer=0;
				int volume1Per4Container=0;
				int volume2Per4Container=0;
				int volume3Per4Container=0;
				
				for (int i=0;i<pCt;i++){
					for (int c=0;c<lCt;c++){
						for(int a=0;a<satuPer4TCt;a++){
		    				if ((Container[i][c][a]!=0)&&(Container[i][c][a]!=infinity)){volume1Per4Container=volume1Per4Container+1;}
		    			}//end of for(int a=0;a<satuPer4TCt;a++)
					}//end of for (int c=0;c<lCt;c++)
				}//end of for (int i=0;i<pCt;i++)
				
				volume2Per4Container=volume2Per4Container+volume1Per4Container;
				for (int i=0;i<pCt;i++){
					for (int c=0;c<lCt;c++){
						for(int a=satuPer4TCt;a<duaPer4TCt;a++){
							if ((Container[i][c][a]!=0)&&(Container[i][c][a]!=infinity)){volume2Per4Container=volume2Per4Container+1;}
		    			}//end of for(int a=0;a<satuPer4TCt;a++)
					}//end of for (int c=0;c<lCt;c++)
				}//end of for (int i=0;i<pCt;i++)
								
				volume3Per4Container=volume3Per4Container+volume2Per4Container;
				for (int i=0;i<pCt;i++){
					for (int c=0;c<lCt;c++){
						for(int a=duaPer4TCt;a<tigaPer4TCt;a++){
							if ((Container[i][c][a]!=0)&&(Container[i][c][a]!=infinity)){volume3Per4Container=volume3Per4Container+1;}
		    			}//end of for(int a=0;a<satuPer4TCt;a++)
					}//end of for (int c=0;c<lCt;c++)
				}//end of for (int i=0;i<pCt;i++)
				
				volumeSatuContainer=volumeSatuContainer+volume3Per4Container;
				for (int i=0;i<pCt;i++){
					for (int c=0;c<lCt;c++){
						for(int a=tigaPer4TCt;a<satuTCt;a++){
							if ((Container[i][c][a]!=0)&&(Container[i][c][a]!=infinity)){volumeSatuContainer=volumeSatuContainer+1;}
		    			}//end of for(int a=0;a<satuPer4TCt;a++)
					}//end of for (int c=0;c<lCt;c++)
				}//end of for (int i=0;i<pCt;i++)
								
				this.fitnessIndividuOut[j][0]=volumeSatuContainer; //fitness satu Kontainer
				this.fitnessIndividuOut[j][1]=volume1Per4Container;//fitness seperempat Kontainer
				this.fitnessIndividuOut[j][2]=volume2Per4Container;//fitness dua perempat Kontainer
				this.fitnessIndividuOut[j][3]=volume3Per4Container;//fitness tiga perempat Kontainer		
				
				
				//menolkan Container:-----------------------------------------------------------------------------------
				    for (int x=0;x<pCt;x++){
			    		for (int y=0;y<lCt;y++){
			    			for (int z=0;z<tCt;z++){
			    				Container[x][y][z]=0;
			    			}//end of for z		    			
			    		}//end of for y
			    	}//end of for x							
		    }//end of for(int j=0;j<jumlahIndividu;j++)
			
	/** Validasi Representasi individu */
		//akhir validasi-----------------------------------------------------------------------------------
	}//end of constructor
	
	public boolean isAnyFreeSpaces(int[][][] Container,int panjangContainer, int lebarContainer, int tinggiContainer){
		boolean status=false;
		int kosong=0;
		for(int i=0;i<panjangContainer;i++){
			for(int j=0;j<lebarContainer;j++){
				for(int k=0;k<tinggiContainer;k++){
					if(Container[i][j][k]==0){kosong++;}
				}
			}
		}
		if(kosong>0){status=true;}
		return status;
	}//end of isAnyFreeSpaces


	public double[][] getFitnessIndividuOut() {
		return fitnessIndividuOut;
	}


	public int[][][] getIndividuOut() {
		return individuOut;
	}


	public int[] getPanjangIndividuOut() {
		return panjangIndividuOut;
	}


	public int[][][] getRepresentasiIndividuOut() {
		return representasiIndividuOut;
	}

}//end of class Validasi
