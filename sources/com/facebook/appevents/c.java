package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.adjust.sdk.Constants;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventQueue.java */
/* loaded from: classes.dex */
public class c {
    private static final String a = "com.facebook.appevents.c";

    /* renamed from: e  reason: collision with root package name */
    private static ScheduledFuture f2262e;
    private static final Integer b = 100;
    private static volatile com.facebook.appevents.b c = new com.facebook.appevents.b();

    /* renamed from: d  reason: collision with root package name */
    private static final ScheduledExecutorService f2261d = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: f  reason: collision with root package name */
    private static final Runnable f2263f = new a();

    /* compiled from: AppEventQueue.java */
    /* loaded from: classes.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                c.b(null);
                if (AppEventsLogger.d() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                    c.l(FlushReason.TIMER);
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppEventQueue.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                com.facebook.appevents.d.b(c.c());
                c.d(new com.facebook.appevents.b());
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppEventQueue.java */
    /* renamed from: com.facebook.appevents.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0070c implements Runnable {
        final /* synthetic */ FlushReason a;

        RunnableC0070c(FlushReason flushReason) {
            this.a = flushReason;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                c.l(this.a);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppEventQueue.java */
    /* loaded from: classes.dex */
    public static class d implements Runnable {
        final /* synthetic */ AccessTokenAppIdPair a;
        final /* synthetic */ AppEvent b;

        d(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
            this.a = accessTokenAppIdPair;
            this.b = appEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                c.c().a(this.a, this.b);
                if (AppEventsLogger.d() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY && c.c().d() > c.e().intValue()) {
                    c.l(FlushReason.EVENT_THRESHOLD);
                } else if (c.a() == null) {
                    c.b(c.g().schedule(c.f(), 15L, TimeUnit.SECONDS));
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppEventQueue.java */
    /* loaded from: classes.dex */
    public static class e implements GraphRequest.e {
        final /* synthetic */ AccessTokenAppIdPair a;
        final /* synthetic */ GraphRequest b;
        final /* synthetic */ h c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ g f2264d;

        e(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, h hVar, g gVar) {
            this.a = accessTokenAppIdPair;
            this.b = graphRequest;
            this.c = hVar;
            this.f2264d = gVar;
        }

        @Override // com.facebook.GraphRequest.e
        public void a(GraphResponse graphResponse) {
            c.n(this.a, this.b, graphResponse, this.c, this.f2264d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppEventQueue.java */
    /* loaded from: classes.dex */
    public static class f implements Runnable {
        final /* synthetic */ AccessTokenAppIdPair a;
        final /* synthetic */ h b;

        f(AccessTokenAppIdPair accessTokenAppIdPair, h hVar) {
            this.a = accessTokenAppIdPair;
            this.b = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                com.facebook.appevents.d.a(this.a, this.b);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    c() {
    }

    static /* synthetic */ ScheduledFuture a() {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            return f2262e;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    static /* synthetic */ ScheduledFuture b(ScheduledFuture scheduledFuture) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            f2262e = scheduledFuture;
            return scheduledFuture;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    static /* synthetic */ com.facebook.appevents.b c() {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            return c;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    static /* synthetic */ com.facebook.appevents.b d(com.facebook.appevents.b bVar) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            c = bVar;
            return bVar;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    static /* synthetic */ Integer e() {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            return b;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    static /* synthetic */ Runnable f() {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            return f2263f;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    static /* synthetic */ ScheduledExecutorService g() {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            return f2261d;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    public static void h(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return;
        }
        try {
            f2261d.execute(new d(accessTokenAppIdPair, appEvent));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
        }
    }

    static GraphRequest i(AccessTokenAppIdPair accessTokenAppIdPair, h hVar, boolean z, g gVar) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            String applicationId = accessTokenAppIdPair.getApplicationId();
            l o = FetchedAppSettingsManager.o(applicationId, false);
            GraphRequest K = GraphRequest.K(null, String.format("%s/activities", applicationId), null, null);
            Bundle y = K.y();
            if (y == null) {
                y = new Bundle();
            }
            y.putString("access_token", accessTokenAppIdPair.getAccessTokenString());
            String d2 = InternalAppEventsLogger.d();
            if (d2 != null) {
                y.putString("device_token", d2);
            }
            String g2 = com.facebook.appevents.e.g();
            if (g2 != null) {
                y.putString(Constants.INSTALL_REFERRER, g2);
            }
            K.Z(y);
            int f2 = hVar.f(K, com.facebook.f.f(), o != null ? o.o() : false, z);
            if (f2 == 0) {
                return null;
            }
            gVar.a += f2;
            K.V(new e(accessTokenAppIdPair, K, hVar, gVar));
            return K;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    static List<GraphRequest> j(com.facebook.appevents.b bVar, g gVar) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            boolean t = com.facebook.f.t(com.facebook.f.f());
            ArrayList arrayList = new ArrayList();
            for (AccessTokenAppIdPair accessTokenAppIdPair : bVar.f()) {
                GraphRequest i2 = i(accessTokenAppIdPair, bVar.c(accessTokenAppIdPair), t, gVar);
                if (i2 != null) {
                    arrayList.add(i2);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    public static void k(FlushReason flushReason) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return;
        }
        try {
            f2261d.execute(new RunnableC0070c(flushReason));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
        }
    }

    static void l(FlushReason flushReason) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return;
        }
        try {
            c.b(com.facebook.appevents.d.c());
            try {
                g p = p(flushReason, c);
                if (p != null) {
                    Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                    intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", p.a);
                    intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", p.b);
                    LocalBroadcastManager.getInstance(com.facebook.f.f()).sendBroadcast(intent);
                }
            } catch (Exception e2) {
                Log.w(a, "Caught unexpected exception while flushing app events: ", e2);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
        }
    }

    public static Set<AccessTokenAppIdPair> m() {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            return c.f();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    static void n(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, h hVar, g gVar) {
        String str;
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return;
        }
        try {
            FacebookRequestError g2 = graphResponse.g();
            String str2 = "Success";
            FlushResult flushResult = FlushResult.SUCCESS;
            boolean z = true;
            if (g2 != null) {
                if (g2.c() == -1) {
                    str2 = "Failed: No Connectivity";
                    flushResult = FlushResult.NO_CONNECTIVITY;
                } else {
                    str2 = String.format("Failed:\n  Response: %s\n  Error %s", graphResponse.toString(), g2.toString());
                    flushResult = FlushResult.SERVER_ERROR;
                }
            }
            if (com.facebook.f.B(LoggingBehavior.APP_EVENTS)) {
                try {
                    str = new JSONArray((String) graphRequest.A()).toString(2);
                } catch (JSONException unused) {
                    str = "<Can't encode events for debug logging>";
                }
                r.h(LoggingBehavior.APP_EVENTS, a, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", graphRequest.t().toString(), str2, str);
            }
            if (g2 == null) {
                z = false;
            }
            hVar.b(z);
            FlushResult flushResult2 = FlushResult.NO_CONNECTIVITY;
            if (flushResult == flushResult2) {
                com.facebook.f.p().execute(new f(accessTokenAppIdPair, hVar));
            }
            if (flushResult == FlushResult.SUCCESS || gVar.b == flushResult2) {
                return;
            }
            gVar.b = flushResult;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
        }
    }

    public static void o() {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return;
        }
        try {
            f2261d.execute(new b());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
        }
    }

    private static g p(FlushReason flushReason, com.facebook.appevents.b bVar) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            g gVar = new g();
            List<GraphRequest> j2 = j(bVar, gVar);
            if (j2.size() > 0) {
                r.h(LoggingBehavior.APP_EVENTS, a, "Flushing %d events due to %s.", Integer.valueOf(gVar.a), flushReason.toString());
                for (GraphRequest graphRequest : j2) {
                    graphRequest.g();
                }
                return gVar;
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }
}
