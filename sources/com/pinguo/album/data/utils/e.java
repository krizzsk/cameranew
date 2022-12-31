package com.pinguo.album.data.utils;

import android.util.DisplayMetrics;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: PGAlbumSizeManager.java */
/* loaded from: classes3.dex */
public class e {
    private static int a = 640;
    private static int b = 480;
    private static int c = 120;

    /* renamed from: d  reason: collision with root package name */
    private static int f6028d = 6291456;

    /* renamed from: e  reason: collision with root package name */
    private static int f6029e = 6291456;

    /* renamed from: f  reason: collision with root package name */
    private static int f6030f = 6291456;

    public static int a() {
        return f6030f;
    }

    public static int b() {
        return f6029e;
    }

    public static int c() {
        return f6028d;
    }

    public static int d() {
        return c;
    }

    public static int e() {
        return b;
    }

    public static int f() {
        return a;
    }

    public static void g(DisplayMetrics displayMetrics) {
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        if (min >= 1600) {
            a = 1080;
            b = 720;
            c = 480;
        } else if (min >= 1000) {
            a = 720;
            b = VideoEdit2Activity.MIN_SCALED_SIZE;
            c = 320;
        } else if (min >= 720) {
            a = VideoEdit2Activity.MIN_SCALED_SIZE;
            b = 480;
            c = 200;
        } else {
            a = 480;
            b = 320;
            c = InspirePublishFragment.MAX_DESC_COUNT;
        }
        int i2 = c;
        f6028d = i2 * i2 * 4 * 60;
        int i3 = b;
        f6030f = i3 * i3 * 4 * 3;
        int i4 = a;
        f6029e = i4 * i4 * 4 * 3;
        d.f.a.b.d.d("POOL_SQUARE_SIZE:" + f6028d + ",POOL_MISC_SIZE:" + f6030f + ",POOL_PHOTO_SIZE:" + f6029e, new Object[0]);
    }
}
