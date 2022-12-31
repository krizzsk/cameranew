package androidx.activity;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.f;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.s;
/* compiled from: ActivityViewModelLazy.kt */
/* loaded from: classes.dex */
public final class ActivityViewModelLazyKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> f<VM> viewModels(ComponentActivity viewModels, a<? extends ViewModelProvider.Factory> aVar) {
        s.h(viewModels, "$this$viewModels");
        if (aVar == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$1(viewModels);
        }
        s.n(4, "VM");
        throw null;
    }

    public static /* synthetic */ f viewModels$default(ComponentActivity viewModels, a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = null;
        }
        s.h(viewModels, "$this$viewModels");
        if (aVar == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$1(viewModels);
        }
        s.n(4, "VM");
        throw null;
    }
}
