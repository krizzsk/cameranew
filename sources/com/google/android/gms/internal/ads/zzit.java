package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import androidx.work.WorkRequest;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzit {
    private static boolean zzajr = false;
    private static boolean zzajs = false;
    private int streamType;
    private zzhz zzafi;
    private int zzahp;
    private final zzja zzaju;
    private final zzjj zzajv;
    private final zzij[] zzajw;
    private final zziz zzajx;
    private final long[] zzajz;
    private final zziv zzaka;
    private final LinkedList<zziy> zzakb;
    private AudioTrack zzakc;
    private int zzakd;
    private int zzake;
    private int zzakf;
    private boolean zzakg;
    private int zzakh;
    private long zzaki;
    private zzhz zzakj;
    private long zzakk;
    private long zzakl;
    private ByteBuffer zzakm;
    private int zzakn;
    private int zzako;
    private int zzakp;
    private long zzakq;
    private long zzakr;
    private boolean zzaks;
    private long zzakt;
    private Method zzaku;
    private int zzakv;
    private long zzakw;
    private long zzakx;
    private int zzaky;
    private long zzakz;
    private long zzala;
    private int zzalb;
    private int zzalc;
    private long zzald;
    private long zzale;
    private long zzalf;
    private zzij[] zzalg;
    private ByteBuffer[] zzalh;
    private ByteBuffer zzali;
    private ByteBuffer zzalj;
    private byte[] zzalk;
    private int zzall;
    private int zzalm;
    private boolean zzaln;
    private boolean zzalo;
    private int zzalp;
    private boolean zzalq;
    private boolean zzalr;
    private long zzals;
    private float zzdi;
    private final zzig zzajt = null;
    private final ConditionVariable zzajy = new ConditionVariable(true);

    public zzit(zzig zzigVar, zzij[] zzijVarArr, zziz zzizVar) {
        this.zzajx = zzizVar;
        if (zzpt.SDK_INT >= 18) {
            try {
                this.zzaku = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzpt.SDK_INT >= 19) {
            this.zzaka = new zziu();
        } else {
            this.zzaka = new zziv(null);
        }
        zzja zzjaVar = new zzja();
        this.zzaju = zzjaVar;
        zzjj zzjjVar = new zzjj();
        this.zzajv = zzjjVar;
        zzij[] zzijVarArr2 = new zzij[zzijVarArr.length + 3];
        this.zzajw = zzijVarArr2;
        zzijVarArr2[0] = new zzjh();
        zzijVarArr2[1] = zzjaVar;
        System.arraycopy(zzijVarArr, 0, zzijVarArr2, 2, zzijVarArr.length);
        zzijVarArr2[zzijVarArr.length + 2] = zzjjVar;
        this.zzajz = new long[10];
        this.zzdi = 1.0f;
        this.zzalc = 0;
        this.streamType = 3;
        this.zzalp = 0;
        this.zzafi = zzhz.zzaia;
        this.zzalm = -1;
        this.zzalg = new zzij[0];
        this.zzalh = new ByteBuffer[0];
        this.zzakb = new LinkedList<>();
    }

    private final boolean isInitialized() {
        return this.zzakc != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d7, code lost:
        if (r11 < r10) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzc(java.nio.ByteBuffer r9, long r10) throws com.google.android.gms.internal.ads.zzjb {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzit.zzc(java.nio.ByteBuffer, long):boolean");
    }

    private final void zzdv(long j2) throws zzjb {
        ByteBuffer byteBuffer;
        int length = this.zzalg.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.zzalh[i2 - 1];
            } else {
                byteBuffer = this.zzali;
                if (byteBuffer == null) {
                    byteBuffer = zzij.zzajc;
                }
            }
            if (i2 == length) {
                zzc(byteBuffer, j2);
            } else {
                zzij zzijVar = this.zzalg[i2];
                zzijVar.zzn(byteBuffer);
                ByteBuffer zzfm = zzijVar.zzfm();
                this.zzalh[i2] = zzfm;
                if (zzfm.hasRemaining()) {
                    i2++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            }
            i2--;
        }
    }

    private final long zzdw(long j2) {
        return (j2 * 1000000) / this.zzahp;
    }

    private final long zzdx(long j2) {
        return (j2 * this.zzahp) / 1000000;
    }

    private final void zzfn() {
        zzij[] zzijVarArr;
        ArrayList arrayList = new ArrayList();
        for (zzij zzijVar : this.zzajw) {
            if (zzijVar.isActive()) {
                arrayList.add(zzijVar);
            } else {
                zzijVar.flush();
            }
        }
        int size = arrayList.size();
        this.zzalg = (zzij[]) arrayList.toArray(new zzij[size]);
        this.zzalh = new ByteBuffer[size];
        for (int i2 = 0; i2 < size; i2++) {
            zzij zzijVar2 = this.zzalg[i2];
            zzijVar2.flush();
            this.zzalh[i2] = zzijVar2.zzfm();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0032 -> B:9:0x0012). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzfq() throws com.google.android.gms.internal.ads.zzjb {
        /*
            r9 = this;
            int r0 = r9.zzalm
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L14
            boolean r0 = r9.zzakg
            if (r0 == 0) goto Lf
            com.google.android.gms.internal.ads.zzij[] r0 = r9.zzalg
            int r0 = r0.length
            goto L10
        Lf:
            r0 = 0
        L10:
            r9.zzalm = r0
        L12:
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            int r4 = r9.zzalm
            com.google.android.gms.internal.ads.zzij[] r5 = r9.zzalg
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L38
            r4 = r5[r4]
            if (r0 == 0) goto L28
            r4.zzfl()
        L28:
            r9.zzdv(r7)
            boolean r0 = r4.zzfe()
            if (r0 != 0) goto L32
            return r3
        L32:
            int r0 = r9.zzalm
            int r0 = r0 + r2
            r9.zzalm = r0
            goto L12
        L38:
            java.nio.ByteBuffer r0 = r9.zzalj
            if (r0 == 0) goto L44
            r9.zzc(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzalj
            if (r0 == 0) goto L44
            return r3
        L44:
            r9.zzalm = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzit.zzfq():boolean");
    }

    private final void zzfu() {
        if (isInitialized()) {
            if (zzpt.SDK_INT >= 21) {
                this.zzakc.setVolume(this.zzdi);
                return;
            }
            AudioTrack audioTrack = this.zzakc;
            float f2 = this.zzdi;
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    private final long zzfv() {
        return this.zzakg ? this.zzala : this.zzakz / this.zzaky;
    }

    private final void zzfw() {
        this.zzakq = 0L;
        this.zzakp = 0;
        this.zzako = 0;
        this.zzakr = 0L;
        this.zzaks = false;
        this.zzakt = 0L;
    }

    private final boolean zzfx() {
        if (zzpt.SDK_INT < 23) {
            int i2 = this.zzakf;
            return i2 == 5 || i2 == 6;
        }
        return false;
    }

    public final void pause() {
        this.zzalo = false;
        if (isInitialized()) {
            zzfw();
            this.zzaka.pause();
        }
    }

    public final void play() {
        this.zzalo = true;
        if (isInitialized()) {
            this.zzale = System.nanoTime() / 1000;
            this.zzakc.play();
        }
    }

    public final void release() {
        reset();
        for (zzij zzijVar : this.zzajw) {
            zzijVar.reset();
        }
        this.zzalp = 0;
        this.zzalo = false;
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzakw = 0L;
            this.zzakx = 0L;
            this.zzakz = 0L;
            this.zzala = 0L;
            this.zzalb = 0;
            zzhz zzhzVar = this.zzakj;
            if (zzhzVar != null) {
                this.zzafi = zzhzVar;
                this.zzakj = null;
            } else if (!this.zzakb.isEmpty()) {
                this.zzafi = zziy.zza(this.zzakb.getLast());
            }
            this.zzakb.clear();
            this.zzakk = 0L;
            this.zzakl = 0L;
            this.zzali = null;
            this.zzalj = null;
            int i2 = 0;
            while (true) {
                zzij[] zzijVarArr = this.zzalg;
                if (i2 >= zzijVarArr.length) {
                    break;
                }
                zzij zzijVar = zzijVarArr[i2];
                zzijVar.flush();
                this.zzalh[i2] = zzijVar.zzfm();
                i2++;
            }
            this.zzaln = false;
            this.zzalm = -1;
            this.zzakm = null;
            this.zzakn = 0;
            this.zzalc = 0;
            this.zzalf = 0L;
            zzfw();
            if (this.zzakc.getPlayState() == 3) {
                this.zzakc.pause();
            }
            AudioTrack audioTrack = this.zzakc;
            this.zzakc = null;
            this.zzaka.zza(null, false);
            this.zzajy.close();
            new zzis(this, audioTrack).start();
        }
    }

    public final void setStreamType(int i2) {
        if (this.streamType == i2) {
            return;
        }
        this.streamType = i2;
        if (this.zzalq) {
            return;
        }
        reset();
        this.zzalp = 0;
    }

    public final void setVolume(float f2) {
        if (this.zzdi != f2) {
            this.zzdi = f2;
            zzfu();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(java.lang.String r18, int r19, int r20, int r21, int r22, int[] r23) throws com.google.android.gms.internal.ads.zzix {
        /*
            Method dump skipped, instructions count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzit.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    public final boolean zzb(ByteBuffer byteBuffer, long j2) throws zziw, zzjb {
        int i2;
        int zzo;
        ByteBuffer byteBuffer2 = this.zzali;
        zzpg.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!isInitialized()) {
            this.zzajy.block();
            if (this.zzalq) {
                this.zzakc = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.zzakd).setEncoding(this.zzakf).setSampleRate(this.zzahp).build(), this.zzakh, 1, this.zzalp);
            } else if (this.zzalp == 0) {
                this.zzakc = new AudioTrack(this.streamType, this.zzahp, this.zzakd, this.zzakf, this.zzakh, 1);
            } else {
                this.zzakc = new AudioTrack(this.streamType, this.zzahp, this.zzakd, this.zzakf, this.zzakh, 1, this.zzalp);
            }
            int state = this.zzakc.getState();
            if (state == 1) {
                int audioSessionId = this.zzakc.getAudioSessionId();
                if (this.zzalp != audioSessionId) {
                    this.zzalp = audioSessionId;
                    this.zzajx.zzx(audioSessionId);
                }
                this.zzaka.zza(this.zzakc, zzfx());
                zzfu();
                this.zzalr = false;
                if (this.zzalo) {
                    play();
                }
            } else {
                try {
                    this.zzakc.release();
                } catch (Exception unused) {
                } finally {
                    this.zzakc = null;
                }
                throw new zziw(state, this.zzahp, this.zzakd, this.zzakh);
            }
        }
        if (zzfx()) {
            if (this.zzakc.getPlayState() == 2) {
                this.zzalr = false;
                return false;
            } else if (this.zzakc.getPlayState() == 1 && this.zzaka.zzgb() != 0) {
                return false;
            }
        }
        boolean z = this.zzalr;
        boolean zzfr = zzfr();
        this.zzalr = zzfr;
        if (z && !zzfr && this.zzakc.getPlayState() != 1) {
            this.zzajx.zzc(this.zzakh, zzhf.zzdo(this.zzaki), SystemClock.elapsedRealtime() - this.zzals);
        }
        if (this.zzali == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzakg && this.zzalb == 0) {
                int i3 = this.zzakf;
                if (i3 == 7 || i3 == 8) {
                    zzo = zzjd.zzo(byteBuffer);
                } else if (i3 == 5) {
                    zzo = zzih.zzfi();
                } else if (i3 == 6) {
                    zzo = zzih.zzm(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i3);
                    throw new IllegalStateException(sb.toString());
                }
                this.zzalb = zzo;
            }
            if (this.zzakj != null) {
                if (!zzfq()) {
                    return false;
                }
                this.zzakb.add(new zziy(this.zzakj, Math.max(0L, j2), zzdw(zzfv()), null));
                this.zzakj = null;
                zzfn();
            }
            if (this.zzalc == 0) {
                this.zzald = Math.max(0L, j2);
                this.zzalc = 1;
            } else {
                long zzdw = this.zzald + zzdw(this.zzakg ? this.zzakx : this.zzakw / this.zzakv);
                if (this.zzalc != 1 || Math.abs(zzdw - j2) <= 200000) {
                    i2 = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(zzdw);
                    sb2.append(", got ");
                    sb2.append(j2);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i2 = 2;
                    this.zzalc = 2;
                }
                if (this.zzalc == i2) {
                    this.zzald += j2 - zzdw;
                    this.zzalc = 1;
                    this.zzajx.zzek();
                }
            }
            if (this.zzakg) {
                this.zzakx += this.zzalb;
            } else {
                this.zzakw += byteBuffer.remaining();
            }
            this.zzali = byteBuffer;
        }
        if (this.zzakg) {
            zzc(this.zzali, j2);
        } else {
            zzdv(j2);
        }
        if (this.zzali.hasRemaining()) {
            return false;
        }
        this.zzali = null;
        return true;
    }

    public final boolean zzfe() {
        if (isInitialized()) {
            return this.zzaln && !zzfr();
        }
        return true;
    }

    public final void zzfo() {
        if (this.zzalc == 1) {
            this.zzalc = 2;
        }
    }

    public final void zzfp() throws zzjb {
        if (!this.zzaln && isInitialized() && zzfq()) {
            this.zzaka.zzdy(zzfv());
            this.zzakn = 0;
            this.zzaln = true;
        }
    }

    public final boolean zzfr() {
        if (isInitialized()) {
            if (zzfv() <= this.zzaka.zzgb()) {
                if (zzfx() && this.zzakc.getPlayState() == 2 && this.zzakc.getPlaybackHeadPosition() == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final zzhz zzfs() {
        return this.zzafi;
    }

    public final void zzft() {
        if (this.zzalq) {
            this.zzalq = false;
            this.zzalp = 0;
            reset();
        }
    }

    public final long zzj(boolean z) {
        long j2;
        long j3;
        long j4;
        long j5;
        Method method;
        if (isInitialized() && this.zzalc != 0) {
            if (this.zzakc.getPlayState() == 3) {
                long zzgc = this.zzaka.zzgc();
                if (zzgc != 0) {
                    long nanoTime = System.nanoTime() / 1000;
                    if (nanoTime - this.zzakr >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                        long[] jArr = this.zzajz;
                        int i2 = this.zzako;
                        jArr[i2] = zzgc - nanoTime;
                        this.zzako = (i2 + 1) % 10;
                        int i3 = this.zzakp;
                        if (i3 < 10) {
                            this.zzakp = i3 + 1;
                        }
                        this.zzakr = nanoTime;
                        this.zzakq = 0L;
                        int i4 = 0;
                        while (true) {
                            int i5 = this.zzakp;
                            if (i4 >= i5) {
                                break;
                            }
                            this.zzakq += this.zzajz[i4] / i5;
                            i4++;
                        }
                    }
                    if (!zzfx() && nanoTime - this.zzakt >= 500000) {
                        boolean zzfy = this.zzaka.zzfy();
                        this.zzaks = zzfy;
                        if (zzfy) {
                            long zzfz = this.zzaka.zzfz() / 1000;
                            long zzga = this.zzaka.zzga();
                            if (zzfz < this.zzale) {
                                this.zzaks = false;
                            } else if (Math.abs(zzfz - nanoTime) > 5000000) {
                                StringBuilder sb = new StringBuilder(136);
                                sb.append("Spurious audio timestamp (system clock mismatch): ");
                                sb.append(zzga);
                                sb.append(", ");
                                sb.append(zzfz);
                                sb.append(", ");
                                sb.append(nanoTime);
                                sb.append(", ");
                                sb.append(zzgc);
                                Log.w("AudioTrack", sb.toString());
                                this.zzaks = false;
                            } else if (Math.abs(zzdw(zzga) - zzgc) > 5000000) {
                                StringBuilder sb2 = new StringBuilder(138);
                                sb2.append("Spurious audio timestamp (frame position mismatch): ");
                                sb2.append(zzga);
                                sb2.append(", ");
                                sb2.append(zzfz);
                                sb2.append(", ");
                                sb2.append(nanoTime);
                                sb2.append(", ");
                                sb2.append(zzgc);
                                Log.w("AudioTrack", sb2.toString());
                                this.zzaks = false;
                            }
                        }
                        if (this.zzaku != null && !this.zzakg) {
                            try {
                                long intValue = (((Integer) method.invoke(this.zzakc, null)).intValue() * 1000) - this.zzaki;
                                this.zzalf = intValue;
                                long max = Math.max(intValue, 0L);
                                this.zzalf = max;
                                if (max > 5000000) {
                                    StringBuilder sb3 = new StringBuilder(61);
                                    sb3.append("Ignoring impossibly large audio latency: ");
                                    sb3.append(max);
                                    Log.w("AudioTrack", sb3.toString());
                                    this.zzalf = 0L;
                                }
                            } catch (Exception unused) {
                                this.zzaku = null;
                            }
                        }
                        this.zzakt = nanoTime;
                    }
                }
            }
            long nanoTime2 = System.nanoTime() / 1000;
            if (this.zzaks) {
                j2 = zzdw(this.zzaka.zzga() + zzdx(nanoTime2 - (this.zzaka.zzfz() / 1000)));
            } else {
                if (this.zzakp == 0) {
                    j2 = this.zzaka.zzgc();
                } else {
                    j2 = nanoTime2 + this.zzakq;
                }
                if (!z) {
                    j2 -= this.zzalf;
                }
            }
            long j6 = this.zzald;
            while (!this.zzakb.isEmpty() && j2 >= zziy.zzb(this.zzakb.getFirst())) {
                zziy remove = this.zzakb.remove();
                this.zzafi = zziy.zza(remove);
                this.zzakl = zziy.zzb(remove);
                this.zzakk = zziy.zzc(remove) - this.zzald;
            }
            if (this.zzafi.zzaib == 1.0f) {
                j5 = (j2 + this.zzakk) - this.zzakl;
            } else {
                if (this.zzakb.isEmpty() && this.zzajv.zzgl() >= 1024) {
                    j3 = this.zzakk;
                    j4 = zzpt.zza(j2 - this.zzakl, this.zzajv.zzgk(), this.zzajv.zzgl());
                } else {
                    j3 = this.zzakk;
                    j4 = (long) (this.zzafi.zzaib * (j2 - this.zzakl));
                }
                j5 = j4 + j3;
            }
            return j6 + j5;
        }
        return Long.MIN_VALUE;
    }

    public final zzhz zzb(zzhz zzhzVar) {
        if (this.zzakg) {
            zzhz zzhzVar2 = zzhz.zzaia;
            this.zzafi = zzhzVar2;
            return zzhzVar2;
        }
        zzhz zzhzVar3 = new zzhz(this.zzajv.zzb(zzhzVar.zzaib), this.zzajv.zzc(zzhzVar.zzaic));
        zzhz zzhzVar4 = this.zzakj;
        if (zzhzVar4 == null) {
            if (!this.zzakb.isEmpty()) {
                zzhzVar4 = zziy.zza(this.zzakb.getLast());
            } else {
                zzhzVar4 = this.zzafi;
            }
        }
        if (!zzhzVar3.equals(zzhzVar4)) {
            if (isInitialized()) {
                this.zzakj = zzhzVar3;
            } else {
                this.zzafi = zzhzVar3;
            }
        }
        return this.zzafi;
    }
}
