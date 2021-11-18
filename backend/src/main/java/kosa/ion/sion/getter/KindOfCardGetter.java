package kosa.ion.sion.getter;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public interface KindOfCardGetter {
    String getCntCredit();
    String getCntCheck();
}
