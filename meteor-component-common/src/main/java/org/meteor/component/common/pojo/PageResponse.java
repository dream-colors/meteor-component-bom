package org.meteor.component.common.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author 钟宗兵
 * @date 2023/1/15
 * @since 1.0
 **/
public class PageResponse<T> extends Response {

    private static final long serialVersionUID = 1L;

    private int totalCount = 0;

    private int pageSize = 1;

    private int pageIndex = 1;

    private Collection<T> data;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return Math.max(pageSize, 1);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = Math.max(pageSize, 1);
    }

    public int getPageIndex() {
        return Math.max(pageIndex, 1);
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = Math.max(pageIndex, 1);
    }

    public List<T> getData() {
        if (null == data) {
            return Collections.emptyList();
        }
        if (data instanceof List) {
            return (List<T>) data;
        }
        return new ArrayList<>(data);
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public int getTotalPages() {
        return this.totalCount % this.pageSize == 0 ? this.totalCount
                / this.pageSize : (this.totalCount / this.pageSize) + 1;
    }

    public boolean isEmpty() {
        return data == null || data.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public static PageResponse<Void> buildSuccess() {
        PageResponse<Void> response = new PageResponse<>();
        response.setSuccess(true);
        return response;
    }

    public static PageResponse<Void> buildFailure(int errCode, String errMessage) {
        PageResponse<Void> response = new PageResponse<>();
        response.setSuccess(false);
        response.setCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static <T> PageResponse<T> of(int pageSize, int pageIndex) {
        PageResponse<T> response = new PageResponse<>();
        response.setSuccess(true);
        response.setData(Collections.emptyList());
        response.setTotalCount(0);
        response.setPageSize(pageSize);
        response.setPageIndex(pageIndex);
        return response;
    }

    public static <T> PageResponse<T> of(Collection<T> data, int totalCount, int pageSize, int pageIndex) {
        PageResponse<T> response = new PageResponse<>();
        response.setSuccess(true);
        response.setData(data);
        response.setTotalCount(totalCount);
        response.setPageSize(pageSize);
        response.setPageIndex(pageIndex);
        return response;
    }

}
