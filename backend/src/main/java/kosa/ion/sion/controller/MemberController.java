
package kosa.ion.sion.controller;

import kosa.ion.sion.dto.MemberUseDto;
import kosa.ion.sion.dto.MembersCardDto;
import kosa.ion.sion.dto.MembersDto;
import kosa.ion.sion.repository.MemberUseRepository;
import kosa.ion.sion.repository.MembersCardRepository;
import kosa.ion.sion.repository.MembersRepository;
import kosa.ion.sion.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

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
		
		// 유효기간 설정 START	
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, 2);
		
		java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
		// 유효기간 설정 END
		
		// 카드번호 설정 START	16자리 번호 난수 생성
		Random num = new Random();
		StringBuffer cardNum = new StringBuffer();
		
		for(int i = 0; i < 16; i++) {
			int index = num.nextInt(10);
			System.out.println(index);
			cardNum.append(index);
		}
		// 카드번호 설정 END
		
		memberscard.setCardEdate(sqlDate);
		memberscard.setCardNum(String.valueOf(cardNum));
		
		return ResponseEntity.ok(membersCardRepository.save(memberscard));
	}
	
	//MemberUseRepository
	@Autowired
	MemberUseRepository memberUseRepository;
	
	//고객이 카드 사용한 정보 가져오기
	@GetMapping("/get_use_card")
	public List<MemberUseDto> getMembersUse(@RequestHeader HashMap<String,String> headers) {
		String[] token = headers.get("authorization").split(" ");
		String member_id = jwtProvider.getUserNameFromJwtToken(token[0].equals("Bearer")?token[1]:"");
		return memberUseRepository.findTop5ByMemberIdOrderByUseDateDesc(member_id);
	}
	
	//관리자 페이지 멤버 DB 전송
	@GetMapping("/member_info")
	public List<MembersDto> MemberdInfo() {
		return membersRepository.findAll();
	}


}