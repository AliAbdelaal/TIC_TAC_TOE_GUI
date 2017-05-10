package XO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ali on 12/26/16.
 */
public class Game {

    private JPanel panel1;
    private JButton a0;
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private JButton a4;
    private JButton a5;
    private JButton a6;
    private JButton a7;
    private JButton a8;

    private boolean xTurn = true;
    private char gameMap[][];
    private JButton buttonsMap[][];


    public Game() {
        gameMap = new char[3][3];
        buttonsMap = new JButton[3][3];
        buttonsMap[0][0] = a0;
        buttonsMap[0][1] = a1;
        buttonsMap[0][2] = a2;
        buttonsMap[1][0] = a3;
        buttonsMap[1][1] = a4;
        buttonsMap[1][2] = a5;
        buttonsMap[2][0] = a6;
        buttonsMap[2][1] = a7;
        buttonsMap[2][2] = a8;


        a0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameMap[0][0] == 0) {
                    gameMap[0][0] = (xTurn ? 'X' : 'O');
                    xTurn = !xTurn;
                    updateUI();
                }
            }
        });
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameMap[0][1] == 0) {
                    gameMap[0][1] = (xTurn ? 'X' : 'O');
                    xTurn = !xTurn;
                    updateUI();
                }
            }
        });
        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameMap[0][2] == 0) {
                    gameMap[0][2] = (xTurn ? 'X' : 'O');
                    xTurn = !xTurn;
                    updateUI();
                }
            }
        });
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameMap[1][0] == 0) {
                    gameMap[1][0] = (xTurn ? 'X' : 'O');
                    xTurn = !xTurn;
                    updateUI();
                }
            }
        });
        a4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameMap[1][1] == 0) {
                    gameMap[1][1] = (xTurn ? 'X' : 'O');
                    xTurn = !xTurn;
                    updateUI();
                }

            }
        });
        a5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameMap[1][2] == 0) {
                    gameMap[1][2] = (xTurn ? 'X' : 'O');
                    xTurn = !xTurn;
                    updateUI();
                }

            }
        });
        a6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameMap[2][0] == 0) {
                    gameMap[2][0] = (xTurn ? 'X' : 'O');
                    xTurn = !xTurn;
                    updateUI();
                }

            }
        });
        a7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameMap[2][1] == 0) {
                    gameMap[2][1] = (xTurn ? 'X' : 'O');
                    xTurn = !xTurn;
                    updateUI();
                }

            }
        });
        a8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameMap[2][2] == 0) {
                    gameMap[2][2] = (xTurn ? 'X' : 'O');
                    xTurn = !xTurn;
                    updateUI();
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        frame.setContentPane(new Game().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private void updateUI() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonsMap[i][j].setText(gameMap[i][j] == 0 ? " " : String.valueOf(gameMap[i][j]));
                buttonsMap[i][j].setForeground(gameMap[i][j] == 0 ? Color.BLACK : (gameMap[i][j] == 'X' ? Color.RED : Color.GREEN));
            }
        }
        checkGame();

    }


    private void checkGame() {
        char winner = 0;
        //check rows
        for (int i = 0; i < 3; i++) {
            if (gameMap[i][0] == gameMap[i][1] && gameMap[i][0] == gameMap[i][2] && gameMap[i][0] != 0) {
                winner = gameMap[i][0];
                break;
            }
        }
        if (winner == 0)
            //check cols
            for (int i = 0; i < 3; i++) {
                if (gameMap[0][i] == gameMap[1][i] && gameMap[0][i] == gameMap[2][i] && gameMap[0][i] != 0) {
                    winner = gameMap[0][i];
                    break;
                }
            }
        if (winner == 0) {
            //check diagonals
            if (gameMap[0][0] == gameMap[1][1] && gameMap[0][0] == gameMap[2][2])
                winner = gameMap[1][1];
            if (gameMap[0][2] == gameMap[1][1] && gameMap[0][2] == gameMap[2][0])
                winner = gameMap[1][1];
        }

        if (winner != 0) {
            JOptionPane.showMessageDialog(panel1, "Player " + winner + " is the winner !!");
            gameMap = new char[3][3];
            updateUI();
        } else {
            //check draw
            boolean draw = true;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (gameMap[i][j] == 0) {
                        draw = false;
                        break;
                    }
            if (draw) {
                JOptionPane.showMessageDialog(panel1, "That's a draw !!");
                gameMap = new char[3][3];
                updateUI();
            }
        }

    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setBackground(new Color(-16777216));
        panel1.setEnabled(true);
        panel1.setForeground(new Color(-16777216));
        panel1.setMinimumSize(new Dimension(800, 800));
        panel1.setPreferredSize(new Dimension(800, 800));
        a0 = new JButton();
        a0.setAutoscrolls(false);
        a0.setBackground(new Color(-16777216));
        a0.setFocusable(false);
        a0.setFont(new Font("Comic Sans MS", Font.BOLD, 72));
        a0.setForeground(new Color(-16777216));
        a0.setHideActionText(true);
        a0.setHorizontalTextPosition(0);
        a0.setInheritsPopupMenu(false);
        a0.setText("");
        a0.setVerifyInputWhenFocusTarget(false);
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(a0, gbc);
        a1 = new JButton();
        a1.setAutoscrolls(false);
        a1.setBackground(new Color(-16777216));
        a1.setFocusable(false);
        a1.setFont(new Font("Comic Sans MS", Font.BOLD, 72));
        a1.setForeground(new Color(-16777216));
        a1.setHideActionText(true);
        a1.setHorizontalTextPosition(0);
        a1.setInheritsPopupMenu(false);
        a1.setText("");
        a1.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(a1, gbc);
        a2 = new JButton();
        a2.setAutoscrolls(false);
        a2.setBackground(new Color(-16777216));
        a2.setFocusable(false);
        a2.setFont(new Font("Comic Sans MS", Font.BOLD, 72));
        a2.setForeground(new Color(-16777216));
        a2.setHideActionText(true);
        a2.setHorizontalTextPosition(0);
        a2.setInheritsPopupMenu(false);
        a2.setText("");
        a2.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(a2, gbc);
        a3 = new JButton();
        a3.setAutoscrolls(false);
        a3.setBackground(new Color(-16777216));
        a3.setFocusable(false);
        a3.setFont(new Font("Comic Sans MS", Font.BOLD, 72));
        a3.setForeground(new Color(-16777216));
        a3.setHideActionText(true);
        a3.setHorizontalTextPosition(0);
        a3.setInheritsPopupMenu(false);
        a3.setText("");
        a3.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(a3, gbc);
        a4 = new JButton();
        a4.setAutoscrolls(false);
        a4.setBackground(new Color(-16777216));
        a4.setFocusable(false);
        a4.setFont(new Font("Comic Sans MS", Font.BOLD, 72));
        a4.setForeground(new Color(-16777216));
        a4.setHideActionText(true);
        a4.setHorizontalTextPosition(0);
        a4.setInheritsPopupMenu(false);
        a4.setText("");
        a4.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(a4, gbc);
        a5 = new JButton();
        a5.setAutoscrolls(false);
        a5.setBackground(new Color(-16777216));
        a5.setFocusable(false);
        a5.setFont(new Font("Comic Sans MS", Font.BOLD, 72));
        a5.setForeground(new Color(-16777216));
        a5.setHideActionText(true);
        a5.setHorizontalTextPosition(0);
        a5.setInheritsPopupMenu(false);
        a5.setText("");
        a5.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(a5, gbc);
        a6 = new JButton();
        a6.setAutoscrolls(false);
        a6.setBackground(new Color(-16777216));
        a6.setFocusable(false);
        a6.setFont(new Font("Comic Sans MS", Font.BOLD, 72));
        a6.setForeground(new Color(-16777216));
        a6.setHideActionText(true);
        a6.setHorizontalTextPosition(0);
        a6.setInheritsPopupMenu(false);
        a6.setText("");
        a6.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(a6, gbc);
        a7 = new JButton();
        a7.setAutoscrolls(false);
        a7.setBackground(new Color(-16777216));
        a7.setFocusable(false);
        a7.setFont(new Font("Comic Sans MS", Font.BOLD, 72));
        a7.setForeground(new Color(-16777216));
        a7.setHideActionText(true);
        a7.setHorizontalTextPosition(0);
        a7.setInheritsPopupMenu(false);
        a7.setText("");
        a7.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(a7, gbc);
        a8 = new JButton();
        a8.setAutoscrolls(false);
        a8.setBackground(new Color(-16777216));
        a8.setFocusable(false);
        a8.setFont(new Font("Comic Sans MS", Font.BOLD, 72));
        a8.setForeground(new Color(-16777216));
        a8.setHideActionText(true);
        a8.setHorizontalTextPosition(0);
        a8.setInheritsPopupMenu(false);
        a8.setText("");
        a8.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(a8, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
