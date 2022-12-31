package us.pinguo.edit2020.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.utils.FlowObserver;
import us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel;
import us.pinguo.edit2020.viewmodel.d;
/* compiled from: StickerStoreManagementFragment.kt */
@Instrumented
/* loaded from: classes4.dex */
public final class StickerStoreManagementFragment extends Fragment {
    public Map<Integer, View> a;
    private final kotlin.f b;
    private final ArrayList<String> c;

    /* renamed from: d  reason: collision with root package name */
    private us.pinguo.edit2020.adapter.q0 f10527d;

    /* compiled from: StickerStoreManagementFragment.kt */
    /* loaded from: classes4.dex */
    public static final class a extends OnBackPressedCallback {
        a() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (!StickerStoreManagementFragment.this.c.isEmpty()) {
                StickerStoreManagementFragment.this.f0();
                return;
            }
            setEnabled(false);
            StickerStoreManagementFragment.this.requireActivity().onBackPressed();
        }
    }

    public StickerStoreManagementFragment() {
        super(R.layout.fragment_sticker_management);
        this.a = new LinkedHashMap();
        this.b = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(StaticStickerStoreViewModel.class), new StickerStoreManagementFragment$special$$inlined$activityViewModels$default$1(this), new StickerStoreManagementFragment$special$$inlined$activityViewModels$default$2(this));
        this.c = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        Intent intent = new Intent();
        intent.putExtra("s_type", "refresh");
        intent.putExtra("deleted_stickers", this.c);
        requireActivity().setResult(-1, intent);
        requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StaticStickerStoreViewModel g0() {
        return (StaticStickerStoreViewModel) this.b.getValue();
    }

    private final void h0() {
        kotlinx.coroutines.flow.c y = kotlinx.coroutines.flow.e.y(g0().q(), new StickerStoreManagementFragment$initObserver$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
        new FlowObserver(viewLifecycleOwner, y, new StickerStoreManagementFragment$initObserver$$inlined$observeInLifecycle$1(null));
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(StickerStoreManagementFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (!this$0.c.isEmpty()) {
            this$0.f0();
        } else {
            this$0.g0().v(new d.c());
        }
    }

    private final void initView() {
        ((ImageView) _$_findCachedViewById(R.id.ivClose)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.fragment.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerStoreManagementFragment.i0(StickerStoreManagementFragment.this, view);
            }
        });
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
        g0().o();
        h0();
        initView();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}
