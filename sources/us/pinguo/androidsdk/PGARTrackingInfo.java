package us.pinguo.androidsdk;
/* loaded from: classes3.dex */
public class PGARTrackingInfo {
    public int[] mRectData = new int[8];
    public int mStatus;

    public PGARTrackingInfo() {
        for (int i2 = 0; i2 < 8; i2++) {
            this.mRectData[i2] = 0;
        }
        this.mStatus = -2;
    }
}
