package us.pinguo.repository2020.database.background;

import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundDetail.kt */
/* loaded from: classes6.dex */
public final class DisplayRect implements NoProguard {

    /* renamed from: h  reason: collision with root package name */
    private final int f11839h;
    private final int w;
    private final int x;
    private final int y;

    public DisplayRect(int i2, int i3, int i4, int i5) {
        this.x = i2;
        this.y = i3;
        this.w = i4;
        this.f11839h = i5;
    }

    public static /* synthetic */ DisplayRect copy$default(DisplayRect displayRect, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = displayRect.x;
        }
        if ((i6 & 2) != 0) {
            i3 = displayRect.y;
        }
        if ((i6 & 4) != 0) {
            i4 = displayRect.w;
        }
        if ((i6 & 8) != 0) {
            i5 = displayRect.f11839h;
        }
        return displayRect.copy(i2, i3, i4, i5);
    }

    public final int component1() {
        return this.x;
    }

    public final int component2() {
        return this.y;
    }

    public final int component3() {
        return this.w;
    }

    public final int component4() {
        return this.f11839h;
    }

    public final DisplayRect copy(int i2, int i3, int i4, int i5) {
        return new DisplayRect(i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DisplayRect) {
            DisplayRect displayRect = (DisplayRect) obj;
            return this.x == displayRect.x && this.y == displayRect.y && this.w == displayRect.w && this.f11839h == displayRect.f11839h;
        }
        return false;
    }

    public final int getH() {
        return this.f11839h;
    }

    public final int getW() {
        return this.w;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public int hashCode() {
        return (((((this.x * 31) + this.y) * 31) + this.w) * 31) + this.f11839h;
    }

    public String toString() {
        return "DisplayRect(x=" + this.x + ", y=" + this.y + ", w=" + this.w + ", h=" + this.f11839h + ')';
    }
}
