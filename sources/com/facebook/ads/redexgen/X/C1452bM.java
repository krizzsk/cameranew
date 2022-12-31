package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.bM  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1452bM extends AnonymousClass57 implements AdOptionsViewApi {
    public static byte[] A03;
    public static final int A04;
    public static final int A05;
    public final ImageView A00;
    public final ImageView A01;
    public final AdOptionsView A02;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 125);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{91, 108, 121, 102, 123, 125, 41, 72, 109};
    }

    static {
        A02();
        A04 = (int) (LY.A00 * 23.0f);
        A05 = (int) (LY.A00 * 4.0f);
    }

    public C1452bM(final Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, AdOptionsView.Orientation orientation, int i2, AdOptionsView adOptionsView) {
        int i3;
        this.A02 = adOptionsView;
        final LinearLayout linearLayout = new LinearLayout(context);
        this.A02.addView(linearLayout);
        if (orientation == AdOptionsView.Orientation.HORIZONTAL) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        linearLayout.setOrientation(i3);
        this.A01 = A00(MD.DEFAULT_INFO_ICON);
        this.A00 = A00(MD.AD_CHOICES_ICON);
        this.A00.setContentDescription(A01(0, 9, 116));
        linearLayout.addView(this.A01);
        linearLayout.addView(this.A00);
        setIconSizeDp(i2);
        setIconColor(-10459280);
        final C1198Tj A0J = C1198Tj.A0J(nativeAdBase.getInternalNativeAd());
        A0J.A1Q(nativeAdLayout);
        A0J.A1S(this);
        C1543cy A0x = A0J.A0x();
        if (A0x != null && A0x.A0h() && !A0x.A0f()) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.4v
            public static String[] A04 = {"KRKQmCMMKryGk4zgpNIytFvS3TD6bAeJ", "Xc6miAmzcu08Y", "37gtSV6CsPxBYDJYgwQ03wIm04Bn1UoS", "vc4nNQQkh46pzBlyEmkoOi4CgZODKTHg", "arJKEayC0J1tSfFqlaoS22WOKdh4xl60", "Efttk19GyNCXlxxyYR0mavkkkhSaw2Qp", "IGlWio493rL8eTjetjpBhFYcUhZqKyAr", ""};

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (C0974Kn.A02(this)) {
                    return;
                }
                try {
                    A0J.A1H();
                    if (Build.VERSION.SDK_INT >= 16 && JD.A1a(context)) {
                        linearLayout.performAccessibilityAction(128, null);
                    }
                } catch (Throwable th) {
                    if (A04[5].charAt(5) == 'z') {
                        throw new RuntimeException();
                    }
                    A04[6] = "upfEaDqgYzKFHRA83M0GBorRIFZJY191";
                    C0974Kn.A00(th, this);
                }
            }
        });
        Ld.A04(this.A02, Ld.A0B);
    }

    public C1452bM(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, AdOptionsView adOptionsView) {
        this(context, nativeAdBase, nativeAdLayout, AdOptionsView.Orientation.HORIZONTAL, 23, adOptionsView);
    }

    private ImageView A00(MD md) {
        ImageView imageView = new ImageView(this.A02.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int i2 = A05;
        imageView.setPadding(i2, i2, i2, i2);
        imageView.setImageBitmap(ME.A01(md));
        return imageView;
    }

    public final void A03(MD md) {
        this.A01.setImageBitmap(ME.A01(md));
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setIconColor(int i2) {
        this.A01.setColorFilter(i2);
        this.A00.setColorFilter(i2);
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setIconSizeDp(int i2) {
        int max = Math.max(A04, (int) (LY.A00 * i2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(max, max);
        this.A01.setLayoutParams(layoutParams);
        this.A00.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass57, com.facebook.ads.internal.api.AdComponentView
    public final void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -2;
        layoutParams.height = -2;
        super.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setSingleIcon(boolean z) {
        M5.A0N(this.A01, z ? 8 : 0);
    }
}
