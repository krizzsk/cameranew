package us.pinguo.edit2020.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewKt;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import java.util.Objects;
import us.pinguo.common.widget.FragmentLoadingView;
import us.pinguo.common.widget.ImageRestorationProgressView;
import us.pinguo.common.widget.ScrollCenterLayoutManager;
import us.pinguo.common.widget.tab.PGAIEditBottomTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.i3;
import us.pinguo.edit2020.view.AIEditCanvasView;
import us.pinguo.edit2020.view.ImageCompareAdjustView;
import us.pinguo.edit2020.view.ImageRestorationCanvasView;
/* compiled from: ImageRestorationController.kt */
/* loaded from: classes4.dex */
public final class ImageRestorationController implements i3, e3, c3 {
    private final ViewGroup a;
    private final us.pinguo.edit2020.viewmodel.module.a b;
    private final Context c;

    /* renamed from: d  reason: collision with root package name */
    private View f10375d;

    /* renamed from: e  reason: collision with root package name */
    private final View f10376e;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.edit2020.view.d0 f10377f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageCompareAdjustView f10378g;

    /* renamed from: h  reason: collision with root package name */
    private us.pinguo.edit2020.adapter.g0 f10379h;

    /* renamed from: i  reason: collision with root package name */
    private ScrollCenterLayoutManager f10380i;

    /* renamed from: j  reason: collision with root package name */
    private final us.pinguo.common.helper.b f10381j;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f10382k;

    /* renamed from: l  reason: collision with root package name */
    private long f10383l;

    public ImageRestorationController(ViewGroup fragmentLayout, us.pinguo.edit2020.viewmodel.module.a imageRestorationModule) {
        kotlin.jvm.internal.s.h(fragmentLayout, "fragmentLayout");
        kotlin.jvm.internal.s.h(imageRestorationModule, "imageRestorationModule");
        this.a = fragmentLayout;
        this.b = imageRestorationModule;
        Context context = fragmentLayout.getContext();
        kotlin.jvm.internal.s.g(context, "fragmentLayout.context");
        this.c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_image_restoration_panel, (ViewGroup) null, false);
        kotlin.jvm.internal.s.g(inflate, "from(context).inflate(\n …null,\n        false\n    )");
        this.f10376e = inflate;
        View inflate2 = LayoutInflater.from(context).inflate(R.layout.layout_image_compare_adjust, (ViewGroup) null, false);
        Objects.requireNonNull(inflate2, "null cannot be cast to non-null type us.pinguo.edit2020.view.ImageCompareAdjustView");
        this.f10378g = (ImageCompareAdjustView) inflate2;
        this.f10381j = new us.pinguo.common.helper.b();
        this.f10383l = -1L;
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        LifecycleCoroutineScope D = D();
        if (D == null) {
            return;
        }
        kotlinx.coroutines.l.d(D, kotlinx.coroutines.z0.b(), null, new ImageRestorationController$clear$1(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LifecycleCoroutineScope D() {
        LifecycleOwner findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(this.a);
        if (findViewTreeLifecycleOwner == null) {
            return null;
        }
        return LifecycleOwnerKt.getLifecycleScope(findViewTreeLifecycleOwner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.bgEventInterceptor);
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(frameLayout, 4);
        }
        PGAIEditBottomTabLayout pGAIEditBottomTabLayout = (PGAIEditBottomTabLayout) this.a.findViewById(R.id.bottomTabLayout);
        if (pGAIEditBottomTabLayout != null) {
            pGAIEditBottomTabLayout.setTabLayoutAndCompleteButtonEnabled(true);
        }
        ViewGroup viewGroup = this.a;
        int i2 = R.id.loadingView;
        if (us.pinguo.edit2020.utils.d.e((FragmentLoadingView) viewGroup.findViewById(i2))) {
            return;
        }
        ViewGroup viewGroup2 = this.a;
        int i3 = R.id.loadingGroup;
        if (us.pinguo.edit2020.utils.d.e((Group) viewGroup2.findViewById(i3))) {
            return;
        }
        ((FragmentLoadingView) this.a.findViewById(i2)).b();
        Group group = (Group) this.a.findViewById(i3);
        kotlin.jvm.internal.s.g(group, "fragmentLayout.loadingGroup");
        group.setVisibility(8);
        VdsAgent.onSetViewVisibility(group, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        Group group = (Group) this.a.findViewById(R.id.progressLoadingGroup);
        kotlin.jvm.internal.s.g(group, "fragmentLayout.progressLoadingGroup");
        group.setVisibility(8);
        VdsAgent.onSetViewVisibility(group, 8);
        ((PGAIEditBottomTabLayout) this.a.findViewById(R.id.bottomTabLayout)).setTabLayoutAndCompleteButtonEnabled(true);
    }

    private final void I() {
        LifecycleCoroutineScope D = D();
        if (D == null) {
            return;
        }
        kotlinx.coroutines.l.d(D, kotlinx.coroutines.z0.b(), null, new ImageRestorationController$initFaceData$1(this, null), 2, null);
    }

    private final void J() {
        ((FrameLayout) this.a.findViewById(R.id.bgEventInterceptor)).setOnClickListener(v1.a);
        ScrollCenterLayoutManager scrollCenterLayoutManager = new ScrollCenterLayoutManager(this.c);
        this.f10380i = scrollCenterLayoutManager;
        if (scrollCenterLayoutManager != null) {
            scrollCenterLayoutManager.setOrientation(0);
        }
        ((RecyclerView) this.f10376e.findViewById(R.id.rvImageRestoration)).setLayoutManager(this.f10380i);
        ((SwitchCompat) this.f10376e.findViewById(R.id.switchFace)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.t1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageRestorationController.O(ImageRestorationController.this, view);
            }
        });
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap q = us.pinguo.util.e.q(this.b.b(), options);
        this.f10382k = q;
        int width = q == null ? 0 : q.getWidth();
        Bitmap bitmap = this.f10382k;
        this.f10377f = width * (bitmap != null ? bitmap.getHeight() : 0) < 20000000 ? new ImageRestorationCanvasView(this.c) : new AIEditCanvasView(this.c, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(View view) {
        VdsAgent.lambdaOnClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(ImageRestorationController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.facedetector.c e2 = this$0.b.e();
        if (e2 != null && e2.h()) {
            return;
        }
        us.pinguo.foundation.utils.j0.d(this$0.c.getString(R.string.detect_no_face));
        ((SwitchCompat) this$0.f10376e.findViewById(R.id.switchFace)).setChecked(false);
    }

    private final void U(boolean z) {
        Group group = (Group) this.a.findViewById(R.id.loadingGroup);
        kotlin.jvm.internal.s.g(group, "fragmentLayout.loadingGroup");
        group.setVisibility(0);
        VdsAgent.onSetViewVisibility(group, 0);
        ViewGroup viewGroup = this.a;
        int i2 = R.id.loadingView;
        String string = this.c.getResources().getString(R.string.canceling_task);
        kotlin.jvm.internal.s.g(string, "context.resources.getStr…(R.string.canceling_task)");
        ((FragmentLoadingView) viewGroup.findViewById(i2)).setTipText(string);
        ((FragmentLoadingView) this.a.findViewById(i2)).f(true);
        ((FragmentLoadingView) this.a.findViewById(i2)).e(false);
        ((FragmentLoadingView) this.a.findViewById(i2)).g();
        if (z) {
            View findViewById = this.a.findViewById(R.id.vBottomTabInterceptor);
            kotlin.jvm.internal.s.g(findViewById, "fragmentLayout.vBottomTabInterceptor");
            findViewById.setVisibility(0);
            VdsAgent.onSetViewVisibility(findViewById, 0);
            return;
        }
        ((PGAIEditBottomTabLayout) this.a.findViewById(R.id.bottomTabLayout)).setTabLayoutAndCompleteButtonEnabled(false);
        FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.bgEventInterceptor);
        kotlin.jvm.internal.s.g(frameLayout, "fragmentLayout.bgEventInterceptor");
        frameLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(frameLayout, 0);
    }

    static /* synthetic */ void V(ImageRestorationController imageRestorationController, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        imageRestorationController.U(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append('%');
        ((TextView) ((FrameLayout) this.a.findViewById(R.id.loading)).findViewById(R.id.tvProgress)).setText(sb.toString());
        ((ImageRestorationProgressView) this.a.findViewById(R.id.progressLoading)).setProgress(i2);
        if (i2 == 0) {
            Group group = (Group) this.a.findViewById(R.id.progressLoadingGroup);
            kotlin.jvm.internal.s.g(group, "fragmentLayout.progressLoadingGroup");
            group.setVisibility(0);
            VdsAgent.onSetViewVisibility(group, 0);
            ((PGAIEditBottomTabLayout) this.a.findViewById(R.id.bottomTabLayout)).setTabLayoutAndCompleteButtonEnabled(false);
        }
    }

    static /* synthetic */ void X(ImageRestorationController imageRestorationController, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        imageRestorationController.W(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y() {
        this.f10383l = System.currentTimeMillis();
        X(this, 0, 1, null);
        LifecycleCoroutineScope D = D();
        if (D == null) {
            return;
        }
        kotlinx.coroutines.l.d(D, kotlinx.coroutines.z0.b(), null, new ImageRestorationController$startRestoreImage$1(this, null), 2, null);
    }

    public void E() {
        Bitmap c;
        Bitmap b;
        ((FrameLayout) this.a.findViewById(R.id.flSecondMenuContainer)).removeAllViews();
        ((FrameLayout) this.a.findViewById(R.id.flCanvasContainer)).removeAllViews();
        ((SwitchCompat) this.f10376e.findViewById(R.id.switchFace)).setOnCheckedChangeListener(null);
        C();
        us.pinguo.edit2020.view.d0 d0Var = this.f10377f;
        if (d0Var != null && (b = d0Var.b()) != null && !b.isRecycled()) {
            b.recycle();
        }
        us.pinguo.edit2020.view.d0 d0Var2 = this.f10377f;
        if (d0Var2 != null && (c = d0Var2.c()) != null && !c.isRecycled()) {
            c.recycle();
        }
        us.pinguo.edit2020.adapter.g0 g0Var = this.f10379h;
        if (g0Var == null) {
            return;
        }
        g0Var.i();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.AI_EDIT;
    }

    @Override // us.pinguo.edit2020.controller.c3
    public boolean L(us.pinguo.edit2020.model.editgoto.b editGoto) {
        kotlin.jvm.internal.s.h(editGoto, "editGoto");
        u(editGoto);
        return true;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        Group group = (Group) this.a.findViewById(R.id.loadingGroup);
        kotlin.jvm.internal.s.g(group, "fragmentLayout.loadingGroup");
        return group.getVisibility() == 0;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return i3.a.c(this);
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        return false;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        us.pinguo.foundation.statistics.h.b.R("save_succuss");
        C();
    }

    @Override // us.pinguo.edit2020.controller.i3, us.pinguo.edit2020.controller.z2
    public boolean f() {
        return false;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void g() {
        if (this.f10381j.d()) {
            H();
            boolean z = false;
            V(this, false, 1, null);
            LifecycleCoroutineScope D = D();
            if (D != null) {
                kotlinx.coroutines.l.d(D, kotlinx.coroutines.z0.b(), null, new ImageRestorationController$onWorkflowCanceled$1(this, null), 2, null);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f10383l;
            Bitmap bitmap = this.f10382k;
            int width = bitmap == null ? 0 : bitmap.getWidth();
            Bitmap bitmap2 = this.f10382k;
            int height = bitmap2 == null ? 0 : bitmap2.getHeight();
            List<List<PointF>> d2 = ((SwitchCompat) this.f10376e.findViewById(R.id.switchFace)).isChecked() ? this.b.d(this.b.e()) : null;
            if ((d2 == null || d2.isEmpty()) ? true : true) {
                us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                StringBuilder sb = new StringBuilder();
                sb.append(width);
                sb.append('*');
                sb.append(height);
                iVar.S("picture", sb.toString(), String.valueOf(currentTimeMillis), "interrupt");
                return;
            }
            us.pinguo.foundation.statistics.i iVar2 = us.pinguo.foundation.statistics.h.b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(width);
            sb2.append('*');
            sb2.append(height);
            iVar2.S("face_n_picture", sb2.toString(), String.valueOf(currentTimeMillis), "interrupt");
            return;
        }
        E();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return i3.a.d(this);
    }

    @Override // us.pinguo.edit2020.controller.i3
    public void u(us.pinguo.edit2020.model.editgoto.b bVar) {
        us.pinguo.foundation.statistics.h.b.R("show");
        View view = this.f10375d;
        ConstraintLayout constraintLayout = view;
        if (view == null) {
            View inflate = LayoutInflater.from(us.pinguo.foundation.e.b()).inflate(R.layout.layout_bottom_title, (ViewGroup) null);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate;
            ((TextView) constraintLayout2.findViewById(R.id.txtTitle)).setText(this.c.getResources().getString(R.string.ai_edit_menu_restoration));
            int i2 = R.id.imgLeftIcon;
            ((ImageView) constraintLayout2.findViewById(i2)).setImageResource(R.drawable.icon_vip_round_label);
            ((ImageView) constraintLayout2.findViewById(i2)).setVisibility(0);
            this.f10375d = constraintLayout2;
            constraintLayout = constraintLayout2;
        }
        PGAIEditBottomTabLayout bottomTabLayout = (PGAIEditBottomTabLayout) this.a.findViewById(R.id.bottomTabLayout);
        kotlin.jvm.internal.s.g(bottomTabLayout, "bottomTabLayout");
        PGAIEditBottomTabLayout.d(bottomTabLayout, new View[]{constraintLayout}, false, null, 6, null);
        bottomTabLayout.n();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        us.pinguo.edit2020.view.d0 d0Var = this.f10377f;
        View view2 = d0Var instanceof View ? (View) d0Var : null;
        if (view2 != null) {
            view2.setLayoutParams(layoutParams);
        }
        this.f10378g.setLayoutParams(layoutParams);
        us.pinguo.edit2020.view.d0 d0Var2 = this.f10377f;
        if (d0Var2 != null) {
            ((FrameLayout) this.a.findViewById(R.id.flCanvasContainer)).addView((View) d0Var2);
        }
        this.f10378g.setOnCompareSlide(new ImageRestorationController$enter$2(this));
        us.pinguo.edit2020.view.d0 d0Var3 = this.f10377f;
        if (d0Var3 != null) {
            d0Var3.setSrcBitmap(this.f10382k);
        }
        I();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        return this.b.h();
    }
}
