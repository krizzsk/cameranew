package us.pinguo.edit2020.fragment;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.internal.Lambda;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes4.dex */
public final class StickerStoreManagementFragment$special$$inlined$activityViewModels$default$1 extends Lambda implements kotlin.jvm.b.a<ViewModelStore> {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreManagementFragment$special$$inlined$activityViewModels$default$1(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
        kotlin.jvm.internal.s.g(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}
