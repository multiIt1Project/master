package com.multi.hdbc_h.service;

import com.multi.hdbc_h.dao.UsersDao;
import com.multi.hdbc_h.dto.Record;
import com.multi.jdbc.common.exception.MemberException;

import java.sql.Connection;

import static com.multi.jdbc.common.JDBCTemplate.getConnection;

/* Service 클래스에서 메소드 작성 방법
 * 1) Controller로 부터 인자를 전달받음
 * 2) Connection 객체 생성
 * 3) Dao 객체 생성
 * 4) Dao로 생성한 Connection 객체와 인자를 전달
 * 5) Dao 수행 결과를 가지고 비즈니스 로직 및 트랜잭션 관리를 함 */
public class UsersService {

    private final UsersDao usersDao;

    public UsersService() {
        usersDao = new UsersDao();
    }

    public int updateHIGH_SCORE(Record record) throws MemberException {
        Connection conn = getConnection();
        int result = usersDao.updateHIGH_SCORE(conn, record);
        return result;
    }


    public int selectlevel(int level) throws MemberException {

        Connection conn = getConnection();
        int num = usersDao.selectlevel(level,conn);
        return num;
    }

    public Record selectHIGH_SCORE(String id) throws MemberException {
        Connection conn = getConnection();
         Record record= usersDao.selectHIGH_SCORE(id,conn);

        return record;
    }

    public int selectItem(String id,int item_NO) throws MemberException {
        Connection conn = getConnection();
        int num = usersDao.selectItem(id,item_NO,conn);
        return num;
    }

    public int updateItem(String id,int itemNo, int item_COUNT) throws MemberException {
        Connection conn = getConnection();
        int result = usersDao.updateItem(conn,id, itemNo,item_COUNT);
        return result;
    }
}
