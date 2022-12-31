package com.tapjoy.internal;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJConnectListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public abstract class gb {
    private final ReentrantLock a;
    volatile int b;
    b c;

    /* renamed from: d  reason: collision with root package name */
    long f7555d;

    /* renamed from: e  reason: collision with root package name */
    a f7556e;

    /* renamed from: f  reason: collision with root package name */
    private final Condition f7557f;

    /* renamed from: g  reason: collision with root package name */
    private final LinkedList f7558g;

    /* renamed from: h  reason: collision with root package name */
    private a f7559h;

    /* renamed from: com.tapjoy.internal.gb$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.a().length];
            a = iArr;
            try {
                iArr[c.f7564e - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.a - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.b - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.c - 1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c.f7563d - 1] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public final Context a;
        public final String b;
        public final Hashtable c;

        public a(Context context, String str, Hashtable hashtable) {
            Context context2;
            if (context != null) {
                context2 = context instanceof Application ? context : context.getApplicationContext();
            } else {
                context2 = null;
            }
            this.a = context2 != null ? context2 : context;
            this.b = str;
            this.c = hashtable;
        }
    }

    /* loaded from: classes3.dex */
    class b extends ka {
        private boolean b;
        private boolean c;

        /* renamed from: d  reason: collision with root package name */
        private Context f7561d;

        /* renamed from: e  reason: collision with root package name */
        private BroadcastReceiver f7562e;

        private b() {
            this.f7562e = new BroadcastReceiver() { // from class: com.tapjoy.internal.gb.b.2
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context, Intent intent) {
                    VdsAgent.onBroadcastReceiver(this, context, intent);
                    gb.this.b();
                }
            };
        }

        private void h() {
            this.f7561d.unregisterReceiver(this.f7562e);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tapjoy.internal.ka
        public final void b() {
            gb gbVar = gb.this;
            int i2 = c.c;
            int i3 = c.b;
            gbVar.a(i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tapjoy.internal.ka
        public final void c() {
            gb gbVar = gb.this;
            if (gbVar.c == this) {
                gbVar.c = null;
            }
            if (gbVar.b == c.c) {
                gb.this.a(c.a);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tapjoy.internal.ka
        public final void d() {
            this.f7561d = gb.this.a().a;
            this.f7561d.registerReceiver(this.f7562e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            while (!this.b) {
                try {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    fs.b.addObserver(new Observer() { // from class: com.tapjoy.internal.gb.b.1
                        @Override // java.util.Observer
                        public final void update(Observable observable, Object obj) {
                            fs.b.deleteObserver(this);
                            b.this.c = Boolean.TRUE.equals(obj);
                            countDownLatch.countDown();
                        }
                    });
                    a a = gb.this.a();
                    if (!gb.this.a(a.a, a.b, a.c, null)) {
                        gb.this.a(false);
                        return;
                    }
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException unused) {
                    }
                    if (!this.c) {
                        gb.this.a(false);
                        long max = Math.max(gb.this.f7555d, 1000L);
                        gb.this.f7555d = Math.min(max << 2, 3600000L);
                        gb.this.a(max);
                    } else {
                        gb gbVar = gb.this;
                        int i2 = c.f7564e;
                        int i3 = c.c;
                        gbVar.a(i2);
                        gb.this.a(true);
                        return;
                    }
                } finally {
                    h();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tapjoy.internal.ka
        public final void a() {
            this.b = true;
            gb.this.b();
        }

        /* synthetic */ b(gb gbVar, byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class c {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f7563d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f7564e = 5;

        /* renamed from: f  reason: collision with root package name */
        private static final /* synthetic */ int[] f7565f = {1, 2, 3, 4, 5};

        public static int[] a() {
            return (int[]) f7565f.clone();
        }
    }

    public gb() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.a = reentrantLock;
        this.f7557f = reentrantLock.newCondition();
        this.b = c.a;
        this.f7558g = new LinkedList();
        this.f7555d = 1000L;
    }

    public abstract boolean a(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener);

    public final boolean b(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        this.a.lock();
        if (tJConnectListener != null) {
            try {
                this.f7558g.addLast(fn.a(tJConnectListener, TJConnectListener.class));
            } finally {
                this.a.unlock();
            }
        }
        a aVar = new a(context, str, hashtable);
        int i2 = AnonymousClass3.a[this.b - 1];
        if (i2 == 1) {
            a(true);
        } else if (i2 == 2) {
            this.f7556e = aVar;
            fs.b.addObserver(new Observer() { // from class: com.tapjoy.internal.gb.1
                @Override // java.util.Observer
                public final void update(Observable observable, Object obj) {
                    gb gbVar;
                    a aVar2;
                    fs.b.deleteObserver(this);
                    if (Boolean.valueOf(Boolean.TRUE.equals(obj)).booleanValue() || (aVar2 = (gbVar = gb.this).f7556e) == null || aVar2.a == null) {
                        return;
                    }
                    gbVar.c = new b(gb.this, (byte) 0);
                    gb.this.c.e();
                }
            });
            if (a(aVar.a, aVar.b, aVar.c, new TJConnectListener() { // from class: com.tapjoy.internal.gb.2
                @Override // com.tapjoy.TJConnectListener
                public final void onConnectFailure() {
                    gb.this.a(false);
                }

                @Override // com.tapjoy.TJConnectListener
                public final void onConnectSuccess() {
                    gb gbVar = gb.this;
                    int i3 = c.f7564e;
                    int i4 = c.b;
                    gbVar.a(i3);
                    gb.this.a(true);
                }
            })) {
                int i3 = c.b;
                int i4 = c.a;
                a(i3);
            } else {
                this.f7558g.clear();
                return false;
            }
        } else if (i2 == 3 || i2 == 4) {
            this.f7559h = aVar;
        } else if (i2 != 5) {
            a(c.a);
            return false;
        } else {
            this.f7559h = aVar;
            b();
        }
        return true;
    }

    final void a(int i2) {
        this.a.lock();
        try {
            this.b = i2;
        } finally {
            this.a.unlock();
        }
    }

    final a a() {
        this.a.lock();
        try {
            a aVar = this.f7559h;
            if (aVar != null) {
                this.f7556e = aVar;
                this.f7559h = null;
            }
            return this.f7556e;
        } finally {
            this.a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        this.a.lock();
        try {
            if (this.f7558g.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f7558g);
            this.f7558g.clear();
            this.a.unlock();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                TJConnectListener tJConnectListener = (TJConnectListener) it.next();
                if (z) {
                    tJConnectListener.onConnectSuccess();
                } else {
                    tJConnectListener.onConnectFailure();
                }
            }
        } finally {
            this.a.unlock();
        }
    }

    final void b() {
        this.a.lock();
        try {
            this.f7555d = 1000L;
            this.f7557f.signal();
        } finally {
            this.a.unlock();
        }
    }

    final boolean a(long j2) {
        this.a.lock();
        try {
            int i2 = c.f7563d;
            int i3 = c.c;
            a(i2);
            if (this.f7557f.await(j2, TimeUnit.MILLISECONDS)) {
                this.f7555d = 1000L;
            }
            a(i3);
        } catch (InterruptedException unused) {
            int i4 = c.c;
            int i5 = c.f7563d;
            a(i4);
        } catch (Throwable th) {
            int i6 = c.c;
            int i7 = c.f7563d;
            a(i6);
            this.a.unlock();
            throw th;
        }
        this.a.unlock();
        return false;
    }
}
