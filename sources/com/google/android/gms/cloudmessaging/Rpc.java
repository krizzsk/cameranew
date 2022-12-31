package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.cloudmessaging.zza;
import com.google.firebase.iid.GmsRpc;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public class Rpc {

    /* renamed from: h  reason: collision with root package name */
    private static int f3575h;

    /* renamed from: i  reason: collision with root package name */
    private static PendingIntent f3576i;

    /* renamed from: j  reason: collision with root package name */
    private static final Executor f3577j = y.a;
    private final Context b;
    private final zzr c;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledExecutorService f3578d;

    /* renamed from: f  reason: collision with root package name */
    private Messenger f3580f;

    /* renamed from: g  reason: collision with root package name */
    private zza f3581g;
    @GuardedBy("responseCallbacks")
    private final SimpleArrayMap<String, com.google.android.gms.tasks.h<Bundle>> a = new SimpleArrayMap<>();

    /* renamed from: e  reason: collision with root package name */
    private Messenger f3579e = new Messenger(new x(this, Looper.getMainLooper()));

    public Rpc(@NonNull Context context) {
        this.b = context;
        this.c = new zzr(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f3578d = scheduledThreadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Bundle b(com.google.android.gms.tasks.g gVar) throws Exception {
        if (gVar.n()) {
            return (Bundle) gVar.j();
        }
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(gVar.i());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
            sb.append("Error making request: ");
            sb.append(valueOf);
            Log.d("Rpc", sb.toString());
        }
        throw new IOException(GmsRpc.ERROR_SERVICE_NOT_AVAILABLE, gVar.i());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ com.google.android.gms.tasks.g c(Bundle bundle) throws Exception {
        if (l(bundle)) {
            return com.google.android.gms.tasks.j.e(null);
        }
        return com.google.android.gms.tasks.j.e(bundle);
    }

    private static synchronized String e() {
        String num;
        synchronized (Rpc.class) {
            int i2 = f3575h;
            f3575h = i2 + 1;
            num = Integer.toString(i2);
        }
        return num;
    }

    private static synchronized void f(Context context, Intent intent) {
        synchronized (Rpc.class) {
            if (f3576i == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                VdsAgent.onPendingIntentGetBroadcastBefore(context, 0, intent2, 0);
                PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent2, 0);
                VdsAgent.onPendingIntentGetBroadcastAfter(context, 0, intent2, 0, broadcast);
                f3576i = broadcast;
            }
            intent.putExtra("app", f3576i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zza.a());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zza) {
                        this.f3581g = (zza) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f3580f = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("Rpc", 3)) {
                        String valueOf = String.valueOf(action);
                        Log.d("Rpc", valueOf.length() != 0 ? "Unexpected response action: ".concat(valueOf) : new String("Unexpected response action: "));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    String stringExtra2 = intent2.getStringExtra("error");
                    if (stringExtra2 == null) {
                        String valueOf2 = String.valueOf(intent2.getExtras());
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 49);
                        sb.append("Unexpected response, no error or registration id ");
                        sb.append(valueOf2);
                        Log.w("Rpc", sb.toString());
                        return;
                    }
                    if (Log.isLoggable("Rpc", 3)) {
                        String valueOf3 = String.valueOf(stringExtra2);
                        Log.d("Rpc", valueOf3.length() != 0 ? "Received InstanceID error ".concat(valueOf3) : new String("Received InstanceID error "));
                    }
                    if (stringExtra2.startsWith(Effect.DIVIDER)) {
                        String[] split = stringExtra2.split("\\|");
                        if (split.length > 2 && "ID".equals(split[1])) {
                            String str = split[2];
                            String str2 = split[3];
                            if (str2.startsWith(":")) {
                                str2 = str2.substring(1);
                            }
                            j(str, intent2.putExtra("error", str2).getExtras());
                            return;
                        }
                        String valueOf4 = String.valueOf(stringExtra2);
                        Log.w("Rpc", valueOf4.length() != 0 ? "Unexpected structured response ".concat(valueOf4) : new String("Unexpected structured response "));
                        return;
                    }
                    synchronized (this.a) {
                        for (int i2 = 0; i2 < this.a.size(); i2++) {
                            j(this.a.keyAt(i2), intent2.getExtras());
                        }
                    }
                    return;
                }
                Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                if (!matcher.matches()) {
                    if (Log.isLoggable("Rpc", 3)) {
                        String valueOf5 = String.valueOf(stringExtra);
                        Log.d("Rpc", valueOf5.length() != 0 ? "Unexpected response string: ".concat(valueOf5) : new String("Unexpected response string: "));
                        return;
                    }
                    return;
                }
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                if (group != null) {
                    Bundle extras = intent2.getExtras();
                    extras.putString("registration_id", group2);
                    j(group, extras);
                    return;
                }
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void i(com.google.android.gms.tasks.h hVar) {
        if (hVar.d(new IOException("TIMEOUT"))) {
            Log.w("Rpc", "No response");
        }
    }

    private final void j(String str, @Nullable Bundle bundle) {
        synchronized (this.a) {
            com.google.android.gms.tasks.h<Bundle> remove = this.a.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("Rpc", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                return;
            }
            remove.c(bundle);
        }
    }

    private static boolean l(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    @AnyThread
    private final com.google.android.gms.tasks.g<Bundle> m(Bundle bundle) {
        final String e2 = e();
        final com.google.android.gms.tasks.h<Bundle> hVar = new com.google.android.gms.tasks.h<>();
        synchronized (this.a) {
            this.a.put(e2, hVar);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.c.a() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        f(this.b, intent);
        StringBuilder sb = new StringBuilder(String.valueOf(e2).length() + 5);
        sb.append("|ID|");
        sb.append(e2);
        sb.append(Effect.DIVIDER);
        intent.putExtra("kid", sb.toString());
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 8);
            sb2.append("Sending ");
            sb2.append(valueOf);
            Log.d("Rpc", sb2.toString());
        }
        intent.putExtra("google.messenger", this.f3579e);
        if (this.f3580f != null || this.f3581g != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.f3580f;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    this.f3581g.b(obtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
            final ScheduledFuture<?> schedule = this.f3578d.schedule(new Runnable(hVar) { // from class: com.google.android.gms.cloudmessaging.t
                private final com.google.android.gms.tasks.h a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = hVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Rpc.i(this.a);
                }
            }, 30L, TimeUnit.SECONDS);
            hVar.a().b(f3577j, new com.google.android.gms.tasks.c(this, e2, schedule) { // from class: com.google.android.gms.cloudmessaging.w
                private final Rpc a;
                private final String b;
                private final ScheduledFuture c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.b = e2;
                    this.c = schedule;
                }

                @Override // com.google.android.gms.tasks.c
                public final void onComplete(com.google.android.gms.tasks.g gVar) {
                    this.a.k(this.b, this.c, gVar);
                }
            });
            return hVar.a();
        }
        if (this.c.a() == 2) {
            this.b.sendBroadcast(intent);
        } else {
            this.b.startService(intent);
        }
        final ScheduledFuture schedule2 = this.f3578d.schedule(new Runnable(hVar) { // from class: com.google.android.gms.cloudmessaging.t
            private final com.google.android.gms.tasks.h a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = hVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Rpc.i(this.a);
            }
        }, 30L, TimeUnit.SECONDS);
        hVar.a().b(f3577j, new com.google.android.gms.tasks.c(this, e2, schedule2) { // from class: com.google.android.gms.cloudmessaging.w
            private final Rpc a;
            private final String b;
            private final ScheduledFuture c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = e2;
                this.c = schedule2;
            }

            @Override // com.google.android.gms.tasks.c
            public final void onComplete(com.google.android.gms.tasks.g gVar) {
                this.a.k(this.b, this.c, gVar);
            }
        });
        return hVar.a();
    }

    @NonNull
    public com.google.android.gms.tasks.g<Bundle> a(@NonNull final Bundle bundle) {
        if (this.c.c() >= 12000000) {
            return e.c(this.b).f(1, bundle).f(f3577j, s.a);
        }
        if (!(this.c.a() != 0)) {
            return com.google.android.gms.tasks.j.d(new IOException("MISSING_INSTANCEID_SERVICE"));
        }
        return m(bundle).h(f3577j, new com.google.android.gms.tasks.a(this, bundle) { // from class: com.google.android.gms.cloudmessaging.u
            private final Rpc a;
            private final Bundle b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = bundle;
            }

            @Override // com.google.android.gms.tasks.a
            public final Object then(com.google.android.gms.tasks.g gVar) {
                return this.a.d(this.b, gVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ com.google.android.gms.tasks.g d(Bundle bundle, com.google.android.gms.tasks.g gVar) throws Exception {
        return (gVar.n() && l((Bundle) gVar.j())) ? m(bundle).p(f3577j, v.a) : gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void k(String str, ScheduledFuture scheduledFuture, com.google.android.gms.tasks.g gVar) {
        synchronized (this.a) {
            this.a.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
