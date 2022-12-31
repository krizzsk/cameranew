package us.pinguo.payssion;

import kotlin.jvm.internal.s;
/* compiled from: PayssionPayway.kt */
/* loaded from: classes5.dex */
public final class PayssionPayway {
    private final int iconRes;
    private final String name;
    private final String payssionPayId;

    public PayssionPayway(String name, int i2, String payssionPayId) {
        s.h(name, "name");
        s.h(payssionPayId, "payssionPayId");
        this.name = name;
        this.iconRes = i2;
        this.payssionPayId = payssionPayId;
    }

    public static /* synthetic */ PayssionPayway copy$default(PayssionPayway payssionPayway, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = payssionPayway.name;
        }
        if ((i3 & 2) != 0) {
            i2 = payssionPayway.iconRes;
        }
        if ((i3 & 4) != 0) {
            str2 = payssionPayway.payssionPayId;
        }
        return payssionPayway.copy(str, i2, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.iconRes;
    }

    public final String component3() {
        return this.payssionPayId;
    }

    public final PayssionPayway copy(String name, int i2, String payssionPayId) {
        s.h(name, "name");
        s.h(payssionPayId, "payssionPayId");
        return new PayssionPayway(name, i2, payssionPayId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayssionPayway) {
            PayssionPayway payssionPayway = (PayssionPayway) obj;
            return s.c(this.name, payssionPayway.name) && this.iconRes == payssionPayway.iconRes && s.c(this.payssionPayId, payssionPayway.payssionPayId);
        }
        return false;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPayssionPayId() {
        return this.payssionPayId;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.iconRes) * 31) + this.payssionPayId.hashCode();
    }

    public String toString() {
        return "PayssionPayway(name=" + this.name + ", iconRes=" + this.iconRes + ", payssionPayId=" + this.payssionPayId + ')';
    }
}
