package kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.mapper.BaseExtSalMapper;
//import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.mapper.BaseSalaryMapper;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.mapper.SocialInsMapper;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.repository.BaseExtSalRepository;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.repository.BaseSalRepository;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.to.BaseExtSalTO;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.to.BaseSalaryTO;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.to.SocialInsTO;

@Service
public class SalaryStdInfoMgmtServiceImpl implements SalaryStdInfoMgmtService{
	
//	@Autowired
//	private BaseSalaryMapper baseSalaryMapper;
//	@Autowired
//	private BaseExtSalMapper baseExtSalMapper;
	@Autowired
	private SocialInsMapper SocialInsureMapper;
	
	@Autowired
	private BaseExtSalRepository baseExtSalrepository;
	@Autowired
	private BaseSalRepository baseSalrepository;

	
	@Override
	public ArrayList<BaseSalaryTO> findBaseSalaryList() {

		ArrayList<BaseSalaryTO> baseSalaryList=null;
		baseSalaryList = (ArrayList<BaseSalaryTO>)baseSalrepository.findAll();
		//baseSalaryList = baseSalaryMapper.selectBaseSalaryList();
		return baseSalaryList;
		
	}
	
	@Override
	public void modifyBaseSalaryList(ArrayList<BaseSalaryTO> baseSalaryList) {

		for (BaseSalaryTO baseSalary : baseSalaryList) {
			if (baseSalary.getStatus().equals("update"))
				baseSalrepository.save(baseSalary);
				//baseSalaryMapper.updateBaseSalary(baseSalary);
		}
		
	}
	
	@Override
	public ArrayList<BaseExtSalTO> findBaseExtSalList() {

		ArrayList<BaseExtSalTO> baseExtSalList=null;
		baseExtSalList = (ArrayList<BaseExtSalTO>)baseExtSalrepository.findAll();
		//baseExtSalList = baseExtSalMapper.selectBaseExtSalList();
		return baseExtSalList;
		
	}
	
	@Override
	public void modifyBaseExtSalList(ArrayList<BaseExtSalTO> baseExtSalList) {

		for (BaseExtSalTO baseExtSal : baseExtSalList) {
			baseExtSalrepository.save(baseExtSal);
				//baseExtSalMapper.updateBaseExtSal(baseExtSal);
		}		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SocialInsTO> findBaseInsureList(String yearBox) {

		HashMap<String, Object> map = new HashMap<String, Object>();
	      map.put("yearBox", yearBox);
	      SocialInsureMapper.selectBaseInsureList(map);
	      ArrayList<SocialInsTO> BaseInsureList = (ArrayList<SocialInsTO>) map.get("result");
	      return BaseInsureList;
		
	}
	
	@Override
	public void updateInsureData(ArrayList<SocialInsTO> baseInsureList) {

		for (SocialInsTO baseInsure : baseInsureList) {
			SocialInsureMapper.updateInsureData(baseInsure);
		}
		
	}

	@Override
	public void deleteInsureData(String year) {
			SocialInsureMapper.deleteInsureData(year);
	
	}
	
}
