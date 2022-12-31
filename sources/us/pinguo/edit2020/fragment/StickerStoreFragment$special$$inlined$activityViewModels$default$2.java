package us.pinguo.edit2020.fragment;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Lambda;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes4.dex */
public final class StickerStoreFragment$special$$inlined$activityViewModels$default$2 extends Lambda implements kotlin.jvm.b.a<ViewModelProvider.Factory> {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreFragment$special$$inlined$activityViewModels$default$2(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
        kotlin.jvm.internal.s.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
