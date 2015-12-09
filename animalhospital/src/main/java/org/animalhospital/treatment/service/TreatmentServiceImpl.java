package org.animalhospital.treatment.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.paging.model.bean.PagingBean;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.treatment.model.DAO.TreatmentDAO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
import org.springframework.stereotype.Service;

@Service
public class TreatmentServiceImpl implements TreatmentService {
	@Resource
	private TreatmentDAO treatmentDAO;
	@Resource
	private ListVO listVO;
	
	
	/**
	 * 진료기록 검색결과를 반환하는 메서드
	 */
	public ListVO findTreatmentRecordByPage(Map<String, Object> paramMap){
		List<Object> list = treatmentDAO.findTreatmentRecordByPage(paramMap);
		for(int li=0; li<list.size(); li++){
			((TreatmentRecordVO) list.get(li)).setPetOwnerVO((PetOwnerVO) paramMap.get("povo"));
		}
		listVO.setList(list);
		listVO.getPagingBean().setNowPage(((ListVO) paramMap.get("listVO")).getPage());
		listVO.getPagingBean().setTotalContents(treatmentDAO.findAllTreatmentRecord(paramMap));
		return listVO;
	}
	
	/**
	 * 진료기록 상세보기를 출력하는 메서드
	 */
	public TreatmentRecordVO findDetailTreatmentRecordByTreatmentNo(int treatmentNo){
		PetVO detailPetVO = treatmentDAO.findDetailPetRecordByTreatmentNo(treatmentNo);
		TreatmentRecordVO searchTreatmentVO = treatmentDAO.findDetailTreatmentRecordByTreatmentNo(treatmentNo);
		searchTreatmentVO.getPetOwnerVO().addPetVO(detailPetVO);
		return searchTreatmentVO;
	}
	
}
