package martin.controllerservicedao.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import martin.controllerservicedao.example.model.request.CustomersPKRequest;
import martin.controllerservicedao.example.model.request.CustomersGetDetailsRequest;
import martin.controllerservicedao.example.model.vo.CustomersDetailsVO;

@Repository
public class CustomersRepository {
	private static final Logger logger = LogManager.getLogger(CustomersRepository.class);
	
	@Autowired
	private EntityManager entityManager;
	
	public CustomersDetailsVO getCustomerDetailsByPK(CustomersPKRequest request) {
		logger.info("getCustomerDetailsByPK start");
		CustomersDetailsVO vo = new CustomersDetailsVO();
		
		List<CustomersDetailsVO> list = new ArrayList();
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
			Query query = entityManager.createNativeQuery(sql.toString(),CustomersDetailsVO.class);
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
	
	
	public List<CustomersDetailsVO> getCustomerDetails(CustomersGetDetailsRequest request) {
		logger.info("getCustomerDetails start");
		List<CustomersDetailsVO> list = new ArrayList();
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
			
			Map<String, Map<String, Object>> where_sql_map = new HashMap<String, Map<String, Object>>();
			
			//CustomerName
			Map<String, Object> customerName_map = new HashMap<String, Object>();
			customerName_map.put("flag", StringUtils.isEmpty(request.getCustomerName()) ? false : true );
			customerName_map.put("column", "`customerName`");
			customerName_map.put("condition", " LIKE :customer_name ");
			customerName_map.put("param", "customer_name");
			customerName_map.put("value", request.getCustomerName());
			where_sql_map.put("customerName", customerName_map);
			//contactLastName
			Map<String, Object> contactLastName_map = new HashMap<String, Object>();
			contactLastName_map.put("flag", StringUtils.isEmpty(request.getContactLastName()) ? false : true );
			contactLastName_map.put("column", "`contactLastName`");
			contactLastName_map.put("condition", " LIKE :contact_last_name ");
			contactLastName_map.put("param", "contact_last_name");
			contactLastName_map.put("value", request.getContactLastName());
			where_sql_map.put("contactLastName", contactLastName_map);
			//contactFirstName
			Map<String, Object> contactFirstName_map = new HashMap<String, Object>();
			contactFirstName_map.put("flag", StringUtils.isEmpty(request.getContactFirstName()) ? false : true );
			contactFirstName_map.put("column", "`contactFirstName`");
			contactFirstName_map.put("condition", " LIKE :contact_first_name ");
			contactFirstName_map.put("param", "contact_first_name");
			contactFirstName_map.put("value", request.getContactFirstName());
			where_sql_map.put("contactFirstName", contactFirstName_map);
			//phone
			Map<String, Object> phone_map = new HashMap<String, Object>();
			phone_map.put("flag", StringUtils.isEmpty(request.getPhone()) ? false : true );
			phone_map.put("column", "`phone`");
			phone_map.put("condition", " LIKE :phone ");
			phone_map.put("param", "phone");
			phone_map.put("value", request.getPhone());
			where_sql_map.put("phone", phone_map);
			//city
			Map<String, Object> city_map = new HashMap<String, Object>();
			city_map.put("flag", StringUtils.isEmpty(request.getCity()) ? false : true );
			city_map.put("column", "`city`");
			city_map.put("condition", " LIKE :city ");
			city_map.put("param", "city");
			city_map.put("value", request.getCity());
			where_sql_map.put("city", city_map);
			//country
			Map<String, Object> country_map = new HashMap<String, Object>();
			country_map.put("flag", StringUtils.isEmpty(request.getCountry()) ? false : true );
			country_map.put("column", "`country`");
			country_map.put("condition", " LIKE :country ");
			country_map.put("param", "country");
			country_map.put("value", request.getCountry());
			where_sql_map.put("country", country_map);
			
			boolean isNullParam = true;
			
			for(String key : where_sql_map.keySet()) {
				Map<String, Object> key_map = where_sql_map.get(key);
				
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
				Query query = entityManager.createNativeQuery(select_from_sql.toString(),CustomersDetailsVO.class);
			
				for(String key : where_sql_map.keySet()) {
					Map<String, Object> key_map = where_sql_map.get(key);
				
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
