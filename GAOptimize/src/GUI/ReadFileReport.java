package GUI;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * 085796940283
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * @author Andi Nuraisyah Mathematics H11107010 UNHAS MAKASSAR 2011
 * andiaisyah@ymail.com
 * DILARANG KERAS MENGUTIP ATAU MEMINDAHKAN SEBAHAGIAN MAUPUN KESELURUHAN SOURCE CODE INI TANPA IZIN TERTULIS DARI ANDI NURAISYAH
 * Terima Kasih ****
 */
public class ReadFileReport {
	String filename;
	public String hasilBacaFile;
	public ReadFileReport(String filename)throws IOException {
		super();
		this.filename = filename;
		File f=new File(filename);
		int size=(int) f.length();
		int byte_read=0;
		FileInputStream in=new FileInputStream(f);
		byte[] data=new byte[size];
		
		while(byte_read<size){byte_read +=in.read(data, byte_read, size-byte_read);}
		this.hasilBacaFile=new String(data,0);
	}
}
