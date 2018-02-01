package com.javaex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.conn.DbConnect;
import com.javaex.vo.GuestVo;

import oracle.jdbc.pool.OracleDataSource;

@Repository
public class GuestDao {
	@Autowired
	private OracleDataSource oracleDataSource;
	@Autowired
	SqlSession sqlSession;

	public void insert(GuestVo vo) {

		sqlSession.insert("guestbook.insert", vo);

	}

	public void delete2(String pass, int no) { // 삭제에 해당하는 번호의 테이블의 비밀번호와 사용자입력비밀번호가 맞을경우 삭제
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", pass);
		sqlSession.delete("guestbook.delete2", map);

	}

	public List<GuestVo> getListAll() {

		List<GuestVo> gulist = sqlSession.selectList("guestbook.getList");

		return gulist;
	}
}
