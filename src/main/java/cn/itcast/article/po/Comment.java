package cn.itcast.article.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 文章评论实体类
 */

/**
 * 把一个Java类声明为mongodb的文档(collection，对应mysql的表）
 *
 * @Document(collection="mongodb对应的collection名")
 */
@Document(collection = "comment") //可以省略，如果省略，则默认使用类名小写映射集合
//@CompoundIndex(def = "{'userid': 1, 'nickname': -1}") //复合索引
public class Comment implements Serializable {
    //主键标识，该属性的值会自动对应mongodb的主键字段“_id”，
    //如果该属性名就叫做“id”，则该注解可以省略，否则必须写
    @Id
    private String id; //主键

    @Field("content") //该属性对应mongodb的字段的名字，如果一致，则无需该注解
    private String content; //吐槽内容

    private Date publishTime; //发布日志

    //添加一个单字段的索引
    @Indexed
    private String userId; //发布人ID

    private String nickName; //昵称

    private LocalDateTime createDateTime; //评论的日期时间

    private Integer likeNum; //点赞数

    private Integer replyNum; //回复数

    private String state; //状态

    private String parentId; //上级ID

    private String articleId;

    //getter and setter.....
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", userId='" + userId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", createDateTime=" + createDateTime +
                ", likeNum=" + likeNum +
                ", replyNum=" + replyNum +
                ", state='" + state + '\'' +
                ", parentId='" + parentId + '\'' +
                ", articleId='" + articleId + '\'' +
                '}';
    }
}