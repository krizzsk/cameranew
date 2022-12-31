package com.bytedance.sdk.openadsdk.h.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.h.e;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public class c extends com.bytedance.sdk.openadsdk.h.a.a {
    public final File a;
    private final LinkedHashMap<String, File> b = new LinkedHashMap<>(0, 0.75f, true);
    private final ReentrantReadWriteLock c;

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantReadWriteLock.ReadLock f2001d;

    /* renamed from: e  reason: collision with root package name */
    private final ReentrantReadWriteLock.WriteLock f2002e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<a> f2003f;

    /* renamed from: g  reason: collision with root package name */
    private volatile long f2004g;

    /* renamed from: h  reason: collision with root package name */
    private volatile float f2005h;

    /* renamed from: i  reason: collision with root package name */
    private final b f2006i;

    /* renamed from: j  reason: collision with root package name */
    private final Executor f2007j;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f2008k;

    /* renamed from: l  reason: collision with root package name */
    private final Handler f2009l;

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str);

        void a(Set<String> set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public static final class b {
        private final Map<String, Integer> a;

        private b() {
            this.a = new HashMap();
        }

        synchronized void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.a.get(str);
                if (num == null) {
                    this.a.put(str, 1);
                } else {
                    this.a.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }

        synchronized void b(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.a.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.a.remove(str);
                } else {
                    this.a.put(str, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        synchronized boolean c(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.a.containsKey(str);
        }
    }

    public c(File file) throws IOException {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock;
        this.f2001d = reentrantReadWriteLock.readLock();
        this.f2002e = reentrantReadWriteLock.writeLock();
        this.f2003f = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f2004g = 104857600L;
        this.f2005h = 0.5f;
        this.f2006i = new b();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue(4), new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.h.a.c.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("DiskLruCache-cleanup-" + thread.getId());
                thread.setDaemon(true);
                return thread;
            }
        }, new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.h.a.c.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                if (e.c) {
                    Log.w("TAG_PROXY_DiskLruCache", "clean up command rejected!");
                }
            }
        });
        this.f2007j = threadPoolExecutor;
        this.f2008k = new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.f2007j.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVar = c.this;
                        cVar.b(cVar.f2004g);
                    }
                });
            }
        };
        this.f2009l = new Handler(Looper.getMainLooper());
        if (file != null && file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
            this.a = file;
            threadPoolExecutor.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b();
                }
            });
            return;
        }
        if (file == null) {
            str = " dir null";
        } else {
            str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
        }
        throw new IOException("dir error!  " + str);
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.a
    public File d(String str) {
        if (this.f2001d.tryLock()) {
            File file = this.b.get(str);
            this.f2001d.unlock();
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f2002e.lock();
        try {
            File[] listFiles = this.a.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                final HashMap hashMap = new HashMap(listFiles.length);
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file : listFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        hashMap.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bytedance.sdk.openadsdk.h.a.c.5
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file3) {
                        int i2 = ((((Long) hashMap.get(file2)).longValue() - ((Long) hashMap.get(file3)).longValue()) > 0L ? 1 : ((((Long) hashMap.get(file2)).longValue() - ((Long) hashMap.get(file3)).longValue()) == 0L ? 0 : -1));
                        if (i2 < 0) {
                            return -1;
                        }
                        return i2 > 0 ? 1 : 0;
                    }
                });
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    this.b.put(a(file2), file2);
                }
            }
            this.f2002e.unlock();
            c();
        } catch (Throwable th) {
            this.f2002e.unlock();
            throw th;
        }
    }

    private void c() {
        this.f2009l.removeCallbacks(this.f2008k);
        this.f2009l.postDelayed(this.f2008k, 10000L);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f2003f.add(aVar);
        }
    }

    public void a(long j2) {
        this.f2004g = j2;
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.a
    public File c(String str) {
        this.f2001d.lock();
        File file = this.b.get(str);
        this.f2001d.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.a, str);
        this.f2002e.lock();
        this.b.put(str, file2);
        this.f2002e.unlock();
        for (a aVar : this.f2003f) {
            aVar.a(str);
        }
        c();
        return file2;
    }

    public void a() {
        d.c().d();
        Context a2 = e.a();
        if (a2 != null) {
            com.bytedance.sdk.openadsdk.h.b.c.a(a2).a(0);
        }
        this.f2009l.removeCallbacks(this.f2008k);
        this.f2007j.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.c.6
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f2006i.a(str);
    }

    private String a(File file) {
        return file.getName();
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.a
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f2006i.b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e4 A[LOOP:3: B:41:0x00de->B:43:0x00e4, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(long r13) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.c.b(long):void");
    }
}
