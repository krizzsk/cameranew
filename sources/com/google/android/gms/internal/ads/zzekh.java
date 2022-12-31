package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzekh extends zzekc {
    private final byte[] buffer;
    private int pos;
    private int zzakh;
    private int zzimr;
    private int zzimt;
    private int zzimu;
    private final InputStream zzimv;
    private int zzimw;
    private zzekg zzimx;

    private zzekh(InputStream inputStream, int i2) {
        super();
        this.zzimu = Integer.MAX_VALUE;
        this.zzimx = null;
        zzeld.zza(inputStream, "input");
        this.zzimv = inputStream;
        this.buffer = new byte[4096];
        this.zzakh = 0;
        this.pos = 0;
        this.zzimw = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
        if (r2[r3] >= 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzbhk() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.zzakh
            if (r1 == r0) goto L6b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.pos = r3
            return r0
        L11:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6b
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L22
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L68
        L22:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L2f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2d:
            r1 = r3
            goto L68
        L2f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L68
        L3d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6b
        L68:
            r5.pos = r1
            return r0
        L6b:
            long r0 = r5.zzbhh()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekh.zzbhk():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
        if (r2[r0] >= 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long zzbhl() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 189
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekh.zzbhl():long");
    }

    private final int zzbhm() throws IOException {
        int i2 = this.pos;
        if (this.zzakh - i2 < 4) {
            zzgj(4);
            i2 = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i2 + 4;
        return ((bArr[i2 + 3] & Draft_75.END_OF_FRAME) << 24) | (bArr[i2] & Draft_75.END_OF_FRAME) | ((bArr[i2 + 1] & Draft_75.END_OF_FRAME) << 8) | ((bArr[i2 + 2] & Draft_75.END_OF_FRAME) << 16);
    }

    private final long zzbhn() throws IOException {
        int i2 = this.pos;
        if (this.zzakh - i2 < 8) {
            zzgj(8);
            i2 = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i2 + 8;
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    private final void zzbho() {
        int i2 = this.zzakh + this.zzimr;
        this.zzakh = i2;
        int i3 = this.zzimw + i2;
        int i4 = this.zzimu;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.zzimr = i5;
            this.zzakh = i2 - i5;
            return;
        }
        this.zzimr = 0;
    }

    private final byte zzbhp() throws IOException {
        if (this.pos == this.zzakh) {
            zzgj(1);
        }
        byte[] bArr = this.buffer;
        int i2 = this.pos;
        this.pos = i2 + 1;
        return bArr[i2];
    }

    private final byte[] zzg(int i2, boolean z) throws IOException {
        byte[] zzgl = zzgl(i2);
        if (zzgl != null) {
            return zzgl;
        }
        int i3 = this.pos;
        int i4 = this.zzakh;
        int i5 = i4 - i3;
        this.zzimw += i4;
        this.pos = 0;
        this.zzakh = 0;
        List<byte[]> zzgm = zzgm(i2 - i5);
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, i3, bArr, 0, i5);
        for (byte[] bArr2 : zzgm) {
            System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
            i5 += bArr2.length;
        }
        return bArr;
    }

    private final void zzgi(int i2) throws IOException {
        int i3 = this.zzakh;
        int i4 = this.pos;
        if (i2 <= i3 - i4 && i2 >= 0) {
            this.pos = i4 + i2;
        } else if (i2 >= 0) {
            int i5 = this.zzimw;
            int i6 = i5 + i4 + i2;
            int i7 = this.zzimu;
            if (i6 <= i7) {
                this.zzimw = i5 + i4;
                int i8 = i3 - i4;
                this.zzakh = 0;
                this.pos = 0;
                while (i8 < i2) {
                    try {
                        long j2 = i2 - i8;
                        long skip = this.zzimv.skip(j2);
                        int i9 = (skip > 0L ? 1 : (skip == 0L ? 0 : -1));
                        if (i9 >= 0 && skip <= j2) {
                            if (i9 == 0) {
                                break;
                            }
                            i8 += (int) skip;
                        } else {
                            String valueOf = String.valueOf(this.zzimv.getClass());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        }
                    } finally {
                        this.zzimw += i8;
                        zzbho();
                    }
                }
                if (i8 >= i2) {
                    return;
                }
                int i10 = this.zzakh;
                int i11 = i10 - this.pos;
                this.pos = i10;
                zzgj(1);
                while (true) {
                    int i12 = i2 - i11;
                    int i13 = this.zzakh;
                    if (i12 > i13) {
                        i11 += i13;
                        this.pos = i13;
                        zzgj(1);
                    } else {
                        this.pos = i12;
                        return;
                    }
                }
            } else {
                zzgi((i7 - i5) - i4);
                throw zzelo.zzbja();
            }
        } else {
            throw zzelo.zzbjb();
        }
    }

    private final void zzgj(int i2) throws IOException {
        if (zzgk(i2)) {
            return;
        }
        if (i2 > (this.zzimn - this.zzimw) - this.pos) {
            throw zzelo.zzbjg();
        }
        throw zzelo.zzbja();
    }

    private final boolean zzgk(int i2) throws IOException {
        do {
            int i3 = this.pos;
            int i4 = i3 + i2;
            int i5 = this.zzakh;
            if (i4 > i5) {
                int i6 = this.zzimn;
                int i7 = this.zzimw;
                if (i2 > (i6 - i7) - i3 || i7 + i3 + i2 > this.zzimu) {
                    return false;
                }
                if (i3 > 0) {
                    if (i5 > i3) {
                        byte[] bArr = this.buffer;
                        System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                    }
                    this.zzimw += i3;
                    this.zzakh -= i3;
                    this.pos = 0;
                }
                InputStream inputStream = this.zzimv;
                byte[] bArr2 = this.buffer;
                int i8 = this.zzakh;
                int read = inputStream.read(bArr2, i8, Math.min(bArr2.length - i8, (this.zzimn - this.zzimw) - i8));
                if (read == 0 || read < -1 || read > this.buffer.length) {
                    String valueOf = String.valueOf(this.zzimv.getClass());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                    sb.append(valueOf);
                    sb.append("#read(byte[]) returned invalid result: ");
                    sb.append(read);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                } else if (read <= 0) {
                    return false;
                } else {
                    this.zzakh += read;
                    zzbho();
                }
            } else {
                StringBuilder sb2 = new StringBuilder(77);
                sb2.append("refillBuffer() called when ");
                sb2.append(i2);
                sb2.append(" bytes were already available in buffer");
                throw new IllegalStateException(sb2.toString());
            }
        } while (this.zzakh < i2);
        return true;
    }

    private final byte[] zzgl(int i2) throws IOException {
        if (i2 == 0) {
            return zzeld.zzimf;
        }
        if (i2 >= 0) {
            int i3 = this.zzimw;
            int i4 = this.pos;
            int i5 = i3 + i4 + i2;
            if (i5 - this.zzimn <= 0) {
                int i6 = this.zzimu;
                if (i5 <= i6) {
                    int i7 = this.zzakh - i4;
                    int i8 = i2 - i7;
                    if (i8 < 4096 || i8 <= this.zzimv.available()) {
                        byte[] bArr = new byte[i2];
                        System.arraycopy(this.buffer, this.pos, bArr, 0, i7);
                        this.zzimw += this.zzakh;
                        this.pos = 0;
                        this.zzakh = 0;
                        while (i7 < i2) {
                            int read = this.zzimv.read(bArr, i7, i2 - i7);
                            if (read != -1) {
                                this.zzimw += read;
                                i7 += read;
                            } else {
                                throw zzelo.zzbja();
                            }
                        }
                        return bArr;
                    }
                    return null;
                }
                zzgi((i6 - i3) - i4);
                throw zzelo.zzbja();
            }
            throw zzelo.zzbjg();
        }
        throw zzelo.zzbjb();
    }

    private final List<byte[]> zzgm(int i2) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i2 > 0) {
            int min = Math.min(i2, 4096);
            byte[] bArr = new byte[min];
            int i3 = 0;
            while (i3 < min) {
                int read = this.zzimv.read(bArr, i3, min - i3);
                if (read != -1) {
                    this.zzimw += read;
                    i3 += read;
                } else {
                    throw zzelo.zzbja();
                }
            }
            i2 -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzbhn());
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzbhm());
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final String readString() throws IOException {
        int zzbhk = zzbhk();
        if (zzbhk > 0 && zzbhk <= this.zzakh - this.pos) {
            String str = new String(this.buffer, this.pos, zzbhk, zzeld.UTF_8);
            this.pos += zzbhk;
            return str;
        } else if (zzbhk == 0) {
            return "";
        } else {
            if (zzbhk <= this.zzakh) {
                zzgj(zzbhk);
                String str2 = new String(this.buffer, this.pos, zzbhk, zzeld.UTF_8);
                this.pos += zzbhk;
                return str2;
            }
            return new String(zzg(zzbhk, false), zzeld.UTF_8);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final int zzbgs() throws IOException {
        if (zzbhi()) {
            this.zzimt = 0;
            return 0;
        }
        int zzbhk = zzbhk();
        this.zzimt = zzbhk;
        if ((zzbhk >>> 3) != 0) {
            return zzbhk;
        }
        throw zzelo.zzbjd();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final long zzbgt() throws IOException {
        return zzbhl();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final long zzbgu() throws IOException {
        return zzbhl();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final int zzbgv() throws IOException {
        return zzbhk();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final long zzbgw() throws IOException {
        return zzbhn();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final int zzbgx() throws IOException {
        return zzbhm();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final boolean zzbgy() throws IOException {
        return zzbhl() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final String zzbgz() throws IOException {
        byte[] zzg;
        int zzbhk = zzbhk();
        int i2 = this.pos;
        int i3 = this.zzakh;
        if (zzbhk <= i3 - i2 && zzbhk > 0) {
            zzg = this.buffer;
            this.pos = i2 + zzbhk;
        } else if (zzbhk == 0) {
            return "";
        } else {
            if (zzbhk <= i3) {
                zzgj(zzbhk);
                zzg = this.buffer;
                this.pos = zzbhk;
            } else {
                zzg = zzg(zzbhk, false);
            }
            i2 = 0;
        }
        return zzeok.zzo(zzg, i2, zzbhk);
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final zzejr zzbha() throws IOException {
        int zzbhk = zzbhk();
        int i2 = this.zzakh;
        int i3 = this.pos;
        if (zzbhk <= i2 - i3 && zzbhk > 0) {
            zzejr zzi = zzejr.zzi(this.buffer, i3, zzbhk);
            this.pos += zzbhk;
            return zzi;
        } else if (zzbhk == 0) {
            return zzejr.zzilz;
        } else {
            byte[] zzgl = zzgl(zzbhk);
            if (zzgl != null) {
                return zzejr.zzt(zzgl);
            }
            int i4 = this.pos;
            int i5 = this.zzakh;
            int i6 = i5 - i4;
            this.zzimw += i5;
            this.pos = 0;
            this.zzakh = 0;
            List<byte[]> zzgm = zzgm(zzbhk - i6);
            byte[] bArr = new byte[zzbhk];
            System.arraycopy(this.buffer, i4, bArr, 0, i6);
            for (byte[] bArr2 : zzgm) {
                System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
                i6 += bArr2.length;
            }
            return zzejr.zzu(bArr);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final int zzbhb() throws IOException {
        return zzbhk();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final int zzbhc() throws IOException {
        return zzbhk();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final int zzbhd() throws IOException {
        return zzbhm();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final long zzbhe() throws IOException {
        return zzbhn();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final int zzbhf() throws IOException {
        return zzekc.zzgh(zzbhk());
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final long zzbhg() throws IOException {
        return zzekc.zzfg(zzbhl());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzekc
    public final long zzbhh() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte zzbhp = zzbhp();
            j2 |= (zzbhp & Byte.MAX_VALUE) << i2;
            if ((zzbhp & 128) == 0) {
                return j2;
            }
        }
        throw zzelo.zzbjc();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final boolean zzbhi() throws IOException {
        return this.pos == this.zzakh && !zzgk(1);
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final int zzbhj() {
        return this.zzimw + this.pos;
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final void zzgd(int i2) throws zzelo {
        if (this.zzimt != i2) {
            throw zzelo.zzbje();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final boolean zzge(int i2) throws IOException {
        int zzbgs;
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (this.zzakh - this.pos >= 10) {
                while (i4 < 10) {
                    byte[] bArr = this.buffer;
                    int i5 = this.pos;
                    this.pos = i5 + 1;
                    if (bArr[i5] < 0) {
                        i4++;
                    }
                }
                throw zzelo.zzbjc();
            }
            while (i4 < 10) {
                if (zzbhp() < 0) {
                    i4++;
                }
            }
            throw zzelo.zzbjc();
            return true;
        } else if (i3 == 1) {
            zzgi(8);
            return true;
        } else if (i3 == 2) {
            zzgi(zzbhk());
            return true;
        } else if (i3 != 3) {
            if (i3 != 4) {
                if (i3 == 5) {
                    zzgi(4);
                    return true;
                }
                throw zzelo.zzbjf();
            }
            return false;
        } else {
            do {
                zzbgs = zzbgs();
                if (zzbgs == 0) {
                    break;
                }
            } while (zzge(zzbgs));
            zzgd(((i2 >>> 3) << 3) | 4);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final int zzgf(int i2) throws zzelo {
        if (i2 >= 0) {
            int i3 = i2 + this.zzimw + this.pos;
            int i4 = this.zzimu;
            if (i3 <= i4) {
                this.zzimu = i3;
                zzbho();
                return i4;
            }
            throw zzelo.zzbja();
        }
        throw zzelo.zzbjb();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final void zzgg(int i2) {
        this.zzimu = i2;
        zzbho();
    }
}
