package cn.itcast.article.service;

/*
@author YG
@create 2022/10/11   17:14
*/

import cn.itcast.article.po.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;

    /**
     * 测试查询所有
     */
    @Test
    public void testFindCommentList() {
        List<Comment> commentList = commentService.findCommentList();
        for (Comment comment : commentList) {
            System.out.println(comment);
        }
    }

    /**
     * 测试根据id查询
     */
    @Test
    public void testFindCommentById() {
        Comment comment = commentService.findCommentById("2");
        System.out.println(comment);
    }

    /**
     * 保存一个评论
     */
    @Test
    public void testSaveComment() {
        Comment comment = new Comment();
        comment.setArticleId("100000");
        comment.setContent("测试添加的数据");
        comment.setCreateDateTime(LocalDateTime.now());
        comment.setUserId("1003");
        comment.setNickName("凯撒大帝");
        comment.setState("1");
        comment.setLikeNum(0);
        comment.setReplyNum(0);
        commentService.saveComment(comment);
    }

    @Test
    public void testFindCommentListByParentid(){
        Page<Comment> page = commentService.findCommentListByParentid("3", 1, 2);
        System.out.println(page.getTotalElements());
        System.out.println(page.getContent());
    }
}
