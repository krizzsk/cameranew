package us.pinguo.paylibcenter.order;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class GetIapProductReq implements Serializable {
    private String limit;
    private String skip;

    public GetIapProductReq() {
    }

    public String getLimit() {
        return this.limit;
    }

    public String getSkip() {
        return this.skip;
    }

    public void setLimit(String str) {
        this.limit = str;
    }

    public void setSkip(String str) {
        this.skip = str;
    }

    public GetIapProductReq(String str, String str2) {
        this.limit = str;
        this.skip = str2;
    }
}
