package us.pinguo.u3dengine.api;
/* compiled from: UnityDataObject.kt */
/* loaded from: classes6.dex */
public final class FilterInfo {
    private String basePath;
    private String lut1;
    private String lut2;
    private int lutCount;
    private float opacity;

    public final String getBasePath() {
        return this.basePath;
    }

    public final String getLut1() {
        return this.lut1;
    }

    public final String getLut2() {
        return this.lut2;
    }

    public final int getLutCount() {
        return this.lutCount;
    }

    public final float getOpacity() {
        return this.opacity;
    }

    public final void setBasePath(String str) {
        this.basePath = str;
    }

    public final void setLut1(String str) {
        this.lut1 = str;
    }

    public final void setLut2(String str) {
        this.lut2 = str;
    }

    public final void setLutCount(int i2) {
        this.lutCount = i2;
    }

    public final void setOpacity(float f2) {
        this.opacity = f2;
    }
}
