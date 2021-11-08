package kosa.ion.sion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kosa.ion.sion.dto.CardsDto;
import kosa.ion.sion.dto.MembersDto;
import kosa.ion.sion.repository.CardsRepository;
import kosa.ion.sion.repository.MembersRepository;
import kosa.ion.sion.security.JwtProvider;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ApiController {
	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	@Autowired
	private MembersRepository membersRepository;
	
	
	@GetMapping("/test")
	public String Test() {
		return "success";
	}
	//jwt 부분
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<HashMap<String, String>> login(HttpServletResponse response, @RequestBody HashMap<String,String> auth) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(auth.get("id"),auth.get("password")));
		auth.put("jwt",jwtProvider.generateJwtToken(authentication));
		auth.remove("password");
		auth.remove("id");
		return ResponseEntity.ok(auth);
	}
	
	//회원가입 부분
	@PostMapping("/signup")
	@ResponseBody
	public ResponseEntity<MembersDto> signup(HttpServletResponse response, @RequestBody MembersDto member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		return ResponseEntity.ok(membersRepository.save(member));
	}

	@GetMapping("/id_check")
	public Boolean idCheck(@RequestParam String id) {
		try {
			membersRepository.findByMemberId(id).orElseThrow(() -> new NoSuchElementException());
			return false;
		}
		catch(Exception e){
			//아이디가 존재하지 않으므로 사용가능함.
			return true;	
		}
	}
	
	
	@Autowired
	CardsRepository cardsRepository;
	
	@GetMapping("/card_info")
	public List<CardsDto> CardInfo() {
		return cardsRepository.findAll();
	}
}
