package us.pinguo.blockbuster.lib.domain.struct;

import us.pinguo.blockbuster.BlockBuster;
/* loaded from: classes3.dex */
public class BoundrayLightStruct extends Struct {
    public int[] boundrayLightColor;
    public String eBoundrayType;
    public String eCoordType;
    public float[] fRatio;
    public float[] shiftCoord;
    public float fWidth = 0.5f;
    public float fGaussianBlurR = -1.0f;
    public float fEpsilon = -1.0f;
    public int iEpsilonMin = 15;
    public int iEpsilonMax = 15;
    public float fHeadRatio = 0.25f;
    public float fTailRatio = 0.25f;

    public BoundrayLightStruct() {
        this.boundrayLightColor = r1;
        int[] iArr = {255, 255, 255};
        this.shiftCoord = r1;
        float[] fArr = {0.0f, 0.0f};
        this.fRatio = r0;
        float[] fArr2 = {0.05f, 0.95f, 0.25f, 0.85f};
    }

    public int geteBoundrayType() {
        String str = this.eBoundrayType;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 1251368125:
                if (str.equals("PORTRAIT_THIN")) {
                    c = 0;
                    break;
                }
                break;
            case 1511893915:
                if (str.equals("PORTRAIT")) {
                    c = 1;
                    break;
                }
                break;
            case 1827114037:
                if (str.equals("PORTRAIT_4SECTION")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 2;
            default:
                return BlockBuster.INVALID;
        }
    }

    public int geteCoordType() {
        String str = this.eCoordType;
        str.hashCode();
        if (str.equals("PIXEL")) {
            return 0;
        }
        if (str.equals("EYELEN")) {
            return 1;
        }
        return BlockBuster.INVALID;
    }
}
