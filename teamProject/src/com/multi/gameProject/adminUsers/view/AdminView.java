package com.multi.gameProject.adminUsers.view;

import com.multi.gameProject.adminUsers.controller.AdminController;
import com.multi.gameProject.generalUsers.model.dto.GeneralUserDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminView {
    private JFrame f;
    private Font font1 = new Font("굴림", Font.BOLD, 50);
    private Font font2 = new Font("굴림", Font.BOLD, 20);
    private JPanel headerP;
    private JPanel midP;
    private JPanel footerP;

    private JList<String> memberList;
    private DefaultListModel<String> listModel;

    private AdminController adminController = new AdminController();
    private GeneralUserDto dto;

    public AdminView(GeneralUserDto dto) {
        
        this.dto= dto;
        
        
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

        JButton menuBtn1 = new JButton("회원 정보");
        JButton menuBtn2 = new JButton("상점 관리");
        JButton menuBtn3 = new JButton("게시판 관리");
        JButton menuBtn4 = new JButton("랭킹");

        JButton[] jButtons = {menuBtn1, menuBtn2, menuBtn3, menuBtn4};

        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i].setFont(font2);
            jButtons[i].setBackground(new Color(63,228,192));
            headerP.add(jButtons[i]);
        }

        menuBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminController.selectAll(dto);
                f.setVisible(false);
            }
        });

        menuBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminController.storeManagement();
                f.setVisible(false);
            }
        });

        menuBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminController.boardManagement();
                f.setVisible(false);
            }
        });
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

        ImageIcon icon = new ImageIcon("img/img.png");
        Image img = icon.getImage();
        Image changeImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon changeIcon= new ImageIcon(changeImg);
        JLabel mainImg = new JLabel(changeIcon);
        midP.add(mainImg);

    }

    private void initFooterP() {
        footerP = new JPanel(); // 아래
        footerP.setBackground(new Color(40, 60, 79));
        footerP.setBorder(BorderFactory.createEmptyBorder(0 , 0, 100 , 0)); // 여백(=padding)

        JButton startBtn = new JButton("게임 시작");
        JButton logout = new JButton("로그아웃");

        startBtn.setBorderPainted(false);
        startBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
        startBtn.setFont(font1);
        startBtn.setBackground(new Color(63,228,192));

        logout.setBorderPainted(false);
        logout.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        logout.setFont(font1);
        logout.setBackground(new Color(63,228,192));

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        footerP.add(logout);
        footerP.add(startBtn);
    }
}

