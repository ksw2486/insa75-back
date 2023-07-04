package kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpEvalTO;

public interface EmpEvalRepository extends JpaRepository<EmpEvalTO,String>{

	
}
