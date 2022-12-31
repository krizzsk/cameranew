package us.pinguo.edit2020.fragment;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Lambda;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes4.dex */
public final class AIEditFragment$special$$inlined$viewModels$default$3 extends Lambda implements kotlin.jvm.b.a<ViewModelProvider.Factory> {
    final /* synthetic */ kotlin.jvm.b.a $ownerProducer;
    final /* synthetic */ Fragment $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEditFragment$special$$inlined$viewModels$default$3(kotlin.jvm.b.a aVar, Fragment fragment) {
        super(0);
        this.$ownerProducer = aVar;
        this.$this_viewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelProvider.Factory invoke() {
        Object invoke = this.$ownerProducer.invoke();
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = invoke instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) invoke : null;
        ViewModelProvider.Factory defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory() : null;
        if (defaultViewModelProviderFactory == null) {
            defaultViewModelProviderFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
        kotlin.jvm.internal.s.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
