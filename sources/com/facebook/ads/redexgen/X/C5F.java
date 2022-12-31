package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.VideoAutoplayBehavior;
import com.facebook.ads.internal.api.NativeAdApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.5F  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5F implements NativeAdApi {
    public static String[] A02 = {"mRGpAzErj1xKeHc9WkF3Ujy7h38joZC8", "9wVKpObP8FA1o7oyYWhkpjh48o8VAcWp", "pz3BbJjT9xlHe4B2EghGg76rolJKqfV", "txN8wQ5fkL3IFh565s3Q1NMKA4RH7CNr", "KrzK51p50C2Qp4g1XOaXdDfTUeF", "0wnkiGzVks6qBKMatIgqU8hY2PaKlPy", "GWxCKnjCJrIvVlnjjEtvZJVKWYpK", "UfKYcBFUD7Ap"};
    public final NativeAd A00;
    public final NativeAdBaseApi A01;

    public C5F(NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        this.A00 = nativeAd;
        this.A01 = nativeAdBaseApi;
        C1198Tj.A0J(nativeAdBaseApi).A1W(K9.A05);
    }

    public C5F(NativeAdBase nativeAdBase, NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        this.A00 = nativeAd;
        this.A01 = nativeAdBaseApi;
    }

    private C1198Tj A00() {
        return C1198Tj.A0J(this.A01);
    }

    @Nullable
    public final String A01() {
        return A00().A1D();
    }

    @Nullable
    public final String A02() {
        return A00().A1E();
    }

    @Nullable
    public final List<NativeAd> A03() {
        if (A00().A1G() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (C1198Tj c1198Tj : A00().A1G()) {
            arrayList.add(new NativeAd(c1198Tj.A10(), c1198Tj));
        }
        return arrayList;
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final NativeAd.AdCreativeType getAdCreativeType() {
        if (!TextUtils.isEmpty(A00().A1E())) {
            return NativeAd.AdCreativeType.VIDEO;
        }
        if (A00().A1G() != null && !A00().A1G().isEmpty()) {
            return NativeAd.AdCreativeType.CAROUSEL;
        }
        if (A00().getAdCoverImage() != null && !TextUtils.isEmpty(A00().getAdCoverImage().getUrl())) {
            NativeAd.AdCreativeType adCreativeType = NativeAd.AdCreativeType.IMAGE;
            String[] strArr = A02;
            if (strArr[7].length() != strArr[6].length()) {
                String[] strArr2 = A02;
                strArr2[7] = "AqlRmswAejgv";
                strArr2[6] = "RNgsy314kOszGsZ2llWC7eCbS6WS";
                return adCreativeType;
            }
            throw new RuntimeException();
        }
        return NativeAd.AdCreativeType.UNKNOWN;
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final VideoAutoplayBehavior getVideoAutoplayBehavior() {
        return EnumC0958Jw.A00(A00().A16());
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView) {
        registerViewForInteraction(view, mediaView, (MediaView) null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable ImageView imageView) {
        registerViewForInteraction(view, mediaView, imageView, (List<View>) null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable ImageView imageView, @Nullable List<View> list) {
        if (imageView != null) {
            XT A10 = A00().A10();
            XT A022 = AnonymousClass59.A02(imageView.getContext());
            A022.A0F(A10);
            C1198Tj.A0g(A00().getAdIcon(), imageView, A022);
        }
        registerViewForInteraction(view, mediaView, (MediaView) null, list);
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable MediaView mediaView2) {
        registerViewForInteraction(view, mediaView, mediaView2, (List<View>) null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable MediaView mediaView2, @Nullable List<View> list) {
        if (mediaView != null) {
            ((C1438b8) mediaView.getMediaViewApi()).A0H(this.A00);
        }
        if (mediaView2 != null) {
            ((C1438b8) mediaView2.getMediaViewApi()).A0I(this.A01, false);
        }
        if (list != null) {
            A00().A1N(view, mediaView, list);
            return;
        }
        C1198Tj A00 = A00();
        if (A02[4].length() == 7) {
            throw new RuntimeException();
        }
        A02[1] = "MBrHnoNt0t7c904xRN41qBo9Q6s9Di6J";
        A00.A1M(view, mediaView);
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable List<View> list) {
        registerViewForInteraction(view, mediaView, (MediaView) null, list);
    }
}
