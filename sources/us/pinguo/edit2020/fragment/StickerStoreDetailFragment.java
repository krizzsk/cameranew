package us.pinguo.edit2020.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import us.pinguo.common.widget.FragmentLoadingView;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.utils.FlowObserver;
import us.pinguo.edit2020.utils.k;
import us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel;
import us.pinguo.edit2020.viewmodel.d;
import us.pinguo.edit2020.widget.dialog.CircleProgressWithResultDialog;
import us.pinguo.repository2020.database.staticsticker.Banner;
import us.pinguo.repository2020.database.staticsticker.IconBig;
import us.pinguo.repository2020.database.staticsticker.ShopDetail;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategoryTable;
import us.pinguo.ui.widget.AlphaPressedConstraintLayout;
/* compiled from: StickerStoreDetailFragment.kt */
@Instrumented
/* loaded from: classes4.dex */
public final class StickerStoreDetailFragment extends Fragment {

    /* renamed from: k  reason: collision with root package name */
    public static final a f10517k = new a(null);
    public Map<Integer, View> a;
    private String b;
    private FragmentLoadingView c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.f f10518d;

    /* renamed from: e  reason: collision with root package name */
    private StickerDownloadType f10519e;

    /* renamed from: f  reason: collision with root package name */
    private int f10520f;

    /* renamed from: g  reason: collision with root package name */
    private CircleProgressWithResultDialog f10521g;

    /* renamed from: h  reason: collision with root package name */
    private StaticStickerCategory f10522h;

    /* renamed from: i  reason: collision with root package name */
    private ShopDetail f10523i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10524j;

    /* compiled from: StickerStoreDetailFragment.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final StickerStoreDetailFragment a(String pid) {
            kotlin.jvm.internal.s.h(pid, "pid");
            StickerStoreDetailFragment stickerStoreDetailFragment = new StickerStoreDetailFragment();
            stickerStoreDetailFragment.setArguments(BundleKt.bundleOf(new Pair("data", pid)));
            return stickerStoreDetailFragment;
        }
    }

    /* compiled from: StickerStoreDetailFragment.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[StickerDownloadType.values().length];
            iArr[StickerDownloadType.None.ordinal()] = 1;
            iArr[StickerDownloadType.FreeTrial.ordinal()] = 2;
            iArr[StickerDownloadType.UnDownloaded.ordinal()] = 3;
            iArr[StickerDownloadType.Downloaded.ordinal()] = 4;
            a = iArr;
        }
    }

    /* compiled from: StickerStoreDetailFragment.kt */
    /* loaded from: classes4.dex */
    public static final class c extends OnBackPressedCallback {
        c() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (StickerStoreDetailFragment.this.f10524j) {
                StickerStoreDetailFragment.this.y0(null);
            }
            setEnabled(false);
            StickerStoreDetailFragment.this.requireActivity().onBackPressed();
        }
    }

    public StickerStoreDetailFragment() {
        super(R.layout.fragment_sticker_detail_layout);
        this.a = new LinkedHashMap();
        this.b = "";
        this.f10518d = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(StaticStickerStoreViewModel.class), new StickerStoreDetailFragment$special$$inlined$activityViewModels$default$1(this), new StickerStoreDetailFragment$special$$inlined$activityViewModels$default$2(this));
        this.f10519e = StickerDownloadType.None;
        this.f10520f = -100;
    }

    private final void C0() {
        us.pinguo.foundation.utils.w.i(requireContext(), R.string.filter_download_dialog_content, R.string.filter_download_dialog_bt_pos, R.string.filter_download_dialog_bt_neg, new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.fragment.r0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                StickerStoreDetailFragment.D0(StickerStoreDetailFragment.this, dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(StickerStoreDetailFragment this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -1) {
            this$0.z0();
            us.pinguo.repository2020.m.a.S(true);
        }
        dialogInterface.cancel();
    }

    private final void E0(ShopDetail shopDetail) {
        Integer vip = shopDetail.getVip();
        if (vip != null && vip.intValue() == 0) {
            ((TextView) _$_findCachedViewById(R.id.tvStatus)).setText(us.pinguo.edit2020.utils.d.k(R.string.shop_item_free));
        } else if (us.pinguo.vip.proxy.b.a.f()) {
            ((TextView) _$_findCachedViewById(R.id.tvStatus)).setText(us.pinguo.edit2020.utils.d.k(R.string.str_vip_free));
        } else {
            ((TextView) _$_findCachedViewById(R.id.tvStatus)).setText(us.pinguo.edit2020.utils.d.k(R.string.str_vip_only));
        }
        AlphaPressedConstraintLayout clControl = (AlphaPressedConstraintLayout) _$_findCachedViewById(R.id.clControl);
        kotlin.jvm.internal.s.g(clControl, "clControl");
        clControl.setVisibility(0);
        VdsAgent.onSetViewVisibility(clControl, 0);
        F0(r0().p(), shopDetail);
    }

    private final void F0(Map<String, StaticStickerCategoryTable> map, ShopDetail shopDetail) {
        Integer completed;
        StaticStickerCategoryTable staticStickerCategoryTable = map.get(this.b);
        boolean z = false;
        if (staticStickerCategoryTable != null && (completed = staticStickerCategoryTable.getCompleted()) != null && 1 == completed.intValue()) {
            z = true;
        }
        if (z) {
            this.f10519e = StickerDownloadType.Downloaded;
            ((TextView) _$_findCachedViewById(R.id.tvStickerStatus)).setText(us.pinguo.edit2020.utils.d.k(R.string.str_use));
            return;
        }
        Integer vip = shopDetail.getVip();
        if (vip != null && vip.intValue() == 0) {
            this.f10519e = StickerDownloadType.UnDownloaded;
            ((TextView) _$_findCachedViewById(R.id.tvStickerStatus)).setText(us.pinguo.edit2020.utils.d.k(R.string.pg_sdk_edit_download_for_free));
        } else if (us.pinguo.vip.proxy.b.a.f()) {
            this.f10519e = StickerDownloadType.UnDownloaded;
            ((TextView) _$_findCachedViewById(R.id.tvStickerStatus)).setText(us.pinguo.edit2020.utils.d.k(R.string.pg_sdk_edit_download_for_free));
        } else {
            this.f10519e = StickerDownloadType.FreeTrial;
            ((TextView) _$_findCachedViewById(R.id.tvStickerStatus)).setText(us.pinguo.edit2020.utils.d.k(R.string.camera_vip_banner_bt_text));
        }
    }

    private final void initView() {
        ((ImageView) _$_findCachedViewById(R.id.ivClose)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.fragment.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerStoreDetailFragment.t0(StickerStoreDetailFragment.this, view);
            }
        });
        ((AlphaPressedConstraintLayout) _$_findCachedViewById(R.id.clControl)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.fragment.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerStoreDetailFragment.u0(StickerStoreDetailFragment.this, view);
            }
        });
    }

    private final void j0(String str, int i2, int i3) {
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(getContext());
        com.facebook.drawee.generic.b u = com.facebook.drawee.generic.b.u(getResources());
        int i4 = R.drawable.ic_camera360_text;
        p.c cVar = p.c.f2564e;
        u.z(i4, cVar);
        u.D(i4, cVar);
        com.facebook.drawee.generic.a a2 = u.a();
        kotlin.jvm.internal.s.g(a2, "newInstance(resources)\n …TER)\n            .build()");
        simpleDraweeView.setBackgroundColor(us.pinguo.edit2020.utils.d.h(R.color.edit_result_adv_bg));
        simpleDraweeView.setHierarchy(a2);
        int j2 = us.pinguo.foundation.t.b.a.j(us.pinguo.foundation.e.b()) - us.pinguo.common.widget.i.a.a(32);
        int i5 = (int) ((i3 / i2) * j2);
        Uri parse = Uri.parse(str);
        kotlin.jvm.internal.s.g(parse, "parse(url)");
        us.pinguo.edit2020.utils.d.g(simpleDraweeView, parse, j2, i5);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(j2, i5);
        int a3 = us.pinguo.common.widget.i.a.a(16);
        layoutParams.topMargin = a3;
        layoutParams.bottomMargin = a3;
        ((LinearLayout) _$_findCachedViewById(R.id.llContainer)).addView(simpleDraweeView, layoutParams);
    }

    private final void k0(ShopDetail shopDetail) {
        String img;
        Banner[] banners;
        ((LinearLayout) _$_findCachedViewById(R.id.llContainer)).removeAllViews();
        Banner[] banners2 = shopDetail.getBanners();
        boolean z = true;
        if (banners2 != null) {
            if (!(banners2.length == 0)) {
                z = false;
            }
        }
        if (!z && (banners = shopDetail.getBanners()) != null) {
            int length = banners.length;
            int i2 = 0;
            while (i2 < length) {
                Banner banner = banners[i2];
                i2++;
                String img2 = banner.getImg();
                if (img2 != null) {
                    Integer width = banner.getWidth();
                    int intValue = width == null ? 0 : width.intValue();
                    Integer height = banner.getHeight();
                    j0(img2, intValue, height == null ? 0 : height.intValue());
                }
            }
        }
        IconBig icon_big = shopDetail.getIcon_big();
        if (icon_big == null || (img = icon_big.getImg()) == null) {
            return;
        }
        Integer width2 = icon_big.getWidth();
        int intValue2 = width2 == null ? 0 : width2.intValue();
        Integer height2 = icon_big.getHeight();
        j0(img, intValue2, height2 != null ? height2.intValue() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        FragmentLoadingView fragmentLoadingView = this.c;
        boolean z = false;
        if (fragmentLoadingView != null && fragmentLoadingView.c()) {
            z = true;
        }
        if (z) {
            kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new StickerStoreDetailFragment$doOnError$1(this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0() {
        if (us.pinguo.edit2020.utils.d.e(this.c)) {
            Context requireContext = requireContext();
            kotlin.jvm.internal.s.g(requireContext, "requireContext()");
            this.c = new FragmentLoadingView(requireContext);
        }
        FragmentLoadingView fragmentLoadingView = this.c;
        if (fragmentLoadingView != null) {
            fragmentLoadingView.f(false);
        }
        int i2 = R.id.flContainer;
        ((FrameLayout) _$_findCachedViewById(i2)).removeAllViews();
        ((FrameLayout) _$_findCachedViewById(i2)).addView(this.c);
        FragmentLoadingView fragmentLoadingView2 = this.c;
        if (fragmentLoadingView2 != null) {
            fragmentLoadingView2.d(true);
        }
        FragmentLoadingView fragmentLoadingView3 = this.c;
        if (fragmentLoadingView3 == null) {
            return;
        }
        fragmentLoadingView3.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(k.d<ShopDetail> dVar) {
        int i2 = R.id.flContainer;
        if (((FrameLayout) _$_findCachedViewById(i2)).getChildCount() != 0) {
            ((FrameLayout) _$_findCachedViewById(i2)).removeAllViews();
        }
        ShopDetail a2 = dVar.a();
        if (a2 == null) {
            return;
        }
        this.f10523i = a2;
        ((TextView) _$_findCachedViewById(R.id.tvName)).setText(a2.getName());
        ((TextView) _$_findCachedViewById(R.id.tvDesc)).setText(a2.getDesc());
        TextView vipLimit = (TextView) _$_findCachedViewById(R.id.vipLimit);
        kotlin.jvm.internal.s.g(vipLimit, "vipLimit");
        Integer vip = a2.getVip();
        int i3 = vip != null && vip.intValue() == 2 ? 0 : 8;
        vipLimit.setVisibility(i3);
        VdsAgent.onSetViewVisibility(vipLimit, i3);
        ((TextView) _$_findCachedViewById(R.id.tvTitle)).setText(a2.getName());
        k0(a2);
        E0(a2);
    }

    private final void o0() {
        Context applicationContext = us.pinguo.foundation.e.b();
        if (us.pinguo.util.q.f(applicationContext)) {
            kotlin.jvm.internal.s.g(applicationContext, "applicationContext");
            if (!us.pinguo.util.q.h(applicationContext) && !us.pinguo.repository2020.m.a.C()) {
                C0();
                return;
            } else {
                z0();
                return;
            }
        }
        us.pinguo.foundation.utils.k0.a.a(R.string.download_not_network);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StaticStickerStoreViewModel r0() {
        return (StaticStickerStoreViewModel) this.f10518d.getValue();
    }

    private final void s0() {
        kotlinx.coroutines.flow.c y = kotlinx.coroutines.flow.e.y(r0().m(), new StickerStoreDetailFragment$initObserver$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
        new FlowObserver(viewLifecycleOwner, y, new StickerStoreDetailFragment$initObserver$$inlined$observeInLifecycle$1(null));
        kotlinx.coroutines.flow.c y2 = kotlinx.coroutines.flow.e.y(r0().n(), new StickerStoreDetailFragment$initObserver$2(this, null));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.s.g(viewLifecycleOwner2, "viewLifecycleOwner");
        new FlowObserver(viewLifecycleOwner2, y2, new StickerStoreDetailFragment$initObserver$$inlined$observeInLifecycle$2(null));
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(StickerStoreDetailFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.f10524j) {
            this$0.y0(null);
        }
        this$0.r0().v(new d.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(StickerStoreDetailFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (us.pinguo.common.widget.tab.k.b(us.pinguo.common.widget.tab.k.a, 0, 1, null) || this$0.f10522h == null) {
            return;
        }
        int i2 = b.a[this$0.f10519e.ordinal()];
        if (i2 == 2) {
            us.pinguo.vip.proxy.c.d(us.pinguo.vip.proxy.c.a, this$0.getActivity(), null, false, 4, null);
        } else if (i2 == 3) {
            this$0.o0();
        } else if (i2 != 4) {
        } else {
            StaticStickerCategory staticStickerCategory = this$0.f10522h;
            this$0.y0(staticStickerCategory != null ? staticStickerCategory.getPid() : null);
            this$0.requireActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(String str) {
        FragmentActivity requireActivity = requireActivity();
        Intent intent = new Intent();
        intent.putExtra("s_type", "use_sticker");
        intent.putExtra("s_result", str);
        kotlin.u uVar = kotlin.u.a;
        requireActivity.setResult(-1, intent);
    }

    private final void z0() {
        StaticStickerCategory staticStickerCategory = this.f10522h;
        if (staticStickerCategory == null) {
            return;
        }
        r0().x(false);
        r0().i(staticStickerCategory);
    }

    public final void A0(CircleProgressWithResultDialog circleProgressWithResultDialog) {
        this.f10521g = circleProgressWithResultDialog;
    }

    public final void B0(int i2) {
        this.f10520f = i2;
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

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f10524j = false;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
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
        VdsAgent.onFragmentResume(this);
        super.onResume();
        if (us.pinguo.vip.proxy.b.a.f() && us.pinguo.edit2020.utils.d.d(this.f10523i)) {
            ShopDetail shopDetail = this.f10523i;
            kotlin.jvm.internal.s.e(shopDetail);
            E0(shopDetail);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String string;
        kotlin.jvm.internal.s.h(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String str = "";
        if (arguments != null && (string = arguments.getString("data")) != null) {
            str = string;
        }
        this.b = str;
        StaticStickerCategory t = r0().t(this.b);
        if (t == null) {
            return;
        }
        this.f10522h = t;
        r0().j(this.b);
        if (us.pinguo.foundation.t.b.a.l()) {
            AlphaPressedConstraintLayout clControl = (AlphaPressedConstraintLayout) _$_findCachedViewById(R.id.clControl);
            kotlin.jvm.internal.s.g(clControl, "clControl");
            ViewGroup.LayoutParams layoutParams = clControl.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = us.pinguo.common.widget.i.a.a(56);
            clControl.setLayoutParams(layoutParams2);
        }
        s0();
        initView();
    }

    public final CircleProgressWithResultDialog p0() {
        return this.f10521g;
    }

    public final int q0() {
        return this.f10520f;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}
