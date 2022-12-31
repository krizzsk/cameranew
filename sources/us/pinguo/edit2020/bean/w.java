package us.pinguo.edit2020.bean;

import us.pinguo.u3dengine.edit.HSLAdjustColor;
/* compiled from: AdjustFunction.kt */
/* loaded from: classes4.dex */
public final class w extends g {

    /* renamed from: e  reason: collision with root package name */
    private final HSLAdjustColor f10255e;

    /* renamed from: f  reason: collision with root package name */
    private final t f10256f;

    /* renamed from: g  reason: collision with root package name */
    private final t f10257g;

    /* renamed from: h  reason: collision with root package name */
    private final t f10258h;

    /* renamed from: i  reason: collision with root package name */
    private int f10259i;

    /* renamed from: j  reason: collision with root package name */
    private int f10260j;

    /* renamed from: k  reason: collision with root package name */
    private int f10261k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(int i2, HSLAdjustColor unityRenderColor, t hueGradient, t lightnessGradient, t saturationGradient) {
        super(i2, false, 0, 0);
        kotlin.jvm.internal.s.h(unityRenderColor, "unityRenderColor");
        kotlin.jvm.internal.s.h(hueGradient, "hueGradient");
        kotlin.jvm.internal.s.h(lightnessGradient, "lightnessGradient");
        kotlin.jvm.internal.s.h(saturationGradient, "saturationGradient");
        this.f10255e = unityRenderColor;
        this.f10256f = hueGradient;
        this.f10257g = lightnessGradient;
        this.f10258h = saturationGradient;
    }

    public final int g() {
        return this.f10259i;
    }

    public final int h() {
        return this.f10260j;
    }

    public final int i() {
        return this.f10261k;
    }

    public final t j() {
        return this.f10256f;
    }

    public final t k() {
        return this.f10257g;
    }

    public final t l() {
        return this.f10258h;
    }

    public final HSLAdjustColor m() {
        return this.f10255e;
    }

    public final void n(int i2) {
        this.f10259i = i2;
    }

    public final void o(int i2) {
        this.f10260j = i2;
    }

    public final void p(int i2) {
        this.f10261k = i2;
    }
}
