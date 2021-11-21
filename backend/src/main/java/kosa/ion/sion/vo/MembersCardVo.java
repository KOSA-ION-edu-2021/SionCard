package kosa.ion.sion.vo;

import java.sql.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MembersCardVo {
	private long id;
	private Date cardEdate;
	private String cardId;
	private String cardNum;
	private String cardTitle;
	private String memberId;
	private String img;
}
