package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
/* loaded from: classes3.dex */
public final class OperatorBufferWithSize<T> implements Observable.Operator<List<T>, T> {
    final int count;
    final int skip;

    public OperatorBufferWithSize(int i2, int i3) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("count must be greater than 0");
        }
        if (i3 > 0) {
            this.count = i2;
            this.skip = i3;
            return;
        }
        throw new IllegalArgumentException("skip must be greater than 0");
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(final Subscriber<? super List<T>> subscriber) {
        if (this.count == this.skip) {
            return (Subscriber<T>) new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorBufferWithSize.1
                List<T> buffer;

                @Override // rx.Observer
                public void onCompleted() {
                    List<T> list = this.buffer;
                    this.buffer = null;
                    if (list != null) {
                        try {
                            subscriber.onNext(list);
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, this);
                            return;
                        }
                    }
                    subscriber.onCompleted();
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    this.buffer = null;
                    subscriber.onError(th);
                }

                @Override // rx.Observer
                public void onNext(T t) {
                    if (this.buffer == null) {
                        this.buffer = new ArrayList(OperatorBufferWithSize.this.count);
                    }
                    this.buffer.add(t);
                    if (this.buffer.size() == OperatorBufferWithSize.this.count) {
                        List<T> list = this.buffer;
                        this.buffer = null;
                        subscriber.onNext(list);
                    }
                }

                @Override // rx.Subscriber
                public void setProducer(final Producer producer) {
                    subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorBufferWithSize.1.1
                        private volatile boolean infinite = false;

                        @Override // rx.Producer
                        public void request(long j2) {
                            if (this.infinite) {
                                return;
                            }
                            int i2 = OperatorBufferWithSize.this.count;
                            if (j2 >= LocationRequestCompat.PASSIVE_INTERVAL / i2) {
                                this.infinite = true;
                                producer.request(LocationRequestCompat.PASSIVE_INTERVAL);
                                return;
                            }
                            producer.request(j2 * i2);
                        }
                    });
                }
            };
        }
        return (Subscriber<T>) new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorBufferWithSize.2
            final List<List<T>> chunks = new LinkedList();
            int index;

            @Override // rx.Observer
            public void onCompleted() {
                try {
                    for (List<T> list : this.chunks) {
                        subscriber.onNext(list);
                    }
                    subscriber.onCompleted();
                } finally {
                    this.chunks.clear();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                this.chunks.clear();
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                int i2 = this.index;
                this.index = i2 + 1;
                if (i2 % OperatorBufferWithSize.this.skip == 0) {
                    this.chunks.add(new ArrayList(OperatorBufferWithSize.this.count));
                }
                Iterator<List<T>> it = this.chunks.iterator();
                while (it.hasNext()) {
                    List<T> next = it.next();
                    next.add(t);
                    if (next.size() == OperatorBufferWithSize.this.count) {
                        it.remove();
                        subscriber.onNext(next);
                    }
                }
            }

            @Override // rx.Subscriber
            public void setProducer(final Producer producer) {
                subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorBufferWithSize.2.1
                    private volatile boolean firstRequest = true;
                    private volatile boolean infinite = false;

                    private void requestInfinite() {
                        this.infinite = true;
                        producer.request(LocationRequestCompat.PASSIVE_INTERVAL);
                    }

                    @Override // rx.Producer
                    public void request(long j2) {
                        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                        if (i2 == 0) {
                            return;
                        }
                        if (i2 >= 0) {
                            if (this.infinite) {
                                return;
                            }
                            if (j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
                                requestInfinite();
                                return;
                            } else if (this.firstRequest) {
                                this.firstRequest = false;
                                long j3 = j2 - 1;
                                OperatorBufferWithSize operatorBufferWithSize = OperatorBufferWithSize.this;
                                int i3 = operatorBufferWithSize.count;
                                long j4 = LocationRequestCompat.PASSIVE_INTERVAL - i3;
                                int i4 = operatorBufferWithSize.skip;
                                if (j3 >= j4 / i4) {
                                    requestInfinite();
                                    return;
                                } else {
                                    producer.request(i3 + (i4 * j3));
                                    return;
                                }
                            } else {
                                int i5 = OperatorBufferWithSize.this.skip;
                                if (j2 >= LocationRequestCompat.PASSIVE_INTERVAL / i5) {
                                    requestInfinite();
                                    return;
                                } else {
                                    producer.request(i5 * j2);
                                    return;
                                }
                            }
                        }
                        throw new IllegalArgumentException("request a negative number: " + j2);
                    }
                });
            }
        };
    }
}
