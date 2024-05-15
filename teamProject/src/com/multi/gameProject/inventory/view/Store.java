package com.multi.gameProject.inventory.view;

import com.multi.gameProject.game.FirstPage;
import com.multi.gameProject.inventory.controller.InvtController;
import com.multi.gameProject.inventory.model.dto.InvtDto;
import com.multi.gameProject.inventory.model.dto.ItemDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Store {
    private static String userId = "ID";
    private InvtController invtController = new InvtController();
    private JFrame f;
    private Font font2 = new Font("굴림", Font.BOLD, 30);
    private Font font3 = new Font("굴림", Font.BOLD, 20);
    private JPanel headerP;
    private JPanel midP;
    private JPanel footerP;
    private JLabel myCoin2;

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
        headerP.setBorder(BorderFactory.createEmptyBorder(30, 10, 40, 10)); // 여백(=padding)

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
        midP = new JPanel(new GridLayout(0, 1, 0, 0)); // 가운데
        midP.setBackground(new Color(40, 60, 79));
        midP.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20)); // 여백(=padding)

        JPanel myCoinP = new JPanel(new GridLayout(0, 2));
        myCoinP.setBackground(Color.CYAN);
        JLabel myCoin1 = new JLabel("나의 코인", 0);
        int coin = invtController.getUserCoin(userId);
        myCoin2 = new JLabel(coin + "개", 0);
        myCoin2.setText(coin+"개");
        myCoin1.setFont(font3);
        myCoin2.setFont(font2);
        myCoinP.add(myCoin1);
        myCoinP.add(myCoin2);
        midP.add(myCoinP);

        ArrayList<ItemDto> list = invtController.getItems();

        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                JPanel itemP = new JPanel(new FlowLayout(0, 30, 0));
                itemP.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                itemP.setBackground(Color.white);
                ImageIcon itemImg = new ImageIcon("img/" + list.get(i).getImg());
                JLabel itemL = new JLabel("    " + list.get(i).getItemName(), itemImg, 0);
                JLabel itemPrice = new JLabel("코인 " + list.get(i).getItemPrice() + "개", 0);
                itemL.setFont(font3);
                itemPrice.setFont(font3);
                JButton addBtn = new JButton("구매");
                addBtn.setActionCommand(String.valueOf(list.get(i).getItemNo()));
                addBtn.setFont(font2);
                itemP.add(itemL);
                itemP.add(itemPrice);
                itemP.add(addBtn);
                midP.add(itemP);

                addBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int itemNo = Integer.parseInt(e.getActionCommand());
                        InvtDto invtDto = new InvtDto(userId, itemNo, 1);
                        int result = invtController.buyItem(invtDto);

                        if (result > 0) {
                            showDialog("아이템 구매 성공");
                            myCoin2.setText(invtController.getUserCoin(userId) + "개");
                        }
                    }
                });
            }
        }
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
                new FirstPage();
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
