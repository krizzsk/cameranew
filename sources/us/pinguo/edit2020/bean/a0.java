package us.pinguo.edit2020.bean;

import android.graphics.PointF;
/* compiled from: ManualMattingFunction.kt */
/* loaded from: classes4.dex */
public final class a0 {
    private PointF a;
    private PointF b;

    public a0(PointF size, PointF center) {
        kotlin.jvm.internal.s.h(size, "size");
        kotlin.jvm.internal.s.h(center, "center");
        this.a = size;
        this.b = center;
    }

    public final PointF a() {
        return this.b;
    }

    public final PointF b() {
        return this.a;
    }

    public final void c(PointF size, PointF center) {
        kotlin.jvm.internal.s.h(size, "size");
        kotlin.jvm.internal.s.h(center, "center");
        this.a = size;
        this.b = center;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a0) {
            a0 a0Var = (a0) obj;
            return kotlin.jvm.internal.s.c(this.a, a0Var.a) && kotlin.jvm.internal.s.c(this.b, a0Var.b);
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "ItemSizeInfoModel(size=" + this.a + ", center=" + this.b + ')';
    }
}
