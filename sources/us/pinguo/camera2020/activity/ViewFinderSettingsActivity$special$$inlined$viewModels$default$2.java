package us.pinguo.camera2020.activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.internal.Lambda;
/* compiled from: ActivityViewModelLazy.kt */
/* loaded from: classes2.dex */
public final class ViewFinderSettingsActivity$special$$inlined$viewModels$default$2 extends Lambda implements kotlin.jvm.b.a<ViewModelStore> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderSettingsActivity$special$$inlined$viewModels$default$2(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
        kotlin.jvm.internal.s.g(viewModelStore, "viewModelStore");
        return viewModelStore;
    }
}
