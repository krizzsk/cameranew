package d.i.a.a;

import android.graphics.Color;
/* compiled from: ColorGradient.java */
/* loaded from: classes3.dex */
public class a {
    private int a;
    private int[] b;
    private int[] c;

    public a(int i2, int i3, int i4) {
        this.a = i4;
        this.b = b(i2);
        this.c = b(i3);
    }

    private int[] b(int i2) {
        return new int[]{Color.alpha(i2), Color.red(i2), Color.green(i2), Color.blue(i2)};
    }

    public int a(int i2) {
        int[] iArr = new int[4];
        int i3 = 0;
        while (true) {
            int[] iArr2 = this.c;
            if (i3 < iArr2.length) {
                int[] iArr3 = this.b;
                iArr[i3] = (int) (iArr3[i3] + ((((iArr2[i3] - iArr3[i3]) * 1.0d) / this.a) * i2));
                i3++;
            } else {
                return Color.argb(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
        }
    }
}
