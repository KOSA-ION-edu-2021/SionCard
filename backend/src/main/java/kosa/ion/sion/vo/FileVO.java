package kosa.ion.sion.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class FileVO {
    private String name;
    private List<MultipartFile> files;
}
