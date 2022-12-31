package us.pinguo.edit2020.controller;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.lib.LowerResolutionCpuMobile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import us.pinguo.common.widget.FragmentLoadingView;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.activity.CommonVideoTutorialActivity;
import us.pinguo.edit2020.b.c;
import us.pinguo.edit2020.view.NoFaceTipView;
import us.pinguo.edit2020.view.NumberTipView;
import us.pinguo.edit2020.view.m0;
import us.pinguo.edit2020.view.menuview.BeautySkinRefreshViewNew;
import us.pinguo.edit2020.view.p0;
import us.pinguo.edit2020.viewmodel.module.EditBeautyModule;
import us.pinguo.edit2020.widget.AreaProtectionBoldAdjustView;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.repository2020.entity.BeautyEditData;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: SkinRefreshController.kt */
/* loaded from: classes4.dex */
public final class SkinRefreshController implements us.pinguo.edit2020.b.c, e3 {
    private final Context a;
    private final ConstraintLayout b;
    private final us.pinguo.edit2020.view.c0 c;

    /* renamed from: d  reason: collision with root package name */
    private final EditBeautyModule f10417d;

    /* renamed from: e  reason: collision with root package name */
    private final LifecycleOwner f10418e;

    /* renamed from: f  reason: collision with root package name */
    private BeautySkinRefreshViewNew f10419f;

    /* renamed from: g  reason: collision with root package name */
    private us.pinguo.edit2020.bean.i f10420g;

    /* renamed from: h  reason: collision with root package name */
    private kotlin.jvm.b.l<? super Integer, kotlin.u> f10421h;

    /* renamed from: i  reason: collision with root package name */
    private kotlin.jvm.b.l<? super us.pinguo.edit2020.bean.x, kotlin.u> f10422i;

    /* renamed from: j  reason: collision with root package name */
    private kotlin.jvm.b.l<? super Boolean, kotlin.u> f10423j;

    /* renamed from: k  reason: collision with root package name */
    private h3 f10424k;

    /* renamed from: l  reason: collision with root package name */
    private final String f10425l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final float q;
    private final float r;
    private final int s;
    private List<us.pinguo.edit2020.bean.i> t;
    private final String[] u;
    private String v;
    private final ArrayList<String> w;
    private final us.pinguo.edit2020.view.m0 x;
    private final c y;

    /* compiled from: SkinRefreshController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements PGEditTabLayout.d {
        final /* synthetic */ us.pinguo.edit2020.bean.h b;

        a(us.pinguo.edit2020.bean.h hVar) {
            this.b = hVar;
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void a(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.c(this, fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void h(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.b(this, fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void i(PGEditTabLayout.f fVar) {
            CommonVideoTutorialActivity.a aVar = CommonVideoTutorialActivity.f10109d;
            Context context = ((PGEditBottomTabLayout) SkinRefreshController.this.b.findViewById(R.id.bottomTabLayout)).getContext();
            kotlin.jvm.internal.s.g(context, "fragmentLayout.bottomTabLayout.context");
            aVar.a(context, this.b.f());
            ((Activity) SkinRefreshController.this.a).overridePendingTransition(R.anim.bottom_in, 0);
        }
    }

    /* compiled from: SkinRefreshController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements us.pinguo.edit2020.view.m0 {
        b() {
        }

        @Override // us.pinguo.edit2020.view.m0
        public void h(int i2) {
            us.pinguo.edit2020.bean.i I = SkinRefreshController.this.I();
            if (I == null) {
                return;
            }
            if (I.j()) {
                if (kotlin.jvm.internal.s.c(I.f(), SkinRefreshController.this.p)) {
                    SkinRefreshController.this.f10417d.v0(I.f(), (i2 / I.g().getMaxValue()) / SkinRefreshController.this.q);
                } else {
                    SkinRefreshController.this.f10417d.v0(I.f(), i2 / I.g().getMaxValue());
                }
                I.g().setCurrentValue(i2);
                return;
            }
            BeautyEditData g2 = I.g();
            g2.setCurrentValue(i2);
            if (LowerResolutionCpuMobile.INSTANCE.isInLowerResolutionList()) {
                return;
            }
            SkinRefreshController.this.f10417d.q0(g2);
        }

        @Override // us.pinguo.edit2020.view.m0
        public void i(float f2) {
            m0.a.a(this, f2);
        }

        @Override // us.pinguo.edit2020.view.m0
        public void l(int i2) {
            us.pinguo.edit2020.bean.i I = SkinRefreshController.this.I();
            if (I == null) {
                return;
            }
            if (I.j()) {
                UnityEditCaller.Common.INSTANCE.addSoftSkinStepWithParamUpdate();
            } else {
                kotlin.jvm.b.l<Integer, kotlin.u> M = SkinRefreshController.this.M();
                if (M != null) {
                    M.invoke(Integer.valueOf(i2));
                }
                if (LowerResolutionCpuMobile.INSTANCE.isInLowerResolutionList()) {
                    I.g().setCurrentValue(i2);
                    SkinRefreshController.this.f10417d.q0(I.g());
                }
            }
            BeautySkinRefreshViewNew H = SkinRefreshController.this.H();
            if (H == null) {
                return;
            }
            H.l();
        }
    }

    /* compiled from: SkinRefreshController.kt */
    /* loaded from: classes4.dex */
    public static final class c implements us.pinguo.edit2020.view.p0 {
        c() {
        }

        @Override // us.pinguo.edit2020.view.p0
        public void P() {
            p0.a.d(this);
        }

        @Override // us.pinguo.edit2020.view.p0
        public void j() {
            UnityEditCaller.Common.moveNext();
        }

        @Override // us.pinguo.edit2020.view.p0
        public void k(boolean z) {
            UnityEditCaller.Common.showOriginalTexture(z);
        }

        @Override // us.pinguo.edit2020.view.p0
        public void m() {
            p0.a.f(this);
        }

        @Override // us.pinguo.edit2020.view.p0
        public void t(boolean z) {
            p0.a.c(this, z);
        }

        @Override // us.pinguo.edit2020.view.p0
        public void y() {
            UnityEditCaller.Common.movePrevious();
        }
    }

    public SkinRefreshController(Context context, ConstraintLayout fragmentLayout, us.pinguo.edit2020.view.c0 operationController, EditBeautyModule bottomModule, LifecycleOwner lifecycleOwner) {
        ArrayList<String> f2;
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(fragmentLayout, "fragmentLayout");
        kotlin.jvm.internal.s.h(operationController, "operationController");
        kotlin.jvm.internal.s.h(bottomModule, "bottomModule");
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        this.a = context;
        this.b = fragmentLayout;
        this.c = operationController;
        this.f10417d = bottomModule;
        this.f10418e = lifecycleOwner;
        this.f10424k = new h3(bottomModule, fragmentLayout, operationController);
        this.f10425l = "qudou";
        this.m = "quzhouwen";
        this.n = PortalFollowFeeds.TYPE_NONE;
        this.o = "new_to_";
        this.p = bottomModule.A();
        this.q = bottomModule.B();
        this.r = -1.0f;
        this.s = 1073676288;
        this.u = new String[]{"mopi", "qudou", "quzhouwen", "liangyan"};
        f2 = kotlin.collections.u.f("quzhouwen", "hongxuesi", "youguang", "jili");
        this.w = f2;
        j0();
        this.x = new b();
        this.y = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final us.pinguo.edit2020.bean.i O(String str) {
        boolean z;
        List<us.pinguo.edit2020.bean.i> list = this.t;
        Object obj = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            us.pinguo.edit2020.bean.i iVar = (us.pinguo.edit2020.bean.i) next;
            if (iVar.j() && kotlin.jvm.internal.s.c(iVar.f(), str)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        return (us.pinguo.edit2020.bean.i) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(us.pinguo.edit2020.bean.i iVar) {
        if (!iVar.j() && iVar.g().getNeedFace() && !this.f10417d.S()) {
            NoFaceTipView noFaceTipView = (NoFaceTipView) this.b.findViewById(R.id.noFaceTipView);
            kotlin.jvm.internal.s.g(noFaceTipView, "fragmentLayout.noFaceTipView");
            noFaceTipView.setVisibility(0);
            VdsAgent.onSetViewVisibility(noFaceTipView, 0);
            this.c.w(4);
            return;
        }
        NoFaceTipView noFaceTipView2 = (NoFaceTipView) this.b.findViewById(R.id.noFaceTipView);
        kotlin.jvm.internal.s.g(noFaceTipView2, "fragmentLayout.noFaceTipView");
        noFaceTipView2.setVisibility(8);
        VdsAgent.onSetViewVisibility(noFaceTipView2, 8);
    }

    private final void Q(us.pinguo.edit2020.bean.h hVar) {
        boolean m;
        boolean z;
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.bottomTabLayout;
        ((PGEditBottomTabLayout) constraintLayout.findViewById(i2)).B();
        m = kotlin.collections.n.m(this.u, this.v);
        z = kotlin.collections.c0.z(this.w, this.v);
        if (!m && !z) {
            PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.b.findViewById(i2);
            kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
            PGEditBottomTabLayout.h(pGEditBottomTabLayout, new String[]{hVar.c()}, false, null, 6, null);
        } else {
            View a2 = us.pinguo.edit2020.utils.d.a(this.a, hVar.h(), z, m);
            PGEditBottomTabLayout pGEditBottomTabLayout2 = (PGEditBottomTabLayout) this.b.findViewById(i2);
            kotlin.jvm.internal.s.g(pGEditBottomTabLayout2, "fragmentLayout.bottomTabLayout");
            PGEditBottomTabLayout.g(pGEditBottomTabLayout2, new View[]{a2}, false, null, 6, null);
        }
        if (m) {
            ((PGEditBottomTabLayout) this.b.findViewById(i2)).d(new a(hVar));
        }
    }

    private final BeautySkinRefreshViewNew T() {
        BeautySkinRefreshViewNew beautySkinRefreshViewNew = new BeautySkinRefreshViewNew(this.a);
        beautySkinRefreshViewNew.setOnItemChanged(new SkinRefreshController$initView$1(this));
        return beautySkinRefreshViewNew;
    }

    private final void X(boolean z) {
        View adjustView = this.c.g().findViewById(R.id.skinErasingAdjust);
        if (adjustView == null) {
            if (!z) {
                return;
            }
            adjustView = ((ViewStub) this.c.g().findViewById(R.id.stubSkinErasingView)).inflate();
            ((AreaProtectionBoldAdjustView) adjustView.findViewById(R.id.selectBar)).setCallBackLevel(new SkinRefreshController$levelSeekbarAdjustEnable$1(this));
        }
        kotlin.jvm.internal.s.g(adjustView, "adjustView");
        int i2 = z ? 0 : 8;
        adjustView.setVisibility(i2);
        VdsAgent.onSetViewVisibility(adjustView, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y() {
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.m2
            @Override // java.lang.Runnable
            public final void run() {
                SkinRefreshController.Z(SkinRefreshController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(SkinRefreshController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        FragmentLoadingView loadingView = (FragmentLoadingView) this$0.b.findViewById(R.id.loadingView);
        loadingView.b();
        kotlin.jvm.internal.s.g(loadingView, "loadingView");
        loadingView.setVisibility(8);
        VdsAgent.onSetViewVisibility(loadingView, 8);
        Group group = (Group) this$0.b.findViewById(R.id.loadingGroup);
        kotlin.jvm.internal.s.g(group, "fragmentLayout.loadingGroup");
        group.setVisibility(8);
        VdsAgent.onSetViewVisibility(group, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0() {
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.n2
            @Override // java.lang.Runnable
            public final void run() {
                SkinRefreshController.b0(SkinRefreshController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(SkinRefreshController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Group group = (Group) this$0.b.findViewById(R.id.loadingGroup);
        kotlin.jvm.internal.s.g(group, "fragmentLayout.loadingGroup");
        group.setVisibility(0);
        VdsAgent.onSetViewVisibility(group, 0);
        FragmentLoadingView loadingView = (FragmentLoadingView) this$0.b.findViewById(R.id.loadingView);
        loadingView.d(true);
        kotlin.jvm.internal.s.g(loadingView, "loadingView");
        loadingView.setVisibility(0);
        VdsAgent.onSetViewVisibility(loadingView, 0);
        loadingView.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(us.pinguo.edit2020.bean.i iVar) {
        this.c.B(us.pinguo.edit2020.utils.d.h(R.color.edit_seekbar_default));
        if (kotlin.jvm.internal.s.c(iVar.f(), this.f10425l)) {
            if (iVar.j()) {
                X(true);
                this.c.x(false);
                us.pinguo.edit2020.view.c0 c0Var = this.c;
                String string = us.pinguo.foundation.e.b().getString(R.string.brush_size);
                kotlin.jvm.internal.s.g(string, "getAppContext().getString(R.string.brush_size)");
                c0Var.A(string);
            } else {
                this.c.y(StickySeekBar.DefaultDotStyle.NONE);
                X(false);
                us.pinguo.edit2020.view.c0 c0Var2 = this.c;
                String string2 = us.pinguo.foundation.e.b().getString(R.string.seekbar_text_skinrefresh);
                kotlin.jvm.internal.s.g(string2, "getAppContext().getStrin…seekbar_text_skinrefresh)");
                c0Var2.A(string2);
                this.c.x(true);
                this.c.I(iVar.g().getMinValue(), iVar.g().getMaxValue(), iVar.g().getCurrentValue(), iVar.g().getDefaultValue());
            }
        } else {
            X(false);
            this.c.x(true);
            us.pinguo.edit2020.view.c0 c0Var3 = this.c;
            String string3 = us.pinguo.foundation.e.b().getString(R.string.seekbar_text_skinrefresh);
            kotlin.jvm.internal.s.g(string3, "getAppContext().getStrin…seekbar_text_skinrefresh)");
            c0Var3.A(string3);
            this.c.y(StickySeekBar.DefaultDotStyle.NONE);
        }
        this.c.I(iVar.g().getMinValue(), iVar.g().getMaxValue(), iVar.g().getCurrentValue(), iVar.g().getDefaultValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        us.pinguo.edit2020.bean.i iVar = this.f10420g;
        if (iVar == null) {
            return;
        }
        if (kotlin.jvm.internal.s.c(this.f10425l, iVar.f())) {
            TextView textView = (TextView) this.b.findViewById(R.id.txtEditHint);
            kotlin.jvm.internal.s.g(textView, "fragmentLayout.txtEditHint");
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
        } else if (!iVar.j()) {
            TextView textView2 = (TextView) this.b.findViewById(R.id.txtEditHint);
            kotlin.jvm.internal.s.g(textView2, "fragmentLayout.txtEditHint");
            textView2.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView2, 8);
        } else if (iVar.e()) {
            TextView textView3 = (TextView) this.b.findViewById(R.id.txtEditHint);
            kotlin.jvm.internal.s.g(textView3, "fragmentLayout.txtEditHint");
            textView3.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView3, 8);
            if (kotlin.jvm.internal.s.c(iVar.f(), this.f10425l)) {
                X(true);
            } else {
                this.c.x(true);
            }
        } else {
            ConstraintLayout constraintLayout = this.b;
            int i2 = R.id.txtEditHint;
            TextView textView4 = (TextView) constraintLayout.findViewById(i2);
            kotlin.jvm.internal.s.g(textView4, "fragmentLayout.txtEditHint");
            textView4.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView4, 0);
            ((TextView) this.b.findViewById(i2)).setText(this.a.getResources().getText(R.string.skin_refresh_manual_tip));
            this.c.x(false);
            X(false);
        }
    }

    private final void j0() {
        this.f10417d.B0(new SkinRefreshController$setUnityStepHistory$1(this));
    }

    public static /* synthetic */ void l0(SkinRefreshController skinRefreshController, us.pinguo.edit2020.bean.h hVar, List list, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        skinRefreshController.k0(hVar, list, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(float f2, int i2) {
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.f10418e), kotlinx.coroutines.z0.c(), null, new SkinRefreshController$showMaskAnim$1(f2, i2, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(String str) {
        boolean m;
        m = kotlin.collections.n.m(this.u, this.v);
        if (m) {
            if (!kotlin.jvm.internal.s.c("mopi", this.v) && (str = this.v) == null) {
                return;
            }
            kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.f10418e), null, null, new SkinRefreshController$showTutorialDialog$1(this, str, null), 3, null);
        }
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.BEAUTY;
    }

    public final BeautySkinRefreshViewNew H() {
        return this.f10419f;
    }

    public final us.pinguo.edit2020.bean.i I() {
        return this.f10420g;
    }

    public final String J() {
        return this.v;
    }

    public final kotlin.jvm.b.l<us.pinguo.edit2020.bean.x, kotlin.u> L() {
        return this.f10422i;
    }

    public final kotlin.jvm.b.l<Integer, kotlin.u> M() {
        return this.f10421h;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        return c.a.a(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return c.a.c(this);
    }

    public final kotlin.jvm.b.l<Boolean, kotlin.u> U() {
        return this.f10423j;
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        us.pinguo.edit2020.bean.i iVar = this.f10420g;
        boolean z = false;
        if (iVar != null && iVar.j()) {
            z = true;
        }
        if (z) {
            return this.f10424k.b(event);
        }
        return true;
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void d() {
        e0();
    }

    public final void e0() {
        this.v = null;
        BeautySkinRefreshViewNew beautySkinRefreshViewNew = this.f10419f;
        if (beautySkinRefreshViewNew != null) {
            beautySkinRefreshViewNew.i();
        }
        this.c.v(null);
        X(false);
        ((NumberTipView) this.b.findViewById(R.id.numberTipView)).a();
        TextView textView = (TextView) this.b.findViewById(R.id.txtEditHint);
        kotlin.jvm.internal.s.g(textView, "fragmentLayout.txtEditHint");
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        NoFaceTipView noFaceTipView = (NoFaceTipView) this.b.findViewById(R.id.noFaceTipView);
        kotlin.jvm.internal.s.g(noFaceTipView, "fragmentLayout.noFaceTipView");
        noFaceTipView.setVisibility(8);
        VdsAgent.onSetViewVisibility(noFaceTipView, 8);
        this.f10417d.d();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean f() {
        return c.a.b(this);
    }

    public final void f0(us.pinguo.edit2020.bean.i iVar) {
        this.f10420g = iVar;
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void g() {
        e0();
    }

    public final void g0(kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar) {
        this.f10423j = lVar;
    }

    public final void h0(kotlin.jvm.b.l<? super us.pinguo.edit2020.bean.x, kotlin.u> lVar) {
        this.f10422i = lVar;
    }

    public final void i0(kotlin.jvm.b.l<? super Integer, kotlin.u> lVar) {
        this.f10421h = lVar;
    }

    public final void k0(us.pinguo.edit2020.bean.h item, List<us.pinguo.edit2020.bean.i> dataList, int i2) {
        kotlin.jvm.internal.s.h(item, "item");
        kotlin.jvm.internal.s.h(dataList, "dataList");
        this.t = dataList;
        this.v = item.f();
        if (this.f10419f == null) {
            this.f10419f = T();
        }
        ConstraintLayout constraintLayout = this.b;
        int i3 = R.id.flContainerSubItems;
        ((FrameLayout) constraintLayout.findViewById(i3)).removeAllViews();
        ((FrameLayout) this.b.findViewById(i3)).addView(this.f10419f);
        Q(item);
        this.c.E();
        if (kotlin.jvm.internal.s.c(item.f(), this.m)) {
            i2 = 2;
        } else if (!this.f10417d.S()) {
            Iterator<us.pinguo.edit2020.bean.i> it = dataList.iterator();
            int i4 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (it.next().j()) {
                    i2 = i4;
                    break;
                } else {
                    i4++;
                }
            }
        }
        if ((!dataList.isEmpty()) && dataList.get(0).g().getNeedFace() && this.f10417d.v() > 1) {
            ArrayList<us.pinguo.edit2020.bean.i> arrayList = new ArrayList();
            for (Object obj : dataList) {
                if (!((us.pinguo.edit2020.bean.i) obj).j()) {
                    arrayList.add(obj);
                }
            }
            for (us.pinguo.edit2020.bean.i iVar : arrayList) {
                iVar.g().setCurrentValue(0);
            }
        }
        BeautySkinRefreshViewNew beautySkinRefreshViewNew = this.f10419f;
        if (beautySkinRefreshViewNew == null) {
            return;
        }
        beautySkinRefreshViewNew.j(dataList, i2, this.w.contains(item.f()));
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return c.a.d(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        return null;
    }

    @Override // us.pinguo.edit2020.b.c
    public void z(String str) {
        this.c.v(this.x);
        this.c.D(this.y);
        this.c.z(true);
    }
}
