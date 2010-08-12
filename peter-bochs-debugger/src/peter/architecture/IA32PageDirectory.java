package peter.architecture;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IA32PageDirectory implements Serializable {
	// @Override
	// public String toString() {
	// return "base=" + base + ", a=" + a + ", avl=" + avl + ", d=" + d + ", g="
	// + g + ", p=" + p + ", pcd=" + pcd + ", pwt=" + pwt + ", us=" + us +
	// ", wr=" + wr;
	// }

	@Override
	public String toString() {
		return base;
	}

	public String base;
	public String avl;
	public String g;
	public String d;
	public String a;
	public String pcd;
	public String pwt;
	public String us;
	public String wr;
	public String p;

	public IA32PageDirectory(String base, String avl, String g, String d, String a, String pcd, String pwt, String us, String wr, String p) {
		super();
		this.base = base;
		this.avl = avl;
		this.g = g;
		this.d = d;
		this.a = a;
		this.pcd = pcd;
		this.pwt = pwt;
		this.us = us;
		this.wr = wr;
		this.p = p;
	}

}
