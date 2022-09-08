package com.sfbest.optimize.batch.mapper.db1;

import com.sfbest.optimize.batch.model.TUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author ZZH
 * @create 2022/9/7
 * @since 1.0.0
 */
@Mapper
public interface UserMapper {
    java.util.List<TUser> select();
}