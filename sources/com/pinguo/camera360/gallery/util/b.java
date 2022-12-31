package com.pinguo.camera360.gallery.util;
/* compiled from: GalleryDeleteUtil.kt */
/* loaded from: classes3.dex */
public final class b {
    private final int a;
    private final boolean b;

    public b(int i2, boolean z) {
        this.a = i2;
        this.b = z;
    }

    public final int a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i2 = this.a * 31;
        boolean z = this.b;
        int i3 = z;
        if (z != 0) {
            i3 = 1;
        }
        return i2 + i3;
    }

    public String toString() {
        return "DeleteSourceWrapper(id=" + this.a + ", isVideo=" + this.b + ')';
    }
}
