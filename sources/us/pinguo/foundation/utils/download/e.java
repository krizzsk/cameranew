package us.pinguo.foundation.utils.download;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;
/* compiled from: RetryWithDelay.java */
/* loaded from: classes4.dex */
public class e implements Func1<Observable<? extends Throwable>, Observable<?>> {
    private final int a;
    private final int b;
    private int c;

    public e(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ Observable c(Throwable th) {
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 <= this.a) {
            return Observable.timer(this.b, TimeUnit.MILLISECONDS);
        }
        return Observable.error(th);
    }

    @Override // rx.functions.Func1
    /* renamed from: a */
    public Observable<?> call(Observable<? extends Throwable> observable) {
        return observable.flatMap(new Func1() { // from class: us.pinguo.foundation.utils.download.b
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return e.this.c((Throwable) obj);
            }
        });
    }
}
