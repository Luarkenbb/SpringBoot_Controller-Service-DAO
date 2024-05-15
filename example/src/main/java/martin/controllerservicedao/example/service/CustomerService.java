package martin.controllerservicedao.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import martin.controllerservicedao.example.dao.CustomerEnquiryRepository;
import martin.controllerservicedao.example.model.request.CustomerGetCustomerDetailRequest;
import martin.controllerservicedao.example.model.response.CustomerGetCustomerDetailResponse;
import martin.controllerservicedao.example.model.vo.CustomerDetailVO;

@Service
public class CustomerService {
	private static final Logger logger = LogManager.getLogger(CustomerService.class);
	
	private final CustomerEnquiryRepository customerEnquiryRepository;
	
	public CustomerService(CustomerEnquiryRepository customerEnquiryRepository) {
		this.customerEnquiryRepository = customerEnquiryRepository;
	}
	
	public CustomerGetCustomerDetailResponse getCustomerDetails(CustomerGetCustomerDetailRequest request) throws Exception{
		logger.info("start");
		CustomerGetCustomerDetailResponse response;
		
		try {
			CustomerDetailVO vo = customerEnquiryRepository.getCustomerDetail(request);
			
			if(vo != null) {
				response = new CustomerGetCustomerDetailResponse();
				
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
		
		logger.info("end");
		return response;
	}
}
