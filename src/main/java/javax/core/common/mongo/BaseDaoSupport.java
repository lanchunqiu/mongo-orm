package javax.core.common.mongo;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import javax.core.common.utils.GenericsUtils;
import java.io.Serializable;
import java.util.List;

/**
 * @Author lancq
 * @Description
 * @Date 2018/9/5
 **/
public abstract class BaseDaoSupport<T extends Serializable, PK extends Serializable> {
    private MongoTemplate mongoTemplate;

    private EntityOperation<T> op;

    public BaseDaoSupport(){
        Class<T> entityClass = GenericsUtils.getSuperClassGenericType(getClass(),0);
        op = new EntityOperation<>(entityClass);
    }

    protected void setTemplate(MongoTemplate template){
       this.mongoTemplate = template;
    }

    protected abstract String getPKColumn();

    protected List<T> find(QueryRule queryRule){
        QueryRuleBuilder builder = new QueryRuleBuilder(queryRule);
        Query query = builder.getQuery();

        return mongoTemplate.find(query,op.entityClass);
    }

    protected int saveAll(List<T> list){
        mongoTemplate.insertAll(list);
        return list.size();
    }

    protected T get(PK id){
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.andEqual(this.getPKColumn(),id);
        QueryRuleBuilder builder = new QueryRuleBuilder(queryRule);
        Query query = builder.getQuery();

        return mongoTemplate.findOne(query, op.entityClass);
    }

    protected int delete(T entity){
        return mongoTemplate.remove(entity).getN();
    }

}
