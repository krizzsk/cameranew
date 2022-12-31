package us.pinguo.camera360.shop.cardsviewpager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.camera360.shop.data.show.ShowScene;
import us.pinguo.camera360.shop.data.show.UnlockType;
import vStudio.Android.Camera360.R;
/* compiled from: StoreVipFragment.kt */
@Instrumented
/* loaded from: classes3.dex */
public final class StoreVipFragment extends Fragment {
    public Map<Integer, View> a = new LinkedHashMap();
    private k b;
    private ShowScene c;

    /* renamed from: d  reason: collision with root package name */
    private int f9576d;

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    public final void a0(String pkgId) {
        s.h(pkgId, "pkgId");
        k kVar = this.b;
        if (kVar == null) {
            return;
        }
        kVar.e(pkgId);
    }

    public final void b0(UnlockType unlockType) {
        s.h(unlockType, "unlockType");
        k kVar = this.b;
        if (kVar == null) {
            return;
        }
        kVar.f(unlockType);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        Serializable serializable = arguments.getSerializable("store_show");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type us.pinguo.camera360.shop.data.show.ShowScene");
        this.c = (ShowScene) serializable;
        this.f9576d = arguments.getInt("show_pos");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        s.h(inflater, "inflater");
        View view = inflater.inflate(R.layout.layout_store_card_fragment, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.store_card_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        Context requireContext = requireContext();
        s.g(requireContext, "requireContext()");
        ShowScene showScene = this.c;
        if (showScene != null) {
            k kVar = new k(requireContext, showScene, this.f9576d);
            this.b = kVar;
            recyclerView.setAdapter(kVar);
            s.g(view, "view");
            return view;
        }
        s.z("showScene");
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
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}
