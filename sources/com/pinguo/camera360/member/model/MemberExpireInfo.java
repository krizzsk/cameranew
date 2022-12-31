package com.pinguo.camera360.member.model;

import kotlin.jvm.internal.s;
/* compiled from: MemberInfo.kt */
/* loaded from: classes3.dex */
public final class MemberExpireInfo {
    private String expires;
    private Integer isVip;

    public MemberExpireInfo(String str, Integer num) {
        this.expires = str;
        this.isVip = num;
    }

    public static /* synthetic */ MemberExpireInfo copy$default(MemberExpireInfo memberExpireInfo, String str, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = memberExpireInfo.expires;
        }
        if ((i2 & 2) != 0) {
            num = memberExpireInfo.isVip;
        }
        return memberExpireInfo.copy(str, num);
    }

    public final String component1() {
        return this.expires;
    }

    public final Integer component2() {
        return this.isVip;
    }

    public final MemberExpireInfo copy(String str, Integer num) {
        return new MemberExpireInfo(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MemberExpireInfo) {
            MemberExpireInfo memberExpireInfo = (MemberExpireInfo) obj;
            return s.c(this.expires, memberExpireInfo.expires) && s.c(this.isVip, memberExpireInfo.isVip);
        }
        return false;
    }

    public final String getExpires() {
        return this.expires;
    }

    public int hashCode() {
        String str = this.expires;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.isVip;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public final Integer isVip() {
        return this.isVip;
    }

    public final void setExpires(String str) {
        this.expires = str;
    }

    public final void setVip(Integer num) {
        this.isVip = num;
    }

    public String toString() {
        return "MemberExpireInfo(expires=" + ((Object) this.expires) + ", isVip=" + this.isVip + ')';
    }
}
