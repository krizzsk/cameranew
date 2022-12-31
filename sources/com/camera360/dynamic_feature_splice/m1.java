package com.camera360.dynamic_feature_splice;

import android.graphics.RectF;
/* compiled from: SpliceUtils.kt */
/* loaded from: classes8.dex */
public final class m1 {
    private final String a;
    private final int b;
    private final RectF c;

    public m1(String path, int i2, RectF rectF) {
        kotlin.jvm.internal.s.h(path, "path");
        this.a = path;
        this.b = i2;
        this.c = rectF;
    }

    public final int a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final RectF c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m1) {
            m1 m1Var = (m1) obj;
            return kotlin.jvm.internal.s.c(this.a, m1Var.a) && this.b == m1Var.b && kotlin.jvm.internal.s.c(this.c, m1Var.c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b) * 31;
        RectF rectF = this.c;
        return hashCode + (rectF == null ? 0 : rectF.hashCode());
    }

    public String toString() {
        return "SpliceInfoItem(path=" + this.a + ", angle=" + this.b + ", rectF=" + this.c + ')';
    }
}
