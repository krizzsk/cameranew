package com.pinguo.camera360.member.model;

import kotlin.jvm.internal.s;
/* compiled from: MemberInfo.kt */
/* loaded from: classes3.dex */
public final class MemberInfo {
    private MemberExpireInfo data;
    private String message;
    private Float serverTime;
    private int status;

    public MemberInfo(int i2, String str, Float f2, MemberExpireInfo memberExpireInfo) {
        this.status = i2;
        this.message = str;
        this.serverTime = f2;
        this.data = memberExpireInfo;
    }

    public static /* synthetic */ MemberInfo copy$default(MemberInfo memberInfo, int i2, String str, Float f2, MemberExpireInfo memberExpireInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = memberInfo.status;
        }
        if ((i3 & 2) != 0) {
            str = memberInfo.message;
        }
        if ((i3 & 4) != 0) {
            f2 = memberInfo.serverTime;
        }
        if ((i3 & 8) != 0) {
            memberExpireInfo = memberInfo.data;
        }
        return memberInfo.copy(i2, str, f2, memberExpireInfo);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final Float component3() {
        return this.serverTime;
    }

    public final MemberExpireInfo component4() {
        return this.data;
    }

    public final MemberInfo copy(int i2, String str, Float f2, MemberExpireInfo memberExpireInfo) {
        return new MemberInfo(i2, str, f2, memberExpireInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MemberInfo) {
            MemberInfo memberInfo = (MemberInfo) obj;
            return this.status == memberInfo.status && s.c(this.message, memberInfo.message) && s.c(this.serverTime, memberInfo.serverTime) && s.c(this.data, memberInfo.data);
        }
        return false;
    }

    public final MemberExpireInfo getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Float getServerTime() {
        return this.serverTime;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i2 = this.status * 31;
        String str = this.message;
        int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        Float f2 = this.serverTime;
        int hashCode2 = (hashCode + (f2 == null ? 0 : f2.hashCode())) * 31;
        MemberExpireInfo memberExpireInfo = this.data;
        return hashCode2 + (memberExpireInfo != null ? memberExpireInfo.hashCode() : 0);
    }

    public final void setData(MemberExpireInfo memberExpireInfo) {
        this.data = memberExpireInfo;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setServerTime(Float f2) {
        this.serverTime = f2;
    }

    public final void setStatus(int i2) {
        this.status = i2;
    }

    public String toString() {
        return "MemberInfo(status=" + this.status + ", message=" + ((Object) this.message) + ", serverTime=" + this.serverTime + ", data=" + this.data + ')';
    }
}
