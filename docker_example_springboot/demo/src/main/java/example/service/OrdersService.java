package example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import example.dao.OrdersRepository;

@Service
public class OrdersService {
	private static final Logger logger = LogManager.getLogger(OrdersService.class);
	
	private final OrdersRepository ordersRepository;
	
	public OrdersService(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}
}
