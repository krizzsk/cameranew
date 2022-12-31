package com.google.android.gms.internal.ads;

import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import us.pinguo.paylibcenter.bean.PayResult;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzkr {
    public int height;
    public int number;
    public int type;
    public int width;
    public zzjo zzahh;
    public int zzahl;
    public byte[] zzahm;
    public int zzaho;
    public int zzahp;
    private String zzahv;
    public String zzarl;
    public int zzarm;
    public boolean zzarn;
    public byte[] zzaro;
    public zzkk zzarp;
    public byte[] zzarq;
    public int zzarr;
    public int zzars;
    public int zzart;
    public boolean zzaru;
    public int zzarv;
    public int zzarw;
    public int zzarx;
    public int zzary;
    public int zzarz;
    public float zzasa;
    public float zzasb;
    public float zzasc;
    public float zzasd;
    public float zzase;
    public float zzasf;
    public float zzasg;
    public float zzash;
    public float zzasi;
    public float zzasj;
    public int zzask;
    public long zzasl;
    public long zzasm;
    public boolean zzasn;
    public boolean zzaso;
    public zzkh zzasp;
    public int zzasq;

    private zzkr() {
        this.width = -1;
        this.height = -1;
        this.zzarr = -1;
        this.zzars = -1;
        this.zzart = 0;
        this.zzahm = null;
        this.zzahl = -1;
        this.zzaru = false;
        this.zzarv = -1;
        this.zzarw = -1;
        this.zzarx = -1;
        this.zzary = 1000;
        this.zzarz = 200;
        this.zzasa = -1.0f;
        this.zzasb = -1.0f;
        this.zzasc = -1.0f;
        this.zzasd = -1.0f;
        this.zzase = -1.0f;
        this.zzasf = -1.0f;
        this.zzasg = -1.0f;
        this.zzash = -1.0f;
        this.zzasi = -1.0f;
        this.zzasj = -1.0f;
        this.zzaho = 1;
        this.zzask = -1;
        this.zzahp = PayResult.PAY_RESULT_ALIPAY_CHECK_IN;
        this.zzasl = 0L;
        this.zzasm = 0L;
        this.zzaso = true;
        this.zzahv = "eng";
    }

    private static boolean zzb(zzpn zzpnVar) throws zzhw {
        UUID uuid;
        UUID uuid2;
        try {
            int zziw = zzpnVar.zziw();
            if (zziw == 1) {
                return true;
            }
            if (zziw == 65534) {
                zzpnVar.zzbi(24);
                long readLong = zzpnVar.readLong();
                uuid = zzkq.zzapn;
                if (readLong == uuid.getMostSignificantBits()) {
                    long readLong2 = zzpnVar.readLong();
                    uuid2 = zzkq.zzapn;
                    if (readLong2 == uuid2.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing MS/ACM codec private");
        }
    }

    private static List<byte[]> zzd(byte[] bArr) throws zzhw {
        try {
            if (bArr[0] == 2) {
                int i2 = 1;
                int i3 = 0;
                while (bArr[i2] == -1) {
                    i3 += 255;
                    i2++;
                }
                int i4 = i2 + 1;
                int i5 = i3 + bArr[i2];
                int i6 = 0;
                while (bArr[i4] == -1) {
                    i6 += 255;
                    i4++;
                }
                int i7 = i4 + 1;
                int i8 = i6 + bArr[i4];
                if (bArr[i7] == 1) {
                    byte[] bArr2 = new byte[i5];
                    System.arraycopy(bArr, i7, bArr2, 0, i5);
                    int i9 = i7 + i5;
                    if (bArr[i9] == 3) {
                        int i10 = i9 + i8;
                        if (bArr[i10] == 5) {
                            byte[] bArr3 = new byte[bArr.length - i10];
                            System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzhw("Error parsing vorbis codec private");
                    }
                    throw new zzhw("Error parsing vorbis codec private");
                }
                throw new zzhw("Error parsing vorbis codec private");
            }
            throw new zzhw("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing vorbis codec private");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void zza(zzkc zzkcVar, int i2) throws zzhw {
        char c;
        String str;
        List<byte[]> singletonList;
        int zzbo;
        int i3;
        int i4;
        List<byte[]> list;
        zzht zza;
        int i5;
        int i6;
        zzpy zzpyVar;
        byte[] bArr;
        int i7;
        String str2 = this.zzarl;
        str2.hashCode();
        int i8 = 1;
        switch (str2.hashCode()) {
            case -2095576542:
                if (str2.equals("V_MPEG4/ISO/AP")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -2095575984:
                if (str2.equals("V_MPEG4/ISO/SP")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1985379776:
                if (str2.equals("A_MS/ACM")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1784763192:
                if (str2.equals("A_TRUEHD")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1730367663:
                if (str2.equals("A_VORBIS")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1482641358:
                if (str2.equals("A_MPEG/L2")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1482641357:
                if (str2.equals("A_MPEG/L3")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1373388978:
                if (str2.equals("V_MS/VFW/FOURCC")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -933872740:
                if (str2.equals("S_DVBSUB")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -538363189:
                if (str2.equals("V_MPEG4/ISO/ASP")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -538363109:
                if (str2.equals("V_MPEG4/ISO/AVC")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -425012669:
                if (str2.equals("S_VOBSUB")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -356037306:
                if (str2.equals("A_DTS/LOSSLESS")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 62923557:
                if (str2.equals("A_AAC")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 62923603:
                if (str2.equals("A_AC3")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 62927045:
                if (str2.equals("A_DTS")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 82338133:
                if (str2.equals("V_VP8")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 82338134:
                if (str2.equals("V_VP9")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 99146302:
                if (str2.equals("S_HDMV/PGS")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 444813526:
                if (str2.equals("V_THEORA")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 542569478:
                if (str2.equals("A_DTS/EXPRESS")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 725957860:
                if (str2.equals("A_PCM/INT/LIT")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 855502857:
                if (str2.equals("V_MPEGH/ISO/HEVC")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 1422270023:
                if (str2.equals("S_TEXT/UTF8")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 1809237540:
                if (str2.equals("V_MPEG2")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 1950749482:
                if (str2.equals("A_EAC3")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 1950789798:
                if (str2.equals("A_FLAC")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 1951062397:
                if (str2.equals("A_OPUS")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        String str3 = "audio/raw";
        switch (c) {
            case 0:
            case 1:
            case '\t':
                str = "application/pgs";
                byte[] bArr2 = this.zzarq;
                singletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                str3 = "video/mp4v-es";
                i3 = -1;
                i4 = -1;
                break;
            case 2:
                str = "application/pgs";
                if (zzb(new zzpn(this.zzarq))) {
                    zzbo = zzpt.zzbo(this.zzask);
                    if (zzbo == 0) {
                        int i9 = this.zzask;
                        StringBuilder sb = new StringBuilder("audio/x-unknown".length() + 60);
                        sb.append("Unsupported PCM bit depth: ");
                        sb.append(i9);
                        sb.append(". Setting mimeType to ");
                        sb.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb.toString());
                    }
                    i3 = zzbo;
                    singletonList = null;
                    i4 = -1;
                    break;
                } else {
                    Log.w("MatroskaExtractor", "audio/x-unknown".length() != 0 ? "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown") : new String("Non-PCM MS/ACM is unsupported. Setting mimeType to "));
                }
                str3 = "audio/x-unknown";
                singletonList = null;
                i3 = -1;
                i4 = -1;
            case 3:
                str = "application/pgs";
                str3 = "audio/true-hd";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                break;
            case 4:
                str = "application/pgs";
                singletonList = zzd(this.zzarq);
                str3 = "audio/vorbis";
                i3 = -1;
                i4 = 8192;
                break;
            case 5:
                str = "application/pgs";
                str3 = "audio/mpeg-L2";
                singletonList = null;
                i3 = -1;
                i4 = 4096;
                break;
            case 6:
                str = "application/pgs";
                str3 = "audio/mpeg";
                singletonList = null;
                i3 = -1;
                i4 = 4096;
                break;
            case 7:
                str = "application/pgs";
                singletonList = zza(new zzpn(this.zzarq));
                if (singletonList != null) {
                    str3 = "video/wvc1";
                } else {
                    Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                    str3 = "video/x-unknown";
                }
                i3 = -1;
                i4 = -1;
                break;
            case '\b':
                str = "application/pgs";
                byte[] bArr3 = this.zzarq;
                singletonList = Collections.singletonList(new byte[]{bArr3[0], bArr3[1], bArr3[2], bArr3[3]});
                str3 = "application/dvbsubs";
                i3 = -1;
                i4 = -1;
                break;
            case '\n':
                str = "application/pgs";
                zzpv zzg = zzpv.zzg(new zzpn(this.zzarq));
                list = zzg.zzahg;
                this.zzasq = zzg.zzasq;
                str3 = "video/avc";
                singletonList = list;
                i3 = -1;
                i4 = -1;
                break;
            case 11:
                str = "application/pgs";
                singletonList = Collections.singletonList(this.zzarq);
                str3 = "application/vobsub";
                i3 = -1;
                i4 = -1;
                break;
            case '\f':
                str = "application/pgs";
                str3 = "audio/vnd.dts.hd";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                break;
            case '\r':
                str = "application/pgs";
                singletonList = Collections.singletonList(this.zzarq);
                str3 = "audio/mp4a-latm";
                i3 = -1;
                i4 = -1;
                break;
            case 14:
                str = "application/pgs";
                str3 = "audio/ac3";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                break;
            case 15:
            case 20:
                str = "application/pgs";
                str3 = "audio/vnd.dts";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                break;
            case 16:
                str = "application/pgs";
                str3 = "video/x-vnd.on2.vp8";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                break;
            case 17:
                str = "application/pgs";
                str3 = "video/x-vnd.on2.vp9";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                break;
            case 18:
                str = "application/pgs";
                singletonList = null;
                str3 = str;
                i3 = -1;
                i4 = -1;
                break;
            case 19:
                str = "application/pgs";
                str3 = "video/x-unknown";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                break;
            case 21:
                str = "application/pgs";
                zzbo = zzpt.zzbo(this.zzask);
                if (zzbo == 0) {
                    int i10 = this.zzask;
                    StringBuilder sb2 = new StringBuilder("audio/x-unknown".length() + 60);
                    sb2.append("Unsupported PCM bit depth: ");
                    sb2.append(i10);
                    sb2.append(". Setting mimeType to ");
                    sb2.append("audio/x-unknown");
                    Log.w("MatroskaExtractor", sb2.toString());
                    str3 = "audio/x-unknown";
                    singletonList = null;
                    i3 = -1;
                    i4 = -1;
                    break;
                }
                i3 = zzbo;
                singletonList = null;
                i4 = -1;
            case 22:
                str = "application/pgs";
                zzqb zzi = zzqb.zzi(new zzpn(this.zzarq));
                list = zzi.zzahg;
                this.zzasq = zzi.zzasq;
                str3 = "video/hevc";
                singletonList = list;
                i3 = -1;
                i4 = -1;
                break;
            case 23:
                str = "application/pgs";
                str3 = "application/x-subrip";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                break;
            case 24:
                str = "application/pgs";
                str3 = "video/mpeg2";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                break;
            case 25:
                str = "application/pgs";
                str3 = "audio/eac3";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                break;
            case 26:
                str = "application/pgs";
                singletonList = Collections.singletonList(this.zzarq);
                str3 = "audio/x-flac";
                i3 = -1;
                i4 = -1;
                break;
            case 27:
                singletonList = new ArrayList<>(3);
                singletonList.add(this.zzarq);
                str = "application/pgs";
                singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.zzasl).array());
                singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.zzasm).array());
                str3 = "audio/opus";
                i3 = -1;
                i4 = 5760;
                break;
            default:
                throw new zzhw("Unrecognized codec identifier.");
        }
        int i11 = (this.zzaso ? 1 : 0) | 0 | (this.zzasn ? 2 : 0);
        if (zzpj.zzbc(str3)) {
            zza = zzht.zza(Integer.toString(i2), str3, null, -1, i4, this.zzaho, this.zzahp, i3, singletonList, this.zzahh, i11, this.zzahv);
        } else if (zzpj.zzbd(str3)) {
            if (this.zzart == 0) {
                int i12 = this.zzarr;
                i5 = -1;
                if (i12 == -1) {
                    i12 = this.width;
                }
                this.zzarr = i12;
                int i13 = this.zzars;
                if (i13 == -1) {
                    i13 = this.height;
                }
                this.zzars = i13;
            } else {
                i5 = -1;
            }
            float f2 = (this.zzarr == i5 || (i7 = this.zzars) == i5) ? -1.0f : (this.height * i6) / (this.width * i7);
            if (this.zzaru) {
                if (this.zzasa == -1.0f || this.zzasb == -1.0f || this.zzasc == -1.0f || this.zzasd == -1.0f || this.zzase == -1.0f || this.zzasf == -1.0f || this.zzasg == -1.0f || this.zzash == -1.0f || this.zzasi == -1.0f || this.zzasj == -1.0f) {
                    bArr = null;
                } else {
                    bArr = new byte[25];
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    wrap.put((byte) 0);
                    wrap.putShort((short) ((this.zzasa * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.zzasb * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.zzasc * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.zzasd * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.zzase * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.zzasf * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.zzasg * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.zzash * 50000.0f) + 0.5f));
                    wrap.putShort((short) (this.zzasi + 0.5f));
                    wrap.putShort((short) (this.zzasj + 0.5f));
                    wrap.putShort((short) this.zzary);
                    wrap.putShort((short) this.zzarz);
                }
                zzpyVar = new zzpy(this.zzarv, this.zzarx, this.zzarw, bArr);
            } else {
                zzpyVar = null;
            }
            zza = zzht.zza(Integer.toString(i2), str3, null, -1, i4, this.width, this.height, -1.0f, singletonList, -1, f2, this.zzahm, this.zzahl, zzpyVar, this.zzahh);
            i8 = 2;
        } else {
            if ("application/x-subrip".equals(str3)) {
                zza = zzht.zza(Integer.toString(i2), str3, (String) null, -1, i11, this.zzahv, this.zzahh);
            } else if (!"application/vobsub".equals(str3) && !str.equals(str3) && !"application/dvbsubs".equals(str3)) {
                throw new zzhw("Unexpected MIME type.");
            } else {
                zza = zzht.zza(Integer.toString(i2), str3, (String) null, -1, singletonList, this.zzahv, this.zzahh);
            }
            i8 = 3;
        }
        zzkh zzc = zzkcVar.zzc(this.number, i8);
        this.zzasp = zzc;
        zzc.zze(zza);
    }

    public /* synthetic */ zzkr(zzkp zzkpVar) {
        this();
    }

    private static List<byte[]> zza(zzpn zzpnVar) throws zzhw {
        try {
            zzpnVar.zzbj(16);
            if (zzpnVar.zziy() != 826496599) {
                return null;
            }
            byte[] bArr = zzpnVar.data;
            for (int position = zzpnVar.getPosition() + 20; position < bArr.length - 4; position++) {
                if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                }
            }
            throw new zzhw("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing FourCC VC1 codec private");
        }
    }

    public static /* synthetic */ String zza(zzkr zzkrVar, String str) {
        zzkrVar.zzahv = str;
        return str;
    }
}
