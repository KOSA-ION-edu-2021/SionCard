package kosa.ion.sion.controller;

import kosa.ion.sion.dto.FileTestDto;
import kosa.ion.sion.repository.CardsRepository;
import kosa.ion.sion.repository.FileTestRepository;
import kosa.ion.sion.vo.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
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
	@Autowired
	FileTestRepository fileTestRepository;

	@PostMapping("/file_up")
	@ResponseBody
	public ResponseEntity<Boolean> fileUp(@RequestBody FileVO fileVO) throws IOException {
		List<FileTestDto> files = new ArrayList<FileTestDto>();
		for(MultipartFile file : fileVO.getFiles()){
			if(file.isEmpty()) continue;
			File newFile = new File(new ClassPathResource("images/"+file.getOriginalFilename()).getFile().getAbsolutePath());
			file.transferTo(newFile);

			files.add(new FileTestDto(new Long(null), file.getOriginalFilename(), file.getContentType()));
		}
		return ResponseEntity.ok(true);
	}
}