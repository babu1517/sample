package com.example.board.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="board1028")
@DynamicUpdate
@DynamicInsert
@SequenceGenerator(name = "board1028_seq_GENERATOR",sequenceName = "board1028_seq", allocationSize = 1, initialValue = 1)
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "board1028_seq_GENERATOR")
    @Column
    long id;
    @Column
    String name;
    @Column
    String title;
    @Column
    String content;
    @Column
    LocalDate writeday;
    @Column
    int readcnt;
    @Column
    String picture;
}
