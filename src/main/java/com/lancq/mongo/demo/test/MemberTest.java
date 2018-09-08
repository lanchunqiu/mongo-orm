package com.lancq.mongo.demo.test;

import com.alibaba.fastjson.JSON;
import com.lancq.mongo.demo.dao.MemberDao;
import com.lancq.mongo.demo.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.core.common.mongo.QueryRule;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lancq
 * @Description
 * @Date 2018/9/8
 **/
@ContextConfiguration(locations={"classpath*:application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberTest {
    @Autowired
    private MemberDao memberDao;

    @Test
    public void testInsertAll(){
        List<Member> data = new ArrayList<Member>();
        data.add(new Member("tom","123456",1,18));
        memberDao.insertAll(data);
    }

    @Test
    public void testSelect(){
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.andEqual("nickname","tom");
        List<Member> memberList = memberDao.select(queryRule);

        System.out.println(JSON.toJSONString(memberList,true));

    }

}
