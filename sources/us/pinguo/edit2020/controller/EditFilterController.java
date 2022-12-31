package us.pinguo.edit2020.controller;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.FunctionReferenceImpl;
import us.pinguo.common.filter.controller.FilterController;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.z2;
import us.pinguo.edit2020.model.editgoto.EditGotoType;
import us.pinguo.edit2020.view.FilterGestureView;
import us.pinguo.edit2020.view.p0;
import us.pinguo.edit2020.viewmodel.module.EditFilterModule;
import us.pinguo.repository2020.FilterConstants;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.repository2020.entity.FilterItem;
import us.pinguo.repository2020.manager.FilterRepository;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: EditFilterController.kt */
/* loaded from: classes4.dex */
public final class EditFilterController extends FilterController implements z2, c3, GestureDetector.OnGestureListener, e3, us.pinguo.edit2020.view.p0 {
    private final boolean A;
    private boolean B;
    private HashMap<String, us.pinguo.edit2020.view.k0> C;
    private HashMap<String, us.pinguo.edit2020.view.k0> D;
    private float E;
    private float F;
    private int G;
    private boolean H;
    private boolean I;
    private final ConstraintLayout u;
    private final EditFilterModule v;
    private final us.pinguo.edit2020.view.c0 w;
    private kotlin.jvm.b.a<kotlin.u> x;
    private final GestureDetector y;
    private volatile boolean z;

    /* compiled from: EditFilterController.kt */
    /* renamed from: us.pinguo.edit2020.controller.EditFilterController$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements kotlin.jvm.b.v<String, Integer, Boolean, Float, Float, Float, Float, Float, kotlin.u> {
        AnonymousClass2(Object obj) {
            super(8, obj, EditFilterController.class, "filterObjectSelectedCallback", "filterObjectSelectedCallback(Ljava/lang/String;IZFFFFF)V", 0);
        }

        @Override // kotlin.jvm.b.v
        public /* bridge */ /* synthetic */ kotlin.u invoke(String str, Integer num, Boolean bool, Float f2, Float f3, Float f4, Float f5, Float f6) {
            invoke(str, num.intValue(), bool.booleanValue(), f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue(), f6.floatValue());
            return kotlin.u.a;
        }

        public final void invoke(String p0, int i2, boolean z, float f2, float f3, float f4, float f5, float f6) {
            kotlin.jvm.internal.s.h(p0, "p0");
            ((EditFilterController) this.receiver).W1(p0, i2, z, f2, f3, f4, f5, f6);
        }
    }

    /* compiled from: EditFilterController.kt */
    /* renamed from: us.pinguo.edit2020.controller.EditFilterController$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements kotlin.jvm.b.t<String, Float, Float, Float, Float, Float, kotlin.u> {
        AnonymousClass3(Object obj) {
            super(6, obj, EditFilterController.class, "filterObjectRenderCompleteCallback", "filterObjectRenderCompleteCallback(Ljava/lang/String;FFFFF)V", 0);
        }

        @Override // kotlin.jvm.b.t
        public /* bridge */ /* synthetic */ kotlin.u invoke(String str, Float f2, Float f3, Float f4, Float f5, Float f6) {
            invoke(str, f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue(), f6.floatValue());
            return kotlin.u.a;
        }

        public final void invoke(String p0, float f2, float f3, float f4, float f5, float f6) {
            kotlin.jvm.internal.s.h(p0, "p0");
            ((EditFilterController) this.receiver).V1(p0, f2, f3, f4, f5, f6);
        }
    }

    /* compiled from: EditFilterController.kt */
    /* renamed from: us.pinguo.edit2020.controller.EditFilterController$4  reason: invalid class name */
    /* loaded from: classes4.dex */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements kotlin.jvm.b.p<Boolean, Boolean, kotlin.u> {
        AnonymousClass4(Object obj) {
            super(2, obj, EditFilterController.class, "filterGestureNeededCallback", "filterGestureNeededCallback(ZZ)V", 0);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool, Boolean bool2) {
            invoke(bool.booleanValue(), bool2.booleanValue());
            return kotlin.u.a;
        }

        public final void invoke(boolean z, boolean z2) {
            ((EditFilterController) this.receiver).U1(z, z2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public EditFilterController(androidx.constraintlayout.widget.ConstraintLayout r6, us.pinguo.edit2020.viewmodel.module.EditFilterModule r7, us.pinguo.edit2020.view.c0 r8) {
        /*
            r5 = this;
            java.lang.String r0 = "fragmentLayout"
            kotlin.jvm.internal.s.h(r6, r0)
            java.lang.String r0 = "editFilterModule"
            kotlin.jvm.internal.s.h(r7, r0)
            java.lang.String r0 = "userOperationController"
            kotlin.jvm.internal.s.h(r8, r0)
            int r0 = us.pinguo.edit2020.R.id.filterView
            android.view.View r1 = r6.findViewById(r0)
            us.pinguo.common.filter.view.FilterPanelView r1 = (us.pinguo.common.filter.view.FilterPanelView) r1
            java.lang.String r2 = "fragmentLayout.filterView"
            kotlin.jvm.internal.s.g(r1, r2)
            r3 = 1
            r5.<init>(r1, r7, r3)
            r5.u = r6
            r5.v = r7
            r5.w = r8
            android.view.GestureDetector r8 = new android.view.GestureDetector
            android.content.Context r1 = r6.getContext()
            r8.<init>(r1, r5)
            r5.y = r8
            r5.z = r3
            us.pinguo.performance.manager.PerformanceLevelManager r8 = us.pinguo.performance.manager.PerformanceLevelManager.a
            java.lang.Integer r8 = r8.g()
            r1 = 0
            if (r8 != 0) goto L3e
            r8 = 0
            goto L42
        L3e:
            int r8 = r8.intValue()
        L42:
            r4 = 90
            if (r8 >= r4) goto L47
            r1 = 1
        L47:
            r5.A = r1
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r5.C = r8
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r5.D = r8
            us.pinguo.repository2020.u r8 = r7.y()
            android.view.View r1 = r6.findViewById(r0)
            us.pinguo.common.filter.view.FilterPanelView r1 = (us.pinguo.common.filter.view.FilterPanelView) r1
            kotlin.jvm.internal.s.g(r1, r2)
            androidx.fragment.app.Fragment r1 = androidx.fragment.app.ViewKt.findFragment(r1)
            androidx.lifecycle.LifecycleOwner r1 = r1.getViewLifecycleOwner()
            java.lang.String r2 = "fragmentLayout.filterVie…ent>().viewLifecycleOwner"
            kotlin.jvm.internal.s.g(r1, r2)
            us.pinguo.edit2020.controller.e1 r2 = new us.pinguo.edit2020.controller.e1
            r2.<init>()
            r8.observe(r1, r2)
            android.view.View r6 = r6.findViewById(r0)
            us.pinguo.common.filter.view.FilterPanelView r6 = (us.pinguo.common.filter.view.FilterPanelView) r6
            r6.setFromEdit(r3)
            us.pinguo.edit2020.model.EditRender r6 = r7.q0()
            us.pinguo.edit2020.controller.EditFilterController$2 r8 = new us.pinguo.edit2020.controller.EditFilterController$2
            r8.<init>(r5)
            r6.y0(r8)
            us.pinguo.edit2020.model.EditRender r6 = r7.q0()
            us.pinguo.edit2020.controller.EditFilterController$3 r8 = new us.pinguo.edit2020.controller.EditFilterController$3
            r8.<init>(r5)
            r6.x0(r8)
            us.pinguo.edit2020.model.EditRender r6 = r7.q0()
            us.pinguo.edit2020.controller.EditFilterController$4 r7 = new us.pinguo.edit2020.controller.EditFilterController$4
            r7.<init>(r5)
            r6.w0(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.EditFilterController.<init>(androidx.constraintlayout.widget.ConstraintLayout, us.pinguo.edit2020.viewmodel.module.EditFilterModule, us.pinguo.edit2020.view.c0):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(EditFilterController this$0, FilterEntry filterEntry) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        String itemId = filterEntry.getItemId();
        if (itemId == null || kotlin.jvm.internal.s.c(itemId, Effect.EFFECT_FILTER_NONE_KEY)) {
            return;
        }
        this$0.J0();
        ConstraintLayout constraintLayout = this$0.u;
        int i2 = R.id.filterGestureView;
        ((FilterGestureView) constraintLayout.findViewById(i2)).setDrawRect(false);
        ((FilterGestureView) this$0.u.findViewById(i2)).setRectActive(true);
        View findViewById = this$0.v0().findViewById(R.id.filterItemView);
        kotlin.jvm.internal.s.g(findViewById, "filterPanelView.findView…iew>(R.id.filterItemView)");
        findViewById.setVisibility(0);
        VdsAgent.onSetViewVisibility(findViewById, 0);
        this$0.v0().setFilterItemViewVisible(true);
        this$0.G = 0;
        ((FilterGestureView) this$0.u.findViewById(i2)).h().s("");
        this$0.v.h0(false);
        if (((FilterGestureView) this$0.u.findViewById(i2)).f() == null) {
            ((FilterGestureView) this$0.u.findViewById(i2)).setOnGesture(new EditFilterController$1$1(this$0));
        }
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.b()), null, null, new EditFilterController$1$2(this$0, filterEntry, itemId, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(boolean z, boolean z2) {
        this.H = z2;
        this.z = !z2;
        this.v.o0(!z2);
        ConstraintLayout constraintLayout = this.u;
        int i2 = R.id.filterGestureView;
        FilterGestureView filterGestureView = (FilterGestureView) constraintLayout.findViewById(i2);
        kotlin.jvm.internal.s.g(filterGestureView, "fragmentLayout.filterGestureView");
        int i3 = z ^ true ? 4 : 0;
        filterGestureView.setVisibility(i3);
        VdsAgent.onSetViewVisibility(filterGestureView, i3);
        ((FilterGestureView) this.u.findViewById(i2)).setMultiFingerMove(!z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V1(String str, float f2, float f3, float f4, float f5, float f6) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1(String str, int i2, boolean z, float f2, float f3, float f4, float f5, float f6) {
        String itemId;
        ConstraintLayout constraintLayout = this.u;
        int i3 = R.id.filterGestureView;
        FilterGestureView gestureView = (FilterGestureView) constraintLayout.findViewById(i3);
        this.E = f4;
        this.F = f5;
        if (!(str.length() == 0) && i2 != 0) {
            if (kotlin.jvm.internal.s.c(gestureView.h().m(), str) && gestureView.d()) {
                this.z = !this.H;
                this.v.o0(!this.H);
                gestureView.h().s("");
                gestureView.setDrawRect(false);
                this.G = 0;
                return;
            }
            this.z = false;
            this.v.o0(false);
            kotlin.jvm.internal.s.g(gestureView, "gestureView");
            gestureView.setVisibility(0);
            VdsAgent.onSetViewVisibility(gestureView, 0);
            if (i2 != 1) {
                if (i2 == 2) {
                    gestureView.setDrawRect(false);
                    gestureView.setRestrictedInScreen(false);
                } else if (i2 == 3) {
                    if (this.I) {
                        this.I = false;
                        gestureView.h().s("");
                        return;
                    }
                    gestureView.setDrawRect(true);
                    gestureView.setRestrictedInScreen(true);
                }
            } else if (this.I) {
                this.I = false;
                gestureView.h().s("");
                return;
            } else {
                gestureView.setDrawRect(true);
                gestureView.setRestrictedInScreen(false);
            }
            this.G = i2;
            gestureView.setDeltaPosition(z);
            us.pinguo.edit2020.bean.u0 value = this.v.q0().L().getValue();
            float e2 = value == null ? 0.0f : value.e();
            us.pinguo.edit2020.bean.u0 value2 = this.v.q0().L().getValue();
            float f7 = e2 * f4;
            float d2 = (value2 != null ? value2.d() : 0.0f) * f5;
            float i4 = ((FilterGestureView) this.u.findViewById(i3)).i();
            gestureView.setRectActive(Math.min(f7, d2) >= i4);
            if (i2 == 3) {
                FilterEntry value3 = this.v.y().getValue();
                if (value3 != null && (itemId = value3.getItemId()) != null) {
                    us.pinguo.edit2020.view.k0 k0Var = this.D.get(itemId);
                    if (k0Var != null) {
                        k0Var.s(str);
                    }
                    us.pinguo.edit2020.view.k0 k0Var2 = this.C.get(itemId);
                    if (k0Var2 != null) {
                        gestureView.setRectInfo(k0Var2, false);
                    }
                }
            } else {
                float min = Math.min(f7, d2);
                if (min < i4) {
                    float f8 = i4 / min;
                    f7 *= f8;
                    d2 *= f8;
                }
                PointF n = gestureView.n(gestureView.getWidth(), gestureView.getHeight(), f2, f3);
                float f9 = n.x;
                float f10 = f7 * 0.5f;
                float f11 = f9 - f10;
                float f12 = n.y;
                float f13 = d2 * 0.5f;
                float f14 = f12 - f13;
                float f15 = f9 + f10;
                float f16 = f12 + f13;
                gestureView.setVertices(new PointF(f11, f14), new PointF(f15, f14), new PointF(f15, f16), new PointF(f11, f16));
                gestureView.s(Float.valueOf(f6));
            }
        } else {
            this.z = !this.H;
            this.v.o0(!this.H);
            gestureView.setDrawRect(false);
        }
        gestureView.h().s(str);
    }

    private final void X1() {
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.u.findViewById(R.id.showOriginPicBt);
        kotlin.jvm.internal.s.g(appCompatImageView, "fragmentLayout.showOriginPicBt");
        appCompatImageView.setVisibility(8);
        VdsAgent.onSetViewVisibility(appCompatImageView, 8);
    }

    private final void a2() {
        h0();
        N0();
    }

    private final void b2(boolean z) {
        if (z) {
            int h2 = us.pinguo.edit2020.utils.d.h(R.color.edit_filter_panel_color);
            ((FilterPanelView) this.u.findViewById(R.id.filterView)).setFilterPanelBg(h2);
            this.u.findViewById(R.id.vBottom).setBackgroundColor(h2);
            ConstraintLayout constraintLayout = this.u;
            int i2 = R.id.viewHairCut;
            View findViewById = constraintLayout.findViewById(i2);
            kotlin.jvm.internal.s.g(findViewById, "fragmentLayout.viewHairCut");
            if (findViewById.getVisibility() == 0) {
                this.u.findViewById(i2).setBackgroundColor(us.pinguo.edit2020.utils.d.h(R.color.edit_filter_canvas_color));
                return;
            }
            return;
        }
        ((FilterPanelView) this.u.findViewById(R.id.filterView)).setFilterPanelBg(-1);
        this.u.findViewById(R.id.vBottom).setBackgroundColor(-1);
        ConstraintLayout constraintLayout2 = this.u;
        int i3 = R.id.viewHairCut;
        View findViewById2 = constraintLayout2.findViewById(i3);
        kotlin.jvm.internal.s.g(findViewById2, "fragmentLayout.viewHairCut");
        if (findViewById2.getVisibility() == 0) {
            this.u.findViewById(i3).setBackgroundColor(this.u.getContext().getResources().getColor(R.color.edit_unity_bg));
        }
    }

    @Override // us.pinguo.common.filter.controller.FilterController, us.pinguo.common.filter.view.FilterPanelView.a
    public void A(int i2) {
        boolean z;
        if (!this.B && (z = this.A)) {
            this.B = true;
            this.v.h0(z);
        }
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.b()), null, null, new EditFilterController$onSeekbarProgressChanged$1(this, this.v.y().getValue(), i2, null), 3, null);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.FILTER;
    }

    @Override // us.pinguo.common.filter.controller.FilterController, us.pinguo.common.filter.view.FilterPanelView.a
    public void H(FilterItem filterItem) {
        kotlin.jvm.internal.s.h(filterItem, "filterItem");
        super.H(filterItem);
        us.pinguo.foundation.statistics.h.b.A(filterItem.getFilterId(), "click");
    }

    @Override // us.pinguo.common.filter.controller.FilterController
    public void H0(boolean z) {
        this.v.o0(false);
        this.v.G().clear();
        this.C.clear();
        this.D.clear();
        super.H0(z);
        d2();
        b2(false);
        ((PGEditBottomTabLayout) this.u.findViewById(R.id.bottomTabLayout)).F(us.pinguo.edit2020.utils.d.h(R.color.white), us.pinguo.edit2020.utils.d.h(R.color.edit_filter_panel_color));
        EditFilterModule.w0(this.v, 0, 1, null);
        this.w.D(null);
        ConstraintLayout constraintLayout = this.u;
        int i2 = R.id.filterGestureView;
        ((FilterGestureView) constraintLayout.findViewById(i2)).setDrawRect(false);
        FilterGestureView filterGestureView = (FilterGestureView) this.u.findViewById(i2);
        kotlin.jvm.internal.s.g(filterGestureView, "fragmentLayout.filterGestureView");
        filterGestureView.setVisibility(4);
        VdsAgent.onSetViewVisibility(filterGestureView, 4);
        this.z = true;
        this.G = 0;
        this.H = false;
        v0().X();
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.b()), null, null, new EditFilterController$hide$1(this, null), 3, null);
    }

    @Override // us.pinguo.edit2020.controller.c3
    public boolean L(us.pinguo.edit2020.model.editgoto.b editGoto) {
        kotlin.jvm.internal.s.h(editGoto, "editGoto");
        if (editGoto.a() == EditGotoType.FILTER) {
            kotlin.jvm.b.a<kotlin.u> aVar = this.x;
            if (aVar != null) {
                aVar.invoke();
            }
            String b = editGoto.b();
            if (b == null) {
                b = "";
            }
            String d2 = editGoto.d();
            if (d2 == null) {
                d2 = "";
            }
            String c = editGoto.c();
            FilterController.B0(this, new FilterEntry(c != null ? c : "", b, d2), false, 2, null);
            return true;
        }
        return false;
    }

    @Override // us.pinguo.common.filter.controller.FilterController
    protected boolean M0() {
        us.pinguo.edit2020.view.k0 k0Var;
        FilterEntry value = this.v.y().getValue();
        String itemId = value == null ? null : value.getItemId();
        if (itemId == null || (k0Var = this.C.get(itemId)) == null) {
            return false;
        }
        return k0Var.d();
    }

    @Override // us.pinguo.edit2020.view.p0
    public void P() {
        p0.a.d(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        return z2.a.a(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return z2.a.c(this);
    }

    public final void Z1(String uid, float f2, float f3, float f4, float f5) {
        kotlin.jvm.internal.s.h(uid, "uid");
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.c()), null, null, new EditFilterController$onSkyPrepared$1(this, f2, f3, f4, f5, uid, null), 3, null);
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        if (L0()) {
            if (this.y.onTouchEvent(event)) {
                return true;
            }
            ConstraintLayout constraintLayout = this.u;
            int i2 = R.id.filterGestureView;
            FilterGestureView filterGestureView = (FilterGestureView) constraintLayout.findViewById(i2);
            kotlin.jvm.internal.s.g(filterGestureView, "fragmentLayout.filterGestureView");
            if (filterGestureView.getVisibility() == 0) {
                ((FilterGestureView) this.u.findViewById(i2)).p(event);
                ConstraintLayout x0 = x0();
                if (x0 != null) {
                    x0.setVisibility(4);
                    VdsAgent.onSetViewVisibility(x0, 4);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final void c2(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.x = aVar;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        FilterEntry value = this.v.y().getValue();
        String itemId = value == null ? null : value.getItemId();
        if (kotlin.jvm.internal.s.c(itemId, Effect.EFFECT_FILTER_NONE_KEY)) {
            this.v.r0(true);
            itemId = "original";
        } else {
            this.v.r0(false);
        }
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.t0(itemId);
        iVar.A(itemId, "save");
        EditFilterModule editFilterModule = this.v;
        FilterEntry value2 = editFilterModule.y().getValue();
        iVar.K("edit_panel_filter", editFilterModule.a0(value2 == null ? null : value2.getPkgId(), itemId) ? "use_vip_func_or_material" : "nonuse_vip_func_or_material", "save");
        FilterController.I0(this, false, 1, null);
        a2();
        this.v.y().setValue(FilterConstants.f());
        FilterRepository.a.L();
    }

    public final void d2() {
        ConstraintLayout constraintLayout = this.u;
        int i2 = R.id.showOriginPicBt;
        AppCompatImageView appCompatImageView = (AppCompatImageView) constraintLayout.findViewById(i2);
        kotlin.jvm.internal.s.g(appCompatImageView, "fragmentLayout.showOriginPicBt");
        if (appCompatImageView.getVisibility() == 0) {
            return;
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) this.u.findViewById(i2);
        kotlin.jvm.internal.s.g(appCompatImageView2, "fragmentLayout.showOriginPicBt");
        appCompatImageView2.setVisibility(0);
        VdsAgent.onSetViewVisibility(appCompatImageView2, 0);
    }

    public final void e(us.pinguo.edit2020.bean.u0 unityCanvasStatus) {
        kotlin.jvm.internal.s.h(unityCanvasStatus, "unityCanvasStatus");
        ((FilterGestureView) this.u.findViewById(R.id.filterGestureView)).setCanvasInfo(unityCanvasStatus);
    }

    @Override // us.pinguo.common.filter.controller.FilterController
    public void e1() {
        us.pinguo.edit2020.view.k0 k0Var;
        us.pinguo.edit2020.bean.u0 value = this.v.q0().L().getValue();
        Float valueOf = value == null ? null : Float.valueOf(value.e());
        if (valueOf == null) {
            return;
        }
        float floatValue = valueOf.floatValue();
        us.pinguo.edit2020.bean.u0 value2 = this.v.q0().L().getValue();
        Float valueOf2 = value2 == null ? null : Float.valueOf(value2.d());
        if (valueOf2 == null) {
            return;
        }
        float floatValue2 = valueOf2.floatValue();
        FilterEntry value3 = this.v.y().getValue();
        String itemId = value3 != null ? value3.getItemId() : null;
        if (itemId == null || (k0Var = this.D.get(itemId)) == null) {
            return;
        }
        this.E = k0Var.j() / floatValue;
        this.F = k0Var.e() / floatValue2;
        ConstraintLayout constraintLayout = this.u;
        int i2 = R.id.filterGestureView;
        ((FilterGestureView) constraintLayout.findViewById(i2)).setRectInfo(k0Var, true);
        ((FilterGestureView) this.u.findViewById(i2)).h().p(false);
        FilterGestureView filterGestureView = (FilterGestureView) this.u.findViewById(i2);
        ConstraintLayout constraintLayout2 = this.u;
        int i3 = R.id.unityContainer;
        PointF o = filterGestureView.o(((FrameLayout) constraintLayout2.findViewById(i3)).getWidth(), ((FrameLayout) this.u.findViewById(i3)).getHeight(), (k0Var.f().x + k0Var.g().x + k0Var.h().x + k0Var.i().x) * 0.25f, (k0Var.f().y + k0Var.g().y + k0Var.h().y + k0Var.i().y) * 0.25f);
        UnityEditCaller.Filter.setEditFilterObjectTransformData(k0Var.m(), o.x, o.y, k0Var.j() / floatValue, k0Var.e() / floatValue2, k0Var.a());
        super.e1();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean f() {
        return z2.a.b(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void g() {
        us.pinguo.processor.i.a.c();
        EditFilterModule editFilterModule = this.v;
        FilterEntry value = editFilterModule.y().getValue();
        String pkgId = value == null ? null : value.getPkgId();
        FilterEntry value2 = this.v.y().getValue();
        String str = editFilterModule.a0(pkgId, value2 == null ? null : value2.getItemId()) ? "use_vip_func_or_material" : "nonuse_vip_func_or_material";
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.K("edit_panel_filter", str, "exited");
        FilterEntry value3 = this.v.y().getValue();
        iVar.A(value3 == null ? null : value3.getItemId(), "exited");
        FilterController.I0(this, false, 1, null);
        a2();
        FilterRepository.a.L();
    }

    @Override // us.pinguo.edit2020.view.p0
    public void j() {
        p0.a.a(this);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void k(boolean z) {
        if (z) {
            ((FilterGestureView) this.u.findViewById(R.id.filterGestureView)).setAlpha(0.0f);
        } else {
            ((FilterGestureView) this.u.findViewById(R.id.filterGestureView)).setAlpha(1.0f);
        }
        UnityEditCaller.Common.showOriginalTexture(z);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void m() {
        p0.a.f(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return w1();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    @Override // android.view.GestureDetector.OnGestureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onFling(android.view.MotionEvent r2, android.view.MotionEvent r3, float r4, float r5) {
        /*
            r1 = this;
            boolean r2 = r1.z
            r3 = 0
            if (r2 != 0) goto L6
            return r3
        L6:
            androidx.constraintlayout.widget.ConstraintLayout r2 = r1.x0()
            r0 = 1
            if (r2 != 0) goto Lf
        Ld:
            r2 = 0
            goto L1b
        Lf:
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L17
            r2 = 1
            goto L18
        L17:
            r2 = 0
        L18:
            if (r2 != r0) goto Ld
            r2 = 1
        L1b:
            if (r2 == 0) goto L1e
            return r3
        L1e:
            float r2 = java.lang.Math.abs(r4)
            float r5 = java.lang.Math.abs(r5)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 >= 0) goto L2b
            return r3
        L2b:
            r2 = 250(0xfa, float:3.5E-43)
            int r2 = us.pinguo.foundation.utils.n0.c(r2)
            float r5 = (float) r2
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 <= 0) goto L38
            r5 = 1
            goto L39
        L38:
            r5 = 0
        L39:
            int r2 = -r2
            float r2 = (float) r2
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L40
            r3 = 1
        L40:
            if (r5 != 0) goto L44
            if (r3 == 0) goto L47
        L44:
            r1.s0(r5)
        L47:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.EditFilterController.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089 A[SYNTHETIC] */
    @Override // us.pinguo.common.filter.controller.FilterController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q1(boolean r14, boolean r15) {
        /*
            r13 = this;
            us.pinguo.repository2020.manager.FilterRepository r0 = us.pinguo.repository2020.manager.FilterRepository.a
            r0.L()
            super.q1(r14, r15)
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r14 = r13.v
            r15 = -14803168(0xffffffffff1e1f20, float:-2.1017963E38)
            r14.v0(r15)
            r14 = 1
            r13.b2(r14)
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r15 = r13.v
            r1 = 0
            r15.o0(r1)
            r0.L()
            r13.X1()
            us.pinguo.repository2020.n$a r15 = us.pinguo.repository2020.n.a
            us.pinguo.repository2020.entity.ClassifyDefault[] r15 = r15.a()
            r0 = 0
            if (r15 != 0) goto L2b
            r2 = r0
            goto L8c
        L2b:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r3 = r15.length
            r4 = 0
        L32:
            if (r4 >= r3) goto L8c
            r5 = r15[r4]
            long r6 = java.lang.System.currentTimeMillis()
            r8 = 1000(0x3e8, float:1.401E-42)
            long r8 = (long) r8
            long r6 = r6 / r8
            java.lang.String r8 = r5.getScene()
            us.pinguo.repository2020.entity.ClassifyType r9 = us.pinguo.repository2020.entity.ClassifyType.CLASSIFY_EDIT_FILTER
            java.lang.String r9 = r9.getType()
            boolean r8 = kotlin.jvm.internal.s.c(r8, r9)
            if (r8 == 0) goto L83
            java.lang.Long r8 = r5.getStartTime()
            r9 = 0
            if (r8 != 0) goto L58
            r11 = r9
            goto L5c
        L58:
            long r11 = r8.longValue()
        L5c:
            java.lang.Long r8 = r5.getEndTime()
            if (r8 != 0) goto L63
            goto L67
        L63:
            long r9 = r8.longValue()
        L67:
            int r8 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r8 > 0) goto L71
            int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r8 > 0) goto L71
            r6 = 1
            goto L72
        L71:
            r6 = 0
        L72:
            if (r6 == 0) goto L83
            java.lang.Integer r6 = r5.getDefault()
            if (r6 != 0) goto L7b
            goto L83
        L7b:
            int r6 = r6.intValue()
            if (r6 != r14) goto L83
            r6 = 1
            goto L84
        L83:
            r6 = 0
        L84:
            if (r6 == 0) goto L89
            r2.add(r5)
        L89:
            int r4 = r4 + 1
            goto L32
        L8c:
            if (r2 == 0) goto L96
            boolean r15 = r2.isEmpty()
            if (r15 == 0) goto L95
            goto L96
        L95:
            r14 = 0
        L96:
            if (r14 != 0) goto Lab
            java.lang.Object r14 = r2.get(r1)
            us.pinguo.repository2020.entity.ClassifyDefault r14 = (us.pinguo.repository2020.entity.ClassifyDefault) r14
            us.pinguo.repository2020.entity.FilterEntry r15 = new us.pinguo.repository2020.entity.FilterEntry
            java.lang.String r14 = r14.getClassifyId()
            r15.<init>(r14, r0, r0)
            r14 = 2
            us.pinguo.common.filter.controller.FilterController.B0(r13, r15, r1, r14, r0)
        Lab:
            us.pinguo.edit2020.view.c0 r14 = r13.w
            r14.D(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.EditFilterController.q1(boolean, boolean):void");
    }

    @Override // us.pinguo.common.filter.controller.FilterController, us.pinguo.common.filter.view.FilterPanelView.a
    public void r(int i2) {
        this.B = false;
        if (this.A) {
            this.v.h0(false);
        }
        super.r(i2);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void t(boolean z) {
        p0.a.c(this, z);
    }

    @Override // us.pinguo.common.filter.controller.FilterController
    public int u0() {
        return 0;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        FilterItem z;
        FilterEntry value = this.v.y().getValue();
        if (value != null) {
            if (!(value.getItemId() != null)) {
                value = null;
            }
            if (value != null && (z = this.v.z(value.getPkgId(), value.getItemId())) != null) {
                if (!(!us.pinguo.vip.proxy.b.a.e(value.getPkgId()))) {
                    z = null;
                }
                if (z != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new us.pinguo.edit2020.bean.s(z));
                    return arrayList;
                }
            }
        }
        return null;
    }

    @Override // us.pinguo.edit2020.view.p0
    public void y() {
        p0.a.b(this);
    }
}
