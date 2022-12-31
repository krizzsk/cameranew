package com.pinguo.camera360.newShop.model;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class StoreIAPGroup implements Serializable {
    private Data data;
    private String message;
    private double serverTime;
    private int status;

    /* loaded from: classes3.dex */
    public class Data implements Serializable {
        private List<Lists> lists;
        private int version;

        public Data() {
        }

        public List<Lists> getList() {
            return this.lists;
        }

        public int getVersion() {
            return this.version;
        }

        public void setList(List<Lists> list) {
            this.lists = list;
        }

        public void setVersion(int i2) {
            this.version = i2;
        }
    }

    /* loaded from: classes3.dex */
    public class Lists implements Serializable {
        private String appStorePrice;
        private String googlePlayPrice;
        private String name;
        private String price;
        private String productId;
        private String productIdAppStore;
        private String productIdGooglePlay;
        private String type;
        private String versionCtrlInfo;

        public Lists() {
        }

        public String getAppStorePrice() {
            return this.appStorePrice;
        }

        public String getGooglePlayPrice() {
            return this.googlePlayPrice;
        }

        public String getName() {
            return this.name;
        }

        public String getPrice() {
            return this.price;
        }

        public String getProductId() {
            return this.productId;
        }

        public String getProductIdAppStore() {
            return this.productIdAppStore;
        }

        public String getProductIdGooglePlay() {
            return this.productIdGooglePlay;
        }

        public String getType() {
            return this.type;
        }

        public String getVersionCtrlInfo() {
            return this.versionCtrlInfo;
        }

        public void setAppStorePrice(String str) {
            this.appStorePrice = str;
        }

        public void setGooglePlayPrice(String str) {
            this.googlePlayPrice = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPrice(String str) {
            this.price = str;
        }

        public void setProductId(String str) {
            this.productId = str;
        }

        public void setProductIdAppStore(String str) {
            this.productIdAppStore = str;
        }

        public void setProductIdGooglePlay(String str) {
            this.productIdGooglePlay = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setVersionCtrlInfo(String str) {
            this.versionCtrlInfo = str;
        }
    }

    public Data getData() {
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

    public void setData(Data data) {
        this.data = data;
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
