package com.lancq.mongo.demo.dao;

import com.lancq.mongo.demo.entity.Member;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.core.common.mongo.BaseDaoSupport;
import javax.core.common.mongo.QueryRule;
import java.util.List;

/**
 * @Author lancq
 * @Description
 * @Date 2018/9/8
 **/
@Repository
public class MemberDao extends BaseDaoSupport<Member,ObjectId> {
    public List<Member> select(QueryRule queryRule){
        return super.find(queryRule);
    }

    public int insertAll(List<Member> data){
        return super.saveAll(data);
    }

    @Resource(name="mongoTemplate")
    @Override
    protected void setTemplate(MongoTemplate tempate) {
        super.setTemplate(tempate);
    }

    @Override
    protected String getPKColumn() {
        return "_id";
    }

}
