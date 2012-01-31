package peter.sourceleveldebugger;

import java.io.File;

public class Function implements Comparable {
	File file;
	int fileOffset;
	int size;
	String name;
	String code;

	@Override
	public int compareTo(Object o) {
		try {
			if (o instanceof Function) {
				Function f = (Function) o;
				if (file.getCanonicalFile() == f.file.getCanonicalFile() && name.equals(f.name)) {
					return 0;
				} else {
					return name.compareTo(f.name);
				}
			} else {
				return 1;
			}
		} catch (Exception ex) {
			return 1;
		}
	}
}
