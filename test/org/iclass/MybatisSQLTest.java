package org.iclass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.dao.NewMemberMybatisDao;
import org.iclass.vo.NewMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mybatis.SqlSessionBean;

class MybatisSQLTest {
	
	private NewMemberMybatisDao dao = NewMemberMybatisDao.getInstance();
	
	@DisplayName("login 테스트 - momo")  
	@Test
	void login() {					//실패 및 성공 각각의 케이스 id,password 값으로 테스트 해보세요.
		String id="momo";
		String password="1111";
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		
		NewMember vo = dao.login(map);
		//assertNotNull(vo.getId());		//조회 결과가 없을때 vo가 null 이면, getId() 오류
		assertNotNull(vo);
	}
	
	@DisplayName("selectOne 테스트 - momo")  
	@Test
	void selectOne() {  //PK로 검색은 1건 이하
		NewMemberMybatisDao dao = NewMemberMybatisDao.getInstance();
		NewMember vo = dao.selectOne("momo");				//실패 및 성공 각각의 케이스 id값으로 테스트 해보세요.
		//assertEquals(vo.getId(), "momo");	//조회 결과가 없을때 vo가 null 이면, getId() 오류
		assertNotNull(vo);
	}
	
	
	@DisplayName("select 전체 조회 테스트-현재예상값 3")
	@Test
	void selectList() {
		assertEquals(dao.selectAll().size(), 3);
		
	}
	
	@DisplayName("SqlSession 연결 테스트")
	@Test
	void session() {
		SqlSession mapper = SqlSessionBean.getSession();
		assertNotEquals(mapper, null);
		mapper.close();
	}
	
	@DisplayName("update 테스트 - id(PK):momo로 수정")  //실패 및 성공 각각의 케이스 id값으로 테스트 해보세요.
	@Test
	void update() {
		int result = dao.update(NewMember.builder()
				.id("momo")
				.email("mm3@naver.com")
				.age(23)
				.gender("1")
				.hobbies("달리기,스키")
				.build()
				);
		assertEquals(result, 1);
		
	}
	
	@DisplayName("delete 테스트 - id(PK):momo99 삭제")  //실패 및 성공 각각의 케이스 id값으로 테스트 해보세요.
	@Test
	void delete() {
		int result = dao.delete("momo99");
		assertEquals(result, 1);
		
	}
	
//	@DisplayName("insert 테스트 - id(PK):momo로 추가")  //첫번째 테스트는 성공,두번쨰 테스트는 실패. 
	void insert() {
		int result = dao.insert(NewMember.builder()	
				.id("momo3")						
				.name("이모모3")
				.password("1212")
				.email("momo3@naver.com")
				//			.age(23)
				//			.gender("2")
				//			.hobbies("달리기")
				.build()
				);
		assertEquals(result, 1);
		
	}

}
