package com.android.pgvolley.toolbox;

import com.android.pgvolley.Request;
import com.android.pgvolley.Response;
import com.android.pgvolley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public class RequestFuture<T> implements Future<T>, Response.Listener<T>, Response.ErrorListener {
    private VolleyError mException;
    private Request<?> mRequest;
    private T mResult;
    private boolean mResultReceived = false;

    private RequestFuture() {
    }

    private synchronized T doGet(Long l2) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.mException == null) {
            if (this.mResultReceived) {
                return this.mResult;
            }
            if (l2 == null) {
                wait(0L);
            } else if (l2.longValue() > 0) {
                wait(l2.longValue());
            }
            if (this.mException == null) {
                if (this.mResultReceived) {
                    return this.mResult;
                }
                throw new TimeoutException();
            }
            throw new ExecutionException(this.mException);
        }
        throw new ExecutionException(this.mException);
    }

    public static <E> RequestFuture<E> newFuture() {
        return new RequestFuture<>();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.mRequest == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.mRequest.cancel();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        try {
            return doGet(null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Request<?> request = this.mRequest;
        if (request == null) {
            return false;
        }
        return request.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.mResultReceived && this.mException == null) {
            z = isCancelled();
        }
        return z;
    }

    @Override // com.android.pgvolley.Response.ErrorListener
    public synchronized void onErrorResponse(VolleyError volleyError) {
        this.mException = volleyError;
        notifyAll();
    }

    @Override // com.android.pgvolley.Response.Listener
    public synchronized void onResponse(T t) {
        this.mResultReceived = true;
        this.mResult = t;
        notifyAll();
    }

    public void setRequest(Request<?> request) {
        this.mRequest = request;
    }

    @Override // java.util.concurrent.Future
    public T get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(j2, timeUnit)));
    }
}
