package sudoku;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputEvent implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        boolean valid = false;
        boolean isDigit = Character.isDigit(e.getKeyChar());

        JTextField cellSource = (JTextField) e.getSource();

        if (isDigit || e.getKeyChar() == '\b') {
            for (int i = 0; i < Sudoku.GRID_SIZE && !valid; i++) {
                for (int j = 0; j < Sudoku.GRID_SIZE && !valid; j++) {
                    if (Sudoku.cellValues[i][j] == cellSource) {
                        if (String.valueOf(Sudoku.solvedSudoku[i][j]).equals(String.valueOf(e.getKeyChar()))) {
                            valid = true;
                            Sudoku.masks[i][j] = true;
                            Sudoku.cellValues[i][j].setText(String.valueOf(e.getKeyChar()));
                            Sudoku.cellValues[i][j].setBackground(Sudoku.OPEN_CELL_TRUE_COLOR);
                            Sudoku.cellValues[i][j].setEditable(false);
                            if (Sudoku.checkWin()) {
                                JOptionPane.showMessageDialog(null, "Congratulations!");
                            }
                        }
                        else if (e.getKeyChar() == '\b') {
                            valid = true;
                            Sudoku.cellValues[i][j].setText("");
                            Sudoku.cellValues[i][j].setBackground(Sudoku.OPEN_CELL_COLOR);
                        }
                        else {
                            valid = true;
                            Sudoku.cellValues[i][j].setBackground(Sudoku.OPEN_CELL_FALSE_COLOR);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
