package us.pinguo.PGEquinox;
/* loaded from: classes3.dex */
public final class PGEquinoxProcessParamBoundrayLight extends PGEquinoxProcessParam {
    public int[] boundrayLightColor;
    public float[] fRatio;
    public float[] shiftCoord;
    public int eCoordType = 1;
    public float fWidth = 0.5f;
    public int eBoundrayType = 0;
    public float fGaussianBlurR = -1.0f;
    public float fEpsilon = -1.0f;
    public int iEpsilonMin = 15;
    public int iEpsilonMax = 15;
    public float fHeadRatio = 0.25f;
    public float fTailRatio = 0.25f;

    public PGEquinoxProcessParamBoundrayLight() {
        this.boundrayLightColor = r1;
        int[] iArr = {255, 255, 255};
        this.shiftCoord = r1;
        float[] fArr = {0.0f, 0.0f};
        this.fRatio = r0;
        float[] fArr2 = {0.05f, 0.95f, 0.25f, 0.85f};
    }
}
