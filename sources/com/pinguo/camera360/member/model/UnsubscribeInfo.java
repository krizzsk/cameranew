package com.pinguo.camera360.member.model;

import kotlin.jvm.internal.s;
/* compiled from: UnsubscribeInfo.kt */
/* loaded from: classes3.dex */
public final class UnsubscribeInfo {
    private final String unsubscribeUrl;

    public UnsubscribeInfo(String unsubscribeUrl) {
        s.h(unsubscribeUrl, "unsubscribeUrl");
        this.unsubscribeUrl = unsubscribeUrl;
    }

    public static /* synthetic */ UnsubscribeInfo copy$default(UnsubscribeInfo unsubscribeInfo, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = unsubscribeInfo.unsubscribeUrl;
        }
        return unsubscribeInfo.copy(str);
    }

    public final String component1() {
        return this.unsubscribeUrl;
    }

    public final UnsubscribeInfo copy(String unsubscribeUrl) {
        s.h(unsubscribeUrl, "unsubscribeUrl");
        return new UnsubscribeInfo(unsubscribeUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UnsubscribeInfo) && s.c(this.unsubscribeUrl, ((UnsubscribeInfo) obj).unsubscribeUrl);
    }

    public final String getUnsubscribeUrl() {
        return this.unsubscribeUrl;
    }

    public int hashCode() {
        return this.unsubscribeUrl.hashCode();
    }

    public String toString() {
        return "UnsubscribeInfo(unsubscribeUrl=" + this.unsubscribeUrl + ')';
    }
}
