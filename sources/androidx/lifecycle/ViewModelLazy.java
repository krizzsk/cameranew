package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.f;
import kotlin.jvm.internal.s;
import kotlin.reflect.c;
/* compiled from: ViewModelLazy.kt */
/* loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements f<VM> {
    private VM cached;
    private final kotlin.jvm.b.a<ViewModelProvider.Factory> factoryProducer;
    private final kotlin.jvm.b.a<ViewModelStore> storeProducer;
    private final c<VM> viewModelClass;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(c<VM> viewModelClass, kotlin.jvm.b.a<? extends ViewModelStore> storeProducer, kotlin.jvm.b.a<? extends ViewModelProvider.Factory> factoryProducer) {
        s.h(viewModelClass, "viewModelClass");
        s.h(storeProducer, "storeProducer");
        s.h(factoryProducer, "factoryProducer");
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
    }

    public boolean isInitialized() {
        return this.cached != null;
    }

    @Override // kotlin.f
    public VM getValue() {
        VM vm = this.cached;
        if (vm == null) {
            VM vm2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke()).get(kotlin.jvm.a.a(this.viewModelClass));
            this.cached = vm2;
            return vm2;
        }
        return vm;
    }
}
