package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.work.WorkRequest;
import java.nio.ByteBuffer;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzqe extends zzlv {
    private static final int[] zzbld = {1920, 1600, 1440, 1280, 960, 854, VideoEdit2Activity.MIN_SCALED_SIZE, 540, 480};
    private final Context context;
    private int zzaif;
    private boolean zzalq;
    private final zzqi zzble;
    private final zzqj zzblf;
    private final long zzblg;
    private final int zzblh;
    private final boolean zzbli;
    private final long[] zzblj;
    private zzht[] zzblk;
    private zzqg zzbll;
    private Surface zzblm;
    private Surface zzbln;
    private int zzblo;
    private boolean zzblp;
    private long zzblq;
    private long zzblr;
    private int zzbls;
    private int zzblt;
    private int zzblu;
    private float zzblv;
    private int zzblw;
    private int zzblx;
    private int zzbly;
    private float zzblz;
    private int zzbma;
    private int zzbmb;
    private int zzbmc;
    private float zzbmd;
    zzqf zzbme;
    private long zzbmf;
    private int zzbmg;

    public zzqe(Context context, zzlx zzlxVar, long j2, Handler handler, zzqk zzqkVar, int i2) {
        this(context, zzlxVar, 0L, null, false, handler, zzqkVar, -1);
    }

    private final void zzb(MediaCodec mediaCodec, int i2, long j2) {
        zzjm();
        zzpu.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, true);
        zzpu.endSection();
        this.zzbcq.zzaod++;
        this.zzblt = 0;
        zzjk();
    }

    private static boolean zzem(long j2) {
        return j2 < -30000;
    }

    private static int zzi(zzht zzhtVar) {
        int i2 = zzhtVar.zzahf;
        return i2 != -1 ? i2 : zza(zzhtVar.zzahe, zzhtVar.width, zzhtVar.height);
    }

    private static int zzj(zzht zzhtVar) {
        int i2 = zzhtVar.zzahj;
        if (i2 == -1) {
            return 0;
        }
        return i2;
    }

    private final void zzji() {
        this.zzblq = -9223372036854775807L;
    }

    private final void zzjj() {
        MediaCodec zzhd;
        this.zzblp = false;
        if (zzpt.SDK_INT < 23 || !this.zzalq || (zzhd = zzhd()) == null) {
            return;
        }
        this.zzbme = new zzqf(this, zzhd);
    }

    private final void zzjl() {
        this.zzbma = -1;
        this.zzbmb = -1;
        this.zzbmd = -1.0f;
        this.zzbmc = -1;
    }

    private final void zzjm() {
        int i2 = this.zzbma;
        int i3 = this.zzblw;
        if (i2 == i3 && this.zzbmb == this.zzblx && this.zzbmc == this.zzbly && this.zzbmd == this.zzblz) {
            return;
        }
        this.zzblf.zza(i3, this.zzblx, this.zzbly, this.zzblz);
        this.zzbma = this.zzblw;
        this.zzbmb = this.zzblx;
        this.zzbmc = this.zzbly;
        this.zzbmd = this.zzblz;
    }

    private final void zzjn() {
        if (this.zzbma == -1 && this.zzbmb == -1) {
            return;
        }
        this.zzblf.zza(this.zzblw, this.zzblx, this.zzbly, this.zzblz);
    }

    private final void zzjo() {
        if (this.zzbls > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzblf.zzf(this.zzbls, elapsedRealtime - this.zzblr);
            this.zzbls = 0;
            this.zzblr = elapsedRealtime;
        }
    }

    private final boolean zzn(boolean z) {
        if (zzpt.SDK_INT < 23 || this.zzalq) {
            return false;
        }
        return !z || zzqa.zzc(this.context);
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhy
    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.zzblp || (((surface = this.zzbln) != null && this.zzblm == surface) || zzhd() == null))) {
            this.zzblq = -9223372036854775807L;
            return true;
        } else if (this.zzblq == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzblq) {
                return true;
            }
            this.zzblq = -9223372036854775807L;
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.zzblw = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.zzblx = integer2;
        float f2 = this.zzblv;
        this.zzblz = f2;
        if (zzpt.SDK_INT >= 21) {
            int i2 = this.zzblu;
            if (i2 == 90 || i2 == 270) {
                int i3 = this.zzblw;
                this.zzblw = integer2;
                this.zzblx = i3;
                this.zzblz = 1.0f / f2;
            }
        } else {
            this.zzbly = this.zzblu;
        }
        mediaCodec.setVideoScalingMode(this.zzblo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void onStarted() {
        super.onStarted();
        this.zzbls = 0;
        this.zzblr = SystemClock.elapsedRealtime();
        this.zzblq = -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void onStopped() {
        zzjo();
        super.onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final int zza(zzlx zzlxVar, zzht zzhtVar) throws zzmd {
        boolean z;
        int i2;
        int i3;
        String str = zzhtVar.zzahe;
        if (zzpj.zzbd(str)) {
            zzjo zzjoVar = zzhtVar.zzahh;
            if (zzjoVar != null) {
                z = false;
                for (int i4 = 0; i4 < zzjoVar.zzaoj; i4++) {
                    z |= zzjoVar.zzac(i4).zzaon;
                }
            } else {
                z = false;
            }
            zzlw zzc = zzlxVar.zzc(str, z);
            if (zzc == null) {
                return 1;
            }
            boolean zzaz = zzc.zzaz(zzhtVar.zzahb);
            if (zzaz && (i2 = zzhtVar.width) > 0 && (i3 = zzhtVar.height) > 0) {
                if (zzpt.SDK_INT >= 21) {
                    zzaz = zzc.zza(i2, i3, zzhtVar.zzahi);
                } else {
                    boolean z2 = i2 * i3 <= zzlz.zzhk();
                    if (!z2) {
                        int i5 = zzhtVar.width;
                        int i6 = zzhtVar.height;
                        String str2 = zzpt.zzbkn;
                        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                        sb.append("FalseCheck [legacyFrameSize, ");
                        sb.append(i5);
                        sb.append("x");
                        sb.append(i6);
                        sb.append("] [");
                        sb.append(str2);
                        sb.append("]");
                        Log.d("MediaCodecVideoRenderer", sb.toString());
                    }
                    zzaz = z2;
                }
            }
            return (zzaz ? 3 : 2) | (zzc.zzbcr ? 8 : 4) | (zzc.zzalq ? 16 : 0);
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void zzc(String str, long j2, long j3) {
        this.zzblf.zza(str, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzd(zzht zzhtVar) throws zzhe {
        super.zzd(zzhtVar);
        this.zzblf.zzb(zzhtVar);
        float f2 = zzhtVar.zzahk;
        if (f2 == -1.0f) {
            f2 = 1.0f;
        }
        this.zzblv = f2;
        this.zzblu = zzj(zzhtVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void zze(boolean z) throws zzhe {
        super.zze(z);
        int i2 = zzei().zzaif;
        this.zzaif = i2;
        this.zzalq = i2 != 0;
        this.zzblf.zza(this.zzbcq);
        this.zzble.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void zzeh() {
        this.zzblw = -1;
        this.zzblx = -1;
        this.zzblz = -1.0f;
        this.zzblv = -1.0f;
        this.zzbmf = -9223372036854775807L;
        this.zzbmg = 0;
        zzjl();
        zzjj();
        this.zzble.disable();
        this.zzbme = null;
        this.zzalq = false;
        try {
            super.zzeh();
        } finally {
            this.zzbcq.zzgn();
            this.zzblf.zzb(this.zzbcq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzhf() {
        try {
            super.zzhf();
            Surface surface = this.zzbln;
            if (surface != null) {
                if (this.zzblm == surface) {
                    this.zzblm = null;
                }
                surface.release();
                this.zzbln = null;
            }
        } catch (Throwable th) {
            if (this.zzbln != null) {
                Surface surface2 = this.zzblm;
                Surface surface3 = this.zzbln;
                if (surface2 == surface3) {
                    this.zzblm = null;
                }
                surface3.release();
                this.zzbln = null;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzjk() {
        if (this.zzblp) {
            return;
        }
        this.zzblp = true;
        this.zzblf.zza(this.zzblm);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzqe(Context context, zzlx zzlxVar, long j2, zzjt<zzjv> zzjtVar, boolean z, Handler handler, zzqk zzqkVar, int i2) {
        super(2, zzlxVar, null, false);
        boolean z2 = false;
        this.zzblg = 0L;
        this.zzblh = -1;
        this.context = context.getApplicationContext();
        this.zzble = new zzqi(context);
        this.zzblf = new zzqj(handler, zzqkVar);
        if (zzpt.SDK_INT <= 22 && "foster".equals(zzpt.DEVICE) && "NVIDIA".equals(zzpt.MANUFACTURER)) {
            z2 = true;
        }
        this.zzbli = z2;
        this.zzblj = new long[10];
        this.zzbmf = -9223372036854775807L;
        this.zzblq = -9223372036854775807L;
        this.zzblw = -1;
        this.zzblx = -1;
        this.zzblz = -1.0f;
        this.zzblv = -1.0f;
        this.zzblo = 1;
        zzjl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhd
    public final void zza(zzht[] zzhtVarArr, long j2) throws zzhe {
        this.zzblk = zzhtVarArr;
        if (this.zzbmf == -9223372036854775807L) {
            this.zzbmf = j2;
        } else {
            int i2 = this.zzbmg;
            long[] jArr = this.zzblj;
            if (i2 == jArr.length) {
                long j3 = jArr[i2 - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j3);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.zzbmg = i2 + 1;
            }
            this.zzblj[this.zzbmg - 1] = j2;
        }
        super.zza(zzhtVarArr, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void zza(long j2, boolean z) throws zzhe {
        super.zza(j2, z);
        zzjj();
        this.zzblt = 0;
        int i2 = this.zzbmg;
        if (i2 != 0) {
            this.zzbmf = this.zzblj[i2 - 1];
            this.zzbmg = 0;
        }
        if (z) {
            zzji();
        } else {
            this.zzblq = -9223372036854775807L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhd, com.google.android.gms.internal.ads.zzhj
    public final void zza(int i2, Object obj) throws zzhe {
        if (i2 != 1) {
            if (i2 == 4) {
                this.zzblo = ((Integer) obj).intValue();
                MediaCodec zzhd = zzhd();
                if (zzhd != null) {
                    zzhd.setVideoScalingMode(this.zzblo);
                    return;
                }
                return;
            }
            super.zza(i2, obj);
            return;
        }
        Surface surface = (Surface) obj;
        if (surface == null) {
            Surface surface2 = this.zzbln;
            if (surface2 != null) {
                surface = surface2;
            } else {
                zzlw zzhe = zzhe();
                if (zzhe != null && zzn(zzhe.zzbcs)) {
                    surface = zzqa.zzc(this.context, zzhe.zzbcs);
                    this.zzbln = surface;
                }
            }
        }
        if (this.zzblm != surface) {
            this.zzblm = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec zzhd2 = zzhd();
                if (zzpt.SDK_INT >= 23 && zzhd2 != null && surface != null) {
                    zzhd2.setOutputSurface(surface);
                } else {
                    zzhf();
                    zzhc();
                }
            }
            if (surface != null && surface != this.zzbln) {
                zzjn();
                zzjj();
                if (state == 2) {
                    zzji();
                    return;
                }
                return;
            }
            zzjl();
            zzjj();
        } else if (surface == null || surface == this.zzbln) {
        } else {
            zzjn();
            if (this.zzblp) {
                this.zzblf.zza(this.zzblm);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final boolean zza(zzlw zzlwVar) {
        return this.zzblm != null || zzn(zzlwVar.zzbcs);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void zza(zzlw zzlwVar, MediaCodec mediaCodec, zzht zzhtVar, MediaCrypto mediaCrypto) throws zzmd {
        zzqg zzqgVar;
        String str;
        Point point;
        zzht[] zzhtVarArr = this.zzblk;
        int i2 = zzhtVar.width;
        int i3 = zzhtVar.height;
        int zzi = zzi(zzhtVar);
        if (zzhtVarArr.length == 1) {
            zzqgVar = new zzqg(i2, i3, zzi);
        } else {
            boolean z = false;
            for (zzht zzhtVar2 : zzhtVarArr) {
                if (zza(zzlwVar.zzbcr, zzhtVar, zzhtVar2)) {
                    int i4 = zzhtVar2.width;
                    z |= i4 == -1 || zzhtVar2.height == -1;
                    i2 = Math.max(i2, i4);
                    i3 = Math.max(i3, zzhtVar2.height);
                    zzi = Math.max(zzi, zzi(zzhtVar2));
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i2);
                sb.append("x");
                sb.append(i3);
                String str2 = "MediaCodecVideoRenderer";
                Log.w("MediaCodecVideoRenderer", sb.toString());
                int i5 = zzhtVar.height;
                int i6 = zzhtVar.width;
                boolean z2 = i5 > i6;
                int i7 = z2 ? i5 : i6;
                if (z2) {
                    i5 = i6;
                }
                float f2 = i5 / i7;
                int[] iArr = zzbld;
                int length = iArr.length;
                int i8 = 0;
                while (i8 < length) {
                    int i9 = length;
                    int i10 = iArr[i8];
                    int[] iArr2 = iArr;
                    int i11 = (int) (i10 * f2);
                    if (i10 <= i7 || i11 <= i5) {
                        break;
                    }
                    int i12 = i5;
                    float f3 = f2;
                    if (zzpt.SDK_INT >= 21) {
                        int i13 = z2 ? i11 : i10;
                        if (!z2) {
                            i10 = i11;
                        }
                        point = zzlwVar.zzd(i13, i10);
                        str = str2;
                        if (zzlwVar.zza(point.x, point.y, zzhtVar.zzahi)) {
                            break;
                        }
                        i8++;
                        length = i9;
                        iArr = iArr2;
                        i5 = i12;
                        f2 = f3;
                        str2 = str;
                    } else {
                        str = str2;
                        int zzf = zzpt.zzf(i10, 16) << 4;
                        int zzf2 = zzpt.zzf(i11, 16) << 4;
                        if (zzf * zzf2 <= zzlz.zzhk()) {
                            int i14 = z2 ? zzf2 : zzf;
                            if (!z2) {
                                zzf = zzf2;
                            }
                            point = new Point(i14, zzf);
                        } else {
                            i8++;
                            length = i9;
                            iArr = iArr2;
                            i5 = i12;
                            f2 = f3;
                            str2 = str;
                        }
                    }
                }
                str = str2;
                point = null;
                if (point != null) {
                    i2 = Math.max(i2, point.x);
                    i3 = Math.max(i3, point.y);
                    zzi = Math.max(zzi, zza(zzhtVar.zzahe, i2, i3));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i2);
                    sb2.append("x");
                    sb2.append(i3);
                    Log.w(str, sb2.toString());
                }
            }
            zzqgVar = new zzqg(i2, i3, zzi);
        }
        this.zzbll = zzqgVar;
        boolean z3 = this.zzbli;
        int i15 = this.zzaif;
        MediaFormat zzfa = zzhtVar.zzfa();
        zzfa.setInteger("max-width", zzqgVar.width);
        zzfa.setInteger("max-height", zzqgVar.height);
        int i16 = zzqgVar.zzbmi;
        if (i16 != -1) {
            zzfa.setInteger("max-input-size", i16);
        }
        if (z3) {
            zzfa.setInteger("auto-frc", 0);
        }
        if (i15 != 0) {
            zzfa.setFeatureEnabled("tunneled-playback", true);
            zzfa.setInteger("audio-session-id", i15);
        }
        if (this.zzblm == null) {
            zzpg.checkState(zzn(zzlwVar.zzbcs));
            if (this.zzbln == null) {
                this.zzbln = zzqa.zzc(this.context, zzlwVar.zzbcs);
            }
            this.zzblm = this.zzbln;
        }
        mediaCodec.configure(zzfa, this.zzblm, (MediaCrypto) null, 0);
        if (zzpt.SDK_INT < 23 || !this.zzalq) {
            return;
        }
        this.zzbme = new zzqf(this, mediaCodec);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void zza(zzjp zzjpVar) {
        if (zzpt.SDK_INT >= 23 || !this.zzalq) {
            return;
        }
        zzjk();
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final boolean zza(MediaCodec mediaCodec, boolean z, zzht zzhtVar, zzht zzhtVar2) {
        if (zza(z, zzhtVar, zzhtVar2)) {
            int i2 = zzhtVar2.width;
            zzqg zzqgVar = this.zzbll;
            return i2 <= zzqgVar.width && zzhtVar2.height <= zzqgVar.height && zzhtVar2.zzahf <= zzqgVar.zzbmi;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final boolean zza(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) {
        while (true) {
            int i4 = this.zzbmg;
            if (i4 == 0) {
                break;
            }
            long[] jArr = this.zzblj;
            if (j4 < jArr[0]) {
                break;
            }
            this.zzbmf = jArr[0];
            int i5 = i4 - 1;
            this.zzbmg = i5;
            System.arraycopy(jArr, 1, jArr, 0, i5);
        }
        long j5 = j4 - this.zzbmf;
        if (z) {
            zza(mediaCodec, i2, j5);
            return true;
        }
        long j6 = j4 - j2;
        if (this.zzblm == this.zzbln) {
            if (zzem(j6)) {
                zza(mediaCodec, i2, j5);
                return true;
            }
            return false;
        } else if (!this.zzblp) {
            if (zzpt.SDK_INT >= 21) {
                zza(mediaCodec, i2, j5, System.nanoTime());
            } else {
                zzb(mediaCodec, i2, j5);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j6 - ((SystemClock.elapsedRealtime() * 1000) - j3);
            long nanoTime = System.nanoTime();
            long zzf = this.zzble.zzf(j4, (elapsedRealtime * 1000) + nanoTime);
            long j7 = (zzf - nanoTime) / 1000;
            if (zzem(j7)) {
                zzpu.beginSection("dropVideoBuffer");
                mediaCodec.releaseOutputBuffer(i2, false);
                zzpu.endSection();
                zzjm zzjmVar = this.zzbcq;
                zzjmVar.zzaof++;
                this.zzbls++;
                int i6 = this.zzblt + 1;
                this.zzblt = i6;
                zzjmVar.zzaog = Math.max(i6, zzjmVar.zzaog);
                if (this.zzbls == this.zzblh) {
                    zzjo();
                }
                return true;
            }
            if (zzpt.SDK_INT >= 21) {
                if (j7 < 50000) {
                    zza(mediaCodec, i2, j5, zzf);
                    return true;
                }
            } else if (j7 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                if (j7 > 11000) {
                    try {
                        Thread.sleep((j7 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzb(mediaCodec, i2, j5);
                return true;
            }
            return false;
        }
    }

    private final void zza(MediaCodec mediaCodec, int i2, long j2) {
        zzpu.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        zzpu.endSection();
        this.zzbcq.zzaoe++;
    }

    @TargetApi(21)
    private final void zza(MediaCodec mediaCodec, int i2, long j2, long j3) {
        zzjm();
        zzpu.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, j3);
        zzpu.endSection();
        this.zzbcq.zzaod++;
        this.zzblt = 0;
        zzjk();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int zza(String str, int i2, int i3) {
        char c;
        int i4;
        if (i2 == -1 || i3 == -1) {
            return -1;
        }
        str.hashCode();
        int i5 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 4:
                i4 = i2 * i3;
                i5 = 2;
                break;
            case 1:
            case 5:
                i4 = i2 * i3;
                break;
            case 3:
                if (!"BRAVIA 4K 2015".equals(zzpt.MODEL)) {
                    i4 = ((zzpt.zzf(i2, 16) * zzpt.zzf(i3, 16)) << 4) << 4;
                    i5 = 2;
                    break;
                } else {
                    return -1;
                }
            default:
                return -1;
        }
        return (i4 * 3) / (i5 * 2);
    }

    private static boolean zza(boolean z, zzht zzhtVar, zzht zzhtVar2) {
        if (zzhtVar.zzahe.equals(zzhtVar2.zzahe) && zzj(zzhtVar) == zzj(zzhtVar2)) {
            if (z) {
                return true;
            }
            return zzhtVar.width == zzhtVar2.width && zzhtVar.height == zzhtVar2.height;
        }
        return false;
    }
}
