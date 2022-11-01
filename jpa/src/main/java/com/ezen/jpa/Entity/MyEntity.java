package com.ezen.jpa.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="info")
@SequenceGenerator(
        name="info_seq_Generator",
        sequenceName = "info_seq",
        initialValue = 1,allocationSize = 1)
public class MyEntity {
    @Id//기본키역할
    @Column
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "info+seq_Generator")
    long id;
    @Column
    String name;
    @Column
    int age;
    @Column
    String mobile;
    @Column
    String address;
    @Column
    String sb;

}
