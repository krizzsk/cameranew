package us.pinguo.edit2020.fragment;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.internal.Lambda;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes4.dex */
public final class EditFragment$special$$inlined$viewModels$default$2 extends Lambda implements kotlin.jvm.b.a<ViewModelStore> {
    final /* synthetic */ kotlin.jvm.b.a $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$special$$inlined$viewModels$default$2(kotlin.jvm.b.a aVar) {
        super(0);
        this.$ownerProducer = aVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
        kotlin.jvm.internal.s.g(viewModelStore, "ownerProducer().viewModelStore");
        return viewModelStore;
    }
}
