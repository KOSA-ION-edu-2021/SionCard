package kosa.ion.sion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosa.ion.sion.dto.CardsDto;
import kosa.ion.sion.dto.MembersDto;
import kosa.ion.sion.repository.MembersRepository;
import kosa.ion.sion.security.JwtProvider;

@RestController
@RequestMapping("/member")
@CrossOrigin("*")
public class MemberController {
	@Autowired
	JwtProvider jwtProvider;
	@Autowired
	MembersRepository membersRepository;
	
	
	@GetMapping("/test")
	public String Test() {
		return "success";
	}
	
	
	@GetMapping("/get_auth")
	public MembersDto GetAuth(@RequestHeader HashMap<String,String> header) {
		String[] token = header.get("authorization").split(" ");
		String member_id = jwtProvider.getUserNameFromJwtToken(token[0].equals("Bearer")?token[1]:"");
		MembersDto member = membersRepository.findByMemberId(member_id).orElseThrow(() -> new NoSuchElementException());
		member.setPassword(null);
		return member;
	}
	
	//@GetMapping("/memberinfo")
	//public MembersDto MemeberInfo(@RequestHeader HashMap<String,String> header) {
	//	String[] token = header.get("authorization").split(" ");
	//	String member_id = jwtProvider.getUserNameFromJwtToken(token[0].equals("Bearer")?token[1]:"");
	//	MembersDto member = membersRepository.findByMemberId(member_id).orElseThrow(() -> new NoSuchElementException());
	//	member.setPassword(null);
	//	return member;
	//}
	
	//@GetMapping("/memberinfo")
	//public List<MembersDto> MyInfo() {
	//	return membersRepository.findAll();
	//}
	
	
}