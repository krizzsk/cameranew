package us.pinguo.edit2020.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.c;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.common.widget.FragmentLoadingView;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.utils.FlowObserver;
import us.pinguo.edit2020.utils.k;
import us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel;
import us.pinguo.edit2020.viewmodel.d;
import us.pinguo.repository2020.database.staticsticker.ShopCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerManager;
/* compiled from: StickerStoreListFragment.kt */
@Instrumented
/* loaded from: classes4.dex */
public final class StickerStoreListFragment extends Fragment {
    public Map<Integer, View> a;
    private final kotlin.f b;
    private FragmentLoadingView c;

    /* compiled from: StickerStoreListFragment.kt */
    /* loaded from: classes4.dex */
    public static final class a implements TabLayout.d {
        a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(TabLayout.f fVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(TabLayout.f tab) {
            ShopCategory shopCategory;
            kotlin.jvm.internal.s.h(tab, "tab");
            int g2 = tab.g();
            List<ShopCategory> v = StaticStickerManager.a.v();
            String str = null;
            if (v != null && (shopCategory = (ShopCategory) kotlin.collections.s.D(v, g2)) != null) {
                str = shopCategory.getCid();
            }
            if (str == null) {
                return;
            }
            us.pinguo.foundation.statistics.h.b.P("sticker_package_category", str, "click");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(TabLayout.f fVar) {
        }
    }

    public StickerStoreListFragment() {
        super(R.layout.fragment_sticker_store_list);
        this.a = new LinkedHashMap();
        this.b = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(StaticStickerStoreViewModel.class), new StickerStoreListFragment$special$$inlined$activityViewModels$default$1(this), new StickerStoreListFragment$special$$inlined$activityViewModels$default$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        if (us.pinguo.edit2020.utils.d.d(this.c)) {
            FragmentLoadingView fragmentLoadingView = this.c;
            kotlin.jvm.internal.s.e(fragmentLoadingView);
            if (fragmentLoadingView.c()) {
                kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new StickerStoreListFragment$doOnError$1(this, null), 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        if (us.pinguo.edit2020.utils.d.e(this.c)) {
            Context requireContext = requireContext();
            kotlin.jvm.internal.s.g(requireContext, "requireContext()");
            this.c = new FragmentLoadingView(requireContext);
        }
        FragmentLoadingView fragmentLoadingView = this.c;
        if (fragmentLoadingView != null) {
            fragmentLoadingView.f(false);
        }
        ((FrameLayout) _$_findCachedViewById(R.id.flContainer)).addView(this.c);
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
    public final void g0(k.d<us.pinguo.edit2020.model.f.b> dVar) {
        int i2 = R.id.flContainer;
        if (((FrameLayout) _$_findCachedViewById(i2)).getChildCount() != 0) {
            ((FrameLayout) _$_findCachedViewById(i2)).removeAllViews();
        }
        Map<ShopCategory, List<StaticStickerCategory>> a2 = dVar.a().a();
        if (a2 == null || a2.isEmpty()) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ShopCategory shopCategory : a2.keySet()) {
            List<StaticStickerCategory> list = a2.get(shopCategory);
            if (!(list == null || list.isEmpty())) {
                arrayList2.add(StickerStoreFragment.f10525e.a(list));
                arrayList.add(shopCategory);
                if (shopCategory.getCid() != null) {
                    String[] pids = shopCategory.getPids();
                    if (!(pids != null && pids.length == 0)) {
                        us.pinguo.foundation.statistics.h.b.P("sticker_package_category", shopCategory.getCid(), "show");
                    }
                }
            }
        }
        int i3 = R.id.viewPager2;
        ViewPager2 viewPager2 = (ViewPager2) _$_findCachedViewById(i3);
        viewPager2.setOrientation(0);
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.s.g(childFragmentManager, "childFragmentManager");
        Lifecycle lifecycle = getLifecycle();
        kotlin.jvm.internal.s.g(lifecycle, "lifecycle");
        viewPager2.setAdapter(new us.pinguo.edit2020.adapter.s0(arrayList2, childFragmentManager, lifecycle));
        Context requireContext = requireContext();
        kotlin.jvm.internal.s.g(requireContext, "requireContext()");
        int i4 = R.color.primary_text_enable;
        int c = us.pinguo.edit2020.utils.d.c(requireContext, i4);
        int a3 = us.pinguo.common.widget.i.a.a(2);
        int a4 = us.pinguo.common.widget.i.a.a(32);
        int a5 = us.pinguo.common.widget.i.a.a(5);
        int i5 = R.drawable.bg_tab_indicator;
        int c2 = us.pinguo.edit2020.utils.d.c(requireContext, R.color.primary_gray_color);
        int c3 = us.pinguo.edit2020.utils.d.c(requireContext, i4);
        int a6 = us.pinguo.common.widget.i.a.a(10);
        int i6 = R.id.tabLayout;
        new us.pinguo.edit2020.utils.j(new us.pinguo.edit2020.utils.i(Integer.valueOf(c3), Integer.valueOf(c2), null, null, false, Integer.valueOf(a4), Integer.valueOf(a3), Integer.valueOf(c), Integer.valueOf(i5), null, Integer.valueOf(a5), null, Integer.valueOf(a6), null, null, (TabLayout) _$_findCachedViewById(i6), 27164, null));
        new com.google.android.material.tabs.c((TabLayout) _$_findCachedViewById(i6), (ViewPager2) _$_findCachedViewById(i3), new c.b() { // from class: us.pinguo.edit2020.fragment.y0
            @Override // com.google.android.material.tabs.c.b
            public final void a(TabLayout.f fVar, int i7) {
                StickerStoreListFragment.h0(arrayList, fVar, i7);
            }
        }).a();
        ((TabLayout) _$_findCachedViewById(i6)).d(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(ArrayList categoryList, TabLayout.f tab, int i2) {
        kotlin.jvm.internal.s.h(categoryList, "$categoryList");
        kotlin.jvm.internal.s.h(tab, "tab");
        tab.r(((ShopCategory) categoryList.get(i2)).getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StaticStickerStoreViewModel i0() {
        return (StaticStickerStoreViewModel) this.b.getValue();
    }

    private final void initView() {
        ((ImageView) _$_findCachedViewById(R.id.ivClose)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.fragment.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerStoreListFragment.j0(StickerStoreListFragment.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R.id.ivSetting)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.fragment.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerStoreListFragment.k0(StickerStoreListFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(StickerStoreListFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(StickerStoreListFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (us.pinguo.common.widget.tab.k.b(us.pinguo.common.widget.tab.k.a, 0, 1, null)) {
            return;
        }
        this$0.i0().v(new d.a(true));
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
        super.onResume();
        VdsAgent.onFragmentResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.s.h(view, "view");
        super.onViewCreated(view, bundle);
        i0().l();
        initView();
        kotlinx.coroutines.flow.c y = kotlinx.coroutines.flow.e.y(i0().k(), new StickerStoreListFragment$onViewCreated$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
        new FlowObserver(viewLifecycleOwner, y, new StickerStoreListFragment$onViewCreated$$inlined$observeInLifecycle$1(null));
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}
