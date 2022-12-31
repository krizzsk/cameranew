package us.pinguo.edit2020.bean;

import android.graphics.Bitmap;
/* compiled from: ImageRestorationInfo.kt */
/* loaded from: classes4.dex */
public final class z {
    private final Bitmap a;
    private boolean b;

    public z(Bitmap bitmap, boolean z) {
        this.a = bitmap;
        this.b = z;
    }

    public final Bitmap a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final void c(boolean z) {
        this.b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            return kotlin.jvm.internal.s.c(this.a, zVar.a) && this.b == zVar.b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Bitmap bitmap = this.a;
        int hashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
        boolean z = this.b;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "ImageRestorationInfo(faceBitmap=" + this.a + ", isSelected=" + this.b + ')';
    }
}
