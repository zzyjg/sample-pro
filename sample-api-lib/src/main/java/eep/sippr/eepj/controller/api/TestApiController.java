package eep.sippr.eepj.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eep.sippr.eepj.entity.User;

@RestController
public class TestApiController {
	
	@RequestMapping("/user")
	public User getUser() {
		User user = new User();
		user.setId(1);
		user.setName("YJG");
		return user;
	}
	
	@RequestMapping("/userx")
	public User getUserx(@RequestParam("id") int id) throws Exception {
		User userx = new User();
		userx.setId(1);
		userx.setName("YJG");
		
		if(id==1) {
			throw new Exception("Exception showing ... ");
		}else if(id==2) {
			return null;
		}
		
		return userx;
	}
}
