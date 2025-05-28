package com.example.board.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.entity.Reply;

import jakarta.transaction.Transactional;

@SpringBootTest
public class ReplyRepositoryTest {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertTest() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            long bno = (long) (Math.random() * 100) + 1;

            Board board = Board.builder().bno(bno).build();
            Member member = Member.builder().email("user1@naver.com").build();

            Reply reply = Reply.builder()
                    .text("Reply..." + i)
                    // .replyer("guest" + i)
                    .replyer(member)
                    .board(board)
                    .build();
            replyRepository.save(reply);
        });
    }

    @Transactional
    @Test
    public void getRow() {
        Reply reply = replyRepository.findById(11L).get();
        System.out.println(reply);

        // FetchType.LAZY 이기 때문에 reply 부모 게시물 안 가지고 옴
        System.out.println(reply.getBoard());
    }

    @Test
    public void getReplies() {

        // SELECT * FROM REPLY r WHERE r.BOARD_BNO = 100;
        Board board = Board.builder().bno(2L).build();
        List<Reply> replies = replyRepository.getRepliesByBoardOrderByRno(board);

        System.out.println(replies.toString());
    }
}
