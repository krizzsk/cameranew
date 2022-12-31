package us.pinguo.edit2020.repository;

import java.util.ArrayList;
import kotlin.LazyThreadSafetyMode;
import kotlin.f;
import kotlin.h;
import us.pinguo.edit2020.bean.c0;
import us.pinguo.edit2020.bean.e;
import us.pinguo.edit2020.bean.m;
import us.pinguo.edit2020.bean.n;
import us.pinguo.edit2020.bean.o;
import us.pinguo.edit2020.bean.p0;
/* compiled from: EditRepository.kt */
/* loaded from: classes4.dex */
public final class EditRepository {
    private final f a;
    private final f b;
    private final f c;

    /* renamed from: d  reason: collision with root package name */
    private final f f10568d;

    /* renamed from: e  reason: collision with root package name */
    private final f f10569e;

    /* renamed from: f  reason: collision with root package name */
    private final f f10570f;

    /* renamed from: g  reason: collision with root package name */
    private final f f10571g;

    /* renamed from: h  reason: collision with root package name */
    private final f f10572h;

    /* renamed from: i  reason: collision with root package name */
    private final f f10573i;

    /* renamed from: j  reason: collision with root package name */
    private final f f10574j;

    /* renamed from: k  reason: collision with root package name */
    private final f f10575k;

    public EditRepository() {
        f a;
        f a2;
        f a3;
        f a4;
        f a5;
        f a6;
        f a7;
        f a8;
        f a9;
        f a10;
        f a11;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        a = h.a(lazyThreadSafetyMode, EditRepository$editFunctions$2.INSTANCE);
        this.a = a;
        a2 = h.a(lazyThreadSafetyMode, EditRepository$cropRateFunctions$2.INSTANCE);
        this.b = a2;
        a3 = h.a(lazyThreadSafetyMode, EditRepository$correctFunctions$2.INSTANCE);
        this.c = a3;
        a4 = h.a(lazyThreadSafetyMode, new EditRepository$cropFunctions$2(this));
        this.f10568d = a4;
        a5 = h.a(lazyThreadSafetyMode, EditRepository$cropFunctionsName$2.INSTANCE);
        this.f10569e = a5;
        a6 = h.a(lazyThreadSafetyMode, EditRepository$eliminationFuncs$2.INSTANCE);
        this.f10570f = a6;
        a7 = h.a(lazyThreadSafetyMode, EditRepository$manualMattingFunctions$2.INSTANCE);
        this.f10571g = a7;
        a8 = h.a(lazyThreadSafetyMode, EditRepository$advancedStickerFunctions$2.INSTANCE);
        this.f10572h = a8;
        a9 = h.a(lazyThreadSafetyMode, EditRepository$blendTypeList$2.INSTANCE);
        this.f10573i = a9;
        a10 = h.a(lazyThreadSafetyMode, EditRepository$backgroundBlurLensCustomizeFunctions$2.INSTANCE);
        this.f10574j = a10;
        a11 = h.a(lazyThreadSafetyMode, EditRepository$backgroundBlurAdjustFunctions$2.INSTANCE);
        this.f10575k = a11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<m> g() {
        return (ArrayList) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<m> j() {
        return (ArrayList) this.b.getValue();
    }

    public final ArrayList<p0> c() {
        return (ArrayList) this.f10572h.getValue();
    }

    public final ArrayList<c0> d() {
        return (ArrayList) this.f10575k.getValue();
    }

    public final ArrayList<e> e() {
        return (ArrayList) this.f10574j.getValue();
    }

    public final ArrayList<us.pinguo.edit2020.model.f.a> f() {
        return (ArrayList) this.f10573i.getValue();
    }

    public final ArrayList<ArrayList<m>> h() {
        return (ArrayList) this.f10568d.getValue();
    }

    public final ArrayList<Integer> i() {
        return (ArrayList) this.f10569e.getValue();
    }

    public final ArrayList<n> k() {
        return (ArrayList) this.a.getValue();
    }

    public final ArrayList<o> l() {
        return (ArrayList) this.f10570f.getValue();
    }

    public final ArrayList<c0> m() {
        return (ArrayList) this.f10571g.getValue();
    }
}
