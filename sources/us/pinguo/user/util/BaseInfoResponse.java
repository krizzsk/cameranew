package us.pinguo.user.util;

import us.pinguo.foundation.utils.NoProguard;
/* compiled from: VerifyResponse.kt */
/* loaded from: classes6.dex */
public final class BaseInfoResponse implements NoProguard {
    private final BaseInfoResult data;
    private final String message;
    private final Integer status;

    public BaseInfoResponse(BaseInfoResult baseInfoResult, String str, Integer num) {
        this.data = baseInfoResult;
        this.message = str;
        this.status = num;
    }

    public final BaseInfoResult getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatus() {
        return this.status;
    }
}
