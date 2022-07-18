package com.example.sbb.reply.dao;

import com.example.sbb.reply.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}
