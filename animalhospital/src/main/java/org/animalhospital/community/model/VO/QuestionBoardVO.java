package org.animalhospital.community.model.VO;

import org.animalhospital.petowner.model.VO.PetOwnerVO;

public class QuestionBoardVO {
	private int questionBoardNo;
	private String questionBoardTitle;
	private String questionBoardWriter;
	private String questionBoardContent;
	private String questionBoardHours;
	private int questionBoardHit;
	private PetOwnerVO petOwnerVO;
	
	public QuestionBoardVO() {
		super();
	}

	public QuestionBoardVO(int questionBoardNo, String questionBoardTitle,
			String questionBoardWriter, String questionBoardContent,
			String questionBoardHours, int questionBoardHit,
			PetOwnerVO petOwnerVO) {
		super();
		this.questionBoardNo = questionBoardNo;
		this.questionBoardTitle = questionBoardTitle;
		this.questionBoardWriter = questionBoardWriter;
		this.questionBoardContent = questionBoardContent;
		this.questionBoardHours = questionBoardHours;
		this.questionBoardHit = questionBoardHit;
		this.petOwnerVO = petOwnerVO;
	}

	public int getQuestionBoardNo() {
		return questionBoardNo;
	}

	public void setQuestionBoardNo(int questionBoardNo) {
		this.questionBoardNo = questionBoardNo;
	}

	public String getQuestionBoardTitle() {
		return questionBoardTitle;
	}

	public void setQuestionBoardTitle(String questionBoardTitle) {
		this.questionBoardTitle = questionBoardTitle;
	}

	public String getQuestionBoardWriter() {
		return questionBoardWriter;
	}

	public void setQuestionBoardWriter(String questionBoardWriter) {
		this.questionBoardWriter = questionBoardWriter;
	}

	public String getQuestionBoardContent() {
		return questionBoardContent;
	}

	public void setQuestionBoardContent(String questionBoardContent) {
		this.questionBoardContent = questionBoardContent;
	}

	public String getQuestionBoardHours() {
		return questionBoardHours;
	}

	public void setQuestionBoardHours(String questionBoardHours) {
		this.questionBoardHours = questionBoardHours;
	}

	public int getQuestionBoardHit() {
		return questionBoardHit;
	}

	public void setQuestionBoardHit(int questionBoardHit) {
		this.questionBoardHit = questionBoardHit;
	}

	public PetOwnerVO getPetOwnerVO() {
		return petOwnerVO;
	}

	public void setPetOwnerVO(PetOwnerVO petOwnerVO) {
		this.petOwnerVO = petOwnerVO;
	}

	@Override
	public String toString() {
		return "QuestionBoardVO [questionBoardNo=" + questionBoardNo
				+ ", questionBoardTitle=" + questionBoardTitle
				+ ", questionBoardWriter=" + questionBoardWriter
				+ ", questionBoardContent=" + questionBoardContent
				+ ", questionBoardHours=" + questionBoardHours
				+ ", questionBoardHit=" + questionBoardHit + ", petOwnerVO="
				+ petOwnerVO + "]";
	}

	
}
