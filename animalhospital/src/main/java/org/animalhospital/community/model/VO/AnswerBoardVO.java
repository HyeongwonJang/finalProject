package org.animalhospital.community.model.VO;

import org.animalhospital.vet.model.VO.HospitalVO;

public class AnswerBoardVO {
	private int answerBoardNo;
	private String answerBoardTitle;
	private String answerBoardWriter;
	private String answerBoardContent;
	private String answerBoardHours;
	private int answerBoardHit;
	private int ref;
	private int reStep;
	private int reLevel;
	private HospitalVO hospitalVO;
	
	public AnswerBoardVO() {
		super();
	}

	public AnswerBoardVO(int answerBoardNo, String answerBoardTitle,
			String answerBoardWriter, String answerBoardContent,
			String answerBoardHours, int answerBoardHit, int ref, int reStep,
			int reLevel, HospitalVO hospitalVO) {
		super();
		this.answerBoardNo = answerBoardNo;
		this.answerBoardTitle = answerBoardTitle;
		this.answerBoardWriter = answerBoardWriter;
		this.answerBoardContent = answerBoardContent;
		this.answerBoardHours = answerBoardHours;
		this.answerBoardHit = answerBoardHit;
		this.ref = ref;
		this.reStep = reStep;
		this.reLevel = reLevel;
		this.hospitalVO = hospitalVO;
	}

	public int getAnswerBoardNo() {
		return answerBoardNo;
	}

	public void setAnswerBoardNo(int answerBoardNo) {
		this.answerBoardNo = answerBoardNo;
	}

	public String getAnswerBoardTitle() {
		return answerBoardTitle;
	}

	public void setAnswerBoardTitle(String answerBoardTitle) {
		this.answerBoardTitle = answerBoardTitle;
	}

	public String getAnswerBoardWriter() {
		return answerBoardWriter;
	}

	public void setAnswerBoardWriter(String answerBoardWriter) {
		this.answerBoardWriter = answerBoardWriter;
	}

	public String getAnswerBoardContent() {
		return answerBoardContent;
	}

	public void setAnswerBoardContent(String answerBoardContent) {
		this.answerBoardContent = answerBoardContent;
	}

	public String getAnswerBoardHours() {
		return answerBoardHours;
	}

	public void setAnswerBoardHours(String answerBoardHours) {
		this.answerBoardHours = answerBoardHours;
	}

	public int getAnswerBoardHit() {
		return answerBoardHit;
	}

	public void setAnswerBoardHit(int answerBoardHit) {
		this.answerBoardHit = answerBoardHit;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getReStep() {
		return reStep;
	}

	public void setReStep(int reStep) {
		this.reStep = reStep;
	}

	public int getReLevel() {
		return reLevel;
	}

	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}

	public HospitalVO getHospitalVO() {
		return hospitalVO;
	}

	public void setHospitalVO(HospitalVO hospitalVO) {
		this.hospitalVO = hospitalVO;
	}

	@Override
	public String toString() {
		return "AnswerBoardVO [answerBoardNo=" + answerBoardNo
				+ ", answerBoardTitle=" + answerBoardTitle
				+ ", answerBoardWriter=" + answerBoardWriter
				+ ", answerBoardContent=" + answerBoardContent
				+ ", answerBoardHours=" + answerBoardHours
				+ ", answerBoardHit=" + answerBoardHit + ", ref=" + ref
				+ ", reStep=" + reStep + ", reLevel=" + reLevel
				+ ", hospitalVO=" + hospitalVO + "]";
	}
	

	
}
