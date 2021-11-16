package kosa.ion.sion.vo;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthVo {
	private String memberId;
	private String name;
	private String email;
	private String birth;
	private String address;
	private String phone;
	private Date expire;
}
