package vStudio.Android.Camera360.guide.pageview;
/* compiled from: GuideImageControl.kt */
/* loaded from: classes7.dex */
public final class d {
    private int a;
    private int b;

    public d(int i2, int i3) {
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
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.a == dVar.a && this.b == dVar.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "GuideImageModel(guideImage=" + this.a + ", guideTextImage=" + this.b + ')';
    }
}
