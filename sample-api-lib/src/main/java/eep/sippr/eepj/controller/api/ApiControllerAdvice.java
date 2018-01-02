package eep.sippr.eepj.controller.api;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@ControllerAdvice(basePackages="eep.sippr.eepj.controller.api")
public class ApiControllerAdvice {
	@ExceptionHandler
	public @ResponseBody JSONObject resolverException(Exception e) {
		JSONObject obj = new JSONObject();
		obj.put("code", 1);
		obj.put("message", e.getMessage());
		return obj;
	}
}
