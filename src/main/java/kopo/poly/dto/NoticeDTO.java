package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDTO {    // 나중에 select문을 할 때 내용을 DTO로 가져올 수 있다. 
    private String notice_seq;
    private String title;
    private String contents;
    private String reg_id;
    private String regdate;
}
