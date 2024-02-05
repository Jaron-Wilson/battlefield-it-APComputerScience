import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinesweeperGUI extends JFrame {
    private final int rows;
    private final int cols;
    private final int numMines;
    private JButton[][] buttons;
    private char[][] board;
    private boolean[][] revealed;
    private boolean gameOver;

    public MinesweeperGUI(int rows, int cols, int numMines) {
        this.rows = rows;
        this.cols = cols;
        this.numMines = numMines;
        this.buttons = new JButton[rows][cols];
        this.board = new char[rows][cols];
        this.revealed = new boolean[rows][cols];
        this.gameOver = false;

        initializeBoard();
        initializeGUI();
    }

    private void initializeBoard() {
        // Initialize the board with empty cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = ' ';
                revealed[i][j] = false;
            }
        }

        // Place mines randomly
        int minesPlaced = 0;
        while (minesPlaced < numMines) {
            int row = (int) (Math.random() * rows);
            int col = (int) (Math.random() * cols);
            if (board[row][col] != 'M') {
                board[row][col] = 'M';
                minesPlaced++;
            }
        }
    }

    private void initializeGUI() {
        setTitle("Jarons Minesweeper Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(rows, cols));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(90, 90));
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 14));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                buttonPanel.add(buttons[i][j]);
            }
        }

        add(buttonPanel, BorderLayout.CENTER);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetGame());
        resetButton.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel controlPanel = new JPanel();
        controlPanel.add(resetButton);

        add(controlPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void revealCell(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || revealed[row][col]) {
            return;
        }

        revealed[row][col] = true;

        if (board[row][col] == 'M') {
            // Game over if mine is revealed
            gameOver = true;
            revealAllMines();
            showGameOverDialog();
            return;
        }

        int count = countSurroundingMines(row, col);
        buttons[row][col].setText(count > 0 ? Integer.toString(count) : "");
        buttons[row][col].setEnabled(false); // Disable the button after revealing

        if (count == 0) {
            // If the cell is empty, recursively reveal adjacent cells
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    revealCell(i, j);
                }
            }
        }

        if (checkWin()) {
            showWinDialog();
        }
    }

    private int countSurroundingMines(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < cols && board[i][j] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }

    private void revealAllMines() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'M') {
                    buttons[i][j].setText("M");
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setBackground(Color.RED);
                }
            }
        }
    }

    private boolean checkWin() {
        // Check if all non-mine cells are revealed
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != 'M' && !revealed[i][j]) {
                    return false;
                }
            }
        }
        // All non-mine cells revealed, player wins
        return true;
    }

    private void showGameOverDialog() {
        JOptionPane.showMessageDialog(this, "Game Over!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showWinDialog() {
        JOptionPane.showMessageDialog(this, "Congratulations! You Win!", "You Win", JOptionPane.INFORMATION_MESSAGE);
    }

    private void resetGame() {
        // Reset the game by creating a new instance of MinesweeperGUI
        dispose();
        new MinesweeperGUI(rows, cols, numMines);
    }

    private class ButtonClickListener implements ActionListener {
        private final int row;
        private final int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            revealCell(row, col);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MinesweeperGUI(10, 10, 10));
    }
}