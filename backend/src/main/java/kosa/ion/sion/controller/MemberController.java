
package kosa.ion.sion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kosa.ion.sion.dto.CardsDto;
import kosa.ion.sion.dto.MemberUseDto;
import kosa.ion.sion.dto.MembersCardDto;
import kosa.ion.sion.dto.MembersDto;
import kosa.ion.sion.repository.MemberUseRepository;
import kosa.ion.sion.repository.MembersCardRepository;
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
	
	
	//MembersCardRepository
	@Autowired
	MembersCardRepository membersCardRepository;
	
	//멤버별 카드 정보 가져오기
	@PostMapping("/get_members_card")
	public List<MembersCardDto> getMembersCard(@RequestBody Map<String, Object> param) {
		return membersCardRepository.findAll();
	}
	
	//카드 신청 부분
	@PostMapping("/application")
	@ResponseBody
	public ResponseEntity<MembersCardDto> application(HttpServletResponse response, @RequestBody MembersCardDto memberscard) {
		return ResponseEntity.ok(membersCardRepository.save(memberscard));
	}
	
	//MemberUseRepository
	@Autowired
	MemberUseRepository memberUseRepository;
	
	//고객이 카드 사용한 정보 가져오기
	@PostMapping("/get_use_card")
	public List<MemberUseDto> getMembersUse(@RequestBody Map<String, Object> param) {
		return memberUseRepository.findAll();
	}
	
}