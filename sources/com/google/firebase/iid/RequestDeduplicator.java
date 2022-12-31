package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
/* loaded from: classes2.dex */
class RequestDeduplicator {
    private final Executor executor;
    @GuardedBy("this")
    private final Map<Pair<String, String>, g<InstanceIdResult>> getTokenRequests = new ArrayMap();

    /* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
    /* loaded from: classes2.dex */
    interface GetTokenRequest {
        g<InstanceIdResult> start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestDeduplicator(Executor executor) {
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized g<InstanceIdResult> getOrStartGetTokenRequest(String str, String str2, GetTokenRequest getTokenRequest) {
        final Pair pair = new Pair(str, str2);
        g<InstanceIdResult> gVar = this.getTokenRequests.get(pair);
        if (gVar != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
                sb.append("Joining ongoing request for: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            return gVar;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 24);
            sb2.append("Making new request for: ");
            sb2.append(valueOf2);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
        g h2 = getTokenRequest.start().h(this.executor, new a(this, pair) { // from class: com.google.firebase.iid.RequestDeduplicator$$Lambda$0
            private final RequestDeduplicator arg$1;
            private final Pair arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = pair;
            }

            @Override // com.google.android.gms.tasks.a
            public Object then(g gVar2) {
                this.arg$1.lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(this.arg$2, gVar2);
                return gVar2;
            }
        });
        this.getTokenRequests.put(pair, h2);
        return h2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ g lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(Pair pair, g gVar) throws Exception {
        synchronized (this) {
            this.getTokenRequests.remove(pair);
        }
        return gVar;
    }
}
