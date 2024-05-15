package com.multi.gameProject.game.model.dao;

import com.multi.gameProject.common.MemberException;
import com.multi.gameProject.game.model.dto.Item_invt;
import com.multi.gameProject.game.model.dto.Levels;
import com.multi.gameProject.game.model.dto.Recorduser;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.multi.gameProject.common.JDBCTemplate.close;


public class UsersDao {



    public UsersDao() {
    }

    public int selectlevel(int level, Connection conn) throws MemberException {
        ResultSet rset = null;
        int num=0;
        PreparedStatement ps = null;
        String sql="SELECT * FROM LEVELS WHERE LEVEL_NO=?";


        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, level);
            rset = ps.executeQuery();
            Levels levels=new Levels();
            if(rset.next()){
            levels.setScore(rset.getInt("SCORE"));
            num=levels.getScore();

            }
        } catch (SQLException e) {
            //  e.printStackTrace();
            throw new MemberException("updateMember 에러 : " + e.getMessage());
        }finally {
            close(ps);
        }

        return num;
    }

    public int updateHIGH_SCORE(Connection conn, Recorduser record) throws MemberException {
        int result = 0;
        PreparedStatement ps = null;

        String sql = "UPDATE RECORD SET HIGH_SCORE = ? , LEVEL_NO = ?,TOTAL_SCORE=? WHERE USER_ID=?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, record.getHigh_score());
            ps.setInt(2, record.getLevel_no() );
            ps.setInt(3, record.getTotal_score() );
            ps.setString(4, record.getUser_ID() );



            result = ps.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            //    e.printStackTrace();

            throw new MemberException("updateMember 에러 : " + e.getMessage());
        }finally {
            close(ps);
        }

        return result;
    }

    public Recorduser selectHIGH_SCORE(String id, Connection conn) throws MemberException {
        ResultSet rset = null;
        int num=0;
        PreparedStatement ps = null;
        String sql="SELECT * FROM RECORD WHERE USER_ID=?";
        Recorduser record=new Recorduser();

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rset = ps.executeQuery();

            if(rset.next()){
                record.setHigh_score(rset.getInt("HIGH_SCORE"));
                record.setTotal_score(rset.getInt("TOTAL_SCORE"));
                record.setUser_ID(id);
                num=record.getHigh_score();

            }
        } catch (SQLException e) {
            //  e.printStackTrace();
            throw new MemberException("updateMember 에러 : " + e.getMessage());
        }finally {
            close(ps);
        }

        if(record.getUser_ID()==null){
    int rset1 = 0;

    PreparedStatement ps1 = null;
    String sql1="INSERT  INTO  RECORD VALUES(?,0,1,0)";
    record=new Recorduser();

    try {
        ps= conn.prepareStatement(sql1);
        ps.setString(1, id);
        
        rset1 = ps.executeUpdate();
        if(rset1>0){
        conn.commit();}

    } catch (SQLException e) {
        //  e.printStackTrace();
        throw new MemberException("updateMember 에러 : " + e.getMessage());
    }finally {
        close(ps);
    }

}

        return record;
    }

    public int selectItem(String id, int item_NO,Connection conn) throws MemberException {
        ResultSet rset = null;
        int num=0;
        PreparedStatement ps = null;
        String sql="SELECT *FROM ITEM_INVT WHERE USER_ID =? AND ITEM_NO =?";


        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setInt(2,item_NO);
            rset = ps.executeQuery();
            Item_invt itemInvt=new Item_invt();
            if(rset.next()){
                itemInvt.setItem_COUNT(rset.getInt("ITEM_COUNT"));

                num=itemInvt.getItem_COUNT();

            }
        } catch (SQLException e) {
            //  e.printStackTrace();
            throw new MemberException("updateMember 에러 : " + e.getMessage());
        }finally {
            close(ps);
        }

        return num;
    }

    public int updateItem(Connection conn, String id,int itemNo,int item_COUNT) throws MemberException {
        int result = 0;
        PreparedStatement ps = null;

        String sql = "UPDATE ITEM_INVT SET ITEM_COUNT =?  WHERE USER_ID=? AND ITEM_NO =?";

        try {
            ps = conn.prepareStatement(sql);
//
          ps.setInt(1, item_COUNT);
           ps.setInt(3, itemNo );
           ps.setString(2, id );
           conn.commit();
            result = ps.executeUpdate();

        } catch (SQLException e) {
            //    e.printStackTrace();

            throw new MemberException("updateMember 에러 : " + e.getMessage());
        }finally {
            close(ps);
        }

        return result;
    }
}
