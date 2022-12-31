package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt$activityViewModels$1 extends Lambda implements kotlin.jvm.b.a<ViewModelStore> {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$1(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
        s.g(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}
