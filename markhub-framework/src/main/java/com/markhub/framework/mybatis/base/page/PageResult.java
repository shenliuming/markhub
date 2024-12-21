package com.markhub.framework.mybatis.base.page;

import lombok.Data;

import java.util.List;

/**
 * @Auther: emp
 * @Date: 2024/12/21 14:51
 * @Description:
 */
@Data
public class PageResult<T> {

    private Long page;       // 当前页码
    private Long pageSize;   // 每页大小
    private Long totalPage;  // 总页数
    private Long total;      // 总记录数
    private List<T> data;   // 当前页的数据

    /**
     * 构造函数，初始化分页信息。
     *
     * @param page     当前页码
     * @param pageSize 每页大小
     * @param total    总记录数
     * @param data     当前页的数据
     */
    public PageResult(Long page, Long pageSize, Long total, List<T> data) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
        this.totalPage = calculateTotalPage(total, pageSize);
    }

    /**
     * 计算总页数。
     *
     * @param total    总记录数
     * @param pageSize 每页大小
     * @return 总页数
     */
    private Long calculateTotalPage(Long total, Long pageSize) {
        if (pageSize == 0) {
            return 0L;
        }
        return (total + pageSize - 1) / pageSize;
    }

}