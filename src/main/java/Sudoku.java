public class Sudoku {

    public static final int size = 3;
    public static final int size2 = size * size;

    private byte[][] board;
    private int zeros = size2*size2;

    @Override
    public String toString() {
        String txt = "";
        for (int i = 0; i < size2; i++) {
            for (int j = 0; j < size2; j++) {
                txt += board[i][j] + ",";
            }
            txt += "\n";
        }
        System.out.println(zeros);
        return txt;
    }

    public boolean isGroupLegal(byte[] group) {
        boolean[] visited = new boolean[size2];
        for (int i = 0; i < size2; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < group.length; i++) {
            if (group[i] == 0) continue;
            if (visited[group[i] - 1]) return false;
            visited[group[i] - 1] = true;
        }
        return true;
    }

    public boolean isLegal() {
        byte[] group = new byte[size2];
        for (int i = 0; i < size2; i++) {
            for (int j = 0; j < size2; j++) {
                group[j] = board[i][j];
            }
        }
        if (!isGroupLegal(group)) return false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                group[j] = board[j][i];
                int q = 0;
                for (int x = 0; x < size; x++) {
                    for (int z = 0; z < size; z++) {
                        group[q++] = board[size * i + x][j + size + z];
                    }
                }
            }
        }

        if (!isGroupLegal(group)) return false;
        return true;
    }

    private void countZeros() {
        zeros = 0;
        for (int x = 0; x < size2; x++) {
            for (int z = 0; z < size2; z++) {
                if (board[x][z] == 0) ++zeros;
            }
        }
    }

    public void fromSudoku(String txt) {
        int k = 0;
        for (int i = 0; i < size2; i++) {
            for (int j = 0; j < size2; j++, k++) {
                board[i][j] = Byte.valueOf(txt.substring(k, k + 1));
            }
        }
        countZeros();
    }

    public Sudoku() {
        board = new byte[size2][size2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = 0;
            }
        }
    }
}
