package us.pinguo.edit2020.viewmodel.module;

import kotlin.jvm.b.t;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.bean.j;
import us.pinguo.edit2020.bean.l0;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: EditBlurringModule.kt */
/* loaded from: classes4.dex */
final class EditBlurringModule$functions$2 extends Lambda implements t<Boolean, j, Float, Float, Float, Float, u> {
    public static final EditBlurringModule$functions$2 INSTANCE = new EditBlurringModule$functions$2();

    EditBlurringModule$functions$2() {
        super(6);
    }

    @Override // kotlin.jvm.b.t
    public /* bridge */ /* synthetic */ u invoke(Boolean bool, j jVar, Float f2, Float f3, Float f4, Float f5) {
        invoke(bool.booleanValue(), jVar, f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue());
        return u.a;
    }

    public final void invoke(boolean z, j func, float f2, float f3, float f4, float f5) {
        s.h(func, "func");
        l0 l2 = func.l();
        if (!z) {
            UnityEditCaller.Blur.updateBlurStrength(func.k() / func.i());
        }
        UnityEditCaller.Blur.updateBlurBaseInfos(z ? 4 : 2, l2.m(), (l2.e() - ((f4 - f2) * 0.5f)) / f2, 1 - ((l2.f() - ((f5 - f3) * 0.5f)) / f3), 0.0f, 0.0f, 0.0f, 0.0f, l2.g(), l2.h());
    }
}
