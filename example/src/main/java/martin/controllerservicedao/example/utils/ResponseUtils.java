package martin.controllerservicedao.example.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {
	public static <T> ResponseEntity<Map<String, Object>> successSingleResult(Object obj){
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("status", Map.of("code", 0, "msg", "ok"));
		responseBody.put("payload", Map.of("data",obj == null ? "" : obj));
		
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
	
	public static <T> ResponseEntity<Map<String, Object>> successListResult(List list){
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("status", Map.of("code", 0, "msg", "ok"));
		if(list.size() != 0 && list != null) {
			responseBody.put("payload", Map.of("data", list));
		}else {
			responseBody.put("payload", Map.of("data", null));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
}
