package com.pinguo.camera360.newShop.model;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class StoreHistory implements Serializable {
    private Datas data;
    private String message;
    private double serverTime;
    private int status;

    /* loaded from: classes3.dex */
    public class Datas implements Serializable {
        private List<Lists> lists;
        private int version;

        public Datas() {
        }

        public List<Lists> getLists() {
            return this.lists;
        }

        public int getVersion() {
            return this.version;
        }

        public void setLists(List<Lists> list) {
            this.lists = list;
        }

        public void setVersion(int i2) {
            this.version = i2;
        }
    }

    /* loaded from: classes3.dex */
    public class Lists implements Serializable {
        private String createTime;
        private String icon;
        private String name;
        private String productId;
        private int status;
        private int type;

        public Lists() {
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public String getIcon() {
            return this.icon;
        }

        public String getName() {
            return this.name;
        }

        public String getProductId() {
            return this.productId;
        }

        public int getStatus() {
            return this.status;
        }

        public int getType() {
            return this.type;
        }

        public void setCreateTime(String str) {
            this.createTime = str;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setProductId(String str) {
            this.productId = str;
        }

        public void setStatus(int i2) {
            this.status = i2;
        }

        public void setType(int i2) {
            this.type = i2;
        }
    }

    public Datas getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public double getServerTime() {
        return this.serverTime;
    }

    public int getStatus() {
        return this.status;
    }

    public void setData(Datas datas) {
        this.data = datas;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setServerTime(double d2) {
        this.serverTime = d2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }
}
