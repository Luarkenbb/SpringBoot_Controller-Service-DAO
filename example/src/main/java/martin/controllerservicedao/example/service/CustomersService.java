package martin.controllerservicedao.example.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import martin.controllerservicedao.example.dao.CustomersRepository;
import martin.controllerservicedao.example.model.request.CustomersPKRequest;
import martin.controllerservicedao.example.model.request.CustomersGetDetailsRequest;
import martin.controllerservicedao.example.model.response.CustomersDetailsBaseResponse;
import martin.controllerservicedao.example.model.vo.CustomersDetailsVO;

@Service
public class CustomersService {
	private static final Logger logger = LogManager.getLogger(CustomersService.class);
	
	private final CustomersRepository customerEnquiryRepository;
	
	@Autowired
	public CustomersService(CustomersRepository customerEnquiryRepository) {
		this.customerEnquiryRepository = customerEnquiryRepository;
	}
	
	public CustomersDetailsBaseResponse getCustomerDetailsByPK(CustomersPKRequest request) throws Exception{
		logger.info("getCustomerDetailsByPK start");
		CustomersDetailsBaseResponse response;
		
		CustomersDetailsVO vo = customerEnquiryRepository.getCustomerDetailsByPK(request);
		if(vo != null) {
			response = new CustomersDetailsBaseResponse(vo);
		}else {
			response = null;
		}
			
		logger.info("getCustomerDetailsByPK end");
		return response;
	}
	
	public List<CustomersDetailsBaseResponse> getCustomerDetails(CustomersGetDetailsRequest request) throws Exception{
		logger.info("getCustomerDetails start");
		
		List<CustomersDetailsBaseResponse> response_list = new ArrayList<CustomersDetailsBaseResponse>();
		List<CustomersDetailsVO> vo_list = customerEnquiryRepository.getCustomerDetails(request);
		if(vo_list != null) {
			for(CustomersDetailsVO vo : vo_list) {
				CustomersDetailsBaseResponse response = new CustomersDetailsBaseResponse(vo);
				response_list.add(response);
			}
		}
		
		logger.info("getCustomerDetails end");
		return response_list;
	}
}
