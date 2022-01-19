package com.jboard.boardserver.repository.content;

import com.jboard.boardserver.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long>, ContentCustomRepository {
}
