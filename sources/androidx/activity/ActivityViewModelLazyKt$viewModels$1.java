package androidx.activity;

import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* compiled from: ActivityViewModelLazy.kt */
/* loaded from: classes.dex */
public final class ActivityViewModelLazyKt$viewModels$1 extends Lambda implements a<ViewModelStore> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$1(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
        s.g(viewModelStore, "viewModelStore");
        return viewModelStore;
    }
}
