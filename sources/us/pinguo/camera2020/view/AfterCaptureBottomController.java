package us.pinguo.camera2020.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.material.tabs.TabLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.ad.RewardVipAdController;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.module.AfterCaptureModule;
import us.pinguo.camera2020.widget.AfterCaptureCircleImageView;
import us.pinguo.camera2020.widget.BottomMenuLayout;
import us.pinguo.camera2020.widget.CameraSwitchMode;
import us.pinguo.camera2020.widget.ShutterButton;
import us.pinguo.common.h;
import us.pinguo.share.util.ExpandShareSite;
import us.pinguo.share.util.InspireShareUtils;
import us.pinguo.share.util.OnShareSiteClickListener;
import us.pinguo.svideo.bean.VideoInfo;
/* compiled from: AfterCaptureBottomController.kt */
/* loaded from: classes3.dex */
public final class AfterCaptureBottomController implements LifecycleObserver, us.pinguo.common.h, us.pinguo.common.g {
    private kotlin.jvm.b.l<? super View, kotlin.u> A;
    private kotlin.jvm.b.l<? super View, kotlin.u> B;
    private boolean C;
    private final float D;
    private final int E;
    private int F;
    private final int[] G;
    private kotlin.jvm.b.a<kotlin.u> H;
    private kotlin.jvm.b.a<kotlin.u> I;
    private final AfterCaptureModule a;
    private final BottomMenuLayout b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final RewardVipAdController f9267d;

    /* renamed from: e  reason: collision with root package name */
    private final ShutterButton f9268e;

    /* renamed from: f  reason: collision with root package name */
    private final AfterCaptureCircleImageView f9269f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f9270g;

    /* renamed from: h  reason: collision with root package name */
    private final ImageView f9271h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f9272i;

    /* renamed from: j  reason: collision with root package name */
    private final ImageView f9273j;

    /* renamed from: k  reason: collision with root package name */
    private final TextView f9274k;

    /* renamed from: l  reason: collision with root package name */
    private final ConstraintLayout f9275l;
    private float m;
    private boolean n;
    private us.pinguo.repository2020.u<Boolean> o;
    private ConstraintLayout p;
    private kotlin.jvm.b.a<? extends ArrayList<String>> q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private CameraSwitchMode v;
    public kotlin.jvm.b.a<kotlin.u> w;
    public kotlin.jvm.b.a<kotlin.u> x;
    private kotlin.jvm.b.l<? super View, kotlin.u> y;
    private kotlin.jvm.b.l<? super View, kotlin.u> z;

    /* compiled from: AfterCaptureBottomController.kt */
    /* loaded from: classes3.dex */
    public static final class a implements TabLayout.d {
        a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(TabLayout.f tab) {
            kotlin.jvm.internal.s.h(tab, "tab");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(TabLayout.f tab) {
            kotlin.jvm.internal.s.h(tab, "tab");
            View e2 = tab.e();
            if (e2 != null) {
                e2.setAlpha(1.0f);
            }
            int g2 = tab.g();
            AfterCaptureBottomController.this.a.N(g2 == 0 ? null : Integer.valueOf(g2 - 1));
            kotlin.jvm.b.a<kotlin.u> t = AfterCaptureBottomController.this.t();
            if (t == null) {
                return;
            }
            t.invoke();
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(TabLayout.f tab) {
            kotlin.jvm.internal.s.h(tab, "tab");
            View e2 = tab.e();
            if (e2 == null) {
                return;
            }
            e2.setAlpha(0.6f);
        }
    }

    /* compiled from: AfterCaptureBottomController.kt */
    /* loaded from: classes3.dex */
    public static final class b implements OnShareSiteClickListener {
        b() {
        }

        @Override // us.pinguo.share.util.OnShareSiteClickListener
        public void onShareOtherClick(OnShareSiteClickListener.ShareDialogContent shareDialogContent) {
        }

        @Override // us.pinguo.share.util.OnShareSiteClickListener
        public void onShareSiteClick(DialogFragment dialogFragment, ExpandShareSite expandShareSite) {
            if (us.pinguo.camera2020.i.a.a.f()) {
                if (AfterCaptureBottomController.this.a.g()) {
                    AfterCaptureBottomController.this.a.H(true);
                }
                AfterCaptureBottomController.this.a.A(false);
            }
        }
    }

    /* compiled from: AfterCaptureBottomController.kt */
    /* loaded from: classes3.dex */
    public static final class c implements OnShareSiteClickListener {
        c() {
        }

        @Override // us.pinguo.share.util.OnShareSiteClickListener
        public void onShareOtherClick(OnShareSiteClickListener.ShareDialogContent shareDialogContent) {
        }

        @Override // us.pinguo.share.util.OnShareSiteClickListener
        public void onShareSiteClick(DialogFragment dialogFragment, ExpandShareSite expandShareSite) {
            if (us.pinguo.camera2020.i.a.a.f()) {
                AfterCaptureBottomController.this.a.A(false);
            }
        }
    }

    public AfterCaptureBottomController(AfterCaptureModule afterCaptureModule, BottomMenuLayout bottomLayout, boolean z, RewardVipAdController rewardVipAdController) {
        kotlin.jvm.internal.s.h(afterCaptureModule, "afterCaptureModule");
        kotlin.jvm.internal.s.h(bottomLayout, "bottomLayout");
        this.a = afterCaptureModule;
        this.b = bottomLayout;
        this.c = z;
        this.f9267d = rewardVipAdController;
        this.f9268e = (ShutterButton) bottomLayout._$_findCachedViewById(R.id.imgShutterOrSave);
        this.f9269f = (AfterCaptureCircleImageView) bottomLayout._$_findCachedViewById(R.id.imgAlbumMusicDiscard);
        this.f9270g = (TextView) bottomLayout._$_findCachedViewById(R.id.txtAlbumMusicDiscard);
        this.f9271h = (ImageView) bottomLayout._$_findCachedViewById(R.id.imgStickerOrFilter);
        this.f9272i = (TextView) bottomLayout._$_findCachedViewById(R.id.txtStickerOrFilter);
        this.f9273j = (ImageView) bottomLayout._$_findCachedViewById(R.id.imgFilterOrShare);
        this.f9274k = (TextView) bottomLayout._$_findCachedViewById(R.id.txtFilterOrShare);
        this.f9275l = (ConstraintLayout) bottomLayout._$_findCachedViewById(R.id.clFuncArea);
        this.m = Float.NaN;
        this.n = true;
        this.o = new us.pinguo.repository2020.u<>(Boolean.FALSE);
        this.u = true;
        this.v = CameraSwitchMode.PHOTO;
        float dimension = us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.shutter_size_small);
        Resources resources = us.pinguo.foundation.e.b().getResources();
        int i2 = R.dimen.shutter_size_normal;
        this.D = dimension / resources.getDimension(i2);
        this.E = bottomLayout.getResources().getDimensionPixelSize(i2);
        this.G = new int[]{R.id.fl_watermark_type_none, R.id.fl_watermark_type1, R.id.fl_watermark_type2, R.id.fl_watermark_type3, R.id.fl_watermark_type7, R.id.fl_watermark_type4, R.id.fl_watermark_type5, R.id.fl_watermark_type6};
    }

    private final void A() {
        final ConstraintLayout constraintLayout = this.p;
        if (constraintLayout == null) {
            return;
        }
        if (constraintLayout.getVisibility() == 0) {
            constraintLayout.animate().translationY(constraintLayout.getMeasuredHeight()).withEndAction(new Runnable() { // from class: us.pinguo.camera2020.view.g
                @Override // java.lang.Runnable
                public final void run() {
                    AfterCaptureBottomController.B(ConstraintLayout.this);
                }
            }).setDuration(200L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ConstraintLayout layout) {
        kotlin.jvm.internal.s.h(layout, "$layout");
        layout.setVisibility(4);
        VdsAgent.onSetViewVisibility(layout, 4);
    }

    private final void C() {
        kotlin.z.d q;
        int o;
        Integer h2;
        final TabLayout tabLayout = (TabLayout) this.b._$_findCachedViewById(R.id.tabWatermarkStyle);
        View inflate = LayoutInflater.from(this.b.getContext()).inflate(R.layout.layout_watermark_style_collection, (ViewGroup) null);
        tabLayout.d(new a());
        q = kotlin.collections.n.q(this.G);
        o = kotlin.collections.v.o(q, 10);
        ArrayList arrayList = new ArrayList(o);
        Iterator<Integer> it = q.iterator();
        while (it.hasNext()) {
            int nextInt = ((kotlin.collections.h0) it).nextInt();
            TabLayout.f F = tabLayout.F();
            kotlin.jvm.internal.s.g(F, "tabLayout.newTab()");
            F.o(inflate.findViewById(this.G[nextInt]));
            tabLayout.g(F, false);
            arrayList.add(kotlin.u.a);
        }
        String k2 = us.pinguo.foundation.j.e().k("key_watermark_type", "0");
        kotlin.jvm.internal.s.g(k2, "get().getString(CameraBu….KEY_WATERMARK_TYPE, \"0\")");
        h2 = kotlin.text.s.h(k2);
        final int intValue = h2 == null ? 1 : h2.intValue();
        kotlin.jvm.internal.s.g(tabLayout, "tabLayout");
        us.pinguo.foundation.ui.c.b(tabLayout, new Runnable() { // from class: us.pinguo.camera2020.view.h
            @Override // java.lang.Runnable
            public final void run() {
                AfterCaptureBottomController.F(TabLayout.this, intValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(TabLayout tabLayout, int i2) {
        TabLayout.f z = tabLayout.z(i2 + 1);
        if (z == null) {
            return;
        }
        z.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        Context context = this.f9273j.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        final Activity activity = (Activity) context;
        final String l2 = this.a.l();
        us.pinguo.user.util.j.c(us.pinguo.user.util.j.a, activity, new Runnable() { // from class: us.pinguo.camera2020.view.k
            @Override // java.lang.Runnable
            public final void run() {
                AfterCaptureBottomController.h0(l2, activity, this);
            }
        }, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(String str, Activity activity, AfterCaptureBottomController this$0) {
        kotlin.jvm.internal.s.h(activity, "$activity");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        InspireShareUtils.showShareDialogWithPictureParamToSNS(1, 5, str, (String) null, (Context) activity, "", true, "camera_preview_page", (OnShareSiteClickListener) new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        Context context = this.f9273j.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        final FragmentActivity fragmentActivity = (FragmentActivity) context;
        VideoInfo m = this.a.m();
        final String videoPath = m == null ? null : m.getVideoPath();
        if (videoPath == null) {
            return;
        }
        us.pinguo.user.util.j.c(us.pinguo.user.util.j.a, fragmentActivity, new Runnable() { // from class: us.pinguo.camera2020.view.d
            @Override // java.lang.Runnable
            public final void run() {
                AfterCaptureBottomController.j0(FragmentActivity.this, videoPath, this);
            }
        }, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(FragmentActivity activity, String videoPath, AfterCaptureBottomController this$0) {
        kotlin.jvm.internal.s.h(activity, "$activity");
        kotlin.jvm.internal.s.h(videoPath, "$videoPath");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        InspireShareUtils.showShareDialogToSNS(activity, videoPath, true, true, "camera_preview_page", (OnShareSiteClickListener) new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(kotlin.jvm.b.l lVar, View view) {
        VdsAgent.lambdaOnClick(view);
        lVar.invoke(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        if (us.pinguo.camera2020.i.a.a.f()) {
            this.a.A(false);
        }
        this.f9268e.x();
        us.pinguo.foundation.statistics.h.b.B0();
        this.a.x();
        this.u = false;
        AppEventsLogger.i(us.pinguo.foundation.e.b()).g("active");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(kotlin.jvm.b.l lVar, View view) {
        VdsAgent.lambdaOnClick(view);
        lVar.invoke(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        float f2 = this.m;
        if (Float.isNaN(f2)) {
            Context b2 = us.pinguo.foundation.e.b();
            kotlin.jvm.internal.s.g(b2, "getAppContext()");
            f2 = (this.b.getLayoutParams().height - (this.f9275l.getLayoutParams().height * 0.5f)) - (this.F + us.pinguo.util.g.b(b2, 38.0f));
            this.m = f2;
        }
        if (!(this.f9275l.getTranslationY() == f2)) {
            this.f9275l.animate().translationY(f2).setDuration(200L).start();
            this.f9269f.animate().scaleX(0.8f).scaleY(0.8f).setDuration(200L).start();
            this.f9271h.animate().scaleX(0.8f).scaleY(0.8f).setDuration(200L).start();
            this.f9273j.animate().scaleX(0.8f).scaleY(0.8f).setDuration(200L).start();
        }
        float f3 = this.D;
        if (this.f9268e.getTranslationY() == f2) {
            if (this.f9268e.getScaleX() == f3) {
                if (this.f9268e.getScaleY() == f3) {
                    return;
                }
            }
        }
        this.f9268e.animate().translationY(f2).scaleX(f3).scaleY(f3).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(AfterCaptureBottomController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ConstraintLayout functionsArea = this$0.f9275l;
        kotlin.jvm.internal.s.g(functionsArea, "functionsArea");
        functionsArea.setVisibility(0);
        VdsAgent.onSetViewVisibility(functionsArea, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(kotlin.jvm.b.l lVar, View view) {
        VdsAgent.lambdaOnClick(view);
        lVar.invoke(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(kotlin.jvm.b.l lVar, View view) {
        VdsAgent.lambdaOnClick(view);
        lVar.invoke(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(AfterCaptureBottomController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(Ref$ObjectRef layout, int i2) {
        Integer h2;
        kotlin.jvm.internal.s.h(layout, "$layout");
        ((ConstraintLayout) layout.element).setTranslationY(i2);
        View view = (View) layout.element;
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
        String k2 = us.pinguo.foundation.j.e().k("key_watermark_type", "0");
        kotlin.jvm.internal.s.g(k2, "get().getString(CameraBu….KEY_WATERMARK_TYPE, \"0\")");
        h2 = kotlin.text.s.h(k2);
        TabLayout.f z = ((TabLayout) ((ConstraintLayout) layout.element).findViewById(R.id.tabWatermarkStyle)).z((h2 == null ? 1 : h2.intValue()) + 1);
        if (z == null) {
            return;
        }
        z.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0() {
        if (!(this.f9275l.getTranslationY() == 0.0f)) {
            this.f9275l.animate().translationY(0.0f).setDuration(200L).start();
            this.f9269f.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
            this.f9271h.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
            this.f9273j.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
        }
        if (this.f9268e.getTranslationY() == 0.0f) {
            if (this.f9268e.getScaleX() == 1.0f) {
                if (this.f9268e.getScaleY() == 1.0f) {
                    return;
                }
            }
        }
        this.f9268e.animate().translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
    }

    @Override // us.pinguo.common.h
    public int D() {
        return h.a.f(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0090  */
    @Override // us.pinguo.common.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean E(us.pinguo.common.d r6) {
        /*
            r5 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.s.h(r6, r0)
            us.pinguo.repository2020.u<java.lang.Boolean> r0 = r5.o
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.s.c(r0, r1)
            r1 = 0
            if (r0 == 0) goto L15
            return r1
        L15:
            kotlin.jvm.b.a<kotlin.u> r0 = r5.I
            if (r0 != 0) goto L1a
            goto L1d
        L1a:
            r0.invoke()
        L1d:
            us.pinguo.common.EventType r0 = r6.c()
            us.pinguo.common.EventType r2 = us.pinguo.common.EventType.LONG_PRESS
            r3 = 1
            if (r0 != r2) goto L44
            boolean r0 = r5.C
            if (r0 != 0) goto L44
            us.pinguo.camera2020.module.AfterCaptureModule r6 = r5.a
            us.pinguo.camera2020.module.AfterCaptureMode r6 = r6.i()
            us.pinguo.camera2020.module.AfterCaptureMode r0 = us.pinguo.camera2020.module.AfterCaptureMode.PHOTO
            if (r6 != r0) goto L3c
            r5.C = r3
            us.pinguo.camera2020.module.AfterCaptureModule r6 = r5.a
            r6.L(r3)
            goto L43
        L3c:
            us.pinguo.foundation.utils.k0 r6 = us.pinguo.foundation.utils.k0.a
            int r0 = us.pinguo.camera2020.R.string.original_photo_not_allowed
            r6.a(r0)
        L43:
            return r3
        L44:
            us.pinguo.common.EventType r0 = r6.c()
            us.pinguo.common.EventType r2 = us.pinguo.common.EventType.ACTION_UP
            if (r0 != r2) goto L58
            boolean r0 = r5.C
            if (r0 == 0) goto L58
            r5.C = r1
            us.pinguo.camera2020.module.AfterCaptureModule r6 = r5.a
            r6.L(r1)
            return r3
        L58:
            us.pinguo.common.EventType r0 = r6.c()
            us.pinguo.common.EventType r2 = us.pinguo.common.EventType.TOUCH_UP
            if (r0 == r2) goto L68
            us.pinguo.common.EventType r0 = r6.c()
            us.pinguo.common.EventType r4 = us.pinguo.common.EventType.BACK_PRESS
            if (r0 != r4) goto Lb5
        L68:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r5.p
            if (r0 != 0) goto L6e
        L6c:
            r0 = 0
            goto L7a
        L6e:
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L76
            r0 = 1
            goto L77
        L76:
            r0 = 0
        L77:
            if (r0 != r3) goto L6c
            r0 = 1
        L7a:
            if (r0 == 0) goto L90
            us.pinguo.common.EventType r0 = r6.c()
            if (r0 != r2) goto L8c
            boolean r6 = r6.a()
            if (r6 == 0) goto Lb5
            r5.A()
            goto Lb5
        L8c:
            r5.A()
            goto Lb5
        L90:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r5.f9275l
            float r0 = r0.getTranslationY()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto La8
            r5.r = r1
            kotlin.jvm.b.a r6 = r5.q()
            r6.invoke()
            r5.t0()
            goto Lb5
        La8:
            us.pinguo.common.EventType r6 = r6.c()
            us.pinguo.common.EventType r0 = us.pinguo.common.EventType.BACK_PRESS
            if (r6 != r0) goto Lb5
            us.pinguo.camera2020.module.AfterCaptureModule r6 = r5.a
            r6.f()
        Lb5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.view.AfterCaptureBottomController.E(us.pinguo.common.d):boolean");
    }

    @Override // us.pinguo.common.h
    public int G() {
        return h.a.h(this);
    }

    public final boolean H() {
        Boolean value = this.o.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        return value.booleanValue();
    }

    @Override // us.pinguo.common.h
    public void J(boolean z) {
        h.a.b(this, z);
    }

    @Override // us.pinguo.common.h
    public int O() {
        return h.a.i(this);
    }

    public final void V(kotlin.jvm.b.a<? extends ArrayList<String>> aVar) {
        this.q = aVar;
    }

    public final void W(CameraSwitchMode cameraSwitchMode) {
        this.v = cameraSwitchMode;
    }

    public final void X(boolean z) {
        this.r = z;
    }

    public final void Y(int i2) {
        this.F = i2;
    }

    public final void Z(kotlin.jvm.b.a<kotlin.u> aVar) {
        kotlin.jvm.internal.s.h(aVar, "<set-?>");
        this.x = aVar;
    }

    public final void a0(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.I = aVar;
    }

    public final void b0(boolean z) {
        this.s = z;
    }

    public final void c0(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.H = aVar;
    }

    public final void d0(boolean z) {
        this.u = z;
    }

    public final void e0(kotlin.jvm.b.a<kotlin.u> aVar) {
        kotlin.jvm.internal.s.h(aVar, "<set-?>");
        this.w = aVar;
    }

    public final void f0(boolean z) {
        this.t = z;
    }

    @Override // us.pinguo.common.h
    public void h(boolean z) {
        h.a.d(this, z);
    }

    @Override // us.pinguo.common.h
    public void i(boolean z) {
        h.a.e(this, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        if ((r9.getVisibility() == 0) == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0232  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k0(boolean r9, int r10) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.view.AfterCaptureBottomController.k0(boolean, int):void");
    }

    public final kotlin.jvm.b.a<ArrayList<String>> o() {
        return this.q;
    }

    @Override // us.pinguo.common.h
    public void p(boolean z) {
        this.n = z;
        this.f9268e.setIsDark(z);
    }

    public final kotlin.jvm.b.a<kotlin.u> q() {
        kotlin.jvm.b.a<kotlin.u> aVar = this.x;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.s.z("hideFilter");
        throw null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r2v18, types: [T, androidx.constraintlayout.widget.ConstraintLayout, java.lang.Object] */
    public final void q0() {
        kotlin.jvm.b.l<? super View, kotlin.u> lVar;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = this.p;
        final int measuredHeight = this.b.getMeasuredHeight();
        if (ref$ObjectRef.element == 0) {
            View inflate = ((ViewStub) this.b._$_findCachedViewById(R.id.stuWatermarkSelection)).inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ?? r2 = (ConstraintLayout) inflate;
            ref$ObjectRef.element = r2;
            Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.View");
            View view = (View) r2;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = measuredHeight;
            view.setLayoutParams(layoutParams2);
            ((ImageView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.imgCollapse)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AfterCaptureBottomController.r0(AfterCaptureBottomController.this, view2);
                }
            });
            C();
            this.p = (ConstraintLayout) ref$ObjectRef.element;
        }
        if (((View) ref$ObjectRef.element).getVisibility() == 0) {
            return;
        }
        if (this.r && (lVar = this.A) != null) {
            ImageView btFilter = this.f9271h;
            kotlin.jvm.internal.s.g(btFilter, "btFilter");
            lVar.invoke(btFilter);
        }
        ((ConstraintLayout) ref$ObjectRef.element).animate().translationY(0.0f).setDuration(200L).withStartAction(new Runnable() { // from class: us.pinguo.camera2020.view.a
            @Override // java.lang.Runnable
            public final void run() {
                AfterCaptureBottomController.s0(Ref$ObjectRef.this, measuredHeight);
            }
        }).start();
    }

    public final kotlin.jvm.b.a<kotlin.u> r() {
        return this.I;
    }

    @Override // us.pinguo.common.h
    public boolean s() {
        return true;
    }

    public final kotlin.jvm.b.a<kotlin.u> t() {
        return this.H;
    }

    public final boolean u() {
        return this.u;
    }

    public final kotlin.jvm.b.a<kotlin.u> v() {
        kotlin.jvm.b.a<kotlin.u> aVar = this.w;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.s.z("showFilter");
        throw null;
    }

    @Override // us.pinguo.common.h
    public void w(int i2) {
        h.a.a(this, i2);
    }

    @Override // us.pinguo.common.h
    public int x() {
        return this.b.getLayoutParams().height;
    }

    public final LiveData<Boolean> y() {
        return this.o;
    }

    public final void z() {
        ConstraintLayout constraintLayout = this.p;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(constraintLayout, 8);
        }
        this.o.setValue(Boolean.FALSE);
        this.t = false;
        this.s = false;
        this.u = false;
        this.f9269f.setScaleX(1.0f);
        this.f9269f.setScaleY(1.0f);
        this.f9271h.setScaleX(1.0f);
        this.f9271h.setScaleY(1.0f);
        this.f9273j.setScaleX(1.0f);
        this.f9273j.setScaleY(1.0f);
    }
}
