package com.pinguo.camera360.homepage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.Rational;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.imageview.ShapeableImageView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.adv.InterstitialManager;
import com.pinguo.camera360.camera.options.MyActivity;
import com.pinguo.camera360.homepage.HomePageFragment2020;
import com.pinguo.camera360.homepage.view.HomePageSimpleBannerIndicator;
import com.pinguo.camera360.homepage.view.HomePagerBannerLinearLayoutManager;
import com.pinguo.camera360.member.MemberRightsActivity;
import com.pinguo.camera360.member.SubscriptionMemberActivity;
import com.pinguo.camera360.vip.VipManager;
import com.tencent.bugly.crashreport.CrashReport;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advstrategy.PgAdvStrategyManager;
import us.pinguo.advstrategy.strategybean.StrategyItem;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.permissionlib.PermissionManager;
import us.pinguo.repository2020.manager.FilterRepository;
import us.pinguo.u3dengine.PGUnityNoneFragment;
import us.pinguo.ui.widget.AlphaPressedConstraintLayout;
import us.pinguo.user.User;
import vStudio.Android.Camera360.R;
/* compiled from: HomePageFragment2020.kt */
/* loaded from: classes3.dex */
public final class HomePageFragment2020 extends PGUnityNoneFragment implements View.OnClickListener {
    public static final a q = new a(null);

    /* renamed from: e  reason: collision with root package name */
    public Map<Integer, View> f6754e = new LinkedHashMap();

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.f f6755f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<f0> f6756g;

    /* renamed from: h  reason: collision with root package name */
    private final o0 f6757h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6758i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6759j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6760k;

    /* renamed from: l  reason: collision with root package name */
    private int f6761l;
    private PermissionManager m;
    private HomeRewardAdvDialogController n;
    private boolean o;
    private r0 p;

    /* compiled from: HomePageFragment2020.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final HomePageFragment2020 a() {
            return new HomePageFragment2020();
        }
    }

    /* compiled from: HomePageFragment2020.kt */
    /* loaded from: classes3.dex */
    public static final class b implements t0 {
        final /* synthetic */ String[] a;
        final /* synthetic */ HomePageFragment2020 b;
        final /* synthetic */ kotlin.jvm.b.a<kotlin.u> c;

        b(String[] strArr, HomePageFragment2020 homePageFragment2020, kotlin.jvm.b.a<kotlin.u> aVar) {
            this.a = strArr;
            this.b = homePageFragment2020;
            this.c = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(String[] permissions, kotlin.jvm.b.a afterPermissionGranted, String[] strArr, String[] strArr2) {
            kotlin.jvm.internal.s.h(permissions, "$permissions");
            kotlin.jvm.internal.s.h(afterPermissionGranted, "$afterPermissionGranted");
            if (strArr.length == permissions.length) {
                afterPermissionGranted.invoke();
            }
        }

        @Override // com.pinguo.camera360.homepage.t0
        public void a() {
        }

        @Override // com.pinguo.camera360.homepage.t0
        public void b() {
            if (!(this.a.length == 0)) {
                PermissionManager permissionManager = this.b.m;
                if (permissionManager == null) {
                    kotlin.jvm.internal.s.z("permissionManager");
                    throw null;
                }
                final String[] strArr = this.a;
                final kotlin.jvm.b.a<kotlin.u> aVar = this.c;
                permissionManager.t(new us.pinguo.permissionlib.c.a() { // from class: com.pinguo.camera360.homepage.r
                    @Override // us.pinguo.permissionlib.c.a
                    public final void a(String[] strArr2, String[] strArr3) {
                        HomePageFragment2020.b.d(strArr, aVar, strArr2, strArr3);
                    }
                }, true, (String[]) Arrays.copyOf(strArr, strArr.length));
            }
        }
    }

    /* compiled from: HomePageFragment2020.kt */
    /* loaded from: classes3.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            kotlin.jvm.internal.s.h(outRect, "outRect");
            kotlin.jvm.internal.s.h(view, "view");
            kotlin.jvm.internal.s.h(parent, "parent");
            kotlin.jvm.internal.s.h(state, "state");
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter == null) {
                return;
            }
            outRect.top = 0;
            outRect.bottom = 0;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int viewLayoutPosition = ((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition();
            if (viewLayoutPosition == 0) {
                Context context = view.getContext();
                kotlin.jvm.internal.s.g(context, "view.context");
                outRect.left = us.pinguo.util.g.a(context, 28.0f);
                Context context2 = view.getContext();
                kotlin.jvm.internal.s.g(context2, "view.context");
                outRect.right = us.pinguo.util.g.a(context2, 13.0f);
            } else if (viewLayoutPosition == adapter.getItemCount() - 1) {
                Context context3 = view.getContext();
                kotlin.jvm.internal.s.g(context3, "view.context");
                outRect.left = us.pinguo.util.g.a(context3, 13.0f);
                Context context4 = view.getContext();
                kotlin.jvm.internal.s.g(context4, "view.context");
                outRect.right = us.pinguo.util.g.a(context4, 28.0f);
            } else {
                Context context5 = view.getContext();
                kotlin.jvm.internal.s.g(context5, "view.context");
                outRect.left = us.pinguo.util.g.a(context5, 13.0f);
                Context context6 = view.getContext();
                kotlin.jvm.internal.s.g(context6, "view.context");
                outRect.right = us.pinguo.util.g.a(context6, 13.0f);
            }
        }
    }

    /* compiled from: HomePageFragment2020.kt */
    /* loaded from: classes3.dex */
    public static final class d extends RecyclerView.ItemDecoration {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            kotlin.jvm.internal.s.h(outRect, "outRect");
            kotlin.jvm.internal.s.h(view, "view");
            kotlin.jvm.internal.s.h(parent, "parent");
            kotlin.jvm.internal.s.h(state, "state");
            outRect.top = 0;
            outRect.bottom = 0;
            Context context = view.getContext();
            kotlin.jvm.internal.s.g(context, "view.context");
            outRect.left = us.pinguo.util.g.a(context, 30.0f);
            Context context2 = view.getContext();
            kotlin.jvm.internal.s.g(context2, "view.context");
            outRect.right = us.pinguo.util.g.a(context2, 30.0f);
        }
    }

    /* compiled from: HomePageFragment2020.kt */
    /* loaded from: classes3.dex */
    public static final class e extends ViewPager2.OnPageChangeCallback {
        final /* synthetic */ ViewPager2 b;
        final /* synthetic */ m0 c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList<f0> f6762d;

        e(ViewPager2 viewPager2, m0 m0Var, ArrayList<f0> arrayList) {
            this.b = viewPager2;
            this.c = m0Var;
            this.f6762d = arrayList;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i2) {
            r0 r0Var;
            if (i2 == 1 && (r0Var = HomePageFragment2020.this.p) != null) {
                r0Var.removeMessages(9011);
            }
            if (i2 == 0) {
                r0 r0Var2 = HomePageFragment2020.this.p;
                if (r0Var2 != null) {
                    HomePageFragment2020 homePageFragment2020 = HomePageFragment2020.this;
                    if (!r0Var2.hasMessages(9011) && !us.pinguo.repository2020.abtest.d.a.a()) {
                        RecyclerView.Adapter adapter = ((ViewPager2) homePageFragment2020._$_findCachedViewById(R.id.pagerBanner)).getAdapter();
                        if ((adapter == null ? 0 : adapter.getItemCount()) > 1) {
                            r0Var2.sendEmptyMessageDelayed(9011, 4000L);
                        }
                    }
                }
                int currentItem = this.b.getCurrentItem();
                if (currentItem == 0) {
                    this.b.setCurrentItem(this.c.getItemCount() - 2, false);
                    us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
                    ArrayList<f0> arrayList = this.f6762d;
                    cVar.K(arrayList.get(arrayList.size() - 1).a(), "show");
                } else if (currentItem == this.c.getItemCount() - 1) {
                    this.b.setCurrentItem(1, false);
                    us.pinguo.foundation.statistics.h.a.K(this.f6762d.get(0).a(), "show");
                } else {
                    us.pinguo.foundation.statistics.h.a.K(this.f6762d.get(currentItem - 1).a(), "show");
                }
            }
        }
    }

    /* compiled from: HomePageFragment2020.kt */
    /* loaded from: classes3.dex */
    public static final class f implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View b;

        f(View view) {
            this.b = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(final HomePageFragment2020 this$0) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            ((ShapeableImageView) this$0._$_findCachedViewById(R.id.fakePager)).animate().alpha(0.0f).setDuration(1200L).withEndAction(new Runnable() { // from class: com.pinguo.camera360.homepage.s
                @Override // java.lang.Runnable
                public final void run() {
                    HomePageFragment2020.f.d(HomePageFragment2020.this);
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(HomePageFragment2020 this$0) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            int i2 = R.id.fakePager;
            ((ShapeableImageView) this$0._$_findCachedViewById(i2)).setImageDrawable(null);
            ShapeableImageView fakePager = (ShapeableImageView) this$0._$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(fakePager, "fakePager");
            fakePager.setVisibility(8);
            VdsAgent.onSetViewVisibility(fakePager, 8);
            Bitmap bitmap = vStudio.Android.Camera360.activity.g.a;
            if (bitmap != null) {
                bitmap.recycle();
            }
            vStudio.Android.Camera360.activity.g.a = null;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            FragmentActivity activity = HomePageFragment2020.this.getActivity();
            if (activity != null) {
                activity.startPostponedEnterTransition();
            }
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            final HomePageFragment2020 homePageFragment2020 = HomePageFragment2020.this;
            us.pinguo.foundation.utils.f.d(new Runnable() { // from class: com.pinguo.camera360.homepage.t
                @Override // java.lang.Runnable
                public final void run() {
                    HomePageFragment2020.f.c(HomePageFragment2020.this);
                }
            }, 600L);
            return false;
        }
    }

    public HomePageFragment2020() {
        HomePageFragment2020$special$$inlined$viewModels$default$1 homePageFragment2020$special$$inlined$viewModels$default$1 = new HomePageFragment2020$special$$inlined$viewModels$default$1(this);
        this.f6755f = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(p0.class), new HomePageFragment2020$special$$inlined$viewModels$default$2(homePageFragment2020$special$$inlined$viewModels$default$1), new HomePageFragment2020$special$$inlined$viewModels$default$3(homePageFragment2020$special$$inlined$viewModels$default$1, this));
        this.f6757h = new o0();
        this.f6758i = true;
        this.f6760k = true;
        this.f6761l = -1;
    }

    private final void A0() {
        us.pinguo.repository2020.abtest.f fVar = us.pinguo.repository2020.abtest.f.a;
        if (!fVar.b() || fVar.a()) {
            boolean z = false;
            if (this.o) {
                this.o = false;
                return;
            }
            HomeRewardAdvDialogController homeRewardAdvDialogController = this.n;
            if (homeRewardAdvDialogController != null && homeRewardAdvDialogController.p()) {
                z = true;
            }
            if (!z && this.f6758i) {
                InterstitialManager.getInstance().e(IADStatisticBase.UNIT_ID_INTERSTITIAL_HOME_BACKUP, getActivity());
                if (this.f6759j && !InterstitialManager.getInstance().g(getActivity(), IADStatisticBase.UNIT_ID_INTERSTITIAL_HOME)) {
                    InterstitialManager.getInstance().g(getActivity(), IADStatisticBase.UNIT_ID_INTERSTITIAL_HOME_BACKUP);
                }
                this.f6759j = true;
                if (this.f6760k) {
                    return;
                }
                InterstitialManager.getInstance().e(IADStatisticBase.UNIT_ID_INTERSTITIAL_HOME, getActivity());
            }
        }
    }

    private final void B0(String[] strArr, kotlin.jvm.b.a<kotlin.u> aVar) {
        PermissionDialog v0 = v0(strArr, aVar);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        kotlin.jvm.internal.s.g(supportFragmentManager, "it.supportFragmentManager");
        v0.show(supportFragmentManager, "tag_permission_info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0() {
        Intent intent = new Intent("us.pinguo.camera360.CAMERA2020");
        intent.setFlags(603979776);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            return;
        }
        activity2.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0(boolean z) {
        int i2 = z ? R.drawable.ic_home_vip : R.drawable.ic_home_golden_vip;
        View view = getView();
        if (view == null) {
            return;
        }
        ((SimpleDraweeView) view.findViewById(R.id.imgHomeVip)).setActualImageResource(i2);
        i0().h(!z);
    }

    private final p0 i0() {
        return (p0) this.f6755f.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
        if (r0.p("android.permission.ACCESS_MEDIA_LOCATION") == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
        r0 = new com.pinguo.camera360.homepage.q(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
        if (us.pinguo.foundation.utils.p0.a(r7) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
        r5 = r7.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
        if (r5 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
        r5.t(r0, true, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_MEDIA_LOCATION");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
        kotlin.jvm.internal.s.z("permissionManager");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
        r4 = r7.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
        if (r4 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
        r4.t(r0, true, "android.permission.WRITE_EXTERNAL_STORAGE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
        kotlin.jvm.internal.s.z("permissionManager");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r0.o("android.permission.WRITE_EXTERNAL_STORAGE") != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void j0() {
        /*
            r7 = this;
            us.pinguo.permissionlib.PermissionManager r0 = r7.m
            r1 = 0
            java.lang.String r2 = "permissionManager"
            if (r0 == 0) goto L7b
            java.lang.String r3 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r0 = r0.p(r3)
            java.lang.String r4 = "android.permission.ACCESS_MEDIA_LOCATION"
            if (r0 != 0) goto L20
            us.pinguo.permissionlib.PermissionManager r0 = r7.m
            if (r0 == 0) goto L1c
            boolean r0 = r0.o(r3)
            if (r0 == 0) goto L34
            goto L20
        L1c:
            kotlin.jvm.internal.s.z(r2)
            throw r1
        L20:
            us.pinguo.permissionlib.PermissionManager r0 = r7.m
            if (r0 == 0) goto L77
            boolean r0 = r0.p(r3)
            if (r0 == 0) goto L64
            us.pinguo.permissionlib.PermissionManager r0 = r7.m
            if (r0 == 0) goto L60
            boolean r0 = r0.p(r4)
            if (r0 != 0) goto L64
        L34:
            com.pinguo.camera360.homepage.q r0 = new com.pinguo.camera360.homepage.q
            r0.<init>()
            boolean r5 = us.pinguo.foundation.utils.p0.a(r7)
            r6 = 1
            if (r5 == 0) goto L50
            us.pinguo.permissionlib.PermissionManager r5 = r7.m
            if (r5 == 0) goto L4c
            java.lang.String[] r1 = new java.lang.String[]{r3, r4}
            r5.t(r0, r6, r1)
            goto L76
        L4c:
            kotlin.jvm.internal.s.z(r2)
            throw r1
        L50:
            us.pinguo.permissionlib.PermissionManager r4 = r7.m
            if (r4 == 0) goto L5c
            java.lang.String[] r1 = new java.lang.String[]{r3}
            r4.t(r0, r6, r1)
            goto L76
        L5c:
            kotlin.jvm.internal.s.z(r2)
            throw r1
        L60:
            kotlin.jvm.internal.s.z(r2)
            throw r1
        L64:
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            java.lang.String r1 = "app://camera360/edit"
            android.net.Uri r1 = android.net.Uri.parse(r1)
            com.pinguo.camera360.j.a.a(r0, r1)
            us.pinguo.foundation.statistics.c r0 = us.pinguo.foundation.statistics.h.a
            r0.s()
        L76:
            return
        L77:
            kotlin.jvm.internal.s.z(r2)
            throw r1
        L7b:
            kotlin.jvm.internal.s.z(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.homepage.HomePageFragment2020.j0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(HomePageFragment2020 this$0, String[] granted, String[] denied) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.g(granted, "granted");
        if (!(granted.length == 0)) {
            com.pinguo.camera360.j.a.a(this$0.getActivity(), Uri.parse("app://camera360/edit"));
            us.pinguo.foundation.statistics.h.a.s();
            return;
        }
        ArrayList arrayList = new ArrayList();
        kotlin.jvm.internal.s.g(denied, "denied");
        for (String str : denied) {
            PermissionManager permissionManager = this$0.m;
            if (permissionManager == null) {
                kotlin.jvm.internal.s.z("permissionManager");
                throw null;
            }
            if (!permissionManager.o(str)) {
                arrayList.add(str);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        kotlin.jvm.internal.s.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this$0.B0((String[]) array, new HomePageFragment2020$gotoEdit$listener$1$2(this$0));
    }

    private final void l0(ViewPager2 viewPager2) {
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("mLayoutManager");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(viewPager2);
            if (obj != null) {
                Context context = viewPager2.getContext();
                kotlin.jvm.internal.s.g(context, "viewPager.context");
                HomePagerBannerLinearLayoutManager homePagerBannerLinearLayoutManager = new HomePagerBannerLinearLayoutManager(context, (LinearLayoutManager) obj, viewPager2);
                homePagerBannerLinearLayoutManager.setOrientation(0);
                declaredField.set(viewPager2, homePagerBannerLinearLayoutManager);
                Field declaredField2 = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(viewPager2);
                Field declaredField3 = obj2.getClass().getDeclaredField("mLayoutManager");
                declaredField3.setAccessible(true);
                declaredField3.set(obj2, homePagerBannerLinearLayoutManager);
                Field declaredField4 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");
                declaredField4.setAccessible(true);
                Object obj3 = declaredField4.get(viewPager2);
                Field declaredField5 = obj3.getClass().getDeclaredField("mLayoutManager");
                declaredField5.setAccessible(true);
                declaredField5.set(obj3, homePagerBannerLinearLayoutManager);
                Field declaredField6 = ViewPager2.class.getDeclaredField("mRecyclerView");
                declaredField6.setAccessible(true);
                Object obj4 = declaredField6.get(viewPager2);
                if (obj4 != null) {
                    ((RecyclerView) obj4).setLayoutManager(homePagerBannerLinearLayoutManager);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        } catch (Exception e2) {
            e2.printStackTrace();
            CrashReport.postCatchedException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(f0 f0Var, int i2) {
        if (i2 == -1) {
            f0Var = i0().c();
        }
        us.pinguo.foundation.interaction.d d2 = f0Var.d();
        if (d2 != null) {
            AppGoto.getInstance().e(d2).b(getActivity());
        } else {
            if (f0Var.c().length() > 0) {
                AppGoto.getInstance().b(Uri.parse(f0Var.c())).b(getActivity());
            }
        }
        us.pinguo.foundation.c.c("b_clk");
        us.pinguo.foundation.statistics.h.a.K(f0Var.a(), "click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(int i2, i0 i0Var) {
        if (i0Var.g() != null) {
            AppGoto.getInstance().e(i0Var.g()).b(getActivity());
        } else {
            if (i0Var.f().length() > 0) {
                AppGoto.getInstance().c(i0Var.f()).b(getActivity());
            }
        }
        us.pinguo.foundation.c.c(kotlin.jvm.internal.s.q("f_clk", Integer.valueOf(i2)));
        us.pinguo.foundation.statistics.h.a.o0(String.valueOf(i0Var.e()), i0Var.a(), "click");
    }

    private final boolean o0() {
        StrategyItem strategyItem = PgAdvStrategyManager.getInstance().getStrategyKeeper(getActivity()).getStrategyItem(IADStatisticBase.UNIT_ID_INTERSTITIAL_HOME);
        return strategyItem != null && strategyItem.isEnable();
    }

    private final void p0() {
        String c2 = i0().e().c();
        if (c2 == null || c2.length() == 0) {
            ((SimpleDraweeView) _$_findCachedViewById(R.id.homeBackground)).setActualImageResource(R.color.home_page_bg_default);
        } else {
            ((SimpleDraweeView) _$_findCachedViewById(R.id.homeBackground)).setImageURI(Uri.parse(kotlin.jvm.internal.s.q(InspirePublishFragment.FILE_HEADER, c2)), (Object) null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x0201, code lost:
        if ((r0.length() > 0) == true) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0215  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void q0() {
        /*
            Method dump skipped, instructions count: 549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.homepage.HomePageFragment2020.q0():void");
    }

    private final void r0() {
        j0 e2 = i0().e();
        Object d2 = e2.d();
        if (d2 instanceof Integer) {
            ((SimpleDraweeView) _$_findCachedViewById(R.id.imgLogo)).setActualImageResource(((Number) d2).intValue(), null);
        } else if (d2 instanceof String) {
            ((SimpleDraweeView) _$_findCachedViewById(R.id.imgLogo)).setImageURI(Uri.parse(kotlin.jvm.internal.s.q(InspirePublishFragment.FILE_HEADER, d2)), (Object) null);
        } else {
            ((SimpleDraweeView) _$_findCachedViewById(R.id.imgLogo)).setActualImageResource(R.drawable.ic_c360_logo, null);
        }
        Object f2 = e2.f();
        if (f2 instanceof Integer) {
            ((SimpleDraweeView) _$_findCachedViewById(R.id.imgHomeVip)).setActualImageResource(((Number) f2).intValue());
        } else if (f2 instanceof String) {
            ((SimpleDraweeView) _$_findCachedViewById(R.id.imgHomeVip)).setImageURI(Uri.parse(kotlin.jvm.internal.s.q(InspirePublishFragment.FILE_HEADER, f2)), (Object) null);
        } else {
            ((SimpleDraweeView) _$_findCachedViewById(R.id.imgHomeVip)).setActualImageResource(R.drawable.ic_home_vip);
        }
        Object e3 = e2.e();
        if (e3 instanceof Integer) {
            ((SimpleDraweeView) _$_findCachedViewById(R.id.imgUserCenter)).setActualImageResource(((Number) e3).intValue());
        } else if (e3 instanceof String) {
            ((SimpleDraweeView) _$_findCachedViewById(R.id.imgUserCenter)).setImageURI(Uri.parse(kotlin.jvm.internal.s.q(InspirePublishFragment.FILE_HEADER, e3)), (Object) null);
        } else {
            ((SimpleDraweeView) _$_findCachedViewById(R.id.imgUserCenter)).setActualImageResource(R.drawable.ic_user_profile);
        }
    }

    private final PermissionDialog v0(String[] strArr, kotlin.jvm.b.a<kotlin.u> aVar) {
        boolean m;
        boolean m2;
        PermissionDialog permissionDialog = new PermissionDialog();
        m = kotlin.collections.n.m(strArr, "android.permission.CAMERA");
        permissionDialog.f0(m);
        m2 = kotlin.collections.n.m(strArr, "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionDialog.g0(m2);
        permissionDialog.e0(new b(strArr, this, aVar));
        return permissionDialog;
    }

    private final List<String> w0() {
        ArrayList arrayList = new ArrayList();
        PermissionManager permissionManager = this.m;
        if (permissionManager != null) {
            if (!permissionManager.p("android.permission.CAMERA")) {
                PermissionManager permissionManager2 = this.m;
                if (permissionManager2 == null) {
                    kotlin.jvm.internal.s.z("permissionManager");
                    throw null;
                } else if (!permissionManager2.o("android.permission.CAMERA")) {
                    arrayList.add("android.permission.CAMERA");
                }
            }
            PermissionManager permissionManager3 = this.m;
            if (permissionManager3 != null) {
                if (!permissionManager3.p("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    PermissionManager permissionManager4 = this.m;
                    if (permissionManager4 == null) {
                        kotlin.jvm.internal.s.z("permissionManager");
                        throw null;
                    } else if (!permissionManager4.o("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                }
                if (us.pinguo.foundation.utils.p0.a(this)) {
                    PermissionManager permissionManager5 = this.m;
                    if (permissionManager5 == null) {
                        kotlin.jvm.internal.s.z("permissionManager");
                        throw null;
                    } else if (!permissionManager5.p("android.permission.ACCESS_MEDIA_LOCATION")) {
                        PermissionManager permissionManager6 = this.m;
                        if (permissionManager6 == null) {
                            kotlin.jvm.internal.s.z("permissionManager");
                            throw null;
                        } else if (!permissionManager6.o("android.permission.ACCESS_MEDIA_LOCATION")) {
                            arrayList.add("android.permission.ACCESS_MEDIA_LOCATION");
                        }
                    }
                }
                return arrayList;
            }
            kotlin.jvm.internal.s.z("permissionManager");
            throw null;
        }
        kotlin.jvm.internal.s.z("permissionManager");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(HomePageFragment2020 this$0, String[] strArr, String[] denied) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        PermissionManager permissionManager = this$0.m;
        if (permissionManager == null) {
            kotlin.jvm.internal.s.z("permissionManager");
            throw null;
        } else if (permissionManager.p("android.permission.CAMERA")) {
            this$0.C0();
        } else {
            ArrayList arrayList = new ArrayList();
            kotlin.jvm.internal.s.g(denied, "denied");
            for (String str : denied) {
                PermissionManager permissionManager2 = this$0.m;
                if (permissionManager2 == null) {
                    kotlin.jvm.internal.s.z("permissionManager");
                    throw null;
                }
                if (!permissionManager2.o(str) && !kotlin.jvm.internal.s.c("android.permission.WRITE_EXTERNAL_STORAGE", str)) {
                    arrayList.add(str);
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            kotlin.jvm.internal.s.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            this$0.B0((String[]) array, new HomePageFragment2020$onClick$1$2(this$0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(View page, float f2) {
        kotlin.jvm.internal.s.h(page, "page");
        if (f2 < -1.0f || f2 > 1.0f) {
            return;
        }
        float f3 = 1;
        float f4 = f3 - 0.9f;
        float abs = ((f3 - Math.abs(f2)) * f4) + 0.9f;
        page.setScaleX(abs);
        page.setScaleY(abs);
        page.setAlpha((((abs - 0.9f) / f4) * (f3 - 0.5f)) + 0.5f);
    }

    private final void z0() {
        if ((i0().d() || VipManager.a.I() || !us.pinguo.repository2020.abtest.i.a.b()) ? false : true) {
            if (us.pinguo.repository2020.abtest.i.a.d() && us.pinguo.repository2020.abtest.h.a.b()) {
                return;
            }
            ConstraintLayout root = (ConstraintLayout) _$_findCachedViewById(R.id.root);
            kotlin.jvm.internal.s.g(root, "root");
            FragmentActivity requireActivity = requireActivity();
            kotlin.jvm.internal.s.g(requireActivity, "requireActivity()");
            HomeRewardAdvDialogController homeRewardAdvDialogController = new HomeRewardAdvDialogController(root, requireActivity);
            homeRewardAdvDialogController.s();
            HomeRewardAdvDialogController.z(homeRewardAdvDialogController, "launch", false, 2, null);
            homeRewardAdvDialogController.t(new HomePageFragment2020$showAdGuideDialog$1$1(this));
            this.n = homeRewardAdvDialogController;
            i0().i(true);
        }
    }

    @Override // us.pinguo.u3dengine.PGUnityNoneFragment, us.pinguo.u3dengine.BaseUnityPlayerFragment
    public void _$_clearFindViewByIdCache() {
        this.f6754e.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this.f6754e;
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

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment
    public ViewGroup b0() {
        return (FrameLayout) _$_findCachedViewById(R.id.emptyUnityContainer);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        PermissionManager permissionManager = this.m;
        if (permissionManager != null) {
            permissionManager.r(i2, i3, intent);
        } else {
            kotlin.jvm.internal.s.z("permissionManager");
            throw null;
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View v) {
        VdsAgent.onClick(this, v);
        kotlin.jvm.internal.s.h(v, "v");
        switch (v.getId()) {
            case R.id.clGoCamera /* 2131296666 */:
                if (us.pinguo.foundation.utils.j.a(1000L)) {
                    return;
                }
                PermissionManager permissionManager = this.m;
                if (permissionManager != null) {
                    if (permissionManager.p("android.permission.CAMERA")) {
                        C0();
                        us.pinguo.foundation.c.c("ca_clk_with_per");
                    } else {
                        us.pinguo.foundation.c.c("ca_clk_no_per");
                        List<String> w0 = w0();
                        if (!w0.isEmpty()) {
                            this.o = true;
                            PermissionManager permissionManager2 = this.m;
                            if (permissionManager2 == null) {
                                kotlin.jvm.internal.s.z("permissionManager");
                                throw null;
                            }
                            us.pinguo.permissionlib.c.a aVar = new us.pinguo.permissionlib.c.a() { // from class: com.pinguo.camera360.homepage.o
                                @Override // us.pinguo.permissionlib.c.a
                                public final void a(String[] strArr, String[] strArr2) {
                                    HomePageFragment2020.x0(HomePageFragment2020.this, strArr, strArr2);
                                }
                            };
                            Object[] array = w0.toArray(new String[0]);
                            kotlin.jvm.internal.s.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            String[] strArr = (String[]) array;
                            permissionManager2.t(aVar, true, (String[]) Arrays.copyOf(strArr, strArr.length));
                        } else {
                            C0();
                        }
                    }
                    us.pinguo.foundation.statistics.h.a.T();
                    return;
                }
                kotlin.jvm.internal.s.z("permissionManager");
                throw null;
            case R.id.clGoEdit /* 2131296667 */:
                if (us.pinguo.foundation.utils.j.a(1000L)) {
                    return;
                }
                j0();
                return;
            case R.id.imgHomeVip /* 2131297194 */:
                if (us.pinguo.foundation.utils.j.a(1000L)) {
                    return;
                }
                if (i0().g()) {
                    HomeRewardAdvDialogController homeRewardAdvDialogController = this.n;
                    if (homeRewardAdvDialogController == null) {
                        return;
                    }
                    homeRewardAdvDialogController.y("home", false);
                    return;
                }
                Intent intent = new Intent();
                VipManager vipManager = VipManager.a;
                if (!vipManager.G() && !vipManager.H()) {
                    FragmentActivity activity = getActivity();
                    kotlin.jvm.internal.s.e(activity);
                    intent.setClass(activity, MemberRightsActivity.class);
                } else {
                    FragmentActivity activity2 = getActivity();
                    kotlin.jvm.internal.s.e(activity2);
                    intent.setClass(activity2, SubscriptionMemberActivity.class);
                }
                intent.putExtra("source_page", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
                intent.putExtra("source_extra", "HomePage");
                startActivityForResult(intent, 9527);
                us.pinguo.foundation.statistics.h.a.O();
                return;
            case R.id.imgUserCenter /* 2131297211 */:
                if (us.pinguo.foundation.utils.j.a(1000L)) {
                    return;
                }
                startActivity(new Intent(getContext(), MyActivity.class));
                us.pinguo.foundation.statistics.h.a.l();
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f6761l = arguments != null ? arguments.getInt("union_adv_index", -1) : -1;
        PermissionManager permissionManager = new PermissionManager(this, us.pinguo.foundation.d.f10987f);
        this.m = permissionManager;
        if (permissionManager != null) {
            permissionManager.w("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA");
        } else {
            kotlin.jvm.internal.s.z("permissionManager");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        this.f6758i = o0();
        return inflater.inflate(R.layout.fragment_home_page_layout, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ViewPager2 viewPager2 = (ViewPager2) _$_findCachedViewById(R.id.pagerBanner);
        if (viewPager2 != null) {
            viewPager2.setAdapter(null);
        }
        PermissionManager permissionManager = this.m;
        if (permissionManager != null) {
            permissionManager.d();
        } else {
            kotlin.jvm.internal.s.z("permissionManager");
            throw null;
        }
    }

    @Override // us.pinguo.u3dengine.PGUnityNoneFragment, us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ViewPager2 viewPager2 = (ViewPager2) _$_findCachedViewById(R.id.pagerBanner);
        if (viewPager2 != null) {
            viewPager2.setAdapter(null);
        }
        _$_clearFindViewByIdCache();
    }

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        r0 r0Var = this.p;
        if (r0Var != null) {
            r0Var.removeMessages(9011);
        }
        if (this.f6760k) {
            this.f6760k = false;
            if (this.f6758i) {
                InterstitialManager.getInstance().e(IADStatisticBase.UNIT_ID_INTERSTITIAL_HOME, getActivity());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.s.h(permissions, "permissions");
        kotlin.jvm.internal.s.h(grantResults, "grantResults");
        super.onRequestPermissionsResult(i2, permissions, grantResults);
        PermissionManager permissionManager = this.m;
        if (permissionManager != null) {
            permissionManager.s(i2, permissions, grantResults);
        } else {
            kotlin.jvm.internal.s.z("permissionManager");
            throw null;
        }
    }

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PermissionManager permissionManager = this.m;
        if (permissionManager != null) {
            permissionManager.v();
            r0 r0Var = this.p;
            if (r0Var != null && us.pinguo.repository2020.abtest.d.a.a()) {
                int i2 = R.id.pagerBanner;
                ((ViewPager2) _$_findCachedViewById(i2)).setCurrentItem(((ViewPager2) _$_findCachedViewById(i2)).getCurrentItem() + 1, true);
            }
            if (r0Var == null) {
                r0Var = new r0(new WeakReference(this));
                this.p = r0Var;
            }
            if (!us.pinguo.repository2020.abtest.d.a.a()) {
                RecyclerView.Adapter adapter = ((ViewPager2) _$_findCachedViewById(R.id.pagerBanner)).getAdapter();
                if ((adapter == null ? 0 : adapter.getItemCount()) > 1) {
                    r0Var.sendEmptyMessageDelayed(9011, 4000L);
                }
            }
            A0();
            ArrayList<f0> arrayList = this.f6756g;
            if (arrayList != null) {
                int i3 = R.id.pagerBanner;
                RecyclerView.Adapter adapter2 = ((ViewPager2) _$_findCachedViewById(i3)).getAdapter();
                int itemCount = adapter2 == null ? 0 : adapter2.getItemCount();
                if (itemCount > 1) {
                    int currentItem = ((ViewPager2) _$_findCachedViewById(i3)).getCurrentItem();
                    if (currentItem == 0) {
                        us.pinguo.foundation.statistics.h.a.K(arrayList.get(arrayList.size() - 1).a(), "show");
                    } else if (currentItem == itemCount - 1) {
                        us.pinguo.foundation.statistics.h.a.K(arrayList.get(0).a(), "show");
                    } else {
                        us.pinguo.foundation.statistics.h.a.K(arrayList.get(currentItem - 1).a(), "show");
                    }
                } else if (itemCount == 1) {
                    us.pinguo.foundation.statistics.h.a.K(arrayList.get(0).a(), "show");
                }
            }
            if (this.n != null && VipManager.a.I()) {
                D0(true);
                return;
            }
            return;
        }
        kotlin.jvm.internal.s.z("permissionManager");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        List<i0> a2 = i0().a();
        for (i0 i0Var : a2) {
            us.pinguo.foundation.statistics.h.a.o0(String.valueOf(i0Var.e()), i0Var.a(), "show");
        }
        this.f6757h.m(a2);
    }

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.s.h(view, "view");
        Context context = getContext();
        if (context == null) {
            return;
        }
        super.onViewCreated(view, bundle);
        int i2 = us.pinguo.foundation.j.e().i("hairCut", 0);
        SimpleDraweeView imgLogo = (SimpleDraweeView) _$_findCachedViewById(R.id.imgLogo);
        kotlin.jvm.internal.s.g(imgLogo, "imgLogo");
        ViewGroup.LayoutParams layoutParams = imgLogo.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin += i2;
        imgLogo.setLayoutParams(layoutParams2);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvFunctionsPosition);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView.addItemDecoration(new c());
        this.f6757h.n(new HomePageFragment2020$onViewCreated$3(this));
        recyclerView.setAdapter(this.f6757h);
        recyclerView.setEdgeEffectFactory(new us.pinguo.common.a());
        ViewPager2 pager = (ViewPager2) _$_findCachedViewById(R.id.pagerBanner);
        kotlin.jvm.internal.s.g(pager, "pager");
        l0(pager);
        Rational rational = new Rational(16, 9);
        Rational rational2 = new Rational(us.pinguo.util.h.g(context), us.pinguo.util.h.i(context));
        int i3 = us.pinguo.util.h.i(context) - us.pinguo.util.g.a(context, 60.0f);
        if (rational2.compareTo(rational) > 0) {
            i3 = (int) ((i3 * 3.5f) / 3.0f);
        }
        ViewGroup.LayoutParams layoutParams3 = pager.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = i3;
        pager.setLayoutParams(layoutParams4);
        if (this.f6761l != -1 && vStudio.Android.Camera360.activity.g.a != null) {
            int i4 = R.id.fakePager;
            ShapeableImageView fakePager = (ShapeableImageView) _$_findCachedViewById(i4);
            kotlin.jvm.internal.s.g(fakePager, "fakePager");
            ViewGroup.LayoutParams layoutParams5 = fakePager.getLayoutParams();
            Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams5.height = i3;
            fakePager.setLayoutParams(layoutParams5);
            ((ShapeableImageView) _$_findCachedViewById(i4)).setTransitionName("union_transition");
            ((ShapeableImageView) _$_findCachedViewById(i4)).setImageBitmap(vStudio.Android.Camera360.activity.g.a);
        }
        m0 m0Var = new m0();
        ArrayList<f0> b2 = i0().b();
        this.f6756g = b2;
        m0Var.o(b2);
        pager.addItemDecoration(new d());
        if (m0Var.h() >= 2) {
            pager.registerOnPageChangeCallback(new e(pager, m0Var, b2));
            pager.setPageTransformer(p.a);
        }
        m0Var.p(new HomePageFragment2020$onViewCreated$8(this));
        pager.setAdapter(m0Var);
        if (m0Var.h() >= 2) {
            int i5 = R.id.indicatorBanner;
            HomePageSimpleBannerIndicator indicatorBanner = (HomePageSimpleBannerIndicator) _$_findCachedViewById(i5);
            kotlin.jvm.internal.s.g(indicatorBanner, "indicatorBanner");
            indicatorBanner.setVisibility(0);
            VdsAgent.onSetViewVisibility(indicatorBanner, 0);
            ((HomePageSimpleBannerIndicator) _$_findCachedViewById(i5)).setUpWithViewPager2(pager);
            int i6 = this.f6761l;
            if (i6 == -1) {
                pager.setCurrentItem(1, false);
            } else {
                pager.setCurrentItem(i6 + 1, false);
            }
        } else {
            pager.setCurrentItem(0, false);
            HomePageSimpleBannerIndicator indicatorBanner2 = (HomePageSimpleBannerIndicator) _$_findCachedViewById(R.id.indicatorBanner);
            kotlin.jvm.internal.s.g(indicatorBanner2, "indicatorBanner");
            indicatorBanner2.setVisibility(8);
            VdsAgent.onSetViewVisibility(indicatorBanner2, 8);
        }
        p0();
        r0();
        q0();
        ((SimpleDraweeView) _$_findCachedViewById(R.id.imgHomeVip)).setOnClickListener(this);
        ((SimpleDraweeView) _$_findCachedViewById(R.id.imgUserCenter)).setOnClickListener(this);
        ((AlphaPressedConstraintLayout) _$_findCachedViewById(R.id.clGoCamera)).setOnClickListener(this);
        ((AlphaPressedConstraintLayout) _$_findCachedViewById(R.id.clGoEdit)).setOnClickListener(this);
        FilterRepository.a.d();
        if (this.f6761l != -1) {
            this.f6761l = -1;
            view.getViewTreeObserver().addOnPreDrawListener(new f(view));
        }
        User.d().t();
        z0();
    }
}
