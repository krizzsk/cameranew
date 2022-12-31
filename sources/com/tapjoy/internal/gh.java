package com.tapjoy.internal;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class gh extends gg {
    private final ThreadPoolExecutor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        private int b;
        private long c;

        /* renamed from: d  reason: collision with root package name */
        private String f7577d;

        /* renamed from: e  reason: collision with root package name */
        private String f7578e;

        /* renamed from: f  reason: collision with root package name */
        private Map f7579f;

        a(int i2, long j2, String str, String str2, Map map) {
            this.b = i2;
            this.c = j2;
            this.f7577d = str;
            this.f7578e = str2;
            this.f7579f = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                int i2 = this.b;
                if (i2 == 1) {
                    gh.super.a(this.c);
                } else if (i2 == 2) {
                    gh.super.a();
                } else if (i2 != 3) {
                } else {
                    gh.super.a(this.c, this.f7577d, this.f7578e, this.f7579f);
                }
            } catch (Throwable unused) {
                gh.super.a();
            }
        }
    }

    public gh(File file, gy gyVar) {
        super(file, gyVar);
        this.b = new ThreadPoolExecutor(0, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    @Override // com.tapjoy.internal.gg
    protected final void finalize() {
        try {
            this.b.shutdown();
            this.b.awaitTermination(1L, TimeUnit.SECONDS);
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.gg, com.tapjoy.internal.gf
    public final void a(long j2) {
        try {
            this.b.execute(new a(1, j2, null, null, null));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.gg, com.tapjoy.internal.gf
    public final void a() {
        try {
            this.b.execute(new a(2, 0L, null, null, null));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.gg, com.tapjoy.internal.gf
    public final void a(long j2, String str, String str2, Map map) {
        try {
            this.b.execute(new a(3, j2, str, str2, map != null ? new HashMap(map) : null));
        } catch (Throwable unused) {
        }
    }
}
