package peter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.FileUtils;

public class Disassemble {
	public static String disassemble(long address, int bits) {
		try {
			int bytes[] = CommonLib.getMemoryFromBochs(address, 100);
			FileUtils.writeByteArrayToFile(new File("temp"), CommonLib.intArrayToByteArray(bytes));

			ProcessBuilder pb;
			if (Application.isLinux) {
				pb = new ProcessBuilder("ndisasm", "-b " + bits, "temp");
			} else {
				pb = new ProcessBuilder("ndisasm.exe", "-b " + bits, "temp");
			}

			pb.redirectErrorStream(true);
			Process p;

			p = pb.start();
			String str = "";
			InputStream is = p.getInputStream();
			final BufferedReader br = new BufferedReader(new InputStreamReader(is), 1024);
			String line;
			while ((line = br.readLine()) != null) {
				str += line + "\n";
			}
			new File("temp").delete();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
