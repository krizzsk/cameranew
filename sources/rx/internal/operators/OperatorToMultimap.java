package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;
/* loaded from: classes3.dex */
public final class OperatorToMultimap<T, K, V> implements Observable.Operator<Map<K, Collection<V>>, T> {
    private final Func1<? super K, ? extends Collection<V>> collectionFactory;
    private final Func1<? super T, ? extends K> keySelector;
    private final Func0<? extends Map<K, Collection<V>>> mapFactory;
    private final Func1<? super T, ? extends V> valueSelector;

    /* loaded from: classes3.dex */
    public static final class DefaultMultimapCollectionFactory<K, V> implements Func1<K, Collection<V>> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((DefaultMultimapCollectionFactory<K, V>) obj);
        }

        @Override // rx.functions.Func1
        public Collection<V> call(K k2) {
            return new ArrayList();
        }
    }

    /* loaded from: classes3.dex */
    public static final class DefaultToMultimapFactory<K, V> implements Func0<Map<K, Collection<V>>> {
        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public Map<K, Collection<V>> call() {
            return new HashMap();
        }
    }

    public OperatorToMultimap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this(func1, func12, new DefaultToMultimapFactory(), new DefaultMultimapCollectionFactory());
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorToMultimap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0) {
        this(func1, func12, func0, new DefaultMultimapCollectionFactory());
    }

    public Subscriber<? super T> call(final Subscriber<? super Map<K, Collection<V>>> subscriber) {
        return (Subscriber<T>) new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorToMultimap.1
            private Map<K, Collection<V>> map;

            {
                this.map = (Map) OperatorToMultimap.this.mapFactory.call();
            }

            @Override // rx.Observer
            public void onCompleted() {
                Map<K, Collection<V>> map = this.map;
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
            /* JADX WARN: Type inference failed for: r1v5, types: [java.util.Collection] */
            /* JADX WARN: Type inference failed for: r1v7, types: [rx.functions.Func1] */
            /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Map, java.util.Map<K, java.util.Collection<V>>] */
            @Override // rx.Observer
            public void onNext(T t) {
                Object call = OperatorToMultimap.this.keySelector.call(t);
                Object call2 = OperatorToMultimap.this.valueSelector.call(t);
                Collection<V> collection = this.map.get(call);
                if (collection == null) {
                    collection = (Collection) OperatorToMultimap.this.collectionFactory.call(call);
                    this.map.put(call, collection);
                }
                collection.add(call2);
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        };
    }

    public OperatorToMultimap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0, Func1<? super K, ? extends Collection<V>> func13) {
        this.keySelector = func1;
        this.valueSelector = func12;
        this.mapFactory = func0;
        this.collectionFactory = func13;
    }
}
