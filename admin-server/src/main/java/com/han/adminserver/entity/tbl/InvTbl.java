package com.han.adminserver.entity.tbl;

import java.io.Serializable;

public class InvTbl implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String skuCode;
    private Integer qty;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSkuCode() {
        return skuCode;
    }
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
    public Integer getQty() {
        return qty;
    }
    public void setQty(Integer qty) {
        this.qty = qty;
    }

}
