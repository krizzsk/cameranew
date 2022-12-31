package com.pinguo.camera360.member.model;

import kotlin.jvm.internal.s;
/* compiled from: ChinaMobilePayResponse.kt */
/* loaded from: classes3.dex */
public final class ChinaMobilePayResponse {
    private String resCode;
    private String resMsg;

    public ChinaMobilePayResponse(String resCode, String resMsg) {
        s.h(resCode, "resCode");
        s.h(resMsg, "resMsg");
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public static /* synthetic */ ChinaMobilePayResponse copy$default(ChinaMobilePayResponse chinaMobilePayResponse, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = chinaMobilePayResponse.resCode;
        }
        if ((i2 & 2) != 0) {
            str2 = chinaMobilePayResponse.resMsg;
        }
        return chinaMobilePayResponse.copy(str, str2);
    }

    public final String component1() {
        return this.resCode;
    }

    public final String component2() {
        return this.resMsg;
    }

    public final ChinaMobilePayResponse copy(String resCode, String resMsg) {
        s.h(resCode, "resCode");
        s.h(resMsg, "resMsg");
        return new ChinaMobilePayResponse(resCode, resMsg);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChinaMobilePayResponse) {
            ChinaMobilePayResponse chinaMobilePayResponse = (ChinaMobilePayResponse) obj;
            return s.c(this.resCode, chinaMobilePayResponse.resCode) && s.c(this.resMsg, chinaMobilePayResponse.resMsg);
        }
        return false;
    }

    public final String getResCode() {
        return this.resCode;
    }

    public final String getResMsg() {
        return this.resMsg;
    }

    public int hashCode() {
        return (this.resCode.hashCode() * 31) + this.resMsg.hashCode();
    }

    public final void setResCode(String str) {
        s.h(str, "<set-?>");
        this.resCode = str;
    }

    public final void setResMsg(String str) {
        s.h(str, "<set-?>");
        this.resMsg = str;
    }

    public String toString() {
        return "ChinaMobilePayResponse(resCode=" + this.resCode + ", resMsg=" + this.resMsg + ')';
    }
}
