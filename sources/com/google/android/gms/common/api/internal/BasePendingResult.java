package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.internal.base.zap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
@KeepName
/* loaded from: classes2.dex */
public abstract class BasePendingResult<R extends com.google.android.gms.common.api.g> extends com.google.android.gms.common.api.e<R> {
    static final ThreadLocal<Boolean> zadr = new x0();
    @KeepName
    private b mResultGuardian;
    private Status mStatus;
    private R zacm;
    private final Object zads;
    private final a<R> zadt;
    private final WeakReference<GoogleApiClient> zadu;
    private final CountDownLatch zadv;
    private final ArrayList<e.a> zadw;
    private com.google.android.gms.common.api.h<? super R> zadx;
    private final AtomicReference<r0> zady;
    private volatile boolean zadz;
    private boolean zaea;
    private boolean zaeb;
    private com.google.android.gms.common.internal.k zaec;
    private volatile o0<R> zaed;
    private boolean zaee;

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static class a<R extends com.google.android.gms.common.api.g> extends zap {
        public a() {
            this(Looper.getMainLooper());
        }

        public final void a(com.google.android.gms.common.api.h<? super R> hVar, R r) {
            sendMessage(obtainMessage(1, new Pair(BasePendingResult.zaa(hVar), r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 != 2) {
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i2);
                    Log.wtf("BasePendingResult", sb.toString(), new Exception());
                    return;
                }
                ((BasePendingResult) message.obj).zab(Status.RESULT_TIMEOUT);
                return;
            }
            Pair pair = (Pair) message.obj;
            com.google.android.gms.common.api.h hVar = (com.google.android.gms.common.api.h) pair.first;
            com.google.android.gms.common.api.g gVar = (com.google.android.gms.common.api.g) pair.second;
            try {
                hVar.a(gVar);
            } catch (RuntimeException e2) {
                BasePendingResult.zab(gVar);
                throw e2;
            }
        }

        public a(Looper looper) {
            super(looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public final class b {
        private b() {
        }

        protected final void finalize() throws Throwable {
            BasePendingResult.zab(BasePendingResult.this.zacm);
            super.finalize();
        }

        /* synthetic */ b(BasePendingResult basePendingResult, x0 x0Var) {
            this();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.zads = new Object();
        this.zadv = new CountDownLatch(1);
        this.zadw = new ArrayList<>();
        this.zady = new AtomicReference<>();
        this.zaee = false;
        this.zadt = new a<>(Looper.getMainLooper());
        this.zadu = new WeakReference<>(null);
    }

    private final R get() {
        R r;
        synchronized (this.zads) {
            com.google.android.gms.common.internal.q.n(!this.zadz, "Result has already been consumed.");
            com.google.android.gms.common.internal.q.n(isReady(), "Result is not ready.");
            r = this.zacm;
            this.zacm = null;
            this.zadx = null;
            this.zadz = true;
        }
        r0 andSet = this.zady.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <R extends com.google.android.gms.common.api.g> com.google.android.gms.common.api.h<R> zaa(com.google.android.gms.common.api.h<R> hVar) {
        return hVar;
    }

    @Override // com.google.android.gms.common.api.e
    public final void addStatusListener(e.a aVar) {
        com.google.android.gms.common.internal.q.b(aVar != null, "Callback cannot be null.");
        synchronized (this.zads) {
            if (isReady()) {
                aVar.a(this.mStatus);
            } else {
                this.zadw.add(aVar);
            }
        }
    }

    @Override // com.google.android.gms.common.api.e
    public final R await() {
        com.google.android.gms.common.internal.q.i("await must not be called on the UI thread");
        com.google.android.gms.common.internal.q.n(!this.zadz, "Result has already been consumed");
        com.google.android.gms.common.internal.q.n(this.zaed == null, "Cannot await if then() has been called.");
        try {
            this.zadv.await();
        } catch (InterruptedException unused) {
            zab(Status.RESULT_INTERRUPTED);
        }
        com.google.android.gms.common.internal.q.n(isReady(), "Result is not ready.");
        return get();
    }

    @Override // com.google.android.gms.common.api.e
    public void cancel() {
        synchronized (this.zads) {
            if (!this.zaea && !this.zadz) {
                com.google.android.gms.common.internal.k kVar = this.zaec;
                if (kVar != null) {
                    try {
                        kVar.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                zab(this.zacm);
                this.zaea = true;
                zaa((BasePendingResult<R>) createFailedResult(Status.RESULT_CANCELED));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public abstract R createFailedResult(Status status);

    @Override // com.google.android.gms.common.api.e
    public boolean isCanceled() {
        boolean z;
        synchronized (this.zads) {
            z = this.zaea;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zadv.getCount() == 0;
    }

    protected final void setCancelToken(com.google.android.gms.common.internal.k kVar) {
        synchronized (this.zads) {
            this.zaec = kVar;
        }
    }

    public final void setResult(R r) {
        synchronized (this.zads) {
            if (!this.zaeb && !this.zaea) {
                isReady();
                boolean z = true;
                com.google.android.gms.common.internal.q.n(!isReady(), "Results have already been set");
                if (this.zadz) {
                    z = false;
                }
                com.google.android.gms.common.internal.q.n(z, "Result has already been consumed");
                zaa((BasePendingResult<R>) r);
                return;
            }
            zab(r);
        }
    }

    @Override // com.google.android.gms.common.api.e
    public final void setResultCallback(com.google.android.gms.common.api.h<? super R> hVar) {
        synchronized (this.zads) {
            if (hVar == null) {
                this.zadx = null;
                return;
            }
            boolean z = true;
            com.google.android.gms.common.internal.q.n(!this.zadz, "Result has already been consumed.");
            if (this.zaed != null) {
                z = false;
            }
            com.google.android.gms.common.internal.q.n(z, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.zadt.a(hVar, get());
            } else {
                this.zadx = hVar;
            }
        }
    }

    @Override // com.google.android.gms.common.api.e
    public <S extends com.google.android.gms.common.api.g> com.google.android.gms.common.api.k<S> then(com.google.android.gms.common.api.j<? super R, ? extends S> jVar) {
        com.google.android.gms.common.api.k<S> b2;
        com.google.android.gms.common.internal.q.n(!this.zadz, "Result has already been consumed.");
        synchronized (this.zads) {
            com.google.android.gms.common.internal.q.n(this.zaed == null, "Cannot call then() twice.");
            com.google.android.gms.common.internal.q.n(this.zadx == null, "Cannot call then() if callbacks are set.");
            com.google.android.gms.common.internal.q.n(this.zaea ? false : true, "Cannot call then() if result was canceled.");
            this.zaee = true;
            this.zaed = new o0<>(this.zadu);
            b2 = this.zaed.b(jVar);
            if (isReady()) {
                this.zadt.a(this.zaed, get());
            } else {
                this.zadx = this.zaed;
            }
        }
        return b2;
    }

    public final void zaa(r0 r0Var) {
        this.zady.set(r0Var);
    }

    public final void zab(Status status) {
        synchronized (this.zads) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zaeb = true;
            }
        }
    }

    @Override // com.google.android.gms.common.api.e
    public final Integer zal() {
        return null;
    }

    public final boolean zar() {
        boolean isCanceled;
        synchronized (this.zads) {
            if (this.zadu.get() == null || !this.zaee) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void zas() {
        this.zaee = this.zaee || zadr.get().booleanValue();
    }

    private final void zaa(R r) {
        this.zacm = r;
        this.zaec = null;
        this.zadv.countDown();
        this.mStatus = this.zacm.getStatus();
        if (this.zaea) {
            this.zadx = null;
        } else if (this.zadx == null) {
            if (this.zacm instanceof com.google.android.gms.common.api.f) {
                this.mResultGuardian = new b(this, null);
            }
        } else {
            this.zadt.removeMessages(2);
            this.zadt.a(this.zadx, get());
        }
        ArrayList<e.a> arrayList = this.zadw;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            e.a aVar = arrayList.get(i2);
            i2++;
            aVar.a(this.mStatus);
        }
        this.zadw.clear();
    }

    public static void zab(com.google.android.gms.common.api.g gVar) {
        if (gVar instanceof com.google.android.gms.common.api.f) {
            try {
                ((com.google.android.gms.common.api.f) gVar).release();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(gVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e2);
            }
        }
    }

    @Override // com.google.android.gms.common.api.e
    public final R await(long j2, TimeUnit timeUnit) {
        if (j2 > 0) {
            com.google.android.gms.common.internal.q.i("await must not be called on the UI thread when time is greater than zero.");
        }
        com.google.android.gms.common.internal.q.n(!this.zadz, "Result has already been consumed.");
        com.google.android.gms.common.internal.q.n(this.zaed == null, "Cannot await if then() has been called.");
        try {
            if (!this.zadv.await(j2, timeUnit)) {
                zab(Status.RESULT_TIMEOUT);
            }
        } catch (InterruptedException unused) {
            zab(Status.RESULT_INTERRUPTED);
        }
        com.google.android.gms.common.internal.q.n(isReady(), "Result is not ready.");
        return get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BasePendingResult(GoogleApiClient googleApiClient) {
        this.zads = new Object();
        this.zadv = new CountDownLatch(1);
        this.zadw = new ArrayList<>();
        this.zady = new AtomicReference<>();
        this.zaee = false;
        this.zadt = new a<>(googleApiClient != null ? googleApiClient.d() : Looper.getMainLooper());
        this.zadu = new WeakReference<>(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.e
    public final void setResultCallback(com.google.android.gms.common.api.h<? super R> hVar, long j2, TimeUnit timeUnit) {
        synchronized (this.zads) {
            if (hVar == null) {
                this.zadx = null;
                return;
            }
            boolean z = true;
            com.google.android.gms.common.internal.q.n(!this.zadz, "Result has already been consumed.");
            if (this.zaed != null) {
                z = false;
            }
            com.google.android.gms.common.internal.q.n(z, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.zadt.a(hVar, get());
            } else {
                this.zadx = hVar;
                a<R> aVar = this.zadt;
                aVar.sendMessageDelayed(aVar.obtainMessage(2, this), timeUnit.toMillis(j2));
            }
        }
    }

    @Deprecated
    protected BasePendingResult(Looper looper) {
        this.zads = new Object();
        this.zadv = new CountDownLatch(1);
        this.zadw = new ArrayList<>();
        this.zady = new AtomicReference<>();
        this.zaee = false;
        this.zadt = new a<>(looper);
        this.zadu = new WeakReference<>(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BasePendingResult(@NonNull a<R> aVar) {
        this.zads = new Object();
        this.zadv = new CountDownLatch(1);
        this.zadw = new ArrayList<>();
        this.zady = new AtomicReference<>();
        this.zaee = false;
        com.google.android.gms.common.internal.q.k(aVar, "CallbackHandler must not be null");
        this.zadt = aVar;
        this.zadu = new WeakReference<>(null);
    }
}
