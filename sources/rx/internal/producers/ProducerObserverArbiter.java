package rx.internal.producers;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.List;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
/* loaded from: classes3.dex */
public final class ProducerObserverArbiter<T> implements Producer, Observer<T> {
    static final Producer NULL_PRODUCER = new Producer() { // from class: rx.internal.producers.ProducerObserverArbiter.1
        @Override // rx.Producer
        public void request(long j2) {
        }
    };
    final Subscriber<? super T> child;
    Producer currentProducer;
    boolean emitting;
    volatile boolean hasError;
    Producer missedProducer;
    long missedRequested;
    Object missedTerminal;
    List<T> queue;
    long requested;

    public ProducerObserverArbiter(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x0009, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void emitLoop() {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerObserverArbiter.emitLoop():void");
    }

    @Override // rx.Observer
    public void onCompleted() {
        synchronized (this) {
            if (this.emitting) {
                this.missedTerminal = Boolean.TRUE;
                return;
            }
            this.emitting = true;
            this.child.onCompleted();
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        boolean z;
        synchronized (this) {
            if (this.emitting) {
                this.missedTerminal = th;
                z = false;
            } else {
                this.emitting = true;
                z = true;
            }
        }
        if (z) {
            this.child.onError(th);
        } else {
            this.hasError = true;
        }
    }

    @Override // rx.Observer
    public void onNext(T t) {
        synchronized (this) {
            if (this.emitting) {
                List list = this.queue;
                if (list == null) {
                    list = new ArrayList(4);
                    this.queue = list;
                }
                list.add(t);
                return;
            }
            try {
                this.child.onNext(t);
                long j2 = this.requested;
                if (j2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    this.requested = j2 - 1;
                }
                emitLoop();
            } catch (Throwable th) {
                synchronized (this) {
                    this.emitting = false;
                    throw th;
                }
            }
        }
    }

    @Override // rx.Producer
    public void request(long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (i2 == 0) {
            return;
        }
        synchronized (this) {
            if (this.emitting) {
                this.missedRequested += j2;
                return;
            }
            this.emitting = true;
            Producer producer = this.currentProducer;
            try {
                long j3 = this.requested + j2;
                if (j3 < 0) {
                    j3 = LocationRequestCompat.PASSIVE_INTERVAL;
                }
                this.requested = j3;
                emitLoop();
                if (producer != null) {
                    producer.request(j2);
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.emitting = false;
                    throw th;
                }
            }
        }
    }

    public void setProducer(Producer producer) {
        synchronized (this) {
            if (this.emitting) {
                if (producer == null) {
                    producer = NULL_PRODUCER;
                }
                this.missedProducer = producer;
                return;
            }
            this.emitting = true;
            this.currentProducer = producer;
            long j2 = this.requested;
            try {
                emitLoop();
                if (producer == null || j2 == 0) {
                    return;
                }
                producer.request(j2);
            } catch (Throwable th) {
                synchronized (this) {
                    this.emitting = false;
                    throw th;
                }
            }
        }
    }
}
