package us.pinguo.edit2020.activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Lambda;
/* compiled from: ActivityViewModelLazy.kt */
/* loaded from: classes4.dex */
public final class StickerStoreActivity$special$$inlined$viewModels$default$1 extends Lambda implements kotlin.jvm.b.a<ViewModelProvider.Factory> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreActivity$special$$inlined$viewModels$default$1(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelProvider.Factory invoke() {
        return this.$this_viewModels.getDefaultViewModelProviderFactory();
    }
}
