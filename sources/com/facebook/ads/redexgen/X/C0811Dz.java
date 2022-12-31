package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.video.ColorInfo;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
@TargetApi(16)
/* renamed from: com.facebook.ads.redexgen.X.Dz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0811Dz {
    public static byte[] A00;
    public static String[] A01 = {"Dbr5x2VsG4nNJUzZeTNPRzqkDjV0oi2y", "sqWbbRPXNyW0qNg4n4LbnWr7GpqemFLg", "VW0orVwJIwlFBZUuevBwAx8XihB6GJeh", "sngGG6Fmd4EPEmkegOhqiaCkbznw5fIQ", "fBp67RXxdXXhweTtV", "xhkPbV6ALkx1WmbrpVNjFTeHYiqbNWEs", "xdguQhXu79c53EOEv", "iU2QkTKnw06iORL4QIBjMVUBldIJ1Brw"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 61);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {102, 106, 105, 106, 119, 40, 119, 100, 107, 98, 96, Draft_75.CR, 1, 2, 1, 28, 67, 29, 26, 15, 0, 10, 15, 28, 10, 99, 111, 108, 111, 114, 45, 116, 114, 97, 110, 115, 102, 101, 114, 0, 16, 7, 78, 92, 80, 70, 25, 71, 64, 85, 64, 93, 87, 25, 93, 90, 82, 91};
        String[] strArr = A01;
        if (strArr[6].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[6] = "x3p0Kh6wVb2g5jx4t";
        strArr2[4] = "ATUwahLadetLCyEQ4";
        A00 = bArr;
    }

    static {
        A01();
    }

    public static void A02(MediaFormat mediaFormat, @Nullable ColorInfo colorInfo) {
        if (colorInfo != null) {
            A04(mediaFormat, A00(25, 14, 61), colorInfo.A03);
            A04(mediaFormat, A00(11, 14, 83), colorInfo.A02);
            A04(mediaFormat, A00(0, 11, 56), colorInfo.A01);
            A05(mediaFormat, A00(43, 15, 9), colorInfo.A04);
        }
    }

    public static void A03(MediaFormat mediaFormat, String str, float f2) {
        if (f2 != -1.0f) {
            mediaFormat.setFloat(str, f2);
        }
    }

    public static void A04(MediaFormat mediaFormat, String str, int i2) {
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
    }

    public static void A05(MediaFormat mediaFormat, String str, @Nullable byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void A06(MediaFormat mediaFormat, List<byte[]> list) {
        int i2 = 0;
        while (true) {
            int size = list.size();
            String[] strArr = A01;
            if (strArr[3].charAt(12) == strArr[2].charAt(12)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[6] = "lAJS3mBUvkodW4hvC";
            strArr2[4] = "VpgNqhxD27ukGqVl1";
            if (i2 < size) {
                mediaFormat.setByteBuffer(A00(39, 4, 94) + i2, ByteBuffer.wrap(list.get(i2)));
                i2++;
            } else {
                return;
            }
        }
    }
}
