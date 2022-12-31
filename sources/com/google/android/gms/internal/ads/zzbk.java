package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import us.pinguo.common.network.HttpRequest;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzbk extends zzab<String> {
    private final Object mLock;
    @Nullable
    @GuardedBy("mLock")
    private zzai<String> zzcy;

    public zzbk(int i2, String str, zzai<String> zzaiVar, @Nullable zzaj zzajVar) {
        super(i2, str, zzajVar);
        this.mLock = new Object();
        this.zzcy = zzaiVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzab
    public final zzag<String> zza(zzz zzzVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzzVar.data;
            Map<String, String> map = zzzVar.zzaj;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = map.get(HttpRequest.HEADER_CONTENT_TYPE)) != null) {
                String[] split = str2.split(";", 0);
                int i2 = 1;
                while (true) {
                    if (i2 >= split.length) {
                        break;
                    }
                    String[] split2 = split[i2].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals(HttpRequest.PARAM_CHARSET)) {
                        str3 = split2[1];
                        break;
                    }
                    i2++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzzVar.data);
        }
        return zzag.zza(str, zzbc.zzb(zzzVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzab
    /* renamed from: zzi */
    public void zza(String str) {
        zzai<String> zzaiVar;
        synchronized (this.mLock) {
            zzaiVar = this.zzcy;
        }
        if (zzaiVar != null) {
            zzaiVar.zzb(str);
        }
    }
}
