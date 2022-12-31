package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class t<T extends IInterface> {

    /* renamed from: l  reason: collision with root package name */
    private static final Map<String, Handler> f4859l = new HashMap();
    private final Context a;
    private final j b;
    private final String c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4861e;

    /* renamed from: f  reason: collision with root package name */
    private final Intent f4862f;

    /* renamed from: g  reason: collision with root package name */
    private final p<T> f4863g;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ServiceConnection f4866j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private T f4867k;

    /* renamed from: d  reason: collision with root package name */
    private final List<k> f4860d = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final IBinder.DeathRecipient f4865i = new IBinder.DeathRecipient(this) { // from class: com.google.android.play.core.internal.l
        private final t a;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.a = this;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            this.a.k();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final WeakReference<o> f4864h = new WeakReference<>(null);

    public t(Context context, j jVar, String str, Intent intent, p<T> pVar) {
        this.a = context;
        this.b = jVar;
        this.c = str;
        this.f4862f = intent;
        this.f4863g = pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(t tVar, k kVar) {
        if (tVar.f4867k != null || tVar.f4861e) {
            if (!tVar.f4861e) {
                kVar.run();
                return;
            }
            tVar.b.f("Waiting to bind to the service.", new Object[0]);
            tVar.f4860d.add(kVar);
            return;
        }
        tVar.b.f("Initiate binding to the service.", new Object[0]);
        tVar.f4860d.add(kVar);
        s sVar = new s(tVar);
        tVar.f4866j = sVar;
        tVar.f4861e = true;
        if (tVar.a.bindService(tVar.f4862f, sVar, 1)) {
            return;
        }
        tVar.b.f("Failed to bind to the service.", new Object[0]);
        tVar.f4861e = false;
        List<k> list = tVar.f4860d;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.google.android.play.core.tasks.p<?> b = list.get(i2).b();
            if (b != null) {
                b.d(new aq());
            }
        }
        tVar.f4860d.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(k kVar) {
        Handler handler;
        Map<String, Handler> map = f4859l;
        synchronized (map) {
            if (!map.containsKey(this.c)) {
                HandlerThread handlerThread = new HandlerThread(this.c, 10);
                handlerThread.start();
                map.put(this.c, new Handler(handlerThread.getLooper()));
            }
            handler = map.get(this.c);
        }
        handler.post(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(t tVar) {
        tVar.b.f("linkToDeath", new Object[0]);
        try {
            tVar.f4867k.asBinder().linkToDeath(tVar.f4865i, 0);
        } catch (RemoteException e2) {
            tVar.b.d(e2, "linkToDeath failed", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(t tVar) {
        tVar.b.f("unlinkToDeath", new Object[0]);
        tVar.f4867k.asBinder().unlinkToDeath(tVar.f4865i, 0);
    }

    public final void b() {
        h(new n(this));
    }

    public final void c(k kVar) {
        h(new m(this, kVar.b(), kVar));
    }

    @Nullable
    public final T f() {
        return this.f4867k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void k() {
        this.b.f("reportBinderDeath", new Object[0]);
        o oVar = this.f4864h.get();
        if (oVar != null) {
            this.b.f("calling onBinderDied", new Object[0]);
            oVar.a();
            return;
        }
        this.b.f("%s : Binder has died.", this.c);
        List<k> list = this.f4860d;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.google.android.play.core.tasks.p<?> b = list.get(i2).b();
            if (b != null) {
                b.d(Build.VERSION.SDK_INT < 15 ? new RemoteException() : new RemoteException(String.valueOf(this.c).concat(" : Binder has died.")));
            }
        }
        this.f4860d.clear();
    }
}
