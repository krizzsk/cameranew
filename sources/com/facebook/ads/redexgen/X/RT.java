package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
/* loaded from: assets/audience_network.dex */
public final class RT extends AbstractC05784e {
    public static String[] A0A = {"av2tITPhYKbVn20ukUfJR25ELbcgjHbj", "MLeLe181lhP7dC21QqjxU1VDKV9lNkzJ", "XUmY4VBJ2tlJWKlPJ7YkBdCsKtcC", "bK6oHsXedskfaWsjnVeS6YyvP0sRA20b", "BhCeFQN4dHt9z3MLE3p7bnIzhrf86Cw8", "mLW9T0fP2Q5Hob07hRXsv0QUH1fN4", "pNzPXZ5fcby2PvmlRsfUzns43oHDF5Mi", "3YktW7BrcDIc4Xw2f2zdWv5xFETbHIAE"};
    @DoNotStrip
    public QY A00;
    public QZ A01;
    @Nullable
    public QZ A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final SparseBooleanArray A07;
    public final XT A08;
    public final AbstractC07069m A09;

    public RT(AbstractC07069m abstractC07069m, SparseBooleanArray sparseBooleanArray, QZ qz, int i2, int i3, int i4, int i5, XT xt) {
        super(abstractC07069m);
        this.A08 = xt;
        this.A09 = abstractC07069m;
        this.A07 = sparseBooleanArray;
        this.A01 = qz;
        this.A03 = i2;
        this.A04 = i3;
        this.A05 = i4;
        this.A06 = i5;
    }

    private void A08(JT jt, C1009Lz c1009Lz, String str, PE pe) {
        if (this.A07.get(pe.A02())) {
            return;
        }
        QZ qz = this.A02;
        if (qz != null) {
            qz.A0V();
            if (A0A[4].charAt(16) != 'E') {
                throw new RuntimeException();
            }
            A0A[4] = "iteeE4SnfkkyQnEAEqI0za4snrHpWaXy";
            this.A02 = null;
        }
        this.A00 = new RV(this, str, pe, jt, pe.A04(), c1009Lz);
        this.A02 = new QZ(this.A09, 10, new WeakReference(this.A00), this.A08);
        this.A02.A0Y(false);
        this.A02.A0W(100);
        this.A02.A0X(100);
        this.A09.setOnAssetsLoadedListener(new RU(this, pe));
    }

    public final void A0l(PE pe, JT jt, C7J c7j, C1009Lz c1009Lz, String videoUrl) {
        int A02 = pe.A02();
        this.A09.setTag(-1593835536, Integer.valueOf(A02));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.A03, -2);
        marginLayoutParams.setMargins(A02 == 0 ? this.A04 : this.A05, 0, A02 >= this.A06 + (-1) ? this.A04 : this.A05, 0);
        String A07 = pe.A03().A0D().A07();
        String A08 = pe.A03().A0D().A08();
        this.A09.setIsVideo(!TextUtils.isEmpty(A08));
        if (this.A09.A0i()) {
            this.A09.setVideoPlaceholderUrl(A07);
            this.A09.setVideoUrl(c7j.A0Q(A08));
        } else {
            this.A09.setImageUrl(A07);
        }
        this.A09.setLayoutParams(marginLayoutParams);
        this.A09.setAdTitleAndDescription(pe.A03().A0E().A06(), pe.A03().A0E().A01());
        this.A09.setCTAInfo(pe.A03().A0F(), pe.A04());
        this.A09.A0k(pe.A04());
        A08(jt, c1009Lz, videoUrl, pe);
    }
}
