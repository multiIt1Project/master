package com.multi.page_swing;

import javax.swing.*;
import java.awt.*;

// 참고로 메뉴 클릭하면 해당 페이지를 setVisible(true)로 나머지는 setVisible(false)로 바꾸면 마치 페이지 이동처럼 창 전환이 된다고 합니다.
// JTABLE

public class FirstPage {
    private JFrame f;
    private Font font1 = new Font("굴림", Font.BOLD, 50);
    private Font font2 = new Font("굴림", Font.BOLD, 20);
    private JPanel headerP;
    private JPanel midP;
    private JPanel footerP;

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

        JButton menuBtn1 = new JButton("menu1");
        JButton menuBtn2 = new JButton("menu2");
        JButton menuBtn3 = new JButton("menu3");
        JButton menuBtn4 = new JButton("menu4");
        JButton menuBtn5 = new JButton("menu5");
        menuBtn1.setFont(font2);
        menuBtn2.setFont(font2);
        menuBtn3.setFont(font2);
        menuBtn4.setFont(font2);
        menuBtn5.setFont(font2);
        menuBtn1.setBackground(new Color(63,228,192));
        menuBtn2.setBackground(new Color(63,228,192));
        menuBtn3.setBackground(new Color(63,228,192));
        menuBtn4.setBackground(new Color(63,228,192));
        menuBtn5.setBackground(new Color(63,228,192));

        headerP.add(menuBtn1);
        headerP.add(menuBtn2);
        headerP.add(menuBtn3);
        headerP.add(menuBtn4);
        headerP.add(menuBtn5);
    }

    private void initMidP() {
        midP = new JPanel(); // 가운데
        midP.setBackground(new Color(40, 60, 79));
        midP.setBorder(BorderFactory.createEmptyBorder(50 , 0, 0 , 0)); // 여백(=padding)

        JLabel titleL = new JLabel("코마에 사칙연산 게임");
        titleL.setFont(font1);
        titleL.setForeground(Color.white);
        titleL.setBorder(BorderFactory.createEmptyBorder(0 , 0, 20 , 0)); // 여백(=padding)
        midP.add(titleL);

        ImageIcon mainImg = new ImageIcon("img/img.png");
        JLabel imgL = new JLabel();
        imgL.setIcon(mainImg);
        midP.add(imgL);

    }


    private void initFooterP() {
        footerP = new JPanel(); // 아래
        footerP.setBackground(new Color(40, 60, 79));
        footerP.setBorder(BorderFactory.createEmptyBorder(0 , 0, 100 , 0)); // 여백(=padding)
        JButton startBtn = new JButton("START");
        startBtn.setBorderPainted(false);
        startBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
        startBtn.setFont(font1);
        startBtn.setBackground(new Color(63,228,192));
        footerP.add(startBtn);
    }
}
