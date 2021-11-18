package kosa.ion.sion.vo;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AuthVo {
	private String memberId;
	private String name;
	private String email;
	private String birth;
	private String address;
	private String phone;
	private Date expire;
}
