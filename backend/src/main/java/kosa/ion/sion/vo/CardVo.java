package kosa.ion.sion.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CardVo {
    private MultipartFile img;
    private String title;
    private String content;
    private String cardType;
    private boolean cardCheck;
    private boolean cardCredit;
    private String benefitType;
    private String benefitContent;
    private boolean mastercard;
    private boolean traficcard;
}
