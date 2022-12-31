package com.bytedance.sdk.adnet.core;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.concurrent.BlockingQueue;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkDispatcher.java */
/* loaded from: classes.dex */
public class h extends Thread {
    private final BlockingQueue<Request<?>> a;
    private final com.bytedance.sdk.adnet.face.b b;
    private final com.bytedance.sdk.adnet.face.a c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bytedance.sdk.adnet.face.c f1241d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f1242e = false;

    public h(BlockingQueue<Request<?>> blockingQueue, com.bytedance.sdk.adnet.face.b bVar, com.bytedance.sdk.adnet.face.a aVar, com.bytedance.sdk.adnet.face.c cVar) {
        this.a = blockingQueue;
        this.b = bVar;
        this.c = aVar;
        this.f1241d = cVar;
    }

    @TargetApi(14)
    private void b(Request<?> request) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
        }
    }

    public void a() {
        this.f1242e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f1242e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                o.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        a(this.a.take());
    }

    @VisibleForTesting
    void a(Request<?> request) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        request.a(3);
        try {
            try {
                request.addMarker("network-queue-take");
            } catch (VAdError e2) {
                e2.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                a(request, e2);
                request.e();
            } catch (Exception e3) {
                o.a(e3, "Unhandled exception %s", e3.toString());
                VAdError vAdError = new VAdError(e3);
                vAdError.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                this.f1241d.a(request, vAdError);
                request.e();
            }
            if (request.isCanceled()) {
                request.a("network-discard-cancelled");
                request.e();
                request.a(4);
                return;
            }
            b(request);
            i a = this.b.a(request);
            request.setNetDuration(a.f1245f);
            request.addMarker("network-http-complete");
            if (a.f1244e && request.hasHadResponseDelivered()) {
                request.a("not-modified");
                request.e();
                request.a(4);
                return;
            }
            m<?> a2 = request.a(a);
            request.setNetDuration(a.f1245f);
            request.addMarker("network-parse-complete");
            if (request.shouldCache() && a2.b != null) {
                this.c.a(request.getCacheKey(), a2.b);
                request.addMarker("network-cache-written");
            }
            request.markDelivered();
            this.f1241d.a(request, a2);
            request.b(a2);
            request.a(4);
        }
    }

    private void a(Request<?> request, VAdError vAdError) {
        this.f1241d.a(request, request.a(vAdError));
    }
}
