package kr.co.seoulit.insa.commsvc.systemmgmt.repository;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.DetailCodeTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DetailCodeRepository extends JpaRepository<DetailCodeTO, String>{

	ArrayList<DetailCodeTO> findAll();
	ArrayList<DetailCodeTO> findAllBycodeNumber(String codetype);
//
//
//	void deleteByDetailCodeNumberAndDetailCodeName(String detailCodeNumber, String detailCodeName);
//
//	void deleteByDetailCodeNumberAndDetailCodeNameAndCodeNumberAndDetailCodeNameusing(String detailCodeNumber,
//			String detailCodeName, String codeNumber, String detailCodeNameusing);
//
//	

}
