package kosa.ion.sion.controller;

import kosa.ion.sion.repository.CardsRepository;
import kosa.ion.sion.vo.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//	@PostMapping("/card_info")
//	@ResponseBody
//	public ResponseEntity<CardsDto> signup(@RequestBody FileTestDto fileTestDto) {
//		return ResponseEntity.ok(cardsRepository.save(card_info));
//	}

	@PostMapping("/file_up")
	@ResponseBody
	public ResponseEntity<Boolean> signup(@RequestBody FileVO fileVO) {


		return ResponseEntity.ok(false);
	}
}