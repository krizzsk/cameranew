package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
class c {
    protected f b;

    /* renamed from: e  reason: collision with root package name */
    protected String f8397e;
    protected r a = null;
    protected Context c = null;

    /* renamed from: d  reason: collision with root package name */
    protected String f8396d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, f fVar) {
        this.b = null;
        this.f8397e = "";
        this.f8397e = str;
        this.b = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportError(String str) {
        f fVar = this.b;
        if (fVar != null) {
            fVar.reportError(this.f8397e + " Error [" + this.f8396d + "]", str);
            return;
        }
        g.Log(6, this.f8397e + " Error [" + this.f8396d + "]: " + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runOnUiThread(Runnable runnable) {
        Context context = this.c;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
            return;
        }
        g.Log(5, "Not running " + this.f8397e + " from an Activity; Ignoring execution request...");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean runOnUiThreadWithSync(final Runnable runnable) {
        boolean z = true;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
            return true;
        }
        final Semaphore semaphore = new Semaphore(0);
        runOnUiThread(new Runnable() { // from class: com.unity3d.player.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    try {
                        runnable.run();
                    } catch (Exception e2) {
                        c cVar = c.this;
                        cVar.reportError("Exception unloading Google VR on UI Thread. " + e2.getLocalizedMessage());
                    }
                } finally {
                    semaphore.release();
                }
            }
        });
        try {
            if (!semaphore.tryAcquire(4L, TimeUnit.SECONDS)) {
                reportError("Timeout waiting for vr state change!");
                z = false;
            }
            return z;
        } catch (InterruptedException e2) {
            reportError("Interrupted while trying to acquire sync lock. " + e2.getLocalizedMessage());
            return false;
        }
    }
}
