package cn.itcast.article.service;

/*
@author YG
@create 2022/10/11   17:04
*/

import cn.itcast.article.dao.CommentRepository;
import cn.itcast.article.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存一个评论
     * @param comment
     */
    public void saveComment(Comment comment) {
        //如果需要自定义主键，可以在这里指定主键；如果不指定主键，MongoDB会自动生成主键
        //设置一些默认初始值。。。
        //调用dao
        commentRepository.save(comment);
    }

    /**
     * 更新评论
     * @param comment
     */
    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    /**
     * 根据id删除评论
     * @param id
     */
    public void deleteCommentById(String id){
        commentRepository.deleteById(id);
    }

    /**
     * 查询所有评论
     * @return
     */
    public List<Comment> findCommentList(){
        List<Comment> list = commentRepository.findAll();
        return list;
    }

    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    public Comment findCommentById(String id){
        return commentRepository.findById(id).get();
    }

    /**
     * 根据父id查询分页列表
     */
    public Page<Comment> findCommentListByParentid(String parentId, int page, int size) {
        //page-1:第0页
        return commentRepository.findByParentId(parentId, PageRequest.of(page-1,size));
    }

    /**
     * 评论点赞 - 效率低
     */
    public void updateCommentThumbupToIncrementingOld(String id) {
        Comment comment = commentRepository.findById(id).get();
        comment.setLikeNum(comment.getLikeNum()+1);
        commentRepository.save(comment);
    }


    /**
     * 评论点赞 - 效率高，使用MongoTemplate
     */
    public void updateCommentLikeNum(String id){
        //查询条件
        Query query = new Query(Criteria.where("_id").is(id));
        //更新条件
        Update update = new Update();
        update.inc("likenum");

        //参数1：查询对象
        //参数2：更新对象
        //参数3：集合的名字或实例类的类型Comment.class
        mongoTemplate.updateFirst(query,update,Comment.class);
    }
}
