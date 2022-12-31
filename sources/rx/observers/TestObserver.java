package rx.observers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Notification;
import rx.Observer;
/* loaded from: classes3.dex */
public class TestObserver<T> implements Observer<T> {
    private static Observer<Object> INERT = new Observer<Object>() { // from class: rx.observers.TestObserver.1
        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
        }

        @Override // rx.Observer
        public void onNext(Object obj) {
        }
    };
    private final Observer<T> delegate;
    private final ArrayList<Notification<T>> onCompletedEvents;
    private final ArrayList<Throwable> onErrorEvents;
    private final ArrayList<T> onNextEvents;

    public TestObserver(Observer<T> observer) {
        this.onNextEvents = new ArrayList<>();
        this.onErrorEvents = new ArrayList<>();
        this.onCompletedEvents = new ArrayList<>();
        this.delegate = observer;
    }

    public void assertReceivedOnNext(List<T> list) {
        if (this.onNextEvents.size() == list.size()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                T t = list.get(i2);
                T t2 = this.onNextEvents.get(i2);
                if (t == null) {
                    if (t2 != null) {
                        throw new AssertionError("Value at index: " + i2 + " expected to be [null] but was: [" + t2 + "]");
                    }
                } else if (!t.equals(t2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Value at index: ");
                    sb.append(i2);
                    sb.append(" expected to be [");
                    sb.append(t);
                    sb.append("] (");
                    sb.append(t.getClass().getSimpleName());
                    sb.append(") but was: [");
                    sb.append(t2);
                    sb.append("] (");
                    sb.append(t2 != null ? t2.getClass().getSimpleName() : "null");
                    sb.append(")");
                    throw new AssertionError(sb.toString());
                }
            }
            return;
        }
        throw new AssertionError("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.onNextEvents.size());
    }

    public void assertTerminalEvent() {
        if (this.onErrorEvents.size() <= 1) {
            if (this.onCompletedEvents.size() <= 1) {
                if (this.onCompletedEvents.size() == 1 && this.onErrorEvents.size() == 1) {
                    throw new AssertionError("Received both an onError and onCompleted. Should be one or the other.");
                }
                if (this.onCompletedEvents.size() == 0 && this.onErrorEvents.size() == 0) {
                    throw new AssertionError("No terminal events received.");
                }
                return;
            }
            throw new AssertionError("Too many onCompleted events: " + this.onCompletedEvents.size());
        }
        throw new AssertionError("Too many onError events: " + this.onErrorEvents.size());
    }

    public List<Object> getEvents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.onNextEvents);
        arrayList.add(this.onErrorEvents);
        arrayList.add(this.onCompletedEvents);
        return Collections.unmodifiableList(arrayList);
    }

    public List<Notification<T>> getOnCompletedEvents() {
        return Collections.unmodifiableList(this.onCompletedEvents);
    }

    public List<Throwable> getOnErrorEvents() {
        return Collections.unmodifiableList(this.onErrorEvents);
    }

    public List<T> getOnNextEvents() {
        return Collections.unmodifiableList(this.onNextEvents);
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.onCompletedEvents.add(Notification.createOnCompleted());
        this.delegate.onCompleted();
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        this.onErrorEvents.add(th);
        this.delegate.onError(th);
    }

    @Override // rx.Observer
    public void onNext(T t) {
        this.onNextEvents.add(t);
        this.delegate.onNext(t);
    }

    public TestObserver() {
        this.onNextEvents = new ArrayList<>();
        this.onErrorEvents = new ArrayList<>();
        this.onCompletedEvents = new ArrayList<>();
        this.delegate = (Observer<T>) INERT;
    }
}
