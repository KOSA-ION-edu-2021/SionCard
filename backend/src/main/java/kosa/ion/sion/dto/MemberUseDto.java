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

@Entity
@Table(name = "memberUse")
@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MemberUseDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String cardNum;
	private String memberId;
	private String usePrice;
	private Date useDate;
	private String useLocation;
	private String useDiscount;
	private String useStack;
	private String usePoint;
	private String useMileage;
}
