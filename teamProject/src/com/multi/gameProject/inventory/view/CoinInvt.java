package com.multi.gameProject.inventory.view;

import com.multi.gameProject.inventory.controller.InvtController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoinInvt {
    private String userId = "ID";
    private InvtController invtController = new InvtController();
    private JFrame f;
    private Font font2 = new Font("굴림", Font.BOLD, 30);
    private Font font3 = new Font("굴림", java.awt.Font.BOLD, 20);
    private JPanel headerP;
    private JPanel midP;
    private JPanel footerP;
    private JTextField input;
    private JTextField output;
    private int coin;
    private int score;
    private JLabel myCoin2;
    private JLabel myScore2;
    private JButton menuBtn1;
    private JButton menuBtn2;

    public void coinInvtView() {
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 800);
        f.setTitle("코마에 사칙연산 게임");

        initHeaderP();
        initMidP();
        initFooterP();

        f.add(headerP, BorderLayout.PAGE_START);
        f.add(midP, BorderLayout.CENTER);
        f.add(footerP, BorderLayout.PAGE_END);

        f.setVisible(true);
    }

    private void initHeaderP() {
        headerP = new JPanel(new GridLayout(0, 2, 50, 50)); // 위
        headerP.setBackground(new Color(40, 60, 79));
        headerP.setBorder(BorderFactory.createEmptyBorder(30, 100, 40, 100)); // 여백(=padding)

        menuBtn1 = new JButton("코인");
        menuBtn2 = new JButton("아이템");

        menuBtn1.setFont(font2);
        menuBtn2.setFont(font2);

        menuBtn1.setBackground(new Color(253, 219, 0, 255));
        menuBtn2.setBackground(new Color(63, 228, 192));

        headerP.add(menuBtn1);
        headerP.add(menuBtn2);


        menuBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new ItemInvt().ItemInvtView();
            }
        });
    }

    private void initMidP() {
        midP = new JPanel(new GridLayout(0, 1)); // 가운데
        midP.setBackground(new Color(40, 60, 79));
        midP.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20)); // 여백(=padding)

        JPanel myCoinP = new JPanel(new GridLayout(0, 2));
        JPanel myScoreP = new JPanel(new GridLayout(0, 2));
        JPanel changeP = new JPanel(new GridLayout(0, 3, 10, 0));

        JLabel myCoin1 = new JLabel("나의 코인", 0);
        coin = invtController.getUserCoin(userId);
        myCoin2 = new JLabel(coin + "개", 0);
        myCoin1.setFont(font3);
        myCoin2.setFont(font2);
        myCoinP.add(myCoin1);
        myCoinP.add(myCoin2);

        JLabel myScore1 = new JLabel("보유 점수", 0);
        score = invtController.getUserScore(userId);
        myScore2 = new JLabel(score + "점", 0);
        myScore1.setFont(font3);
        myScore2.setFont(font2);
        myScoreP.add(myScore1);
        myScoreP.add(myScore2);

        JLabel changeTitle1 = new JLabel("점수 ▶ 코인 전환하기" + "   (※ 점수 100점당 코인 1개)", 0);
        changeTitle1.setFont(font3);
        changeTitle1.setForeground(Color.white);

        JPanel changeScoreP = new JPanel(new GridLayout(0, 1));
        JLabel changeScoreL = new JLabel("전환할 점수 (점)", 0);
        input = new JTextField("", 10);
        input.setHorizontalAlignment(0);

        JPanel arrorwP = new JPanel(null);
        ImageIcon arrowImg = new ImageIcon("img/arrow.png");
        JLabel arrowL = new JLabel(arrowImg, 0);
        arrowL.setBounds(50, 10, 80, 80);
        JButton checkBtn = new JButton("확인하기");
        checkBtn.setFont(new Font("굴림", Font.BOLD, 15));
        checkBtn.setBackground(Color.yellow);
        checkBtn.setBounds(38, 85, 100, 25);

        arrorwP.add(arrowL);
        arrorwP.add(checkBtn, BorderLayout.SOUTH);

        JPanel changeCoinP = new JPanel(new GridLayout(0, 1));
        JLabel changeCoinL = new JLabel("전환될 코인 (개)", 0);
        output = new JTextField(10);
        output.setEditable(false);
        output.setBackground(Color.white);
        output.setHorizontalAlignment(0);

        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int inputScore;
                if (input.getText().length() == 0 || input.getText().equals("0")) {
                    showDialog("전환할 점수를 입력해주세요.");
                } else {
                    inputScore = Integer.parseInt(input.getText());

                    int outputCoin = invtController.getOutputCoin(userId, inputScore);
                    output.setText(outputCoin + "개");
                }
            }
        });

        changeScoreL.setFont(font3);
        input.setFont(font2);

        changeCoinL.setFont(font3);
        output.setFont(font2);

        changeScoreP.add(changeScoreL);
        changeScoreP.add(input);
        changeCoinP.add(changeCoinL);
        changeCoinP.add(output);

        changeP.add(changeScoreP);
        changeP.add(arrorwP);
        changeP.add(changeCoinP);

        midP.add(myCoinP);
        midP.add(myScoreP);
        midP.add(changeTitle1);
        midP.add(changeP);

    }


    private void initFooterP() {
        footerP = new JPanel(new BorderLayout()); // 아래
        footerP.setBackground(new Color(40, 60, 79));
        footerP.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // 여백(=padding)
        JButton GoToStoreBtn = new JButton("상점으로");
        GoToStoreBtn.setBorderPainted(false);
        GoToStoreBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
        GoToStoreBtn.setFont(font2);
        GoToStoreBtn.setBackground(new Color(63, 228, 192));
        JButton changeBtn = new JButton(" 전  환 ");
        changeBtn.setBorderPainted(false);
        changeBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
        changeBtn.setFont(font2);
        changeBtn.setBackground(new Color(63, 228, 192));
        footerP.add(changeBtn, BorderLayout.LINE_START);
        footerP.add(GoToStoreBtn, BorderLayout.LINE_END);

        changeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input.getText().length() == 0 || input.getText() == "0") {
                    showDialog("전환할 점수를 입력해주세요.");
                } else {
                    int inputScore = Integer.parseInt(input.getText());

                    int result = invtController.changeScoreToCoin(userId, inputScore);

                    if (result == 1) {
                        input.setText("");
                        output.setText("");
                        myCoin2.setText(invtController.getUserCoin(userId) + "개");
                        myScore2.setText(invtController.getUserScore(userId) + "개");
                        showDialog("전환완료");
                    } else {
                        input.setText("");
                        output.setText("");
                        showDialog("전환실패");
                    }
                }

            }
        });

        GoToStoreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Store().storeView();
            }
        });
    }

    public void showDialog(String inform) {
        JOptionPane.showMessageDialog(f, inform);
    }
}
