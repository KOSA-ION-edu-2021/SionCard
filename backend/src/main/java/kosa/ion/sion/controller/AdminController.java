package kosa.ion.sion.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosa.ion.sion.dto.CardsDto;
import kosa.ion.sion.repository.CardsRepository;
import kosa.ion.sion.vo.CardVo;

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

	@PostMapping("/create_card")
	public CardsDto createCard(CardVo cardVo) throws Exception{

		//if(cardVo.getImg() == null) return cardsDto;
		String newName = UUID.randomUUID()+cardVo.getImg().getOriginalFilename();
		cardVo.getImg().transferTo(new File(newName));
		CardsDto cardsDto=new CardsDto();

		cardsDto.setImg("http://localhost:8080/api/image/"+newName);
		cardsDto.setTitle(cardVo.getTitle());
		cardsDto.setContent(cardVo.getContent());
		cardsDto.setCardType(cardVo.getCardType());
		//cardsDto.setCardCheck(cardVo.getCardCheck());
		//cardsDto.setCardCredit(cardVo.getCardCredit());
		cardsDto.setBenefitType(cardVo.getBenefitType());
		cardsDto.setBenefitContent(cardVo.getBenefitContent());
		//cardsDto.setMastercard(cardVo.getMastercard());
		//cardsDto.setTraficcard(cardVo.getTraficcard());


		return cardsRepository.save(cardsDto);
	}
	
	@GetMapping("/card")
	public List<CardsDto> CardInfo() {
		return cardsRepository.findAll();
	}
	
	@DeleteMapping("/card/{id}")
	public Boolean deleteCard(@PathVariable("id") Long id) {
			if(!cardsRepository.existsById(id)) return false;
			cardsRepository.deleteById(id);
			return true;
	}
	
}