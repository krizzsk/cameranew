package us.pinguo.paylibcenter.order;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class RestoreOrderReq implements Serializable {
    private String deviceId;
    private String token;
    private String userId;
    private int version;

    public RestoreOrderReq() {
        this.userId = "";
        this.version = 0;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserId() {
        String str = this.userId;
        return str == null ? "" : str;
    }

    public int getVersion() {
        return this.version;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setVersion(int i2) {
        this.version = i2;
    }

    public RestoreOrderReq(String str, int i2) {
        this.userId = "";
        this.version = 0;
        this.userId = str;
        this.version = i2;
    }
}
