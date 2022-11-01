package com.example.board.Reposiroty;

import com.example.board.Entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.beans.Transient;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    @Transactional
    @Modifying
    @Query(value = "update board1028 set readcnt = readcnt +1 where board1028.id = :id", nativeQuery = true )
    int updateReadcnt(@Param("id") Long id);
}
