package com.pinguo.camera360.test;

import android.graphics.Point;
import java.util.List;
/* compiled from: FilterInstallTestActivity.kt */
/* loaded from: classes3.dex */
public final class r0 {
    private final String a;
    private final String b;
    private final List<Point> c;

    /* JADX WARN: Multi-variable type inference failed */
    public r0(String id, String jpgName, List<? extends Point> sizes) {
        kotlin.jvm.internal.s.h(id, "id");
        kotlin.jvm.internal.s.h(jpgName, "jpgName");
        kotlin.jvm.internal.s.h(sizes, "sizes");
        this.a = id;
        this.b = jpgName;
        this.c = sizes;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final List<Point> c() {
        return this.c;
    }
}
