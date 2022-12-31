package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import androidx.work.WorkRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class u {
    private static u a;
    private final Context c;

    /* renamed from: e  reason: collision with root package name */
    private long f8008e;

    /* renamed from: f  reason: collision with root package name */
    private long f8009f;

    /* renamed from: d  reason: collision with root package name */
    private Map<Integer, Long> f8007d = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f8010g = new LinkedBlockingQueue<>();

    /* renamed from: h  reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f8011h = new LinkedBlockingQueue<>();

    /* renamed from: i  reason: collision with root package name */
    private final Object f8012i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private int f8013j = 0;
    private final p b = p.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public final class a implements Runnable {
        private /* synthetic */ Runnable a;

        a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.run();
            synchronized (u.this.f8012i) {
                u.b(u.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public final class b implements Runnable {
        private /* synthetic */ int a;
        private /* synthetic */ LinkedBlockingQueue b;

        b(u uVar, int i2, LinkedBlockingQueue linkedBlockingQueue) {
            this.a = i2;
            this.b = linkedBlockingQueue;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable runnable;
            for (int i2 = 0; i2 < this.a && (runnable = (Runnable) this.b.poll()) != null; i2++) {
                runnable.run();
            }
        }
    }

    private u(Context context) {
        this.c = context;
    }

    static /* synthetic */ int b(u uVar) {
        int i2 = uVar.f8013j - 1;
        uVar.f8013j = i2;
        return i2;
    }

    private void c(int i2) {
        w a2 = w.a();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.f8012i) {
            x.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            int size = this.f8010g.size();
            int size2 = this.f8011h.size();
            if (size == 0 && size2 == 0) {
                x.c("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            size2 = (a2 == null || !a2.c()) ? 0 : 0;
            for (int i3 = 0; i3 < size; i3++) {
                Runnable peek = this.f8010g.peek();
                if (peek == null) {
                    break;
                }
                linkedBlockingQueue.put(peek);
                this.f8010g.poll();
            }
            for (int i4 = 0; i4 < size2; i4++) {
                Runnable peek2 = this.f8011h.peek();
                if (peek2 == null) {
                    break;
                }
                linkedBlockingQueue2.put(peek2);
                this.f8011h.poll();
            }
            if (size > 0) {
                x.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            for (int i5 = 0; i5 < size; i5++) {
                Runnable runnable = (Runnable) linkedBlockingQueue.poll();
                if (runnable == null) {
                    break;
                }
                synchronized (this.f8012i) {
                    if (this.f8013j >= 2 && a2 != null) {
                        a2.a(runnable);
                    } else {
                        x.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                        if (z.a(new a(runnable), "BUGLY_ASYNC_UPLOAD") != null) {
                            synchronized (this.f8012i) {
                                this.f8013j++;
                            }
                        } else {
                            x.d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new Object[0]);
                            a(runnable, true);
                        }
                    }
                }
            }
            if (size2 > 0) {
                x.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            if (a2 != null) {
                a2.a(new b(this, size2, linkedBlockingQueue2));
            }
        }
    }

    public static synchronized u a(Context context) {
        u uVar;
        synchronized (u.class) {
            if (a == null) {
                a = new u(context);
            }
            uVar = a;
        }
        return uVar;
    }

    public final boolean b(int i2) {
        if (com.tencent.bugly.b.c) {
            x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i2);
        x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i2));
        if (currentTimeMillis < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            x.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
            return false;
        }
        return true;
    }

    public static synchronized u a() {
        u uVar;
        synchronized (u.class) {
            uVar = a;
        }
        return uVar;
    }

    public final void a(int i2, am amVar, String str, String str2, t tVar, long j2, boolean z) {
        try {
            try {
                a(new v(this.c, i2, amVar.f7939g, com.tencent.bugly.proguard.a.a((Object) amVar), str, str2, tVar, true, z), true, true, j2);
            } catch (Throwable th) {
                th = th;
                if (x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void a(int i2, am amVar, String str, String str2, t tVar, boolean z) {
        try {
            try {
                a(new v(this.c, i2, amVar.f7939g, com.tencent.bugly.proguard.a.a((Object) amVar), str, str2, tVar, 0, 0, false, null), z, false, 0L);
            } catch (Throwable th) {
                th = th;
                if (x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final long a(boolean z) {
        long j2;
        long b2 = z.b();
        int i2 = z ? 5 : 3;
        List<r> a2 = this.b.a(i2);
        if (a2 != null && a2.size() > 0) {
            j2 = 0;
            try {
                r rVar = a2.get(0);
                if (rVar.f8004e >= b2) {
                    j2 = z.b(rVar.f8006g);
                    if (i2 == 3) {
                        this.f8008e = j2;
                    } else {
                        this.f8009f = j2;
                    }
                    a2.remove(rVar);
                }
            } catch (Throwable th) {
                x.a(th);
            }
            if (a2.size() > 0) {
                this.b.a(a2);
            }
        } else {
            j2 = z ? this.f8009f : this.f8008e;
        }
        x.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j2 / 1024));
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void a(long j2, boolean z) {
        int i2 = z ? 5 : 3;
        r rVar = new r();
        rVar.b = i2;
        rVar.f8004e = z.b();
        rVar.c = "";
        rVar.f8003d = "";
        rVar.f8006g = z.c(j2);
        this.b.b(i2);
        this.b.a(rVar);
        if (z) {
            this.f8009f = j2;
        } else {
            this.f8008e = j2;
        }
        x.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j2 / 1024));
    }

    public final synchronized void a(int i2, long j2) {
        if (i2 < 0) {
            x.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i2));
            return;
        }
        this.f8007d.put(Integer.valueOf(i2), Long.valueOf(j2));
        r rVar = new r();
        rVar.b = i2;
        rVar.f8004e = j2;
        rVar.c = "";
        rVar.f8003d = "";
        rVar.f8006g = new byte[0];
        this.b.b(i2);
        this.b.a(rVar);
        x.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i2), z.a(j2));
    }

    public final synchronized long a(int i2) {
        if (i2 >= 0) {
            Long l2 = this.f8007d.get(Integer.valueOf(i2));
            if (l2 != null) {
                return l2.longValue();
            }
        } else {
            x.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i2));
        }
        return 0L;
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            x.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f8012i) {
                if (z) {
                    this.f8010g.put(runnable);
                } else {
                    this.f8011h.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            x.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, boolean z, boolean z2, long j2) {
        if (runnable == null) {
            x.d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (!z2) {
            a(runnable, z);
            c(0);
        } else if (runnable == null) {
            x.d("[UploadManager] Upload task should not be null", new Object[0]);
        } else {
            x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            Thread a2 = z.a(runnable, "BUGLY_SYNC_UPLOAD");
            if (a2 == null) {
                x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
                a(runnable, true);
                return;
            }
            try {
                a2.join(j2);
            } catch (Throwable th) {
                x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
                a(runnable, true);
                c(0);
            }
        }
    }
}
