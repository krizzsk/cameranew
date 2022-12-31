package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzazn;
import com.google.android.gms.internal.ads.zzazp;
import com.google.android.gms.internal.ads.zzcv;
import com.google.android.gms.internal.ads.zzds;
import com.google.android.gms.internal.ads.zzdsy;
import com.google.android.gms.internal.ads.zzdue;
import com.google.android.gms.internal.ads.zzdux;
import com.google.android.gms.internal.ads.zzdva;
import com.google.android.gms.internal.ads.zzdy;
import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzwr;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzf implements zzdy, Runnable {

    /* renamed from: d  reason: collision with root package name */
    private int f3501d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f3502e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f3503f;

    /* renamed from: g  reason: collision with root package name */
    private final Executor f3504g;

    /* renamed from: h  reason: collision with root package name */
    private final zzdsy f3505h;

    /* renamed from: i  reason: collision with root package name */
    private Context f3506i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f3507j;

    /* renamed from: k  reason: collision with root package name */
    private zzazn f3508k;

    /* renamed from: l  reason: collision with root package name */
    private final zzazn f3509l;
    private final List<Object[]> a = new Vector();
    private final AtomicReference<zzdy> b = new AtomicReference<>();
    private final AtomicReference<zzdy> c = new AtomicReference<>();
    private CountDownLatch m = new CountDownLatch(1);

    public zzf(Context context, zzazn zzaznVar) {
        this.f3506i = context;
        this.f3507j = context;
        this.f3508k = zzaznVar;
        this.f3509l = zzaznVar;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        this.f3504g = newCachedThreadPool;
        zzdsy zza = zzdsy.zza(context, newCachedThreadPool);
        this.f3505h = zza;
        this.f3503f = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcrs)).booleanValue();
        int intValue = ((Integer) zzwr.zzqr().zzd(zzabp.zzcru)).intValue();
        if (intValue != 1 && intValue != 2) {
            this.f3501d = zzcv.zznj;
        } else {
            this.f3501d = zzcv.zznk;
        }
        zzdue zzdueVar = new zzdue(this.f3506i, zza);
        c cVar = new c(this);
        this.f3502e = new zzdux(this.f3506i, zzdueVar.zzayg(), cVar, ((Boolean) zzwr.zzqr().zzd(zzabp.zzcrt)).booleanValue()).zzek(zzdva.zzhut);
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcsj)).booleanValue()) {
            zzazp.zzeic.execute(this);
            return;
        }
        zzwr.zzqn();
        if (zzaza.zzzx()) {
            zzazp.zzeic.execute(this);
        } else {
            run();
        }
    }

    private final void c(zzdy zzdyVar) {
        this.b.set(zzdyVar);
    }

    @Nullable
    private final zzdy f() {
        if (j() == zzcv.zznk) {
            return this.c.get();
        }
        return this.b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context g(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private final boolean h() {
        try {
            this.m.await();
            return true;
        } catch (InterruptedException e2) {
            zzazk.zzd("Interrupted during GADSignals creation.", e2);
            return false;
        }
    }

    private final void i() {
        zzdy f2 = f();
        if (this.a.isEmpty() || f2 == null) {
            return;
        }
        for (Object[] objArr : this.a) {
            if (objArr.length == 1) {
                f2.zza((MotionEvent) objArr[0]);
            } else if (objArr.length == 3) {
                f2.zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.a.clear();
    }

    private final int j() {
        if (this.f3503f && !this.f3502e) {
            return zzcv.zznj;
        }
        return this.f3501d;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, com.google.android.gms.internal.ads.zzazn] */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.f3508k.zzeia;
            if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcpp)).booleanValue() && z2) {
                z = true;
            }
            if (j() == zzcv.zznj) {
                c(zzef.zzb(this.f3508k.zzbrp, g(this.f3506i), z, this.f3501d));
                if (this.f3501d == zzcv.zznk) {
                    this.f3504g.execute(new b(this, z));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    this.c.set(zzds.zza(this.f3508k.zzbrp, g(this.f3506i), z));
                } catch (NullPointerException e2) {
                    this.f3501d = zzcv.zznj;
                    c(zzef.zzb(this.f3508k.zzbrp, g(this.f3506i), z, this.f3501d));
                    this.f3505h.zza(2031, System.currentTimeMillis() - currentTimeMillis, e2);
                }
            }
        } finally {
            this.m.countDown();
            this.f3506i = null;
            this.f3508k = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, View view, Activity activity) {
        zzdy f2 = f();
        return f2 != null ? f2.zza(context, view, activity) : "";
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zzb(Context context) {
        zzdy f2;
        if (!h() || (f2 = f()) == null) {
            return "";
        }
        i();
        return f2.zzb(g(context));
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, String str, View view, Activity activity) {
        zzdy f2;
        if (!h() || (f2 = f()) == null) {
            return "";
        }
        i();
        return f2.zza(g(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zzb(View view) {
        zzdy f2 = f();
        if (f2 != null) {
            f2.zzb(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zza(MotionEvent motionEvent) {
        zzdy f2 = f();
        if (f2 != null) {
            i();
            f2.zza(motionEvent);
            return;
        }
        this.a.add(new Object[]{motionEvent});
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zza(int i2, int i3, int i4) {
        zzdy f2 = f();
        if (f2 != null) {
            i();
            f2.zza(i2, i3, i4);
            return;
        }
        this.a.add(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }
}
