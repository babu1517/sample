package com.ezen.jpa.DTO;

import com.ezen.jpa.Entity.MyEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MyDTO {
    long id;

    String name;

    int age;

    String mobile;

    String address;

    String sb;

    public MyEntity toEntity() {
        return new MyEntity(id, name, age, mobile, address, sb);
    }
}
