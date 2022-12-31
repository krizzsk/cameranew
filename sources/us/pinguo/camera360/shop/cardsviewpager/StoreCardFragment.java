package us.pinguo.camera360.shop.cardsviewpager;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.camera360.shop.data.show.ShowScene;
import us.pinguo.camera360.shop.data.show.UnlockType;
import vStudio.Android.Camera360.R;
@Instrumented
/* loaded from: classes3.dex */
public class StoreCardFragment extends Fragment {
    private j a;
    private ShowScene b;
    private RecyclerView c;

    /* renamed from: d  reason: collision with root package name */
    private GridLayoutManager f9566d;

    /* renamed from: e  reason: collision with root package name */
    private Context f9567e;

    /* renamed from: f  reason: collision with root package name */
    private View f9568f;

    /* renamed from: g  reason: collision with root package name */
    private int f9569g;

    /* loaded from: classes3.dex */
    class a extends GridLayoutManager.SpanSizeLookup {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return StoreCardFragment.this.a.getItemViewType(i2) == 1 ? 3 : 1;
        }
    }

    /* loaded from: classes3.dex */
    class b extends RecyclerView.ItemDecoration {
        private int a;
        private boolean b;

        public b(StoreCardFragment storeCardFragment, int i2, boolean z) {
            this.a = i2;
            this.b = z;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition() > (this.b ? 0 : 2)) {
                rect.top = this.a;
            }
            int i2 = this.a;
            rect.bottom = i2;
            rect.left = i2;
            rect.right = i2;
        }
    }

    public void b0(String str) {
        j jVar = this.a;
        if (jVar != null) {
            jVar.k(str);
        }
    }

    public void c0(UnlockType unlockType) {
        j jVar = this.a;
        if (jVar != null) {
            jVar.l(unlockType);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Bundle arguments = getArguments();
        this.b = (ShowScene) arguments.getSerializable("store_show");
        this.f9569g = arguments.getInt("show_pos");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        boolean z = false;
        us.pinguo.common.log.a.d("StoreCardFragment", "onCreateView", new Object[0]);
        this.f9567e = getActivity();
        View inflate = layoutInflater.inflate(R.layout.layout_store_card_fragment, viewGroup, false);
        this.f9568f = inflate;
        this.c = (RecyclerView) inflate.findViewById(R.id.store_card_rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f9567e, 3);
        this.f9566d = gridLayoutManager;
        gridLayoutManager.setSpanSizeLookup(new a());
        this.c.setLayoutManager(this.f9566d);
        this.c.setHasFixedSize(true);
        RecyclerView recyclerView = this.c;
        int dimensionPixelSize = getActivity().getResources().getDimensionPixelSize(R.dimen.store_card_item_gap);
        ShowScene showScene = this.b;
        if (showScene != null && showScene.getTopicList() != null && this.b.getTopicList().size() > 0) {
            z = true;
        }
        recyclerView.addItemDecoration(new b(this, dimensionPixelSize, z));
        j jVar = new j(this.b, getActivity(), this.f9569g);
        this.a = jVar;
        this.c.setAdapter(jVar);
        return this.f9568f;
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
