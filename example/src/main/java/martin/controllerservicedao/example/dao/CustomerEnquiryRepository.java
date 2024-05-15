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
import martin.controllerservicedao.example.model.request.CustomerGetDetailsRequest;
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
					+ "    `creditLimit` "
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
	
	
	public List<CustomerDetailsVO> getCustomerDetails(CustomerGetDetailsRequest request) {
		logger.info("getCustomerDetails start");
		List<CustomerDetailsVO> list = new ArrayList();
		try {
			/*-- Check Searching Criteria --*/
			boolean isCustomerNameExist, isContactLastNameExist, isContactFirstNameExist, isPhoneExist, isCityExist, isCountryExist, isCreditLimitExist;
			if(StringUtils.isEmpty(request.getCustomerName())) {
				isCustomerNameExist = false;}
			else {
				isCustomerNameExist = true;
			}
			
			if(StringUtils.isEmpty(request.getContactLastName())) {
				isContactLastNameExist = false;
			}else {
				isContactLastNameExist = true;
			}
			
			if(StringUtils.isEmpty(request.getContactFirstName())) {
				isContactFirstNameExist = false;
			}else {
				isContactFirstNameExist = true;
			}
			
			if(StringUtils.isEmpty(request.getPhone())) {
				isPhoneExist = false;
			}else {
				isPhoneExist = true;
			}
			
			if(StringUtils.isEmpty(request.getCity())) {
				isCityExist = false;
			}else {
				isCityExist = true;
			}
			
			if(StringUtils.isEmpty(request.getCountry())) {
				isCountryExist = false;
			}else {
				isCountryExist = true;
			}
			
			if(request.getCreditLimit() == 0) {
				isCreditLimitExist = false;
			}else {
				isCreditLimitExist = true;
			}
			
			if(!isCustomerNameExist && !isContactLastNameExist && !isContactFirstNameExist && !isPhoneExist && !isCityExist && !isCountryExist && !isCreditLimitExist) {
				logger.info("getCustomerDetails: no searching criteria");
				return null;
			}
			/**/
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
					+ "    `creditLimit` "
					+ "FROM `customers` ");
			
			/*-- WHERE SQL--*/
			boolean isFirstCondition = true;
			StringBuffer where_sql = new StringBuffer("");
			
			if(isCustomerNameExist) {
				if(isFirstCondition) {
					where_sql.append("WHERE ");
					isFirstCondition = false;
				}else {
					where_sql.append("AND ");
				}
				where_sql.append("`customerName` LIKE :customer_name ");
			}
			
			if(isContactLastNameExist) {
				if(isFirstCondition) {
					where_sql.append("WHERE ");
					isFirstCondition = false;
				}else {
					where_sql.append("AND ");
				}
				where_sql.append("`contactLastName` LIKE :contact_last_name ");
			}
			
			if(isContactFirstNameExist) {
				if(isFirstCondition) {
					where_sql.append("WHERE ");
					isFirstCondition = false;
				}else {
					where_sql.append("AND ");
				}
				where_sql.append("`contactFirstName` LIKE :contact_first_name ");
			}
			
			if(isPhoneExist) {
				if(isFirstCondition) {
					where_sql.append("WHERE ");
					isFirstCondition = false;
				}else {
					where_sql.append("AND ");
				}
				where_sql.append("`phone` LIKE :phone ");
			}
			
			if(isCityExist) {
				if(isFirstCondition) {
					where_sql.append("WHERE ");
					isFirstCondition = false;
				}else {
					where_sql.append("AND ");
				}
				where_sql.append("`city` LIKE :city ");
			}
			
			if(isCountryExist) {
				if(isFirstCondition) {
					where_sql.append("WHERE ");
					isFirstCondition = false;
				}else {
					where_sql.append("AND ");
				}
				where_sql.append("`country` LIKE :country ");
			}
			
			select_from_sql.append(where_sql);
			Query query = entityManager.createNativeQuery(select_from_sql.toString(),CustomerDetailsVO.class);
			if(isCustomerNameExist) {query.setParameter("customer_name", "%" + request.getCustomerName() + "%");}
			if(isContactLastNameExist) {query.setParameter("contact_last_name", "%" + request.getContactLastName() + "%");}
			if(isContactFirstNameExist) {query.setParameter("contact_first_name", "%" + request.getContactFirstName() + "%");}
			if(isPhoneExist) {query.setParameter("phone", "%" + request.getPhone() + "%");}
			if(isCityExist) {query.setParameter("city", "%" + request.getCity() + "%");}
			if(isCountryExist) {query.setParameter("country", "%" + request.getCountry() + "%");}
			
			list = query.getResultList();
			logger.info("getCustomerDetails count" + list.size());
			//todo
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
		
		logger.info("getCustomerDetails end");
		return list;
	}
}
