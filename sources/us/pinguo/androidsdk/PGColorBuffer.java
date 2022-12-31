package us.pinguo.androidsdk;
/* loaded from: classes3.dex */
public class PGColorBuffer {
    private int[] argb = null;
    private int width = 0;
    private int height = 0;

    public int[] getColorBuffer() {
        return this.argb;
    }

    public int getImageHeight() {
        return this.height;
    }

    public int getImageWidth() {
        return this.width;
    }

    public void setColorBuffer(int[] iArr) {
        this.argb = iArr;
    }

    public void setImageHeight(int i2) {
        this.height = i2;
    }

    public void setImageWidth(int i2) {
        this.width = i2;
    }
}
