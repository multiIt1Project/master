package com.multi.gameProject.adminUsers.view;

import com.multi.gameProject.adminUsers.controller.AdminController;
import com.multi.gameProject.adminUsers.model.dto.AdminDto;
import com.multi.gameProject.adminUsers.service.AdminService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MemberList {

    private JFrame f = new JFrame();
    private JTable table;
    private JScrollPane scrollPane = null;
    private String header[] = {"아이디", "최고 점수", "보유 코인", "생성일", "탈퇴여부", "탈퇴일자"};
    private JPanel panel;
    private Font font1 = new Font("굴림", Font.BOLD, 50);
    private Font font2 = new Font("굴림", Font.BOLD, 20);

    private AdminController adminController = new AdminController();
    private AdminService adminService = new AdminService();

    public void selectList() {
        f.setSize(600, 800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        f.getContentPane().add(panel, BorderLayout.CENTER);

        panel.setSize(600, 800);
        panel.setBackground(new Color(40, 60, 79));
        panel.setBorder(BorderFactory.createEmptyBorder(20 , 0,  0, 0)); // 여백(=padding)

        JButton menuBtn1 = new JButton("회원 정보");
        JButton menuBtn2 = new JButton("상점 관리");
        JButton menuBtn3 = new JButton("게시판 관리");
        JButton menuBtn4 = new JButton("랭킹");

        JButton[] jButtons = {menuBtn1, menuBtn2, menuBtn3, menuBtn4};

        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i].setFont(font2);
            jButtons[i].setBackground(new Color(63,228,192));
            panel.add(jButtons[i]);
        }

        menuBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ItemManagement().ItemPageView();
                panel.setVisible(false);
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


        JButton btnNewButton = new JButton("삭제");
        JButton btnNewButton2 = new JButton("홈으로");

        setListTable();
        panel.add(btnNewButton);
        panel.add(btnNewButton2);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel.remove(scrollPane);

                //클릭한 위치의 행번호
                int rowNo = table.getSelectedRow();
                Object value1 = (Object) table.getModel().getValueAt(rowNo, 0);
                int result = adminService.deleteUser(value1.toString());
                if (result == 1) {
                    JOptionPane.showMessageDialog(f, "회원 삭제 성공");
                } else {
                    JOptionPane.showMessageDialog(f, "회원 삭제 실패");
                }

                setListTable();
            }
        });

        btnNewButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminView();
                panel.setVisible(false);
                f.setVisible(false);
            }
        });


        f.setVisible(true);
    }

    public void setListTable() {

        ArrayList<AdminDto> list = adminService.selectAll();

        Object[][] all = new String[list.size()][6];
        for (int i = 0; i < all.length; i++) {
            all[i][0] = list.get(i).getUserId();
            all[i][1] = list.get(i).getPassword();
            all[i][2] = list.get(i).getUserName();
            all[i][3] = list.get(i).getTel();
            all[i][4] = list.get(i).getDelAcc();
            all[i][5] = list.get(i).getDeleteAccDate();
        }

        DefaultTableModel model = new DefaultTableModel(all, header);
        if (table == null) {
            System.out.println("table == null)");

            table = new JTable(model);
            scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(500, 200));  // 스크롤 팬의 선호 크기 설정

        } else {
            System.out.println(" table.setModel(model)");

            table.setModel(model);
            System.out.println("setViewportView");
            scrollPane.setViewportView(table);  // 기존 스크롤 팬에 새로운 테이블 뷰 설정

        }
        panel.add(scrollPane);
        panel.revalidate();  // 레이아웃을 새로 계산
        panel.repaint();  // 컴포넌트를 다시 그림


        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //클릭한 위치의 행번호
                int rowNo = table.getSelectedRow();
                //클릭한 위치의 열번호
                int colNo = table.getSelectedColumn();
                //행,열에 해당하는 값 추출
                Object value = (Object) table.getModel().getValueAt(rowNo, colNo);
                System.out.println(value);

                //한 row가지고 오기
                Object value1 = (Object) table.getModel().getValueAt(rowNo, 0);
                Object value2 = (Object) table.getModel().getValueAt(rowNo, 1);
                Object value3 = (Object) table.getModel().getValueAt(rowNo, 2);
                Object value4 = (Object) table.getModel().getValueAt(rowNo, 3);
                Object value5 = (Object) table.getModel().getValueAt(rowNo, 4);
                Object value6 = (Object) table.getModel().getValueAt(rowNo, 5);
                System.out.println(value1 + " " + value2 + " " + value3 + " " + value4 + " " + value5 + " " + value6);
            }
        });

    }

    public void displayNoData() {
    }

    public void displayError(String s) {
    }

}
