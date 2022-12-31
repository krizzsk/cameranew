package us.pinguo.edit2020.controller;

import android.content.Context;
import android.graphics.PointF;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.MagnifierLayout;
import us.pinguo.edit2020.view.MagnifierView;
import us.pinguo.edit2020.view.NumberTipView;
import us.pinguo.edit2020.view.ShapeDirectionView;
import us.pinguo.edit2020.viewmodel.module.EditBeautyModule;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SkinRefreshController.kt */
/* loaded from: classes4.dex */
public final class SkinRefreshController$initView$1 extends Lambda implements kotlin.jvm.b.l<us.pinguo.edit2020.bean.i, kotlin.u> {
    final /* synthetic */ SkinRefreshController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SkinRefreshController.kt */
    /* renamed from: us.pinguo.edit2020.controller.SkinRefreshController$initView$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements kotlin.jvm.b.a<kotlin.u> {
        AnonymousClass1(Object obj) {
            super(0, obj, SkinRefreshController.class, "onRemoveStart", "onRemoveStart()V", 0);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((SkinRefreshController) this.receiver).a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SkinRefreshController.kt */
    /* renamed from: us.pinguo.edit2020.controller.SkinRefreshController$initView$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements kotlin.jvm.b.a<kotlin.u> {
        AnonymousClass2(Object obj) {
            super(0, obj, SkinRefreshController.class, "onRemoveEnd", "onRemoveEnd()V", 0);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((SkinRefreshController) this.receiver).Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SkinRefreshController.kt */
    /* renamed from: us.pinguo.edit2020.controller.SkinRefreshController$initView$1$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements kotlin.jvm.b.a<kotlin.u> {
        AnonymousClass3(Object obj) {
            super(0, obj, SkinRefreshController.class, "onRemoveStart", "onRemoveStart()V", 0);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((SkinRefreshController) this.receiver).a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SkinRefreshController.kt */
    /* renamed from: us.pinguo.edit2020.controller.SkinRefreshController$initView$1$4  reason: invalid class name */
    /* loaded from: classes4.dex */
    public /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements kotlin.jvm.b.a<kotlin.u> {
        AnonymousClass4(Object obj) {
            super(0, obj, SkinRefreshController.class, "onRemoveEnd", "onRemoveEnd()V", 0);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((SkinRefreshController) this.receiver).Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SkinRefreshController.kt */
    /* renamed from: us.pinguo.edit2020.controller.SkinRefreshController$initView$1$5  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass5 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
        final /* synthetic */ us.pinguo.edit2020.bean.i $it;
        final /* synthetic */ SkinRefreshController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(SkinRefreshController skinRefreshController, us.pinguo.edit2020.bean.i iVar) {
            super(0);
            this.this$0 = skinRefreshController;
            this.$it = iVar;
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.f10417d.q0(this.$it.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkinRefreshController$initView$1(SkinRefreshController skinRefreshController) {
        super(1);
        this.this$0 = skinRefreshController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(us.pinguo.edit2020.bean.i iVar) {
        invoke2(iVar);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(us.pinguo.edit2020.bean.i iVar) {
        us.pinguo.edit2020.view.c0 c0Var;
        String str;
        String str2;
        String str3;
        us.pinguo.edit2020.view.m0 m0Var;
        int i2;
        int i3;
        String str4;
        us.pinguo.edit2020.view.m0 m0Var2;
        this.this$0.f10417d.x0(null);
        this.this$0.f10417d.w0(null);
        ((NumberTipView) this.this$0.b.findViewById(R.id.numberTipView)).a();
        if (iVar == null) {
            this.this$0.f10417d.o0(BasicBrushMode.Erasing);
            this.this$0.m0(0.9f, 20);
            return;
        }
        this.this$0.f0(iVar);
        kotlin.jvm.b.l<us.pinguo.edit2020.bean.x, kotlin.u> L = this.this$0.L();
        if (L != null) {
            L.invoke(iVar);
        }
        this.this$0.c0(iVar);
        this.this$0.d0();
        this.this$0.P(iVar);
        c0Var = this.this$0.c;
        c0Var.F(iVar.j());
        String f2 = iVar.f();
        str = this.this$0.f10425l;
        if (kotlin.jvm.internal.s.c(f2, str)) {
            if (iVar.j()) {
                this.this$0.f10417d.b(iVar.f());
                EditBeautyModule editBeautyModule = this.this$0.f10417d;
                BasicBrushMode basicBrushMode = BasicBrushMode.Brush;
                editBeautyModule.o0(basicBrushMode);
                this.this$0.f10417d.n0(basicBrushMode, this.this$0.f10417d.K().get(this.this$0.f10417d.L()).floatValue());
                ConstraintLayout constraintLayout = this.this$0.b;
                int i4 = R.id.handShapeView;
                ((ShapeDirectionView) constraintLayout.findViewById(i4)).setIndicatorSize(this.this$0.f10417d.O());
                ((MagnifierView) ((MagnifierLayout) this.this$0.b.findViewById(R.id.flMagnifier)).a(R.id.magnifierView)).setSize(this.this$0.f10417d.O());
                us.pinguo.edit2020.manager.g gVar = us.pinguo.edit2020.manager.g.a;
                if (kotlin.jvm.internal.s.c(gVar.a(), Boolean.FALSE)) {
                    gVar.b(null);
                    us.pinguo.foundation.utils.k0.a.a(R.string.skin_manual_qudou_toast);
                } else {
                    Context b = us.pinguo.foundation.e.b();
                    kotlin.jvm.internal.s.g(b, "getAppContext()");
                    ((ShapeDirectionView) this.this$0.b.findViewById(i4)).m(new PointF(us.pinguo.util.h.i(b) / 2.0f, ((FrameLayout) this.this$0.b.findViewById(R.id.unityContainer)).getHeight() / 2.0f));
                }
                this.this$0.f10417d.x0(new AnonymousClass1(this.this$0));
                this.this$0.f10417d.w0(new AnonymousClass2(this.this$0));
                m0Var2 = this.this$0.x;
                m0Var2.h(iVar.g().getCurrentValue());
                this.this$0.n0(iVar.f());
                return;
            }
            EditBeautyModule editBeautyModule2 = this.this$0.f10417d;
            str4 = this.this$0.n;
            editBeautyModule2.b(str4);
            this.this$0.f10417d.q0(iVar.g());
            kotlin.jvm.b.l<Boolean, kotlin.u> U = this.this$0.U();
            if (U == null) {
                return;
            }
            U.invoke(Boolean.valueOf(iVar.g().getNeedFace()));
        } else if (iVar.j()) {
            EditBeautyModule editBeautyModule3 = this.this$0.f10417d;
            BasicBrushMode basicBrushMode2 = BasicBrushMode.Brush;
            editBeautyModule3.o0(basicBrushMode2);
            kotlin.jvm.b.l<Boolean, kotlin.u> U2 = this.this$0.U();
            if (U2 != null) {
                U2.invoke(Boolean.FALSE);
            }
            this.this$0.f10417d.b(iVar.f());
            EditBeautyModule editBeautyModule4 = this.this$0.f10417d;
            EditBeautyModule editBeautyModule5 = this.this$0.f10417d;
            us.pinguo.edit2020.bean.i I = this.this$0.I();
            editBeautyModule4.n0(basicBrushMode2, editBeautyModule5.u(I == null ? null : I.f()));
            ConstraintLayout constraintLayout2 = this.this$0.b;
            int i5 = R.id.handShapeView;
            ShapeDirectionView shapeDirectionView = (ShapeDirectionView) constraintLayout2.findViewById(i5);
            EditBeautyModule editBeautyModule6 = this.this$0.f10417d;
            us.pinguo.edit2020.bean.i I2 = this.this$0.I();
            shapeDirectionView.setIndicatorSize(editBeautyModule6.r(I2 == null ? null : I2.f()));
            MagnifierView magnifierView = (MagnifierView) ((MagnifierLayout) this.this$0.b.findViewById(R.id.flMagnifier)).a(R.id.magnifierView);
            EditBeautyModule editBeautyModule7 = this.this$0.f10417d;
            us.pinguo.edit2020.bean.i I3 = this.this$0.I();
            magnifierView.setSize(editBeautyModule7.r(I3 != null ? I3.f() : null));
            Context b2 = us.pinguo.foundation.e.b();
            kotlin.jvm.internal.s.g(b2, "getAppContext()");
            ((ShapeDirectionView) this.this$0.b.findViewById(i5)).m(new PointF(us.pinguo.util.h.i(b2) / 2.0f, ((FrameLayout) this.this$0.b.findViewById(R.id.unityContainer)).getHeight() / 2.0f));
            String f3 = iVar.f();
            str3 = this.this$0.m;
            if (kotlin.jvm.internal.s.c(f3, str3)) {
                UnityEditCaller.Brush brush = UnityEditCaller.Brush.INSTANCE;
                i2 = this.this$0.s;
                i3 = this.this$0.s;
                brush.setBrushMaskHighlightColor(i2, i3);
                brush.setSoftSkinMaskViewOpacity(0.5f);
                this.this$0.f10417d.x0(new AnonymousClass3(this.this$0));
                this.this$0.f10417d.w0(new AnonymousClass4(this.this$0));
            } else {
                UnityEditCaller.Brush.INSTANCE.setSoftSkinMaskViewOpacity(0.0f);
            }
            m0Var = this.this$0.x;
            m0Var.h(iVar.g().getCurrentValue());
            this.this$0.n0(iVar.f());
        } else {
            EditBeautyModule editBeautyModule8 = this.this$0.f10417d;
            str2 = this.this$0.n;
            editBeautyModule8.b(str2);
            kotlin.jvm.b.l<Boolean, kotlin.u> U3 = this.this$0.U();
            if (U3 != null) {
                U3.invoke(Boolean.valueOf(iVar.g().getNeedFace()));
            }
            this.this$0.f10417d.q0(iVar.g());
            this.this$0.f10417d.c0(new AnonymousClass5(this.this$0, iVar));
        }
    }
}
