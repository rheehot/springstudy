package com.example.spring01.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession;

//	 private static final String Namespace = "com.example.spring01.mapper.memberMapper";
//	    
//    @Override
//    public List<MemberDTO> memberList() throws Exception {
// 
//        return sqlSession.selectList(Namespace+".memberList");
//    }

	
	@Override
	public List<MemberDTO> memberList() {
		return sqlSession.selectList("member.memberList");
	}

	@Override
	public void insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.insert("member.insertMember",dto);
	}

	@Override
	public MemberDTO viewMember(String userid) { 
// 레코드 1개 : selectOne(), 2개 이상 : selectList()		
		return sqlSession.selectOne("member.viewMember", userid);
	}

	@Override
	public void deleteMember(String userid) {
		sqlSession.delete("member.deleteMember", userid); 
	}

	@Override
	public void updateMember(MemberDTO dto) {
		sqlSession.update("member.updateMember", dto); 
	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		boolean result=false;
		//mapper에 2개 이상의 자료를 전달할 때 : map, dto 사용
		Map<String,String> map=new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		int count=sqlSession.selectOne("member.checkPw", map);
		//비번이 맞으면 1=>true, 틀리면 0=>false 리턴
		if(count==1) result=true;
		return result;
	}
}
