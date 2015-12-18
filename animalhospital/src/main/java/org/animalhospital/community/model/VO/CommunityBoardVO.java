package org.animalhospital.community.model.VO;

import org.animalhospital.petowner.model.VO.PetOwnerVO;

public class CommunityBoardVO {
	private int communityBoardNo;
	private String communityBoardTitle;
	private String communityBoardContent;
	private String communityBoardHours;
	private int communityBoardHit;
	private String communityBoardUserType;
	private PetOwnerVO petOwnerVO;
	public CommunityBoardVO() {
		super();
	}
	public CommunityBoardVO(int communityBoardNo, String communityBoardTitle,
			String communityBoardContent, String communityBoardHours,
			int communityBoardHit, String communityBoardUserType,
			PetOwnerVO petOwnerVO) {
		super();
		this.communityBoardNo = communityBoardNo;
		this.communityBoardTitle = communityBoardTitle;
		this.communityBoardContent = communityBoardContent;
		this.communityBoardHours = communityBoardHours;
		this.communityBoardHit = communityBoardHit;
		this.communityBoardUserType = communityBoardUserType;
		this.petOwnerVO = petOwnerVO;
	}
	public int getCommunityBoardNo() {
		return communityBoardNo;
	}
	public void setCommunityBoardNo(int communityBoardNo) {
		this.communityBoardNo = communityBoardNo;
	}
	public String getCommunityBoardTitle() {
		return communityBoardTitle;
	}
	public void setCommunityBoardTitle(String communityBoardTitle) {
		this.communityBoardTitle = communityBoardTitle;
	}
	public String getCommunityBoardContent() {
		return communityBoardContent;
	}
	public void setCommunityBoardContent(String communityBoardContent) {
		this.communityBoardContent = communityBoardContent;
	}
	public String getCommunityBoardHours() {
		return communityBoardHours;
	}
	public void setCommunityBoardHours(String communityBoardHours) {
		this.communityBoardHours = communityBoardHours;
	}
	public int getCommunityBoardHit() {
		return communityBoardHit;
	}
	public void setCommunityBoardHit(int communityBoardHit) {
		this.communityBoardHit = communityBoardHit;
	}
	public String getCommunityBoardUserType() {
		return communityBoardUserType;
	}
	public void setCommunityBoardUserType(String communityBoardUserType) {
		this.communityBoardUserType = communityBoardUserType;
	}
	public PetOwnerVO getPetOwnerVO() {
		return petOwnerVO;
	}
	public void setPetOwnerVO(PetOwnerVO petOwnerVO) {
		this.petOwnerVO = petOwnerVO;
	}
	@Override
	public String toString() {
		return "CommunityBoardVO [communityBoardNo=" + communityBoardNo
				+ ", communityBoardTitle=" + communityBoardTitle
				+ ", communityBoardContent=" + communityBoardContent
				+ ", communityBoardHours=" + communityBoardHours
				+ ", communityBoardHit=" + communityBoardHit
				+ ", communityBoardUserType=" + communityBoardUserType
				+ ", petOwnerVO=" + petOwnerVO + "]";
	}
	
	
	
	
}
