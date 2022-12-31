package us.pinguo.user.util;

import us.pinguo.foundation.utils.NoProguard;
/* compiled from: VerifyResponse.kt */
/* loaded from: classes6.dex */
public final class VerifyResponse implements NoProguard {
    private VerifyResult data;
    private String message;
    private Integer status;

    public VerifyResponse(VerifyResult verifyResult, String str, Integer num) {
        this.data = verifyResult;
        this.message = str;
        this.status = num;
    }

    public final VerifyResult getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setData(VerifyResult verifyResult) {
        this.data = verifyResult;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }
}
