package us.pinguo.inspire.lib.rx;

import rx.Subscriber;
import us.pinguo.foundation.e;
/* compiled from: Ignore.java */
/* loaded from: classes9.dex */
public class a<T> extends Subscriber<T> {
    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    @Override // rx.Observer
    public void onNext(T t) {
    }
}
