package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.7K  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C7K {
    public static byte[] A02;
    public static String[] A03 = {"xEW9LSpkxtcMkiVkCjWXuTu5CJHPJiyq", "tTP", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "dhAFlm3SiPB0s9864OvgcmZEVzRtwwmX", "mnE9bSEHBlleLkXo6La2W5bpkmZqSUyN", "0jwmHWkFqK", "xBcWrb6s57BN1yke0uYkFqIHC7aAgPEb", "dL0KwaEpZdlIbw3ka3MpOkzONR5qkJY2"};
    public static final String A04;
    public static volatile C7K A05;
    public final XS A00;
    public final Map<String, C7G> A01 = Collections.synchronizedMap(new HashMap());

    public static String A08(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 89);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A02 = new byte[]{97, 102, 34, 124, 98, 107, 68, 103, 98, 38, 105, 115, 114, 118, 115, 114, 38, 98, 99, 117, 114, 111, 104, 103, 114, 111, 105, 104, 38, 46, 96, 111, 106, 99, 59, 27, 57, 59, 48, 61, 120, 61, 42, 42, 55, 42, 118, 120, 26, 49, 44, 53, 57, 40, 120, 49, 43, 120, 54, 45, 52, 52, 118, 98, 69, 77, 72, 65, 64, 4, 80, 75, 4, 71, 75, 84, 93, 4, 72, 75, 71, 69, 72, 4, 77, 73, 69, 67, 65, 4, 77, 74, 80, 75, 4, 71, 69, 71, 76, 65, 4, 12, 81, 86, 72, 25, 42, 17, 30, 29, 19, 26, 95, 11, 16, 95, 8, Draft_75.CR, 22, 11, 26, 95, 29, 22, 11, 18, 30, 15, 95, 11, 16, 95, 25, 22, 19, 26, 95, 87, 10, Draft_75.CR, 19, 66, 53, 14, 1, 2, 12, 5, 64, 20, 15, 64, 23, 18, 9, 20, 5, 64, 2, 9, 20, Draft_75.CR, 1, 16, 64, 20, 15, 64, 15, 21, 20, 16, 21, 20, 64, 19, 20, 18, 5, 1, Draft_75.CR, 100, 118, 118, 96, 113, 63, 42, 42, 42, 121, 118, 115, 122, 37, 48, 48, 48, 52, 56, 62, 60, 78, 77, 67, 70, 7, 28, 25, 28, 29, 5, 28};
    }

    static {
        A09();
        A04 = C7K.class.getSimpleName();
    }

    public C7K(XS xs) {
        this.A00 = xs;
    }

    private int A00(String str, @Nullable Bitmap bitmap) {
        String A08 = A08(0, 2, 17);
        if (bitmap == null) {
            A0B(null);
            return 0;
        }
        File A07 = A07(this.A00);
        File file = new File(A07, str.hashCode() + A08(2, 4, 85));
        ByteArrayOutputStream byteArrayOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            int size = byteArrayOutputStream.size();
            int size2 = JD.A0D(this.A00);
            if (size >= size2) {
                return 0;
            }
            fileOutputStream = new FileOutputStream(file);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.flush();
            return size;
        } catch (FileNotFoundException e2) {
            String str2 = A04;
            Log.e(str2, A08(6, 29, 95) + file.getPath() + A08, e2);
            A0B(e2);
            return 0;
        } catch (IOException e3) {
            A0B(e3);
            String str3 = A04;
            Log.e(str3, A08(106, 36, 38) + str + A08, e3);
            return 0;
        } catch (OutOfMemoryError e4) {
            A0B(e4);
            Log.e(A04, A08(142, 39, 57), e4);
            return 0;
        } finally {
            A0A(byteArrayOutputStream);
            A0A(fileOutputStream);
        }
    }

    @Nullable
    private final Bitmap A01(C8J c8j, C7G c7g, int i2, int i3, String str) {
        if (C7M.A06(c8j) && A08(202, 4, 123).equals(str)) {
            Map<String, C7G> map = this.A01;
            if (A03[4].charAt(4) != 'b') {
                throw new RuntimeException();
            }
            A03[1] = "FHlvPh";
            map.put(c7g.A07, c7g);
        }
        String str2 = c7g.A07;
        C7L c7l = new C7L(c7g.A05, c7g.A06, A08(197, 5, 0), str, str2);
        File A07 = A07(this.A00);
        File file = new File(A07, str2.hashCode() + A08(2, 4, 85));
        if (!file.exists()) {
            C7M.A04(c8j, c7l, false);
            if (str2.startsWith(A08(190, 7, 70))) {
                return A04(str2, i3, i2);
            }
            return A02(c8j, c7g, str);
        }
        C7M.A04(c8j, c7l, true);
        try {
            if (A0C(i3, i2)) {
                return C7N.A02(file.getCanonicalPath(), i3, i2, this.A00);
            }
            return BitmapFactory.decodeFile(file.getCanonicalPath());
        } catch (IOException e2) {
            A0B(e2);
            return null;
        }
    }

    @Nullable
    private Bitmap A02(C8J c8j, C7G c7g, String str) {
        Bitmap A032;
        String failureReason = c7g.A07;
        int i2 = c7g.A03;
        int i3 = c7g.A04;
        long currentTimeMillis = System.currentTimeMillis();
        IOException e2 = null;
        if (failureReason.startsWith(A08(181, 9, 92))) {
            try {
                try {
                    try {
                        InputStream open = this.A00.getAssets().open(failureReason.substring(9));
                        if (A0C(i2, i3)) {
                            A032 = C7N.A01(open, i2, i3);
                        } else {
                            A032 = BitmapFactory.decodeStream(open);
                        }
                        if (open != null) {
                            A0A(open);
                        }
                    } catch (OutOfMemoryError e3) {
                        A0B(e3);
                        if (0 != 0) {
                            A0A(null);
                        }
                        return null;
                    }
                } catch (IOException e4) {
                    A0B(e4);
                    if (0 != 0) {
                        A0A(null);
                    }
                    return null;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    A0A(null);
                }
                throw th;
            }
        } else if (A0C(i2, i3)) {
            try {
                A032 = A05(failureReason, i2, i3);
            } catch (IOException e5) {
                e2 = e5;
                A0B(e2);
                A032 = A03(failureReason);
            }
            int height = A03[2].length();
            if (height == 5) {
                throw new RuntimeException();
            }
            A03[3] = "EtuvklQgZLPMp8CYh3QQVMKsyyqrprqR";
        } else {
            A032 = A03(failureReason);
        }
        String th2 = e2 != null ? e2.toString() : null;
        if (A032 == null) {
            C7M.A03(c8j, c7g, str, C7M.A03, th2, null, null);
        } else {
            int width = A00(failureReason, A032);
            long requestTime = System.currentTimeMillis();
            long loadTime = requestTime - currentTimeMillis;
            if (width > 0) {
                C7M.A03(c8j, c7g, str, C7M.A02, th2, Integer.valueOf(width), Long.valueOf(loadTime));
            } else {
                int i4 = C7M.A01;
                String[] strArr = A03;
                String str2 = strArr[0];
                String str3 = strArr[6];
                int storedSize = str2.charAt(0);
                if (storedSize != str3.charAt(0)) {
                    C7M.A03(c8j, c7g, str, i4, th2, null, null);
                } else {
                    A03[1] = "v696HPT8k3klpjO3N";
                    C7M.A03(c8j, c7g, str, i4, th2, null, null);
                }
            }
        }
        return A032;
    }

    @Nullable
    private Bitmap A03(String str) {
        byte[] A5l;
        InterfaceC1115Qe ACs = C1134Qx.A00(this.A00).ACs(str, new C1130Qt());
        if (ACs != null && (A5l = ACs.A5l()) != null) {
            return BitmapFactory.decodeByteArray(A5l, 0, A5l.length);
        }
        return null;
    }

    @Nullable
    private Bitmap A04(String str, int i2, int i3) {
        Bitmap A022;
        try {
            boolean A0C = A0C(i2, i3);
            String A08 = A08(190, 7, 70);
            if (!A0C) {
                A022 = BitmapFactory.decodeStream(new FileInputStream(str.substring(A08.length())), null, null);
            } else {
                A022 = C7N.A02(str.substring(A08.length()), i2, i3, this.A00);
            }
            A00(str, A022);
            return A022;
        } catch (IOException e2) {
            String str2 = A04;
            Log.e(str2, A08(63, 43, 125) + str + A08(0, 2, 17), e2);
            return null;
        }
    }

    @Nullable
    private Bitmap A05(String str, int i2, int i3) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        Bitmap A01 = C7N.A01(inputStream, i2, i3);
        A0A(inputStream);
        return A01;
    }

    public static C7K A06(XS xs) {
        if (A05 == null) {
            synchronized (C7K.class) {
                if (A05 == null) {
                    A05 = new C7K(xs);
                }
            }
        }
        return A05;
    }

    public static File A07(C8J c8j) {
        return c8j.getCacheDir();
    }

    public static void A0A(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    private void A0B(@Nullable Throwable th) {
        String A08 = A08(197, 5, 0);
        if (th != null) {
            this.A00.A06().A8q(A08, C06808m.A1S, new C06818n(th));
        } else {
            this.A00.A06().A8q(A08, C06808m.A1S, new C06818n(A08(35, 28, 1)));
        }
    }

    private boolean A0C(int i2, int i3) {
        return i2 > 0 && i3 > 0 && JD.A0w(this.A00);
    }

    @Nullable
    public final Bitmap A0D(C7G c7g) {
        return A01(this.A00, c7g, c7g.A04, c7g.A03, c7g.A01);
    }

    @Nullable
    public final Bitmap A0E(C8J c8j, String str, int i2, int i3, String str2) {
        C7G c7g = this.A01.get(str);
        return (!C7M.A06(c8j) || c7g == null) ? A01(c8j, new C7G(str, i2, i3, A08(206, 7, 43), A08(206, 7, 43)), i3, i2, str2) : A01(c8j, c7g, i3, i2, str2);
    }

    @Nullable
    public final File A0F(String str) {
        File A07 = A07(this.A00);
        File file = new File(A07, str.hashCode() + A08(2, 4, 85));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public final String A0G(String str) {
        File A07 = A07(this.A00);
        File file = new File(A07, str.hashCode() + A08(2, 4, 85));
        return file.exists() ? file.getPath() : str;
    }
}
