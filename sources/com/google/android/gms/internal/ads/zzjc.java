package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzjc extends zzlv implements zzpk {
    private int zzaho;
    private int zzahq;
    private final zzik zzamm;
    private final zzit zzamn;
    private boolean zzamo;
    private boolean zzamp;
    private MediaFormat zzamq;
    private long zzamr;
    private boolean zzams;

    public zzjc(zzlx zzlxVar, Handler handler, zzil zzilVar) {
        this(zzlxVar, null, true, handler, zzilVar);
    }

    private final boolean zzax(String str) {
        return false;
    }

    public static void zzb(int i2, long j2, long j3) {
    }

    public static void zzgd() {
    }

    public static void zzx(int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhy
    public final boolean isReady() {
        return this.zzamn.zzfr() || super.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzhe {
        int[] iArr;
        int i2;
        MediaFormat mediaFormat2 = this.zzamq;
        boolean z = mediaFormat2 != null;
        String string = z ? mediaFormat2.getString(IMediaFormat.KEY_MIME) : "audio/raw";
        if (z) {
            mediaFormat = this.zzamq;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.zzamp && integer == 6 && (i2 = this.zzaho) < 6) {
            iArr = new int[i2];
            for (int i3 = 0; i3 < this.zzaho; i3++) {
                iArr[i3] = i3;
            }
        } else {
            iArr = null;
        }
        try {
            this.zzamn.zza(string, integer, integer2, this.zzahq, 0, iArr);
        } catch (zzix e2) {
            throw zzhe.zza(e2, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void onStarted() {
        super.onStarted();
        this.zzamn.play();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void onStopped() {
        this.zzamn.pause();
        super.onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final int zza(zzlx zzlxVar, zzht zzhtVar) throws zzmd {
        int i2;
        int i3;
        String str = zzhtVar.zzahe;
        boolean z = false;
        if (zzpj.zzbc(str)) {
            int i4 = zzpt.SDK_INT;
            int i5 = i4 >= 21 ? 16 : 0;
            if (!zzax(str) || zzlxVar.zzhj() == null) {
                zzlw zzc = zzlxVar.zzc(str, false);
                if (zzc == null) {
                    return 1;
                }
                if (i4 < 21 || (((i2 = zzhtVar.zzahp) == -1 || zzc.zzaw(i2)) && ((i3 = zzhtVar.zzaho) == -1 || zzc.zzax(i3)))) {
                    z = true;
                }
                return i5 | 4 | (z ? 3 : 2);
            }
            return i5 | 4 | 3;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzpk
    public final zzhz zzb(zzhz zzhzVar) {
        return this.zzamn.zzb(zzhzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void zzc(String str, long j2, long j3) {
        this.zzamm.zza(str, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzd(zzht zzhtVar) throws zzhe {
        super.zzd(zzhtVar);
        this.zzamm.zzb(zzhtVar);
        this.zzahq = "audio/raw".equals(zzhtVar.zzahe) ? zzhtVar.zzahq : 2;
        this.zzaho = zzhtVar.zzaho;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void zze(boolean z) throws zzhe {
        super.zze(z);
        this.zzamm.zza(this.zzbcq);
        int i2 = zzei().zzaif;
        this.zzamn.zzft();
    }

    @Override // com.google.android.gms.internal.ads.zzhd, com.google.android.gms.internal.ads.zzhy
    public final zzpk zzea() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void zzeh() {
        try {
            this.zzamn.release();
            try {
                super.zzeh();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.zzeh();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhy
    public final boolean zzfe() {
        return super.zzfe() && this.zzamn.zzfe();
    }

    @Override // com.google.android.gms.internal.ads.zzpk
    public final zzhz zzfs() {
        return this.zzamn.zzfs();
    }

    @Override // com.google.android.gms.internal.ads.zzpk
    public final long zzgc() {
        long zzj = this.zzamn.zzj(zzfe());
        if (zzj != Long.MIN_VALUE) {
            if (!this.zzams) {
                zzj = Math.max(this.zzamr, zzj);
            }
            this.zzamr = zzj;
            this.zzams = false;
        }
        return this.zzamr;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void zzge() throws zzhe {
        try {
            this.zzamn.zzfp();
        } catch (zzjb e2) {
            throw zzhe.zza(e2, getIndex());
        }
    }

    private zzjc(zzlx zzlxVar, zzjt<zzjv> zzjtVar, boolean z, Handler handler, zzil zzilVar) {
        this(zzlxVar, null, true, handler, zzilVar, null, new zzij[0]);
    }

    private zzjc(zzlx zzlxVar, zzjt<zzjv> zzjtVar, boolean z, Handler handler, zzil zzilVar, zzig zzigVar, zzij... zzijVarArr) {
        super(1, zzlxVar, null, true);
        this.zzamn = new zzit(null, zzijVarArr, new zzje(this));
        this.zzamm = new zzik(handler, zzilVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv
    public final zzlw zza(zzlx zzlxVar, zzht zzhtVar, boolean z) throws zzmd {
        zzlw zzhj;
        if (zzax(zzhtVar.zzahe) && (zzhj = zzlxVar.zzhj()) != null) {
            this.zzamo = true;
            return zzhj;
        }
        this.zzamo = false;
        return super.zza(zzlxVar, zzhtVar, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0059  */
    @Override // com.google.android.gms.internal.ads.zzlv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zza(com.google.android.gms.internal.ads.zzlw r4, android.media.MediaCodec r5, com.google.android.gms.internal.ads.zzht r6, android.media.MediaCrypto r7) {
        /*
            r3 = this;
            java.lang.String r4 = r4.name
            int r7 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            r0 = 0
            r1 = 24
            if (r7 >= r1) goto L37
            java.lang.String r7 = "OMX.SEC.aac.dec"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L37
            java.lang.String r4 = com.google.android.gms.internal.ads.zzpt.MANUFACTURER
            java.lang.String r7 = "samsung"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L37
            java.lang.String r4 = com.google.android.gms.internal.ads.zzpt.DEVICE
            java.lang.String r7 = "zeroflte"
            boolean r7 = r4.startsWith(r7)
            if (r7 != 0) goto L35
            java.lang.String r7 = "herolte"
            boolean r7 = r4.startsWith(r7)
            if (r7 != 0) goto L35
            java.lang.String r7 = "heroqlte"
            boolean r4 = r4.startsWith(r7)
            if (r4 == 0) goto L37
        L35:
            r4 = 1
            goto L38
        L37:
            r4 = 0
        L38:
            r3.zzamp = r4
            boolean r4 = r3.zzamo
            r7 = 0
            if (r4 == 0) goto L59
            android.media.MediaFormat r4 = r6.zzfa()
            r3.zzamq = r4
            java.lang.String r1 = "mime"
            java.lang.String r2 = "audio/raw"
            r4.setString(r1, r2)
            android.media.MediaFormat r4 = r3.zzamq
            r5.configure(r4, r7, r7, r0)
            android.media.MediaFormat r4 = r3.zzamq
            java.lang.String r5 = r6.zzahe
            r4.setString(r1, r5)
            return
        L59:
            android.media.MediaFormat r4 = r6.zzfa()
            r5.configure(r4, r7, r7, r0)
            r3.zzamq = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjc.zza(com.google.android.gms.internal.ads.zzlw, android.media.MediaCodec, com.google.android.gms.internal.ads.zzht, android.media.MediaCrypto):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void zza(long j2, boolean z) throws zzhe {
        super.zza(j2, z);
        this.zzamn.reset();
        this.zzamr = j2;
        this.zzams = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final boolean zza(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) throws zzhe {
        if (this.zzamo && (i3 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i2, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i2, false);
            this.zzbcq.zzaoe++;
            this.zzamn.zzfo();
            return true;
        } else {
            try {
                if (this.zzamn.zzb(byteBuffer, j4)) {
                    mediaCodec.releaseOutputBuffer(i2, false);
                    this.zzbcq.zzaod++;
                    return true;
                }
                return false;
            } catch (zziw | zzjb e2) {
                throw zzhe.zza(e2, getIndex());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhd, com.google.android.gms.internal.ads.zzhj
    public final void zza(int i2, Object obj) throws zzhe {
        if (i2 == 2) {
            this.zzamn.setVolume(((Float) obj).floatValue());
        } else if (i2 != 3) {
            super.zza(i2, obj);
        } else {
            this.zzamn.setStreamType(((Integer) obj).intValue());
        }
    }
}
