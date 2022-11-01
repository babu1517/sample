package com.example.board.DTO;

import com.example.board.Entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BoardDTO {
    long id;
    String content;
    @NotBlank(message = "이름은 필수항목")
    @Size(min = 2,max = 5,message = "이름은 2~5자 이내입력요함!!")
    String name;
    String title;
    LocalDate writeday;
    int readcnt;

    String picture;
    public BoardEntity toEntity(){
        return new BoardEntity(id,name,title,content,writeday,readcnt,picture);
    }
}
