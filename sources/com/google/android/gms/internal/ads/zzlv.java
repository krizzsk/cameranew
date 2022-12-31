package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@RequiresApi(19)
@TargetApi(19)
/* loaded from: classes2.dex */
public abstract class zzlv extends zzhd {
    private static final byte[] zzbbg = zzpt.zzbi("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private zzht zzahz;
    private ByteBuffer[] zzalh;
    private final zzlx zzbbh;
    private final zzjt<zzjv> zzbbi;
    private final boolean zzbbj;
    private final zzjp zzbbk;
    private final zzjp zzbbl;
    private final zzhv zzbbm;
    private final List<Long> zzbbn;
    private final MediaCodec.BufferInfo zzbbo;
    private zzjr<zzjv> zzbbp;
    private zzjr<zzjv> zzbbq;
    private MediaCodec zzbbr;
    private zzlw zzbbs;
    private boolean zzbbt;
    private boolean zzbbu;
    private boolean zzbbv;
    private boolean zzbbw;
    private boolean zzbbx;
    private boolean zzbby;
    private boolean zzbbz;
    private boolean zzbca;
    private boolean zzbcb;
    private ByteBuffer[] zzbcc;
    private long zzbcd;
    private int zzbce;
    private int zzbcf;
    private boolean zzbcg;
    private boolean zzbch;
    private int zzbci;
    private int zzbcj;
    private boolean zzbck;
    private boolean zzbcl;
    private boolean zzbcm;
    private boolean zzbcn;
    private boolean zzbco;
    private boolean zzbcp;
    protected zzjm zzbcq;

    public zzlv(int i2, zzlx zzlxVar, zzjt<zzjv> zzjtVar, boolean z) {
        super(i2);
        zzpg.checkState(zzpt.SDK_INT >= 16);
        this.zzbbh = (zzlx) zzpg.checkNotNull(zzlxVar);
        this.zzbbi = null;
        this.zzbbj = z;
        this.zzbbk = new zzjp(0);
        this.zzbbl = new zzjp(0);
        this.zzbbm = new zzhv();
        this.zzbbn = new ArrayList();
        this.zzbbo = new MediaCodec.BufferInfo();
        this.zzbci = 0;
        this.zzbcj = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0145 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzhg() throws com.google.android.gms.internal.ads.zzhe {
        /*
            Method dump skipped, instructions count: 463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlv.zzhg():boolean");
    }

    private final void zzhh() throws zzhe {
        if (this.zzbcj == 2) {
            zzhf();
            zzhc();
            return;
        }
        this.zzbcn = true;
        zzge();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public boolean isReady() {
        if (this.zzahz == null || this.zzbco) {
            return false;
        }
        if (zzej() || this.zzbcf >= 0) {
            return true;
        }
        return this.zzbcd != -9223372036854775807L && SystemClock.elapsedRealtime() < this.zzbcd;
    }

    protected void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzhe {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhd
    public void onStarted() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhd
    public void onStopped() {
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public final int zza(zzht zzhtVar) throws zzhe {
        try {
            return zza(this.zzbbh, zzhtVar);
        } catch (zzmd e2) {
            throw zzhe.zza(e2, getIndex());
        }
    }

    protected abstract int zza(zzlx zzlxVar, zzht zzhtVar) throws zzmd;

    protected void zza(zzjp zzjpVar) {
    }

    protected abstract void zza(zzlw zzlwVar, MediaCodec mediaCodec, zzht zzhtVar, MediaCrypto mediaCrypto) throws zzmd;

    protected abstract boolean zza(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) throws zzhe;

    protected boolean zza(MediaCodec mediaCodec, boolean z, zzht zzhtVar, zzht zzhtVar2) {
        return false;
    }

    protected boolean zza(zzlw zzlwVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzb(long j2, long j3) throws zzhe {
        if (this.zzbcn) {
            zzge();
            return;
        }
        if (this.zzahz == null) {
            this.zzbbl.clear();
            int zza = zza(this.zzbbm, this.zzbbl, true);
            if (zza != -5) {
                if (zza == -4) {
                    zzpg.checkState(this.zzbbl.zzgi());
                    this.zzbcm = true;
                    zzhh();
                    return;
                }
                return;
            }
            zzd(this.zzbbm.zzahz);
        }
        zzhc();
        if (this.zzbbr != null) {
            zzpu.beginSection("drainAndFeed");
            do {
            } while (zzd(j2, j3));
            do {
            } while (zzhg());
            zzpu.endSection();
        } else {
            zzdn(j2);
            this.zzbbl.clear();
            int zza2 = zza(this.zzbbm, this.zzbbl, false);
            if (zza2 == -5) {
                zzd(this.zzbbm.zzahz);
            } else if (zza2 == -4) {
                zzpg.checkState(this.zzbbl.zzgi());
                this.zzbcm = true;
                zzhh();
            }
        }
        this.zzbcq.zzgn();
    }

    protected void zzc(String str, long j2, long j3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
        if (r5.height == r0.height) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void zzd(com.google.android.gms.internal.ads.zzht r5) throws com.google.android.gms.internal.ads.zzhe {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzht r0 = r4.zzahz
            r4.zzahz = r5
            com.google.android.gms.internal.ads.zzjo r5 = r5.zzahh
            r1 = 0
            if (r0 != 0) goto Lb
            r2 = r1
            goto Ld
        Lb:
            com.google.android.gms.internal.ads.zzjo r2 = r0.zzahh
        Ld:
            boolean r5 = com.google.android.gms.internal.ads.zzpt.zza(r5, r2)
            r2 = 1
            r5 = r5 ^ r2
            if (r5 == 0) goto L49
            com.google.android.gms.internal.ads.zzht r5 = r4.zzahz
            com.google.android.gms.internal.ads.zzjo r5 = r5.zzahh
            if (r5 == 0) goto L47
            com.google.android.gms.internal.ads.zzjt<com.google.android.gms.internal.ads.zzjv> r5 = r4.zzbbi
            if (r5 == 0) goto L37
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.google.android.gms.internal.ads.zzht r3 = r4.zzahz
            com.google.android.gms.internal.ads.zzjo r3 = r3.zzahh
            com.google.android.gms.internal.ads.zzjr r5 = r5.zza(r1, r3)
            r4.zzbbq = r5
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r1 = r4.zzbbp
            if (r5 != r1) goto L49
            com.google.android.gms.internal.ads.zzjt<com.google.android.gms.internal.ads.zzjv> r1 = r4.zzbbi
            r1.zza(r5)
            goto L49
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r5.<init>(r0)
            int r0 = r4.getIndex()
            com.google.android.gms.internal.ads.zzhe r5 = com.google.android.gms.internal.ads.zzhe.zza(r5, r0)
            throw r5
        L47:
            r4.zzbbq = r1
        L49:
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r5 = r4.zzbbq
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r1 = r4.zzbbp
            if (r5 != r1) goto L7a
            android.media.MediaCodec r5 = r4.zzbbr
            if (r5 == 0) goto L7a
            com.google.android.gms.internal.ads.zzlw r1 = r4.zzbbs
            boolean r1 = r1.zzbcr
            com.google.android.gms.internal.ads.zzht r3 = r4.zzahz
            boolean r5 = r4.zza(r5, r1, r0, r3)
            if (r5 == 0) goto L7a
            r4.zzbch = r2
            r4.zzbci = r2
            boolean r5 = r4.zzbbv
            if (r5 == 0) goto L76
            com.google.android.gms.internal.ads.zzht r5 = r4.zzahz
            int r1 = r5.width
            int r3 = r0.width
            if (r1 != r3) goto L76
            int r5 = r5.height
            int r0 = r0.height
            if (r5 != r0) goto L76
            goto L77
        L76:
            r2 = 0
        L77:
            r4.zzbca = r2
            return
        L7a:
            boolean r5 = r4.zzbck
            if (r5 == 0) goto L81
            r4.zzbcj = r2
            return
        L81:
            r4.zzhf()
            r4.zzhc()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlv.zzd(com.google.android.gms.internal.ads.zzht):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhd
    public void zze(boolean z) throws zzhe {
        this.zzbcq = new zzjm();
    }

    @Override // com.google.android.gms.internal.ads.zzhd, com.google.android.gms.internal.ads.zzib
    public final int zzeg() {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhd
    public void zzeh() {
        this.zzahz = null;
        try {
            zzhf();
            try {
                zzjr<zzjv> zzjrVar = this.zzbbp;
                if (zzjrVar != null) {
                    this.zzbbi.zza(zzjrVar);
                }
                try {
                    zzjr<zzjv> zzjrVar2 = this.zzbbq;
                    if (zzjrVar2 != null && zzjrVar2 != this.zzbbp) {
                        this.zzbbi.zza(zzjrVar2);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    zzjr<zzjv> zzjrVar3 = this.zzbbq;
                    if (zzjrVar3 != null && zzjrVar3 != this.zzbbp) {
                        this.zzbbi.zza(zzjrVar3);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.zzbbp != null) {
                    this.zzbbi.zza(this.zzbbp);
                }
                try {
                    zzjr<zzjv> zzjrVar4 = this.zzbbq;
                    if (zzjrVar4 != null && zzjrVar4 != this.zzbbp) {
                        this.zzbbi.zza(zzjrVar4);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    zzjr<zzjv> zzjrVar5 = this.zzbbq;
                    if (zzjrVar5 != null && zzjrVar5 != this.zzbbp) {
                        this.zzbbi.zza(zzjrVar5);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public boolean zzfe() {
        return this.zzbcn;
    }

    protected void zzge() throws zzhe {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(28:24|(1:114)(1:30)|31|(1:113)(1:45)|46|(2:52|(18:60|61|(1:111)(1:67)|68|(1:110)(1:72)|73|(1:102)(1:77)|78|(1:101)(1:84)|85|86|87|(1:89)(1:98)|90|91|(1:93)(1:96)|94|95))|112|61|(2:63|65)|111|68|(1:70)|110|73|(1:75)|102|78|(1:80)|101|85|86|87|(0)(0)|90|91|(0)(0)|94|95) */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01d5, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01d6, code lost:
        zza(new com.google.android.gms.internal.ads.zzly(r11.zzahz, (java.lang.Throwable) r1, false, r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0184 A[Catch: Exception -> 0x01d5, TryCatch #1 {Exception -> 0x01d5, blocks: (B:109:0x0174, B:111:0x0184, B:113:0x018f, B:112:0x0189), top: B:125:0x0174 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0189 A[Catch: Exception -> 0x01d5, TryCatch #1 {Exception -> 0x01d5, blocks: (B:109:0x0174, B:111:0x0184, B:113:0x018f, B:112:0x0189), top: B:125:0x0174 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzhc() throws com.google.android.gms.internal.ads.zzhe {
        /*
            Method dump skipped, instructions count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlv.zzhc():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaCodec zzhd() {
        return this.zzbbr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzlw zzhe() {
        return this.zzbbs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzhf() {
        this.zzbcd = -9223372036854775807L;
        this.zzbce = -1;
        this.zzbcf = -1;
        this.zzbco = false;
        this.zzbcg = false;
        this.zzbbn.clear();
        this.zzbcc = null;
        this.zzalh = null;
        this.zzbbs = null;
        this.zzbch = false;
        this.zzbck = false;
        this.zzbbt = false;
        this.zzbbu = false;
        this.zzbbv = false;
        this.zzbbw = false;
        this.zzbbx = false;
        this.zzbbz = false;
        this.zzbca = false;
        this.zzbcb = false;
        this.zzbcl = false;
        this.zzbci = 0;
        this.zzbcj = 0;
        this.zzbbk.zzdr = null;
        MediaCodec mediaCodec = this.zzbbr;
        if (mediaCodec != null) {
            this.zzbcq.zzaob++;
            try {
                mediaCodec.stop();
                try {
                    this.zzbbr.release();
                    this.zzbbr = null;
                    zzjr<zzjv> zzjrVar = this.zzbbp;
                    if (zzjrVar == null || this.zzbbq == zzjrVar) {
                        return;
                    }
                    try {
                        this.zzbbi.zza(zzjrVar);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.zzbbr = null;
                    zzjr<zzjv> zzjrVar2 = this.zzbbp;
                    if (zzjrVar2 != null && this.zzbbq != zzjrVar2) {
                        try {
                            this.zzbbi.zza(zzjrVar2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.zzbbr.release();
                    this.zzbbr = null;
                    zzjr<zzjv> zzjrVar3 = this.zzbbp;
                    if (zzjrVar3 != null && this.zzbbq != zzjrVar3) {
                        try {
                            this.zzbbi.zza(zzjrVar3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.zzbbr = null;
                    zzjr<zzjv> zzjrVar4 = this.zzbbp;
                    if (zzjrVar4 != null && this.zzbbq != zzjrVar4) {
                        try {
                            this.zzbbi.zza(zzjrVar4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzlw zza(zzlx zzlxVar, zzht zzhtVar, boolean z) throws zzmd {
        return zzlxVar.zzc(zzhtVar.zzahe, z);
    }

    private final void zza(zzly zzlyVar) throws zzhe {
        throw zzhe.zza(zzlyVar, getIndex());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhd
    public void zza(long j2, boolean z) throws zzhe {
        this.zzbcm = false;
        this.zzbcn = false;
        if (this.zzbbr != null) {
            this.zzbcd = -9223372036854775807L;
            this.zzbce = -1;
            this.zzbcf = -1;
            this.zzbcp = true;
            this.zzbco = false;
            this.zzbcg = false;
            this.zzbbn.clear();
            this.zzbca = false;
            this.zzbcb = false;
            if (!this.zzbbu && (!this.zzbbx || !this.zzbcl)) {
                if (this.zzbcj != 0) {
                    zzhf();
                    zzhc();
                } else {
                    this.zzbbr.flush();
                    this.zzbck = false;
                }
            } else {
                zzhf();
                zzhc();
            }
            if (!this.zzbch || this.zzahz == null) {
                return;
            }
            this.zzbci = 1;
        }
    }

    private final boolean zzd(long j2, long j3) throws zzhe {
        boolean zza;
        boolean z;
        if (this.zzbcf < 0) {
            if (this.zzbby && this.zzbcl) {
                try {
                    this.zzbcf = this.zzbbr.dequeueOutputBuffer(this.zzbbo, 0L);
                } catch (IllegalStateException unused) {
                    zzhh();
                    if (this.zzbcn) {
                        zzhf();
                    }
                    return false;
                }
            } else {
                this.zzbcf = this.zzbbr.dequeueOutputBuffer(this.zzbbo, 0L);
            }
            int i2 = this.zzbcf;
            if (i2 < 0) {
                if (i2 != -2) {
                    if (i2 == -3) {
                        this.zzalh = this.zzbbr.getOutputBuffers();
                        return true;
                    }
                    if (this.zzbbw && (this.zzbcm || this.zzbcj == 2)) {
                        zzhh();
                    }
                    return false;
                }
                MediaFormat outputFormat = this.zzbbr.getOutputFormat();
                if (this.zzbbv && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.zzbcb = true;
                } else {
                    if (this.zzbbz) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.zzbbr, outputFormat);
                }
                return true;
            } else if (this.zzbcb) {
                this.zzbcb = false;
                this.zzbbr.releaseOutputBuffer(i2, false);
                this.zzbcf = -1;
                return true;
            } else {
                MediaCodec.BufferInfo bufferInfo = this.zzbbo;
                if ((bufferInfo.flags & 4) != 0) {
                    zzhh();
                    this.zzbcf = -1;
                    return false;
                }
                ByteBuffer byteBuffer = this.zzalh[i2];
                if (byteBuffer != null) {
                    byteBuffer.position(bufferInfo.offset);
                    MediaCodec.BufferInfo bufferInfo2 = this.zzbbo;
                    byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                }
                long j4 = this.zzbbo.presentationTimeUs;
                int size = this.zzbbn.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        z = false;
                        break;
                    } else if (this.zzbbn.get(i3).longValue() == j4) {
                        this.zzbbn.remove(i3);
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                this.zzbcg = z;
            }
        }
        if (this.zzbby && this.zzbcl) {
            try {
                MediaCodec mediaCodec = this.zzbbr;
                ByteBuffer[] byteBufferArr = this.zzalh;
                int i4 = this.zzbcf;
                ByteBuffer byteBuffer2 = byteBufferArr[i4];
                MediaCodec.BufferInfo bufferInfo3 = this.zzbbo;
                zza = zza(j2, j3, mediaCodec, byteBuffer2, i4, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.zzbcg);
            } catch (IllegalStateException unused2) {
                zzhh();
                if (this.zzbcn) {
                    zzhf();
                }
                return false;
            }
        } else {
            MediaCodec mediaCodec2 = this.zzbbr;
            ByteBuffer[] byteBufferArr2 = this.zzalh;
            int i5 = this.zzbcf;
            ByteBuffer byteBuffer3 = byteBufferArr2[i5];
            MediaCodec.BufferInfo bufferInfo4 = this.zzbbo;
            zza = zza(j2, j3, mediaCodec2, byteBuffer3, i5, bufferInfo4.flags, bufferInfo4.presentationTimeUs, this.zzbcg);
        }
        if (zza) {
            long j5 = this.zzbbo.presentationTimeUs;
            this.zzbcf = -1;
            return true;
        }
        return false;
    }
}
