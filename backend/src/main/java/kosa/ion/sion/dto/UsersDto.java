package kosa.ion.sion.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "users")
@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UsersDto {
	@Id
	private String id;
	private String name;
	private String password;
	private String email;
}
