package us.pinguo.edit2020.controller;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.MagnifierLayout;
import us.pinguo.edit2020.view.MagnifierView;
import us.pinguo.edit2020.view.ShapeDirectionView;
import us.pinguo.edit2020.viewmodel.module.EditBeautyModule;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.ui.widget.StickySeekBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditBottomTabBeautyController.kt */
/* loaded from: classes4.dex */
public final class EditBottomTabBeautyController$createSkinRefreshView$3 extends Lambda implements kotlin.jvm.b.l<us.pinguo.edit2020.bean.n0, kotlin.u> {
    final /* synthetic */ EditBottomTabBeautyController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditBottomTabBeautyController.kt */
    /* renamed from: us.pinguo.edit2020.controller.EditBottomTabBeautyController$createSkinRefreshView$3$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements kotlin.jvm.b.a<kotlin.u> {
        AnonymousClass1(Object obj) {
            super(0, obj, EditBottomTabBeautyController.class, "onRemoveStart", "onRemoveStart()V", 0);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((EditBottomTabBeautyController) this.receiver).c1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditBottomTabBeautyController.kt */
    /* renamed from: us.pinguo.edit2020.controller.EditBottomTabBeautyController$createSkinRefreshView$3$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements kotlin.jvm.b.a<kotlin.u> {
        AnonymousClass2(Object obj) {
            super(0, obj, EditBottomTabBeautyController.class, "onRemoveEnd", "onRemoveEnd()V", 0);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((EditBottomTabBeautyController) this.receiver).a1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditBottomTabBeautyController.kt */
    /* renamed from: us.pinguo.edit2020.controller.EditBottomTabBeautyController$createSkinRefreshView$3$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements kotlin.jvm.b.a<kotlin.u> {
        AnonymousClass3(Object obj) {
            super(0, obj, EditBottomTabBeautyController.class, "onRemoveStart", "onRemoveStart()V", 0);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((EditBottomTabBeautyController) this.receiver).c1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditBottomTabBeautyController.kt */
    /* renamed from: us.pinguo.edit2020.controller.EditBottomTabBeautyController$createSkinRefreshView$3$4  reason: invalid class name */
    /* loaded from: classes4.dex */
    public /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements kotlin.jvm.b.a<kotlin.u> {
        AnonymousClass4(Object obj) {
            super(0, obj, EditBottomTabBeautyController.class, "onRemoveEnd", "onRemoveEnd()V", 0);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((EditBottomTabBeautyController) this.receiver).a1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBottomTabBeautyController$createSkinRefreshView$3(EditBottomTabBeautyController editBottomTabBeautyController) {
        super(1);
        this.this$0 = editBottomTabBeautyController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(us.pinguo.edit2020.bean.n0 n0Var) {
        invoke2(n0Var);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(us.pinguo.edit2020.bean.n0 n0Var) {
        String str;
        String str2;
        String str3;
        kotlin.jvm.b.l lVar;
        us.pinguo.edit2020.view.m0 m0Var;
        kotlin.jvm.b.l lVar2;
        int i2;
        int i3;
        this.this$0.c.y(StickySeekBar.DefaultDotStyle.CIRCLE);
        us.pinguo.edit2020.view.c0 c0Var = this.this$0.c;
        str = this.this$0.L;
        c0Var.B(Color.parseColor(str));
        this.this$0.f10326e.x0(null);
        this.this$0.f10326e.w0(null);
        if (n0Var == null) {
            this.this$0.f10326e.o0(BasicBrushMode.Erasing);
            us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
            us.pinguo.edit2020.bean.n0 s = this.this$0.f10326e.s();
            iVar.l0(s != null ? s.f() : null, "erase");
            this.this$0.B1(0.9f, 20);
            return;
        }
        this.this$0.f10326e.p0(n0Var);
        us.pinguo.foundation.statistics.h.b.l0(n0Var.f(), "click");
        EditBeautyModule editBeautyModule = this.this$0.f10326e;
        BasicBrushMode basicBrushMode = BasicBrushMode.Brush;
        editBeautyModule.o0(basicBrushMode);
        String f2 = n0Var.f();
        str2 = this.this$0.A;
        if (kotlin.jvm.internal.s.c(f2, str2)) {
            RelativeLayout relativeLayout = (RelativeLayout) this.this$0.c.g().findViewById(R.id.flSeekBar);
            kotlin.jvm.internal.s.g(relativeLayout, "bottomOperationController.container.flSeekBar");
            relativeLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(relativeLayout, 4);
            this.this$0.W0(true);
            this.this$0.f10326e.n0(basicBrushMode, this.this$0.f10326e.K().get(this.this$0.f10326e.L()).floatValue());
            ConstraintLayout constraintLayout = this.this$0.b;
            int i4 = R.id.handShapeView;
            ((ShapeDirectionView) constraintLayout.findViewById(i4)).setIndicatorSize(this.this$0.f10326e.O());
            ((MagnifierView) ((MagnifierLayout) this.this$0.b.findViewById(R.id.flMagnifier)).a(R.id.magnifierView)).setSize(this.this$0.f10326e.O());
            us.pinguo.edit2020.view.c0 c0Var2 = this.this$0.c;
            String string = us.pinguo.foundation.e.b().getString(R.string.brush_size);
            kotlin.jvm.internal.s.g(string, "getAppContext().getString(R.string.brush_size)");
            c0Var2.A(string);
            us.pinguo.edit2020.manager.g gVar = us.pinguo.edit2020.manager.g.a;
            if (kotlin.jvm.internal.s.c(gVar.a(), Boolean.FALSE)) {
                gVar.b(null);
                us.pinguo.foundation.utils.k0.a.a(R.string.skin_manual_qudou_toast);
            } else {
                Context b = us.pinguo.foundation.e.b();
                kotlin.jvm.internal.s.g(b, "getAppContext()");
                ((ShapeDirectionView) this.this$0.b.findViewById(i4)).m(new PointF(us.pinguo.util.h.i(b) / 2.0f, ((FrameLayout) this.this$0.b.findViewById(R.id.unityContainer)).getHeight() / 2.0f));
            }
            this.this$0.f10326e.x0(new AnonymousClass1(this.this$0));
            this.this$0.f10326e.w0(new AnonymousClass2(this.this$0));
        } else {
            this.this$0.W0(false);
            EditBeautyModule editBeautyModule2 = this.this$0.f10326e;
            EditBeautyModule editBeautyModule3 = this.this$0.f10326e;
            us.pinguo.edit2020.bean.n0 s2 = this.this$0.f10326e.s();
            editBeautyModule2.n0(basicBrushMode, editBeautyModule3.u(s2 == null ? null : s2.f()));
            ConstraintLayout constraintLayout2 = this.this$0.b;
            int i5 = R.id.handShapeView;
            ShapeDirectionView shapeDirectionView = (ShapeDirectionView) constraintLayout2.findViewById(i5);
            EditBeautyModule editBeautyModule4 = this.this$0.f10326e;
            us.pinguo.edit2020.bean.n0 s3 = this.this$0.f10326e.s();
            shapeDirectionView.setIndicatorSize(editBeautyModule4.r(s3 == null ? null : s3.f()));
            MagnifierView magnifierView = (MagnifierView) ((MagnifierLayout) this.this$0.b.findViewById(R.id.flMagnifier)).a(R.id.magnifierView);
            EditBeautyModule editBeautyModule5 = this.this$0.f10326e;
            us.pinguo.edit2020.bean.n0 s4 = this.this$0.f10326e.s();
            magnifierView.setSize(editBeautyModule5.r(s4 != null ? s4.f() : null));
            Context b2 = us.pinguo.foundation.e.b();
            kotlin.jvm.internal.s.g(b2, "getAppContext()");
            ((ShapeDirectionView) this.this$0.b.findViewById(i5)).m(new PointF(us.pinguo.util.h.i(b2) / 2.0f, ((FrameLayout) this.this$0.b.findViewById(R.id.unityContainer)).getHeight() / 2.0f));
        }
        String f3 = n0Var.f();
        str3 = this.this$0.D;
        if (kotlin.jvm.internal.s.c(f3, str3)) {
            UnityEditCaller.Brush brush = UnityEditCaller.Brush.INSTANCE;
            i2 = this.this$0.K;
            i3 = this.this$0.K;
            brush.setBrushMaskHighlightColor(i2, i3);
            brush.setSoftSkinMaskViewOpacity(0.5f);
            this.this$0.f10326e.x0(new AnonymousClass3(this.this$0));
            this.this$0.f10326e.w0(new AnonymousClass4(this.this$0));
        } else {
            UnityEditCaller.Brush.INSTANCE.setSoftSkinMaskViewOpacity(0.0f);
        }
        this.this$0.f10326e.b(n0Var.f());
        us.pinguo.edit2020.view.c0 c0Var3 = this.this$0.c;
        String string2 = us.pinguo.foundation.e.b().getString(R.string.qiangdu);
        kotlin.jvm.internal.s.g(string2, "getAppContext().getString(R.string.qiangdu)");
        c0Var3.A(string2);
        this.this$0.c.x(true);
        lVar = this.this$0.G;
        if (lVar != null) {
            lVar.invoke(n0Var);
        }
        this.this$0.c.I(n0Var.g().getMinValue(), n0Var.g().getMaxValue(), n0Var.g().getCurrentValue(), n0Var.g().getDefaultValue());
        m0Var = this.this$0.S;
        m0Var.h(n0Var.g().getCurrentValue());
        lVar2 = this.this$0.F;
        if (lVar2 != null) {
            lVar2.invoke(Boolean.valueOf(n0Var.g().getNeedFace()));
        }
        us.pinguo.edit2020.bean.n0 s5 = this.this$0.f10326e.s();
        if (s5 == null) {
            return;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) this.this$0.b.findViewById(R.id.flSeekBar);
        kotlin.jvm.internal.s.g(relativeLayout2, "fragmentLayout.flSeekBar");
        int i6 = s5.e() ^ true ? 4 : 0;
        relativeLayout2.setVisibility(i6);
        VdsAgent.onSetViewVisibility(relativeLayout2, i6);
    }
}
