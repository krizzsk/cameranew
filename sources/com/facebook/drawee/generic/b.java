package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.h;
import com.facebook.drawee.drawable.p;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* compiled from: GenericDraweeHierarchyBuilder.java */
/* loaded from: classes.dex */
public class b {
    public static final p.c s = p.c.f2565f;
    public static final p.c t = p.c.f2566g;
    private Resources a;
    private int b;
    private float c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Drawable f2589d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private p.c f2590e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Drawable f2591f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private p.c f2592g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Drawable f2593h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private p.c f2594i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Drawable f2595j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private p.c f2596k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private p.c f2597l;
    @Nullable
    private PointF m;
    @Nullable
    private ColorFilter n;
    @Nullable
    private Drawable o;
    @Nullable
    private List<Drawable> p;
    @Nullable
    private Drawable q;
    @Nullable
    private RoundingParams r;

    public b(Resources resources) {
        this.a = resources;
        t();
    }

    private void M() {
        List<Drawable> list = this.p;
        if (list != null) {
            for (Drawable drawable : list) {
                h.g(drawable);
            }
        }
    }

    private void t() {
        this.b = IjkMediaCodecInfo.RANK_SECURE;
        this.c = 0.0f;
        this.f2589d = null;
        p.c cVar = s;
        this.f2590e = cVar;
        this.f2591f = null;
        this.f2592g = cVar;
        this.f2593h = null;
        this.f2594i = cVar;
        this.f2595j = null;
        this.f2596k = cVar;
        this.f2597l = t;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
    }

    public static b u(Resources resources) {
        return new b(resources);
    }

    public b A(@Nullable Drawable drawable) {
        this.f2593h = drawable;
        return this;
    }

    public b B(@Nullable p.c cVar) {
        this.f2594i = cVar;
        return this;
    }

    public b C(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.p = null;
        } else {
            this.p = Arrays.asList(drawable);
        }
        return this;
    }

    public b D(int i2, @Nullable p.c cVar) {
        this.f2589d = this.a.getDrawable(i2);
        this.f2590e = cVar;
        return this;
    }

    public b E(@Nullable Drawable drawable) {
        this.f2589d = drawable;
        return this;
    }

    public b F(@Nullable p.c cVar) {
        this.f2590e = cVar;
        return this;
    }

    public b G(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.q = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.q = stateListDrawable;
        }
        return this;
    }

    public b H(@Nullable Drawable drawable) {
        this.f2595j = drawable;
        return this;
    }

    public b I(@Nullable p.c cVar) {
        this.f2596k = cVar;
        return this;
    }

    public b J(@Nullable Drawable drawable) {
        this.f2591f = drawable;
        return this;
    }

    public b K(@Nullable p.c cVar) {
        this.f2592g = cVar;
        return this;
    }

    public b L(@Nullable RoundingParams roundingParams) {
        this.r = roundingParams;
        return this;
    }

    public a a() {
        M();
        return new a(this);
    }

    @Nullable
    public ColorFilter b() {
        return this.n;
    }

    @Nullable
    public PointF c() {
        return this.m;
    }

    @Nullable
    public p.c d() {
        return this.f2597l;
    }

    @Nullable
    public Drawable e() {
        return this.o;
    }

    public float f() {
        return this.c;
    }

    public int g() {
        return this.b;
    }

    @Nullable
    public Drawable h() {
        return this.f2593h;
    }

    @Nullable
    public p.c i() {
        return this.f2594i;
    }

    @Nullable
    public List<Drawable> j() {
        return this.p;
    }

    @Nullable
    public Drawable k() {
        return this.f2589d;
    }

    @Nullable
    public p.c l() {
        return this.f2590e;
    }

    @Nullable
    public Drawable m() {
        return this.q;
    }

    @Nullable
    public Drawable n() {
        return this.f2595j;
    }

    @Nullable
    public p.c o() {
        return this.f2596k;
    }

    public Resources p() {
        return this.a;
    }

    @Nullable
    public Drawable q() {
        return this.f2591f;
    }

    @Nullable
    public p.c r() {
        return this.f2592g;
    }

    @Nullable
    public RoundingParams s() {
        return this.r;
    }

    public b v(@Nullable p.c cVar) {
        this.f2597l = cVar;
        return this;
    }

    public b w(@Nullable Drawable drawable) {
        this.o = drawable;
        return this;
    }

    public b x(float f2) {
        this.c = f2;
        return this;
    }

    public b y(int i2) {
        this.b = i2;
        return this;
    }

    public b z(int i2, @Nullable p.c cVar) {
        this.f2593h = this.a.getDrawable(i2);
        this.f2594i = cVar;
        return this;
    }
}
