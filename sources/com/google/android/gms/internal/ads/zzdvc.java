package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.facebook.ads.AdError;
import com.tencent.matrix.trace.constants.Constants;
import com.tencent.stat.DeviceInfo;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdvc {
    private static final HashMap<String, Class<?>> zzhux = new HashMap<>();
    private final Context context;
    private final zzdvb zzhuj;
    private final zzdsx zzhuy;
    @Nullable
    private zzduq zzhuz;
    private final Object zzhva = new Object();
    private final zzdsy zzvs;

    public zzdvc(@NonNull Context context, @NonNull zzdvb zzdvbVar, @NonNull zzdsy zzdsyVar, @NonNull zzdsx zzdsxVar) {
        this.context = context;
        this.zzhuj = zzdvbVar;
        this.zzvs = zzdsyVar;
        this.zzhuy = zzdsxVar;
    }

    private final synchronized Class<?> zza(@NonNull zzdup zzdupVar) throws zzduz {
        if (zzdupVar.zzayk() != null) {
            String zzdg = zzdupVar.zzayk().zzdg();
            HashMap<String, Class<?>> hashMap = zzhux;
            Class<?> cls = hashMap.get(zzdg);
            if (cls != null) {
                return cls;
            }
            try {
                if (this.zzhuy.zzb(zzdupVar.zzayl())) {
                    try {
                        File zzaym = zzdupVar.zzaym();
                        if (!zzaym.exists()) {
                            zzaym.mkdirs();
                        }
                        Class loadClass = new DexClassLoader(zzdupVar.zzayl().getAbsolutePath(), zzaym.getAbsolutePath(), null, this.context.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                        hashMap.put(zzdg, loadClass);
                        return loadClass;
                    } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e2) {
                        throw new zzduz((int) AdError.REMOTE_ADS_SERVICE_ERROR, e2);
                    }
                }
                throw new zzduz(2026, "VM did not pass signature verification");
            } catch (GeneralSecurityException e3) {
                throw new zzduz(2026, e3);
            }
        }
        throw new zzduz(4010, DeviceInfo.TAG_MAC);
    }

    @Nullable
    public final zzdte zzayv() {
        zzduq zzduqVar;
        synchronized (this.zzhva) {
            zzduqVar = this.zzhuz;
        }
        return zzduqVar;
    }

    @Nullable
    public final zzdup zzayw() {
        synchronized (this.zzhva) {
            zzduq zzduqVar = this.zzhuz;
            if (zzduqVar != null) {
                return zzduqVar.zzayo();
            }
            return null;
        }
    }

    public final void zzb(@NonNull zzdup zzdupVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzduq zzduqVar = new zzduq(zza(zza(zzdupVar), zzdupVar), zzdupVar, this.zzhuj, this.zzvs);
            if (zzduqVar.zzayp()) {
                int zzayq = zzduqVar.zzayq();
                if (zzayq == 0) {
                    synchronized (this.zzhva) {
                        zzduq zzduqVar2 = this.zzhuz;
                        if (zzduqVar2 != null) {
                            try {
                                zzduqVar2.close();
                            } catch (zzduz e2) {
                                this.zzvs.zza(e2.zzayu(), -1L, e2);
                            }
                        }
                        this.zzhuz = zzduqVar;
                    }
                    this.zzvs.zzh(PathInterpolatorCompat.MAX_NUM_POINTS, System.currentTimeMillis() - currentTimeMillis);
                    return;
                }
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(zzayq);
                throw new zzduz(4001, sb.toString());
            }
            throw new zzduz((int) Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM, "init failed");
        } catch (zzduz e3) {
            this.zzvs.zza(e3.zzayu(), System.currentTimeMillis() - currentTimeMillis, e3);
        } catch (Exception e4) {
            this.zzvs.zza(4010, System.currentTimeMillis() - currentTimeMillis, e4);
        }
    }

    private final Object zza(@NonNull Class<?> cls, @NonNull zzdup zzdupVar) throws zzduz {
        try {
            return cls.getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.context, "msa-r", zzdupVar.zzayn(), null, new Bundle(), 2);
        } catch (Exception e2) {
            throw new zzduz((int) AdError.INTERNAL_ERROR_2004, e2);
        }
    }
}
