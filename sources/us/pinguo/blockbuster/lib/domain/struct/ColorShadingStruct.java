package us.pinguo.blockbuster.lib.domain.struct;
/* loaded from: classes3.dex */
public class ColorShadingStruct extends Struct {
    public int[][] cColor;
    public String eShadingDirection;
    public String eShadingType;
    public float[] fCutPoint;
    public int iColorNum;

    public int[] getCColor() {
        int[][] iArr = this.cColor;
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = this.cColor;
            if (i2 >= iArr2.length) {
                break;
            }
            i3 += iArr2[i2].length;
            i2++;
        }
        int[] iArr3 = new int[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < this.cColor.length; i5++) {
            int i6 = 0;
            while (true) {
                int[][] iArr4 = this.cColor;
                if (i6 < iArr4[i5].length) {
                    iArr3[i4] = iArr4[i5][i6];
                    i6++;
                    i4++;
                }
            }
        }
        return iArr3;
    }
}
