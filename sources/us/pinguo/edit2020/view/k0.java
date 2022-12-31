package us.pinguo.edit2020.view;

import android.graphics.Matrix;
import android.graphics.PointF;
/* compiled from: FilterGestureView.kt */
/* loaded from: classes4.dex */
public final class k0 {

    /* renamed from: f  reason: collision with root package name */
    private float f10768f;

    /* renamed from: k  reason: collision with root package name */
    private float f10773k;

    /* renamed from: l  reason: collision with root package name */
    private float f10774l;
    private boolean m;
    private String a = "";
    private final PointF b = new PointF();
    private final PointF c = new PointF();

    /* renamed from: d  reason: collision with root package name */
    private final PointF f10766d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    private final PointF f10767e = new PointF();

    /* renamed from: g  reason: collision with root package name */
    private final Matrix f10769g = new Matrix();

    /* renamed from: h  reason: collision with root package name */
    private final Matrix f10770h = new Matrix();

    /* renamed from: i  reason: collision with root package name */
    private float f10771i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private final PointF f10772j = new PointF();

    public final float a() {
        return this.f10768f;
    }

    public final float b() {
        return this.f10771i;
    }

    public final PointF c() {
        return this.f10772j;
    }

    public final boolean d() {
        return this.m;
    }

    public final float e() {
        return this.f10774l;
    }

    public final PointF f() {
        return this.b;
    }

    public final PointF g() {
        return this.c;
    }

    public final PointF h() {
        return this.f10766d;
    }

    public final PointF i() {
        return this.f10767e;
    }

    public final float j() {
        return this.f10773k;
    }

    public final Matrix k() {
        return this.f10769g;
    }

    public final Matrix l() {
        return this.f10770h;
    }

    public final String m() {
        return this.a;
    }

    public final void n(float f2) {
        this.f10768f = f2;
    }

    public final void o(float f2) {
        this.f10771i = f2;
    }

    public final void p(boolean z) {
        this.m = z;
    }

    public final void q(float f2) {
        this.f10774l = f2;
    }

    public final void r(float f2) {
        this.f10773k = f2;
    }

    public final void s(String str) {
        kotlin.jvm.internal.s.h(str, "<set-?>");
        this.a = str;
    }
}
