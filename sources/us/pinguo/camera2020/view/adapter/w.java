package us.pinguo.camera2020.view.adapter;
/* compiled from: InfiniteRecyclerViewAdapter.kt */
/* loaded from: classes3.dex */
public final class w {
    private final int a;
    private final int b;

    public w(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            return this.a == wVar.a && this.b == wVar.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "VipHalfScreenItem(imgRes=" + this.a + ", txtRes=" + this.b + ')';
    }
}
