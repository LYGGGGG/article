package cn.itcast.article.dao;

/*
@author YG
@create 2022/10/11   17:03
*/

import cn.itcast.article.po.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {
}
