package kosa.ion.sion.controller;

import kosa.ion.sion.dto.CardsDto;
import kosa.ion.sion.dto.MembersDto;
import kosa.ion.sion.repository.CardsRepository;
import kosa.ion.sion.repository.MembersRepository;
import kosa.ion.sion.security.JwtProvider;
import kosa.ion.sion.service.MailService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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
	
	@Autowired
	private MailService mailService;
	
	@GetMapping("/test")
	public String Test() {
		return "success";
	}
	
	//jwt 부분
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<Map<String,String>> login(@RequestBody Map<String,String> Auth) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(Auth.get("id"),Auth.get("password")));
		String jwt = jwtProvider.generateJwtToken(authentication);
		Auth.clear();
		Auth.put("jwt", jwt);
		return ResponseEntity.ok(Auth);
	}
	
	//회원가입 부분
	@PostMapping("/signup")
	@ResponseBody
	public ResponseEntity<MembersDto> signup(@RequestBody MembersDto member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		return ResponseEntity.ok(membersRepository.save(member));
	}
	
	

	@GetMapping("/id_check")
	public Boolean idCheck(@RequestParam String id) {
		return !membersRepository.existsByMemberId(id);
	}
	
	@PostMapping("/find_id")
	public String findId(@RequestBody MembersDto membersDto){
		try {
			membersDto= membersRepository.findByNameAndEmail(membersDto.getName(), membersDto.getEmail()).orElseThrow(()->new Exception());
			return "아이디는 ["+membersDto.getMemberId()+"]입니다.";
		}catch(Exception e){
		}
		return "올바른 정보를 입력해주세요.";
	}
	
	@PostMapping("/find_pw")
	@Transactional
	public String findPw(@RequestBody MembersDto membersDto) {
		try {
			membersDto= membersRepository.findByNameAndEmailAndMemberId(membersDto.getName(), membersDto.getEmail(),membersDto.getMemberId()).orElseThrow(()->new Exception());
			
			//임시 비밀번호 생성
			RandomString randomString = new RandomString();
			String pw=randomString.nextString();
			System.out.println(pw);
			
			
			mailService.sendMail(membersDto.getEmail(), "임시 비밀번호 안내", "임시 비밀번호는 "+pw+"입니다.");
			//임시 비밀번호 설정
			membersDto.setPassword(passwordEncoder.encode(pw));
			
			return "임시 비밀번호를 "+membersDto.getEmail()+"로 발송하였습니다.";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "올바른 정보르 입력해주세요.";
	}
	
	@Autowired
	CardsRepository cardsRepository;
	
	@GetMapping("/card_info")
	public List<CardsDto> CardInfo() {
		return cardsRepository.findAll();
	}
	
	// 카드 신청 부분에서 비밀번호 확인 용도
	@PostMapping("/pwd_check")
	public Boolean pwdCheck(@RequestBody Map<String, Object> param) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(param.get("id"), param.get("pwd")));
			System.out.println("인증성공");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("인증실패");
			return false;
		}
	}
	
	//관리자 페이지 멤버 DB 전송
	@GetMapping("/member_info")
	public List<MembersDto> MemberdInfo() {
		return membersRepository.findAll();
	}
	@GetMapping("/image/{imagename}")
	public ResponseEntity<Resource> getImage(@PathVariable("imagename") String imagename) throws IOException {
		String path = System.getProperty("user.home")+"/sion_images/"+imagename;
		Resource resource = new FileSystemResource(path);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", Files.probeContentType(Paths.get(path)));
		return new ResponseEntity<Resource>(resource,headers, HttpStatus.OK);
	}
}
