package kr.co.seoulit.insa.commsvc.foudinfomgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.PositionTO;

public interface PositionRepository extends JpaRepository<PositionTO,String>{

	
}
