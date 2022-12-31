package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class zzegy extends zzelb<zzegy, zza> implements zzemq {
    private static volatile zzemx<zzegy> zzek;
    private static final zzegy zziis;
    private String zziiq = "";
    private zzell<zzegk> zziir = zzelb.zzbin();

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzegy, zza> implements zzemq {
        private zza() {
            super(zzegy.zziis);
        }

        /* synthetic */ zza(zzeha zzehaVar) {
            this();
        }
    }

    static {
        zzegy zzegyVar = new zzegy();
        zziis = zzegyVar;
        zzelb.zza(zzegy.class, zzegyVar);
    }

    private zzegy() {
    }

    public static zzegy zzbfk() {
        return zziis;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzeha.zzel[i2 - 1]) {
            case 1:
                return new zzegy();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziis, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zziiq", "zziir", zzegk.class});
            case 4:
                return zziis;
            case 5:
                zzemx<zzegy> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzegy.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziis);
                            zzek = zzemxVar;
                        }
                    }
                }
                return zzemxVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final List<zzegk> zzbfj() {
        return this.zziir;
    }
}
