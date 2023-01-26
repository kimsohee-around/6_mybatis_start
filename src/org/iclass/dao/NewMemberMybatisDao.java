package org.iclass.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.NewMember;

import mybatis.SqlSessionBean;

public class NewMemberMybatisDao {
	private static final NewMemberMybatisDao dao = new NewMemberMybatisDao();
	private NewMemberMybatisDao() {}
	public static NewMemberMybatisDao getInstance() {
		return dao;
	}

	//Exception 처리 필요 없음. 객체와 db컬럼 매핑 필요 없음.리스트 add 필요없음.
	public List<NewMember> selectAll() {
		SqlSession mapper = SqlSessionBean.getSession();
		List<NewMember> list = mapper.selectList("selectAll");
		
		mapper.close(); //필수
		return list;
	}
	
}
