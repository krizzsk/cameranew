package androidx.fragment.app;

import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes.dex */
final class FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1 extends Lambda implements kotlin.jvm.b.a<ViewModelProvider.Factory> {
    final /* synthetic */ Fragment $this_createViewModelLazy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(Fragment fragment) {
        super(0);
        this.$this_createViewModelLazy = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_createViewModelLazy.getDefaultViewModelProviderFactory();
        s.g(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
