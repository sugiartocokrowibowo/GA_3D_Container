package Database;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Data {	
	int[][] dataOut;

	public Data() {
		super();	
		createDirectory();
	}
	
	public void createDirectory(){//---------------------------------------------
		File dir = new File("Data");
		FileOutputStream dataBarang;
		if (!(dir.exists())){
			dir.mkdir();	
			try {
				dataBarang=new FileOutputStream("Data/Data.txt");
				dataBarang.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//end of 
	}//end of createDirectory()--------------------------------------------------
	
	public int length(){//-------------------------------------------------------
		int nData=0;
		try {
			FileInputStream data=new FileInputStream("Data/Data.txt");
			BufferedReader dataIn=new BufferedReader(new InputStreamReader(data));
			while((dataIn.readLine())!=null){
				nData++;				
			}
			dataIn.close();
			data.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end of try		
		return nData;
	}//end of length--------------------------------------------------------------
	
	public int[][] view(){//------------------------------------------------------
		int[][] dataOut=new int[this.length()][3];
		try {
			FileInputStream data=new FileInputStream("Data/Data.txt");
			BufferedReader dataIn=new BufferedReader(new InputStreamReader(data));
			String[] dataValue=new String[3];
			String thisLine;
			int i=0;
			while((thisLine=dataIn.readLine())!=null){
				dataValue=thisLine.split(",");	
				for(int j=0;j<3;j++){
					dataOut[i][j]=Integer.parseInt(dataValue[j].trim());
				}//end of for int j				
				i++;
			}
			dataIn.close();
			data.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end of try		
		return dataOut;
	}//end of view----------------------------------------------------------------
	
	public String[][] stringView(){//---------------------------------------------
		String[][] dataOut=new String[this.length()][3];
		int[][] dataView=this.view();
		for(int i=0;i<dataView.length;i++){
			for(int j=0;j<dataView[i].length;j++){
				dataOut[i][j]=String.valueOf(dataView[i][j]);
			}
		}		
		return dataOut;
	}//end of stringView----------------------------------------------------------
	
	public String[][] stringViewWithID(){//---------------------------------------------
		String[][] dataOut=new String[this.length()][4];
		int[][] dataView=this.view();
		for(int i=0;i<dataView.length;i++){
			int a=i;
			dataOut[i][0]=String.valueOf(a+1);
			dataOut[i][1]=String.valueOf(dataView[i][0]);
			dataOut[i][2]=String.valueOf(dataView[i][1]);
			dataOut[i][3]=String.valueOf(dataView[i][2]);
		}		
		return dataOut;
	}//end of stringView----------------------------------------------------------
	
	public String cariPanjangByID(int ID){//--------------------------------------
		String panjang="";		
		String[][] ViewWithID=this.stringViewWithID();
		panjang=ViewWithID[ID-1][1];		
		return panjang;
	}//end of cariPanjangByID-----------------------------------------------------
	
	public String cariLebarByID(int ID){//--------------------------------------
		String lebar="";		
		String[][] ViewWithID=this.stringViewWithID();
		lebar=ViewWithID[ID-1][2];		
		return lebar;
	}//end of cariLebarByID-----------------------------------------------------
	
	public String cariTinggiByID(int ID){//--------------------------------------
		String tinggi="";		
		String[][] ViewWithID=this.stringViewWithID();
		tinggi=ViewWithID[ID-1][3];		
		return tinggi;
	}//end of cariTinggiByID-----------------------------------------------------
	
	
	public void insert(int panjang,int lebar,int tinggi){//-----------------------
		try {
			FileInputStream data=new FileInputStream("Data/Data.txt");
			BufferedReader dataIn=new BufferedReader(new InputStreamReader(data));
			String thisLine,mergeLine="";
			while((thisLine=dataIn.readLine())!=null){
				mergeLine+=thisLine+"\n";					
			}
			dataIn.close();
			data.close();
			mergeLine+=String.valueOf(panjang)+","+String.valueOf(lebar)+","+String.valueOf(tinggi);			
			FileOutputStream dataOut=new FileOutputStream("Data/Data.txt");
			new PrintStream(dataOut).print(mergeLine);
			dataOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end of try	
	}//end of insert//-------------------------------------------------------------
	
	public void delete(int id){//--------------------------------------------------
		try {
			FileInputStream data=new FileInputStream("Data/Data.txt");
			BufferedReader dataIn=new BufferedReader(new InputStreamReader(data));
			String thisLine,mergeLine="";
			int i=1;
			while((thisLine=dataIn.readLine())!=null){
				if(i!=id){
					mergeLine+=thisLine+"\n";
				}//end of if				
				i++;
			}
			dataIn.close();
			data.close();			
			FileOutputStream dataOut=new FileOutputStream("Data/Data.txt");
			new PrintStream(dataOut).print(mergeLine);
			dataOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end of try
	}//end of delete---------------------------------------------------------------
	
	public void update(int id,int panjang,int lebar,int tinggi){//-----------------
		try {
			FileInputStream data=new FileInputStream("Data/Data.txt");
			BufferedReader dataIn=new BufferedReader(new InputStreamReader(data));
			String thisLine,mergeLine="";
			int i=1;
			while((thisLine=dataIn.readLine())!=null){
				if(i!=id){
					mergeLine+=thisLine+"\n";
				}//end of if		
				else{
					mergeLine+=String.valueOf(panjang)+","+String.valueOf(lebar)+","+String.valueOf(tinggi)+"\n";
				}//end of else
				i++;
			}
			dataIn.close();
			data.close();			
			FileOutputStream dataOut=new FileOutputStream("Data/Data.txt");
			new PrintStream(dataOut).print(mergeLine);
			dataOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end of try
	}//end of update---------------------------------------------------------------
	
	public void reset(){//---------------------------------------------------------
		try {
			FileOutputStream dataOut=new FileOutputStream("Data/Data.txt");
			new PrintStream(dataOut).print("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end of try
	}//end of reset----------------------------------------------------------------

}//end of class
