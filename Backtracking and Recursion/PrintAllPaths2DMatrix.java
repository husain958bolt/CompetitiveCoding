public class PrintAllPaths2DMatrix {

	int rowCount;
	int colCount;
	int[][] arrA;

	public PrintAllPaths2DMatrix(int arrA[][]) {
		this.arrA = arrA;
		rowCount = arrA.length;
		colCount = arrA[0].length;
	}

	public void printAll(int currentRow, int currentColumn, String path) {
		if (currentRow == rowCount - 1) {
			for (int i = currentColumn; i < colCount; i++) {
				path += "-" + arrA[currentRow][i];
			}
			System.out.println(path);
			return;
		}
		if (currentColumn == colCount - 1) {
			for (int i = currentRow; i <= rowCount - 1; i++) {
				path += "-" + arrA[i][currentColumn];
			}
			System.out.println(path);
			return;
		}
		path = path + "-" + arrA[currentRow][currentColumn];
		printAll(currentRow + 1, currentColumn, path);
		printAll(currentRow, currentColumn + 1, path);
	//	printAll(currentRow + 1, currentColumn + 1, path);
	}

	public static void main(String args[]) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
		PrintAllPaths2DMatrix p = new PrintAllPaths2DMatrix(a);
		p.printAll(0, 0, "");
	}

}
