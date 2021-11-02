package kosa.ion.sion.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "members")
@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MembersDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String memberId;
	private String name;
	private String password;
	private String email;
}
