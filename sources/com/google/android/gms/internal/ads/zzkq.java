package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzjo;
import com.google.firebase.FirebaseError;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzkq implements zzka {
    private static final zzkb zzapk = new zzkp();
    private static final byte[] zzapl = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzapm = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID zzapn = new UUID(72057594037932032L, -9223371306706625679L);
    private long zzaip;
    private final zzkt zzapc;
    private final zzko zzapo;
    private final SparseArray<zzkr> zzapp;
    private final boolean zzapq;
    private final zzpn zzapr;
    private final zzpn zzaps;
    private final zzpn zzapt;
    private final zzpn zzapu;
    private final zzpn zzapv;
    private final zzpn zzapw;
    private final zzpn zzapx;
    private final zzpn zzapy;
    private final zzpn zzapz;
    private ByteBuffer zzaqa;
    private long zzaqb;
    private long zzaqc;
    private long zzaqd;
    private long zzaqe;
    private zzkr zzaqf;
    private boolean zzaqg;
    private int zzaqh;
    private long zzaqi;
    private boolean zzaqj;
    private long zzaqk;
    private long zzaql;
    private long zzaqm;
    private zzph zzaqn;
    private zzph zzaqo;
    private boolean zzaqp;
    private int zzaqq;
    private long zzaqr;
    private long zzaqs;
    private int zzaqt;
    private int zzaqu;
    private int[] zzaqv;
    private int zzaqw;
    private int zzaqx;
    private int zzaqy;
    private int zzaqz;
    private boolean zzara;
    private boolean zzarb;
    private boolean zzarc;
    private boolean zzard;
    private byte zzare;
    private int zzarf;
    private int zzarg;
    private int zzarh;
    private boolean zzari;
    private boolean zzarj;
    private zzkc zzark;

    public zzkq() {
        this(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzal(int i2) {
        switch (i2) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzam(int i2) {
        return i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427;
    }

    private final void zzb(zzjz zzjzVar, int i2) throws IOException, InterruptedException {
        if (this.zzapt.limit() >= i2) {
            return;
        }
        if (this.zzapt.capacity() < i2) {
            zzpn zzpnVar = this.zzapt;
            byte[] bArr = zzpnVar.data;
            zzpnVar.zzc(Arrays.copyOf(bArr, Math.max(bArr.length << 1, i2)), this.zzapt.limit());
        }
        zzpn zzpnVar2 = this.zzapt;
        zzjzVar.readFully(zzpnVar2.data, zzpnVar2.limit(), i2 - this.zzapt.limit());
        this.zzapt.zzbh(i2);
    }

    private final long zzea(long j2) throws zzhw {
        long j3 = this.zzaqd;
        if (j3 != -9223372036854775807L) {
            return zzpt.zza(j2, j3, 1000L);
        }
        throw new zzhw("Can't scale timecode prior to timecodeScale being set.");
    }

    private final void zzgu() {
        this.zzaqz = 0;
        this.zzarh = 0;
        this.zzarg = 0;
        this.zzara = false;
        this.zzarb = false;
        this.zzard = false;
        this.zzarf = 0;
        this.zzare = (byte) 0;
        this.zzarc = false;
        this.zzapw.reset();
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final boolean zza(zzjz zzjzVar) throws IOException, InterruptedException {
        return new zzku().zza(zzjzVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzan(int i2) throws zzhw {
        zzkf zzkiVar;
        zzph zzphVar;
        zzph zzphVar2;
        int i3;
        int i4 = 0;
        if (i2 == 160) {
            if (this.zzaqq != 2) {
                return;
            }
            if (!this.zzarj) {
                this.zzaqy |= 1;
            }
            zza(this.zzapp.get(this.zzaqw), this.zzaqr);
            this.zzaqq = 0;
        } else if (i2 == 174) {
            String str = this.zzaqf.zzarl;
            if ((("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) ? 1 : 1) != 0) {
                zzkr zzkrVar = this.zzaqf;
                zzkrVar.zza(this.zzark, zzkrVar.number);
                SparseArray<zzkr> sparseArray = this.zzapp;
                zzkr zzkrVar2 = this.zzaqf;
                sparseArray.put(zzkrVar2.number, zzkrVar2);
            }
            this.zzaqf = null;
        } else if (i2 == 19899) {
            int i5 = this.zzaqh;
            if (i5 != -1) {
                long j2 = this.zzaqi;
                if (j2 != -1) {
                    if (i5 == 475249515) {
                        this.zzaqk = j2;
                        return;
                    }
                    return;
                }
            }
            throw new zzhw("Mandatory element SeekID or SeekPosition not found");
        } else if (i2 == 25152) {
            zzkr zzkrVar3 = this.zzaqf;
            if (zzkrVar3.zzarn) {
                if (zzkrVar3.zzarp != null) {
                    zzkrVar3.zzahh = new zzjo(new zzjo.zza(zzhf.UUID_NIL, "video/webm", this.zzaqf.zzarp.zzapi));
                    return;
                }
                throw new zzhw("Encrypted Track found but ContentEncKeyID was not found");
            }
        } else if (i2 == 28032) {
            zzkr zzkrVar4 = this.zzaqf;
            if (zzkrVar4.zzarn && zzkrVar4.zzaro != null) {
                throw new zzhw("Combining encryption and compression is not supported");
            }
        } else if (i2 == 357149030) {
            if (this.zzaqd == -9223372036854775807L) {
                this.zzaqd = 1000000L;
            }
            long j3 = this.zzaqe;
            if (j3 != -9223372036854775807L) {
                this.zzaip = zzea(j3);
            }
        } else if (i2 != 374648427) {
            if (i2 == 475249515 && !this.zzaqg) {
                zzkc zzkcVar = this.zzark;
                if (this.zzaqc != -1 && this.zzaip != -9223372036854775807L && (zzphVar = this.zzaqn) != null && zzphVar.size() != 0 && (zzphVar2 = this.zzaqo) != null && zzphVar2.size() == this.zzaqn.size()) {
                    int size = this.zzaqn.size();
                    int[] iArr = new int[size];
                    long[] jArr = new long[size];
                    long[] jArr2 = new long[size];
                    long[] jArr3 = new long[size];
                    for (int i6 = 0; i6 < size; i6++) {
                        jArr3[i6] = this.zzaqn.get(i6);
                        jArr[i6] = this.zzaqc + this.zzaqo.get(i6);
                    }
                    while (true) {
                        i3 = size - 1;
                        if (i4 >= i3) {
                            break;
                        }
                        int i7 = i4 + 1;
                        iArr[i4] = (int) (jArr[i7] - jArr[i4]);
                        jArr2[i4] = jArr3[i7] - jArr3[i4];
                        i4 = i7;
                    }
                    iArr[i3] = (int) ((this.zzaqc + this.zzaqb) - jArr[i3]);
                    jArr2[i3] = this.zzaip - jArr3[i3];
                    this.zzaqn = null;
                    this.zzaqo = null;
                    zzkiVar = new zzjy(iArr, jArr, jArr2, jArr3);
                } else {
                    this.zzaqn = null;
                    this.zzaqo = null;
                    zzkiVar = new zzki(this.zzaip);
                }
                zzkcVar.zza(zzkiVar);
                this.zzaqg = true;
            }
        } else if (this.zzapp.size() != 0) {
            this.zzark.zzgs();
        } else {
            throw new zzhw("No valid tracks were found");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zzc(long j2, long j3) {
        this.zzaqm = -9223372036854775807L;
        this.zzaqq = 0;
        this.zzapo.reset();
        this.zzapc.reset();
        zzgu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(int i2, long j2, long j3) throws zzhw {
        if (i2 == 160) {
            this.zzarj = false;
        } else if (i2 == 174) {
            this.zzaqf = new zzkr(null);
        } else if (i2 == 187) {
            this.zzaqp = false;
        } else if (i2 == 19899) {
            this.zzaqh = -1;
            this.zzaqi = -1L;
        } else if (i2 == 20533) {
            this.zzaqf.zzarn = true;
        } else if (i2 == 21968) {
            this.zzaqf.zzaru = true;
        } else if (i2 == 408125543) {
            long j4 = this.zzaqc;
            if (j4 != -1 && j4 != j2) {
                throw new zzhw("Multiple Segment elements not supported");
            }
            this.zzaqc = j2;
            this.zzaqb = j3;
        } else if (i2 != 475249515) {
            if (i2 == 524531317 && !this.zzaqg) {
                if (this.zzapq && this.zzaqk != -1) {
                    this.zzaqj = true;
                    return;
                }
                this.zzark.zza(new zzki(this.zzaip));
                this.zzaqg = true;
            }
        } else {
            this.zzaqn = new zzph();
            this.zzaqo = new zzph();
        }
    }

    private zzkq(int i2) {
        this(new zzkj(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zza(zzkc zzkcVar) {
        this.zzark = zzkcVar;
    }

    private zzkq(zzko zzkoVar, int i2) {
        this.zzaqc = -1L;
        this.zzaqd = -9223372036854775807L;
        this.zzaqe = -9223372036854775807L;
        this.zzaip = -9223372036854775807L;
        this.zzaqk = -1L;
        this.zzaql = -1L;
        this.zzaqm = -9223372036854775807L;
        this.zzapo = zzkoVar;
        zzkoVar.zza(new zzks(this, null));
        this.zzapq = true;
        this.zzapc = new zzkt();
        this.zzapp = new SparseArray<>();
        this.zzapt = new zzpn(4);
        this.zzapu = new zzpn(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzapv = new zzpn(4);
        this.zzapr = new zzpn(zzpm.zzbjt);
        this.zzaps = new zzpn(4);
        this.zzapw = new zzpn();
        this.zzapx = new zzpn();
        this.zzapy = new zzpn(8);
        this.zzapz = new zzpn();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0039 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0005 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzka
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(com.google.android.gms.internal.ads.zzjz r9, com.google.android.gms.internal.ads.zzkg r10) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            r0 = 0
            r8.zzari = r0
            r1 = 1
            r2 = 1
        L5:
            if (r2 == 0) goto L3a
            boolean r3 = r8.zzari
            if (r3 != 0) goto L3a
            com.google.android.gms.internal.ads.zzko r2 = r8.zzapo
            boolean r2 = r2.zzb(r9)
            if (r2 == 0) goto L5
            long r3 = r9.getPosition()
            boolean r5 = r8.zzaqj
            if (r5 == 0) goto L25
            r8.zzaql = r3
            long r3 = r8.zzaqk
            r10.position = r3
            r8.zzaqj = r0
        L23:
            r3 = 1
            goto L37
        L25:
            boolean r3 = r8.zzaqg
            if (r3 == 0) goto L36
            long r3 = r8.zzaql
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L36
            r10.position = r3
            r8.zzaql = r5
            goto L23
        L36:
            r3 = 0
        L37:
            if (r3 == 0) goto L5
            return r1
        L3a:
            if (r2 == 0) goto L3d
            return r0
        L3d:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkq.zza(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkg):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i2, double d2) {
        if (i2 == 181) {
            this.zzaqf.zzahp = (int) d2;
        } else if (i2 != 17545) {
            switch (i2) {
                case 21969:
                    this.zzaqf.zzasa = (float) d2;
                    return;
                case 21970:
                    this.zzaqf.zzasb = (float) d2;
                    return;
                case 21971:
                    this.zzaqf.zzasc = (float) d2;
                    return;
                case 21972:
                    this.zzaqf.zzasd = (float) d2;
                    return;
                case 21973:
                    this.zzaqf.zzase = (float) d2;
                    return;
                case 21974:
                    this.zzaqf.zzasf = (float) d2;
                    return;
                case 21975:
                    this.zzaqf.zzasg = (float) d2;
                    return;
                case 21976:
                    this.zzaqf.zzash = (float) d2;
                    return;
                case 21977:
                    this.zzaqf.zzasi = (float) d2;
                    return;
                case 21978:
                    this.zzaqf.zzasj = (float) d2;
                    return;
                default:
                    return;
            }
        } else {
            this.zzaqe = (long) d2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(int i2, long j2) throws zzhw {
        if (i2 == 20529) {
            if (j2 == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(55);
            sb.append("ContentEncodingOrder ");
            sb.append(j2);
            sb.append(" not supported");
            throw new zzhw(sb.toString());
        } else if (i2 == 20530) {
            if (j2 == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("ContentEncodingScope ");
            sb2.append(j2);
            sb2.append(" not supported");
            throw new zzhw(sb2.toString());
        } else {
            switch (i2) {
                case 131:
                    this.zzaqf.type = (int) j2;
                    return;
                case 136:
                    this.zzaqf.zzasn = j2 == 1;
                    return;
                case 155:
                    this.zzaqs = zzea(j2);
                    return;
                case 159:
                    this.zzaqf.zzaho = (int) j2;
                    return;
                case 176:
                    this.zzaqf.width = (int) j2;
                    return;
                case 179:
                    this.zzaqn.add(zzea(j2));
                    return;
                case 186:
                    this.zzaqf.height = (int) j2;
                    return;
                case 215:
                    this.zzaqf.number = (int) j2;
                    return;
                case 231:
                    this.zzaqm = zzea(j2);
                    return;
                case 241:
                    if (this.zzaqp) {
                        return;
                    }
                    this.zzaqo.add(j2);
                    this.zzaqp = true;
                    return;
                case 251:
                    this.zzarj = true;
                    return;
                case 16980:
                    if (j2 == 3) {
                        return;
                    }
                    StringBuilder sb3 = new StringBuilder(50);
                    sb3.append("ContentCompAlgo ");
                    sb3.append(j2);
                    sb3.append(" not supported");
                    throw new zzhw(sb3.toString());
                case 17029:
                    if (j2 < 1 || j2 > 2) {
                        StringBuilder sb4 = new StringBuilder(53);
                        sb4.append("DocTypeReadVersion ");
                        sb4.append(j2);
                        sb4.append(" not supported");
                        throw new zzhw(sb4.toString());
                    }
                    return;
                case 17143:
                    if (j2 == 1) {
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder(50);
                    sb5.append("EBMLReadVersion ");
                    sb5.append(j2);
                    sb5.append(" not supported");
                    throw new zzhw(sb5.toString());
                case 18401:
                    if (j2 == 5) {
                        return;
                    }
                    StringBuilder sb6 = new StringBuilder(49);
                    sb6.append("ContentEncAlgo ");
                    sb6.append(j2);
                    sb6.append(" not supported");
                    throw new zzhw(sb6.toString());
                case 18408:
                    if (j2 == 1) {
                        return;
                    }
                    StringBuilder sb7 = new StringBuilder(56);
                    sb7.append("AESSettingsCipherMode ");
                    sb7.append(j2);
                    sb7.append(" not supported");
                    throw new zzhw(sb7.toString());
                case 21420:
                    this.zzaqi = j2 + this.zzaqc;
                    return;
                case 21432:
                    int i3 = (int) j2;
                    if (i3 == 0) {
                        this.zzaqf.zzahl = 0;
                        return;
                    } else if (i3 == 1) {
                        this.zzaqf.zzahl = 2;
                        return;
                    } else if (i3 == 3) {
                        this.zzaqf.zzahl = 1;
                        return;
                    } else if (i3 != 15) {
                        return;
                    } else {
                        this.zzaqf.zzahl = 3;
                        return;
                    }
                case 21680:
                    this.zzaqf.zzarr = (int) j2;
                    return;
                case 21682:
                    this.zzaqf.zzart = (int) j2;
                    return;
                case 21690:
                    this.zzaqf.zzars = (int) j2;
                    return;
                case 21930:
                    this.zzaqf.zzaso = j2 == 1;
                    return;
                case 22186:
                    this.zzaqf.zzasl = j2;
                    return;
                case 22203:
                    this.zzaqf.zzasm = j2;
                    return;
                case 25188:
                    this.zzaqf.zzask = (int) j2;
                    return;
                case 2352003:
                    this.zzaqf.zzarm = (int) j2;
                    return;
                case 2807729:
                    this.zzaqd = j2;
                    return;
                default:
                    switch (i2) {
                        case 21945:
                            int i4 = (int) j2;
                            if (i4 == 1) {
                                this.zzaqf.zzarx = 2;
                                return;
                            } else if (i4 != 2) {
                                return;
                            } else {
                                this.zzaqf.zzarx = 1;
                                return;
                            }
                        case 21946:
                            int i5 = (int) j2;
                            if (i5 != 1) {
                                if (i5 == 16) {
                                    this.zzaqf.zzarw = 6;
                                    return;
                                } else if (i5 == 18) {
                                    this.zzaqf.zzarw = 7;
                                    return;
                                } else if (i5 != 6 && i5 != 7) {
                                    return;
                                }
                            }
                            this.zzaqf.zzarw = 3;
                            return;
                        case 21947:
                            zzkr zzkrVar = this.zzaqf;
                            zzkrVar.zzaru = true;
                            int i6 = (int) j2;
                            if (i6 == 1) {
                                zzkrVar.zzarv = 1;
                                return;
                            } else if (i6 == 9) {
                                zzkrVar.zzarv = 6;
                                return;
                            } else if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                zzkrVar.zzarv = 2;
                                return;
                            } else {
                                return;
                            }
                        case 21948:
                            this.zzaqf.zzary = (int) j2;
                            return;
                        case 21949:
                            this.zzaqf.zzarz = (int) j2;
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i2, String str) throws zzhw {
        if (i2 == 134) {
            this.zzaqf.zzarl = str;
        } else if (i2 != 17026) {
            if (i2 != 2274716) {
                return;
            }
            zzkr.zza(this.zzaqf, str);
        } else if ("webm".equals(str) || "matroska".equals(str)) {
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzhw(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01f0, code lost:
        throw new com.google.android.gms.internal.ads.zzhw("EBML lacing sample size out of range.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(int r22, int r23, com.google.android.gms.internal.ads.zzjz r24) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkq.zza(int, int, com.google.android.gms.internal.ads.zzjz):void");
    }

    private final void zza(zzkr zzkrVar, long j2) {
        int i2;
        byte[] zzbg;
        if ("S_TEXT/UTF8".equals(zzkrVar.zzarl)) {
            byte[] bArr = this.zzapx.data;
            long j3 = this.zzaqs;
            if (j3 == -9223372036854775807L) {
                zzbg = zzapm;
            } else {
                int i3 = (int) (j3 / 3600000000L);
                long j4 = j3 - (i3 * 3600000000L);
                int i4 = (int) (j4 / 60000000);
                long j5 = j4 - (60000000 * i4);
                zzbg = zzpt.zzbg(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) (j5 / 1000000)), Integer.valueOf((int) ((j5 - (1000000 * i2)) / 1000))));
            }
            System.arraycopy(zzbg, 0, bArr, 19, 12);
            zzkh zzkhVar = zzkrVar.zzasp;
            zzpn zzpnVar = this.zzapx;
            zzkhVar.zza(zzpnVar, zzpnVar.limit());
            this.zzarh += this.zzapx.limit();
        }
        zzkrVar.zzasp.zza(j2, this.zzaqy, this.zzarh, 0, zzkrVar.zzarp);
        this.zzari = true;
        zzgu();
    }

    private final void zza(zzjz zzjzVar, zzkr zzkrVar, int i2) throws IOException, InterruptedException {
        int i3;
        if ("S_TEXT/UTF8".equals(zzkrVar.zzarl)) {
            byte[] bArr = zzapl;
            int length = bArr.length + i2;
            if (this.zzapx.capacity() < length) {
                this.zzapx.data = Arrays.copyOf(bArr, length + i2);
            }
            zzjzVar.readFully(this.zzapx.data, bArr.length, i2);
            this.zzapx.zzbi(0);
            this.zzapx.zzbh(length);
            return;
        }
        zzkh zzkhVar = zzkrVar.zzasp;
        if (!this.zzara) {
            if (zzkrVar.zzarn) {
                this.zzaqy &= -1073741825;
                if (!this.zzarb) {
                    zzjzVar.readFully(this.zzapt.data, 0, 1);
                    this.zzaqz++;
                    byte[] bArr2 = this.zzapt.data;
                    if ((bArr2[0] & 128) != 128) {
                        this.zzare = bArr2[0];
                        this.zzarb = true;
                    } else {
                        throw new zzhw("Extension bit is set in signal byte");
                    }
                }
                byte b = this.zzare;
                if ((b & 1) == 1) {
                    boolean z = (b & 2) == 2;
                    this.zzaqy |= 1073741824;
                    if (!this.zzarc) {
                        zzjzVar.readFully(this.zzapy.data, 0, 8);
                        this.zzaqz += 8;
                        this.zzarc = true;
                        zzpn zzpnVar = this.zzapt;
                        zzpnVar.data[0] = (byte) ((z ? 128 : 0) | 8);
                        zzpnVar.zzbi(0);
                        zzkhVar.zza(this.zzapt, 1);
                        this.zzarh++;
                        this.zzapy.zzbi(0);
                        zzkhVar.zza(this.zzapy, 8);
                        this.zzarh += 8;
                    }
                    if (z) {
                        if (!this.zzard) {
                            zzjzVar.readFully(this.zzapt.data, 0, 1);
                            this.zzaqz++;
                            this.zzapt.zzbi(0);
                            this.zzarf = this.zzapt.readUnsignedByte();
                            this.zzard = true;
                        }
                        int i4 = this.zzarf << 2;
                        this.zzapt.reset(i4);
                        zzjzVar.readFully(this.zzapt.data, 0, i4);
                        this.zzaqz += i4;
                        short s = (short) ((this.zzarf / 2) + 1);
                        int i5 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.zzaqa;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.zzaqa = ByteBuffer.allocate(i5);
                        }
                        this.zzaqa.position(0);
                        this.zzaqa.putShort(s);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i3 = this.zzarf;
                            if (i6 >= i3) {
                                break;
                            }
                            int zzja = this.zzapt.zzja();
                            if (i6 % 2 == 0) {
                                this.zzaqa.putShort((short) (zzja - i7));
                            } else {
                                this.zzaqa.putInt(zzja - i7);
                            }
                            i6++;
                            i7 = zzja;
                        }
                        int i8 = (i2 - this.zzaqz) - i7;
                        if (i3 % 2 == 1) {
                            this.zzaqa.putInt(i8);
                        } else {
                            this.zzaqa.putShort((short) i8);
                            this.zzaqa.putInt(0);
                        }
                        this.zzapz.zzc(this.zzaqa.array(), i5);
                        zzkhVar.zza(this.zzapz, i5);
                        this.zzarh += i5;
                    }
                }
            } else {
                byte[] bArr3 = zzkrVar.zzaro;
                if (bArr3 != null) {
                    this.zzapw.zzc(bArr3, bArr3.length);
                }
            }
            this.zzara = true;
        }
        int limit = i2 + this.zzapw.limit();
        if (!"V_MPEG4/ISO/AVC".equals(zzkrVar.zzarl) && !"V_MPEGH/ISO/HEVC".equals(zzkrVar.zzarl)) {
            while (true) {
                int i9 = this.zzaqz;
                if (i9 >= limit) {
                    break;
                }
                zza(zzjzVar, zzkhVar, limit - i9);
            }
        } else {
            byte[] bArr4 = this.zzaps.data;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i10 = zzkrVar.zzasq;
            int i11 = 4 - i10;
            while (this.zzaqz < limit) {
                int i12 = this.zzarg;
                if (i12 == 0) {
                    int min = Math.min(i10, this.zzapw.zziv());
                    zzjzVar.readFully(bArr4, i11 + min, i10 - min);
                    if (min > 0) {
                        this.zzapw.zze(bArr4, i11, min);
                    }
                    this.zzaqz += i10;
                    this.zzaps.zzbi(0);
                    this.zzarg = this.zzaps.zzja();
                    this.zzapr.zzbi(0);
                    zzkhVar.zza(this.zzapr, 4);
                    this.zzarh += 4;
                } else {
                    this.zzarg = i12 - zza(zzjzVar, zzkhVar, i12);
                }
            }
        }
        if ("A_VORBIS".equals(zzkrVar.zzarl)) {
            this.zzapu.zzbi(0);
            zzkhVar.zza(this.zzapu, 4);
            this.zzarh += 4;
        }
    }

    private final int zza(zzjz zzjzVar, zzkh zzkhVar, int i2) throws IOException, InterruptedException {
        int zza;
        int zziv = this.zzapw.zziv();
        if (zziv > 0) {
            zza = Math.min(i2, zziv);
            zzkhVar.zza(this.zzapw, zza);
        } else {
            zza = zzkhVar.zza(zzjzVar, i2, false);
        }
        this.zzaqz += zza;
        this.zzarh += zza;
        return zza;
    }

    private static int[] zza(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        return iArr.length >= i2 ? iArr : new int[Math.max(iArr.length << 1, i2)];
    }
}
