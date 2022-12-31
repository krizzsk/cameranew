package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.util.s;
import com.google.android.gms.common.util.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class a {

    /* renamed from: l  reason: collision with root package name */
    private static ScheduledExecutorService f4015l;
    private final Object a;
    private final PowerManager.WakeLock b;
    private WorkSource c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4016d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4017e;

    /* renamed from: f  reason: collision with root package name */
    private final String f4018f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f4019g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4020h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<String, Integer[]> f4021i;

    /* renamed from: j  reason: collision with root package name */
    private int f4022j;

    /* renamed from: k  reason: collision with root package name */
    private AtomicInteger f4023k;

    public a(@NonNull Context context, int i2, @NonNull String str) {
        this(context, i2, str, null, context == null ? null : context.getPackageName());
    }

    private final String d(String str) {
        return (!this.f4020h || TextUtils.isEmpty(str)) ? this.f4018f : str;
    }

    private final List<String> e() {
        return u.b(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(int i2) {
        if (this.b.isHeld()) {
            try {
                this.b.release();
            } catch (RuntimeException e2) {
                if (e2.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.f4017e).concat(" was already released!"), e2);
                } else {
                    throw e2;
                }
            }
            this.b.isHeld();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r2 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        if (r13.f4022j == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().b(r13.f4019g, com.google.android.gms.common.stats.b.a(r13.b, r6), 7, r13.f4017e, r6, null, r13.f4016d, e(), r14);
        r13.f4022j++;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r13.f4023k
            r0.incrementAndGet()
            r0 = 0
            java.lang.String r6 = r13.d(r0)
            java.lang.Object r0 = r13.a
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f4021i     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L96
            r2 = 0
            if (r1 == 0) goto L1a
            int r1 = r13.f4022j     // Catch: java.lang.Throwable -> L96
            if (r1 <= 0) goto L29
        L1a:
            android.os.PowerManager$WakeLock r1 = r13.b     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isHeld()     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L29
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f4021i     // Catch: java.lang.Throwable -> L96
            r1.clear()     // Catch: java.lang.Throwable -> L96
            r13.f4022j = r2     // Catch: java.lang.Throwable -> L96
        L29:
            boolean r1 = r13.f4020h     // Catch: java.lang.Throwable -> L96
            r12 = 1
            if (r1 == 0) goto L56
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f4021i     // Catch: java.lang.Throwable -> L96
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L47
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f4021i     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r3 = new java.lang.Integer[r12]     // Catch: java.lang.Throwable -> L96
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L96
            r3[r2] = r4     // Catch: java.lang.Throwable -> L96
            r1.put(r6, r3)     // Catch: java.lang.Throwable -> L96
            r2 = 1
            goto L54
        L47:
            r3 = r1[r2]     // Catch: java.lang.Throwable -> L96
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L96
            int r3 = r3 + r12
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L96
            r1[r2] = r3     // Catch: java.lang.Throwable -> L96
        L54:
            if (r2 != 0) goto L5e
        L56:
            boolean r1 = r13.f4020h     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
            int r1 = r13.f4022j     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
        L5e:
            com.google.android.gms.common.stats.WakeLockTracker r1 = com.google.android.gms.common.stats.WakeLockTracker.getInstance()     // Catch: java.lang.Throwable -> L96
            android.content.Context r2 = r13.f4019g     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r3 = r13.b     // Catch: java.lang.Throwable -> L96
            java.lang.String r3 = com.google.android.gms.common.stats.b.a(r3, r6)     // Catch: java.lang.Throwable -> L96
            r4 = 7
            java.lang.String r5 = r13.f4017e     // Catch: java.lang.Throwable -> L96
            r7 = 0
            int r8 = r13.f4016d     // Catch: java.lang.Throwable -> L96
            java.util.List r9 = r13.e()     // Catch: java.lang.Throwable -> L96
            r10 = r14
            r1.b(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L96
            int r1 = r13.f4022j     // Catch: java.lang.Throwable -> L96
            int r1 = r1 + r12
            r13.f4022j = r1     // Catch: java.lang.Throwable -> L96
        L7d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r0 = r13.b
            r0.acquire()
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 <= 0) goto L95
            java.util.concurrent.ScheduledExecutorService r0 = com.google.android.gms.stats.a.f4015l
            com.google.android.gms.stats.b r1 = new com.google.android.gms.stats.b
            r1.<init>(r13)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r14, r2)
        L95:
            return
        L96:
            r14 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.a.a(long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r1 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
        if (r12.f4022j == 1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().a(r12.f4019g, com.google.android.gms.common.stats.b.a(r12.b, r6), 8, r12.f4017e, r6, null, r12.f4016d, e());
        r12.f4022j--;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.f4023k
            int r0 = r0.decrementAndGet()
            if (r0 >= 0) goto L19
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r12.f4017e
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = " release without a matched acquire!"
            java.lang.String r1 = r1.concat(r2)
            android.util.Log.e(r0, r1)
        L19:
            r0 = 0
            java.lang.String r6 = r12.d(r0)
            java.lang.Object r0 = r12.a
            monitor-enter(r0)
            boolean r1 = r12.f4020h     // Catch: java.lang.Throwable -> L7e
            r10 = 1
            r11 = 0
            if (r1 == 0) goto L52
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f4021i     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L7e
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L33
        L31:
            r1 = 0
            goto L50
        L33:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            if (r2 != r10) goto L42
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f4021i     // Catch: java.lang.Throwable -> L7e
            r1.remove(r6)     // Catch: java.lang.Throwable -> L7e
            r1 = 1
            goto L50
        L42:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            int r2 = r2 - r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L7e
            r1[r11] = r2     // Catch: java.lang.Throwable -> L7e
            goto L31
        L50:
            if (r1 != 0) goto L5a
        L52:
            boolean r1 = r12.f4020h     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L79
            int r1 = r12.f4022j     // Catch: java.lang.Throwable -> L7e
            if (r1 != r10) goto L79
        L5a:
            com.google.android.gms.common.stats.WakeLockTracker r1 = com.google.android.gms.common.stats.WakeLockTracker.getInstance()     // Catch: java.lang.Throwable -> L7e
            android.content.Context r2 = r12.f4019g     // Catch: java.lang.Throwable -> L7e
            android.os.PowerManager$WakeLock r3 = r12.b     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = com.google.android.gms.common.stats.b.a(r3, r6)     // Catch: java.lang.Throwable -> L7e
            r4 = 8
            java.lang.String r5 = r12.f4017e     // Catch: java.lang.Throwable -> L7e
            r7 = 0
            int r8 = r12.f4016d     // Catch: java.lang.Throwable -> L7e
            java.util.List r9 = r12.e()     // Catch: java.lang.Throwable -> L7e
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L7e
            int r1 = r12.f4022j     // Catch: java.lang.Throwable -> L7e
            int r1 = r1 - r10
            r12.f4022j = r1     // Catch: java.lang.Throwable -> L7e
        L79:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            r12.f(r11)
            return
        L7e:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.a.b():void");
    }

    public void c(boolean z) {
        this.b.setReferenceCounted(z);
        this.f4020h = z;
    }

    private a(@NonNull Context context, int i2, @NonNull String str, @Nullable String str2, @NonNull String str3) {
        this(context, i2, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private a(@NonNull Context context, int i2, @NonNull String str, @Nullable String str2, @NonNull String str3, @Nullable String str4) {
        this.a = this;
        this.f4020h = true;
        this.f4021i = new HashMap();
        Collections.synchronizedSet(new HashSet());
        this.f4023k = new AtomicInteger(0);
        q.k(context, "WakeLock: context must not be null");
        q.g(str, "WakeLock: wakeLockName must not be empty");
        this.f4016d = i2;
        this.f4018f = null;
        Context applicationContext = context.getApplicationContext();
        this.f4019g = applicationContext;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            this.f4017e = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        } else {
            this.f4017e = str;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i2, str);
        this.b = newWakeLock;
        if (u.c(context)) {
            WorkSource a = u.a(context, s.a(str3) ? context.getPackageName() : str3);
            this.c = a;
            if (a != null && u.c(applicationContext)) {
                WorkSource workSource = this.c;
                if (workSource != null) {
                    workSource.add(a);
                } else {
                    this.c = a;
                }
                try {
                    newWakeLock.setWorkSource(this.c);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
                    Log.wtf("WakeLock", e2.toString());
                }
            }
        }
        if (f4015l == null) {
            f4015l = PooledExecutorsProvider.getInstance().a();
        }
    }
}
