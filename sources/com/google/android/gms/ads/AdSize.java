package com.google.android.gms.ads;

import android.content.Context;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzvs;
import com.google.android.gms.internal.ads.zzwr;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private final int a;
    private final int b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3437d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3438e;

    /* renamed from: f  reason: collision with root package name */
    private int f3439f;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(IjkMediaCodecInfo.RANK_SECURE, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "300x250_as");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize INVALID = new AdSize(0, 0, "invalid");
    public static final AdSize zzacx = new AdSize(50, 50, "50x50_mb");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AdSize(int r5, int r6) {
        /*
            r4 = this;
            r0 = -1
            if (r5 != r0) goto L6
            java.lang.String r0 = "FULL"
            goto La
        L6:
            java.lang.String r0 = java.lang.String.valueOf(r5)
        La:
            r1 = -2
            if (r6 != r1) goto L10
            java.lang.String r1 = "AUTO"
            goto L14
        L10:
            java.lang.String r1 = java.lang.String.valueOf(r6)
        L14:
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 4
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r0)
            java.lang.String r0 = "x"
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = "_as"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r4.<init>(r5, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    public static AdSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(Context context, int i2) {
        AdSize zza = zzaza.zza(context, i2, 50, 0);
        zza.f3437d = true;
        return zza;
    }

    @Deprecated
    public static AdSize getCurrentOrientationBannerAdSizeWithWidth(Context context, int i2) {
        return getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, i2);
    }

    public static AdSize getCurrentOrientationInlineAdaptiveBannerAdSize(Context context, int i2) {
        int zzg = zzaza.zzg(context, 0);
        if (zzg == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i2, 0);
        adSize.f3439f = zzg;
        adSize.f3438e = true;
        return adSize;
    }

    public static AdSize getLandscapeAnchoredAdaptiveBannerAdSize(Context context, int i2) {
        AdSize zza = zzaza.zza(context, i2, 50, 2);
        zza.f3437d = true;
        return zza;
    }

    @Deprecated
    public static AdSize getLandscapeBannerAdSizeWithWidth(Context context, int i2) {
        return getLandscapeAnchoredAdaptiveBannerAdSize(context, i2);
    }

    public static AdSize getLandscapeInlineAdaptiveBannerAdSize(Context context, int i2) {
        int zzg = zzaza.zzg(context, 2);
        AdSize adSize = new AdSize(i2, 0);
        if (zzg == -1) {
            return INVALID;
        }
        adSize.f3439f = zzg;
        adSize.f3438e = true;
        return adSize;
    }

    public static AdSize getPortraitAnchoredAdaptiveBannerAdSize(Context context, int i2) {
        AdSize zza = zzaza.zza(context, i2, 50, 1);
        zza.f3437d = true;
        return zza;
    }

    @Deprecated
    public static AdSize getPortraitBannerAdSizeWithWidth(Context context, int i2) {
        return getPortraitAnchoredAdaptiveBannerAdSize(context, i2);
    }

    public static AdSize getPortraitInlineAdaptiveBannerAdSize(Context context, int i2) {
        int zzg = zzaza.zzg(context, 1);
        AdSize adSize = new AdSize(i2, 0);
        if (zzg == -1) {
            return INVALID;
        }
        adSize.f3439f = zzg;
        adSize.f3438e = true;
        return adSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        this.f3438e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return this.f3437d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        return this.f3438e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int d() {
        return this.f3439f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(int i2) {
        this.f3439f = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AdSize) {
            AdSize adSize = (AdSize) obj;
            return this.a == adSize.a && this.b == adSize.b && this.c.equals(adSize.c);
        }
        return false;
    }

    public final int getHeight() {
        return this.b;
    }

    public final int getHeightInPixels(Context context) {
        int i2 = this.b;
        if (i2 == -4 || i2 == -3) {
            return -1;
        }
        if (i2 != -2) {
            zzwr.zzqn();
            return zzaza.zze(context, this.b);
        }
        return zzvs.zzc(context.getResources().getDisplayMetrics());
    }

    public final int getWidth() {
        return this.a;
    }

    public final int getWidthInPixels(Context context) {
        int i2 = this.a;
        if (i2 == -4 || i2 == -3) {
            return -1;
        }
        if (i2 != -1) {
            zzwr.zzqn();
            return zzaza.zze(context, this.a);
        }
        return zzvs.zzb(context.getResources().getDisplayMetrics());
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final boolean isAutoHeight() {
        return this.b == -2;
    }

    public final boolean isFluid() {
        return this.a == -3 && this.b == -4;
    }

    public final boolean isFullWidth() {
        return this.a == -1;
    }

    public final String toString() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdSize(int i2, int i3, String str) {
        if (i2 < 0 && i2 != -1 && i2 != -3) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Invalid width for AdSize: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } else if (i3 < 0 && i3 != -2 && i3 != -4) {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("Invalid height for AdSize: ");
            sb2.append(i3);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            this.a = i2;
            this.b = i3;
            this.c = str;
        }
    }
}
