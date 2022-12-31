package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.f;
import com.tapjoy.TapjoyConstants;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class zzbdd implements f {
    protected Context mContext;
    protected String zzegw;
    protected WeakReference<zzbbo> zzepn;

    public zzbdd(zzbbo zzbboVar) {
        this.mContext = zzbboVar.getContext();
        this.zzegw = com.google.android.gms.ads.internal.zzr.zzkr().zzq(this.mContext, zzbboVar.zzabj().zzbrp);
        this.zzepn = new WeakReference<>(zzbboVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzfi(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1947652542:
                if (str.equals("interrupted")) {
                    c = 0;
                    break;
                }
                break;
            case -1396664534:
                if (str.equals("badUrl")) {
                    c = 1;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c = 3;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c = 4;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c = 5;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c = 6;
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c = 7;
                    break;
                }
                break;
            case 3387234:
                if (str.equals("noop")) {
                    c = '\b';
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = '\t';
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c = '\n';
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 4:
            case 5:
            case '\b':
            case '\t':
            default:
                return TapjoyConstants.LOG_LEVEL_INTERNAL;
            case 1:
            case 3:
                return "network";
            case 6:
            case 7:
                return "policy";
            case '\n':
            case 11:
                return "io";
        }
    }

    public abstract void abort();

    @Override // com.google.android.gms.common.api.f
    public void release() {
    }

    public final void zza(String str, String str2, long j2, long j3, boolean z, long j4, long j5, long j6, int i2, int i3) {
        zzaza.zzaac.post(new zzbdf(this, str, str2, j2, j3, j4, j5, j6, z, i2, i3));
    }

    public final void zzc(String str, String str2, long j2) {
        zzaza.zzaac.post(new zzbdk(this, str, str2, j2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzdk(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzdl(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzdm(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzdn(int i2) {
    }

    public boolean zze(String str, String[] strArr) {
        return zzfg(str);
    }

    public abstract boolean zzfg(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public String zzfh(String str) {
        return zzaza.zzeq(str);
    }

    public final void zza(String str, String str2, int i2, int i3, long j2, long j3, boolean z, int i4, int i5) {
        zzaza.zzaac.post(new zzbdi(this, str, str2, i2, i3, j2, j3, z, i4, i5));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(String str, String str2, int i2) {
        zzaza.zzaac.post(new zzbdh(this, str, str2, i2));
    }

    public final void zza(String str, String str2, String str3, @Nullable String str4) {
        zzaza.zzaac.post(new zzbdj(this, str, str2, str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, Map<String, String> map) {
        zzbbo zzbboVar = this.zzepn.get();
        if (zzbboVar != null) {
            zzbboVar.zza(str, map);
        }
    }
}
