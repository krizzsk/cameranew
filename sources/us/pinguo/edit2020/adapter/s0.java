package us.pinguo.edit2020.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;
import us.pinguo.edit2020.fragment.StickerStoreFragment;
/* compiled from: StickerStoreViewPagerAdapter.kt */
/* loaded from: classes4.dex */
public final class s0 extends FragmentStateAdapter {
    private final List<StickerStoreFragment> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(List<StickerStoreFragment> fragmentLists, FragmentManager fm, Lifecycle lifecycle) {
        super(fm, lifecycle);
        kotlin.jvm.internal.s.h(fragmentLists, "fragmentLists");
        kotlin.jvm.internal.s.h(fm, "fm");
        kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
        this.a = fragmentLists;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i2) {
        return this.a.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }
}
