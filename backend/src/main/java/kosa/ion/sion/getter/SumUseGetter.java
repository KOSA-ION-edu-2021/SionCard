package kosa.ion.sion.getter;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public interface SumUseGetter {
	public String getMemberId();
	public Integer getSumPrice();
	public Integer getSumDiscount();
	public Integer getSumStack();
	public Integer getSumPoint();
	public Integer getSumMileage();
}
