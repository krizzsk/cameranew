package us.pinguo.paylibcenter.order;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class SyncOrderResp extends BaseResp implements Serializable {
    private Data data;

    /* loaded from: classes5.dex */
    public class Data implements Serializable {
        public Data() {
        }
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
