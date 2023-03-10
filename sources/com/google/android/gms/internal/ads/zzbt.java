package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.nio.ByteBuffer;
import java.util.Date;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbt extends zzepm {
    private Date zzdd;
    private Date zzde;
    private long zzdf;
    private long zzdg;
    private double zzdh;
    private float zzdi;
    private zzepw zzdj;
    private long zzdk;
    private int zzdl;
    private int zzdm;
    private int zzdn;
    private int zzdo;
    private int zzdp;
    private int zzdq;

    public zzbt() {
        super(MovieHeaderBox.TYPE);
        this.zzdh = 1.0d;
        this.zzdi = 1.0f;
        this.zzdj = zzepw.zzjbr;
    }

    public final long getDuration() {
        return this.zzdg;
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zzdd + ";modificationTime=" + this.zzde + ";timescale=" + this.zzdf + ";duration=" + this.zzdg + ";rate=" + this.zzdh + ";volume=" + this.zzdi + ";matrix=" + this.zzdj + ";nextTrackId=" + this.zzdk + "]";
    }

    @Override // com.google.android.gms.internal.ads.zzepk
    public final void zzl(ByteBuffer byteBuffer) {
        zzr(byteBuffer);
        if (getVersion() == 1) {
            this.zzdd = zzepp.zzfu(zzbp.zzh(byteBuffer));
            this.zzde = zzepp.zzfu(zzbp.zzh(byteBuffer));
            this.zzdf = zzbp.zzf(byteBuffer);
            this.zzdg = zzbp.zzh(byteBuffer);
        } else {
            this.zzdd = zzepp.zzfu(zzbp.zzf(byteBuffer));
            this.zzde = zzepp.zzfu(zzbp.zzf(byteBuffer));
            this.zzdf = zzbp.zzf(byteBuffer);
            this.zzdg = zzbp.zzf(byteBuffer);
        }
        this.zzdh = zzbp.zzi(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzdi = ((short) ((bArr[1] & Draft_75.END_OF_FRAME) | ((short) (0 | ((bArr[0] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))))) / 256.0f;
        zzbp.zzg(byteBuffer);
        zzbp.zzf(byteBuffer);
        zzbp.zzf(byteBuffer);
        this.zzdj = zzepw.zzs(byteBuffer);
        this.zzdl = byteBuffer.getInt();
        this.zzdm = byteBuffer.getInt();
        this.zzdn = byteBuffer.getInt();
        this.zzdo = byteBuffer.getInt();
        this.zzdp = byteBuffer.getInt();
        this.zzdq = byteBuffer.getInt();
        this.zzdk = zzbp.zzf(byteBuffer);
    }

    public final long zzr() {
        return this.zzdf;
    }
}
