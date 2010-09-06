package peter.instrument.callgraph;

public class JmpData {
	public long segmentStart;
	public long segmentEnd;
	public long from;
	public long to;

	public JmpData(long segmentStart, long segmentEnd, long from, long to) {
		this.segmentStart = segmentStart;
		this.segmentEnd = segmentEnd;
		this.from = from;
		this.to = to;
	}
}
