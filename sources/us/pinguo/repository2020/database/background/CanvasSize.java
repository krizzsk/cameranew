package us.pinguo.repository2020.database.background;

import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundDetail.kt */
/* loaded from: classes6.dex */
public final class CanvasSize implements NoProguard {

    /* renamed from: h  reason: collision with root package name */
    private final int f11837h;
    private final int w;

    public CanvasSize(int i2, int i3) {
        this.w = i2;
        this.f11837h = i3;
    }

    public static /* synthetic */ CanvasSize copy$default(CanvasSize canvasSize, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = canvasSize.w;
        }
        if ((i4 & 2) != 0) {
            i3 = canvasSize.f11837h;
        }
        return canvasSize.copy(i2, i3);
    }

    public final int component1() {
        return this.w;
    }

    public final int component2() {
        return this.f11837h;
    }

    public final CanvasSize copy(int i2, int i3) {
        return new CanvasSize(i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CanvasSize) {
            CanvasSize canvasSize = (CanvasSize) obj;
            return this.w == canvasSize.w && this.f11837h == canvasSize.f11837h;
        }
        return false;
    }

    public final int getH() {
        return this.f11837h;
    }

    public final int getW() {
        return this.w;
    }

    public int hashCode() {
        return (this.w * 31) + this.f11837h;
    }

    public String toString() {
        return "CanvasSize(w=" + this.w + ", h=" + this.f11837h + ')';
    }
}
