package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Rb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1138Rb implements OW {
    public static String[] A02 = {"z07VqEjGvJ", "HVUavbLQzawZdZVBJZvs2mdfMmVurwko", "OXCJr9QWCT6iNhGP7b2SKXpA8jzUGtxO", "XfWPaMhvYm", "d0mI5Otk4DkPTVLBqA06pYB2qhxVYO4x", "4lS6eLthtLYEvbxsvILcFz16jeQVP", "9TNy9PrFUeRgfy9Rk5pKZK4U", "r8zM3TRfMT7OJmVxj71ND5jlCBdKG"};
    public final /* synthetic */ PE A00;
    public final /* synthetic */ C1137Ra A01;

    public C1138Rb(C1137Ra c1137Ra, PE pe) {
        this.A01 = c1137Ra;
        this.A00 = pe;
    }

    @Override // com.facebook.ads.redexgen.X.OW
    public final void A9r() {
        QZ qz;
        QZ qz2;
        QZ qz3;
        if (this.A00.A02() == 0) {
            qz3 = this.A01.A01;
            String[] strArr = A02;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "rJocaZsUv9";
            strArr2[6] = "3nzpDtzjz9tePwbisyAfJiul";
            qz3.A0U();
        }
        qz = this.A01.A02;
        if (qz != null) {
            qz2 = this.A01.A02;
            qz2.A0U();
        }
    }
}
