package kosa.ion.sion.dto;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "membersCard")
@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@Getter @Setter
public class MembersCardDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date cardEdate;
	private String cardId;
	private String cardNum;
	private String cardTitle;
	private String memberId;
	
}
