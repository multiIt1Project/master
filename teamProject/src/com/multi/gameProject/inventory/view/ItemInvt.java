package com.multi.gameProject.inventory.view;

import com.multi.gameProject.inventory.controller.InvtController;
import com.multi.gameProject.inventory.model.dao.InvtDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ItemInvt {
    private JFrame f;
    private Font font1 = new Font("굴림", Font.BOLD, 50);
    private Font font2 = new Font("굴림", Font.BOLD, 30);
    private Font font3 = new Font("굴림", Font.BOLD, 20);
    private JPanel headerP;
    private JPanel midP;
    private JPanel footerP;
    private String userId = "ID";

    private InvtController invtController = new InvtController();

    public void ItemInvtView() {
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
        headerP.setBorder(BorderFactory.createEmptyBorder(20, 100, 0, 100)); // 여백(=padding)

        JButton menuBtn1 = new JButton("코인");
        JButton menuBtn2 = new JButton("아이템");

        menuBtn1.setFont(font2);
        menuBtn2.setFont(font2);



        menuBtn1.setBackground(new Color(63, 228, 192));
        menuBtn2.setBackground(new Color(253, 219, 0, 255));
        menuBtn2.setForeground(Color.black);


        headerP.add(menuBtn1);
        headerP.add(menuBtn2);

        menuBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new CoinInvt().coinInvtView();
            }
        });
    }

    private void initMidP() {
        midP = new JPanel(new GridLayout(0, 1)); // 가운데
        midP.setBackground(new Color(40, 60, 79));
        midP.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20)); // 여백(=padding)

        JLabel titleL = new JLabel("내 아이템 조회");
        titleL.setFont(font2);
        titleL.setForeground(Color.white);
        titleL.setHorizontalAlignment(0);
        midP.add(titleL);

        JPanel itemP1 = new JPanel(new GridLayout(0,2));
        JPanel itemP2 = new JPanel(new GridLayout(0,2));
        JPanel itemP3 = new JPanel(new GridLayout(0,2));

        ImageIcon itemImg1 = new ImageIcon("img/double.png");
        ImageIcon itemImg2 = new ImageIcon("img/time.png");
        ImageIcon itemImg3 = new ImageIcon("img/pass.png");


        JLabel itemL1 = new JLabel("  점수두배", itemImg1, 0);
        JLabel itemL2 = new JLabel("  시간연장", itemImg2, 0);
        JLabel itemL3 = new JLabel("  문제패스", itemImg3, 0);

        itemL1.setFont(font3);
        itemL2.setFont(font3);
        itemL3.setFont(font3);
        
        JLabel count1 = new JLabel("개", 0);
        JLabel count2 = new JLabel("개", 0);
        JLabel count3 = new JLabel("개", 0);

        count1.setFont(font2);
        count2.setFont(font2);
        count3.setFont(font2);


        itemP1.add(itemL1);
        itemP1.add(count1);
        itemP2.add(itemL2);
        itemP2.add(count2);
        itemP3.add(itemL3);
        itemP3.add(count3);

        midP.add(itemP1);
        midP.add(itemP2);
        midP.add(itemP3);


    }


    private void initFooterP() {
        footerP = new JPanel(new BorderLayout()); // 아래
        footerP.setBackground(new Color(40, 60, 79));
        footerP.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 50)); // 여백(=padding)
        JButton GoToStoreBtn = new JButton("상점으로");
        GoToStoreBtn.setBorderPainted(false);
        GoToStoreBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
        GoToStoreBtn.setFont(font2);
        GoToStoreBtn.setBackground(new Color(63, 228, 192));
        footerP.add(GoToStoreBtn, BorderLayout.LINE_END);

        GoToStoreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                Store store = new Store();
                store.storeView();
            }
        });

    }

    public void showDialog(String inform) {
        JOptionPane.showMessageDialog(f, inform);
    }

}
