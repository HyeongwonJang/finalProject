package org.animalhospital.vaccination.model.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.DiseaseVO;
import org.animalhospital.vaccination.model.VO.VaccinationRecordVO;
import org.animalhospital.vaccination.model.VO.VaccinationVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VaccinationDAOImpl implements VaccinationDAO {
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	/* (non-Javadoc)
	 * @see org.animalhospital.vaccination.model.DAO.VaccinationDAO#registerVaccination(org.animalhospital.vaccination.model.VO.VaccinationVO)
	 */
	@Override
	public void registerVaccination(VaccinationRecordVO vrvo){
		System.out.println("date"+ vrvo);
		sqlSessionTemplate.insert("Vaccination.registerVaccination", vrvo);
	}


	@Override
	public List<VaccinationVO> findAllVaccination() {
		return sqlSessionTemplate.selectList("vaccination.findAllVaccination");
	}
	@Override
	public List<DiseaseVO> findAllDisease(){
		return sqlSessionTemplate.selectList("vaccination.findAllDisease");
	}
	
	@Override
	public PetOwnerVO findPetListById(PetOwnerVO povo){
		return sqlSessionTemplate.selectOne("vaccination.findPetListById",povo);
	}
	
}
