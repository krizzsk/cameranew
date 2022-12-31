package com.bumptech.glide.request.f;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.bumptech.glide.request.f.f;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* compiled from: DrawableCrossFadeFactory.java */
/* loaded from: classes.dex */
public class a<T extends Drawable> implements d<T> {
    private final g<T> a;
    private final int b;
    private b<T> c;

    /* renamed from: d  reason: collision with root package name */
    private b<T> f832d;

    /* compiled from: DrawableCrossFadeFactory.java */
    /* renamed from: com.bumptech.glide.request.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0034a implements f.a {
        private final int a;

        C0034a(int i2) {
            this.a = i2;
        }

        @Override // com.bumptech.glide.request.f.f.a
        public Animation build() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(this.a);
            return alphaAnimation;
        }
    }

    public a() {
        this(IjkMediaCodecInfo.RANK_SECURE);
    }

    private c<T> b() {
        if (this.c == null) {
            this.c = new b<>(this.a.a(false, true), this.b);
        }
        return this.c;
    }

    private c<T> c() {
        if (this.f832d == null) {
            this.f832d = new b<>(this.a.a(false, false), this.b);
        }
        return this.f832d;
    }

    @Override // com.bumptech.glide.request.f.d
    public c<T> a(boolean z, boolean z2) {
        if (z) {
            return e.c();
        }
        if (z2) {
            return b();
        }
        return c();
    }

    public a(int i2) {
        this(new g(new C0034a(i2)), i2);
    }

    a(g<T> gVar, int i2) {
        this.a = gVar;
        this.b = i2;
    }
}
