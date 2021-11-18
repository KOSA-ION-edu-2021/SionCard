package kosa.ion.sion.controller;

import kosa.ion.sion.dto.CardsDto;
import kosa.ion.sion.getter.KindOfCardGetter;
import kosa.ion.sion.repository.CardsRepository;
import kosa.ion.sion.repository.MembersRepository;
import kosa.ion.sion.vo.CardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController{

	@Autowired
	MembersRepository membersRepository;
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

	@DeleteMapping("/members/{memberId}")
	public Boolean deleteMember(@PathVariable String memberId) {
		if(!membersRepository.existsByMemberId(memberId)) return false;
		membersRepository.deleteByMemberId(memberId);
		return true;
	}

	@GetMapping("kind_of_card")
	public List<KindOfCardGetter> kindOfCard(){
		return cardsRepository.kindOfCard();
	}
}