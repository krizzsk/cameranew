package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
/* renamed from: com.facebook.ads.redexgen.X.Ra  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1137Ra extends AbstractC05784e {
    @Nullable
    @DoNotStrip
    public QY A00;
    public QZ A01;
    @Nullable
    public QZ A02;
    public final int A03;
    public final SparseBooleanArray A04;
    public final XT A05;
    public final C07159v A06;

    public C1137Ra(C07159v c07159v, SparseBooleanArray sparseBooleanArray, QZ qz, int i2, XT xt) {
        super(c07159v);
        this.A05 = xt;
        this.A06 = c07159v;
        this.A04 = sparseBooleanArray;
        this.A01 = qz;
        this.A03 = i2;
    }

    private void A08(JT jt, C1009Lz c1009Lz, String str, PE pe) {
        if (this.A04.get(pe.A02())) {
            return;
        }
        QZ qz = this.A02;
        if (qz != null) {
            qz.A0V();
            this.A02 = null;
        }
        this.A00 = new C1139Rc(this, str, pe, jt, pe.A04(), c1009Lz);
        this.A02 = new QZ(this.A06, 10, new WeakReference(this.A00), this.A05);
        this.A02.A0Y(false);
        this.A02.A0W(100);
        this.A02.A0X(100);
        this.A06.setOnAssetsLoadedListener(new C1138Rb(this, pe));
    }

    public final void A0l(PE pe, JT jt, C7J c7j, C1009Lz c1009Lz, String str, int i2, int i3, int i4) {
        int A02 = pe.A02();
        this.A06.setTag(-1593835536, Integer.valueOf(A02));
        this.A06.setupNativeCtaExtension(pe);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i2, -2);
        int i5 = A02 == 0 ? i4 : i3;
        if (A02 < this.A03 - 1) {
            i4 = i3;
        }
        marginLayoutParams.setMargins(i5, 0, i4, 0);
        String A07 = pe.A03().A0D().A07();
        String A08 = pe.A03().A0D().A08();
        this.A06.setIsVideo(!TextUtils.isEmpty(A08));
        if (this.A06.A0i()) {
            this.A06.setVideoPlaceholderUrl(A07);
            this.A06.setVideoUrl(c7j.A0Q(A08));
        } else {
            this.A06.setImageUrl(A07);
        }
        this.A06.setLayoutParams(marginLayoutParams);
        this.A06.A0j(pe.A04());
        A08(jt, c1009Lz, str, pe);
    }

    public final void A0m(QZ qz) {
        this.A01 = qz;
    }
}
