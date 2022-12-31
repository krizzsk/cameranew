package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;
/* loaded from: classes3.dex */
public final class OperatorToMap<T, K, V> implements Observable.Operator<Map<K, V>, T> {
    private final Func1<? super T, ? extends K> keySelector;
    private final Func0<? extends Map<K, V>> mapFactory;
    private final Func1<? super T, ? extends V> valueSelector;

    /* loaded from: classes3.dex */
    public static final class DefaultToMapFactory<K, V> implements Func0<Map<K, V>> {
        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public Map<K, V> call() {
            return new HashMap();
        }
    }

    public OperatorToMap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this(func1, func12, new DefaultToMapFactory());
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorToMap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, V>> func0) {
        this.keySelector = func1;
        this.valueSelector = func12;
        this.mapFactory = func0;
    }

    public Subscriber<? super T> call(final Subscriber<? super Map<K, V>> subscriber) {
        return (Subscriber<T>) new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorToMap.1
            private Map<K, V> map;

            {
                this.map = (Map) OperatorToMap.this.mapFactory.call();
            }

            @Override // rx.Observer
            public void onCompleted() {
                Map<K, V> map = this.map;
                this.map = null;
                subscriber.onNext(map);
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                this.map = null;
                subscriber.onError(th);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(T t) {
                this.map.put(OperatorToMap.this.keySelector.call(t), OperatorToMap.this.valueSelector.call(t));
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        };
    }
}
