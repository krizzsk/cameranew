package us.pinguo.edit2020.controller;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.common.widget.EditFunctionLayoutManager;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.b.c;
import us.pinguo.edit2020.bean.LongLegMode;
import us.pinguo.edit2020.view.LongLegHeightenView;
import us.pinguo.edit2020.view.p0;
import us.pinguo.edit2020.viewmodel.module.EditLongLegModule;
import us.pinguo.edit2020.widget.StovepipeAreaSelectorView;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: LongLegController.kt */
/* loaded from: classes4.dex */
public final class LongLegController extends GestureDetector.SimpleOnGestureListener implements e3, us.pinguo.edit2020.view.p0, us.pinguo.edit2020.b.c, us.pinguo.edit2020.view.h0, us.pinguo.edit2020.view.g0 {
    private final LifecycleOwner a;
    private final ConstraintLayout b;
    private final EditLongLegModule c;

    /* renamed from: d  reason: collision with root package name */
    private ConstraintLayout f10384d;

    /* renamed from: e  reason: collision with root package name */
    private final us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.b0> f10385e;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.edit2020.model.editgoto.b f10386f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f10387g;

    /* renamed from: h  reason: collision with root package name */
    private float f10388h;

    /* renamed from: i  reason: collision with root package name */
    private float f10389i;

    /* compiled from: LongLegController.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LongLegMode.values().length];
            iArr[LongLegMode.Vertical.ordinal()] = 1;
            iArr[LongLegMode.Horizontal.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: LongLegController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements us.pinguo.ui.widget.h {
        b() {
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            us.pinguo.edit2020.bean.b0 c = LongLegController.this.c.c();
            if (c != null) {
                LongLegController longLegController = LongLegController.this;
                c.t(i2);
                kotlin.jvm.b.q<Float, Float, Integer, kotlin.u> l2 = c.l();
                if (l2 != null) {
                    ConstraintLayout constraintLayout = longLegController.b;
                    int i3 = R.id.unityContainer;
                    l2.invoke(Float.valueOf(((FrameLayout) constraintLayout.findViewById(i3)).getWidth()), Float.valueOf(((FrameLayout) longLegController.b.findViewById(i3)).getHeight()), 1);
                }
                if (c.k() == LongLegMode.Free) {
                    ConstraintLayout constraintLayout2 = longLegController.b;
                    int i4 = R.id.stovepipeAreaSelectorView;
                    StovepipeAreaSelectorView stovepipeAreaSelectorView = (StovepipeAreaSelectorView) constraintLayout2.findViewById(i4);
                    kotlin.jvm.internal.s.g(stovepipeAreaSelectorView, "fragmentLayout.stovepipeAreaSelectorView");
                    if (!(stovepipeAreaSelectorView.getVisibility() == 0)) {
                        StovepipeAreaSelectorView stovepipeAreaSelectorView2 = (StovepipeAreaSelectorView) longLegController.b.findViewById(i4);
                        kotlin.jvm.internal.s.g(stovepipeAreaSelectorView2, "fragmentLayout.stovepipeAreaSelectorView");
                        stovepipeAreaSelectorView2.setVisibility(0);
                        VdsAgent.onSetViewVisibility(stovepipeAreaSelectorView2, 0);
                    }
                }
            }
            LongLegController.this.f10385e.notifyItemChanged(0, Integer.valueOf(LongLegController.this.f10385e.getItemCount()));
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            us.pinguo.edit2020.bean.b0 c = LongLegController.this.c.c();
            if (c == null) {
                return;
            }
            LongLegController longLegController = LongLegController.this;
            if (c.k() == LongLegMode.Free) {
                ConstraintLayout constraintLayout = longLegController.b;
                int i3 = R.id.stovepipeAreaSelectorView;
                StovepipeAreaSelectorView stovepipeAreaSelectorView = (StovepipeAreaSelectorView) constraintLayout.findViewById(i3);
                kotlin.jvm.internal.s.g(stovepipeAreaSelectorView, "fragmentLayout.stovepipeAreaSelectorView");
                if (stovepipeAreaSelectorView.getVisibility() == 0) {
                    StovepipeAreaSelectorView stovepipeAreaSelectorView2 = (StovepipeAreaSelectorView) longLegController.b.findViewById(i3);
                    kotlin.jvm.internal.s.g(stovepipeAreaSelectorView2, "fragmentLayout.stovepipeAreaSelectorView");
                    stovepipeAreaSelectorView2.setVisibility(8);
                    VdsAgent.onSetViewVisibility(stovepipeAreaSelectorView2, 8);
                }
            } else {
                ((LongLegHeightenView) longLegController.b.findViewById(R.id.longLegHeightenView)).d(true);
            }
            c.t(i2);
            kotlin.jvm.b.q<Float, Float, Integer, kotlin.u> l2 = c.l();
            if (l2 == null) {
                return;
            }
            ConstraintLayout constraintLayout2 = longLegController.b;
            int i4 = R.id.unityContainer;
            l2.invoke(Float.valueOf(((FrameLayout) constraintLayout2.findViewById(i4)).getWidth()), Float.valueOf(((FrameLayout) longLegController.b.findViewById(i4)).getHeight()), 0);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: LongLegController.kt */
    /* loaded from: classes4.dex */
    public static final class c implements StovepipeAreaSelectorView.a {
        c() {
        }

        @Override // us.pinguo.edit2020.widget.StovepipeAreaSelectorView.a
        public void a(float f2, float f3, float f4, float f5, float f6) {
            us.pinguo.edit2020.bean.b0 c = LongLegController.this.c.c();
            if (c != null) {
                LongLegController longLegController = LongLegController.this;
                if (c.j() != 0) {
                    longLegController.c.a();
                }
                c.p(f2);
                c.q(f3);
                c.x(f4);
                c.s(f5);
                c.w(f6);
                c.t(0);
            }
            ConstraintLayout constraintLayout = LongLegController.this.f10384d;
            StickySeekBar stickySeekBar = constraintLayout == null ? null : (StickySeekBar) constraintLayout.findViewById(R.id.sbLongLeg);
            if (stickySeekBar == null) {
                return;
            }
            stickySeekBar.setProgress(0);
        }
    }

    public LongLegController(LifecycleOwner lifecycleOwner, ConstraintLayout fragmentLayout, EditLongLegModule longLegModule) {
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        kotlin.jvm.internal.s.h(fragmentLayout, "fragmentLayout");
        kotlin.jvm.internal.s.h(longLegModule, "longLegModule");
        this.a = lifecycleOwner;
        this.b = fragmentLayout;
        this.c = longLegModule;
        this.f10385e = new us.pinguo.edit2020.adapter.a0<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean z) {
        us.pinguo.edit2020.bean.b0 c2;
        LongLegMode k2;
        final float height;
        Log.e(CrashlyticsReport.DEVELOPMENT_PLATFORM_UNITY, "[onBodyBeautifyToolUpdated]:" + f9 + ", " + f10);
        if (!z || (c2 = this.c.c()) == null || (k2 = c2.k()) == null) {
            return;
        }
        int i2 = a.a[k2.ordinal()];
        if (i2 == 1) {
            height = f5 * ((FrameLayout) this.b.findViewById(R.id.unityContainer)).getHeight();
        } else if (i2 != 2) {
            return;
        } else {
            height = f4 * ((FrameLayout) this.b.findViewById(R.id.unityContainer)).getWidth();
        }
        ConstraintLayout constraintLayout = this.b;
        int i3 = R.id.unityContainer;
        this.f10388h = Math.min(f9, ((FrameLayout) constraintLayout.findViewById(i3)).getWidth());
        this.f10389i = Math.min(f10, ((FrameLayout) this.b.findViewById(i3)).getHeight());
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.w1
            @Override // java.lang.Runnable
            public final void run() {
                LongLegController.D(LongLegController.this, height);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(LongLegController this$0, float f2) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        LongLegHeightenView longLegHeightenView = (LongLegHeightenView) this$0.b.findViewById(R.id.longLegHeightenView);
        longLegHeightenView.setFrameSize(f2);
        longLegHeightenView.d(false);
    }

    private final void E() {
        us.pinguo.edit2020.bean.b0 c2 = this.c.c();
        if (c2 != null) {
            c2.t(0);
        }
        ConstraintLayout constraintLayout = this.f10384d;
        StickySeekBar stickySeekBar = constraintLayout == null ? null : (StickySeekBar) constraintLayout.findViewById(R.id.sbLongLeg);
        if (stickySeekBar != null) {
            stickySeekBar.setProgress(0);
        }
        ((StovepipeAreaSelectorView) this.b.findViewById(R.id.stovepipeAreaSelectorView)).x();
    }

    private final void H() {
        Context context;
        Context context2;
        ConstraintLayout constraintLayout = this.f10384d;
        CharSequence charSequence = null;
        TextView textView = constraintLayout == null ? null : (TextView) constraintLayout.findViewById(R.id.txtShorten);
        if (textView != null) {
            ConstraintLayout constraintLayout2 = this.f10384d;
            textView.setText((constraintLayout2 == null || (context2 = constraintLayout2.getContext()) == null) ? null : context2.getText(R.string.long_leg_widen));
        }
        ConstraintLayout constraintLayout3 = this.f10384d;
        TextView textView2 = constraintLayout3 == null ? null : (TextView) constraintLayout3.findViewById(R.id.txtHeighten);
        if (textView2 != null) {
            ConstraintLayout constraintLayout4 = this.f10384d;
            if (constraintLayout4 != null && (context = constraintLayout4.getContext()) != null) {
                charSequence = context.getText(R.string.long_leg_stovepip);
            }
            textView2.setText(charSequence);
        }
        ConstraintLayout constraintLayout5 = this.b;
        int i2 = R.id.stovepipeAreaSelectorView;
        StovepipeAreaSelectorView stovepipeAreaSelectorView = (StovepipeAreaSelectorView) constraintLayout5.findViewById(i2);
        kotlin.jvm.internal.s.g(stovepipeAreaSelectorView, "fragmentLayout.stovepipeAreaSelectorView");
        if (!(stovepipeAreaSelectorView.getVisibility() == 0)) {
            StovepipeAreaSelectorView stovepipeAreaSelectorView2 = (StovepipeAreaSelectorView) this.b.findViewById(i2);
            kotlin.jvm.internal.s.g(stovepipeAreaSelectorView2, "fragmentLayout.stovepipeAreaSelectorView");
            stovepipeAreaSelectorView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(stovepipeAreaSelectorView2, 0);
        }
        E();
        this.c.b(true);
    }

    private final void I(int i2) {
        if (i2 == 0) {
            return;
        }
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        if (us.pinguo.repository2020.utils.o.b(oVar, "tutorial_thin", true, null, 4, null)) {
            us.pinguo.repository2020.utils.o.n(oVar, "tutorial_thin", false, null, 4, null);
            LifecycleOwnerKt.getLifecycleScope(this.a).launchWhenResumed(new LongLegController$showTutorial$1(this, null));
        }
    }

    private final void r(boolean z) {
        ((FrameLayout) this.b.findViewById(R.id.flIrregularPanelContainer)).removeAllViews();
        LongLegHeightenView longLegHeightenView = (LongLegHeightenView) this.b.findViewById(R.id.longLegHeightenView);
        kotlin.jvm.internal.s.g(longLegHeightenView, "fragmentLayout.longLegHeightenView");
        longLegHeightenView.setVisibility(4);
        VdsAgent.onSetViewVisibility(longLegHeightenView, 4);
        StovepipeAreaSelectorView stovepipeAreaSelectorView = (StovepipeAreaSelectorView) this.b.findViewById(R.id.stovepipeAreaSelectorView);
        kotlin.jvm.internal.s.g(stovepipeAreaSelectorView, "fragmentLayout.stovepipeAreaSelectorView");
        stovepipeAreaSelectorView.setVisibility(8);
        VdsAgent.onSetViewVisibility(stovepipeAreaSelectorView, 8);
        ConstraintLayout constraintLayout = this.f10384d;
        StickySeekBar stickySeekBar = constraintLayout == null ? null : (StickySeekBar) constraintLayout.findViewById(R.id.sbLongLeg);
        if (stickySeekBar != null) {
            stickySeekBar.setProgress(0);
        }
        this.f10386f = null;
        this.c.g(z);
    }

    private final int s() {
        String d2;
        boolean n;
        us.pinguo.edit2020.model.editgoto.b bVar = this.f10386f;
        if (bVar == null || (d2 = bVar.d()) == null) {
            return 0;
        }
        if (d2.length() == 0) {
            return 0;
        }
        n = kotlin.text.t.n(d2, "heighten", true);
        return n ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(int i2, us.pinguo.edit2020.bean.b0 b0Var) {
        if (!kotlin.jvm.internal.s.c(this.c.c(), b0Var)) {
            us.pinguo.edit2020.bean.b0 c2 = this.c.c();
            if (!(c2 != null && c2.j() == 0)) {
                us.pinguo.edit2020.bean.b0 c3 = this.c.c();
                if (c3 != null) {
                    c3.r(true);
                }
                us.pinguo.edit2020.bean.b0 c4 = this.c.c();
                if (c4 != null) {
                    c4.t(0);
                }
            }
        }
        this.c.h(b0Var);
        int i3 = a.a[b0Var.k().ordinal()];
        if (i3 == 1) {
            ConstraintLayout constraintLayout = this.b;
            int i4 = R.id.longLegHeightenView;
            LongLegHeightenView longLegHeightenView = (LongLegHeightenView) constraintLayout.findViewById(i4);
            kotlin.jvm.internal.s.g(longLegHeightenView, "fragmentLayout.longLegHeightenView");
            longLegHeightenView.setVisibility(0);
            VdsAgent.onSetViewVisibility(longLegHeightenView, 0);
            x();
            ((LongLegHeightenView) this.b.findViewById(i4)).setMode(LongLegMode.Vertical, this.f10389i / 2.0f);
        } else if (i3 != 2) {
            LongLegHeightenView longLegHeightenView2 = (LongLegHeightenView) this.b.findViewById(R.id.longLegHeightenView);
            kotlin.jvm.internal.s.g(longLegHeightenView2, "fragmentLayout.longLegHeightenView");
            longLegHeightenView2.setVisibility(4);
            VdsAgent.onSetViewVisibility(longLegHeightenView2, 4);
            H();
        } else {
            ConstraintLayout constraintLayout2 = this.b;
            int i5 = R.id.longLegHeightenView;
            LongLegHeightenView longLegHeightenView3 = (LongLegHeightenView) constraintLayout2.findViewById(i5);
            kotlin.jvm.internal.s.g(longLegHeightenView3, "fragmentLayout.longLegHeightenView");
            longLegHeightenView3.setVisibility(0);
            VdsAgent.onSetViewVisibility(longLegHeightenView3, 0);
            x();
            ((LongLegHeightenView) this.b.findViewById(i5)).setMode(LongLegMode.Horizontal, this.f10388h / 2.0f);
        }
        I(i2);
        if (this.f10387g == null) {
            this.f10387g = new ArrayList();
        }
        List<String> list = this.f10387g;
        if (list != null) {
            list.add(b0Var.f());
        }
        us.pinguo.foundation.statistics.h.b.k0(b0Var.f(), null, "click");
    }

    private final void x() {
        Context context;
        Context context2;
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.stovepipeAreaSelectorView;
        StovepipeAreaSelectorView stovepipeAreaSelectorView = (StovepipeAreaSelectorView) constraintLayout.findViewById(i2);
        kotlin.jvm.internal.s.g(stovepipeAreaSelectorView, "fragmentLayout.stovepipeAreaSelectorView");
        if (stovepipeAreaSelectorView.getVisibility() == 0) {
            StovepipeAreaSelectorView stovepipeAreaSelectorView2 = (StovepipeAreaSelectorView) this.b.findViewById(i2);
            kotlin.jvm.internal.s.g(stovepipeAreaSelectorView2, "fragmentLayout.stovepipeAreaSelectorView");
            stovepipeAreaSelectorView2.setVisibility(8);
            VdsAgent.onSetViewVisibility(stovepipeAreaSelectorView2, 8);
        }
        this.c.b(false);
        ConstraintLayout constraintLayout2 = this.f10384d;
        TextView textView = constraintLayout2 == null ? null : (TextView) constraintLayout2.findViewById(R.id.txtShorten);
        if (textView != null) {
            ConstraintLayout constraintLayout3 = this.f10384d;
            textView.setText((constraintLayout3 == null || (context2 = constraintLayout3.getContext()) == null) ? null : context2.getText(R.string.long_leg_shorten));
        }
        ConstraintLayout constraintLayout4 = this.f10384d;
        TextView textView2 = constraintLayout4 == null ? null : (TextView) constraintLayout4.findViewById(R.id.txtHeighten);
        if (textView2 != null) {
            ConstraintLayout constraintLayout5 = this.f10384d;
            textView2.setText((constraintLayout5 == null || (context = constraintLayout5.getContext()) == null) ? null : context.getText(R.string.long_leg_heighten));
        }
        ConstraintLayout constraintLayout6 = this.f10384d;
        StickySeekBar stickySeekBar = constraintLayout6 != null ? (StickySeekBar) constraintLayout6.findViewById(R.id.sbLongLeg) : null;
        if (stickySeekBar == null) {
            return;
        }
        stickySeekBar.setProgress(0);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.BEAUTY;
    }

    public final void G(us.pinguo.edit2020.model.editgoto.b bVar) {
        this.f10386f = bVar;
    }

    @Override // us.pinguo.edit2020.view.p0
    public void P() {
        p0.a.d(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        return c.a.a(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return c.a.c(this);
    }

    @Override // us.pinguo.edit2020.view.g0
    public void a(float f2, float f3, float f4, float f5, boolean z) {
        us.pinguo.edit2020.bean.b0 c2 = this.c.c();
        if (c2 == null) {
            return;
        }
        if (c2.k() == LongLegMode.Vertical || c2.k() == LongLegMode.Horizontal) {
            if (z && c2.j() != 0) {
                this.c.a();
                ((StickySeekBar) this.b.findViewById(R.id.sbLongLeg)).setProgress(0);
                c2.t(0);
            }
            c2.p((f2 + f4) * 0.5f);
            c2.q((f3 + f5) * 0.5f);
            c2.x(f4 - f2);
            c2.s(f5 - f3);
        }
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        us.pinguo.edit2020.bean.b0 c2 = this.c.c();
        if ((c2 == null ? null : c2.k()) == LongLegMode.Free) {
            return ((StovepipeAreaSelectorView) this.b.findViewById(R.id.stovepipeAreaSelectorView)).w(event);
        }
        return ((LongLegHeightenView) this.b.findViewById(R.id.longLegHeightenView)).g(event);
    }

    @Override // us.pinguo.edit2020.view.h0
    public void c(LongLegMode mode) {
        kotlin.jvm.internal.s.h(mode, "mode");
        LongLegMode longLegMode = LongLegMode.Vertical;
        String name = longLegMode.name();
        us.pinguo.edit2020.bean.b0 c2 = this.c.c();
        if (c2 != null) {
            c2.u(mode);
            this.c.h(c2);
            if (c2.j() != 0) {
                c2.r(true);
                c2.t(0);
            }
        }
        ((StickySeekBar) this.b.findViewById(R.id.sbLongLeg)).setProgress(0);
        if (mode == longLegMode) {
            ((LongLegHeightenView) this.b.findViewById(R.id.longLegHeightenView)).setMode(longLegMode, this.f10389i / 2.0f);
            name = LongLegMode.Horizontal.name();
        } else {
            LongLegMode longLegMode2 = LongLegMode.Horizontal;
            if (mode == longLegMode2) {
                ((LongLegHeightenView) this.b.findViewById(R.id.longLegHeightenView)).setMode(longLegMode2, this.f10388h / 2.0f);
                name = longLegMode.name();
            }
        }
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        if (name.length() > 0) {
            StringBuilder sb = new StringBuilder();
            String valueOf = String.valueOf(name.charAt(0));
            kotlin.jvm.internal.s.f(valueOf, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = valueOf.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.s.g(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            sb.append((Object) lowerCase);
            String substring = name.substring(1);
            kotlin.jvm.internal.s.g(substring, "this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            name = sb.toString();
        }
        iVar.k0(null, name, "change_direction");
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void d() {
        int i2;
        List O;
        String J;
        r(true);
        List<String> list = this.f10387g;
        if (list != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            i2 = kotlin.collections.u.i(list);
            if (i2 >= 0) {
                while (true) {
                    int i3 = i2 - 1;
                    linkedHashSet.add(list.get(i2));
                    if (i3 < 0) {
                        break;
                    }
                    i2 = i3;
                }
            }
            O = kotlin.collections.c0.O(linkedHashSet);
            J = kotlin.collections.c0.J(O, PGTransHeader.CONNECTOR, null, null, 0, null, null, 62, null);
            us.pinguo.foundation.statistics.h.b.k0(J, null, "save");
        }
        this.f10387g = null;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean f() {
        return c.a.b(this);
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void g() {
        r(false);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void j() {
        p0.a.a(this);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void k(boolean z) {
        ((LongLegHeightenView) this.b.findViewById(R.id.longLegHeightenView)).d(z);
        us.pinguo.edit2020.bean.b0 c2 = this.c.c();
        if ((c2 == null ? null : c2.k()) == LongLegMode.Free) {
            StovepipeAreaSelectorView stovepipeAreaSelectorView = (StovepipeAreaSelectorView) this.b.findViewById(R.id.stovepipeAreaSelectorView);
            kotlin.jvm.internal.s.g(stovepipeAreaSelectorView, "fragmentLayout.stovepipeAreaSelectorView");
            int i2 = z ^ true ? 0 : 8;
            stovepipeAreaSelectorView.setVisibility(i2);
            VdsAgent.onSetViewVisibility(stovepipeAreaSelectorView, i2);
        }
        UnityEditCaller.Common.showOriginalTexture(z);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void m() {
        p0.a.f(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return c.a.d(this);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void t(boolean z) {
        p0.a.c(this, z);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        return this.c.f();
    }

    @Override // us.pinguo.edit2020.view.p0
    public void y() {
        p0.a.b(this);
    }

    @Override // us.pinguo.edit2020.b.c
    public void z(String str) {
        ConstraintLayout constraintLayout = this.f10384d;
        if (constraintLayout == null) {
            View inflate = LayoutInflater.from(this.b.getContext()).inflate(R.layout.layout_long_leg, (ViewGroup) ((FrameLayout) this.b.findViewById(R.id.flIrregularPanelContainer)), false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            constraintLayout = (ConstraintLayout) inflate;
            this.f10384d = constraintLayout;
            RecyclerView recyclerView = (RecyclerView) constraintLayout.findViewById(R.id.rvLongLeg);
            EditFunctionLayoutManager editFunctionLayoutManager = new EditFunctionLayoutManager(this.b.getContext(), 0, false);
            recyclerView.setLayoutManager(editFunctionLayoutManager);
            us.pinguo.common.widget.g gVar = new us.pinguo.common.widget.g();
            Context context = this.b.getContext();
            kotlin.jvm.internal.s.g(context, "fragmentLayout.context");
            Context context2 = this.b.getContext();
            kotlin.jvm.internal.s.g(context2, "fragmentLayout.context");
            gVar.a(context, 2, editFunctionLayoutManager.a(context2, 2));
            recyclerView.addItemDecoration(gVar);
            this.f10385e.x(true);
            recyclerView.setAdapter(this.f10385e);
            int i2 = R.id.sbLongLeg;
            ((StickySeekBar) constraintLayout.findViewById(i2)).setValues(-100, 100, 0, 0);
            ((StickySeekBar) constraintLayout.findViewById(i2)).setTrackListener(new b());
            ((StovepipeAreaSelectorView) this.b.findViewById(R.id.stovepipeAreaSelectorView)).setOnStovepipeSelectorListener(new c());
            this.c.d().d0(new LongLegController$onWorkflowStarted$3(this));
        }
        us.pinguo.edit2020.bean.u0 value = this.c.d().L().getValue();
        if (value != null) {
            this.f10388h = value.e();
            this.f10389i = value.d();
        }
        FrameLayout it = (FrameLayout) this.b.findViewById(R.id.flIrregularPanelContainer);
        it.addView(constraintLayout);
        kotlin.jvm.internal.s.g(it, "it");
        it.setVisibility(0);
        VdsAgent.onSetViewVisibility(it, 0);
        this.f10385e.y(Boolean.TRUE);
        this.f10385e.A(new LongLegController$onWorkflowStarted$6(this));
        int s = s();
        this.c.d().s0(new LongLegController$onWorkflowStarted$7(this, s));
        us.pinguo.edit2020.adapter.a0.u(this.f10385e, this.c.e(), Integer.valueOf(s), false, 4, null);
        LongLegHeightenView longLegHeightenView = (LongLegHeightenView) this.b.findViewById(R.id.longLegHeightenView);
        if (s == 0) {
            kotlin.jvm.internal.s.g(longLegHeightenView, "");
            longLegHeightenView.setVisibility(0);
            VdsAgent.onSetViewVisibility(longLegHeightenView, 0);
        }
        longLegHeightenView.setMode(LongLegMode.Vertical, this.f10389i / 2.0f);
        longLegHeightenView.setOnAreaChangeListener(this);
        longLegHeightenView.setOnRotateListener(this);
    }
}
