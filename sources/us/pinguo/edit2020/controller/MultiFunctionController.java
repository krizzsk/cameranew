package us.pinguo.edit2020.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.pinguo.lib.LowerResolutionCpuMobile;
import java.util.List;
import java.util.Objects;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.b.c;
import us.pinguo.edit2020.view.SkinToneAdjustView;
import us.pinguo.edit2020.viewmodel.module.EditBeautyModule;
import us.pinguo.edit2020.widget.CenterLayoutManager;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.repository2020.entity.BeautyEditData;
/* compiled from: MultiFunctionController.kt */
/* loaded from: classes4.dex */
public final class MultiFunctionController implements us.pinguo.edit2020.b.c {
    private final ConstraintLayout a;
    private final EditBeautyModule b;
    private Boolean c;

    /* renamed from: d  reason: collision with root package name */
    private int f10408d;

    /* renamed from: e  reason: collision with root package name */
    private String[] f10409e;

    /* renamed from: f  reason: collision with root package name */
    private CenterLayoutManager f10410f;

    /* renamed from: g  reason: collision with root package name */
    private us.pinguo.common.widget.g f10411g;

    /* renamed from: h  reason: collision with root package name */
    private final RecyclerView f10412h;

    /* renamed from: i  reason: collision with root package name */
    private final us.pinguo.edit2020.adapter.k0 f10413i;

    /* renamed from: j  reason: collision with root package name */
    private List<? extends List<us.pinguo.edit2020.bean.i>> f10414j;

    /* renamed from: k  reason: collision with root package name */
    private SkinToneAdjustView f10415k;

    /* renamed from: l  reason: collision with root package name */
    private a f10416l;

    /* compiled from: MultiFunctionController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements SkinToneAdjustView.a {
        a() {
        }

        @Override // us.pinguo.edit2020.view.SkinToneAdjustView.a
        public void a(String type, int i2) {
            kotlin.jvm.internal.s.h(type, "type");
            if (LowerResolutionCpuMobile.INSTANCE.isInLowerResolutionList()) {
                BeautyEditData g2 = MultiFunctionController.this.r().g();
                MultiFunctionController multiFunctionController = MultiFunctionController.this;
                g2.setCurrentValue(i2);
                multiFunctionController.b.q0(g2);
            }
        }

        @Override // us.pinguo.edit2020.view.SkinToneAdjustView.a
        public void b(String type, int i2) {
            kotlin.jvm.internal.s.h(type, "type");
            BeautyEditData g2 = MultiFunctionController.this.r().g();
            MultiFunctionController multiFunctionController = MultiFunctionController.this;
            g2.setCurrentValue(i2);
            if (LowerResolutionCpuMobile.INSTANCE.isInLowerResolutionList()) {
                return;
            }
            multiFunctionController.b.q0(g2);
        }
    }

    public MultiFunctionController(ConstraintLayout fragmentLayout, EditBeautyModule bottomModule) {
        kotlin.jvm.internal.s.h(fragmentLayout, "fragmentLayout");
        kotlin.jvm.internal.s.h(bottomModule, "bottomModule");
        this.a = fragmentLayout;
        this.b = bottomModule;
        this.f10408d = 1;
        this.f10412h = new RecyclerView(fragmentLayout.getContext());
        this.f10413i = new us.pinguo.edit2020.adapter.k0();
        this.f10416l = new a();
        w();
    }

    private final void A() {
        ConstraintLayout constraintLayout = this.a;
        SkinToneAdjustView skinToneAdjustView = this.f10415k;
        if (skinToneAdjustView != null) {
            constraintLayout.removeView(skinToneAdjustView);
        } else {
            kotlin.jvm.internal.s.z("skinToneAdjustView");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(us.pinguo.edit2020.bean.i iVar) {
        BeautyEditData i2 = iVar.i();
        SkinToneAdjustView skinToneAdjustView = this.f10415k;
        if (skinToneAdjustView != null) {
            skinToneAdjustView.setSeekBarValue(i2.getMinValue(), i2.getMaxValue(), i2.getCurrentValue(), i2.getDefaultValue());
            SkinToneAdjustView skinToneAdjustView2 = this.f10415k;
            if (skinToneAdjustView2 != null) {
                skinToneAdjustView2.o(y(iVar));
                return;
            } else {
                kotlin.jvm.internal.s.z("skinToneAdjustView");
                throw null;
            }
        }
        kotlin.jvm.internal.s.z("skinToneAdjustView");
        throw null;
    }

    private final void p() {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, us.pinguo.edit2020.utils.d.i(R.dimen.pg_sdk_edit_tab_height));
        int i2 = R.id.frameLayout;
        layoutParams.startToStart = i2;
        layoutParams.endToEnd = i2;
        layoutParams.bottomToTop = R.id.flContainerSubItems;
        SkinToneAdjustView skinToneAdjustView = this.f10415k;
        if (skinToneAdjustView != null) {
            if (skinToneAdjustView == null) {
                kotlin.jvm.internal.s.z("skinToneAdjustView");
                throw null;
            } else if (skinToneAdjustView.getParent() != null) {
                SkinToneAdjustView skinToneAdjustView2 = this.f10415k;
                if (skinToneAdjustView2 == null) {
                    kotlin.jvm.internal.s.z("skinToneAdjustView");
                    throw null;
                }
                ViewParent parent = skinToneAdjustView2.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) parent;
                SkinToneAdjustView skinToneAdjustView3 = this.f10415k;
                if (skinToneAdjustView3 == null) {
                    kotlin.jvm.internal.s.z("skinToneAdjustView");
                    throw null;
                }
                viewGroup.removeView(skinToneAdjustView3);
            }
        }
        ConstraintLayout constraintLayout = this.a;
        SkinToneAdjustView skinToneAdjustView4 = this.f10415k;
        if (skinToneAdjustView4 != null) {
            constraintLayout.addView(skinToneAdjustView4, layoutParams);
        } else {
            kotlin.jvm.internal.s.z("skinToneAdjustView");
            throw null;
        }
    }

    private final void q() {
        this.c = null;
        String[] strArr = this.f10409e;
        if (strArr != null) {
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                String[] strArr2 = this.f10409e;
                if (strArr2 == null) {
                    kotlin.jvm.internal.s.z("toggleSwitchArrays");
                    throw null;
                } else {
                    strArr2[i2] = "hardness";
                    i2 = i3;
                }
            }
            A();
            return;
        }
        kotlin.jvm.internal.s.z("toggleSwitchArrays");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final us.pinguo.edit2020.bean.i r() {
        SkinToneAdjustView skinToneAdjustView = this.f10415k;
        if (skinToneAdjustView == null) {
            kotlin.jvm.internal.s.z("skinToneAdjustView");
            throw null;
        } else if (kotlin.jvm.internal.s.c("hardness", skinToneAdjustView.g())) {
            List<? extends List<us.pinguo.edit2020.bean.i>> list = this.f10414j;
            if (list != null) {
                return list.get(0).get(this.f10408d);
            }
            kotlin.jvm.internal.s.z("functionLists");
            throw null;
        } else {
            List<? extends List<us.pinguo.edit2020.bean.i>> list2 = this.f10414j;
            if (list2 != null) {
                return list2.get(1).get(s());
            }
            kotlin.jvm.internal.s.z("functionLists");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int s() {
        return this.f10408d - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int i2, us.pinguo.edit2020.bean.i iVar) {
        C(iVar);
        if (y(iVar)) {
            this.b.t0(null);
            this.b.q0(iVar.g());
            return;
        }
        List<? extends List<us.pinguo.edit2020.bean.i>> list = this.f10414j;
        if (list != null) {
            us.pinguo.edit2020.bean.i iVar2 = list.get(0).get(i2);
            List<? extends List<us.pinguo.edit2020.bean.i>> list2 = this.f10414j;
            if (list2 != null) {
                this.b.t0(iVar2);
                this.b.q0(iVar2.g());
                this.b.q0(list2.get(1).get(s()).g());
                return;
            }
            kotlin.jvm.internal.s.z("functionLists");
            throw null;
        }
        kotlin.jvm.internal.s.z("functionLists");
        throw null;
    }

    private final void w() {
        this.c = Boolean.TRUE;
        List<List<us.pinguo.edit2020.bean.i>> F = this.b.F();
        this.f10414j = F;
        if (F != null) {
            int size = F.get(0).size() - 1;
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = "hardness";
            }
            this.f10409e = strArr;
            RecyclerView recyclerView = this.f10412h;
            Context context = recyclerView.getContext();
            kotlin.jvm.internal.s.g(context, "context");
            this.f10410f = new CenterLayoutManager(context, 0, false);
            this.f10411g = new us.pinguo.common.widget.g();
            CenterLayoutManager centerLayoutManager = this.f10410f;
            if (centerLayoutManager != null) {
                recyclerView.setLayoutManager(centerLayoutManager);
                us.pinguo.common.widget.g gVar = this.f10411g;
                if (gVar != null) {
                    recyclerView.addItemDecoration(gVar);
                    View inflate = LayoutInflater.from(this.f10412h.getContext()).inflate(R.layout.layout_skin_tone_adjust, (ViewGroup) null);
                    Objects.requireNonNull(inflate, "null cannot be cast to non-null type us.pinguo.edit2020.view.SkinToneAdjustView");
                    SkinToneAdjustView skinToneAdjustView = (SkinToneAdjustView) inflate;
                    this.f10415k = skinToneAdjustView;
                    if (skinToneAdjustView != null) {
                        skinToneAdjustView.setOnSeekbarChangeListener(this.f10416l);
                        SkinToneAdjustView skinToneAdjustView2 = this.f10415k;
                        if (skinToneAdjustView2 != null) {
                            skinToneAdjustView2.setOnToggleSwitch(new MultiFunctionController$initView$3(this));
                            this.f10413i.k(new MultiFunctionController$initView$4(this));
                            return;
                        }
                        kotlin.jvm.internal.s.z("skinToneAdjustView");
                        throw null;
                    }
                    kotlin.jvm.internal.s.z("skinToneAdjustView");
                    throw null;
                }
                kotlin.jvm.internal.s.z("itemDecoration");
                throw null;
            }
            kotlin.jvm.internal.s.z("centerLayoutManager");
            throw null;
        }
        kotlin.jvm.internal.s.z("functionLists");
        throw null;
    }

    private final boolean y(us.pinguo.edit2020.bean.i iVar) {
        return kotlin.jvm.internal.s.c(iVar.f(), PortalFollowFeeds.TYPE_NONE);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.BEAUTY;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        return c.a.a(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return c.a.c(this);
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void d() {
        q();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean f() {
        return c.a.b(this);
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void g() {
        q();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return c.a.d(this);
    }

    public final void show() {
        p();
        List<List<us.pinguo.edit2020.bean.i>> F = this.b.F();
        this.f10414j = F;
        if (F != null) {
            this.f10413i.j(F.get(0), 1);
            this.f10412h.setAdapter(this.f10413i);
            us.pinguo.common.widget.g gVar = this.f10411g;
            if (gVar != null) {
                Context b = us.pinguo.foundation.e.b();
                kotlin.jvm.internal.s.g(b, "getAppContext()");
                int itemCount = this.f10413i.getItemCount();
                CenterLayoutManager centerLayoutManager = this.f10410f;
                if (centerLayoutManager != null) {
                    Context b2 = us.pinguo.foundation.e.b();
                    kotlin.jvm.internal.s.g(b2, "getAppContext()");
                    gVar.a(b, itemCount, centerLayoutManager.a(b2, this.f10413i.getItemCount()));
                    PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.a.findViewById(R.id.bottomTabLayout);
                    kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "");
                    PGEditBottomTabLayout.h(pGEditBottomTabLayout, this.b.E(), false, null, 6, null);
                    pGEditBottomTabLayout.B();
                    ConstraintLayout constraintLayout = this.a;
                    int i2 = R.id.flContainerSubItems;
                    ((FrameLayout) constraintLayout.findViewById(i2)).removeAllViews();
                    ((FrameLayout) this.a.findViewById(i2)).addView(this.f10412h);
                    return;
                }
                kotlin.jvm.internal.s.z("centerLayoutManager");
                throw null;
            }
            kotlin.jvm.internal.s.z("itemDecoration");
            throw null;
        }
        kotlin.jvm.internal.s.z("functionLists");
        throw null;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        return null;
    }

    public final Boolean x() {
        return this.c;
    }

    @Override // us.pinguo.edit2020.b.c
    public void z(String str) {
        show();
    }
}
