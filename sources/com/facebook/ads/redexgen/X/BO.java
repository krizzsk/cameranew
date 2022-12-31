package com.facebook.ads.redexgen.X;

import android.media.AudioTrack;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class BO {
    public static String[] A06 = {"W1h", "J3B5KCEbjjwmRuC3OBjGZe6Vqq", "m9qFzMc74R8svEUC9gqMjQn", "jgNIoR8qAkaEc7us150M5yTFbz", "3ys", "w1u", "bbeJnzocKvEAyVfPIveapdYFC3HTaXea", "5a1"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    @Nullable
    public final BM A05;

    public BO(AudioTrack audioTrack) {
        if (C0923Il.A02 >= 19) {
            this.A05 = new BM(audioTrack);
            A05();
            return;
        }
        this.A05 = null;
        A00(3);
    }

    private void A00(int i2) {
        this.A00 = i2;
        if (i2 == 0) {
            this.A03 = 0L;
            this.A01 = -1L;
            this.A02 = System.nanoTime() / 1000;
            this.A04 = 5000L;
        } else if (i2 == 1) {
            this.A04 = 5000L;
        } else if (i2 == 2 || i2 == 3) {
            this.A04 = 10000000L;
        } else if (i2 == 4) {
            this.A04 = 500000L;
        } else {
            throw new IllegalStateException();
        }
    }

    public final long A01() {
        BM bm = this.A05;
        if (bm != null) {
            return bm.A00();
        }
        return -1L;
    }

    public final long A02() {
        BM bm = this.A05;
        if (bm != null) {
            return bm.A01();
        }
        return -9223372036854775807L;
    }

    public final void A03() {
        if (this.A00 == 4) {
            A05();
        }
    }

    public final void A04() {
        A00(4);
    }

    public final void A05() {
        if (this.A05 != null) {
            A00(0);
        }
    }

    public final boolean A06() {
        int i2 = this.A00;
        return i2 == 1 || i2 == 2;
    }

    public final boolean A07() {
        return this.A00 == 2;
    }

    public final boolean A08(long timestampPositionFrames) {
        BM bm = this.A05;
        if (bm == null || timestampPositionFrames - this.A03 < this.A04) {
            return false;
        }
        this.A03 = timestampPositionFrames;
        boolean A02 = bm.A02();
        int i2 = this.A00;
        if (i2 == 0) {
            if (A02) {
                if (this.A05.A01() >= this.A02) {
                    this.A01 = this.A05.A00();
                    String[] strArr = A06;
                    if (strArr[1].length() != strArr[3].length()) {
                        A00(1);
                        return A02;
                    }
                    String[] strArr2 = A06;
                    strArr2[5] = "X7O";
                    strArr2[4] = "dhv";
                    A00(1);
                    return A02;
                }
                return false;
            } else if (timestampPositionFrames - this.A02 > 500000) {
                A00(3);
                return A02;
            } else {
                return A02;
            }
        } else if (i2 == 1) {
            if (A02) {
                if (this.A05.A00() > this.A01) {
                    A00(2);
                    return A02;
                }
                return A02;
            }
            A05();
            return A02;
        } else if (i2 == 2) {
            if (!A02) {
                A05();
                return A02;
            }
            return A02;
        } else if (i2 == 3) {
            if (A02) {
                A05();
                return A02;
            }
            return A02;
        } else {
            String[] strArr3 = A06;
            if (strArr3[0].length() != strArr3[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr4 = A06;
            strArr4[5] = "KBr";
            strArr4[4] = "FWj";
            if (i2 != 4) {
                throw new IllegalStateException();
            }
            return A02;
        }
    }
}
