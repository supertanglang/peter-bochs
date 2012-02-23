package com.peterbochs;

import java.util.Date;
import java.util.Vector;

public class AllRegisters {
	public static Vector<Date> time = new Vector<Date>();
	public static Vector<String> ptime = new Vector<String>();

	public static Vector<Long> eax = new Vector<Long>();
	public static Vector<Long> ebx = new Vector<Long>();
	public static Vector<Long> ecx = new Vector<Long>();
	public static Vector<Long> edx = new Vector<Long>();
	public static Vector<Long> esi = new Vector<Long>();
	public static Vector<Long> edi = new Vector<Long>();
	public static Vector<Long> ebp = new Vector<Long>();
	public static Vector<Long> esp = new Vector<Long>();

	public static Vector<Long> cs = new Vector<Long>();
	public static Vector<Long> eip = new Vector<Long>();
	public static Vector<Long> ds = new Vector<Long>();
	public static Vector<Long> es = new Vector<Long>();
	public static Vector<Long> fs = new Vector<Long>();
	public static Vector<Long> gs = new Vector<Long>();
	public static Vector<Long> ss = new Vector<Long>();
	public static Vector<String> eflags = new Vector<String>();

	public static Vector<Long> cr0 = new Vector<Long>();
	public static Vector<Long> cr2 = new Vector<Long>();
	public static Vector<Long> cr3 = new Vector<Long>();
	public static Vector<Long> cr4 = new Vector<Long>();

	public static Vector<Vector<Long>> stack = new Vector<Vector<Long>>();

	public static Vector<Long> gdtr = new Vector<Long>();
	public static Vector<Long> idtr = new Vector<Long>();
	public static Vector<Long> ldtr = new Vector<Long>();

	public static Vector<Vector<Long>> gdt = new Vector<Vector<Long>>();
	public static Vector<Vector<Long>> idt = new Vector<Vector<Long>>();
	public static Vector<Vector<Long>> ldt = new Vector<Vector<Long>>();

	public static Vector<Long> tr = new Vector<Long>();

	public static Vector<String> instructions = new Vector<String>();
	public static Vector<String> cCode = new Vector<String>();

	public static Vector<String> st0 = new Vector<String>();
	public static Vector<String> st1 = new Vector<String>();
	public static Vector<String> st2 = new Vector<String>();
	public static Vector<String> st3 = new Vector<String>();
	public static Vector<String> st4 = new Vector<String>();
	public static Vector<String> st5 = new Vector<String>();
	public static Vector<String> st6 = new Vector<String>();
	public static Vector<String> st7 = new Vector<String>();
	public static Vector<String> fpu_status = new Vector<String>();
	public static Vector<String> fpu_control = new Vector<String>();
	public static Vector<String> fpu_tag = new Vector<String>();
	public static Vector<String> fpu_operand = new Vector<String>();
	public static Vector<String> fip = new Vector<String>();
	public static Vector<String> fcs = new Vector<String>();
	public static Vector<String> fdp = new Vector<String>();
	public static Vector<String> fds = new Vector<String>();

	public static Vector<String> mm0 = new Vector<String>();
	public static Vector<String> mm1 = new Vector<String>();
	public static Vector<String> mm2 = new Vector<String>();
	public static Vector<String> mm3 = new Vector<String>();
	public static Vector<String> mm4 = new Vector<String>();
	public static Vector<String> mm5 = new Vector<String>();
	public static Vector<String> mm6 = new Vector<String>();
	public static Vector<String> mm7 = new Vector<String>();

	public static void clear() {
		time.clear();
		ptime.clear();

		eax.clear();
		ebx.clear();
		ecx.clear();
		edx.clear();
		esi.clear();
		edi.clear();
		ebp.clear();
		esp.clear();

		cs.clear();
		eip.clear();
		ds.clear();
		es.clear();
		fs.clear();
		gs.clear();
		ss.clear();
		eflags.clear();

		cr0.clear();
		cr2.clear();
		cr3.clear();
		cr4.clear();

		stack.clear();

		gdtr.clear();
		idtr.clear();
		ldtr.clear();

		gdt.clear();
		idt.clear();
		ldt.clear();

		tr.clear();

		instructions.clear();
		cCode.clear();

		st0.clear();
		st1.clear();
		st2.clear();
		st3.clear();
		st4.clear();
		st5.clear();
		st6.clear();
		st7.clear();
		fpu_status.clear();
		fpu_control.clear();
		fpu_tag.clear();
		fpu_operand.clear();
		fip.clear();
		fcs.clear();
		fdp.clear();
		fds.clear();

		mm0.clear();
		mm1.clear();
		mm2.clear();
		mm3.clear();
		mm4.clear();
		mm5.clear();
		mm6.clear();
		mm7.clear();
	}
}
