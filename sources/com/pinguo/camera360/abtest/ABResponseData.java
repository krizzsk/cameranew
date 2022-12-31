package com.pinguo.camera360.abtest;

import us.pinguo.foundation.utils.NoProguard;
/* compiled from: ABTestDataModel.kt */
/* loaded from: classes3.dex */
public final class ABResponseData implements NoProguard {
    private final Data data;
    private final String exetime;
    private final String message;
    private final Double serverTime;
    private final Integer status;

    public ABResponseData(Data data, Integer num, String str, Double d2, String str2) {
        this.data = data;
        this.status = num;
        this.message = str;
        this.serverTime = d2;
        this.exetime = str2;
    }

    public final Data getData() {
        return this.data;
    }

    public final String getExetime() {
        return this.exetime;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Double getServerTime() {
        return this.serverTime;
    }

    public final Integer getStatus() {
        return this.status;
    }
}
