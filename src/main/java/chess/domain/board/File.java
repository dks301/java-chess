package chess.domain.board;

/**
 *    체스판 열을 의미하는 enum입니다.
 *
 *    @author AnHyungJu, LeeHoBin
 */
public enum File {
	A("a", 8),
	B("b", 7),
	C("c", 6),
	D("d", 5),
	E("e", 4),
	F("f", 3),
	G("g", 2),
	H("h", 1);

	private String file;
	private int columnNumber;

	File(String file, int columnNumber) {
		this.file = file;
		this.columnNumber = columnNumber;
	}

	public String getFile() {
		return file;
	}

	public int getColumnNumber() {
		return columnNumber;
	}
}
