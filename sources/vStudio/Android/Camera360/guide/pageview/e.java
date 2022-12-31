package vStudio.Android.Camera360.guide.pageview;

import kotlin.jvm.internal.s;
import vStudio.Android.Camera360.a;
/* compiled from: GuideModel.kt */
/* loaded from: classes7.dex */
public final class e {
    private a.InterfaceC0470a a;
    private boolean b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12623d;

    public e(a.InterfaceC0470a guideActionListener, boolean z) {
        s.h(guideActionListener, "guideActionListener");
        this.a = guideActionListener;
        this.b = z;
    }

    public final void a(String str) {
        this.a.n(2, str);
    }

    public final boolean b() {
        return this.c;
    }

    public final void c(boolean z) {
        this.c = z;
    }

    public final void d(boolean z) {
        this.f12623d = z;
    }

    public final boolean e() {
        return this.b || this.f12623d;
    }

    public final void f(String str) {
        this.c = true;
        this.a.n(16, str);
    }
}
