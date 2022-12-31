package androidx.fragment.app;

import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt$viewModels$3 extends Lambda implements kotlin.jvm.b.a<ViewModelProvider.Factory> {
    final /* synthetic */ kotlin.jvm.b.a<ViewModelStoreOwner> $ownerProducer;
    final /* synthetic */ Fragment $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$3(kotlin.jvm.b.a<? extends ViewModelStoreOwner> aVar, Fragment fragment) {
        super(0);
        this.$ownerProducer = aVar;
        this.$this_viewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelProvider.Factory invoke() {
        ViewModelStoreOwner invoke = this.$ownerProducer.invoke();
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = invoke instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) invoke : null;
        ViewModelProvider.Factory defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory() : null;
        if (defaultViewModelProviderFactory == null) {
            defaultViewModelProviderFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
        s.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
