package com.bytedance.sdk.openadsdk.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.PeriodicWorkRequest;
import com.bytedance.sdk.openadsdk.c.i;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* compiled from: AdEventThread.java */
/* loaded from: classes.dex */
public class g<T extends i> extends HandlerThread implements Handler.Callback {
    public static String a = "AdEventThread";
    public static String b = "ttad_bk";
    public final e<T> c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.p<T> f1391d;

    /* renamed from: e  reason: collision with root package name */
    public final List<T> f1392e;

    /* renamed from: f  reason: collision with root package name */
    public long f1393f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1394g;

    /* renamed from: h  reason: collision with root package name */
    public int f1395h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f1396i;

    /* renamed from: j  reason: collision with root package name */
    public final a f1397j;

    /* renamed from: k  reason: collision with root package name */
    public final b f1398k;

    /* renamed from: l  reason: collision with root package name */
    private final g<T>.c f1399l;

    /* compiled from: AdEventThread.java */
    /* loaded from: classes.dex */
    public interface a {
        boolean a();
    }

    /* compiled from: AdEventThread.java */
    /* loaded from: classes.dex */
    public static class b {
        final int a;
        final long b;
        final long c;

        /* renamed from: d  reason: collision with root package name */
        final int f1400d;

        /* renamed from: e  reason: collision with root package name */
        final long f1401e;

        /* renamed from: f  reason: collision with root package name */
        final long f1402f;

        b(int i2, long j2, long j3, int i3, long j4, long j5) {
            this.a = i2;
            this.b = j2;
            this.c = j3;
            this.f1400d = i3;
            this.f1401e = j4;
            this.f1402f = j5;
        }

        public static b a() {
            return new b(1, 120000L, 15000L, 5, 172800000L, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        }

        public static b b() {
            return new b(3, 120000L, 15000L, 5, 172800000L, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        }
    }

    /* compiled from: AdEventThread.java */
    /* loaded from: classes.dex */
    private class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            com.bytedance.sdk.openadsdk.utils.o.c(g.a, "onReceive: timer event");
            Handler handler = g.this.f1396i;
            if (handler == null) {
                return;
            }
            handler.removeMessages(6);
            Message obtainMessage = g.this.f1396i.obtainMessage();
            obtainMessage.what = 6;
            g.this.f1396i.sendMessage(obtainMessage);
        }
    }

    public g(e<T> eVar, com.bytedance.sdk.openadsdk.core.p<T> pVar, b bVar, a aVar) {
        this(b, a, eVar, pVar, bVar, aVar);
    }

    private void a() {
        e<T> eVar = this.c;
        b bVar = this.f1398k;
        eVar.a(bVar.f1400d, bVar.f1401e);
        this.f1394g = this.c.a();
        this.f1395h = this.c.b();
        if (this.f1394g) {
            a("onHandleInitEvent serverBusy, retryCount = " + this.f1395h);
            i();
            return;
        }
        b(this.c.a(50, "_id"));
        a("onHandleInitEvent cacheData count = " + this.f1392e.size());
        f();
    }

    private void b() {
        e<T> eVar = this.c;
        b bVar = this.f1398k;
        eVar.a(bVar.f1400d, bVar.f1401e);
        this.f1394g = this.c.a();
        this.f1395h = this.c.b();
        if (this.f1394g) {
            a("onHandleInitEvent serverBusy, retryCount = " + this.f1395h);
            i();
            return;
        }
        b(this.c.a(50, "_id"));
        c(this.f1392e);
        a("onHandleInitEvent cacheData count = " + this.f1392e.size());
        f();
    }

    private void c() {
        if (!this.f1397j.a()) {
            a(4, this.f1398k.c);
            a("onHandleServerBusyRetryEvent, no net");
            return;
        }
        List<T> a2 = this.c.a(50, "_id");
        if (com.bytedance.sdk.openadsdk.utils.m.a(a2)) {
            a("onHandleServerBusyRetryEvent, empty list start routine");
            o();
            k();
            return;
        }
        h a3 = a(a2);
        if (a3 != null) {
            if (a3.a) {
                a("onHandleServerBusyRetryEvent, success");
                h();
                g();
            } else if (a(a3)) {
                int i2 = this.f1395h + 1;
                this.f1395h = i2;
                this.c.a(i2);
                e<T> eVar = this.c;
                b bVar = this.f1398k;
                eVar.a(a2, bVar.f1400d, bVar.f1401e);
                i();
                a("onHandleServerBusyRetryEvent, serverbusy, count = " + this.f1395h);
            } else if (b(a3)) {
                h();
                g();
            } else {
                j();
            }
        }
    }

    private void d() {
        if (this.f1394g) {
            return;
        }
        a("onHandleRoutineRetryEvent");
        f();
    }

    private void e() {
        if (this.f1394g) {
            return;
        }
        a("onHandleRoutineUploadEvent");
        f();
    }

    private void f() {
        com.bytedance.sdk.openadsdk.utils.o.c("ReportEvent", "execute doRoutineUpload ... start ");
        this.f1396i.removeMessages(3);
        this.f1396i.removeMessages(2);
        this.f1396i.removeMessages(6);
        com.bytedance.sdk.openadsdk.utils.o.c("ReportEvent", "execute doRoutineUpload ... ListUtils.isEmpty(mCacheList) :" + com.bytedance.sdk.openadsdk.utils.m.a(this.f1392e));
        if (com.bytedance.sdk.openadsdk.utils.m.a(this.f1392e)) {
            this.f1393f = System.currentTimeMillis();
            k();
        } else if (!this.f1397j.a()) {
            com.bytedance.sdk.openadsdk.utils.o.c("ReportEvent", "execute doRoutineUpload ...no network, wait retry ");
            j();
        } else {
            h a2 = a(this.f1392e);
            if (a2 != null) {
                if (a2.a) {
                    com.bytedance.sdk.openadsdk.utils.o.c("ReportEvent", "doRoutineUpload success");
                    h();
                    g();
                } else if (a(a2)) {
                    l();
                } else if (b(a2)) {
                    h();
                    g();
                } else if (this.f1394g) {
                } else {
                    j();
                }
            }
        }
    }

    private void g() {
        this.f1393f = System.currentTimeMillis();
        o();
        k();
    }

    private void h() {
        this.c.a(this.f1392e);
        this.f1392e.clear();
    }

    private void i() {
        a(4, m());
    }

    private void j() {
        a(3, this.f1398k.c);
    }

    private void k() {
        a(2, this.f1398k.b);
    }

    private void l() {
        this.f1394g = true;
        this.c.a(true);
        this.f1392e.clear();
        this.f1396i.removeMessages(3);
        this.f1396i.removeMessages(2);
        i();
    }

    private long m() {
        return ((this.f1395h % 3) + 1) * this.f1398k.f1402f;
    }

    private boolean n() {
        return !this.f1394g && (this.f1392e.size() >= this.f1398k.a || System.currentTimeMillis() - this.f1393f >= this.f1398k.b);
    }

    private void o() {
        this.f1394g = false;
        this.c.a(false);
        this.f1395h = 0;
        this.c.a(0);
        this.f1396i.removeMessages(4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                a((g<T>) ((i) message.obj));
                return true;
            case 2:
                e();
                return true;
            case 3:
                d();
                return true;
            case 4:
                c();
                return true;
            case 5:
                a();
                return true;
            case 6:
                b();
                return true;
            default:
                return true;
        }
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        this.f1393f = System.currentTimeMillis();
        this.f1396i = new Handler(getLooper(), this);
    }

    public g(String str, String str2, e<T> eVar, com.bytedance.sdk.openadsdk.core.p<T> pVar, b bVar, a aVar) {
        super(str);
        g<T>.c cVar = new c();
        this.f1399l = cVar;
        a = str2;
        this.f1398k = bVar;
        this.f1397j = aVar;
        this.c = eVar;
        this.f1391d = pVar;
        this.f1392e = Collections.synchronizedList(new LinkedList());
        LocalBroadcastManager.getInstance(com.bytedance.sdk.openadsdk.core.o.a()).registerReceiver(cVar, new IntentFilter(com.bytedance.sdk.openadsdk.utils.a.a));
    }

    public h a(List<T> list) {
        if (this.f1391d == null) {
            com.bytedance.sdk.openadsdk.core.o.f();
        }
        com.bytedance.sdk.openadsdk.core.p<T> pVar = this.f1391d;
        if (pVar == null) {
            return null;
        }
        return pVar.a(list);
    }

    private void b(List<T> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    HashSet hashSet = new HashSet();
                    for (T t : this.f1392e) {
                        hashSet.add(t.b());
                    }
                    for (T t2 : list) {
                        if (!hashSet.contains(t2.b())) {
                            this.f1392e.add(t2);
                        }
                    }
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        a("reloadCacheList adEventList is empty======");
    }

    private void a(T t) {
        com.bytedance.sdk.openadsdk.utils.o.b("ReportEvent", "execute onHandleReceivedAdEvent()  start...");
        this.c.a((e<T>) t);
        if (this.f1394g) {
            return;
        }
        a("onHandleReceivedAdEvent");
        this.f1392e.add(t);
        c(this.f1392e);
        com.bytedance.sdk.openadsdk.utils.o.b("ReportEvent", "execute onHandleReceivedAdEvent() ... mIsServerBusy =" + this.f1394g);
        if (n()) {
            com.bytedance.sdk.openadsdk.utils.o.b("ReportEvent", "execute onHandleReceivedAdEvent()  needUploadRoutine ... upload ");
            f();
        }
    }

    private static boolean b(h hVar) {
        return hVar.f1403d;
    }

    private void c(List<T> list) {
        if (list == null) {
            return;
        }
        if (list.size() <= 75) {
            a("start and return, checkAndDeleteEvent local size:" + list.size() + "小于:75");
            return;
        }
        int size = list.size() - 75;
        a("start checkAndDeleteEvent local size,deleteCnt:" + list.size() + "," + size);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(list.get(i2));
        }
        list.removeAll(arrayList);
        a("end checkAndDeleteEvent local size:" + list.size());
    }

    private void a(int i2, long j2) {
        Message obtainMessage = this.f1396i.obtainMessage();
        obtainMessage.what = i2;
        this.f1396i.sendMessageDelayed(obtainMessage, j2);
    }

    private static boolean a(h hVar) {
        return hVar.b == 509;
    }

    private void a(String str) {
        com.bytedance.sdk.openadsdk.utils.o.c(a, str);
    }
}
