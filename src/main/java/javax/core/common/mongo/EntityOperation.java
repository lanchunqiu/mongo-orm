package javax.core.common.mongo;

/**
 * @Author lancq
 * @Description
 * @Date 2018/9/5
 **/
public class EntityOperation<T> {
    public Class<T> entityClass = null; // 泛型实体Class对象

    public EntityOperation(Class<T> entityClass){
        this.entityClass = entityClass;
    }

}
