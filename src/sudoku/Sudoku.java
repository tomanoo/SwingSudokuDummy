package sudoku;

import javax.swing.*;
import java.awt.*;

public class Sudoku extends JFrame {

    public static final int GRID_SIZE = 9;
    private static final int CELL_SIZE = 60;
    private static final int WIDTH = CELL_SIZE * GRID_SIZE;
    private static final int HEIGHT = CELL_SIZE * GRID_SIZE;
    public static final Color OPEN_CELL_COLOR = Color.WHITE;
    public static final Color OPEN_CELL_TRUE_COLOR = Color.GREEN;
    public static final Color OPEN_CELL_FALSE_COLOR = Color.RED;
    private static final Font FONT_MODEL = new Font("Sans-Serif", Font.BOLD, 30);

    public static JTextField[][] cellValues = new JTextField[GRID_SIZE][GRID_SIZE];

    public static int[][] solvedSudoku = {
                    {5,3,4,6,7,8,9,1,2},
                    {6,7,2,1,9,5,3,4,8},
                    {1,9,8,3,4,2,5,6,7},
                    {8,5,9,7,6,1,4,2,3},
                    {4,2,6,8,5,3,7,9,1},
                    {7,1,3,9,2,4,8,5,6},
                    {9,6,1,5,3,7,2,8,4},
                    {2,8,7,4,1,9,6,3,5},
                    {3,4,5,2,8,6,1,7,9}};

    public static boolean[][] masks = {
        {true,  true,  false, false, true,  false, false, false, false},
        {true,  false, false, true,  true,  true,  false, false, false},
        {false, true,  true,  false, false, false, false, true,  false},
        {true,  false, false, false, true,  false, false, false, true},
        {true,  false, false, true,  false, true,  false, false, true},
        {true,  false, false, false, true,  false, false, false, true},
        {false, true,  false, false, false, false, true,  true,  false},
        {false, false, false, true,  true,  true,  false, false, false},
        {false, false, false, false, true,  false, false, true,  true}};



    public Sudoku(){
        Container cp = getContentPane();
        GridLayout gl = new GridLayout(GRID_SIZE, GRID_SIZE);
        cp.setLayout(gl);

        KeyInputEvent keyInputEvent = new KeyInputEvent();

        for (int i=0; i<GRID_SIZE; i++) {
            for (int j=0; j<GRID_SIZE; j++) {
                cellValues[i][j] = new JTextField();
                cp.add(cellValues[i][j]);

                if (!masks[i][j]) {
                    cellValues[i][j].setText("");
                    cellValues[i][j].setEditable(true);
                    cellValues[i][j].setBackground(OPEN_CELL_COLOR);
                    cellValues[i][j].addKeyListener(keyInputEvent);
                }

                else {
                    cellValues[i][j].setText(String.valueOf(solvedSudoku[i][j]));
                    cellValues[i][j].setEditable(false);
                    cellValues[i][j].setBackground(OPEN_CELL_COLOR);
                }

                cellValues[i][j].setHorizontalAlignment(JTextField.CENTER);
                cellValues[i][j].setFont(FONT_MODEL);
            }
        }

        cp.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SUDOKU");
    }

    public static boolean checkWin() {
        for (int i=0; i<Sudoku.GRID_SIZE; i++) {
            for (int j = 0; j < Sudoku.GRID_SIZE; j++) {
                if (!cellValues[i][j].getText().equals(String.valueOf(solvedSudoku[i][j]))) {
                    return false;
                }
            }
        }
        return true;
    }
}
