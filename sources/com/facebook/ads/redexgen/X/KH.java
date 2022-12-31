package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.S2SRewardedVideoAdListener;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class KH implements S2SRewardedVideoAdListener {
    public static byte[] A08;
    public static String[] A09 = {"ERTXJLrBuVvZX", "UTGwSJBCAszmvg0Znuy2qQWepe5s3fqM", "XY7nx1q2aLzME12z5GaZxf04lM87T", "M", "VCMRMH9YawAvJ0pBtyC5iwlbjX7sgPEv", "UItMcFDfBKLMMqn8GhO3yPavd4WFpW4U", "gFEyeP0A6kxHrH35Jv4TBqO8F9qv0kpu", "CLK1gwWa8r8Wc"};
    @Nullable
    public AdError A00;
    @Nullable
    public Boolean A01;
    @Nullable
    public Boolean A02;
    @Nullable
    public Integer A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 10);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{-87, -91, -75, -71, 113, -92, -89, -94, -90, -81, -84, -90, -82, -88, -89, -126, 126, -114, -110, 74, 125, Byte.MIN_VALUE, 123, -120, -117, 125, Byte.MIN_VALUE, -127, Byte.MIN_VALUE, -69, -73, -57, -53, -125, -71, -74, -55, -74, -88, -92, -76, -72, 112, -89, -76, -76, -79, -76, -95, -91, -79, -90, -89, -93, -97, -81, -77, 107, -94, -81, -81, -84, -81, -100, -86, -94, -80, -80, -98, -92, -94, -28, -32, -16, -12, -84, -25, -21, -18, -16, -29, -15, -15, -25, -19, -20, -35, -22, -19, -27, -27, -29, -30, -76, -80, -64, -60, 124, -64, -77, -63, -61, -70, -62, -97, -101, -85, -81, 103, -85, -98, -80, -102, -85, -99, -98, -99, -104, -81, -94, -99, -98, -88, -104, -100, -91, -88, -84, -98, -99, -93, -97, -81, -77, 107, -81, -94, -76, -98, -81, -95, -94, -95, -100, -77, -90, -95, -94, -84, -100, -96, -84, -86, -83, -87, -94, -79, -94, -95, 118, 114, -126, -122, 62, -125, 117, -126, -122, 117, -126, 111, -126, 117, -121, 113, -126, 116, 111, -126, 117, -125, -123, 124, -124};
        if (A09[1].length() == 28) {
            throw new RuntimeException();
        }
        String[] strArr = A09;
        strArr[0] = "QzdUdmfCBDZ8u";
        strArr[3] = "N";
    }

    static {
        A01();
    }

    public KH(Intent intent) {
        this(intent == null ? null : intent.getBundleExtra(A00(29, 9, 75)));
    }

    public KH(@Nullable Bundle bundle) {
        this.A01 = null;
        this.A00 = null;
        this.A05 = false;
        this.A04 = false;
        this.A06 = false;
        this.A07 = false;
        this.A02 = null;
        if (bundle != null) {
            String A00 = A00(93, 11, 68);
            if (bundle.containsKey(A00)) {
                this.A03 = Integer.valueOf(bundle.getInt(A00));
            }
            String A002 = A00(15, 14, 18);
            if (bundle.containsKey(A002)) {
                this.A01 = Boolean.valueOf(bundle.getBoolean(A002));
            }
            String A003 = A00(38, 15, 56);
            if (bundle.containsKey(A003)) {
                this.A00 = new AdError(bundle.getInt(A003, 0), bundle.getString(A00(53, 18, 51), A00(0, 0, 22)));
            }
            this.A05 = bundle.getBoolean(A00(71, 22, 116), false);
            this.A04 = bundle.getBoolean(A00(0, 15, 57), false);
            this.A06 = bundle.getBoolean(A00(104, 26, 47), false);
            this.A07 = bundle.getBoolean(A00(130, 29, 51), false);
            String A004 = A00(159, 25, 6);
            if (bundle.containsKey(A004)) {
                this.A02 = Boolean.valueOf(bundle.getBoolean(A004));
            }
        }
    }

    @Nullable
    public final Boolean A02() {
        return this.A02;
    }

    @Nullable
    public final Integer A03() {
        return this.A03;
    }

    public final boolean A04() {
        return this.A07;
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdClicked(com.facebook.ads.Ad ad) {
        this.A04 = true;
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdLoaded(com.facebook.ads.Ad ad) {
        this.A01 = true;
    }

    @Override // com.facebook.ads.AdListener
    public final void onError(com.facebook.ads.Ad ad, AdError adError) {
        this.A01 = false;
        this.A00 = adError;
    }

    @Override // com.facebook.ads.AdListener
    public final void onLoggingImpression(com.facebook.ads.Ad ad) {
        this.A05 = true;
    }

    @Override // com.facebook.ads.S2SRewardedVideoAdListener
    public final void onRewardServerFailed() {
        this.A02 = false;
    }

    @Override // com.facebook.ads.S2SRewardedVideoAdListener
    public final void onRewardServerSuccess() {
        this.A02 = true;
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public final void onRewardedVideoClosed() {
        this.A06 = true;
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public final void onRewardedVideoCompleted() {
        this.A07 = true;
    }
}
