package example.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.dao.OfficesRepository;
import example.model.entity.Offices;
import example.model.request.OfficesPKRequest;
import example.model.response.OfficesBaseResponse;
@Service
public class OfficesService {
	private static final Logger logger = LogManager.getLogger(OfficesService.class);
	
	private final OfficesRepository officesRepository;
	
	@Autowired
	public OfficesService(OfficesRepository officesRepository) {
		this.officesRepository = officesRepository;
	}
	
	public OfficesBaseResponse getOfficeByPK(OfficesPKRequest request){
		logger.info("Start");
		Optional<Offices> office = officesRepository.findById(request.getOfficeCode());
		if(office.isEmpty()) {
			return new OfficesBaseResponse();
		}
		
		return new OfficesBaseResponse(office.get());
	}
	
}
