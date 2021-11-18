package kosa.ion.sion.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CardVo {
    private MultipartFile img;
    private String title;
    private String content;
    private String cardType;
    private Boolean cardCheck;
    private Boolean cardCredit;
    private String benefitType;
    private String benefitContent;
    private Boolean mastercard;
    private Boolean traficcard;
}
