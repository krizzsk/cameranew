package us.pinguo.user.model;

import kotlin.jvm.internal.s;
/* compiled from: VipMemberInfo.kt */
/* loaded from: classes6.dex */
public final class MemberExpireInfo {
    private String expires;
    private int isVip;

    public MemberExpireInfo(String expires, int i2) {
        s.h(expires, "expires");
        this.expires = expires;
        this.isVip = i2;
    }

    public static /* synthetic */ MemberExpireInfo copy$default(MemberExpireInfo memberExpireInfo, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = memberExpireInfo.expires;
        }
        if ((i3 & 2) != 0) {
            i2 = memberExpireInfo.isVip;
        }
        return memberExpireInfo.copy(str, i2);
    }

    public final String component1() {
        return this.expires;
    }

    public final int component2() {
        return this.isVip;
    }

    public final MemberExpireInfo copy(String expires, int i2) {
        s.h(expires, "expires");
        return new MemberExpireInfo(expires, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MemberExpireInfo) {
            MemberExpireInfo memberExpireInfo = (MemberExpireInfo) obj;
            return s.c(this.expires, memberExpireInfo.expires) && this.isVip == memberExpireInfo.isVip;
        }
        return false;
    }

    public final String getExpires() {
        return this.expires;
    }

    public int hashCode() {
        return (this.expires.hashCode() * 31) + this.isVip;
    }

    public final int isVip() {
        return this.isVip;
    }

    public final void setExpires(String str) {
        s.h(str, "<set-?>");
        this.expires = str;
    }

    public final void setVip(int i2) {
        this.isVip = i2;
    }

    public String toString() {
        return "MemberExpireInfo(expires=" + this.expires + ", isVip=" + this.isVip + ')';
    }
}
