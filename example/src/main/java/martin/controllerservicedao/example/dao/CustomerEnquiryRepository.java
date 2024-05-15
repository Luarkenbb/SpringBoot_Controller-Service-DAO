package martin.controllerservicedao.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Repository;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import martin.controllerservicedao.example.model.request.CustomerGetDetailsByPKRequest;
import martin.controllerservicedao.example.model.vo.CustomerDetailsVO;

@Repository
public class CustomerEnquiryRepository {
	private static final Logger logger = LogManager.getLogger(CustomerEnquiryRepository.class);
	
	@Autowired
	private EntityManager entityManager;
	
	public CustomerDetailsVO getCustomerDetailsByPK(CustomerGetDetailsByPKRequest request) {
		logger.info("getCustomerDetailsByPK start");
		CustomerDetailsVO vo = new CustomerDetailsVO();
		
		List<CustomerDetailsVO> list = new ArrayList();
		try {
			StringBuffer sql = new StringBuffer("SELECT `customerNumber`,"
					+ "    `customerName`,"
					+ "    `contactLastName`,"
					+ "    `contactFirstName`,"
					+ "    `phone`,"
					+ "    `addressLine1`,"
					+ "    `addressLine2`,"
					+ "    `city`,"
					+ "    `state`,"
					+ "    `postalCode`,"
					+ "    `country`,"
					+ "    `salesRepEmployeeNumber`,"
					+ "    `creditLimit`"
					+ "FROM `customers` "
					+ "WHERE `customerNumber` = :number");
			Query query = entityManager.createNativeQuery(sql.toString(),CustomerDetailsVO.class);
			if(request.getCustomerNumber() != 0) { //primitives dont have null value
				query.setParameter("number", request.getCustomerNumber());
			}
			list = query.getResultList();
			if(list.size() == 0) {
				vo = null;
			}else {
				vo = list.get(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		
		logger.info("getCustomerDetailsByPK end");
		return vo;
	}
	
	
	public List<CustomerDetailsVO> getCustomerDetails(CustomerGetDetailsByPKRequest request) {
		logger.info("getCustomerDetails start");
		List<CustomerDetailsVO> list = new ArrayList();
		try {
			/*--SELECT SQL--*/
			StringBuffer select_from_sql = new StringBuffer("SELECT `customerNumber`,"
					+ "    `customerName`,"
					+ "    `contactLastName`,"
					+ "    `contactFirstName`,"
					+ "    `phone`,"
					+ "    `addressLine1`,"
					+ "    `addressLine2`,"
					+ "    `city`,"
					+ "    `state`,"
					+ "    `postalCode`,"
					+ "    `country`,"
					+ "    `salesRepEmployeeNumber`,"
					+ "    `creditLimit`"
					+ "FROM `customers` ");
			/*-- Allowed Searching Criteria --*/
			/**/
			/*-- WHERE SQL--*/
			//todo
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		logger.info("getCustomerDetails end");
		return null;
	}
}
