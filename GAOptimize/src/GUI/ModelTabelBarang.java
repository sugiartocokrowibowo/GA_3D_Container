package GUI;

import javax.swing.table.AbstractTableModel;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
public class ModelTabelBarang extends AbstractTableModel{
	String [][] data;
	String [] field;
	
	public ModelTabelBarang(String[][] data, String[] field) {
		super();
		this.data = data;
		this.field = field;
	}

	public void setFieldValue(String[] namaField){
		field=namaField;
	}
	
	public void setDataValue(String[][] dataTabel){
		data=dataTabel;
	}
	
	public void refreshData(String[][] dataTabel, String[] namaField){
		data=dataTabel;
		field=namaField;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return field.length;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	public Object getValueAt(int x, int y) {
		// TODO Auto-generated method stub
		return data[x][y];
	}
	
	public String getColumnName(int c) {
	    return field[c];
	  }
	
	public Class getColumnClass(int c) {
	    return data[0][c].getClass();
	  }
	

}//end of class
