package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
/* loaded from: classes3.dex */
public final class BlockingOperatorNext {

    /* loaded from: classes3.dex */
    static final class NextIterator<T> implements Iterator<T> {
        private Throwable error;
        private boolean hasNext;
        private boolean isNextConsumed;
        private final Observable<? extends T> items;
        private T next;
        private final NextObserver<T> observer;
        private boolean started;

        private boolean moveToNext() {
            try {
                if (!this.started) {
                    this.started = true;
                    this.observer.setWaiting(1);
                    this.items.materialize().subscribe((Subscriber<? super Notification<? extends T>>) this.observer);
                }
                Notification<? extends T> takeNext = this.observer.takeNext();
                if (takeNext.isOnNext()) {
                    this.isNextConsumed = false;
                    this.next = takeNext.getValue();
                    return true;
                }
                this.hasNext = false;
                if (takeNext.isOnCompleted()) {
                    return false;
                }
                if (takeNext.isOnError()) {
                    Throwable throwable = takeNext.getThrowable();
                    this.error = throwable;
                    throw Exceptions.propagate(throwable);
                }
                throw new IllegalStateException("Should not reach here");
            } catch (InterruptedException e2) {
                this.observer.unsubscribe();
                Thread.currentThread().interrupt();
                this.error = e2;
                throw Exceptions.propagate(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.error;
            if (th == null) {
                if (this.hasNext) {
                    if (this.isNextConsumed) {
                        return moveToNext();
                    }
                    return true;
                }
                return false;
            }
            throw Exceptions.propagate(th);
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.error;
            if (th == null) {
                if (hasNext()) {
                    this.isNextConsumed = true;
                    return this.next;
                }
                throw new NoSuchElementException("No more elements");
            }
            throw Exceptions.propagate(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }

        private NextIterator(Observable<? extends T> observable, NextObserver<T> nextObserver) {
            this.hasNext = true;
            this.isNextConsumed = true;
            this.error = null;
            this.started = false;
            this.items = observable;
            this.observer = nextObserver;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class NextObserver<T> extends Subscriber<Notification<? extends T>> {
        private final BlockingQueue<Notification<? extends T>> buf;
        final AtomicInteger waiting;

        private NextObserver() {
            this.buf = new ArrayBlockingQueue(1);
            this.waiting = new AtomicInteger();
        }

        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
        }

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Notification) ((Notification) obj));
        }

        void setWaiting(int i2) {
            this.waiting.set(i2);
        }

        public Notification<? extends T> takeNext() throws InterruptedException {
            setWaiting(1);
            return this.buf.take();
        }

        public void onNext(Notification<? extends T> notification) {
            if (this.waiting.getAndSet(0) == 1 || !notification.isOnNext()) {
                while (!this.buf.offer(notification)) {
                    Notification<? extends T> poll = this.buf.poll();
                    if (poll != null && !poll.isOnNext()) {
                        notification = poll;
                    }
                }
            }
        }
    }

    private BlockingOperatorNext() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> next(final Observable<? extends T> observable) {
        return new Iterable<T>() { // from class: rx.internal.operators.BlockingOperatorNext.1
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return new NextIterator(Observable.this, new NextObserver());
            }
        };
    }
}
