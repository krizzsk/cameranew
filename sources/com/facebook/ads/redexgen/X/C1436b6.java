package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdsManager;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.b6  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1436b6 extends AbstractC05342m {
    public static String[] A02 = {"f2MNSWDlL1YMuTPGOAjONPZtO", "cmMTh0pUaJ1RDNo0mFNR3IJYAK2Mf6gB", "4dFqjoT4qnH4w96CQtkjoCAuJyqtgp11", "6XB3g70NG5Gd02gyy8Ab40YcxuzvQEqb", "wwGHlt0jZwPrQfekoFOvLm8zPwbBrmxC", "1Rqxvwj8Vs8GuK5", "NKSqZWGd9qA279w", "7JvmemziLS26U2JKZlqSRSAl5nA0imSt"};
    public List<NativeAd> A00 = new ArrayList();
    public final /* synthetic */ C5G A01;

    public C1436b6(C5G c5g) {
        this.A01 = c5g;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05342m
    public final int A05() {
        return this.A00.size();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05342m
    public final int A06(Object obj) {
        int indexOf = this.A00.indexOf(obj);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05342m
    public final Object A08(ViewGroup viewGroup, int i2) {
        NativeAdScrollView.AdViewProvider adViewProvider;
        NativeAdView.Type type;
        XT xt;
        NativeAdViewAttributes nativeAdViewAttributes;
        View render;
        XT xt2;
        NativeAdView.Type type2;
        NativeAdViewAttributes nativeAdViewAttributes2;
        NativeAdScrollView.AdViewProvider adViewProvider2;
        adViewProvider = this.A01.A01;
        if (adViewProvider != null) {
            adViewProvider2 = this.A01.A01;
            List<NativeAd> list = this.A00;
            String[] strArr = A02;
            if (strArr[7].charAt(19) == strArr[4].charAt(19)) {
                throw new RuntimeException();
            }
            A02[2] = "d9x9bMDlXKa90r8XaToMTFuUxNqAoP43";
            render = adViewProvider2.createView(list.get(i2), i2);
        } else {
            type = this.A01.A02;
            if (type != null) {
                xt2 = this.A01.A06;
                type2 = this.A01.A02;
                nativeAdViewAttributes2 = this.A01.A03;
                render = NativeAdView.render(xt2, this.A00.get(i2), type2, nativeAdViewAttributes2);
            } else {
                xt = this.A01.A06;
                nativeAdViewAttributes = this.A01.A03;
                render = NativeAdView.render(xt, this.A00.get(i2), nativeAdViewAttributes);
            }
        }
        viewGroup.addView(render);
        return render;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05342m
    public final void A0B(ViewGroup viewGroup, int i2, Object obj) {
        NativeAdScrollView.AdViewProvider adViewProvider;
        NativeAdScrollView.AdViewProvider adViewProvider2;
        if (i2 < this.A00.size()) {
            adViewProvider = this.A01.A01;
            if (adViewProvider != null) {
                adViewProvider2 = this.A01.A01;
                adViewProvider2.destroyView(this.A00.get(i2), (View) obj);
            } else {
                List<NativeAd> list = this.A00;
                if (A02[0].length() != 25) {
                    throw new RuntimeException();
                }
                A02[0] = "BErMlyrXrYPfhoDWoAGZwiXdk";
                list.get(i2).unregisterView();
            }
        }
        viewGroup.removeView((View) obj);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05342m
    public final boolean A0C(View view, Object obj) {
        return view == obj;
    }

    public final void A0D() {
        int i2;
        NativeAdsManager nativeAdsManager;
        NativeAdsManager nativeAdsManager2;
        this.A00.clear();
        i2 = this.A01.A00;
        nativeAdsManager = this.A01.A04;
        int min = Math.min(i2, nativeAdsManager.getUniqueNativeAdCount());
        for (int i3 = 0; i3 < min; i3++) {
            nativeAdsManager2 = this.A01.A04;
            NativeAd nextNativeAd = nativeAdsManager2.nextNativeAd();
            C1198Tj.A0J(nextNativeAd.getInternalNativeAd()).A1Y(true);
            this.A00.add(nextNativeAd);
        }
        A09();
    }
}
