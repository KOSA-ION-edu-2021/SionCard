package kosa.ion.sion.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "fileTest")
@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FileTestDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

}
