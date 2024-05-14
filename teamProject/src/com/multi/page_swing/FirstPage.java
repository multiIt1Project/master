package com.multi.page_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FirstPage {
    private JFrame f;
    private Font font1 = new Font("굴림", Font.BOLD, 50);
    private Font font2 = new Font("굴림", Font.BOLD, 20);
    private JPanel headerP;
    private JPanel midP;
    private JPanel footerP;
    private JLabel titleL,blank,imgL;
    private int level=0;
    public FirstPage() {
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
        headerP = new JPanel(); // 위
        headerP.setBackground(new Color(40, 60, 79));
        headerP.setBorder(BorderFactory.createEmptyBorder(20 , 0,  0, 0)); // 여백(=padding)

        JButton menuBtn1 = new JButton("난이도1:");
        JButton menuBtn2 = new JButton("난이도2");
        JButton menuBtn3 = new JButton("난이도3");
        menuBtn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                blank.setText("난이도1");
                ImageIcon mainImg = new ImageIcon("");

                imgL.setIcon(mainImg);
                level=1;
            }
        });
        menuBtn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blank.setText("난이도2");
                ImageIcon mainImg = new ImageIcon("");

                imgL.setIcon(mainImg);

                level=2;
            }
        });
        menuBtn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon mainImg = new ImageIcon("");

                imgL.setIcon(mainImg);
                blank.setText("난이도3");
                level=3;
            }
        });
        menuBtn1.setFont(font2);
        menuBtn2.setFont(font2);
        menuBtn3.setFont(font2);


        menuBtn1.setBackground(new Color(63,228,192));
        menuBtn2.setBackground(new Color(63,228,192));
        menuBtn3.setBackground(new Color(63,228,192));


        headerP.add(menuBtn1);
        headerP.add(menuBtn2);
        headerP.add(menuBtn3);

    }

    private void initMidP() {
        midP = new JPanel(); // 가운데
        midP.setBackground(new Color(40, 60, 79));
        midP.setBorder(BorderFactory.createEmptyBorder(50 , 0, 0 , 0)); // 여백(=padding)

        titleL = new JLabel("코마에 사칙연산 게임");
        titleL.setFont(font1);
        titleL.setForeground(Color.white);
        titleL.setBorder(BorderFactory.createEmptyBorder(0 , 0, 20 , 0)); // 여백(=padding)
        midP.add(titleL);

        ImageIcon mainImg = new ImageIcon("img/img.png");
        imgL = new JLabel();
        imgL.setIcon(mainImg);
        midP.add(imgL);

        blank=new JLabel("  ");
        blank.setFont(font1);
        blank.setForeground(Color.white);
        blank.setBorder(BorderFactory.createEmptyBorder(0 , 0, 20 , 0)); // 여백(=padding)
        midP.add(blank);

    }


    private void initFooterP() {
        footerP = new JPanel(); // 아래
        footerP.setBackground(new Color(40, 60, 79));
        footerP.setBorder(BorderFactory.createEmptyBorder(0 , 0, 100 , 0)); // 여백(=padding)
        JButton startBtn = new JButton("START");
        startBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(0<level){
                GamePage g = new GamePage(level);
                    f.setVisible(false);

                }
                else {
                    JOptionPane.showMessageDialog(f,"난이도를 선택하시오");
                }
            }
        });
        startBtn.setBorderPainted(false);
        startBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
        startBtn.setFont(font1);
        startBtn.setBackground(new Color(63,228,192));
        footerP.add(startBtn);


        JButton exitBtn = new JButton("EXIT");
        exitBtn.setBorderPainted(false);
        exitBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // 여백(=padding)
        exitBtn.setFont(font1);
        exitBtn.setBackground(new Color(63,228,192));
        footerP.add(exitBtn);
    }
}
