package kosa.ion.sion.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "cards")
@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CardsDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String img;
	private String content;
	private String cardType;
	private boolean cardCheck;
	private boolean cardCredit;
	private String benefitType;
	private String benefitContent;
	private boolean mastercard;
	private boolean traficcard;
}
