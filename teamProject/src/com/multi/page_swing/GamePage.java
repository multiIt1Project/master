package com.multi.page_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Random;


public class GamePage extends JFrame {
    
    public static void main(String[] args) {
        
        GamePage g = new GamePage(1);
        
    }
    
    
    
    private JFrame f;
    private Font font1 = new Font("굴림", Font.BOLD, 44);
    private Font font2 = new Font("굴림", Font.BOLD, 20);
    private JPanel headerGP;
    private JPanel midP;
    private JPanel footerP;
    private JLabel titleL, resultL, timeL, scoreL;
    private JTextArea textArea;
    private boolean gameout = false;
    private int spentTime;
    private int lavel, sum, count;
    private int gametime = 30;
    private int ietm1, ietm2, ietm3, soc = 100;
    private GameT gameT;

    public GamePage(int i) {
        f = new JFrame("난이도"+lavel);
        lavel = i;
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 800);
        f.setTitle("게임");

        gameT = new GameT();


        initHeaderP();
        initMidP();
        initFooterP();

        f.add(headerGP, BorderLayout.PAGE_START);
        f.add(midP, BorderLayout.CENTER);
        f.add(footerP, BorderLayout.PAGE_END);

        gameT.start();//
        GameStart(i);

        f.setVisible(true);


    }

    private void GameStart(int i) {

        switch (i) {
            case 1:
                Gamelevel(10, 2);
                break;
            case 2:
                Gamelevel(10, 4);
                break;
            case 3:
                Gamelevel(50, 4);
                break;
        }

    }

    public class GameT extends Thread {
        private Date start;
        private Date now;
        @Override
        public void run() {


            start = new Date();
            while (spentTime <= gametime) {
                now = new Date();
                timeL.setText("시간:" + (gametime - spentTime));
                spentTime = (int) (now.getTime() - start.getTime()) / 1000;
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("강제 종료합니다...");
                }
                if(gametime<spentTime){
                    titleL.setText("시간 종료");
                    resultL.setText("시간 종료");
                    gameout = true;

                }
            }

        }
    }

    private void Gamelevel(int round, int operations) {
        Random r = new Random();
        int x = r.nextInt(round) + 1;
        int y = r.nextInt(round) + 1;
        int mu = r.nextInt(operations) + 1;
        String str = null;//문제를 저장하는 변수
        switch (mu) {
            case 1:
                sum = x + y;
                str = x + " + " + y + " = ";
                break;
            case 2:
                sum = x - y;
                str = x + " - " + y + " = ";
                break;
            case 3:
                sum = x * y;
                str = x + " x " + y + " = ";
                break;
            case 4:
                while (true) {
                    if (x % y == 0) {
                        break;
                    }
                    x = r.nextInt(round) + 1;
                    y = r.nextInt(round) + 1;
                }
                sum = x / y;
                str = x + " / " + y + " = ";

                break;
        }
        titleL.setText(str);//문제를 출력

    }

    private void gamesoc() {
        int sum1;


        sum1 = Integer.parseInt(textArea.getText());

        if (gameout) {
            resultL.setForeground(Color.BLACK);
            resultL.setText("시간 초과 입니다");
        } else if (sum == sum1) {
            resultL.setForeground(Color.GREEN);
            resultL.setText("정답입니다");

            count = count + lavel * soc;//임으로 배정
            scoreL.setText("점수 :" + count);
        } else {
            resultL.setForeground(Color.red);
            resultL.setText("오답 :" + "\n" + "정답은 " + sum + "입니다");
        }
    }


    private void initHeaderP() {
        headerGP = new JPanel(); // 위
        headerGP.setLayout(new BorderLayout());
        headerGP.setBackground(new Color(40, 60, 79));
        headerGP.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10)); // 여백(=padding)
        timeL = new JLabel("시간:" + spentTime);
        scoreL = new JLabel("점수:  ");


        timeL.setFont(font1);
        scoreL.setFont(font1);

        timeL.setOpaque(true);
        scoreL.setOpaque(true);
        timeL.setBackground(new Color(63, 228, 192));
        scoreL.setBackground(new Color(63, 228, 192));
        timeL.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scoreL.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        headerGP.add(timeL,BorderLayout.WEST);
        headerGP.add(scoreL,BorderLayout.EAST);
    }

    private void initMidP() {
        midP = new JPanel(); // 가운데
        midP.setLayout(null);//위치를 직접설정
        midP.setBackground(new Color(40, 60, 79));

        JButton menuBtn1 = new JButton("다음문제");
        JButton menuBtn2 = new JButton("시간증가");
        JButton menuBtn3 = new JButton("점수x2");
        menuBtn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ietm1 == 10) {
                } else {
                    GameStart(lavel);//패스
                    textArea.setText("55");//textArea초기화및 표시
                    textArea.setText("");
                    ietm1 = 10;
                }
            }
        });
        menuBtn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ietm2 == 20) {
                } else {
                    gametime = gametime + 10;//시간증가
                    ietm2 = 20;
                }
            }
        });
        menuBtn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ietm3 == 30) {
                } else {
                    count = count * 2;
                    soc = soc * 2;
                    scoreL.setText("점수:" + count);
                    ietm3 = 30;
                }


            }
        });
        menuBtn1.setFont(font2);
        menuBtn2.setFont(font2);
        menuBtn3.setFont(font2);

        menuBtn1.setBackground(new Color(63, 228, 192));
        menuBtn2.setBackground(new Color(63, 228, 192));
        menuBtn3.setBackground(new Color(63, 228, 192));
        menuBtn1.setSize(120, 50);
        menuBtn1.setLocation(40, 50);
        menuBtn2.setSize(120, 50);
        menuBtn2.setLocation(220, 50);
        menuBtn3.setSize(120, 50);
        menuBtn3.setLocation(400, 50);

        midP.add(menuBtn1);
        midP.add(menuBtn2);
        midP.add(menuBtn3);


        titleL = new JLabel();
        titleL.setOpaque(true);
        titleL.setSize(500, 80);
        titleL.setLocation(40, 155);
        titleL.setFont(font1);

        titleL.setBackground(Color.YELLOW);
        titleL.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0)); // 여백(=padding)


        textArea = new JTextArea("");//정답입력칸
        textArea.setOpaque(true);
        textArea.setFont(font1);
        textArea.setBackground(Color.white);
        textArea.setSize(130, 50);
        textArea.setLocation(400, 170);


        midP.add(textArea);
        midP.add(titleL);


        JButton btn1 = new JButton("정답");//정답입력버튼
        btn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameout) {
                } else {
                    gamesoc();//
                    GameStart(lavel);
                    textArea.setText("  ");//textArea의 표시하기위해사용
                    textArea.setText("");//정답을 초기화
                }
            }
        });
        btn1.setSize(130, 80);
        btn1.setLocation(400, 300);
        btn1.setBorderPainted(false);
        btn1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
        btn1.setFont(font1);
        btn1.setBackground(new Color(63, 228, 192));
        midP.add(btn1);

        resultL = new JLabel("정답을 입력해주세요");//정답
        resultL.setOpaque(true);
        resultL.setSize(350, 80);
        resultL.setLocation(40, 300);
        resultL.setFont(font2);

        resultL.setBackground(Color.YELLOW);
        resultL.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 0));
        midP.add(resultL);
    }


    private void initFooterP() {
        footerP = new JPanel(new BorderLayout()); // 아래
        footerP.setBackground(new Color(40, 60, 79));
        footerP.setBorder(BorderFactory.createEmptyBorder(0, 0, 100, 50)); // 여백(=padding)


        JButton exitBtn = new JButton("EXIT");
        exitBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstPage s = new FirstPage();
                JOptionPane.showMessageDialog(f, "점수" + count);
                gameT.interrupt();
                textArea.setText("");
                if(ietm1==10){

                }if(ietm2==20){//초기화
                    soc=soc/2;
                }
                if(ietm3==30){

                }
                f.setVisible(false);
            }
        });
        exitBtn.setBorderPainted(false);
        exitBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // 여백(=padding)
        exitBtn.setFont(font1);
        exitBtn.setBackground(new Color(63, 228, 192));
        footerP.add(exitBtn,BorderLayout.EAST);
    }
}