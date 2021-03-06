
package kosa.ion.sion.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import kosa.ion.sion.dto.CardsDto;
import kosa.ion.sion.dto.MemberUseDto;
import kosa.ion.sion.dto.MembersCardDto;
import kosa.ion.sion.dto.MembersDto;
import kosa.ion.sion.getter.SumUseGetter;
import kosa.ion.sion.repository.CardsRepository;
import kosa.ion.sion.repository.MemberUseRepository;
import kosa.ion.sion.repository.MembersCardRepository;
import kosa.ion.sion.repository.MembersRepository;
import kosa.ion.sion.security.JwtProvider;
import kosa.ion.sion.service.MailService;
import kosa.ion.sion.vo.AuthVo;

import net.bytebuddy.utility.RandomString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.*;
import kosa.ion.sion.vo.MembersCardVo;

@RestController
@RequestMapping("/member")
@CrossOrigin("*")
public class MemberController {
	@Autowired
	JwtProvider jwtProvider;
	@Autowired
	MembersRepository membersRepository;
	@Autowired
	CardsRepository cardsRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MailService mailService;
	
	private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

	@GetMapping("/test")
	public String Test() {
		return "success";
	}

	//jwt ??????
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


	@DeleteMapping("/members")
	public Boolean deleteMember(@RequestHeader HashMap<String,String> headers) {
		try {
			String[] token = headers.get("authorization").split(" ");
			String member_id = jwtProvider.getUserNameFromJwtToken(token[1]);

			MembersDto member = membersRepository.findByMemberId(member_id).orElseThrow(() -> new ResourceNotFoundException());

			String memberId = headers.get("id");
			String email = headers.get("email");
			String pw = headers.get("password");
			if (!(member.getMemberId().equals(memberId) &&
					member.getEmail().equals(email) &&
					passwordEncoder.matches(pw, member.getPassword())
			))
				return false;
			membersRepository.delete(member);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//MembersCardRepository
	@Autowired
	MembersCardRepository membersCardRepository;
	
	//????????? ?????? ?????? ????????????
	@GetMapping("/get_card")
	public List<MembersCardVo> MembersCard(@RequestHeader HashMap<String,String> headers) {
		String[] token = headers.get("authorization").split(" ");
		String member_id = jwtProvider.getUserNameFromJwtToken(token[0].equals("Bearer")?token[1]:"");
		
		List<MembersCardDto> membersCardDtoList = membersCardRepository.findByMemberId(member_id);
		
		List<MembersCardVo> result = new ArrayList<MembersCardVo>();
		
		for(MembersCardDto membersCardDto : membersCardDtoList) {
			System.out.println(membersCardDto.getCardId());
			CardsDto cardsDto = cardsRepository.findById(new Long(membersCardDto.getCardId())).orElseThrow(()->new NoSuchElementException());
			result.add(MembersCardVo.builder()
					.id(new Long(membersCardDto.getCardId()))
					.cardId(membersCardDto.getCardId())
					.cardEdate(membersCardDto.getCardEdate())
					.memberId(membersCardDto.getMemberId())
					.cardNum(membersCardDto.getCardNum())
					.cardTitle(membersCardDto.getCardTitle())
					.img(cardsDto.getImg())
					.build()
					);
		}
		return result;
	}
	
	@PostMapping("/get_members_card")
	public List<MembersCardDto> getMembersCard(@RequestBody Map<String, Object> param) {
		return membersCardRepository.findAll();
	}
	
	//?????? ?????? ??????
	@PostMapping("/application")
	@ResponseBody
	public ResponseEntity<MembersCardDto> application( @RequestBody MembersCardDto memberscard) {
		
		// ???????????? ?????? START	
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, 2);
		
		java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
		// ???????????? ?????? END
		
		// ???????????? ?????? START	16?????? ?????? ?????? ??????
		Random num = new Random();
		StringBuffer cardNum = new StringBuffer();
		
		for(int i = 0; i < 16; i++) {
			int index = num.nextInt(10);
			System.out.println(index);
			cardNum.append(index);
		}
		// ???????????? ?????? END
		
		memberscard.setCardEdate(sqlDate);
		memberscard.setCardNum(String.valueOf(cardNum));
		
		return ResponseEntity.ok(membersCardRepository.save(memberscard));
	}
	
	//MemberUseRepository
	@Autowired
	MemberUseRepository memberUseRepository;
	
	//????????? ?????? ????????? ?????? ????????????
	@GetMapping("/get_use_card")
	public List<MemberUseDto> getMembersUse(@RequestHeader HashMap<String,String> headers) {
		String[] token = headers.get("authorization").split(" ");
		String member_id = jwtProvider.getUserNameFromJwtToken(token[0].equals("Bearer")?token[1]:"");
		return memberUseRepository.findTop5ByMemberIdOrderByUseDateDesc(member_id);
	}
	
	//????????? ????????? ?????? DB ??????
	@GetMapping("/member_info")
	public List<MembersDto> MemberdInfo() {
		return membersRepository.findAll();
	}
	
	// My ?????? ??????
	// ID ?????? ?????? ( ?????? ??????)
	@PostMapping("/pwd_check")
	public Boolean pwdCheck(@RequestBody Map<String, String> param) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(param.get("id"), param.get("pwd")));
			System.out.println("????????????");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("????????????");
			return false;
		}
	}
	
	// ????????? ?????? ??????
	@PostMapping("/checkpassword")
	public Boolean CheckPassword(@RequestHeader HashMap<String,String> headers,@RequestBody HashMap<String,String> param) {
		try {
			String[] token = headers.get("authorization").split(" ");
			String member_id = jwtProvider.getUserNameFromJwtToken(token[1]);

			MembersDto member = membersRepository.findByMemberId(member_id).orElseThrow(() -> new ResourceNotFoundException());
			
			String pw = headers.get("password");
			if (passwordEncoder.matches(pw, member.getPassword())) {
				System.out.println("????????????");
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("????????????");
		return false;
	}
	// ???????????? ??????
	@PostMapping("/changepw")
	public MembersDto changepw(@RequestHeader HashMap<String,String> headers,@RequestBody HashMap<String,String> param){

			String[] token = headers.get("authorization").split(" ");
			String member_id = jwtProvider.getUserNameFromJwtToken(token[1]);

			MembersDto member = membersRepository.findByMemberId(member_id).orElseThrow(() -> new ResourceNotFoundException());
			
				String pw = param.get("password");
				member.setPassword(passwordEncoder.encode(pw));
				MembersDto changeinfo = membersRepository.save(member);
				return changeinfo;
			}
		
	
	// ????????? ??????
	@PutMapping("/member_info/email/{memberId}")
	public MembersDto changeemail(@PathVariable(value = "memberId") String memberId,@Valid @RequestBody MembersDto membersDto){
				
			MembersDto member = membersRepository.findByMemberId(memberId).orElseThrow(()->	new ResourceNotFoundException());
			member.setEmail(membersDto.getEmail());
			MembersDto changeinfo = membersRepository.save(member);
			return changeinfo;	
		}
	// ?????? ??????
	@PutMapping("/member_info/address/{memberId}")
	public MembersDto changeaddress(@PathVariable(value = "memberId") String memberId,@Valid @RequestBody MembersDto membersDto){
						
			MembersDto member = membersRepository.findByMemberId(memberId).orElseThrow(()->	new ResourceNotFoundException());
			member.setAddress(membersDto.getAddress());
			MembersDto changeinfo = membersRepository.save(member);
			return changeinfo;	
		}
	// ???????????? ??????
	@PutMapping("/member_info/phone/{memberId}")
	public MembersDto changephone(@PathVariable(value = "memberId") String memberId,@Valid @RequestBody MembersDto membersDto){
							
			MembersDto member = membersRepository.findByMemberId(memberId).orElseThrow(()->	new ResourceNotFoundException());
			member.setPhone(membersDto.getPhone());
			MembersDto changeinfo = membersRepository.save(member);
			return changeinfo;	
		}
	// ?????? ??????
	@PutMapping("/member_info/birth/{memberId}")
	public MembersDto changebirth(@PathVariable(value = "memberId") String memberId,@Valid @RequestBody MembersDto membersDto){
			
		MembersDto member = membersRepository.findByMemberId(memberId).orElseThrow(()->	new ResourceNotFoundException());
			member.setBirth(membersDto.getBirth());
			MembersDto changeinfo = membersRepository.save(member);
			return changeinfo;	
		}
	@GetMapping("/sum_use")
	public List<SumUseGetter> sumUse(@RequestHeader Map<String,String> headers) {
		String[] token = headers.get("authorization").split(" ");
		String member_id = jwtProvider.getUserNameFromJwtToken(token[1]);
		return memberUseRepository.sumUseByMemberId(member_id);
	}
	@GetMapping("/sum_use1")
	public List<SumUseGetter> sumUse(@RequestHeader Map<String,String> headers,@RequestParam LocalDateTime start_date, LocalDateTime end_date) {
		String[] token = headers.get("authorization").split(" ");
		String member_id = jwtProvider.getUserNameFromJwtToken(token[1]);
		return memberUseRepository.sumUseByMemberId(member_id,start_date, end_date);
	}

}