
package kosa.ion.sion.controller;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kosa.ion.sion.dto.MemberUseDto;
import kosa.ion.sion.dto.MembersCardDto;
import kosa.ion.sion.dto.MembersDto;
import kosa.ion.sion.getter.SumUseGetter;
import kosa.ion.sion.repository.MemberUseRepository;
import kosa.ion.sion.repository.MembersCardRepository;
import kosa.ion.sion.repository.MembersRepository;
import kosa.ion.sion.security.JwtProvider;
import kosa.ion.sion.vo.AuthVo;

@RestController
@RequestMapping("/member")
@CrossOrigin("*")
public class MemberController {
	@Autowired
	JwtProvider jwtProvider;
	@Autowired
	MembersRepository membersRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/test")
	public String Test() {
		return "success";
	}

	//jwt 부분
	@GetMapping("/refresh_jwt")
	public ResponseEntity<Map<String,String>> refreshJwt(@RequestHeader HashMap<String,String> headers) {
		String[] token = headers.get("authorization").split(" ");
		String jwt = jwtProvider.getRefreshJwtToken(token[1]);
		headers.clear();
		headers.put("jwt", jwt);
		return ResponseEntity.ok(headers);
	}
	
	@GetMapping("/get_auth")
	public AuthVo GetAuth(@RequestHeader HashMap<String,String> headers) {
		String[] token = headers.get("authorization").split(" ");
		String member_id = jwtProvider.getUserNameFromJwtToken(token[1]);
		MembersDto member = membersRepository.findByMemberId(member_id).orElseThrow(() -> new NoSuchElementException());
		
		return AuthVo.builder()
				.name(member.getName())
				.memberId(member.getMemberId())
				.address(member.getAddress())
				.birth(member.getBirth())
				.email(member.getEmail())
				.phone(member.getPhone())
				.expire(jwtProvider.getExpirationaFromJwtToken(token[1]))
				.build();
	}

	@DeleteMapping("/members/{memberId}")
	public Boolean deleteMember(@PathVariable String memberId) {
		if(!membersRepository.existsByMemberId(memberId)) return false;
		membersRepository.deleteByMemberId(memberId);
		return true;
	}

	@DeleteMapping("/members")
	public Boolean deleteMember2(@RequestHeader HashMap<String,String> headers) {
		String[] token = headers.get("authorization").split(" ");
		String member_id = jwtProvider.getUserNameFromJwtToken(token[1]);
		if(!membersRepository.existsByMemberId(member_id)) return false;
		return true;
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
	public ResponseEntity<MembersCardDto> application( @RequestBody MembersCardDto memberscard) {
		
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
	
	// My 정보 변경
	// 이메일 변경
	@PutMapping("/member_info/email/{memberId}")
	@Transactional
	public MembersDto changeemail(@PathVariable(value = "memberId") String memberId,@Valid @RequestBody MembersDto membersDto){
				
			MembersDto member = membersRepository.findByMemberId(memberId).orElseThrow(()->	new ResourceNotFoundException());
			member.setEmail(membersDto.getEmail());
			MembersDto changeinfo = membersRepository.save(member);
			return changeinfo;	
		}
	// 주소 변경
	@PutMapping("/member_info/address/{memberId}")
	@Transactional
	public MembersDto changeaddress(@PathVariable(value = "memberId") String memberId,@Valid @RequestBody MembersDto membersDto){
						
			MembersDto member = membersRepository.findByMemberId(memberId).orElseThrow(()->	new ResourceNotFoundException());
			member.setAddress(membersDto.getAddress());

			MembersDto changeinfo = membersRepository.save(member);
			return changeinfo;	
		}
	// 전화번호 변경
	@PutMapping("/member_info/phone/{memberId}")
	@Transactional
	public MembersDto changephone(@PathVariable(value = "memberId") String memberId,@Valid @RequestBody MembersDto membersDto){
							
			MembersDto member = membersRepository.findByMemberId(memberId).orElseThrow(()->	new ResourceNotFoundException());
			member.setPhone(membersDto.getPhone());

			MembersDto changeinfo = membersRepository.save(member);
			return changeinfo;	
		}
	// 생일 변경
	@PutMapping("/member_info/birth/{memberId}")
	@Transactional
	public MembersDto changebirth(@PathVariable(value = "memberId") String memberId,@Valid @RequestBody MembersDto membersDto){
			
		MembersDto member = membersRepository.findByMemberId(memberId).orElseThrow(()->	new ResourceNotFoundException());
			member.setBirth(membersDto.getBirth());
			
			MembersDto changeinfo = membersRepository.save(member);
			return changeinfo;	
		}
	@GetMapping("/sum_use")
	public List<SumUseGetter> sumUse(@RequestHeader Map<String,String> headers,@RequestParam LocalDateTime start_date, LocalDateTime end_date) {
		String[] token = headers.get("authorization").split(" ");
		String member_id = jwtProvider.getUserNameFromJwtToken(token[1]);
		return memberUseRepository.sumUseByMemberId(member_id,start_date, end_date);
	}

}