package us.pinguo.ui.widget;
/* compiled from: MultiStateImageTextView.kt */
/* loaded from: classes6.dex */
final class k {
    private final int a;
    private final int b;
    private final int c;

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            return this.a == kVar.a && this.b == kVar.b && this.c == kVar.c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public String toString() {
        return "State(imageRes=" + this.a + ", textRes=" + this.b + ", textStyleRes=" + this.c + ')';
    }
}
