package us.pinguo.edit2020.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.drawee.view.DraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import us.pinguo.common.widget.FragmentLoadingView;
import us.pinguo.common.widget.tab.PGAIEditBottomTabLayout;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.activity.EditActivity;
import us.pinguo.edit2020.controller.EditTabType;
import us.pinguo.edit2020.controller.i3;
import us.pinguo.edit2020.controller.x2;
import us.pinguo.edit2020.controller.z2;
import us.pinguo.edit2020.manager.HistoryRecord;
import us.pinguo.edit2020.viewmodel.AIEditViewModel;
/* compiled from: AIEditFragment.kt */
@Instrumented
/* loaded from: classes4.dex */
public final class AIEditFragment extends Fragment implements PGAIEditBottomTabLayout.b, PGAIEditBottomTabLayout.a {
    public Map<Integer, View> a;
    private x2 b;
    private final kotlin.f c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10508d;

    /* renamed from: e  reason: collision with root package name */
    private z2 f10509e;

    /* compiled from: AIEditFragment.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EditTabType.values().length];
            iArr[EditTabType.AI_EDIT.ordinal()] = 1;
            a = iArr;
        }
    }

    public AIEditFragment() {
        super(R.layout.fragment_ai_edit);
        this.a = new LinkedHashMap();
        AIEditFragment$special$$inlined$viewModels$default$1 aIEditFragment$special$$inlined$viewModels$default$1 = new AIEditFragment$special$$inlined$viewModels$default$1(this);
        this.c = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(AIEditViewModel.class), new AIEditFragment$special$$inlined$viewModels$default$2(aIEditFragment$special$$inlined$viewModels$default$1), new AIEditFragment$special$$inlined$viewModels$default$3(aIEditFragment$special$$inlined$viewModels$default$1, this));
    }

    private final void E0(final String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        DraweeView draweeView = (DraweeView) _$_findCachedViewById(R.id.ivOriginalPicture);
        if (kotlin.jvm.internal.s.c(draweeView == null ? null : draweeView.getTag(), str)) {
            return;
        }
        us.pinguo.foundation.utils.f.b(new Runnable() { // from class: us.pinguo.edit2020.fragment.g
            @Override // java.lang.Runnable
            public final void run() {
                AIEditFragment.F0(str, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(final String str, final AIEditFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        final Bitmap w = us.pinguo.util.e.w(str, us.pinguo.foundation.utils.n0.h(), 1, true);
        if (w == null) {
            return;
        }
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.fragment.e
            @Override // java.lang.Runnable
            public final void run() {
                AIEditFragment.G0(AIEditFragment.this, str, w);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(AIEditFragment this$0, String str, Bitmap bitmap) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(bitmap, "$bitmap");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        int i2 = R.id.ivOriginalPicture;
        DraweeView draweeView = (DraweeView) this$0._$_findCachedViewById(i2);
        if (draweeView != null) {
            draweeView.setTag(str);
        }
        DraweeView draweeView2 = (DraweeView) this$0._$_findCachedViewById(i2);
        if (draweeView2 == null) {
            return;
        }
        draweeView2.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(AIEditFragment this$0, ActivityResult it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        AIEditViewModel m0 = this$0.m0();
        kotlin.jvm.internal.s.g(it, "it");
        m0.l(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(View view) {
        VdsAgent.lambdaOnClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(View view) {
        VdsAgent.lambdaOnClick(view);
    }

    private final void M0(boolean z) {
        Group loadingGroup = (Group) _$_findCachedViewById(R.id.loadingGroup);
        kotlin.jvm.internal.s.g(loadingGroup, "loadingGroup");
        loadingGroup.setVisibility(0);
        VdsAgent.onSetViewVisibility(loadingGroup, 0);
        int i2 = R.id.loadingView;
        ((FragmentLoadingView) _$_findCachedViewById(i2)).g();
        ((FragmentLoadingView) _$_findCachedViewById(i2)).f(false);
        ((FragmentLoadingView) _$_findCachedViewById(i2)).e(false);
        if (z) {
            return;
        }
        ((PGAIEditBottomTabLayout) _$_findCachedViewById(R.id.bottomTabLayout)).setTabLayoutAndCompleteButtonEnabled(false);
        FrameLayout bgEventInterceptor = (FrameLayout) _$_findCachedViewById(R.id.bgEventInterceptor);
        kotlin.jvm.internal.s.g(bgEventInterceptor, "bgEventInterceptor");
        bgEventInterceptor.setVisibility(0);
        VdsAgent.onSetViewVisibility(bgEventInterceptor, 0);
    }

    static /* synthetic */ void N0(AIEditFragment aIEditFragment, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        aIEditFragment.M0(z);
    }

    private final void O0() {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        us.pinguo.foundation.utils.d0.b(activity);
        us.pinguo.foundation.utils.w.g(activity, -999, R.string.pg_sdk_edit_quit_edit, R.string.pg_sdk_edit_ok, R.string.pg_sdk_edit_quit, new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.fragment.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AIEditFragment.P0(AIEditFragment.this, dialogInterface, i2);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.edit2020.fragment.h
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AIEditFragment.Q0(FragmentActivity.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(AIEditFragment this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -1) {
            this$0.l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(FragmentActivity it, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.h(it, "$it");
        us.pinguo.foundation.utils.d0.a(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(final String str) {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        us.pinguo.foundation.utils.d0.b(activity);
        AlertDialog h2 = us.pinguo.foundation.utils.w.h(activity, activity.getString(R.string.result_save_tip), activity.getString(R.string.go_to_next_step), activity.getString(R.string.go_to_edit), activity.getString(us.pinguo.user.R.string.cancel), new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.fragment.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AIEditFragment.S0(FragmentActivity.this, str, this, dialogInterface, i2);
            }
        });
        h2.setCancelable(false);
        h2.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(FragmentActivity act, String str, AIEditFragment this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(act, "$act");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.foundation.utils.d0.a(act);
        if (i2 == -2) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            this$0.l0();
        } else if (i2 != -1) {
        } else {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            EditActivity.a.b(act, (r13 & 2) != 0 ? null : str, (r13 & 4) != 0 ? false : false, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? false : false);
            this$0.l0();
        }
    }

    private final void T0(boolean z) {
        DraweeView draweeView = (DraweeView) _$_findCachedViewById(R.id.ivOriginalPicture);
        if (draweeView == null) {
            return;
        }
        draweeView.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0() {
        if (this.f10508d) {
            O0();
        } else {
            l0();
        }
    }

    private final void i0(String str) {
        Bitmap w;
        if (str == null) {
            return;
        }
        int i2 = R.id.ivOriginalPicture;
        DraweeView draweeView = (DraweeView) _$_findCachedViewById(i2);
        if (kotlin.jvm.internal.s.c(draweeView == null ? null : draweeView.getTag(), str) || (w = us.pinguo.util.e.w(str, us.pinguo.foundation.utils.n0.h(), 1, true)) == null) {
            return;
        }
        DraweeView draweeView2 = (DraweeView) _$_findCachedViewById(i2);
        if (draweeView2 != null) {
            draweeView2.setTag(str);
        }
        DraweeView draweeView3 = (DraweeView) _$_findCachedViewById(i2);
        if (draweeView3 == null) {
            return;
        }
        draweeView3.setImageBitmap(w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LifecycleCoroutineScope j0() {
        LifecycleOwner value = getViewLifecycleOwnerLiveData().getValue();
        if (value == null) {
            return null;
        }
        return LifecycleOwnerKt.getLifecycleScope(value);
    }

    private final void k0(kotlin.jvm.b.l<? super String, kotlin.u> lVar) {
        N0(this, false, 1, null);
        m0().b(new AIEditFragment$doSaveAction$1(this, lVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIEditViewModel m0() {
        return (AIEditViewModel) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(Uri uri) {
        us.pinguo.edit2020.model.editgoto.b a2;
        x2 x2Var;
        if (uri == null || (a2 = new us.pinguo.edit2020.model.editgoto.c().a(uri)) == null || (x2Var = this.b) == null) {
            return;
        }
        x2Var.L(a2);
    }

    private final void o0(Intent intent) {
        if (intent == null) {
            return;
        }
        AIEditViewModel m0 = m0();
        String stringExtra = intent.getStringExtra("photo_path");
        if (stringExtra == null) {
            stringExtra = "";
        }
        m0.m(stringExtra);
        this.f10508d = false;
        intent.getBooleanExtra("bundle_key_used_vip_in_camera", false);
        n0((Uri) intent.getParcelableExtra("bundle_key_goto"));
    }

    private final void p0() {
        z2 z2Var = this.f10509e;
        if (z2Var == null) {
            return;
        }
        m0().r(z2Var.v());
        if (!z2Var.f() && !z2Var.R()) {
            if (a.a[z2Var.F().ordinal()] == 1) {
                m0().e().a().n(new HistoryRecord(m0().c().b().f(), m0().g()));
            }
            boolean z = false;
            if (m0().e().c() && !us.pinguo.vip.proxy.b.b(us.pinguo.vip.proxy.b.a, false, 1, null)) {
                z = true;
            }
            if (z) {
                us.pinguo.foundation.statistics.h.b.R("goto_sales_page");
                us.pinguo.vip.proxy.c.a.c(getActivity(), null, true);
                return;
            }
            k0(new AIEditFragment$handleWorkFlowComplete$1$1(this, z2Var));
            return;
        }
        z2Var.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.bgEventInterceptor);
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(frameLayout, 4);
        }
        PGAIEditBottomTabLayout pGAIEditBottomTabLayout = (PGAIEditBottomTabLayout) _$_findCachedViewById(R.id.bottomTabLayout);
        if (pGAIEditBottomTabLayout != null) {
            pGAIEditBottomTabLayout.setTabLayoutAndCompleteButtonEnabled(true);
        }
        int i2 = R.id.loadingView;
        if (us.pinguo.edit2020.utils.d.e((FragmentLoadingView) _$_findCachedViewById(i2))) {
            return;
        }
        int i3 = R.id.loadingGroup;
        if (us.pinguo.edit2020.utils.d.e((Group) _$_findCachedViewById(i3))) {
            return;
        }
        ((FragmentLoadingView) _$_findCachedViewById(i2)).b();
        Group loadingGroup = (Group) _$_findCachedViewById(i3);
        kotlin.jvm.internal.s.g(loadingGroup, "loadingGroup");
        loadingGroup.setVisibility(8);
        VdsAgent.onSetViewVisibility(loadingGroup, 8);
    }

    private final void r0() {
        int dimensionPixelOffset;
        int dimensionPixelOffset2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        m0().o(((float) us.pinguo.util.h.g(activity)) / ((float) us.pinguo.util.h.i(activity)) > 1.7777778f);
        Guideline guideline = (Guideline) _$_findCachedViewById(R.id.fixedBottomTabGuideline);
        if (m0().j()) {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.whole_bottom_height) + getResources().getDimensionPixelSize(R.dimen.pg_sdk_edit_bottom_margin_height);
        } else {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.whole_bottom_height);
        }
        guideline.setGuidelineEnd(dimensionPixelOffset);
        Guideline guideline2 = (Guideline) _$_findCachedViewById(R.id.flexBottomTabGuideline);
        if (m0().j()) {
            dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.bottom_height_without_operation) + getResources().getDimensionPixelSize(R.dimen.pg_sdk_edit_bottom_margin_height);
        } else {
            dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.bottom_height_without_operation);
        }
        guideline2.setGuidelineEnd(dimensionPixelOffset2);
        if (m0().j()) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.pg_sdk_edit_bottom_margin_height));
            layoutParams.bottomToBottom = 0;
            ((ConstraintLayout) _$_findCachedViewById(R.id.frameLayout)).findViewById(R.id.vBottom).setLayoutParams(layoutParams);
        }
    }

    private final void s0() {
        int i2 = R.id.bottomTabLayout;
        ((PGAIEditBottomTabLayout) _$_findCachedViewById(i2)).setOnBottomTabListener(this);
        ((PGAIEditBottomTabLayout) _$_findCachedViewById(i2)).setOnBottomClickListener(this);
    }

    private final void t0() {
    }

    private final void u0() {
        int i2 = us.pinguo.foundation.j.e().i("hairCut", 0);
        if (i2 > 0) {
            int i3 = R.id.viewHairCut;
            View viewHairCut = _$_findCachedViewById(i3);
            kotlin.jvm.internal.s.g(viewHairCut, "viewHairCut");
            viewHairCut.setVisibility(0);
            VdsAgent.onSetViewVisibility(viewHairCut, 0);
            View viewHairCut2 = _$_findCachedViewById(i3);
            kotlin.jvm.internal.s.g(viewHairCut2, "viewHairCut");
            ViewGroup.LayoutParams layoutParams = viewHairCut2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = i2;
            viewHairCut2.setLayoutParams(layoutParams2);
        }
    }

    private final void v0() {
        m0().e().a().m();
        m0().e().a().n(new HistoryRecord(m0().d(), null));
    }

    public final void H0() {
        FragmentActivity activity = getActivity();
        if (activity != null && us.pinguo.foundation.j.e().i("hairCut", -1) == -1) {
            View decorView = activity.getWindow().getDecorView();
            kotlin.jvm.internal.s.g(decorView, "act.window.decorView");
            int b = us.pinguo.util.h.b(decorView);
            us.pinguo.foundation.j.e().q("hairCut", b);
            int i2 = R.id.viewHairCut;
            View viewHairCut = _$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(viewHairCut, "viewHairCut");
            viewHairCut.setVisibility(0);
            VdsAgent.onSetViewVisibility(viewHairCut, 0);
            View viewHairCut2 = _$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(viewHairCut2, "viewHairCut");
            ViewGroup.LayoutParams layoutParams = viewHairCut2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = b;
            viewHairCut2.setLayoutParams(layoutParams2);
        }
    }

    @Override // us.pinguo.common.widget.tab.PGAIEditBottomTabLayout.a
    public void J(PGEditTabLayout.f fVar) {
        DraweeView ivOriginalPicture = (DraweeView) _$_findCachedViewById(R.id.ivOriginalPicture);
        kotlin.jvm.internal.s.g(ivOriginalPicture, "ivOriginalPicture");
        ivOriginalPicture.setVisibility(8);
        VdsAgent.onSetViewVisibility(ivOriginalPicture, 8);
        x2 x2Var = this.b;
        if (x2Var != null) {
            i3.a.a(x2Var, null, 1, null);
        }
        this.f10509e = this.b;
    }

    public final void L0(Intent intent) {
        DraweeView draweeView = (DraweeView) _$_findCachedViewById(R.id.ivOriginalPicture);
        if (draweeView != null) {
            draweeView.setTag(null);
        }
        o0(intent);
        E0(m0().d());
        String d2 = m0().d();
        if (!(d2 == null || d2.length() == 0)) {
            i0(d2);
            T0(true);
            v0();
        }
        ((PGAIEditBottomTabLayout) _$_findCachedViewById(R.id.bottomTabLayout)).q();
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // us.pinguo.common.widget.tab.PGAIEditBottomTabLayout.b
    public void a() {
        us.pinguo.foundation.statistics.h.b.R("click_save");
        p0();
    }

    @Override // us.pinguo.common.widget.tab.PGAIEditBottomTabLayout.b
    public void c() {
        z2 z2Var = this.f10509e;
        if ((z2Var == null || z2Var.f()) ? false : true) {
            z2 z2Var2 = this.f10509e;
            if (z2Var2 != null) {
                z2Var2.g();
            }
            m0().clear();
            z2 z2Var3 = this.f10509e;
            if ((z2Var3 == null || z2Var3.R()) ? false : true) {
                U0();
            }
        }
    }

    public final boolean onBackPressed() {
        z2 z2Var = this.f10509e;
        if (z2Var != null && z2Var.onBackPressed()) {
            return true;
        }
        Group loadingGroup = (Group) _$_findCachedViewById(R.id.loadingGroup);
        kotlin.jvm.internal.s.g(loadingGroup, "loadingGroup");
        if (loadingGroup.getVisibility() == 0) {
            return true;
        }
        if (((PGAIEditBottomTabLayout) _$_findCachedViewById(R.id.bottomTabLayout)).g()) {
            c();
        } else {
            U0();
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getLifecycle().addObserver(m0());
        m0().i();
        m0().p(registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: us.pinguo.edit2020.fragment.d
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AIEditFragment.I0(AIEditFragment.this, (ActivityResult) obj);
            }
        }));
        m0().c().b().i(new AIEditFragment$onCreate$2(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        us.pinguo.common.log.a.c("onDestroyView", new Object[0]);
        super.onDestroyView();
        us.pinguo.vip.proxy.c.a.a();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        VdsAgent.onFragmentHiddenChanged(this, z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VdsAgent.onFragmentPause(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        VdsAgent.onFragmentResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.s.h(view, "view");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        super.onViewCreated(view, bundle);
        ((FrameLayout) _$_findCachedViewById(R.id.bgEventInterceptor)).setOnClickListener(b.a);
        _$_findCachedViewById(R.id.vBottomTabInterceptor).setOnClickListener(f.a);
        o0(activity.getIntent());
        E0(m0().d());
        v0();
        u0();
        t0();
        s0();
        r0();
        ConstraintLayout frameLayout = (ConstraintLayout) _$_findCachedViewById(R.id.frameLayout);
        kotlin.jvm.internal.s.g(frameLayout, "frameLayout");
        this.b = new x2(frameLayout, m0());
        J(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}
