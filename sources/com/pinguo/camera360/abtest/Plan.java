package com.pinguo.camera360.abtest;

import kotlin.jvm.internal.o;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: ABTestDataModel.kt */
/* loaded from: classes3.dex */
public final class Plan implements NoProguard {
    private final String gid;
    private final String gname;
    private final String tid;
    private Float value;

    public Plan(String str, String str2, Float f2, String str3) {
        this.gname = str;
        this.gid = str2;
        this.value = f2;
        this.tid = str3;
        this.value = Float.valueOf(0.0f);
    }

    public final String getGid() {
        return this.gid;
    }

    public final String getGname() {
        return this.gname;
    }

    public final String getTid() {
        return this.tid;
    }

    public final Float getValue() {
        return this.value;
    }

    public final boolean isOK() {
        return this.gid != null;
    }

    public final void setValue(Float f2) {
        this.value = f2;
    }

    public /* synthetic */ Plan(String str, String str2, Float f2, String str3, int i2, o oVar) {
        this(str, str2, (i2 & 4) != 0 ? Float.valueOf(0.0f) : f2, str3);
    }
}
