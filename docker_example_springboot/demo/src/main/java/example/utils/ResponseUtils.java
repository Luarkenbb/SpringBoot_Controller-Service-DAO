package example.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
	
public class ResponseUtils {
	private static final String PAYLOAD = "payload";
	private static final String STATUS = "status";
	private static final String CODE = "code";
	private static final String DATA = "data";
	private static final String MESSAGE = "msg";
	private static final String MESSAGE_OK = "ok";
	private static final String COUNT = "count";
	
	public static <T> ResponseEntity<Map<String, Object>> successSingleResult(Object obj){
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put(STATUS, Map.of(CODE, 0, MESSAGE, MESSAGE_OK));
		responseBody.put(PAYLOAD, Map.of(DATA, obj == null ? "" : obj));
		
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
	
	public static <T> ResponseEntity<Map<String, Object>> successListResult(List list){
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put(STATUS, Map.of(CODE, 0, MESSAGE, MESSAGE_OK));
		
		if(list != null && !list.isEmpty()) {
			responseBody.put(COUNT, list.size());
			responseBody.put(PAYLOAD, Map.of(DATA, list));
		}else {
			responseBody.put(COUNT, 0);
			responseBody.put(PAYLOAD, Map.of(DATA, "nodata"));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}

	public static <T> ResponseEntity<Map<String, Object>> errorResult(String message){
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put(STATUS, Map.of(CODE, 1, MESSAGE, message));
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
	}
}
