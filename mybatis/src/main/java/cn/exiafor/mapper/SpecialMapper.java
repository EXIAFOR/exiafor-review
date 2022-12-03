package cn.exiafor.mapper;

import org.apache.ibatis.annotations.Param;

public interface SpecialMapper {
    /**
     * 批量删除
     */
    int batchDelete(@Param("ids") String ids);
}
