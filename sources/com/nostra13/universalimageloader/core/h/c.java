package com.nostra13.universalimageloader.core.h;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
/* compiled from: ImageDecodingInfo.java */
/* loaded from: classes3.dex */
public class c {
    private final String a;
    private final String b;
    private final com.nostra13.universalimageloader.core.assist.c c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageScaleType f5964d;

    /* renamed from: e  reason: collision with root package name */
    private final ViewScaleType f5965e;

    /* renamed from: f  reason: collision with root package name */
    private final ImageDownloader f5966f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f5967g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f5968h;

    /* renamed from: i  reason: collision with root package name */
    private final BitmapFactory.Options f5969i;

    public c(String str, String str2, String str3, com.nostra13.universalimageloader.core.assist.c cVar, ViewScaleType viewScaleType, ImageDownloader imageDownloader, com.nostra13.universalimageloader.core.c cVar2) {
        this.a = str;
        this.b = str2;
        this.c = cVar;
        this.f5964d = cVar2.C();
        this.f5965e = viewScaleType;
        this.f5966f = imageDownloader;
        this.f5967g = cVar2.x();
        this.f5968h = cVar2.H();
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.f5969i = options;
        a(cVar2.u(), options);
    }

    private void a(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 10) {
            b(options, options2);
        }
        if (i2 >= 11) {
            c(options, options2);
        }
    }

    @TargetApi(10)
    private void b(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    private void c(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    public BitmapFactory.Options d() {
        return this.f5969i;
    }

    public ImageDownloader e() {
        return this.f5966f;
    }

    public Object f() {
        return this.f5967g;
    }

    public String g() {
        return this.a;
    }

    public ImageScaleType h() {
        return this.f5964d;
    }

    public String i() {
        return this.b;
    }

    public com.nostra13.universalimageloader.core.assist.c j() {
        return this.c;
    }

    public ViewScaleType k() {
        return this.f5965e;
    }

    public boolean l() {
        return this.f5968h;
    }
}
