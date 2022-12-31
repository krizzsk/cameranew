package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import com.facebook.imagepipeline.common.c;
import javax.annotation.Nullable;
/* compiled from: ImageDecodeOptionsBuilder.java */
/* loaded from: classes.dex */
public class c<T extends c> {
    private int a = 100;
    private int b = Integer.MAX_VALUE;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2709d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2710e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2711f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap.Config f2712g;

    /* renamed from: h  reason: collision with root package name */
    private Bitmap.Config f2713h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private com.facebook.imagepipeline.decoder.b f2714i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private com.facebook.imagepipeline.h.a f2715j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ColorSpace f2716k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2717l;

    public c() {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        this.f2712g = config;
        this.f2713h = config;
    }

    public b a() {
        return new b(this);
    }

    public Bitmap.Config b() {
        return this.f2713h;
    }

    public Bitmap.Config c() {
        return this.f2712g;
    }

    @Nullable
    public com.facebook.imagepipeline.h.a d() {
        return this.f2715j;
    }

    @Nullable
    public ColorSpace e() {
        return this.f2716k;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b f() {
        return this.f2714i;
    }

    public boolean g() {
        return this.f2710e;
    }

    public boolean h() {
        return this.c;
    }

    public boolean i() {
        return this.f2717l;
    }

    public boolean j() {
        return this.f2711f;
    }

    public int k() {
        return this.b;
    }

    public int l() {
        return this.a;
    }

    public boolean m() {
        return this.f2709d;
    }
}
