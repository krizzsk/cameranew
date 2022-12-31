package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzpb;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes2.dex */
public final class zzpc<T extends zzpb> extends Handler implements Runnable {
    private volatile boolean zzafw;
    private final T zzbjl;
    private final zzoz<T> zzbjm;
    public final int zzbjn;
    private final long zzbjo;
    private IOException zzbjp;
    private int zzbjq;
    private volatile Thread zzbjr;
    private final /* synthetic */ zzpa zzbjs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpc(zzpa zzpaVar, Looper looper, T t, zzoz<T> zzozVar, int i2, long j2) {
        super(looper);
        this.zzbjs = zzpaVar;
        this.zzbjl = t;
        this.zzbjm = zzozVar;
        this.zzbjn = i2;
        this.zzbjo = j2;
    }

    private final void execute() {
        ExecutorService executorService;
        zzpc zzpcVar;
        this.zzbjp = null;
        executorService = this.zzbjs.zzbji;
        zzpcVar = this.zzbjs.zzbjj;
        executorService.execute(zzpcVar);
    }

    private final void finish() {
        this.zzbjs.zzbjj = null;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzafw) {
            return;
        }
        int i2 = message.what;
        if (i2 == 0) {
            execute();
        } else if (i2 != 4) {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = elapsedRealtime - this.zzbjo;
            if (this.zzbjl.zzhx()) {
                this.zzbjm.zza((zzoz<T>) this.zzbjl, elapsedRealtime, j2, false);
                return;
            }
            int i3 = message.what;
            if (i3 == 1) {
                this.zzbjm.zza((zzoz<T>) this.zzbjl, elapsedRealtime, j2, false);
            } else if (i3 == 2) {
                this.zzbjm.zza(this.zzbjl, elapsedRealtime, j2);
            } else if (i3 != 3) {
            } else {
                IOException iOException = (IOException) message.obj;
                this.zzbjp = iOException;
                int zza = this.zzbjm.zza((zzoz<T>) this.zzbjl, elapsedRealtime, j2, iOException);
                if (zza == 3) {
                    this.zzbjs.zzbjk = this.zzbjp;
                } else if (zza != 2) {
                    int i4 = zza == 1 ? 1 : this.zzbjq + 1;
                    this.zzbjq = i4;
                    zzek(Math.min((i4 - 1) * 1000, 5000));
                }
            }
        } else {
            throw ((Error) message.obj);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzbjr = Thread.currentThread();
            if (!this.zzbjl.zzhx()) {
                String valueOf = String.valueOf(this.zzbjl.getClass().getSimpleName());
                zzpu.beginSection(valueOf.length() != 0 ? "load:".concat(valueOf) : new String("load:"));
                try {
                    this.zzbjl.zzhy();
                    zzpu.endSection();
                } catch (Throwable th) {
                    zzpu.endSection();
                    throw th;
                }
            }
            if (this.zzafw) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e2) {
            if (this.zzafw) {
                return;
            }
            obtainMessage(3, e2).sendToTarget();
        } catch (Exception e3) {
            Log.e("LoadTask", "Unexpected exception loading stream", e3);
            if (this.zzafw) {
                return;
            }
            obtainMessage(3, new zzpe(e3)).sendToTarget();
        } catch (OutOfMemoryError e4) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e4);
            if (this.zzafw) {
                return;
            }
            obtainMessage(3, new zzpe(e4)).sendToTarget();
        } catch (Error e5) {
            Log.e("LoadTask", "Unexpected error loading stream", e5);
            if (!this.zzafw) {
                obtainMessage(4, e5).sendToTarget();
            }
            throw e5;
        } catch (InterruptedException unused) {
            zzpg.checkState(this.zzbjl.zzhx());
            if (this.zzafw) {
                return;
            }
            sendEmptyMessage(2);
        }
    }

    public final void zzbg(int i2) throws IOException {
        IOException iOException = this.zzbjp;
        if (iOException != null && this.zzbjq > i2) {
            throw iOException;
        }
    }

    public final void zzek(long j2) {
        zzpc zzpcVar;
        zzpcVar = this.zzbjs.zzbjj;
        zzpg.checkState(zzpcVar == null);
        this.zzbjs.zzbjj = this;
        if (j2 > 0) {
            sendEmptyMessageDelayed(0, j2);
        } else {
            execute();
        }
    }

    public final void zzl(boolean z) {
        this.zzafw = z;
        this.zzbjp = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.zzbjl.cancelLoad();
            if (this.zzbjr != null) {
                this.zzbjr.interrupt();
            }
        }
        if (z) {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbjm.zza((zzoz<T>) this.zzbjl, elapsedRealtime, elapsedRealtime - this.zzbjo, true);
        }
    }
}
