package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: assets/audience_network.dex */
public final class UI extends C0906Hu {
    public static byte[] A00;
    public static final Pattern A01;
    public static final Pattern A02;
    public static final Pattern A03;

    public static String A06(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 18);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{120, 86, 14, 75, 86, 29, 0, 23, 39, 81, 87, 82, 80, 37, 87, 81, 37, 29, 82, 80, 37, 87, 81, 37, 29, 82, 80, 37, 87, 15, 72, 37, 87, 28, 1, 22, 93, 107, 29, 27, 30, 28, 105, 27, 29, 105, 81, 30, 28, 105, 27, 29, 105, 81, 30, 28, 105, 27, 67, 7, 105, 27, 80, 77, 90, 17, 85, 35, 87, 111, 32, 34, 87, 37, 35, 87, 111, 32, 34, 87, 37, 35, 87, 111, 32, 34, 87, 37, 125, 56, 87, 37, 110, 115, 100, 47};
    }

    static {
        A07();
        A01 = Pattern.compile(A06(8, 29, 107), 32);
        A02 = Pattern.compile(A06(37, 29, 39), 32);
        A03 = Pattern.compile(A06(66, 30, 25), 32);
    }

    public UI(String str, long j2, long j3, long j4, @Nullable File file) {
        super(str, j2, j3, j4, file);
    }

    @Nullable
    public static UI A00(File file, C0910Hy c0910Hy) {
        String name = file.getName();
        if (!name.endsWith(A06(1, 7, 106))) {
            file = A05(file, c0910Hy);
            if (file == null) {
                return null;
            }
            name = file.getName();
        }
        Matcher matcher = A03.matcher(name);
        if (matcher.matches()) {
            long length = file.length();
            int id = Integer.parseInt(matcher.group(1));
            String A0C = c0910Hy.A0C(id);
            if (A0C == null) {
                return null;
            }
            String key = matcher.group(2);
            long parseLong = Long.parseLong(key);
            String key2 = matcher.group(3);
            return new UI(A0C, parseLong, length, Long.parseLong(key2), file);
        }
        return null;
    }

    public static UI A01(String str, long j2) {
        return new UI(str, j2, -1L, -9223372036854775807L, null);
    }

    public static UI A02(String str, long j2) {
        return new UI(str, j2, -1L, -9223372036854775807L, null);
    }

    public static UI A03(String str, long j2, long j3) {
        return new UI(str, j2, j3, -9223372036854775807L, null);
    }

    public static File A04(File file, int i2, long j2, long j3) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        String A06 = A06(0, 1, 68);
        sb.append(A06);
        sb.append(j2);
        sb.append(A06);
        sb.append(j3);
        sb.append(A06(1, 7, 106));
        return new File(file, sb.toString());
    }

    @Nullable
    public static File A05(File file, C0910Hy c0910Hy) {
        String group;
        String name = file.getName();
        Matcher matcher = A02.matcher(name);
        if (matcher.matches()) {
            group = C0923Il.A0O(matcher.group(1));
            if (group == null) {
                return null;
            }
        } else {
            matcher = A01.matcher(name);
            if (!matcher.matches()) {
                return null;
            }
            group = matcher.group(1);
        }
        File A04 = A04(file.getParentFile(), c0910Hy.A08(group), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
        if (file.renameTo(A04)) {
            return A04;
        }
        return null;
    }

    public final UI A08(int i2) {
        I6.A04(this.A05);
        long now = System.currentTimeMillis();
        return new UI(this.A04, this.A02, this.A01, now, A04(this.A03.getParentFile(), i2, this.A02, now));
    }
}
