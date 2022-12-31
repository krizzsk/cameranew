package us.pinguo.u3dengine.edit;
/* compiled from: UnityEditData.kt */
/* loaded from: classes6.dex */
public final class NativeFilterRet {
    private int height;
    private int tid;
    private int width;

    public NativeFilterRet(int i2, int i3, int i4) {
        this.tid = i2;
        this.width = i3;
        this.height = i4;
    }

    public static /* synthetic */ NativeFilterRet copy$default(NativeFilterRet nativeFilterRet, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = nativeFilterRet.tid;
        }
        if ((i5 & 2) != 0) {
            i3 = nativeFilterRet.width;
        }
        if ((i5 & 4) != 0) {
            i4 = nativeFilterRet.height;
        }
        return nativeFilterRet.copy(i2, i3, i4);
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

    public final NativeFilterRet copy(int i2, int i3, int i4) {
        return new NativeFilterRet(i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NativeFilterRet) {
            NativeFilterRet nativeFilterRet = (NativeFilterRet) obj;
            return this.tid == nativeFilterRet.tid && this.width == nativeFilterRet.width && this.height == nativeFilterRet.height;
        }
        return false;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getTid() {
        return this.tid;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((this.tid * 31) + this.width) * 31) + this.height;
    }

    public final void setHeight(int i2) {
        this.height = i2;
    }

    public final void setTid(int i2) {
        this.tid = i2;
    }

    public final void setWidth(int i2) {
        this.width = i2;
    }

    public String toString() {
        return "NativeFilterRet(tid=" + this.tid + ", width=" + this.width + ", height=" + this.height + ')';
    }
}
