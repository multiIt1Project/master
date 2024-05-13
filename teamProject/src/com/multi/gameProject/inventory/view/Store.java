package com.multi.gameProject.inventory.view;

import com.multi.gameProject.game.FirstPage;
import com.multi.gameProject.inventory.controller.InvtController;
import com.multi.gameProject.inventory.model.dao.InvtDao;
import com.multi.gameProject.inventory.model.dto.InvtDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Store {

    private InvtController invtController = new InvtController();

    private static JFrame f;
    private Font font1 = new Font("굴림", Font.BOLD, 50);
    private Font font2 = new Font("굴림", Font.BOLD, 30);
    private Font font3 = new Font("굴림", Font.BOLD, 20);
    private static JPanel headerP;
    private static JPanel midP;
    private static JPanel footerP;
    private static String userId = "ID";
    private JLabel myCoin2;
    private JButton addB1;
    private JButton addB2;
    private JButton addB3;
    private JLabel itemPrice1;
    private JLabel itemPrice2;
    private JLabel itemPrice3;

    public void storeView() {
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
        headerP = new JPanel(new GridLayout(0, 4, 10, 10)); // 위
        headerP.setBackground(new Color(40, 60, 79));
        headerP.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10)); // 여백(=padding)

        JButton menuBtn1 = new JButton("내정보");
        JButton menuBtn2 = new JButton("상점");
        JButton menuBtn3 = new JButton("게시판");
        JButton menuBtn4 = new JButton("랭킹");
        menuBtn1.setFont(font2);
        menuBtn2.setFont(font2);
        menuBtn3.setFont(font2);
        menuBtn4.setFont(font2);
        menuBtn1.setBackground(new Color(63, 228, 192));
        menuBtn2.setBackground(new Color(253, 219, 0, 255));
        menuBtn3.setBackground(new Color(63, 228, 192));
        menuBtn4.setBackground(new Color(63, 228, 192));

        headerP.add(menuBtn1);
        headerP.add(menuBtn2);
        headerP.add(menuBtn3);
        headerP.add(menuBtn4);
    }

    private void initMidP() {
        midP = new JPanel(new GridLayout(0, 1)); // 가운데
        midP.setBackground(new Color(40, 60, 79));
        midP.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20)); // 여백(=padding)

        JLabel titleL = new JLabel("아이템 구매");
        titleL.setFont(font2);
        titleL.setForeground(Color.white);
        titleL.setHorizontalAlignment(0);
        midP.add(titleL);

        JPanel myCoinP = new JPanel(new GridLayout(0, 2));
        JLabel myCoin1 = new JLabel("나의 코인", 0);
        int coin = invtController.getUserCoin(userId);
        myCoin2 = new JLabel(coin + "개", 0);
        myCoin1.setFont(font3);
        myCoin2.setFont(font2);
        myCoinP.add(myCoin1);
        myCoinP.add(myCoin2);
        midP.add(myCoinP);

        JPanel itemP1 = new JPanel(new FlowLayout(0, 50, 0));
        JPanel itemP2 = new JPanel(new FlowLayout(0, 50, 0));
        JPanel itemP3 = new JPanel(new FlowLayout(0, 50, 0));

        ImageIcon itemImg1 = new ImageIcon("img/double.png");
        ImageIcon itemImg2 = new ImageIcon("img/time.png");
        ImageIcon itemImg3 = new ImageIcon("img/pass.png");

        JLabel itemName1 = new JLabel("  점수두배", itemImg1, 0);
        JLabel itemName2 = new JLabel("  시간연장", itemImg2, 0);
        JLabel itemName3 = new JLabel("  문제패스", itemImg3, 0);

        itemName1.setFont(font3);
        itemName2.setFont(font3);
        itemName3.setFont(font3);

        itemPrice1 = new JLabel("코인 10개", 0);
        itemPrice2 = new JLabel("코인 10개", 0);
        itemPrice3 = new JLabel("코인 10개", 0);

        itemPrice1.setFont(font3);
        itemPrice2.setFont(font3);
        itemPrice3.setFont(font3);

        JButton addB1 = new JButton("구매");
        JButton addB2 = new JButton("구매");
        JButton addB3 = new JButton("구매");

        addB1.setFont(font2);
        addB2.setFont(font2);
        addB3.setFont(font2);

        itemP1.add(itemName1);
        itemP1.add(itemPrice1);
        itemP1.add(addB1);

        itemP2.add(itemName2);
        itemP2.add(itemPrice2);
        itemP2.add(addB2);

        itemP3.add(itemName3);
        itemP3.add(itemPrice3);
        itemP3.add(addB3);

        addB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                InvtDto invtDto = new InvtDto(userId, 1, 1);


                int result = invtController.buyItem(invtDto);
                String comment = null;
                if (result == 1) {
                    comment = "아이템 구입 성공!";
                } else {
                    comment = "아이템 구입 실패";
                }
                showDialog(comment);
            }
        });

        addB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InvtDao invtDao = new InvtDao();

                int result = invtDao.buyItem(2);
                String comment = null;
                if (result == 1) {
                    comment = "아이템 구입 성공!";
                } else {
                    comment = "아이템 구입 실패";
                }
                showDialog(comment);
            }
        });

        addB3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InvtDao invtDao = new InvtDao();

                int result = invtDao.buyItem(3);
                String comment = null;
                if (result == 1) {
                    comment = "아이템 구입 성공!";
                } else {
                    comment = "아이템 구입 실패";
                }
                showDialog(comment);
            }
        });

        midP.add(itemP1);
        midP.add(itemP2);
        midP.add(itemP3);

    }


    private void initFooterP() {
        footerP = new JPanel(new BorderLayout()); // 아래
        footerP.setBackground(new Color(40, 60, 79));
        footerP.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // 여백(=padding)
        JButton goHomeBtn = new JButton("홈으로");
        goHomeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                FirstPage firstPage = new FirstPage();
            }
        });
        goHomeBtn.setBorderPainted(false);
        goHomeBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
        goHomeBtn.setFont(font2);
        goHomeBtn.setBackground(new Color(63, 228, 192));
        JButton goToInvt = new JButton("내 코인 / 아이템 조회");
        goToInvt.setBorderPainted(false);
        goToInvt.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
        goToInvt.setFont(font2);
        goToInvt.setBackground(new Color(63, 228, 192));
        footerP.add(goToInvt, BorderLayout.LINE_START);
        footerP.add(goHomeBtn, BorderLayout.LINE_END);

        goToInvt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                CoinInvt coinInvt = new CoinInvt();
                coinInvt.coinInvtView();
            }
        });
    }

    public void showDialog(String inform) {
        JOptionPane.showMessageDialog(f, inform);
    }
}
