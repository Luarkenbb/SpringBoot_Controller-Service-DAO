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
import martin.controllerservicedao.example.model.request.CustomerGetCustomerDetailRequest;
import martin.controllerservicedao.example.model.vo.CustomerDetailVO;

@Repository
public class CustomerEnquiryRepository {
	private static final Logger logger = LogManager.getLogger(CustomerEnquiryRepository.class);
	
	@Autowired
	private EntityManager entityManager;
	
	public CustomerDetailVO getCustomerDetail(CustomerGetCustomerDetailRequest request) {
		logger.info("getCustomerDetail start");
		CustomerDetailVO vo = new CustomerDetailVO();
		
		List<CustomerDetailVO> list = new ArrayList();
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
					+ "WHERE `customerNumber` = ?");
			Query query = entityManager.createNativeQuery(sql.toString(),CustomerDetailVO.class);
			if(request.getCustomerNumber() != 0) { //primitives dont have null value
				query.setParameter(1, request.getCustomerNumber());
			}
			list = query.getResultList();
			vo = list.get(0);
			
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		
		logger.info("getCustomerDetail end");
		return vo;
	}
}
