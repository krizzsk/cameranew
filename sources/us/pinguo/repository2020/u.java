package us.pinguo.repository2020;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
/* compiled from: SafeMutableLiveData.kt */
/* loaded from: classes6.dex */
public class u<T> extends MutableLiveData<T> {
    public u() {
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner owner, Observer<? super T> observer) {
        kotlin.jvm.internal.s.h(owner, "owner");
        kotlin.jvm.internal.s.h(observer, "observer");
        removeObserver(observer);
        super.observe(owner, observer);
    }

    public u(T t) {
        super(t);
    }
}
