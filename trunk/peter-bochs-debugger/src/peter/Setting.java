package peter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

import org.apache.commons.betwixt.io.BeanReader;
import org.apache.commons.betwixt.io.BeanWriter;

public class Setting {
	LinkedHashSet<String> bochsCommandHistory = new LinkedHashSet<String>();
	TreeSet<String> memoryCombo = new TreeSet<String>();
	LinkedList<Breakpoint> breakpoint = new LinkedList<Breakpoint>();

	public LinkedList<Breakpoint> getBreakpoint() {
		return breakpoint;
	}

	public void setBreakpoint(LinkedList<Breakpoint> breakpoint) {
		this.breakpoint = breakpoint;
	}

	public Setting() {
		// memoryCombo.add("123");
		// memoryCombo.add("456");
		// memoryCombo.add("789");
		//
		// Breakpoint hm = new Breakpoint();
		// hm.setType("ppp");
		// breakpoint.add(hm);
		// hm = new Breakpoint();
		// hm.setType("address");
		// breakpoint.add(hm);
	}

	String lastElfHistoryOpenDir = new File(".").getAbsolutePath();
	String lastElfHistoryOpenDir2 = new File(".").getAbsolutePath();

	public String getLastElfHistoryOpenDir2() {
		return lastElfHistoryOpenDir2;
	}

	public void setLastElfHistoryOpenDir2(String lastElfHistoryOpenDir2) {
		this.lastElfHistoryOpenDir2 = lastElfHistoryOpenDir2;
	}

	public String getLastElfHistoryOpenDir() {
		return lastElfHistoryOpenDir;
	}

	public void setLastElfHistoryOpenDir(String lastElfHistoryOpenDir) {
		this.lastElfHistoryOpenDir = lastElfHistoryOpenDir;
	}

	public void addBreakpoint(Breakpoint breakpoint) {
		this.breakpoint.add(breakpoint);
	}

	// public void setBreakpoint(LinkedList breakpoints) {
	// System.out.println(breakpoints);
	// // this.breakpoint = breakpoints;
	// }

	public TreeSet<String> getMemoryCombo() {
		return memoryCombo;
	}

	public void setMemoryCombo(TreeSet<String> memoryCombo) {
		this.memoryCombo = memoryCombo;
	}

	public void addMemoryCombo(String str) {
		memoryCombo.add(str);
	}

	public LinkedHashSet<String> getBochsCommandHistory() {
		return bochsCommandHistory;
	}

	public void setBochsCommandHistory(LinkedHashSet<String> bochsCommandHistory) {
		this.bochsCommandHistory = bochsCommandHistory;
	}

	public void addBochsCommandHistory(String str) {
		if (str != null) {
			bochsCommandHistory.add(str);
		}
	}

	public void save() {
		try {
			// Start by preparing the writer
			// We'll write to a string
			FileWriter outputWriter = new FileWriter(new File("peter-bochs.xml"));

			// Betwixt just writes out the bean as a fragment
			// So if we want well-formed xml, we need to add the prolog
			outputWriter.write("<?xml version='1.0' ?>");

			// Create a BeanWriter which writes to our prepared stream
			BeanWriter beanWriter = new BeanWriter(outputWriter);

			// Configure betwixt
			// For more details see java docs or later in the main documentation
			beanWriter.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
			beanWriter.getBindingConfiguration().setMapIDs(false);
			beanWriter.enablePrettyPrint();

			// If the base element is not passed in, Betwixt will guess
			// But let's write example bean as base element 'person'
			beanWriter.write("Setting", this);

			// Write to System.out
			// (We could have used the empty constructor for BeanWriter
			// but this way is more instructive)

			// Betwixt writes fragments not documents so does not automatically
			// close
			// writers or streams.
			// This example will do no more writing so close the writer now.
			outputWriter.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Setting load() {
		try {
			File file = new File("peter-bochs.xml");
			if (!file.exists()) {
				return new Setting();
			}

			FileReader reader = new FileReader(file);

			BeanReader beanReader = new BeanReader();
			beanReader.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
			beanReader.getBindingConfiguration().setMapIDs(false);
			beanReader.setValidating(false);
			beanReader.registerBeanClass("Setting", Setting.class);

			Setting setting = (Setting) beanReader.parse(reader);

			if (Global.debug) {
				System.out.println("breakpoint=" + setting.breakpoint.size());
				System.out.println("getMemoryCombo=" + setting.getMemoryCombo().size());
				System.out.println("peter=" + setting.getBreakpoint().size());
			}
			return setting;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Setting();
		}
	}

	public static void main(String args[]) {
		// new Setting().save();
		Setting setting = Setting.load();
	}
}
