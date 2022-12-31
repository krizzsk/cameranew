package us.pinguo.edit2020.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategoryTable;
/* compiled from: StickerStoreFragment.kt */
@Instrumented
/* loaded from: classes4.dex */
public final class StickerStoreFragment extends Fragment {

    /* renamed from: e  reason: collision with root package name */
    public static final a f10525e = new a(null);
    public Map<Integer, View> a = new LinkedHashMap();
    private RecyclerView b;
    private final kotlin.f c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.f f10526d;

    /* compiled from: StickerStoreFragment.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final StickerStoreFragment a(List<StaticStickerCategory> list) {
            kotlin.jvm.internal.s.h(list, "list");
            StickerStoreFragment stickerStoreFragment = new StickerStoreFragment();
            stickerStoreFragment.setArguments(BundleKt.bundleOf(new Pair("store_data", list)));
            return stickerStoreFragment;
        }
    }

    /* compiled from: StickerStoreFragment.kt */
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            kotlin.jvm.internal.s.h(recyclerView, "recyclerView");
            if (i2 == 0) {
                StickerStoreFragment.this.d0(recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            kotlin.jvm.internal.s.h(recyclerView, "recyclerView");
            if (i2 == 0 && i3 == 0) {
                StickerStoreFragment.this.d0(recyclerView);
            }
        }
    }

    public StickerStoreFragment() {
        kotlin.f b2;
        b2 = kotlin.h.b(StickerStoreFragment$stickerAdapter$2.INSTANCE);
        this.c = b2;
        this.f10526d = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(StaticStickerStoreViewModel.class), new StickerStoreFragment$special$$inlined$activityViewModels$default$1(this), new StickerStoreFragment$special$$inlined$activityViewModels$default$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(RecyclerView recyclerView) {
        List<StaticStickerCategory> e2 = e0().e();
        if (e2 == null || e2.isEmpty()) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager == null) {
            return;
        }
        Iterator<Integer> it = new kotlin.z.d(gridLayoutManager.findFirstVisibleItemPosition(), gridLayoutManager.findLastVisibleItemPosition()).iterator();
        while (it.hasNext()) {
            StaticStickerCategory staticStickerCategory = (StaticStickerCategory) kotlin.collections.s.D(e2, ((kotlin.collections.h0) it).nextInt());
            String pid = staticStickerCategory == null ? null : staticStickerCategory.getPid();
            if (pid == null) {
                return;
            }
            us.pinguo.foundation.statistics.h.b.P("sticker_package", pid, "show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final us.pinguo.edit2020.adapter.r0 e0() {
        return (us.pinguo.edit2020.adapter.r0) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StaticStickerStoreViewModel f0() {
        return (StaticStickerStoreViewModel) this.f10526d.getValue();
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        Context requireContext = requireContext();
        kotlin.jvm.internal.s.g(requireContext, "requireContext()");
        FrameLayout frameLayout = new FrameLayout(requireContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMarginStart(us.pinguo.common.widget.i.a.a(6));
        layoutParams.setMarginEnd(us.pinguo.common.widget.i.a.a(6));
        RecyclerView recyclerView = new RecyclerView(requireContext);
        this.b = recyclerView;
        if (recyclerView != null) {
            frameLayout.addView(recyclerView, layoutParams);
            return frameLayout;
        }
        kotlin.jvm.internal.s.z("stickerList");
        throw null;
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
        Map<String, StaticStickerCategoryTable> p = f0().p();
        Bundle arguments = getArguments();
        Serializable serializable = arguments == null ? null : arguments.getSerializable("store_data");
        List<StaticStickerCategory> list = serializable instanceof List ? (List) serializable : null;
        if (list == null) {
            list = kotlin.collections.u.h();
        }
        e0().k(list);
        e0().l(p);
        e0().m(new StickerStoreFragment$onViewCreated$1(this));
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
            recyclerView.setAdapter(e0());
            us.pinguo.edit2020.utils.e eVar = new us.pinguo.edit2020.utils.e(us.pinguo.common.widget.i.a.a(10), true);
            eVar.a(0);
            recyclerView.addItemDecoration(eVar);
            kotlinx.coroutines.flow.e.w(kotlinx.coroutines.flow.e.y(f0().r(), new StickerStoreFragment$onViewCreated$3(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
            RecyclerView recyclerView2 = this.b;
            if (recyclerView2 != null) {
                recyclerView2.addOnScrollListener(new b());
                return;
            } else {
                kotlin.jvm.internal.s.z("stickerList");
                throw null;
            }
        }
        kotlin.jvm.internal.s.z("stickerList");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}
