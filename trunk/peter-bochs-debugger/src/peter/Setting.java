package peter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

import org.apache.commons.betwixt.io.BeanReader;
import org.apache.commons.betwixt.io.BeanWriter;

public class Setting {
	private static Setting setting = null;

	LinkedHashSet<String> bochsCommandHistory = new LinkedHashSet<String>();
	TreeSet<String> memoryCombo = new TreeSet<String>();
	LinkedList<Breakpoint> breakpoint = new LinkedList<Breakpoint>();

	String currentLanguage;
	int fontsize;
	String fontFamily;
	int x;
	int y;
	int width;
	int height;
	int divX;
	int divY;

	boolean loadBreakpointAtStartup;
	boolean updateAfterBochsCommand;
	boolean updateAfterBochsCommand_register;
	boolean updateAfterBochsCommand_memory;
	boolean updateAfterBochsCommand_instruction;
	boolean updateAfterBochsCommand_breakpoint;
	boolean updateAfterBochsCommand_gdt;
	boolean updateAfterBochsCommand_ldt;
	boolean updateAfterBochsCommand_idt;
	boolean updateAfterBochsCommand_pageTable;
	boolean updateAfterBochsCommand_stack;
	boolean updateAfterBochsCommand_addressTranslate;
	boolean updateAfterBochsCommand_history;

	public boolean isUpdateAfterBochsCommand_history() {
		return updateAfterBochsCommand_history;
	}

	public void setUpdateAfterBochsCommand_history(boolean updateAfterBochsCommandHistory) {
		updateAfterBochsCommand_history = updateAfterBochsCommandHistory;
	}

	public boolean isUpdateAfterBochsCommand_pageTable() {
		return updateAfterBochsCommand_pageTable;
	}

	public void setUpdateAfterBochsCommand_pageTable(boolean updateAfterBochsCommandPageTable) {
		updateAfterBochsCommand_pageTable = updateAfterBochsCommandPageTable;
	}

	public boolean isUpdateAfterBochsCommand_stack() {
		return updateAfterBochsCommand_stack;
	}

	public void setUpdateAfterBochsCommand_stack(boolean updateAfterBochsCommandStack) {
		updateAfterBochsCommand_stack = updateAfterBochsCommandStack;
	}

	public boolean isUpdateAfterBochsCommand_addressTranslate() {
		return updateAfterBochsCommand_addressTranslate;
	}

	public void setUpdateAfterBochsCommand_addressTranslate(boolean updateAfterBochsCommandAddressTranslate) {
		updateAfterBochsCommand_addressTranslate = updateAfterBochsCommandAddressTranslate;
	}

	boolean updateFastStepCommand_register;
	boolean updateFastStepCommand_memory;
	boolean updateFastStepCommand_instruction;
	boolean updateFastStepCommand_breakpoint;
	boolean updateFastStepCommand_gdt;
	boolean updateFastStepCommand_ldt;
	boolean updateFastStepCommand_idt;

	public boolean isUpdateFastStepCommand_register() {
		return updateFastStepCommand_register;
	}

	public void setUpdateFastStepCommand_register(boolean updateFastStepCommandRegister) {
		updateFastStepCommand_register = updateFastStepCommandRegister;
	}

	public boolean isUpdateFastStepCommand_memory() {
		return updateFastStepCommand_memory;
	}

	public void setUpdateFastStepCommand_memory(boolean updateFastStepCommandMemory) {
		updateFastStepCommand_memory = updateFastStepCommandMemory;
	}

	public boolean isUpdateFastStepCommand_instruction() {
		return updateFastStepCommand_instruction;
	}

	public void setUpdateFastStepCommand_instruction(boolean updateFastStepCommandInstruction) {
		updateFastStepCommand_instruction = updateFastStepCommandInstruction;
	}

	public boolean isUpdateFastStepCommand_breakpoint() {
		return updateFastStepCommand_breakpoint;
	}

	public void setUpdateFastStepCommand_breakpoint(boolean updateFastStepCommandBreakpoint) {
		updateFastStepCommand_breakpoint = updateFastStepCommandBreakpoint;
	}

	public boolean isUpdateFastStepCommand_gdt() {
		return updateFastStepCommand_gdt;
	}

	public void setUpdateFastStepCommand_gdt(boolean updateFastStepCommandGdt) {
		updateFastStepCommand_gdt = updateFastStepCommandGdt;
	}

	public boolean isUpdateFastStepCommand_ldt() {
		return updateFastStepCommand_ldt;
	}

	public void setUpdateFastStepCommand_ldt(boolean updateFastStepCommandLdt) {
		updateFastStepCommand_ldt = updateFastStepCommandLdt;
	}

	public boolean isUpdateFastStepCommand_idt() {
		return updateFastStepCommand_idt;
	}

	public void setUpdateFastStepCommand_idt(boolean updateFastStepCommandIdt) {
		updateFastStepCommand_idt = updateFastStepCommandIdt;
	}

	public boolean isUpdateAfterBochsCommand_register() {
		return updateAfterBochsCommand_register;
	}

	public void setUpdateAfterBochsCommand_register(boolean updateAfterBochsCommandRegister) {
		updateAfterBochsCommand_register = updateAfterBochsCommandRegister;
	}

	public boolean isUpdateAfterBochsCommand_memory() {
		return updateAfterBochsCommand_memory;
	}

	public void setUpdateAfterBochsCommand_memory(boolean updateAfterBochsCommandMemory) {
		updateAfterBochsCommand_memory = updateAfterBochsCommandMemory;
	}

	public boolean isUpdateAfterBochsCommand_instruction() {
		return updateAfterBochsCommand_instruction;
	}

	public void setUpdateAfterBochsCommand_instruction(boolean updateAfterBochsCommandInstruction) {
		updateAfterBochsCommand_instruction = updateAfterBochsCommandInstruction;
	}

	public boolean isUpdateAfterBochsCommand_breakpoint() {
		return updateAfterBochsCommand_breakpoint;
	}

	public void setUpdateAfterBochsCommand_breakpoint(boolean updateAfterBochsCommandBreakpoint) {
		updateAfterBochsCommand_breakpoint = updateAfterBochsCommandBreakpoint;
	}

	public boolean isUpdateAfterBochsCommand_gdt() {
		return updateAfterBochsCommand_gdt;
	}

	public void setUpdateAfterBochsCommand_gdt(boolean updateAfterBochsCommandGdt) {
		updateAfterBochsCommand_gdt = updateAfterBochsCommandGdt;
	}

	public boolean isUpdateAfterBochsCommand_ldt() {
		return updateAfterBochsCommand_ldt;
	}

	public void setUpdateAfterBochsCommand_ldt(boolean updateAfterBochsCommandLdt) {
		updateAfterBochsCommand_ldt = updateAfterBochsCommandLdt;
	}

	public boolean isUpdateAfterBochsCommand_idt() {
		return updateAfterBochsCommand_idt;
	}

	public void setUpdateAfterBochsCommand_idt(boolean updateAfterBochsCommandIdt) {
		updateAfterBochsCommand_idt = updateAfterBochsCommandIdt;
	}

	public boolean isUpdateAfterBochsCommand() {
		return updateAfterBochsCommand;
	}

	public void setUpdateAfterBochsCommand(boolean updateAfterBochsCommand) {
		this.updateAfterBochsCommand = updateAfterBochsCommand;
	}

	public static Setting getInstance() {
		if (setting == null) {
			setting = load();
		}
		return setting;
	}

	public boolean isLoadBreakpointAtStartup() {
		return loadBreakpointAtStartup;
	}

	public void setLoadBreakpointAtStartup(boolean loadBreakpointAtStartup) {
		this.loadBreakpointAtStartup = loadBreakpointAtStartup;
	}

	public Setting() {
		currentLanguage = "en_US";
		fontsize = 12;
		fontFamily = "Dialog";
		width = 800;
		height = 600;
		divX = 400;
		divY = 200;
	}

	public int getDivX() {
		return divX;
	}

	public void setDivX(int divX) {
		this.divX = divX;
	}

	public int getDivY() {
		return divY;
	}

	public void setDivY(int divY) {
		this.divY = divY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCurrentLanguage() {
		return currentLanguage;
	}

	public void setCurrentLanguage(String currentLanguage) {
		this.currentLanguage = currentLanguage;
	}

	public int getFontsize() {
		return fontsize;
	}

	public void setFontsize(int fontsize) {
		this.fontsize = fontsize;
	}

	public String getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	public LinkedList<Breakpoint> getBreakpoint() {
		return breakpoint;
	}

	public void setBreakpoint(LinkedList<Breakpoint> breakpoint) {
		this.breakpoint = breakpoint;
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

	private static Setting load() {
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

			return setting;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Setting();
		}
	}

	public static void main(String args[]) {
		// new Setting().save();
		Setting setting = Setting.getInstance();
	}
}
