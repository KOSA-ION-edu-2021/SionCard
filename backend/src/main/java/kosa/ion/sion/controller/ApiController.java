package kosa.ion.sion.controller;

import kosa.ion.sion.dto.CardsDto;
import kosa.ion.sion.dto.MembersDto;
import kosa.ion.sion.getter.SumUseGetter;
import kosa.ion.sion.repository.CardsRepository;
import kosa.ion.sion.repository.MemberUseRepository;
import kosa.ion.sion.repository.MembersRepository;
import kosa.ion.sion.security.JwtProvider;
import kosa.ion.sion.service.MailService;
import kosa.ion.sion.vo.SEDateVo;
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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

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
	
	@Autowired
	MemberUseRepository memberUseRepository;
	

	@GetMapping("/test")
	@ResponseBody
	public List<SumUseGetter> sumUse(@RequestHeader Map<String,String> headers, SEDateVo seDateVo) {
//		String[] token = headers.get("authorization").split(" ");
//		String member_id = jwtProvider.getUserNameFromJwtToken(token[1]);
		String member_id = "admin";
		return memberUseRepository.sumUseByMemberId(member_id,seDateVo.getStartDate(), seDateVo.getEndDate());
	}
	//jwt ??????
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
	
	//???????????? ??????
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
			return "???????????? ["+membersDto.getMemberId()+"]?????????.";
		}catch(Exception e){
		}
		return "????????? ????????? ??????????????????.";
	}
	
	@PostMapping("/find_pw")
	@Transactional
	public String findPw(@RequestBody MembersDto membersDto) {
		try {
			membersDto= membersRepository.findByNameAndEmailAndMemberId(membersDto.getName(), membersDto.getEmail(),membersDto.getMemberId()).orElseThrow(()->new Exception());
			
			//?????? ???????????? ??????
			RandomString randomString = new RandomString();
			String pw=randomString.nextString();
			mailService.sendMail(membersDto.getEmail(), "?????? ???????????? ??????", "?????? ??????????????? "+pw+"?????????.");
			//?????? ???????????? ??????
			membersDto.setPassword(passwordEncoder.encode(pw));
			
			return "?????? ??????????????? "+membersDto.getEmail()+"??? ?????????????????????.";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "????????? ????????? ??????????????????.";
	}
	
	@Autowired
	CardsRepository cardsRepository;
	
	@GetMapping("/card_info")
	public List<CardsDto> CardInfo() {
		return cardsRepository.findAll();
	}
	
	// ?????? ?????? ???????????? ???????????? ?????? ??????
	@PostMapping("/pwd_check")
	public Boolean pwdCheck(@RequestBody Map<String, Object> param) {
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
	
	//????????? ????????? ?????? DB ??????
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
