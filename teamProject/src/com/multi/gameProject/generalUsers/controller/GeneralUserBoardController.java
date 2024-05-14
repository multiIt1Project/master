package com.multi.gameProject.generalUsers.controller;

import com.multi.gameProject.generalUsers.model.dto.GeneralUserBoardDto;
import com.multi.gameProject.generalUsers.service.GeneralUserBoardService;

import javax.swing.*;
import java.util.ArrayList;

public class GeneralUserBoardController {
	
	
	private GeneralUserBoardService boardService = new GeneralUserBoardService();
	
	public ArrayList<GeneralUserBoardDto> selectAllBoard() {
		
		ArrayList<GeneralUserBoardDto> list = null;
		
		try {
			list = boardService.selectAllBoard();
			
			if (!list.isEmpty()) {
				JOptionPane.showMessageDialog(null, "게시판 글이 있음");
			} else {
				JOptionPane.showMessageDialog(null, "게시판 글이 없음");
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "게시글 리스트 조회중 오류 발생..");
		}
		
		return list;
	}
	
	
	public ArrayList<GeneralUserBoardDto> selectList(String id) {
		
		ArrayList<GeneralUserBoardDto> list = null;
		
		try {
			list = boardService.selectList(id);
			
			if (!list.isEmpty()) {
				JOptionPane.showMessageDialog(null, "게시판 글이 있음");
			} else {
				JOptionPane.showMessageDialog(null, "게시판 글이 없음");
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "게시글 리스트 조회중 오류 발생..");
		}
		
		return list;
		
	}
	
	public int editBoard(int no, String content) {
		
		int result = 0;
		
		try {
			result = boardService.editBoard(no, content);
			
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "게시글 수정 성공");
			} else {
				JOptionPane.showMessageDialog(null, "게시글 수정 실패");
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "게시글 수정 에러 발생...");
		}
		
		return result;
		
		
	}
	
	public int insertBoard(String title, String content, String userId) {
		
		int result = 0;
		
		try {
			result = boardService.insertBoard(title, content, userId);
			
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "게시글 삽입 성공");
			} else {
				JOptionPane.showMessageDialog(null, "게시글 삽입 실패");
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "게시글 삽입 에러 발생...");
		}
		
		
		return result;
	}
	
	
	public GeneralUserBoardDto selectOneBoard(int no) {
		
		GeneralUserBoardDto boardDto = null;
		
		try {
			 boardDto= boardService.selectOneBoard(no);
			
			if  (boardDto != null) {
				JOptionPane.showMessageDialog(null, "게시글 찾기 성공");
			} else {
				JOptionPane.showMessageDialog(null, "게시글 찾기 실패");
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "게시글 찾기 에러 발생...");
			System.out.println(e.getStackTrace());
		}
		
		return boardDto;
	}
	
	
	
	
}
