package kr.co.seoulit.insa.salarysvc.salaryinfomgmt.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.service.SalaryInfoMgmtService;
import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to.FullTimeSalTO;
import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to.PayDayTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RequestMapping("/salaryinfomgmt/*")
@RestController
public class FullTimeSalaryController {
   
   @Autowired
   private SalaryInfoMgmtService salaryInfoMgmtService;
   @Autowired
   private DatasetBeanMapper datasetBeanMapper;
   
   @GetMapping("salary")
   public void AllMoneyList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
      
      String applyYearMonth = reqData.getVariable("date").toString();
      
      ArrayList<FullTimeSalTO> AllMoneyList = salaryInfoMgmtService.findAllMoney(applyYearMonth);
      
      datasetBeanMapper.beansToDataset(resData, AllMoneyList, FullTimeSalTO.class);
   }
   

   @PostMapping("/salary/empcode")
   public void selectSalary(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {      

      String applyYearMonth = reqData.getVariable("apply_year_month").getString();
      String empCode = reqData.getVariable("empCode").getString();

      System.out.println("applyYearMonth = " + applyYearMonth);
      System.out.println("empCode = " + empCode);            

      ArrayList<FullTimeSalTO> fullTimeSalaryList = salaryInfoMgmtService.findselectSalary(applyYearMonth,empCode);
      
      datasetBeanMapper.beansToDataset(resData, fullTimeSalaryList, FullTimeSalTO.class);
   }

   @PostMapping("salary")
   public void modifyFullTimeSalary(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
      
      ArrayList<FullTimeSalTO> fullTimeSalary
      = (ArrayList<FullTimeSalTO>)datasetBeanMapper.datasetToBeans(reqData, FullTimeSalTO.class);

      salaryInfoMgmtService.modifyFullTimeSalary(fullTimeSalary);
      }
   
   public void paydayList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception  {
      
      ArrayList<PayDayTO> list = salaryInfoMgmtService.findPayDayList();
      
      datasetBeanMapper.beansToDataset(resData, list, PayDayTO.class);
   }
   
   
}
