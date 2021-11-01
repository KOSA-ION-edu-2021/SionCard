package kosa.ion.sion.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kosa.ion.sion.security.JwtProvider;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ApiController {
	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/test")
	public String Test() {
		return "success";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<String> login(HttpServletResponse response, @RequestBody String id, @RequestBody String password) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(id, password));
		String jwt = jwtProvider.generateJwtToken(authentication); 
		 
		return ResponseEntity.ok(jwt);
	}

}
