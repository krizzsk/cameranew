package us.pinguo.edit2020.viewmodel.module;

import java.util.ArrayList;
import kotlin.jvm.b.l;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.bean.LongLegMode;
import us.pinguo.edit2020.bean.b0;
import us.pinguo.edit2020.bean.u0;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.foundation.utils.i;
import us.pinguo.repository2020.R;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: EditLongLegModule.kt */
/* loaded from: classes4.dex */
public final class EditLongLegModule {

    /* renamed from: e  reason: collision with root package name */
    public static final a f10861e = new a(null);
    private final EditRender a;
    private final ArrayList<b0> b;
    private b0 c;

    /* renamed from: d  reason: collision with root package name */
    private l<? super Boolean, u> f10862d;

    /* compiled from: EditLongLegModule.kt */
    /* renamed from: us.pinguo.edit2020.viewmodel.module.EditLongLegModule$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends Lambda implements q<Float, Float, Integer, u> {
        final /* synthetic */ b0 $heightenFunc;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(b0 b0Var) {
            super(3);
            this.$heightenFunc = b0Var;
        }

        @Override // kotlin.jvm.b.q
        public /* bridge */ /* synthetic */ u invoke(Float f2, Float f3, Integer num) {
            invoke(f2.floatValue(), f3.floatValue(), num.intValue());
            return u.a;
        }

        public final void invoke(float f2, float f3, int i2) {
            float f4;
            if (this.$heightenFunc.k() == LongLegMode.Vertical) {
                f4 = (this.$heightenFunc.j() / 100.0f) * 0.15f;
            } else {
                f4 = -((this.$heightenFunc.j() / 100.0f) * 0.15f);
            }
            UnityEditCaller.BodyBeautify.INSTANCE.updateBodyBeautifyTool(this.$heightenFunc.g() / f2, (f3 - this.$heightenFunc.h()) / f3, this.$heightenFunc.o() / f2, this.$heightenFunc.i() / f3, 0.0f, f4, i2, 10);
        }
    }

    /* compiled from: EditLongLegModule.kt */
    /* renamed from: us.pinguo.edit2020.viewmodel.module.EditLongLegModule$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass2 extends Lambda implements q<Float, Float, Integer, u> {
        final /* synthetic */ b0 $thinFunc;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(b0 b0Var) {
            super(3);
            this.$thinFunc = b0Var;
        }

        @Override // kotlin.jvm.b.q
        public /* bridge */ /* synthetic */ u invoke(Float f2, Float f3, Integer num) {
            invoke(f2.floatValue(), f3.floatValue(), num.intValue());
            return u.a;
        }

        public final void invoke(float f2, float f3, int i2) {
            u0 value = EditLongLegModule.this.d().L().getValue();
            if (value == null) {
                return;
            }
            b0 b0Var = this.$thinFunc;
            float f4 = 2;
            UnityEditCaller.BodyBeautify.INSTANCE.updateBodyBeautifyTool(((b0Var.g() - ((value.h() - value.e()) / f4)) - value.a()) / value.e(), (value.d() - ((b0Var.h() - ((value.g() - value.d()) / f4)) + value.b())) / value.d(), b0Var.o() / value.e(), b0Var.i() / value.d(), b0Var.m(), (b0Var.j() / 100.0f) * 0.2f, 0, 34);
        }
    }

    /* compiled from: EditLongLegModule.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final boolean a() {
            return i.c();
        }
    }

    public EditLongLegModule(EditRender editRender) {
        s.h(editRender, "editRender");
        this.a = editRender;
        ArrayList<b0> arrayList = new ArrayList<>(2);
        this.b = arrayList;
        String string = us.pinguo.foundation.e.b().getString(R.string.long_leg_heighten);
        s.g(string, "getAppContext().getStrin…string.long_leg_heighten)");
        int i2 = R.drawable.ic_icon_heighten_leg;
        a aVar = f10861e;
        b0 b0Var = new b0("heightening", string, i2, aVar.a(), LongLegMode.Vertical);
        b0Var.v(new AnonymousClass1(b0Var));
        String string2 = us.pinguo.foundation.e.b().getString(R.string.long_leg_stovepip);
        s.g(string2, "getAppContext().getStrin…string.long_leg_stovepip)");
        b0 b0Var2 = new b0("manual_narrowing", string2, R.drawable.ic_icon_thin_leg, aVar.a(), LongLegMode.Free);
        b0Var2.v(new AnonymousClass2(b0Var2));
        arrayList.add(b0Var);
        arrayList.add(b0Var2);
    }

    public final void a() {
        UnityEditCaller.BodyBeautify.INSTANCE.mergeCurrentBodyBeatifyEffect();
        b0 b0Var = this.c;
        if (b0Var == null) {
            return;
        }
        b0Var.r(true);
    }

    public final void b(boolean z) {
        this.a.n1(z);
    }

    public final b0 c() {
        return this.c;
    }

    public final EditRender d() {
        return this.a;
    }

    public final ArrayList<b0> e() {
        return this.b;
    }

    public final ArrayList<b0> f() {
        return this.b;
    }

    public final void g(boolean z) {
        this.c = null;
        this.a.s0(null);
        for (b0 b0Var : this.b) {
            b0Var.r(false);
            b0Var.t(0);
            b0Var.w(0.0f);
        }
        this.b.get(0).u(LongLegMode.Vertical);
        UnityEditCaller.BodyBeautify bodyBeautify = UnityEditCaller.BodyBeautify.INSTANCE;
        bodyBeautify.setBodyBeautifyEffectIsApplied(z ? 1 : 0);
        bodyBeautify.requestBodyBeatifyEffectStatus();
    }

    public final void h(b0 b0Var) {
        this.c = b0Var;
        if (b0Var != null) {
            UnityEditCaller.BodyBeautify.INSTANCE.setCurrentBodyBeautifyMode(b0Var.k().getValue());
        }
    }

    public final void i(l<? super Boolean, u> lVar) {
        this.f10862d = lVar;
    }
}
