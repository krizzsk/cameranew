package us.pinguo.paylibcenter.order;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class PurchaseResp extends BaseResp implements Serializable {
    private data data;

    /* loaded from: classes5.dex */
    public static class data implements Serializable {
        String pay;

        public String getPay() {
            return this.pay;
        }

        public void setPay(String str) {
            this.pay = str;
        }
    }

    public data getData() {
        return this.data;
    }

    public void setData(data dataVar) {
        this.data = dataVar;
    }
}
