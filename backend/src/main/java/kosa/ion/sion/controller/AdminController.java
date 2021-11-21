package kosa.ion.sion.controller;

import kosa.ion.sion.dto.CardsDto;
import kosa.ion.sion.getter.KindOfCardGetter;
import kosa.ion.sion.repository.CardsRepository;
import kosa.ion.sion.vo.CardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.*;

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

		String newName = UUID.randomUUID()+cardVo.getImg().getOriginalFilename();
		cardVo.getImg().transferTo(new File(newName));
		CardsDto cardsDto=new CardsDto();

		cardsDto.setImg("https://manage.si-on.net/api/image/"+newName);
		cardsDto.setTitle(cardVo.getTitle());
		cardsDto.setContent(cardVo.getContent());
		cardsDto.setCardType(cardVo.getCardType());
		cardsDto.setCardCheck(cardVo.getCardCheck());
		cardsDto.setCardCredit(cardVo.getCardCredit());
		cardsDto.setBenefitType(cardVo.getBenefitType());
		cardsDto.setBenefitContent(cardVo.getBenefitContent());
		cardsDto.setMastercard(cardVo.getMastercard());
		cardsDto.setTraficcard(cardVo.getTraficcard());


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
	@PutMapping("/card/{id}")
	@Transactional
	public Boolean editCard(@PathVariable("id") Long id, @RequestBody Map<String, String> body) {
		if(!cardsRepository.existsById(id)) return false;
		CardsDto cardsDto = cardsRepository.findById(id).orElseThrow(()->new NoSuchElementException());
		cardsDto.setTitle(body.get("title"));
		cardsDto.setContent(body.get("content"));
		cardsDto.setCardType(body.get("card_type"));
		cardsDto.setCardCheck(body.get("card_type").equals("check"));
		cardsDto.setCardCredit(body.get("card_type").equals("credit"));
		cardsDto.setBenefitType(body.get("benefit_type"));
		cardsDto.setBenefitContent(body.get("benefit_content"));
		return true;
	}


	@GetMapping("kind_of_card")
	public List<Map<String, String>> kindOfCard(){
		List<KindOfCardGetter> kindOfCards= cardsRepository.kindOfCard();
		List<Map<String,String>> result=new ArrayList<>();

		for(KindOfCardGetter kindOfCard : kindOfCards){
			Map<String, String> temp = new HashMap<>();
			temp.put("체크카드",kindOfCard.getCntCheck());
			temp.put("신용카드",kindOfCard.getCntCheck());
			result.add(temp);
		}
		return result;
	}
}