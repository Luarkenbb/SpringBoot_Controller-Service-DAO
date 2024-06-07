package martin.controllerservicedao.example.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import martin.controllerservicedao.example.dao.OfficesRepository;
import martin.controllerservicedao.example.model.entity.Offices;
import martin.controllerservicedao.example.model.request.OfficesGetOfficeByPKRequest;
import martin.controllerservicedao.example.model.response.OfficesDetailsBaseResponse;
@Service
public class OfficesService {
	private static final Logger logger = LogManager.getLogger(OfficesService.class);
	
	private final OfficesRepository officesRepository;
	
	@Autowired
	public OfficesService(OfficesRepository officesRepository) {
		this.officesRepository = officesRepository;
	}
	
	public OfficesDetailsBaseResponse getOfficeByPK(OfficesGetOfficeByPKRequest request){
		logger.info("Start");
		Optional<Offices> office = officesRepository.findById(request.getOfficeCode());
		if(office.isEmpty()) {
			return new OfficesDetailsBaseResponse();
		}
		
		return new OfficesDetailsBaseResponse(office.get());
	}
	
}
