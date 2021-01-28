package test.mystudy;

import com.mystudy.Application;
import com.mystudy.mapper.ArticleMapper;
import com.mystudy.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class TestDemo {
    @Autowired
    private ArticleMapper mapper;

    @Test
    public void test() {
        Article article = mapper.selectByPrimaryKey(2);
        System.out.println(article);
    }
}
