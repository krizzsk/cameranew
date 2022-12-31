package us.pinguo.paylibcenter.order;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class BaseResp implements Serializable {
    private String message;
    private int status;

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isSuccess() {
        return this.status == 200;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }
}
