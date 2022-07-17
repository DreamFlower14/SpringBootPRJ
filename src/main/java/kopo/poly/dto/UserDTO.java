package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {    // 나중에 select문을 할 때 내용을 DTO로 가져올 수 있다.
    private String user_seq;
    private String user_name;
    private String user_id;
    private String user_pwd;
    private String user_email;
}
