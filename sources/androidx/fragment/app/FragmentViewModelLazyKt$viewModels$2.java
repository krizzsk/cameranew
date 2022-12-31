package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt$viewModels$2 extends Lambda implements kotlin.jvm.b.a<ViewModelStore> {
    final /* synthetic */ kotlin.jvm.b.a<ViewModelStoreOwner> $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$2(kotlin.jvm.b.a<? extends ViewModelStoreOwner> aVar) {
        super(0);
        this.$ownerProducer = aVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = this.$ownerProducer.invoke().getViewModelStore();
        s.g(viewModelStore, "ownerProducer().viewModelStore");
        return viewModelStore;
    }
}
