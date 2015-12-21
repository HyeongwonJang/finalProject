package org.animalhospital.community.model.DAO;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.community.model.VO.AnswerBoardVO;
import org.animalhospital.community.model.VO.QuestionBoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityBoardDAOImpl implements CommunityBoardDAO{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 1:1 문의 게시판 글 작성 메서드
	 * @param QuestionBoardVO
	 * @author 강신후 , 곽진혁
	 */
	@Override
	public void writeCommunity(QuestionBoardVO qbvo) {
		sqlSessionTemplate.insert("communityBoard.writeCommunity",qbvo);
	}

	/**
	 * 1:1 문의 게시판 조회수 증가 시키기는 메소드
	 * @param int
	 * @author 강신후 , 곽진혁
	 */
	@Override
	public void updateCount(int questionBoardHit) {
		sqlSessionTemplate.update("communityBoard.updateCommunityBoardHit",questionBoardHit);
	}

	/**
	 * 1:1 문의 게시판 글 상세 보기 메서드
	 * @param int
	 * @author 강신후 , 곽진혁
	 */
	@Override
	   public QuestionBoardVO showCommunityBoardContent(int questionBoardNo){
	      return (QuestionBoardVO)sqlSessionTemplate.selectOne("communityBoard.showCommunityBoardContent",questionBoardNo);
	   }
	
	 /**
		 * 1:1 문의 게시판 전체 글 갯수 구하는 메소드 (totalContent))
		 * @param String
		 * @author 강신후 , 곽진혁
		 */
		@Override
		public int totalContent() {
			return sqlSessionTemplate.selectOne("communityBoard.totalContent");
		}

	/**
	 * 1:1 문의 게시판 전제 글 목록 출력하는 메소드
	 * @param String
	 * @author 강신후 , 곽진혁
	 */
	@Override
	public List<QuestionBoardVO> findCommunityBoardList(String pageNo) {
		return sqlSessionTemplate.selectList("communityBoard.findCommunityBoardList",pageNo);
	}

	/**
	 * 1:1 문의 게시판 글 수정 처리하는 메소드
	 * @param QuestionBoardVO
	 * @author 강신후 , 곽진혁
	 */
	@Override
	public void updateCommunityBoard(QuestionBoardVO qbvo) {
		sqlSessionTemplate.update("communityBoard.updateCommunityBoard",qbvo);
	}

	/**
	 * 1:1 문의 게시판 글 삭제 처리하는 메소드
	 * @param int
	 * @author 강신후 , 곽진혁
	 */
	@Override
	public void deleteCommunityBoard(int questionBoardNo) {
		sqlSessionTemplate.delete("communityBoard.deleteCommunityBoard",questionBoardNo);
	}

	
	@Override
	public void updateRestep(int ref, int restep) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("ref", ref);
		map.put("restep", restep);
		sqlSessionTemplate.update("communityBoard.updateRestep", map);		
	}
	@Override
	public void insertRefContent(AnswerBoardVO abvo){
		sqlSessionTemplate.insert("communityBoard.writeReply", abvo);		
	}

	
	
	
	
}
