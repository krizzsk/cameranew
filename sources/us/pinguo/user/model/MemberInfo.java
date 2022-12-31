package us.pinguo.user.model;

import kotlin.jvm.internal.s;
/* compiled from: VipMemberInfo.kt */
/* loaded from: classes6.dex */
public final class MemberInfo {
    private MemberExpireInfo data;
    private String message;
    private float serverTime;
    private int status;

    public MemberInfo(int i2, String message, float f2, MemberExpireInfo data) {
        s.h(message, "message");
        s.h(data, "data");
        this.status = i2;
        this.message = message;
        this.serverTime = f2;
        this.data = data;
    }

    public static /* synthetic */ MemberInfo copy$default(MemberInfo memberInfo, int i2, String str, float f2, MemberExpireInfo memberExpireInfo, int i3, Object obj) {
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

    public final float component3() {
        return this.serverTime;
    }

    public final MemberExpireInfo component4() {
        return this.data;
    }

    public final MemberInfo copy(int i2, String message, float f2, MemberExpireInfo data) {
        s.h(message, "message");
        s.h(data, "data");
        return new MemberInfo(i2, message, f2, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MemberInfo) {
            MemberInfo memberInfo = (MemberInfo) obj;
            return this.status == memberInfo.status && s.c(this.message, memberInfo.message) && s.c(Float.valueOf(this.serverTime), Float.valueOf(memberInfo.serverTime)) && s.c(this.data, memberInfo.data);
        }
        return false;
    }

    public final MemberExpireInfo getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final float getServerTime() {
        return this.serverTime;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((this.status * 31) + this.message.hashCode()) * 31) + Float.floatToIntBits(this.serverTime)) * 31) + this.data.hashCode();
    }

    public final void setData(MemberExpireInfo memberExpireInfo) {
        s.h(memberExpireInfo, "<set-?>");
        this.data = memberExpireInfo;
    }

    public final void setMessage(String str) {
        s.h(str, "<set-?>");
        this.message = str;
    }

    public final void setServerTime(float f2) {
        this.serverTime = f2;
    }

    public final void setStatus(int i2) {
        this.status = i2;
    }

    public String toString() {
        return "status = " + this.status + " message = " + this.message + " serverTime = " + this.serverTime;
    }
}
