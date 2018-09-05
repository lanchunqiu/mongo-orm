package javax.core.common.mongo;

import org.springframework.data.mongodb.core.MongoTemplate;

import javax.core.common.utils.GenericsUtils;
import java.io.Serializable;

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


}
