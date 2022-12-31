package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcx extends zzcw<Integer, Object> {
    public String zznn;
    public long zzno;
    public String zznp;
    public String zznq;
    public String zznr;

    public zzcx(String str) {
        this();
        zzam(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcw
    public final void zzam(String str) {
        HashMap zzan = zzcw.zzan(str);
        if (zzan != null) {
            Object obj = zzan.get(0);
            String str2 = ExifInterface.LONGITUDE_EAST;
            this.zznn = obj == null ? ExifInterface.LONGITUDE_EAST : (String) zzan.get(0);
            this.zzno = zzan.get(1) == null ? -1L : ((Long) zzan.get(1)).longValue();
            this.zznp = zzan.get(2) == null ? ExifInterface.LONGITUDE_EAST : (String) zzan.get(2);
            this.zznq = zzan.get(3) == null ? ExifInterface.LONGITUDE_EAST : (String) zzan.get(3);
            if (zzan.get(4) != null) {
                str2 = (String) zzan.get(4);
            }
            this.zznr = str2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    protected final HashMap<Integer, Object> zzbn() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zznn);
        hashMap.put(4, this.zznr);
        hashMap.put(3, this.zznq);
        hashMap.put(2, this.zznp);
        hashMap.put(1, Long.valueOf(this.zzno));
        return hashMap;
    }

    public zzcx() {
        this.zznn = ExifInterface.LONGITUDE_EAST;
        this.zzno = -1L;
        this.zznp = ExifInterface.LONGITUDE_EAST;
        this.zznq = ExifInterface.LONGITUDE_EAST;
        this.zznr = ExifInterface.LONGITUDE_EAST;
    }
}
