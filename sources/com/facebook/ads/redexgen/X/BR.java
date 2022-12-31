package com.facebook.ads.redexgen.X;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.WorkRequest;
import com.tencent.connect.common.Constants;
import java.lang.reflect.Method;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class BR {
    public static byte[] A0P;
    public static String[] A0Q = {"2OZtSKqBdCORReWjwkUHUNaFdmP57qD6", "wxnNTeBLYydyQqASc88t", "NZCt4jZqJZROeAh1myX6H7SaBhvHRhTJ", ExifInterface.LONGITUDE_WEST, "cvmaUkh2yailCvlRg0", "9zfhSGNjdoCRl8j9ORTvg70vvPJm", "N6Pae7kbdU7K2JDJ7pHsGdlVXSdZHDtL", "MG3JHDBNbYnrrwGYpH7tUB1vkoKXKxdT"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public long A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public long A0C;
    public long A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public AudioTrack A0H;
    public BO A0I;
    public Method A0J;
    public boolean A0K;
    public boolean A0L;
    public boolean A0M;
    public final BP A0N;
    public final long[] A0O;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0P, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 82);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A0P = new byte[]{119, 117, 100, 92, 113, 100, 117, 126, 115, 105};
    }

    static {
        A06();
    }

    public BR(BP bp) {
        this.A0N = (BP) I6.A01(bp);
        if (C0923Il.A02 >= 18) {
            try {
                this.A0J = AudioTrack.class.getMethod(A03(0, 10, 66), null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.A0O = new long[10];
    }

    private long A00() {
        if (this.A0G != -9223372036854775807L) {
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            if (A0Q[6].charAt(23) != 'U') {
                A0Q[3] = Constants.VIA_TO_TYPE_QZONE;
                long j2 = elapsedRealtime - this.A0G;
                long framesSinceStop = this.A06;
                return Math.min(framesSinceStop, this.A0F + ((this.A03 * j2) / 1000000));
            }
            throw new RuntimeException();
        }
        int playState = this.A0H.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & this.A0H.getPlaybackHeadPosition();
        if (this.A0M) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.A0C = this.A0A;
            }
            playbackHeadPosition += this.A0C;
        }
        if (C0923Il.A02 <= 28) {
            if (playbackHeadPosition == 0) {
                int i2 = (this.A0A > 0L ? 1 : (this.A0A == 0L ? 0 : -1));
                if (A0Q[2].charAt(13) == 'g') {
                    throw new RuntimeException();
                }
                A0Q[7] = "Jf7te8MTt0xB0AnyTHSRJJahUuQs4RIN";
                if (i2 > 0 && playState == 3) {
                    if (this.A07 == -9223372036854775807L) {
                        this.A07 = SystemClock.elapsedRealtime();
                    }
                    return this.A0A;
                }
            }
            this.A07 = -9223372036854775807L;
        }
        if (this.A0A > playbackHeadPosition) {
            this.A0D++;
        }
        this.A0A = playbackHeadPosition;
        return (this.A0D << 32) + playbackHeadPosition;
    }

    private long A01() {
        return A02(A00());
    }

    private long A02(long j2) {
        return (1000000 * j2) / this.A03;
    }

    private void A04() {
        long systemTimeUs = A01();
        if (systemTimeUs == 0) {
            return;
        }
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.A09 >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            long[] jArr = this.A0O;
            int i2 = this.A01;
            jArr[i2] = systemTimeUs - nanoTime;
            this.A01 = (i2 + 1) % 10;
            int i3 = this.A04;
            if (i3 < 10) {
                int i4 = i3 + 1;
                if (A0Q[7].charAt(25) == 'h') {
                    throw new RuntimeException();
                }
                A0Q[7] = "0ZtCyKtQlXFIE9UJw5KWgAyqZz9KpR2W";
                this.A04 = i4;
            }
            this.A09 = nanoTime;
            this.A0E = 0L;
            int i5 = 0;
            while (true) {
                int i6 = this.A04;
                if (i5 >= i6) {
                    break;
                }
                this.A0E += this.A0O[i5] / i6;
                i5++;
            }
        }
        boolean z = this.A0M;
        if (A0Q[3].length() == 1) {
            A0Q[7] = "QKSLI2et0ddSkJpCy6yOqBE4Y3BrEDug";
            if (z) {
                return;
            }
        } else if (z) {
            return;
        }
        A08(nanoTime, systemTimeUs);
        A07(nanoTime);
    }

    private void A05() {
        this.A0E = 0L;
        this.A04 = 0;
        this.A01 = 0;
        this.A09 = 0L;
    }

    private void A07(long j2) {
        Method method;
        if (this.A0L && (method = this.A0J) != null && j2 - this.A08 >= 500000) {
            try {
                this.A0B = (((Integer) method.invoke(this.A0H, null)).intValue() * 1000) - this.A05;
                this.A0B = Math.max(this.A0B, 0L);
                if (this.A0B > 5000000) {
                    this.A0N.AAw(this.A0B);
                    this.A0B = 0L;
                }
            } catch (Exception unused) {
                this.A0J = null;
            }
            this.A08 = j2;
        }
    }

    private void A08(long j2, long audioTimestampSystemTimeUs) {
        if (!this.A0I.A08(j2)) {
            return;
        }
        long A02 = this.A0I.A02();
        long audioTimestampPositionFrames = this.A0I.A01();
        if (Math.abs(A02 - j2) > 5000000) {
            this.A0N.ACE(audioTimestampPositionFrames, A02, j2, audioTimestampSystemTimeUs);
            this.A0I.A04();
        } else if (Math.abs(A02(audioTimestampPositionFrames) - audioTimestampSystemTimeUs) > 5000000) {
            this.A0N.ABg(audioTimestampPositionFrames, A02, j2, audioTimestampSystemTimeUs);
            this.A0I.A04();
        } else {
            this.A0I.A03();
        }
    }

    private boolean A09() {
        return this.A0M && this.A0H.getPlayState() == 2 && A00() == 0;
    }

    public static boolean A0A(int i2) {
        return C0923Il.A02 < 23 && (i2 == 5 || i2 == 6);
    }

    public final int A0B(long j2) {
        return this.A00 - ((int) (j2 - (A00() * this.A02)));
    }

    public final long A0C(boolean z) {
        long positionUs;
        if (this.A0H.getPlayState() == 3) {
            A04();
        }
        long nanoTime = System.nanoTime();
        if (A0Q[7].charAt(25) != 'h') {
            String[] strArr = A0Q;
            strArr[5] = "wFaGh6b5RiCG631f3S8Lg8JJUGkJ";
            strArr[1] = "CitVBV12pOqWvHiAj7sv";
            long j2 = nanoTime / 1000;
            if (this.A0I.A06()) {
                long timestampPositionFrames = this.A0I.A01();
                long A02 = A02(timestampPositionFrames);
                if (!this.A0I.A07()) {
                    return A02;
                }
                long timestampPositionUs = this.A0I.A02();
                return A02 + (j2 - timestampPositionUs);
            }
            if (this.A04 == 0) {
                positionUs = A01();
            } else {
                long positionUs2 = this.A0E;
                positionUs = positionUs2 + j2;
            }
            if (!z) {
                return positionUs - this.A0B;
            }
            return positionUs;
        }
        throw new RuntimeException();
    }

    public final void A0D() {
        A05();
        this.A0H = null;
        this.A0I = null;
    }

    public final void A0E() {
        this.A0I.A05();
    }

    public final void A0F(long j2) {
        this.A0F = A00();
        this.A0G = SystemClock.elapsedRealtime() * 1000;
        this.A06 = j2;
    }

    public final void A0G(AudioTrack audioTrack, int i2, int i3, int i4) {
        this.A0H = audioTrack;
        this.A02 = i3;
        this.A00 = i4;
        this.A0I = new BO(audioTrack);
        this.A03 = audioTrack.getSampleRate();
        this.A0M = A0A(i2);
        this.A0L = C0923Il.A0c(i2);
        this.A05 = this.A0L ? A02(i4 / i3) : -9223372036854775807L;
        this.A0A = 0L;
        this.A0D = 0L;
        this.A0C = 0L;
        this.A0K = false;
        this.A0G = -9223372036854775807L;
        this.A07 = -9223372036854775807L;
        this.A0B = 0L;
    }

    public final boolean A0H() {
        return this.A0H.getPlayState() == 3;
    }

    public final boolean A0I() {
        A05();
        if (this.A0G == -9223372036854775807L) {
            this.A0I.A05();
            String[] strArr = A0Q;
            if (strArr[5].length() != strArr[1].length()) {
                String[] strArr2 = A0Q;
                strArr2[5] = "GAvEeTbbpJy4dkpTDH1oMJCt3ihg";
                strArr2[1] = "Fc6P1TrRc3WwbWBQIjag";
                return true;
            }
            throw new RuntimeException();
        }
        return false;
    }

    public final boolean A0J(long j2) {
        return j2 > A00() || A09();
    }

    public final boolean A0K(long j2) {
        if (this.A07 != -9223372036854775807L) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (A0Q[3].length() != 1) {
                throw new RuntimeException();
            }
            A0Q[2] = "WkbNChvAjAmG4HStnLH3XRlXL7LoLVfn";
            if (i2 > 0 && SystemClock.elapsedRealtime() - this.A07 >= 200) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0L(long j2) {
        BP bp;
        int playState = this.A0H.getPlayState();
        if (this.A0M) {
            if (playState == 2) {
                this.A0K = false;
                return false;
            } else if (playState == 1 && A00() == 0) {
                return false;
            }
        }
        boolean z = this.A0K;
        this.A0K = A0J(j2);
        if (z && !this.A0K && playState != 1 && (bp = this.A0N) != null) {
            bp.ACL(this.A00, A3.A01(this.A05));
        }
        return true;
    }
}
