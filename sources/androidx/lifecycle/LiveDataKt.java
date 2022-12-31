package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: LiveData.kt */
/* loaded from: classes.dex */
public final class LiveDataKt {
    @MainThread
    public static final <T> Observer<T> observe(LiveData<T> observe, LifecycleOwner owner, final l<? super T, u> onChanged) {
        s.h(observe, "$this$observe");
        s.h(owner, "owner");
        s.h(onChanged, "onChanged");
        Observer<T> observer = new Observer<T>() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                l.this.invoke(t);
            }
        };
        observe.observe(owner, observer);
        return observer;
    }
}
