package com.multi.gameProject.inventory.view;

import com.multi.gameProject.generalUsers.model.dto.GeneralUserDto;
import com.multi.gameProject.inventory.controller.InvtController;
import com.multi.gameProject.inventory.model.dto.InvtDto;
import com.multi.gameProject.inventory.model.dto.ItemDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ItemInvtPage {
    private GeneralUserDto loginDto;
    private String userId = loginDto.getUser_Id();
    private InvtController invtController = new InvtController();
    private JFrame f;
    private Font font2 = new Font("굴림", Font.BOLD, 30);
    private Font font3 = new Font("굴림", Font.BOLD, 20);
    private JPanel headerP;
    private JPanel midP;
    private JPanel footerP;

    public ItemInvtPage(GeneralUserDto loginDto) {
        userId = loginDto.getUser_Id();
    }

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
        headerP.setBorder(BorderFactory.createEmptyBorder(30, 100, 40, 100)); // 여백(=padding)

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
                new CoinInvtPage(loginDto).coinInvtView();
            }
        });
    }

    private void initMidP() {
        midP = new JPanel(new GridLayout(0, 1)); // 가운데
        midP.setBackground(new Color(40, 60, 79));
        midP.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20)); // 여백(=padding)

        JLabel titleL = new JLabel("나의 아이템");
        titleL.setFont(font2);
        titleL.setOpaque(true);
        titleL.setBackground(Color.cyan);
        titleL.setForeground(new Color(40, 60, 79));
        titleL.setHorizontalAlignment(0);
        midP.add(titleL);

        ArrayList<ItemDto> list = invtController.getItems();

        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                InvtDto invtDto = new InvtDto(userId, list.get(i).getItemNo());
                JPanel itemP = new JPanel(new FlowLayout(0, 50, 0));
                itemP.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                itemP.setBackground(Color.white);
                ImageIcon itemImg = new ImageIcon("img/" + list.get(i).getImg());
                JLabel itemL = new JLabel("    " + list.get(i).getItemName(), itemImg, 0);
                JLabel count = new JLabel("      " + invtController.getUserItemCount(invtDto) + "개", 0);
                itemL.setFont(font3);
                count.setFont(font2);
                itemP.add(itemL);
                itemP.add(count);
                midP.add(itemP);
            }
        }
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
                GeneralUserStorePage store = new GeneralUserStorePage(loginDto);
                store.storeView();
            }
        });

    }

    public void showDialog(String inform) {
        JOptionPane.showMessageDialog(f, inform);
    }

}
