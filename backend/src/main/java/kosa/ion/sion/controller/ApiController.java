package kosa.ion.sion.controller;

import kosa.ion.sion.dto.CardsDto;
import kosa.ion.sion.dto.MembersDto;
import kosa.ion.sion.repository.CardsRepository;
import kosa.ion.sion.repository.FileTestRepository;
import kosa.ion.sion.repository.MembersRepository;
import kosa.ion.sion.security.JwtProvider;
import kosa.ion.sion.service.MailService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

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
		System.out.println("success");
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

	@Autowired
	FileTestRepository fileTestRepository;
	@PostMapping("/file_up")
	public ResponseEntity<Boolean> fileUp(@RequestParam(name="files") List<MultipartFile> files) throws IOException {
		System.out.println(files.toArray()+"");
		for(MultipartFile file : files){
			if(file.isEmpty()) continue;
			File newFile = new File("images/"+file.getOriginalFilename());
			file.transferTo(newFile);

		}
		return ResponseEntity.ok(true);
	}
}
