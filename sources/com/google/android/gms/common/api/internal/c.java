package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.BasePendingResult;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class c<R extends com.google.android.gms.common.api.g, A extends a.b> extends BasePendingResult<R> implements d<R> {
    private final com.google.android.gms.common.api.a<?> mApi;
    private final a.c<A> mClientKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated
    protected c(@NonNull a.c<A> cVar, @NonNull GoogleApiClient googleApiClient) {
        super(googleApiClient);
        com.google.android.gms.common.internal.q.k(googleApiClient, "GoogleApiClient must not be null");
        com.google.android.gms.common.internal.q.j(cVar);
        this.mClientKey = cVar;
        this.mApi = null;
    }

    protected abstract void doExecute(@NonNull A a) throws RemoteException;

    public final com.google.android.gms.common.api.a<?> getApi() {
        return this.mApi;
    }

    public final a.c<A> getClientKey() {
        return this.mClientKey;
    }

    protected void onSetFailedResult(@NonNull R r) {
    }

    public final void run(@NonNull A a) throws DeadObjectException {
        if (a instanceof com.google.android.gms.common.internal.s) {
            a = ((com.google.android.gms.common.internal.s) a).c();
        }
        try {
            doExecute(a);
        } catch (DeadObjectException e2) {
            setFailedResult(e2);
            throw e2;
        } catch (RemoteException e3) {
            setFailedResult(e3);
        }
    }

    public final void setFailedResult(@NonNull Status status) {
        com.google.android.gms.common.internal.q.b(!status.U(), "Failed result must not be success");
        R createFailedResult = createFailedResult(status);
        setResult((c<R, A>) createFailedResult);
        onSetFailedResult(createFailedResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.d
    public /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((c<R, A>) ((com.google.android.gms.common.api.g) obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull com.google.android.gms.common.api.a<?> aVar, @NonNull GoogleApiClient googleApiClient) {
        super(googleApiClient);
        com.google.android.gms.common.internal.q.k(googleApiClient, "GoogleApiClient must not be null");
        com.google.android.gms.common.internal.q.k(aVar, "Api must not be null");
        this.mClientKey = (a.c<A>) aVar.a();
        this.mApi = aVar;
    }

    private void setFailedResult(@NonNull RemoteException remoteException) {
        setFailedResult(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    @VisibleForTesting
    protected c(@NonNull BasePendingResult.a<R> aVar) {
        super(aVar);
        this.mClientKey = null;
        this.mApi = null;
    }
}
