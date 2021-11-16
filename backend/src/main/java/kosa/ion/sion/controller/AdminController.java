package kosa.ion.sion.controller;

import kosa.ion.sion.dto.CardsDto;
import kosa.ion.sion.repository.CardsRepository;
import kosa.ion.sion.vo.CardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController{
	@Autowired
	CardsRepository cardsRepository;

	@GetMapping("/test")
	public String Test() {
		return "success";
	}
	//가정 : formdata로 받으면 Body가 아니라 pram으로 받아야 한다?
	@PostMapping("/create_card")
	public ResponseEntity<Boolean> createCard(@RequestParam CardVo cardVo) {
		UUID.randomUUID();
		cardVo.getImg();
		return ResponseEntity.ok(false);
	}
	
	@GetMapping("/card")
	public List<CardsDto> CardInfo() {
		return cardsRepository.findAll();
	}
}