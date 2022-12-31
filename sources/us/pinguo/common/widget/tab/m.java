package us.pinguo.common.widget.tab;
/* compiled from: TabIndicatorOffsetModel.kt */
/* loaded from: classes4.dex */
public final class m {
    private final int a;
    private final int b;

    public m(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            return this.a == mVar.a && this.b == mVar.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "TabIndicatorOffsetModel(position=" + this.a + ", offset=" + this.b + ')';
    }
}
