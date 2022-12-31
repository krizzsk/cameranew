package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.f;
import kotlin.jvm.internal.s;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> f<VM> activityViewModels(Fragment fragment, kotlin.jvm.b.a<? extends ViewModelProvider.Factory> aVar) {
        s.h(fragment, "<this>");
        s.n(4, "VM");
        throw null;
    }

    public static /* synthetic */ f activityViewModels$default(Fragment fragment, kotlin.jvm.b.a aVar, int i2, Object obj) {
        int i3 = i2 & 1;
        s.h(fragment, "<this>");
        s.n(4, "VM");
        throw null;
    }

    @MainThread
    public static final <VM extends ViewModel> f<VM> createViewModelLazy(Fragment fragment, kotlin.reflect.c<VM> viewModelClass, kotlin.jvm.b.a<? extends ViewModelStore> storeProducer, kotlin.jvm.b.a<? extends ViewModelProvider.Factory> aVar) {
        s.h(fragment, "<this>");
        s.h(viewModelClass, "viewModelClass");
        s.h(storeProducer, "storeProducer");
        if (aVar == null) {
            aVar = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new ViewModelLazy(viewModelClass, storeProducer, aVar);
    }

    public static /* synthetic */ f createViewModelLazy$default(Fragment fragment, kotlin.reflect.c cVar, kotlin.jvm.b.a aVar, kotlin.jvm.b.a aVar2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            aVar2 = null;
        }
        return createViewModelLazy(fragment, cVar, aVar, aVar2);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> f<VM> viewModels(Fragment fragment, kotlin.jvm.b.a<? extends ViewModelStoreOwner> ownerProducer, kotlin.jvm.b.a<? extends ViewModelProvider.Factory> aVar) {
        s.h(fragment, "<this>");
        s.h(ownerProducer, "ownerProducer");
        s.n(4, "VM");
        throw null;
    }

    public static /* synthetic */ f viewModels$default(Fragment fragment, kotlin.jvm.b.a ownerProducer, kotlin.jvm.b.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            ownerProducer = new FragmentViewModelLazyKt$viewModels$1(fragment);
        }
        int i3 = i2 & 2;
        s.h(fragment, "<this>");
        s.h(ownerProducer, "ownerProducer");
        s.n(4, "VM");
        throw null;
    }
}
