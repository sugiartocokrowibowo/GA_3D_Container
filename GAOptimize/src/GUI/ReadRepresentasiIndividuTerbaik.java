package GUI;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadRepresentasiIndividuTerbaik {
	
	
	public String[][] readRepresentasi(){//-------------------------------------------------------
		String[][] dataRepresentasi=new String[9][];
		try {
			FileInputStream data=new FileInputStream("Terbaik/representasiIndividuTerbaik.txt");
			BufferedReader dataIn=new BufferedReader(new InputStreamReader(data));
			dataIn.readLine();
			String thisLine;
			int i=0;
			while((thisLine=dataIn.readLine())!=null){
				dataRepresentasi[i]=thisLine.split(":");
				i++;
			}
			dataIn.close();
			data.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end of try		
		return dataRepresentasi;
	}//end of ReadRepresentasi()--------------------------------------------------------------
	
	public String[][] readIndividu(){//-------------------------------------------------------
		String[][] dataIndividu=new String[2][];
		try {
			FileInputStream data=new FileInputStream("Terbaik/individuTerbaik.txt");
			BufferedReader dataIn=new BufferedReader(new InputStreamReader(data));
			dataIn.readLine();
			String thisLine;
			int i=0;
			while((thisLine=dataIn.readLine())!=null){
				dataIndividu[i]=thisLine.split(":");
				i++;
			}
			dataIn.close();
			data.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end of try		
		return dataIndividu;
	}//end of ReadRepresentasi()--------------------------------------------------------------
	
	public String[][]representasiOut(){//----------------------------------------------------
		String[][] individu,representasi,input,output;
		
		individu=this.readIndividu();
		representasi=this.readRepresentasi();
		input=new String[11][individu[0].length];
		for(int i=0;i<2;i++){
			for(int j=0;j<individu[i].length;j++){
				input[i][j]=individu[i][j];
			}//end of for j
		}//end of for i
		
		for(int i=0;i<9;i++){
			int a=i+2;
			for(int j=0;j<representasi[i].length;j++){				
				input[a][j]=representasi[i][j];
			}//end of for j
		}//end of for i
		
		
		output=new String[input[0].length][input.length];
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[i].length;j++){
				output[j][i]=input[i][j];
			}//endd of for j
		}//end of for i
		
		
		return output;
	}//end of representasiOut()---------------------------------------------------------------
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		String[][] dataRepresentasi=new ReadRepresentasiIndividuTerbaik().readRepresentasi();
		System.out.println(dataRepresentasi.length);
		System.out.println(dataRepresentasi[1].length);
		
		for(int i=0;i<dataRepresentasi.length;i++){
			for(int j=0;j<dataRepresentasi[i].length;j++){
				System.out.print(dataRepresentasi[i][j]+" ");
			}//end of for j
			System.out.println();
		}//end of for i
		
		String[][] dataIndividu=new ReadRepresentasiIndividuTerbaik().readIndividu();
		System.out.println(dataIndividu.length);
		System.out.println(dataIndividu[1].length);
		
		for(int i=0;i<dataIndividu.length;i++){
			for(int j=0;j<dataIndividu[i].length;j++){
				System.out.print(dataIndividu[i][j]+" ");
			}//end of for j
			System.out.println();
		}//end of for i
		
		String[][] output=new ReadRepresentasiIndividuTerbaik().representasiOut();
		System.out.println();
		for(int i=0;i<output.length;i++){
			for(int j=0;j<output[i].length;j++){
				System.out.print(output[i][j]+" ");
			}//end of for j
			System.out.println();
		}//end of for i
		
	}

}
