import sac.graph.AStar;

public class Main {

    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        String sudoku = "200080300" +
                "060070084" +
                "030500209" +
                "000105408" +
                "000000000" +
                "402706000" +
                "301007040" +
                "720040060" +
                "004010003";
        s.fromSudoku(sudoku);
        System.out.println(s.isLegal());
        System.out.println(s.toString());
    }
    AStar a = new AStar();
}
