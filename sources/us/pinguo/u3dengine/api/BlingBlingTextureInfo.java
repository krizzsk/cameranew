package us.pinguo.u3dengine.api;

import kotlin.jvm.internal.o;
/* compiled from: UnityMethodData.kt */
/* loaded from: classes6.dex */
public final class BlingBlingTextureInfo {
    private volatile int height;
    private volatile int maxCount;
    private volatile int tid;
    private volatile int width;

    public BlingBlingTextureInfo() {
        this(0, 0, 0, 0, 15, null);
    }

    public BlingBlingTextureInfo(int i2, int i3, int i4, int i5) {
        this.tid = i2;
        this.width = i3;
        this.height = i4;
        this.maxCount = i5;
    }

    public static /* synthetic */ BlingBlingTextureInfo copy$default(BlingBlingTextureInfo blingBlingTextureInfo, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = blingBlingTextureInfo.tid;
        }
        if ((i6 & 2) != 0) {
            i3 = blingBlingTextureInfo.width;
        }
        if ((i6 & 4) != 0) {
            i4 = blingBlingTextureInfo.height;
        }
        if ((i6 & 8) != 0) {
            i5 = blingBlingTextureInfo.maxCount;
        }
        return blingBlingTextureInfo.copy(i2, i3, i4, i5);
    }

    public final int component1() {
        return this.tid;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final int component4() {
        return this.maxCount;
    }

    public final BlingBlingTextureInfo copy(int i2, int i3, int i4, int i5) {
        return new BlingBlingTextureInfo(i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlingBlingTextureInfo) {
            BlingBlingTextureInfo blingBlingTextureInfo = (BlingBlingTextureInfo) obj;
            return this.tid == blingBlingTextureInfo.tid && this.width == blingBlingTextureInfo.width && this.height == blingBlingTextureInfo.height && this.maxCount == blingBlingTextureInfo.maxCount;
        }
        return false;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final int getTid() {
        return this.tid;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((this.tid * 31) + this.width) * 31) + this.height) * 31) + this.maxCount;
    }

    public final void setHeight(int i2) {
        this.height = i2;
    }

    public final void setMaxCount(int i2) {
        this.maxCount = i2;
    }

    public final void setTid(int i2) {
        this.tid = i2;
    }

    public final void setWidth(int i2) {
        this.width = i2;
    }

    public String toString() {
        return "BlingBlingTextureInfo(tid=" + this.tid + ", width=" + this.width + ", height=" + this.height + ", maxCount=" + this.maxCount + ')';
    }

    public /* synthetic */ BlingBlingTextureInfo(int i2, int i3, int i4, int i5, int i6, o oVar) {
        this((i6 & 1) != 0 ? -1 : i2, (i6 & 2) != 0 ? -1 : i3, (i6 & 4) != 0 ? -1 : i4, (i6 & 8) != 0 ? -1 : i5);
    }
}
