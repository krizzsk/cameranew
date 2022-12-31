package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeke extends zzekc {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzimq;
    private int zzimr;
    private int zzims;
    private int zzimt;
    private int zzimu;

    private zzeke(byte[] bArr, int i2, int i3, boolean z) {
        super();
        this.zzimu = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i3 + i2;
        this.pos = i2;
        this.zzims = i2;
        this.zzimq = z;
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
            int r1 = r5.limit
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeke.zzbhk():int");
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeke.zzbhl():long");
    }

    private final int zzbhm() throws IOException {
        int i2 = this.pos;
        if (this.limit - i2 >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i2 + 4;
            return ((bArr[i2 + 3] & Draft_75.END_OF_FRAME) << 24) | (bArr[i2] & Draft_75.END_OF_FRAME) | ((bArr[i2 + 1] & Draft_75.END_OF_FRAME) << 8) | ((bArr[i2 + 2] & Draft_75.END_OF_FRAME) << 16);
        }
        throw zzelo.zzbja();
    }

    private final long zzbhn() throws IOException {
        int i2 = this.pos;
        if (this.limit - i2 >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i2 + 8;
            return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
        }
        throw zzelo.zzbja();
    }

    private final void zzbho() {
        int i2 = this.limit + this.zzimr;
        this.limit = i2;
        int i3 = i2 - this.zzims;
        int i4 = this.zzimu;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.zzimr = i5;
            this.limit = i2 - i5;
            return;
        }
        this.zzimr = 0;
    }

    private final byte zzbhp() throws IOException {
        int i2 = this.pos;
        if (i2 != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i2 + 1;
            return bArr[i2];
        }
        throw zzelo.zzbja();
    }

    private final void zzgi(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (i2 <= i3 - i4) {
                this.pos = i4 + i2;
                return;
            }
        }
        if (i2 < 0) {
            throw zzelo.zzbjb();
        }
        throw zzelo.zzbja();
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
        if (zzbhk > 0 && zzbhk <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzbhk, zzeld.UTF_8);
            this.pos += zzbhk;
            return str;
        } else if (zzbhk == 0) {
            return "";
        } else {
            if (zzbhk < 0) {
                throw zzelo.zzbjb();
            }
            throw zzelo.zzbja();
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
        int zzbhk = zzbhk();
        if (zzbhk > 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (zzbhk <= i2 - i3) {
                String zzo = zzeok.zzo(this.buffer, i3, zzbhk);
                this.pos += zzbhk;
                return zzo;
            }
        }
        if (zzbhk == 0) {
            return "";
        }
        if (zzbhk <= 0) {
            throw zzelo.zzbjb();
        }
        throw zzelo.zzbja();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final zzejr zzbha() throws IOException {
        byte[] bArr;
        int zzbhk = zzbhk();
        if (zzbhk > 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (zzbhk <= i2 - i3) {
                zzejr zzi = zzejr.zzi(this.buffer, i3, zzbhk);
                this.pos += zzbhk;
                return zzi;
            }
        }
        if (zzbhk == 0) {
            return zzejr.zzilz;
        }
        if (zzbhk > 0) {
            int i4 = this.limit;
            int i5 = this.pos;
            if (zzbhk <= i4 - i5) {
                int i6 = zzbhk + i5;
                this.pos = i6;
                bArr = Arrays.copyOfRange(this.buffer, i5, i6);
                return zzejr.zzu(bArr);
            }
        }
        if (zzbhk <= 0) {
            if (zzbhk == 0) {
                bArr = zzeld.zzimf;
                return zzejr.zzu(bArr);
            }
            throw zzelo.zzbjb();
        }
        throw zzelo.zzbja();
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
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final int zzbhj() {
        return this.pos - this.zzims;
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
            if (this.limit - this.pos >= 10) {
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
            int zzbhj = i2 + zzbhj();
            int i3 = this.zzimu;
            if (zzbhj <= i3) {
                this.zzimu = zzbhj;
                zzbho();
                return i3;
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
