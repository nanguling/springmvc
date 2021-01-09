package com.mystudy.model;

public class Comment {
    private Integer id;
    private String content;
    private Integer articleId;
    private Integer commenter;//评论者

    public Comment() {
    }

    public Comment(Integer id, String content, Integer articleId, Integer commenter) {
        this.id = id;
        this.content = content;
        this.articleId = articleId;
        this.commenter = commenter;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", articleId=" + articleId +
                ", commenter=" + commenter +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getCommenter() {
        return commenter;
    }

    public void setCommenter(Integer commenter) {
        this.commenter = commenter;
    }
}
