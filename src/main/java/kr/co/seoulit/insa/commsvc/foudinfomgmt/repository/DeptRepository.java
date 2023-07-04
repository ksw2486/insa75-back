package kr.co.seoulit.insa.commsvc.foudinfomgmt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.DeptTO;


public interface DeptRepository extends JpaRepository<DeptTO, String>{


}
