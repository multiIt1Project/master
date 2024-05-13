package com.multi.gameProject.generalUsers.view.generalUser;

import com.multi.gameProject.generalUsers.controller.GeneralUserController;
import com.multi.gameProject.generalUsers.model.generalUserBoardDAO.GeneralUserBoardDao;
import com.multi.gameProject.generalUsers.model.generalUserBoardDTO.GeneralUserBoardDto;
import com.multi.gameProject.generalUsers.model.generalUserDTO.GeneralUserDto;
import com.multi.gameProject.generalUsers.model.generalUserRecordDAO.GeneralUserRecordDao;
import com.multi.gameProject.generalUsers.model.generalUserRecordDTO.GeneralUserRecordDto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

// 참고로 메뉴 클릭하면 해당 페이지를 setVisible(true)로 나머지는 setVisible(false)로 바꾸면 마치 페이지 이동처럼 창 전환이 된다고 합니다.
// 버튼/ jpanel 최종 리스트 보면서 셋비지블 다 맞게 넣어주기. 넣다가 안 넣은 것들이 많음.
// 그 외 공지 내용대로 수정할 것
// 다른 페이지로 넘길 때 loginDto 정보를 넘길 것!!

public class GeneralUserAfterLoginHomePage {
	
	private GeneralUserController controller = new GeneralUserController();
	
	// 생성자를 통해 로그인 정보를 받아서 초기화 할 것임. 업데이트나 삭제 시 값 변경됨
	private GeneralUserDto loginDto;
	
	// 1 : 큰 글자  , 2: 작은 글자
	private JFrame f;
	private Font font1 = new Font("굴림", Font.BOLD, 50);
	private Font font2 = new Font("굴림", Font.BOLD, 20);
	
	// 위에 4개 메뉴 버튼
	private JButton myInfoBtn = new JButton("내 정보");
	private JButton shopBtn = new JButton("상점");
	private JButton BoardListBtn = new JButton("게시판");
	private JButton BoardRankingBtn = new JButton("랭킹");
	
	// 내 정보 텍스트 필드
	private JTextField idField;
	private JTextField pwField;
	private JTextField coin_CountField;
	private JTextField nameField;
	private JTextField ageField;
	private JTextField telField;
	private JTextField emailField;
	private JTextField signUpField;
	
	
	// 내정보에서 버튼 2개 : 회원수정, 회원탈퇴
	private JButton editBtn = new JButton("회원수정");
	private JButton deleteBtn = new JButton("회원탈퇴");
	
	// 밑의 총 7개 버튼. 일부는 화면에 따라 가려진다. 로그아웃/ 게임시작 / 글쓰기/ 아이디로 조회/글 수정/홈으로
	private JButton logoutBtn = new JButton("로그아웃");
	private JButton gameBtn = new JButton("게임시작");
	
	private JButton writeBtn = new JButton("글쓰기");
	private JButton selectByIdBtn = new JButton("아이디로 조회");
	private JButton edit2Btn = new JButton("글 수정");
	private JButton homeBtn = new JButton("홈으로");
	
	// 글 쓰기 페이지 밑에 있는 '글 쓰기'는 '작성한 글 저장'으로 바꿀 것!!
	// 게시판 리스트의 글 쓰기는 화면 전환
	private JButton writeSaveBtn = new JButton("작성한 글 저장");
	
	
	// 위 - 중간 - 밑 페이지 요소순서. 가운데 부분이 주로 크게 바뀌고 위 아래는 소소하게 바뀐다.
	private JPanel headerP = new JPanel();
	
	private JPanel midMyInfoP = new JPanel();
	private JPanel midHomeP = new JPanel();
	private JPanel midBoardListP = new JPanel();
	private JPanel midBoardWriteP = new JPanel();
	private JPanel midBoardEditP = new JPanel();
	private JPanel midBoardRankingP = new JPanel();
	
	private JPanel footerP = new JPanel();
	
	
	// 보드 리스트 페이지 패널에 들어갈 model, jtable, jscrollpane, header
	JScrollPane boardListScrollPane = null;
	private String header[] = {"NO", "회원 아이디", "작성일자", "제목", "내용"};
	
	private GeneralUserBoardDto currentBoardDto;
	
	
	// 보드 행별 내용 조회하는 글 수정 페이지에 들어갈 JTextField, JTextArea
	private JTextArea titlesArea;
	private JTextArea contentArea;
	
	// 글을 아예 쓰는 글 쓰기 페이지에 들어갈 JTextField, JTextArea
	private JTextField titlesField2;
	private JTextArea contentArea2;
	
	// 랭킹 화면 안의 텍스트 에어리어
	JTextArea rankingArea;
	
	
	// 유저가 로그인 성공한 후의 화면
	public GeneralUserAfterLoginHomePage(GeneralUserDto loginDto) {
		
		// 로그인 전 화면에서 받은 로그인디티오를 로그인 후 클래스에서 사용하기위해 저장함
		this.loginDto = loginDto;
		
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 800);
		f.setTitle("코마에 사칙연산 게임");
		
		initHeaderP();
		initHome();
		initFooterP();
		
		
		f.add(headerP, BorderLayout.PAGE_START);
		f.add(midHomeP);
		f.add(footerP, BorderLayout.PAGE_END);
		
		myInfoBtn.setVisible(true);
		shopBtn.setVisible(true);
		BoardListBtn.setVisible(true);
		BoardRankingBtn.setVisible(true);
		logoutBtn.setVisible(true);
		gameBtn.setVisible(true);
		
		homeBtn.setVisible(false);
		writeBtn.setVisible(false);
		selectByIdBtn.setVisible(false);
		edit2Btn.setVisible(false);
		editBtn.setVisible(false);
		deleteBtn.setVisible(false);
		writeSaveBtn.setVisible(false);
		
		
		f.setVisible(true);
	}
	
	private void initHeaderP() {
		// 위
		headerP.setBackground(new Color(40, 60, 79));
		headerP.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // 여백(=padding)
		
		myInfoBtn.setFont(font2);
		shopBtn.setFont(font2);
		BoardListBtn.setFont(font2);
		BoardRankingBtn.setFont(font2);
		
		myInfoBtn.setBackground(new Color(63, 228, 192));
		shopBtn.setBackground(new Color(63, 228, 192));
		BoardListBtn.setBackground(new Color(63, 228, 192));
		BoardRankingBtn.setBackground(new Color(63, 228, 192));
		
		headerP.add(myInfoBtn);
		headerP.add(shopBtn);
		headerP.add(BoardListBtn);
		headerP.add(BoardRankingBtn);
		
		
		// 내 정보 버튼
		myInfoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 다른 미드 페이지들을 다 제거하고
				
				midMyInfoP.removeAll();
				
				
				initMidMyInfo();
				
				f.remove(midHomeP);
				f.remove(midBoardListP);
				f.remove(midBoardWriteP);
				f.remove(midBoardEditP);
				f.remove(midBoardRankingP);
				// 해당 미드 페이지를 넣기
				f.add(midMyInfoP);
				
				// 셋 비지블도 마찬가지로 해준다
				midMyInfoP.setVisible(true);
				midHomeP.setVisible(false);
				
				// 아래 7개의 버튼 중 보여야하는 것을 고른다
				logoutBtn.setVisible(true);
				gameBtn.setVisible(false);
				homeBtn.setVisible(true);
				editBtn.setVisible(true);
				deleteBtn.setVisible(true);
				
				idField.setText(loginDto.getUser_Id());
				pwField.setText(loginDto.getPw());
				coin_CountField.setText(String.valueOf(loginDto.getCoin_Count()));
				nameField.setText(loginDto.getName());
				ageField.setText(String.valueOf(loginDto.getAge()));
				telField.setText(loginDto.getTel());
				emailField.setText(loginDto.getEmail());
				signUpField.setText(String.valueOf(loginDto.getSingup_Date()));
				
				
				f.setVisible(true);
			}
		});
		
		/*private JButton BoardListBtn = new JButton("게시판");
		private JButton BoardRankingBtn = new JButton("랭킹");*/
		
		// 게시판 버튼
		BoardListBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				midBoardListP.removeAll();
				
				// 나머지 미드 요소 전부 빼고 게시판 리스트 요소만 넣기
				f.remove(midHomeP);
				f.remove(midMyInfoP);
				f.remove(midBoardWriteP);
				f.remove(midBoardEditP);
				f.remove(midBoardRankingP);
				
				// 나머지 미드 요소 전부 빼고 게시판 리스트 요소만 넣기(setvisible)
				midMyInfoP.setVisible(false);
				midHomeP.setVisible(false);
				midBoardWriteP.setVisible(false);
				midBoardEditP.setVisible(false);
				midBoardRankingP.setVisible(false);
				
				// init에 f.add(boardlist) 포함됨
				initMidBoardListP();
				midBoardListP.setVisible(true);
				
				// 버튼 보이는 것만 고르기
				logoutBtn.setVisible(false);
				gameBtn.setVisible(false);
				edit2Btn.setVisible(false);
				editBtn.setVisible(false);
				deleteBtn.setVisible(false);
				writeSaveBtn.setVisible(false);
				
				writeBtn.setVisible(true);
				selectByIdBtn.setVisible(true);
				homeBtn.setVisible(true);
				
				// 게시판 테이블을 jtable로 가져올 것
				f.setVisible(true);
			}
		});
		
		
		// 랭킹 버튼 누르면 랭킹 테이블이 순위 내림차순으로 조회됨
		BoardRankingBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				midBoardRankingP.removeAll();
				
				// 나머지 미드 요소 전부 빼고 랭킹 리스트 요소만 넣기
				f.remove(midHomeP);
				f.remove(midMyInfoP);
				f.remove(midBoardWriteP);
				f.remove(midBoardEditP);
				f.remove(midBoardListP);
				
				// 나머지 미드 요소 전부 빼고 게시판 리스트 요소만 넣기(setvisible)
				midMyInfoP.setVisible(false);
				midHomeP.setVisible(false);
				midBoardWriteP.setVisible(false);
				midBoardEditP.setVisible(false);
				midBoardListP.setVisible(false);
				
				// init에 f.add(rankinglist) 포함됨
				initMidBoardRankingP();
				midBoardRankingP.setVisible(true);
				
				// 버튼 보이는 것만 고르기
				logoutBtn.setVisible(false);
				gameBtn.setVisible(false);
				edit2Btn.setVisible(false);
				editBtn.setVisible(false);
				deleteBtn.setVisible(false);
				writeSaveBtn.setVisible(false);
				writeBtn.setVisible(false);
				selectByIdBtn.setVisible(false);
				
				
				homeBtn.setVisible(true);
				
				//
				f.add(midBoardRankingP, BorderLayout.CENTER);
				f.setVisible(true);
				
				
			}
		});
		
		
	}
	
	// 홈화면
	private void initHome() {
		
		f.add(midHomeP, BorderLayout.CENTER);
		// 가운데
		midHomeP.setBackground(new Color(40, 60, 79));
		midHomeP.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0)); // 여백(=padding)
		
		JLabel titleL = new JLabel("코마에 사칙연산 게임");
		titleL.setFont(font1);
		titleL.setForeground(Color.white);
		titleL.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); // 여백(=padding)
		midHomeP.add(titleL);
		
		ImageIcon icon = new ImageIcon("img/img.png");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel mainImg = new JLabel(changeIcon);
		midHomeP.add(mainImg);
		
		
	}
	
	// 내 정보
	private void initMidMyInfo() {
		
		f.add(midMyInfoP, BorderLayout.CENTER);
		
		
		midMyInfoP.setBackground(new Color(40, 60, 79));
		midMyInfoP.setBorder(BorderFactory.createEmptyBorder(50, 10, 0, 10)); // 여백(=padding)
		midMyInfoP.setLayout(new GridLayout(9, 2, 10, 10));
		
		JLabel idLabel = new JLabel("ID");
		idField = new JTextField();
		idField.setText(loginDto.getUser_Id());
		
		JLabel pwLabel = new JLabel("PW");
		pwField = new JTextField();
		pwField.setText(loginDto.getPw());
		
		JLabel coin_CountLabel = new JLabel("COIN_COUNT");
		coin_CountField = new JTextField();
		coin_CountField.setText(String.valueOf(loginDto.getCoin_Count()));
		coin_CountField.setFocusable(false);
		coin_CountField.setEnabled(false);
		
		JLabel nameLabel = new JLabel("Name");
		nameField = new JTextField();
		nameField.setText(loginDto.getName());
		
		JLabel ageLabel = new JLabel("Age");
		ageField = new JTextField();
		ageField.setText(String.valueOf(loginDto.getAge()));
		
		JLabel telLabel = new JLabel("Tel");
		telField = new JTextField();
		telField.setText(loginDto.getTel());
		
		JLabel emailLabel = new JLabel("Email");
		emailField = new JTextField();
		emailField.setText(loginDto.getEmail());
		
		JLabel signUpLabel = new JLabel("가입일");
		signUpField = new JTextField();
		signUpField.setText(String.valueOf(loginDto.getSingup_Date()));
		signUpField.setFocusable(false);
		signUpField.setEnabled(false);
		
		idLabel.setFont(font2);
		idLabel.setOpaque(true);
		pwLabel.setFont(font2);
		pwLabel.setOpaque(true);
		coin_CountLabel.setFont(font2);
		coin_CountLabel.setOpaque(true);
		nameLabel.setFont(font2);
		nameLabel.setOpaque(true);
		ageLabel.setFont(font2);
		ageLabel.setOpaque(true);
		telLabel.setFont(font2);
		telLabel.setOpaque(true);
		emailLabel.setFont(font2);
		emailLabel.setOpaque(true);
		signUpLabel.setFont(font2);
		signUpLabel.setOpaque(true);
		
		
		midMyInfoP.add(idLabel);
		midMyInfoP.add(idField);
		midMyInfoP.add(pwLabel);
		midMyInfoP.add(pwField);
		midMyInfoP.add(coin_CountLabel);
		midMyInfoP.add(coin_CountField);
		midMyInfoP.add(nameLabel);
		midMyInfoP.add(nameField);
		midMyInfoP.add(ageLabel);
		midMyInfoP.add(ageField);
		midMyInfoP.add(telLabel);
		midMyInfoP.add(telField);
		midMyInfoP.add(emailLabel);
		midMyInfoP.add(emailField);
		midMyInfoP.add(signUpLabel);
		midMyInfoP.add(signUpField);
		
		editBtn.setBorderPainted(false);
		editBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
		editBtn.setFont(font2);
		editBtn.setBackground(new Color(63, 228, 192));
		midMyInfoP.add(editBtn);
		
		// 내정보에서 수정버튼 누르기
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 텍스트 필드의 값을 받아 컨트롤러의 함수의 인자로 전달함
				String user_Id = idField.getText();
				String Pw = pwField.getText();
				String name = nameField.getText();
				int age = Integer.parseInt(ageField.getText());
				String tel = telField.getText();
				String email = emailField.getText();
				String user_Pre_Id = loginDto.getUser_Id();
				
				// String userId, String pw,String name, int age, String tel, String email, String user_Pre_Id
				System.out.println("user_pre_id: " + user_Pre_Id);
				int result = controller.updateUser(user_Id, Pw, name, age, tel, email, user_Pre_Id);
				
				// 회원가입에 문제 없으면 콘솔에 문제없다고 표시된다
				
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "회원 정보를 수정했습니다!");
					GeneralUserDto newUser = controller.selectUser(user_Id);
					loginDto = newUser;
					
					
					idField.setText(loginDto.getUser_Id());
					pwField.setText(loginDto.getPw());
					coin_CountField.setText(String.valueOf(loginDto.getCoin_Count()));
					nameField.setText(loginDto.getName());
					ageField.setText(String.valueOf(loginDto.getAge()));
					telField.setText(loginDto.getTel());
					emailField.setText(loginDto.getEmail());
					signUpField.setText(String.valueOf(loginDto.getSingup_Date()));
					
					
				} else {
					System.out.println("result: " + result);
				}
				
				
			}
		});
		
		
		// 나의 정보의 회원탈퇴 버튼
		deleteBtn.setBorderPainted(false);
		deleteBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
		deleteBtn.setFont(font2);
		deleteBtn.setBackground(new Color(63, 228, 192));
		midMyInfoP.add(deleteBtn);
		
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean answer = (JOptionPane.showConfirmDialog(null, "정말로 계정을 삭제하시겠습니까?") == JOptionPane.YES_OPTION);
				
				if (answer == true) {
					
					int result = controller.deleteUser(loginDto.getUser_Id(), loginDto.getPw());
					
					if (result > 0) {
						JOptionPane.showMessageDialog(null, "회원을 삭제했습니다!!! 초기화면으로 돌아갑니다.");
						loginDto = null;
						
						GeneralUserBeforeLoginPage home = new GeneralUserBeforeLoginPage();
						
						f.dispose();
						
					} else {
						JOptionPane.showMessageDialog(null, "회원을 삭제할 수 없습니다!!");
						
					}
					
					
				}
				
			}
		});
		
		
	}
	
	
	// 게시판
/*	private JPanel midBoardListP = new JPanel();
	private JPanel midBoardWriteP = new JPanel();
	private JPanel midBoardEditP = new JPanel();
	private JPanel midBoardRankingP = new JPanel();*/
	
	// 게시판은 전부 jtable 사용할 예정임
	private void initMidBoardListP() {
		
		
		midBoardListP.setBackground(new Color(40, 60, 79));
		midBoardListP.setBorder(BorderFactory.createEmptyBorder(50, 10, 0, 10)); // 여백(=padding)
		
		
		GeneralUserBoardDao boardDao = new GeneralUserBoardDao();
		ArrayList<GeneralUserBoardDto> list = boardDao.allList();
		Object[][] tableData = new Object[list.size()][5];
		
		// 2차원 배열에 담기
		for (int i = 0; i < list.size(); i++) {
			tableData[i][0] = list.get(i).getNo();
			tableData[i][1] = list.get(i).getUser_Id();
			tableData[i][2] = list.get(i).getWrite_Date();
			tableData[i][3] = list.get(i).getTitle();
			tableData[i][4] = list.get(i).getContent();
		}
		
		DefaultTableModel model = new DefaultTableModel(tableData, header);
		
		/*// 보드 리스트 페이지 패널에 들어갈 jtable, jscrollpane, header
		private JTable boardListTable= new jtable();
		private JScrollPane boardListScrollPane = null;
		private String header[] = {"NO", "회원 아이디", "작성일자", "제목", "내용"};*/
		JTable boardListTable = new JTable(model);
		JScrollPane boardListScrollPane = new JScrollPane(boardListTable);
		
		
		System.out.println("boardListTable.setModel(model)");
		boardListTable.setModel(model);
		System.out.println("setViewPortView");
		boardListScrollPane.setViewportView(boardListTable);
		
		
		midBoardListP.add(boardListScrollPane);
		// 레이아웃 다시 유효하게 계산 / 컴포넌트 다시 그리기로 안보임 방지
		midBoardListP.revalidate();
		midBoardListP.repaint();
		
		
		// 마우스 클릭으로 글 조회, 수정하는 창으로 전환함
		
		boardListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int rowNum = boardListTable.getSelectedRow();
				
				// 기본키인 글 생성 순서인 no 칼럼의 인트 값을 가져와 게시판 dto을 담아와서 보여줄 예정임
				// no로 글 하나(dto)를 가져오는 것
				int no = (int) boardListTable.getModel().getValueAt(rowNum, 0);
				String user_Id = (String) boardListTable.getModel().getValueAt(rowNum, 1);
				Date write_Date = (Date) boardListTable.getModel().getValueAt(rowNum, 2);
				String title = (String) boardListTable.getModel().getValueAt(rowNum, 3);
				String content = (String) boardListTable.getModel().getValueAt(rowNum, 4);
				
				currentBoardDto = new GeneralUserBoardDto(no, user_Id, write_Date, title, content);
				JOptionPane.showMessageDialog(null, currentBoardDto.toString());
				// 이제 특정 행에 해당하는 데이터를 새로운 midpage에 넣은 페이지 만들기: MidBoardEditP
				// 글 내용은 textarea, 나머지는 textfield에 /로 구분할 것
				
				initMidBoardEditP(currentBoardDto);
				
				
			}
		});
		
		f.add(midBoardListP, BorderLayout.CENTER);
	}
	
	// 아예 글을 처음 쓰는 페이지
	private void initMidBoardWriteP() {
		
		midBoardWriteP.removeAll();
		
		// 다른 미드 페이지들을 다 제거하고
		f.remove(midMyInfoP);
		f.remove(midHomeP);
		f.remove(midBoardListP);
		f.remove(midBoardEditP);
		f.remove(midMyInfoP);
		f.remove(midBoardRankingP);
		
		midBoardWriteP.setBackground(new Color(40, 60, 79));
		midBoardWriteP.setBorder(BorderFactory.createEmptyBorder(50, 10, 0, 10)); // 여백(=padding)
		midBoardWriteP.setLayout(new GridLayout(2, 1, 10, 10));
		
		// 글을 처음 쓰기에 비어있는 jtextfield와 jtextarea
		titlesField2 = new JTextField(20);
		contentArea2 = new JTextArea(20, 20);
		
		midBoardWriteP.add(titlesField2);
		midBoardWriteP.add(contentArea2);
		
		
		// 아래 7개의 버튼 중 보여야하는 것을 고른다
		logoutBtn.setVisible(false);
		gameBtn.setVisible(false);
		edit2Btn.setVisible(false);
		writeBtn.setVisible(false);
		editBtn.setVisible(false);
		selectByIdBtn.setVisible(false);
		deleteBtn.setVisible(false);
		
		writeSaveBtn.setVisible(true);
		homeBtn.setVisible(true);
		
		
		// 셋 비지블도 마찬가지로 해준다
		midMyInfoP.setVisible(false);
		midHomeP.setVisible(false);
		midBoardEditP.setVisible(false);
		midBoardListP.setVisible(false);
		midBoardRankingP.setVisible(false);
		
		midBoardWriteP.setVisible(true);
		
		
		// 해당 미드 페이지를 넣기
		f.add(midBoardWriteP, BorderLayout.CENTER);
		
	}
	
	// 특정 행에 해당하는 글을 보고 수정할 수 있는 페이지
	private void initMidBoardEditP(GeneralUserBoardDto boardDto) {
		
		// 기존 남아있던 글 요소 제거해 오류 방지
		midBoardEditP.removeAll();
		
		// 다른 미드 페이지들을 다 제거하고
		f.remove(midHomeP);
		f.remove(midBoardListP);
		f.remove(midBoardWriteP);
		f.remove(midMyInfoP);
		f.remove(midBoardRankingP);
		
		// 해당 미드 페이지를 넣기
		f.add(midBoardEditP, BorderLayout.CENTER);
		
		// 셋 비지블도 마찬가지로 해준다
		midMyInfoP.setVisible(false);
		midHomeP.setVisible(false);
		midBoardWriteP.setVisible(false);
		midBoardRankingP.setVisible(false);
		midBoardListP.setVisible(false);
		
		midBoardEditP.setVisible(true);
		
		// 아래 7개의 버튼 중 보여야하는 것을 고른다
		logoutBtn.setVisible(false);
		gameBtn.setVisible(false);
		
		
		edit2Btn.setVisible(true);
		homeBtn.setVisible(true);
		
		
		midBoardEditP.setBackground(new Color(40, 60, 79));
		midBoardEditP.setBorder(BorderFactory.createEmptyBorder(50, 10, 0, 10)); // 여백(=padding)
		midBoardEditP.setLayout(new GridLayout(2, 1, 10, 10));
		
		titlesArea = new JTextArea(1, 20);
		contentArea = new JTextArea(20, 20);
		
		// 목록 마우스 클릭으로 해서 넘어온 dto를 이용해 텍스트를 넣어준다.
		// 번호 | 제목 | 유저아이디 | 작성일자
		titlesArea.setText(boardDto.getNo() + " | " + boardDto.getTitle() + " | " + boardDto.getUser_Id() + boardDto.getWrite_Date());
		titlesArea.setEnabled(false);
		
		// 내용은 textarea에 넣는다
		contentArea.setText(boardDto.getContent());
		
		
		midBoardEditP.add(titlesArea);
		midBoardEditP.add(contentArea);
		
		
	}
	
	private void initMidBoardRankingP() {
		
		midBoardRankingP.setBackground(new Color(40, 60, 79));
		midBoardRankingP.setBorder(BorderFactory.createEmptyBorder(50, 10, 0, 10)); // 여백(=padding)
		midBoardRankingP.setLayout(new GridLayout(1, 1, 10, 10));
		
		rankingArea = new JTextArea(20, 20);
		
		// 데이터 리스트를 가져올 레코드 다오 생성
		GeneralUserRecordDao recordDAO = new GeneralUserRecordDao();
		
		ArrayList<GeneralUserRecordDto> recordList = recordDAO.selectAll();
		
		int count = 0;
		rankingArea.append("Rank | UserId | HighScore | Level | TotalScore" + "\n");
		for (GeneralUserRecordDto recordDto : recordList) {
			count++;
			rankingArea.append(count + " | " + recordDto.getUser_Id() + " | " + recordDto.getHigh_Score() + " | " + recordDto.getLevel_No() + " | " + recordDto.getTotal_Score() + "\n");
		}
		
		
		midBoardRankingP.add(rankingArea);
		
		f.add(midBoardRankingP, BorderLayout.CENTER);
		
		
	}
	
	
	
	
	/*// 밑의 총 7개 버튼. 일부는 화면에 따라 가려진다. 로그아웃/ 게임시작 / 글쓰기/ 아이디로 조회/글 수정/홈으로
	private JButton logoutBtn = new JButton("로그아웃");
	private JButton gameBtn = new JButton("게임시작");
	
	private JButton writeBtn = new JButton("글쓰기");
	private JButton selectByIdBtn = new JButton("아이디로 조회");
	private JButton edit2Btn = new JButton("글 수정");
	private JButton homeBtn = new JButton("홈으로");*/
	
	
	private void initFooterP() {// 아래
		footerP.setBackground(new Color(40, 60, 79));
		footerP.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // 여백(=padding)
		
		
		// 로그아웃 버튼
		logoutBtn.setBorderPainted(false);
		logoutBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
		logoutBtn.setFont(font2);
		logoutBtn.setBackground(new Color(63, 228, 192));
		footerP.add(logoutBtn);
		
		// 로그아웃 버튼 이벤트
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean answer = (JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?") == JOptionPane.YES_OPTION);
				if (answer == true) {
					
					// 로그아웃시 로그인되어있던 정보를 없애기 위해 널로 지정함
					loginDto = null;
					GeneralUserBeforeLoginPage login = new GeneralUserBeforeLoginPage();
					f.dispose();
				}
				
				
			}
		});
		
		
		// 게임 버튼
		gameBtn.setBorderPainted(false);
		gameBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
		gameBtn.setFont(font2);
		gameBtn.setBackground(new Color(63, 228, 192));
		footerP.add(gameBtn);
		
		// 게임 버튼 이벤트
		gameBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "게임 시작!!");
			}
		});
		
		
		// 글쓰기 버튼
		writeBtn.setBorderPainted(false);
		writeBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
		writeBtn.setFont(font2);
		writeBtn.setBackground(new Color(63, 228, 192));
		footerP.add(writeBtn);
		
		
		// 글 쓰기 이벤트
		writeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				initMidBoardWriteP();
				
				f.setVisible(true);
				
				// 글 쓰기 페이지 밑에 있는 '글 쓰기'는 '작성한 글 저장'으로 바꿀 것!!
				// 게시판 리스트의 글 쓰기는 화면 전환
				
				
			}
		});
		
		
		// 아이디로 조회 버튼
		selectByIdBtn.setBorderPainted(false);
		selectByIdBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
		selectByIdBtn.setFont(font2);
		selectByIdBtn.setBackground(new Color(63, 228, 192));
		footerP.add(selectByIdBtn);
		
		// 아이디로 조회 이벤트
		selectByIdBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				midBoardListP.removeAll();
				
				String id = JOptionPane.showInputDialog("검색할 아이디를 입력하세요.");
				GeneralUserBoardDao boardDao = new GeneralUserBoardDao();
				ArrayList<GeneralUserBoardDto> list = boardDao.selectList(id);
				
				Object[][] tableData = new Object[list.size()][5];
				
				// 2차원 배열에 담기
				for (int i = 0; i < list.size(); i++) {
					tableData[i][0] = list.get(i).getNo();
					tableData[i][1] = list.get(i).getUser_Id();
					tableData[i][2] = list.get(i).getWrite_Date();
					tableData[i][3] = list.get(i).getTitle();
					tableData[i][4] = list.get(i).getContent();
				}
				
				DefaultTableModel model = new DefaultTableModel(tableData, header);
				JTable boardListTable = new JTable(model);
				boardListScrollPane = new JScrollPane();
				System.out.println("boardListTable.setModel(model)");
				System.out.println("setViewPortView");
				boardListScrollPane.setViewportView(boardListTable);
				// 테이블 클릭으로는 바로 수정되지 못하게 에디터를 널로 지정함
				boardListTable.setDefaultEditor(Object.class, null);
				
				
				midBoardListP.add(boardListScrollPane);
				// 레이아웃 다시 유효하게 계산 / 컴포넌트 다시 그리기로 안보임 방지
				midBoardListP.revalidate();
				midBoardListP.repaint();
				
				
				// 마우스 클릭으로 글 조회, 수정하는 창으로 전환함
				
				boardListTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						int rowNum = boardListTable.getSelectedRow();
						
						// 기본키인 글 생성 순서인 no 칼럼의 인트 값을 가져와 게시판 dto을 담아와서 보여줄 예정임
						// no로 글 하나(dto)를 가져오는 것
						int no = (int) boardListTable.getModel().getValueAt(rowNum, 0);
						String user_Id = (String) boardListTable.getModel().getValueAt(rowNum, 1);
						Date write_Date = (Date) boardListTable.getModel().getValueAt(rowNum, 2);
						String title = (String) boardListTable.getModel().getValueAt(rowNum, 3);
						String content = (String) boardListTable.getModel().getValueAt(rowNum, 4);
						
						currentBoardDto = new GeneralUserBoardDto(no, user_Id, write_Date, title, content);
						
						// 이제 특정 행에 해당하는 데이터를 새로운 midpage에 넣은 페이지 만들기: MidBoardEditP
						// 글 내용은 textarea, 나머지는 textfield에 /로 구분할 것
						
						initMidBoardEditP(currentBoardDto);
						
						
					}
				});
				
				
			}
		});
		
		
		/*// 1. 보드 행별 내용 조회하는 글 수정 페이지에 들어갈 JTextField, JTextArea
		JTextField titlesField;
		JTextArea contentArea;
		
		// 2. 글을 아예 쓰는 글 쓰기 페이지에 들어갈 JTextField, JTextArea
		JTextField titlesField2;
		JTextArea contentArea2;*/
		
		
		// 글 수정 버튼
		edit2Btn.setBorderPainted(false);
		edit2Btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
		edit2Btn.setFont(font2);
		edit2Btn.setBackground(new Color(63, 228, 192));
		footerP.add(edit2Btn);
		
		// 글 수정 이벤트
		edit2Btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String edit2Content = contentArea.getText();
				int no = currentBoardDto.getNo();
				
				GeneralUserBoardDao boardDao = new GeneralUserBoardDao();
				int result = boardDao.editBoard(no, edit2Content);
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "게시글 내용이 수정되었습니다.");
					
				} else {
					JOptionPane.showMessageDialog(null, "게시글 내용을 수정할 수 없습니다.");
				}
				
				currentBoardDto = boardDao.selectOne(no);
				
				// 수정한 내용으로 바꿈
				titlesArea.setText(currentBoardDto.getTitle());
				contentArea.setText(currentBoardDto.getContent());
				
				
			}
		});
		
		
		// 글 쓰기 페이지 밑에 있는 '글 쓰기'는 '작성한 글 저장'으로 바꿀 것!!
		// 게시판 리스트의 글 쓰기는 화면 전환
		// private JButton writeSaveBtn = new JButton("작성한 글 저장");
		
		// 작성 글 저장 버튼
		
		writeSaveBtn.setBorderPainted(false);
		writeSaveBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
		writeSaveBtn.setFont(font2);
		writeSaveBtn.setBackground(new Color(63, 228, 192));
		footerP.add(writeSaveBtn);
		
		// 작성 글 저장 이벤트
		writeSaveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 글 작성 페이지의 textfield, textarea
				String title = titlesField2.getText();
				String content = contentArea2.getText();
				
				GeneralUserBoardDao boardDao = new GeneralUserBoardDao();
				int result = boardDao.insertBoard(title, content, loginDto.getUser_Id());
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "게시글 저장 성공 ^^.");
					
				} else {
					JOptionPane.showMessageDialog(null, "게시글 저장 실패!!");
				}
				
				
			}
		});
		
		
		// 홈버튼
		homeBtn.setBorderPainted(false);
		homeBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
		homeBtn.setFont(font2);
		homeBtn.setBackground(new Color(63, 228, 192));
		footerP.add(homeBtn);
		
		
		// 홈버튼 이벤트
		homeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				f.remove(midBoardListP);
				f.remove(midBoardRankingP);
				f.remove(midBoardEditP);
				f.remove(midBoardWriteP);
				f.remove(midMyInfoP);
				
				
				f.add(midHomeP);
				
				midMyInfoP.setVisible(false);
				midHomeP.setVisible(true);
				
				homeBtn.setVisible(false);
				gameBtn.setVisible(false);
				logoutBtn.setVisible(false);
				editBtn.setVisible(false);
				edit2Btn.setVisible(false);
				writeSaveBtn.setVisible(false);
				BoardListBtn.setVisible(true);
				BoardRankingBtn.setVisible(true);
				shopBtn.setVisible(true);
				myInfoBtn.setVisible(true);
				selectByIdBtn.setVisible(false);
				writeBtn.setVisible(false);
				
				
				gameBtn.setVisible(true);
				logoutBtn.setVisible(true);
				
				
				f.setVisible(true);
				
				
			}
		});
		
		
	}
}
