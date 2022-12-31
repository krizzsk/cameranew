package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.o;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
/* loaded from: classes2.dex */
public class FcmBroadcastProcessor {
    @GuardedBy("lock")
    private static WithinAppServiceConnection fcmServiceConn;
    private static final Object lock = new Object();
    private final Context context;
    private final Executor executor;

    public FcmBroadcastProcessor(Context context) {
        this.context = context;
        this.executor = FcmBroadcastProcessor$$Lambda$0.$instance;
    }

    public FcmBroadcastProcessor(Context context, ExecutorService executorService) {
        this.context = context;
        this.executor = executorService;
    }

    private static g<Integer> bindToMessagingService(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        return getServiceConnection(context, ServiceStarter.ACTION_MESSAGING_EVENT).sendIntent(intent).f(FirebaseIidExecutors.directExecutor(), FcmBroadcastProcessor$$Lambda$3.$instance);
    }

    private static WithinAppServiceConnection getServiceConnection(Context context, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (lock) {
            if (fcmServiceConn == null) {
                fcmServiceConn = new WithinAppServiceConnection(context, ServiceStarter.ACTION_MESSAGING_EVENT);
            }
            withinAppServiceConnection = fcmServiceConn;
        }
        return withinAppServiceConnection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Integer lambda$bindToMessagingService$3$FcmBroadcastProcessor(g gVar) throws Exception {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ g lambda$startMessagingService$2$FcmBroadcastProcessor(Context context, Intent intent, g gVar) throws Exception {
        return (o.k() && ((Integer) gVar.j()).intValue() == 402) ? bindToMessagingService(context, intent).f(FirebaseIidExecutors.directExecutor(), FcmBroadcastProcessor$$Lambda$4.$instance) : gVar;
    }

    public static void reset() {
        synchronized (lock) {
            fcmServiceConn = null;
        }
    }

    public g<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra(Constants.MessagePayloadKeys.RAW_DATA, Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return startMessagingService(this.context, intent);
    }

    @SuppressLint({"InlinedApi"})
    public g<Integer> startMessagingService(final Context context, final Intent intent) {
        boolean z = false;
        if (o.k() && context.getApplicationInfo().targetSdkVersion >= 26) {
            z = true;
        }
        int flags = intent.getFlags() & PGImageSDK.SDK_STATUS_CREATE;
        if (z && flags == 0) {
            return bindToMessagingService(context, intent);
        }
        return j.c(this.executor, new Callable(context, intent) { // from class: com.google.firebase.iid.FcmBroadcastProcessor$$Lambda$1
            private final Context arg$1;
            private final Intent arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = context;
                this.arg$2 = intent;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                Integer valueOf;
                valueOf = Integer.valueOf(ServiceStarter.getInstance().startMessagingService(this.arg$1, this.arg$2));
                return valueOf;
            }
        }).h(this.executor, new a(context, intent) { // from class: com.google.firebase.iid.FcmBroadcastProcessor$$Lambda$2
            private final Context arg$1;
            private final Intent arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = context;
                this.arg$2 = intent;
            }

            @Override // com.google.android.gms.tasks.a
            public Object then(g gVar) {
                return FcmBroadcastProcessor.lambda$startMessagingService$2$FcmBroadcastProcessor(this.arg$1, this.arg$2, gVar);
            }
        });
    }
}
