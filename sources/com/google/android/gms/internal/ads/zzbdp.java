package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbdp extends zzbdd implements zzpd<zzon> {
    private String url;
    private ByteBuffer zzamk;
    private final String zzbvs;
    private final int zzbvt;
    private final zzbbl zzenf;
    private boolean zzeqe;
    private final zzbdq zzeqf;
    private final zzbcv zzeqg;
    private boolean zzeqh;
    private final Object zzeqi;
    private boolean zzeqj;

    public zzbdp(zzbbo zzbboVar, zzbbl zzbblVar) {
        super(zzbboVar);
        this.zzenf = zzbblVar;
        this.zzeqf = new zzbdq();
        this.zzeqg = new zzbcv();
        this.zzeqi = new Object();
        this.zzbvs = zzbboVar != null ? zzbboVar.zzabg() : "";
        this.zzbvt = zzbboVar != null ? zzbboVar.zzabh() : 0;
    }

    private final void zzaas() {
        int zzacn = (int) this.zzeqf.zzacn();
        int zzq = (int) this.zzeqg.zzq(this.zzamk);
        int position = this.zzamk.position();
        int round = Math.round(zzq * (position / zzacn));
        boolean z = round > 0;
        int zzacj = zzbck.zzacj();
        int zzack = zzbck.zzack();
        String str = this.url;
        zza(str, zzfh(str), position, zzacn, round, zzq, z, zzacj, zzack);
    }

    @Override // com.google.android.gms.internal.ads.zzbdd
    public final void abort() {
        this.zzeqe = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzeqi) {
            ByteBuffer byteBuffer = this.zzamk;
            if (byteBuffer != null && !this.zzeqh) {
                byteBuffer.flip();
                this.zzeqh = true;
            }
            this.zzeqe = true;
        }
        return this.zzamk;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* synthetic */ void zza(zzon zzonVar, zzos zzosVar) {
        zzon zzonVar2 = zzonVar;
        if (zzonVar2 instanceof zzou) {
            this.zzeqf.zza((zzou) zzonVar2);
        }
    }

    public final boolean zzacm() {
        return this.zzeqj;
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* bridge */ /* synthetic */ void zzc(zzon zzonVar, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* bridge */ /* synthetic */ void zze(zzon zzonVar) {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:? -> B:53:0x013f). Please submit an issue!!! */
    @Override // com.google.android.gms.internal.ads.zzbdd
    public final boolean zzfg(String str) {
        String str2;
        this.url = str;
        String zzfh = zzfh(str);
        String str3 = "error";
        int i2 = 0;
        try {
            String str4 = this.zzegw;
            zzbbl zzbblVar = this.zzenf;
            zzon zzouVar = new zzou(str4, null, this, zzbblVar.zzeli, zzbblVar.zzelk, true, null);
            if (this.zzenf.zzelo) {
                try {
                    zzouVar = new zzbcg(this.mContext, zzouVar, this.zzbvs, this.zzbvt, null, null);
                } catch (Exception e2) {
                    e = e2;
                    String canonicalName = e.getClass().getCanonicalName();
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 1 + String.valueOf(message).length());
                    sb.append(canonicalName);
                    sb.append(":");
                    sb.append(message);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(sb2).length());
                    sb3.append("Failed to preload url ");
                    sb3.append(str);
                    sb3.append(" Exception: ");
                    sb3.append(sb2);
                    zzazk.zzex(sb3.toString());
                    zza(str, zzfh, str3, sb2);
                    return false;
                }
            }
            zzouVar.zza(new zzos(Uri.parse(str)));
            zzbbo zzbboVar = this.zzepn.get();
            if (zzbboVar != null) {
                zzbboVar.zza(zzfh, this);
            }
            Clock zzky = com.google.android.gms.ads.internal.zzr.zzky();
            long currentTimeMillis = zzky.currentTimeMillis();
            long longValue = ((Long) zzwr.zzqr().zzd(zzabp.zzcnb)).longValue();
            long longValue2 = ((Long) zzwr.zzqr().zzd(zzabp.zzcna)).longValue();
            this.zzamk = ByteBuffer.allocate(this.zzenf.zzelh);
            int i3 = 8192;
            byte[] bArr = new byte[8192];
            long j2 = currentTimeMillis;
            while (true) {
                int read = zzouVar.read(bArr, i2, Math.min(this.zzamk.remaining(), i3));
                if (read == -1) {
                    this.zzeqj = true;
                    zzc(str, zzfh, (int) this.zzeqg.zzq(this.zzamk));
                    return true;
                }
                synchronized (this.zzeqi) {
                    try {
                        if (this.zzeqe) {
                            str2 = str3;
                        } else {
                            str2 = str3;
                            try {
                                this.zzamk.put(bArr, 0, read);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        try {
                            if (this.zzamk.remaining() <= 0) {
                                zzaas();
                                return true;
                            } else if (!this.zzeqe) {
                                long currentTimeMillis2 = zzky.currentTimeMillis();
                                if (currentTimeMillis2 - j2 >= longValue) {
                                    zzaas();
                                    j2 = currentTimeMillis2;
                                }
                                if (currentTimeMillis2 - currentTimeMillis > 1000 * longValue2) {
                                    StringBuilder sb4 = new StringBuilder(49);
                                    sb4.append("Timeout exceeded. Limit: ");
                                    sb4.append(longValue2);
                                    sb4.append(" sec");
                                    throw new IOException(sb4.toString());
                                }
                                str3 = str2;
                                i3 = 8192;
                                i2 = 0;
                            } else {
                                int limit = this.zzamk.limit();
                                StringBuilder sb5 = new StringBuilder(35);
                                sb5.append("Precache abort at ");
                                sb5.append(limit);
                                sb5.append(" bytes");
                                throw new IOException(sb5.toString());
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str3 = str2;
                            String canonicalName2 = e.getClass().getCanonicalName();
                            String message2 = e.getMessage();
                            StringBuilder sb6 = new StringBuilder(String.valueOf(canonicalName2).length() + 1 + String.valueOf(message2).length());
                            sb6.append(canonicalName2);
                            sb6.append(":");
                            sb6.append(message2);
                            String sb22 = sb6.toString();
                            StringBuilder sb32 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(sb22).length());
                            sb32.append("Failed to preload url ");
                            sb32.append(str);
                            sb32.append(" Exception: ");
                            sb32.append(sb22);
                            zzazk.zzex(sb32.toString());
                            zza(str, zzfh, str3, sb22);
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbdd
    public final String zzfh(String str) {
        String valueOf = String.valueOf(super.zzfh(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }
}
