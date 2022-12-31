package us.pinguo.bigdata.network.model;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class BDNetworkResult implements Serializable {
    int errorCode;
    String errorMsg;
    boolean isSuccess;
    String result;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getResult() {
        return this.result;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }
}
