package com.google.ads;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.ads.AdSize;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes.dex */
public final class a {
    public static final a b = new a(-1, -2, "mb");
    public static final a c = new a(320, 50, "mb");

    /* renamed from: d  reason: collision with root package name */
    public static final a f3310d = new a(IjkMediaCodecInfo.RANK_SECURE, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "as");

    /* renamed from: e  reason: collision with root package name */
    public static final a f3311e = new a(468, 60, "as");

    /* renamed from: f  reason: collision with root package name */
    public static final a f3312f = new a(728, 90, "as");

    /* renamed from: g  reason: collision with root package name */
    public static final a f3313g = new a(160, 600, "as");
    private final AdSize a;

    public a(AdSize adSize) {
        this.a = adSize;
    }

    public final int a() {
        return this.a.getHeight();
    }

    public final int b() {
        return this.a.getWidth();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.a.equals(((a) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString();
    }

    private a(int i2, int i3, String str) {
        this(new AdSize(i2, i3));
    }
}
