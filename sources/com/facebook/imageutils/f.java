package com.facebook.imageutils;

import android.util.Pair;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
/* compiled from: WebpUtil.java */
/* loaded from: classes.dex */
public class f {
    private static boolean a(byte[] bArr, String str) {
        if (bArr.length != str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (str.charAt(i2) != bArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public static int b(InputStream inputStream) throws IOException {
        return ((((byte) inputStream.read()) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (((byte) inputStream.read()) & Draft_75.END_OF_FRAME);
    }

    private static byte c(InputStream inputStream) throws IOException {
        return (byte) (inputStream.read() & 255);
    }

    private static String d(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append((char) b);
        }
        return sb.toString();
    }

    private static int e(InputStream inputStream) throws IOException {
        return ((((byte) inputStream.read()) << 24) & ViewCompat.MEASURED_STATE_MASK) | ((((byte) inputStream.read()) << 16) & 16711680) | ((((byte) inputStream.read()) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (((byte) inputStream.read()) & Draft_75.END_OF_FRAME);
    }

    private static short f(InputStream inputStream) throws IOException {
        return (short) (inputStream.read() & 255);
    }

    @Nullable
    public static Pair<Integer, Integer> g(InputStream inputStream) {
        byte[] bArr = new byte[4];
        try {
            try {
                try {
                    inputStream.read(bArr);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            if (a(bArr, "RIFF")) {
                e(inputStream);
                inputStream.read(bArr);
                if (!a(bArr, "WEBP")) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                }
                inputStream.read(bArr);
                String d2 = d(bArr);
                if ("VP8 ".equals(d2)) {
                    Pair<Integer, Integer> h2 = h(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return h2;
                } else if ("VP8L".equals(d2)) {
                    Pair<Integer, Integer> i2 = i(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return i2;
                } else if (!"VP8X".equals(d2)) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return null;
                } else {
                    Pair<Integer, Integer> j2 = j(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    return j2;
                }
            }
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
        }
    }

    @Nullable
    private static Pair<Integer, Integer> h(InputStream inputStream) throws IOException {
        inputStream.skip(7L);
        short f2 = f(inputStream);
        short f3 = f(inputStream);
        short f4 = f(inputStream);
        if (f2 == 157 && f3 == 1 && f4 == 42) {
            return new Pair<>(Integer.valueOf(b(inputStream)), Integer.valueOf(b(inputStream)));
        }
        return null;
    }

    @Nullable
    private static Pair<Integer, Integer> i(InputStream inputStream) throws IOException {
        e(inputStream);
        if (c(inputStream) != 47) {
            return null;
        }
        int read = ((byte) inputStream.read()) & Draft_75.END_OF_FRAME;
        int read2 = ((byte) inputStream.read()) & Draft_75.END_OF_FRAME;
        return new Pair<>(Integer.valueOf((read | ((read2 & 63) << 8)) + 1), Integer.valueOf(((((((byte) inputStream.read()) & Draft_75.END_OF_FRAME) & 15) << 10) | ((((byte) inputStream.read()) & Draft_75.END_OF_FRAME) << 2) | ((read2 & 192) >> 6)) + 1));
    }

    private static Pair<Integer, Integer> j(InputStream inputStream) throws IOException {
        inputStream.skip(8L);
        return new Pair<>(Integer.valueOf(k(inputStream) + 1), Integer.valueOf(k(inputStream) + 1));
    }

    private static int k(InputStream inputStream) throws IOException {
        byte c = c(inputStream);
        return ((c(inputStream) << 16) & 16711680) | ((c(inputStream) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (c & Draft_75.END_OF_FRAME);
    }
}
