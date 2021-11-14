package kosa.ion.sion.controller;

import kosa.ion.sion.dto.FileTestDto;
import kosa.ion.sion.repository.CardsRepository;
import kosa.ion.sion.vo.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	public ResponseEntity<Boolean> signup(@RequestBody FileVO fileVO, Model model) throws IOException {
		List<FileTestDto> list = new ArrayList<>();

		for(MultipartFile file : fileVO.getFiles()){
			if(file.isEmpty()) continue;
			list.add(new FileTestDto(0, file.getOriginalFilename(), file.getContentType()));

			File newFile = new File(file.getOriginalFilename());
			file.transferTo(newFile);
		}
		
		return ResponseEntity.ok(false);
	}
}