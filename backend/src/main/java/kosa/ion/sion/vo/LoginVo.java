package kosa.ion.sion.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVo {
    private String id;
    private String password;
    private String jwt;
    private Date expire;
}
