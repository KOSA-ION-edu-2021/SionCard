package kosa.ion.sion.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kosa.ion.sion.dto.CardsDto;
import kosa.ion.sion.repository.CardsRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController{
	@Autowired
	CardsRepository cardsRepository;
	
	@PostMapping("/card_info")
	@ResponseBody
	public ResponseEntity<CardsDto> signup(HttpServletResponse response, @RequestBody CardsDto card_info) {
		return ResponseEntity.ok(cardsRepository.save(card_info));
	}
}
