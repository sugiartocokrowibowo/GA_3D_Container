package Proses;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
public class SortingFitness {
	double[][] fitnessGenerasiIn;	/**Input: fitnessGenerasiIn */
	//---------------------------------
	double[][] fitnessGenerasi;
	//---------------------------------
	public double[][] fitnessGenerasiOut;	/**Output: fitnessGenerasiOut */
	
	//Konstruktor:
	public SortingFitness(double[][] fitnessGenerasiIn) {
		super();
		this.fitnessGenerasiIn = fitnessGenerasiIn;
		//awal prosessorting----------------------------------------------------------------
		int jumlahIndividu=this.fitnessGenerasiIn.length;
		this.fitnessGenerasi=this.fitnessGenerasiIn;
		//System.out.println("Jumlah Individu: "+jumlahIndividu);
		double[] tukar=new double[5];
		double[][] fitnessSementara=new double[jumlahIndividu][5];
		for(int ic=0;ic<jumlahIndividu;ic++){
			fitnessSementara[ic][4]=ic;
			for(int ha=0;ha<4;ha++){
				fitnessSementara[ic][ha]=this.fitnessGenerasi[ic][ha];
			}
		}//end of for(int ic=0;ic<jumlahIndividu;i++)
		
		//Memulai Proses Sorting >>>>>
		for(int a=0;a<jumlahIndividu;a++){
			for(int b=0;b<jumlahIndividu;b++){
				if(fitnessSementara[a][0]>fitnessSementara[b][0]){
					//-------------------------------
					tukar[0]=fitnessSementara[a][0];
					tukar[1]=fitnessSementara[a][1];
					tukar[2]=fitnessSementara[a][2];
					tukar[3]=fitnessSementara[a][3];
					tukar[4]=fitnessSementara[a][4];
					//-------------------------------
					fitnessSementara[a][0]=fitnessSementara[b][0];
					fitnessSementara[a][1]=fitnessSementara[b][1];
					fitnessSementara[a][2]=fitnessSementara[b][2];
					fitnessSementara[a][3]=fitnessSementara[b][3];
					fitnessSementara[a][4]=fitnessSementara[b][4];
					//-------------------------------
					fitnessSementara[b][0]=tukar[0];
					fitnessSementara[b][1]=tukar[1];
					fitnessSementara[b][2]=tukar[2];
					fitnessSementara[b][3]=tukar[3];
					fitnessSementara[b][4]=tukar[4];
					//-------------------------------
				}//end of if(fitnessSementara[a][0]>fitnessSementara[b][0]) 
			}//end of for(int b=0;b<jumlahIndividu;b++)
		}//end of for(int a=0;a<jumlahIndividu;a++) 		
		this.fitnessGenerasi=fitnessSementara;
		
		fitnessSementara=this.fitnessGenerasi;
		for(int a=0;a<jumlahIndividu;a++){
			for(int b=0;b<jumlahIndividu;b++){
			if(fitnessSementara[a][0]==fitnessSementara[b][0]){
				if(fitnessSementara[a][1]>fitnessSementara[b][1]){
					//-------------------------------
					tukar[0]=fitnessSementara[a][0];
					tukar[1]=fitnessSementara[a][1];
					tukar[2]=fitnessSementara[a][2];
					tukar[3]=fitnessSementara[a][3];
					tukar[4]=fitnessSementara[a][4];
					//-------------------------------
					fitnessSementara[a][0]=fitnessSementara[b][0];
					fitnessSementara[a][1]=fitnessSementara[b][1];
					fitnessSementara[a][2]=fitnessSementara[b][2];
					fitnessSementara[a][3]=fitnessSementara[b][3];
					fitnessSementara[a][4]=fitnessSementara[b][4];
					//-------------------------------
					fitnessSementara[b][0]=tukar[0];
					fitnessSementara[b][1]=tukar[1];
					fitnessSementara[b][2]=tukar[2];
					fitnessSementara[b][3]=tukar[3];
					fitnessSementara[b][4]=tukar[4];
					//-------------------------------
				}//end of if(fitnessSementara[a][0]>fitnessSementara[b][0]) 
			}//end of if(fitnessSementara[a][0]==fitnessSementara[b][0])
			}//end of for(int b=0;b<jumlahIndividu;b++)
		}//end of for(int a=0;a<jumlahIndividu;a++) 
		this.fitnessGenerasi=fitnessSementara;
		
		fitnessSementara=this.fitnessGenerasi;
		for(int a=0;a<jumlahIndividu;a++){
			for(int b=0;b<jumlahIndividu;b++){
			if((fitnessSementara[a][0]==fitnessSementara[b][0])&&(fitnessSementara[a][1]==fitnessSementara[b][1])){
				if(fitnessSementara[a][2]>fitnessSementara[b][2]){
					//-------------------------------
					tukar[0]=fitnessSementara[a][0];
					tukar[1]=fitnessSementara[a][1];
					tukar[2]=fitnessSementara[a][2];
					tukar[3]=fitnessSementara[a][3];
					tukar[4]=fitnessSementara[a][4];
					//-------------------------------
					fitnessSementara[a][0]=fitnessSementara[b][0];
					fitnessSementara[a][1]=fitnessSementara[b][1];
					fitnessSementara[a][2]=fitnessSementara[b][2];
					fitnessSementara[a][3]=fitnessSementara[b][3];
					fitnessSementara[a][4]=fitnessSementara[b][4];
					//-------------------------------
					fitnessSementara[b][0]=tukar[0];
					fitnessSementara[b][1]=tukar[1];
					fitnessSementara[b][2]=tukar[2];
					fitnessSementara[b][3]=tukar[3];
					fitnessSementara[b][4]=tukar[4];
					//-------------------------------
				}//end of if(fitnessSementara[a][0]>fitnessSementara[b][0]) 
			}//end of if(fitnessSementara[a][0]==fitnessSementara[b][0])
			}//end of for(int b=0;b<jumlahIndividu;b++)
		}//end of for(int a=0;a<jumlahIndividu;a++) 
		this.fitnessGenerasi=fitnessSementara;
		
		fitnessSementara=this.fitnessGenerasi;
		for(int a=0;a<jumlahIndividu;a++){
			for(int b=0;b<jumlahIndividu;b++){
			if((fitnessSementara[a][0]==fitnessSementara[b][0])&&(fitnessSementara[a][1]==fitnessSementara[b][1])&&(fitnessSementara[a][2]==fitnessSementara[b][2])){
				if(fitnessSementara[a][3]>fitnessSementara[b][3]){
					//-------------------------------
					tukar[0]=fitnessSementara[a][0];
					tukar[1]=fitnessSementara[a][1];
					tukar[2]=fitnessSementara[a][2];
					tukar[3]=fitnessSementara[a][3];
					tukar[4]=fitnessSementara[a][4];
					//-------------------------------
					fitnessSementara[a][0]=fitnessSementara[b][0];
					fitnessSementara[a][1]=fitnessSementara[b][1];
					fitnessSementara[a][2]=fitnessSementara[b][2];
					fitnessSementara[a][3]=fitnessSementara[b][3];
					fitnessSementara[a][4]=fitnessSementara[b][4];
					//-------------------------------
					fitnessSementara[b][0]=tukar[0];
					fitnessSementara[b][1]=tukar[1];
					fitnessSementara[b][2]=tukar[2];
					fitnessSementara[b][3]=tukar[3];
					fitnessSementara[b][4]=tukar[4];
					//-------------------------------
				}//end of if(fitnessSementara[a][0]>fitnessSementara[b][0]) 
			}//end of if(fitnessSementara[a][0]==fitnessSementara[b][0])
			}//end of for(int b=0;b<jumlahIndividu;b++)
		}//end of for(int a=0;a<jumlahIndividu;a++) 
		this.fitnessGenerasi=fitnessSementara;
		
		fitnessSementara=this.fitnessGenerasi;
		for(int a=0;a<jumlahIndividu;a++){
			for(int b=0;b<jumlahIndividu;b++){
			if((fitnessSementara[a][0]==fitnessSementara[b][0])&&(fitnessSementara[a][1]==fitnessSementara[b][1])&&(fitnessSementara[a][2]==fitnessSementara[b][2])&&(fitnessSementara[a][3]==fitnessSementara[b][3])){
				if(fitnessSementara[a][4]<fitnessSementara[b][4]){
					//-------------------------------
					tukar[0]=fitnessSementara[a][0];
					tukar[1]=fitnessSementara[a][1];
					tukar[2]=fitnessSementara[a][2];
					tukar[3]=fitnessSementara[a][3];
					tukar[4]=fitnessSementara[a][4];
					//-------------------------------
					fitnessSementara[a][0]=fitnessSementara[b][0];
					fitnessSementara[a][1]=fitnessSementara[b][1];
					fitnessSementara[a][2]=fitnessSementara[b][2];
					fitnessSementara[a][3]=fitnessSementara[b][3];
					fitnessSementara[a][4]=fitnessSementara[b][4];
					//-------------------------------
					fitnessSementara[b][0]=tukar[0];
					fitnessSementara[b][1]=tukar[1];
					fitnessSementara[b][2]=tukar[2];
					fitnessSementara[b][3]=tukar[3];
					fitnessSementara[b][4]=tukar[4];
					//-------------------------------
				}//end of if(fitnessSementara[a][0]>fitnessSementara[b][0]) 
			}//end of if(fitnessSementara[a][0]==fitnessSementara[b][0])
			}//end of for(int b=0;b<jumlahIndividu;b++)
		}//end of for(int a=0;a<jumlahIndividu;a++) 
		this.fitnessGenerasi=fitnessSementara;	
		this.fitnessGenerasiOut=this.fitnessGenerasi;//Akhir dari proses Sorting.		
		//akhir proses sorting---------------------------------------------------------------
	}

	public double[][] getFitnessGenerasiOut() {
		return fitnessGenerasiOut;
	}

}//end of class SortingFitnes
