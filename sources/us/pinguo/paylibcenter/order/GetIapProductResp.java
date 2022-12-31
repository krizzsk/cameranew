package us.pinguo.paylibcenter.order;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes5.dex */
public class GetIapProductResp extends BaseResp implements Serializable {
    private List<data> data;
    private double serverTime;

    /* loaded from: classes5.dex */
    public static class data implements Serializable {
        private String appStorePrice;
        private String googlePlayPrice;
        private String name;
        private String price;
        private String productId;
        private String productIdAppStore;
        private String productIdGooglePlay;

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

        public String toString() {
            return new com.google.gson.e().s(this);
        }
    }

    public List<data> getData() {
        return this.data;
    }

    public double getServerTime() {
        return this.serverTime;
    }

    public void setData(List<data> list) {
        this.data = list;
    }

    public void setServerTime(double d2) {
        this.serverTime = d2;
    }
}
