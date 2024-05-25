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
		
		CustomerDetailsVO vo = customerEnquiryRepository.getCustomerDetailsByPK(request);
		if(vo != null) {
			response = new CustomerDetailsBaseResponse(vo);
		}else {
			response = null;
		}
			
		logger.info("getCustomerDetailsByPK end");
		return response;
	}
	
	public List<CustomerDetailsBaseResponse> getCustomerDetails(CustomerGetDetailsRequest request) throws Exception{
		logger.info("getCustomerDetails start");
		
		List<CustomerDetailsBaseResponse> response_list = new ArrayList<CustomerDetailsBaseResponse>();
		List<CustomerDetailsVO> vo_list = customerEnquiryRepository.getCustomerDetails(request);
		if(vo_list != null) {
			for(CustomerDetailsVO vo : vo_list) {
				CustomerDetailsBaseResponse response = new CustomerDetailsBaseResponse(vo);
				response_list.add(response);
			}
		}
		
		logger.info("getCustomerDetails end");
		return response_list;
	}
}
