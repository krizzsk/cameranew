package us.pinguo.edit2020.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.LazyThreadSafetyMode;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.b.c;
import us.pinguo.edit2020.bean.Facial3DFunctionConfig;
import us.pinguo.edit2020.view.Facial3DAdjustView;
import us.pinguo.edit2020.viewmodel.module.EditBeautyModule;
import us.pinguo.edit2020.widget.CenterLayoutManager;
/* compiled from: Facial3DController.kt */
/* loaded from: classes4.dex */
public final class Facial3DController implements e3, us.pinguo.edit2020.b.c {
    private final EditBeautyModule a;
    private final FrameLayout b;
    private final PGEditBottomTabLayout c;

    /* renamed from: d  reason: collision with root package name */
    private final ViewStub f10361d;

    /* renamed from: e  reason: collision with root package name */
    private Facial3DAdjustView f10362e;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.edit2020.adapter.c0 f10363f;

    /* renamed from: g  reason: collision with root package name */
    private int f10364g;

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.f f10365h;

    /* compiled from: Facial3DController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Facial3DAdjustView.a {
        a() {
        }

        @Override // us.pinguo.edit2020.view.Facial3DAdjustView.a
        public void b(int i2) {
            us.pinguo.edit2020.adapter.c0 c0Var = Facial3DController.this.f10363f;
            if (c0Var == null) {
                return;
            }
            c0Var.H();
        }

        @Override // us.pinguo.edit2020.view.Facial3DAdjustView.a
        public void c(int i2) {
            us.pinguo.edit2020.bean.q g2;
            Facial3DAdjustView facial3DAdjustView = Facial3DController.this.f10362e;
            if (facial3DAdjustView == null || (g2 = facial3DAdjustView.g()) == null) {
                return;
            }
            Facial3DController.this.a.a(g2);
        }
    }

    public Facial3DController(EditBeautyModule bottomModule, FrameLayout container, PGEditBottomTabLayout tabLayout, ViewStub adjustStub) {
        kotlin.f a2;
        kotlin.jvm.internal.s.h(bottomModule, "bottomModule");
        kotlin.jvm.internal.s.h(container, "container");
        kotlin.jvm.internal.s.h(tabLayout, "tabLayout");
        kotlin.jvm.internal.s.h(adjustStub, "adjustStub");
        this.a = bottomModule;
        this.b = container;
        this.c = tabLayout;
        this.f10361d = adjustStub;
        this.f10364g = -1;
        a2 = kotlin.h.a(LazyThreadSafetyMode.NONE, new Facial3DController$recyclerView$2(this));
        this.f10365h = a2;
    }

    private final void m() {
        if (this.f10362e == null) {
            View inflate = this.f10361d.inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type us.pinguo.edit2020.view.Facial3DAdjustView");
            Facial3DAdjustView facial3DAdjustView = (Facial3DAdjustView) inflate;
            this.f10362e = facial3DAdjustView;
            kotlin.jvm.internal.s.e(facial3DAdjustView);
            facial3DAdjustView.setOnTrackListener(new a());
        }
    }

    private final void n() {
        m();
        Facial3DAdjustView facial3DAdjustView = this.f10362e;
        if (facial3DAdjustView != null) {
            facial3DAdjustView.setVisibility(0);
            VdsAgent.onSetViewVisibility(facial3DAdjustView, 0);
        }
        w(this.a.w());
        this.b.removeAllViews();
        this.b.addView(q(), new ViewGroup.LayoutParams(-1, -1));
        if (us.pinguo.foundation.utils.i.c()) {
            PGEditBottomTabLayout pGEditBottomTabLayout = this.c;
            Context context = this.b.getContext();
            kotlin.jvm.internal.s.g(context, "container.context");
            PGEditBottomTabLayout.g(pGEditBottomTabLayout, new View[]{us.pinguo.edit2020.utils.d.a(context, R.string.main_menu_facial_three_dimensional, true, false)}, false, null, 6, null);
        } else {
            PGEditBottomTabLayout pGEditBottomTabLayout2 = this.c;
            String string = us.pinguo.foundation.e.b().getString(R.string.main_menu_facial_three_dimensional);
            kotlin.jvm.internal.s.g(string, "getAppContext().getStrin…facial_three_dimensional)");
            PGEditBottomTabLayout.h(pGEditBottomTabLayout2, new String[]{string}, false, null, 6, null);
        }
        this.c.B();
    }

    private final void p() {
        this.f10364g = -1;
        Facial3DAdjustView facial3DAdjustView = this.f10362e;
        if (facial3DAdjustView != null) {
            facial3DAdjustView.setVisibility(8);
            VdsAgent.onSetViewVisibility(facial3DAdjustView, 8);
            facial3DAdjustView.o();
        }
        this.a.k0();
    }

    private final RecyclerView q() {
        return (RecyclerView) this.f10365h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(us.pinguo.edit2020.bean.q qVar, int i2, CenterLayoutManager centerLayoutManager, Context context) {
        if (Facial3DFunctionConfig.ALL3D == us.pinguo.edit2020.bean.q.f10240g.c(qVar.f()) && this.a.T()) {
            x(new Facial3DController$handleItemChange$1(this, i2, centerLayoutManager, context, qVar));
        } else {
            s(this, i2, centerLayoutManager, context, qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Facial3DController facial3DController, int i2, CenterLayoutManager centerLayoutManager, Context context, us.pinguo.edit2020.bean.q qVar) {
        facial3DController.f10364g = i2;
        centerLayoutManager.b(context, i2, 100.0f);
        Facial3DAdjustView facial3DAdjustView = facial3DController.f10362e;
        if (facial3DAdjustView == null) {
            return;
        }
        facial3DAdjustView.setCurrentFunction(qVar);
        us.pinguo.foundation.statistics.h.b.k(facial3DAdjustView.h(), qVar.f(), "click");
    }

    private final void w(ArrayList<us.pinguo.edit2020.bean.q> arrayList) {
        us.pinguo.edit2020.adapter.c0 c0Var = this.f10363f;
        if (c0Var == null) {
            Context context = us.pinguo.foundation.e.b();
            kotlin.jvm.internal.s.g(context, "context");
            CenterLayoutManager centerLayoutManager = new CenterLayoutManager(context, 0, false);
            q().setLayoutManager(centerLayoutManager);
            RecyclerView.ItemAnimator itemAnimator = q().getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            us.pinguo.edit2020.adapter.c0 c0Var2 = new us.pinguo.edit2020.adapter.c0();
            c0Var2.A(new Facial3DController$refreshData$1$1(this, centerLayoutManager, context));
            us.pinguo.edit2020.adapter.a0.u(c0Var2, arrayList, 0, false, 4, null);
            q().setAdapter(c0Var2);
            us.pinguo.common.widget.g gVar = new us.pinguo.common.widget.g();
            gVar.a(context, c0Var2.getItemCount(), centerLayoutManager.a(context, c0Var2.getItemCount()));
            q().addItemDecoration(gVar);
            q().addItemDecoration(new us.pinguo.edit2020.adapter.d0());
            this.f10363f = c0Var2;
            return;
        }
        us.pinguo.edit2020.adapter.a0.u(c0Var, arrayList, 0, false, 4, null);
    }

    private final void x(final kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar) {
        final Context context = this.b.getContext();
        AppCompatActivity appCompatActivity = (AppCompatActivity) context;
        if (appCompatActivity != null) {
            us.pinguo.foundation.utils.d0.b(appCompatActivity);
        }
        AlertDialog h2 = us.pinguo.foundation.utils.w.h(context, null, context.getString(R.string.facial3d_revert), context.getString(R.string.confirm), context.getString(us.pinguo.user.R.string.cancel), new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.controller.o1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                Facial3DController.y(context, lVar, dialogInterface, i2);
            }
        });
        h2.setCancelable(false);
        h2.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Context context, kotlin.jvm.b.l callback, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(callback, "$callback");
        if (context != null) {
            us.pinguo.foundation.utils.d0.a(context);
        }
        if (i2 == -2) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            callback.invoke(Boolean.FALSE);
        } else if (i2 != -1) {
        } else {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            callback.invoke(Boolean.TRUE);
        }
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

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        return false;
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void d() {
        p();
        this.a.l0();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean f() {
        return false;
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void g() {
        p();
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
        n();
    }
}
