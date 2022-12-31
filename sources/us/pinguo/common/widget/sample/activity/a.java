package us.pinguo.common.widget.sample.activity;
/* compiled from: TestRecyclerAdapter.kt */
/* loaded from: classes4.dex */
public final class a {
    private final int a;
    private final int b;

    public a(int i2, int i3) {
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
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "Test(imgRes=" + this.a + ", nameRes=" + this.b + ')';
    }
}
