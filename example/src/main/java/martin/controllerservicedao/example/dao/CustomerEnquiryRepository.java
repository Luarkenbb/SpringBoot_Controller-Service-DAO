package martin.controllerservicedao.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
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
			
			HashMap<String, HashMap<String, Object>> where_sql_map = new HashMap<>();
			//CustomerName
			HashMap<String, Object> customerName_map = new HashMap<>();
			customerName_map.put("flag", StringUtils.isEmpty(request.getCustomerName()) ? true : false );
			customerName_map.put("column", "`customerName`");
			customerName_map.put("condition", " LIKE :customer_name ");
			customerName_map.put("param", "customer_name");
			customerName_map.put("value", request.getCustomerName());
			where_sql_map.put("customerName", customerName_map);
			//contactLastName
			HashMap<String, Object> contactLastName_map = new HashMap<>();
			contactLastName_map.put("flag", StringUtils.isEmpty(request.getContactLastName()) ? true : false);
			contactLastName_map.put("column", "`contactLastName`");
			contactLastName_map.put("condition", " LIKE :contact_last_name ");
			contactLastName_map.put("param", "contact_last_name");
			contactLastName_map.put("value", request.getContactLastName());
			where_sql_map.put("contactLastName", contactLastName_map);
			//contactFirstName
			HashMap<String, Object> contactFirstName_map = new HashMap<>();
			contactFirstName_map.put("flag", StringUtils.isEmpty(request.getContactFirstName()) ? true : false);
			contactFirstName_map.put("column", "`contactFirstName`");
			contactFirstName_map.put("condition", " LIKE :contact_first_name ");
			contactFirstName_map.put("param", "contact_first_name");
			contactFirstName_map.put("value", request.getContactFirstName());
			where_sql_map.put("contactFirstName", contactFirstName_map);
			//phone
			HashMap<String, Object> phone_map = new HashMap<>();
			phone_map.put("flag", StringUtils.isEmpty(request.getPhone()) ? true : false);
			phone_map.put("column", "`phone`");
			phone_map.put("condition", " LIKE :phone ");
			phone_map.put("param", "phone");
			phone_map.put("value", request.getPhone());
			where_sql_map.put("phone", phone_map);
			//city
			HashMap<String, Object> city_map = new HashMap<>();
			city_map.put("flag", StringUtils.isEmpty(request.getCity()) ? true : false);
			city_map.put("column", "`city`");
			city_map.put("condition", " LIKE :city ");
			city_map.put("param", "city");
			city_map.put("value", request.getCity());
			where_sql_map.put("city", city_map);
			//country
			HashMap<String, Object> country_map = new HashMap<>();
			country_map.put("flag", StringUtils.isEmpty(request.getCountry()) ? true : false);
			country_map.put("column", "`country`");
			country_map.put("condition", " LIKE :country ");
			country_map.put("param", "country");
			country_map.put("value", request.getCountry());
			where_sql_map.put("country", country_map);
			
			boolean isNullParam = true;
			
			for(String key : where_sql_map.keySet()) {
				HashMap<String, Object> key_map = where_sql_map.get(key);
				
				if((boolean)key_map.get("flag")) {
					isNullParam = false;
					
					if(isFirstCondition) {
						where_sql.append("WHERE ");
						isFirstCondition = false;
					}else {
						where_sql.append("AND ");
					}
					where_sql.append((String)key_map.get("column") + (String)key_map.get("condition"));
				}
			}
			
			if(!isNullParam) {
				select_from_sql.append(where_sql);
				Query query = entityManager.createNativeQuery(select_from_sql.toString(),CustomerDetailsVO.class);
			
				for(String key : where_sql_map.keySet()) {
					HashMap<String, Object> key_map = where_sql_map.get(key);
				
					if((boolean)key_map.get("flag")) {
						query.setParameter((String)key_map.get("param"), "%" + (String)key_map.get("value") + "%");
					}
				}
			
				list = query.getResultList();
				logger.info("getCustomerDetails count" + list.size());
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
		
		logger.info("getCustomerDetails end");
		return list;
	}
}
