package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.util.Stack;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzkj implements zzko {
    private final byte[] zzapa = new byte[8];
    private final Stack<zzkl> zzapb = new Stack<>();
    private final zzkt zzapc = new zzkt();
    private zzkn zzapd;
    private int zzape;
    private int zzapf;
    private long zzapg;

    @Override // com.google.android.gms.internal.ads.zzko
    public final void reset() {
        this.zzape = 0;
        this.zzapb.clear();
        this.zzapc.reset();
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final void zza(zzkn zzknVar) {
        this.zzapd = zzknVar;
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final boolean zzb(zzjz zzjzVar) throws IOException, InterruptedException {
        String str;
        double longBitsToDouble;
        int zzao;
        int zza;
        long j2;
        int i2;
        zzpg.checkState(this.zzapd != null);
        while (true) {
            if (!this.zzapb.isEmpty()) {
                long position = zzjzVar.getPosition();
                j2 = this.zzapb.peek().zzapj;
                if (position >= j2) {
                    zzkn zzknVar = this.zzapd;
                    i2 = this.zzapb.pop().zzapf;
                    zzknVar.zzan(i2);
                    return true;
                }
            }
            if (this.zzape == 0) {
                long zza2 = this.zzapc.zza(zzjzVar, true, false, 4);
                if (zza2 == -2) {
                    zzjzVar.zzgq();
                    while (true) {
                        zzjzVar.zza(this.zzapa, 0, 4);
                        zzao = zzkt.zzao(this.zzapa[0]);
                        if (zzao != -1 && zzao <= 4) {
                            zza = (int) zzkt.zza(this.zzapa, zzao, false);
                            if (this.zzapd.zzam(zza)) {
                                break;
                            }
                        }
                        zzjzVar.zzag(1);
                    }
                    zzjzVar.zzag(zzao);
                    zza2 = zza;
                }
                if (zza2 == -1) {
                    return false;
                }
                this.zzapf = (int) zza2;
                this.zzape = 1;
            }
            if (this.zzape == 1) {
                this.zzapg = this.zzapc.zza(zzjzVar, false, true, 8);
                this.zzape = 2;
            }
            int zzal = this.zzapd.zzal(this.zzapf);
            if (zzal != 0) {
                if (zzal == 1) {
                    long position2 = zzjzVar.getPosition();
                    this.zzapb.add(new zzkl(this.zzapf, this.zzapg + position2));
                    this.zzapd.zzd(this.zzapf, position2, this.zzapg);
                    this.zzape = 0;
                    return true;
                } else if (zzal == 2) {
                    long j3 = this.zzapg;
                    if (j3 <= 8) {
                        this.zzapd.zzd(this.zzapf, zza(zzjzVar, (int) j3));
                        this.zzape = 0;
                        return true;
                    }
                    long j4 = this.zzapg;
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j4);
                    throw new zzhw(sb.toString());
                } else if (zzal == 3) {
                    long j5 = this.zzapg;
                    if (j5 <= 2147483647L) {
                        zzkn zzknVar2 = this.zzapd;
                        int i3 = this.zzapf;
                        int i4 = (int) j5;
                        if (i4 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i4];
                            zzjzVar.readFully(bArr, 0, i4);
                            str = new String(bArr);
                        }
                        zzknVar2.zza(i3, str);
                        this.zzape = 0;
                        return true;
                    }
                    long j6 = this.zzapg;
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j6);
                    throw new zzhw(sb2.toString());
                } else if (zzal == 4) {
                    this.zzapd.zza(this.zzapf, (int) this.zzapg, zzjzVar);
                    this.zzape = 0;
                    return true;
                } else if (zzal == 5) {
                    long j7 = this.zzapg;
                    if (j7 != 4 && j7 != 8) {
                        long j8 = this.zzapg;
                        StringBuilder sb3 = new StringBuilder(40);
                        sb3.append("Invalid float size: ");
                        sb3.append(j8);
                        throw new zzhw(sb3.toString());
                    }
                    zzkn zzknVar3 = this.zzapd;
                    int i5 = this.zzapf;
                    int i6 = (int) j7;
                    long zza3 = zza(zzjzVar, i6);
                    if (i6 == 4) {
                        longBitsToDouble = Float.intBitsToFloat((int) zza3);
                    } else {
                        longBitsToDouble = Double.longBitsToDouble(zza3);
                    }
                    zzknVar3.zza(i5, longBitsToDouble);
                    this.zzape = 0;
                    return true;
                } else {
                    StringBuilder sb4 = new StringBuilder(32);
                    sb4.append("Invalid element type ");
                    sb4.append(zzal);
                    throw new zzhw(sb4.toString());
                }
            }
            zzjzVar.zzag((int) this.zzapg);
            this.zzape = 0;
        }
    }

    private final long zza(zzjz zzjzVar, int i2) throws IOException, InterruptedException {
        zzjzVar.readFully(this.zzapa, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | (this.zzapa[i3] & Draft_75.END_OF_FRAME);
        }
        return j2;
    }
}
