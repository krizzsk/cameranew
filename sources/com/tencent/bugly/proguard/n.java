package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class n {
    public static final long a = System.currentTimeMillis();
    private static n b;
    private Context c;

    /* renamed from: f  reason: collision with root package name */
    private SharedPreferences f7992f;

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, Map<String, m>> f7991e = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private String f7990d = com.tencent.bugly.crashreport.common.info.a.b().f7817d;

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    final class a implements Runnable {
        private /* synthetic */ int a;
        private /* synthetic */ int b;

        a(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            m mVar;
            String str;
            String str2;
            try {
                if (TextUtils.isEmpty(n.this.f7990d)) {
                    return;
                }
                List<m> c = n.this.c(this.a);
                if (c == null) {
                    c = new ArrayList();
                }
                if (n.this.f7991e.get(Integer.valueOf(this.a)) == null) {
                    n.this.f7991e.put(Integer.valueOf(this.a), new HashMap());
                }
                if (((Map) n.this.f7991e.get(Integer.valueOf(this.a))).get(n.this.f7990d) != null) {
                    mVar = (m) ((Map) n.this.f7991e.get(Integer.valueOf(this.a))).get(n.this.f7990d);
                    mVar.f7986d = this.b;
                } else {
                    mVar = new m();
                    mVar.a = this.a;
                    mVar.f7989g = n.a;
                    mVar.b = n.this.f7990d;
                    mVar.f7988f = com.tencent.bugly.crashreport.common.info.a.b().f7824k;
                    mVar.f7987e = com.tencent.bugly.crashreport.common.info.a.b().f7819f;
                    mVar.c = System.currentTimeMillis();
                    mVar.f7986d = this.b;
                    ((Map) n.this.f7991e.get(Integer.valueOf(this.a))).put(n.this.f7990d, mVar);
                }
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (m mVar2 : c) {
                    if (mVar2.f7989g == mVar.f7989g && (str2 = mVar2.b) != null && str2.equalsIgnoreCase(mVar.b)) {
                        z = true;
                        mVar2.f7986d = mVar.f7986d;
                    }
                    String str3 = mVar2.f7987e;
                    if ((str3 != null && !str3.equalsIgnoreCase(mVar.f7987e)) || (((str = mVar2.f7988f) != null && !str.equalsIgnoreCase(mVar.f7988f)) || mVar2.f7986d <= 0)) {
                        arrayList.add(mVar2);
                    }
                }
                c.removeAll(arrayList);
                if (!z) {
                    c.add(mVar);
                }
                n.this.a(this.a, (int) c);
            } catch (Exception unused) {
                x.e("saveCrashRecord failed", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public final class b implements Runnable {
        private /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean b = n.this.b(this.a);
            SharedPreferences.Editor edit = n.this.f7992f.edit();
            edit.putBoolean(this.a + "_" + n.this.f7990d, !b).commit();
        }
    }

    private n(Context context) {
        this.c = context;
        this.f7992f = context.getSharedPreferences("crashrecord", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r6 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        if (r6 == null) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized <T extends java.util.List<?>> T c(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            android.content.Context r3 = r5.c     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r4.<init>()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r4.append(r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            if (r6 != 0) goto L24
            monitor-exit(r5)
            return r0
        L24:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.ClassNotFoundException -> L3d java.io.IOException -> L4b java.lang.Throwable -> L55
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.ClassNotFoundException -> L3d java.io.IOException -> L4b java.lang.Throwable -> L55
            r6.close()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            monitor-exit(r5)
            return r2
        L39:
            r2 = move-exception
            r6 = r0
            goto L56
        L3c:
            r6 = r0
        L3d:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L55
            com.tencent.bugly.proguard.x.a(r2, r3)     // Catch: java.lang.Throwable -> L55
            if (r6 == 0) goto L65
        L46:
            r6.close()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            goto L65
        L4a:
            r6 = r0
        L4b:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L55
            com.tencent.bugly.proguard.x.a(r2, r3)     // Catch: java.lang.Throwable -> L55
            if (r6 == 0) goto L65
            goto L46
        L55:
            r2 = move-exception
        L56:
            if (r6 == 0) goto L5b
            r6.close()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
        L5b:
            throw r2     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
        L5c:
            r6 = move-exception
            goto L67
        L5e:
            java.lang.String r6 = "readCrashRecord error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5c
            com.tencent.bugly.proguard.x.e(r6, r1)     // Catch: java.lang.Throwable -> L5c
        L65:
            monitor-exit(r5)
            return r0
        L67:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.n.c(int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean b(int i2) {
        try {
            List<m> c = c(i2);
            if (c == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (m mVar : c) {
                String str = mVar.b;
                if (str != null && str.equalsIgnoreCase(this.f7990d) && mVar.f7986d > 0) {
                    arrayList.add(mVar);
                }
                if (mVar.c + AdvTimeUtils.MILLIS_OF_A_DAY < currentTimeMillis) {
                    arrayList2.add(mVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((m) arrayList.get(arrayList.size() - 1)).c + AdvTimeUtils.MILLIS_OF_A_DAY >= currentTimeMillis) {
                    return true;
                }
                c.clear();
                a(i2, (int) c);
                return false;
            }
            c.removeAll(arrayList2);
            a(i2, (int) c);
            return false;
        } catch (Exception unused) {
            x.e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (b == null) {
                b = new n(context);
            }
            nVar = b;
        }
        return nVar;
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            nVar = b;
        }
        return nVar;
    }

    public final void a(int i2, int i3) {
        w.a().a(new a(1004, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f A[Catch: all -> 0x0053, Exception -> 0x0055, TRY_ENTER, TryCatch #4 {Exception -> 0x0055, blocks: (B:7:0x0006, B:11:0x002d, B:21:0x0046, B:27:0x004f, B:28:0x0052), top: B:36:0x0006, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized <T extends java.util.List<?>> void a(int r5, T r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            android.content.Context r2 = r4.c     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.lang.String r3 = "crashrecord"
            java.io.File r2 = r2.getDir(r3, r0)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r3.<init>()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r3.append(r5)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.lang.String r5 = r3.toString()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r1.<init>(r2, r5)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r5 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L37
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L37
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L37
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L37
            r2.writeObject(r6)     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L4c
            r2.close()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            goto L5c
        L31:
            r5 = move-exception
            goto L3a
        L33:
            r6 = move-exception
            r2 = r5
            r5 = r6
            goto L4d
        L37:
            r6 = move-exception
            r2 = r5
            r5 = r6
        L3a:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L4c
            java.lang.String r5 = "open record file error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4c
            com.tencent.bugly.proguard.x.a(r5, r6)     // Catch: java.lang.Throwable -> L4c
            if (r2 == 0) goto L4a
            r2.close()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            goto L5c
        L4a:
            monitor-exit(r4)
            return
        L4c:
            r5 = move-exception
        L4d:
            if (r2 == 0) goto L52
            r2.close()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
        L52:
            throw r5     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
        L53:
            r5 = move-exception
            goto L5e
        L55:
            java.lang.String r5 = "writeCrashRecord error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L53
            com.tencent.bugly.proguard.x.e(r5, r6)     // Catch: java.lang.Throwable -> L53
        L5c:
            monitor-exit(r4)
            return
        L5e:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.n.a(int, java.util.List):void");
    }

    public final synchronized boolean a(int i2) {
        boolean z;
        z = true;
        try {
            SharedPreferences sharedPreferences = this.f7992f;
            z = sharedPreferences.getBoolean(i2 + "_" + this.f7990d, true);
            w.a().a(new b(i2));
        } catch (Exception unused) {
            x.e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
