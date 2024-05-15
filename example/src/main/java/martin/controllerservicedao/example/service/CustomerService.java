package martin.controllerservicedao.example.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import martin.controllerservicedao.example.dao.CustomerEnquiryRepository;
import martin.controllerservicedao.example.model.request.CustomerGetDetailsByPKRequest;
import martin.controllerservicedao.example.model.request.CustomerGetDetailsRequest;
import martin.controllerservicedao.example.model.response.CustomerDetailsBaseResponse;
import martin.controllerservicedao.example.model.vo.CustomerDetailsVO;

@Service
public class CustomerService {
	private static final Logger logger = LogManager.getLogger(CustomerService.class);
	
	private final CustomerEnquiryRepository customerEnquiryRepository;
	
	@Autowired
	public CustomerService(CustomerEnquiryRepository customerEnquiryRepository) {
		this.customerEnquiryRepository = customerEnquiryRepository;
	}
	
	public CustomerDetailsBaseResponse getCustomerDetailsByPK(CustomerGetDetailsByPKRequest request) throws Exception{
		logger.info("getCustomerDetailsByPK start");
		CustomerDetailsBaseResponse response;
		
		try {
			CustomerDetailsVO vo = customerEnquiryRepository.getCustomerDetailsByPK(request);
			if(vo != null) {
				response = new CustomerDetailsBaseResponse();
				
				response.setAddressLine1(vo.getAddressLine1());
				response.setAddressLine2(vo.getAddressLine2());
				response.setCity(vo.getCity());
				response.setContactFirstName(vo.getContactFirstName());
				response.setContactLastName(vo.getContactLastName());
				response.setCountry(vo.getCountry());
				response.setCreditLimit(vo.getCreditLimit());
				response.setCustomerName(vo.getCustomerName());
				response.setCustomerNumber(vo.getCustomerNumber());
				response.setPhone(vo.getPhone());
				response.setPostalCode(vo.getPostalCode());
				response.setSalesRepEmployeeNumber(vo.getSalesRepEmployeeNumber());
				response.setState(vo.getState());
			}else {
				response = null;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw e;
		}
		
		logger.info("getCustomerDetailsByPK end");
		return response;
	}
	
	public List<CustomerDetailsBaseResponse> getCustomerDetails(CustomerGetDetailsRequest request) throws Exception{
		logger.info("getCustomerDetails start");
		List<CustomerDetailsBaseResponse> response_list = new ArrayList<CustomerDetailsBaseResponse>();
		CustomerDetailsBaseResponse response;
		try {
			List<CustomerDetailsVO> vo_list = customerEnquiryRepository.getCustomerDetails(request);
			if(vo_list != null && vo_list.size() != 0) {
				for(CustomerDetailsVO vo : vo_list) {
					response = new CustomerDetailsBaseResponse();
					
					response.setAddressLine1(vo.getAddressLine1());
					response.setAddressLine2(vo.getAddressLine2());
					response.setCity(vo.getCity());
					response.setContactFirstName(vo.getContactFirstName());
					response.setContactLastName(vo.getContactLastName());
					response.setCountry(vo.getCountry());
					response.setCreditLimit(vo.getCreditLimit());
					response.setCustomerName(vo.getCustomerName());
					response.setCustomerNumber(vo.getCustomerNumber());
					response.setPhone(vo.getPhone());
					response.setPostalCode(vo.getPostalCode());
					response.setSalesRepEmployeeNumber(vo.getSalesRepEmployeeNumber());
					response.setState(vo.getState());
					
					response_list.add(response);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw e;
		}
		
		logger.info("getCustomerDetails end");
		return response_list;
	}
}
