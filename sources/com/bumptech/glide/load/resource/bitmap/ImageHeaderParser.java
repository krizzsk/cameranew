package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MotionEventCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes.dex */
public class ImageHeaderParser {
    private static final byte[] b;
    private static final int[] c = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private final b a;

    /* loaded from: classes.dex */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        PNG_A(true),
        PNG(false),
        UNKNOWN(false);
        
        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final ByteBuffer a;

        public a(byte[] bArr) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.a = wrap;
            wrap.order(ByteOrder.BIG_ENDIAN);
        }

        public short a(int i2) {
            return this.a.getShort(i2);
        }

        public int b(int i2) {
            return this.a.getInt(i2);
        }

        public int c() {
            return this.a.array().length;
        }

        public void d(ByteOrder byteOrder) {
            this.a.order(byteOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private final InputStream a;

        public b(InputStream inputStream) {
            this.a = inputStream;
        }

        public int a() throws IOException {
            return this.a.read();
        }

        public int b() throws IOException {
            return ((this.a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.a.read() & 255);
        }

        public short c() throws IOException {
            return (short) (this.a.read() & 255);
        }

        public int d(byte[] bArr) throws IOException {
            int length = bArr.length;
            while (length > 0) {
                int read = this.a.read(bArr, bArr.length - length, length);
                if (read == -1) {
                    break;
                }
                length -= read;
            }
            return bArr.length - length;
        }

        public long e(long j2) throws IOException {
            if (j2 < 0) {
                return 0L;
            }
            long j3 = j2;
            while (j3 > 0) {
                long skip = this.a.skip(j3);
                if (skip <= 0) {
                    if (this.a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j3 -= skip;
            }
            return j2 - j3;
        }
    }

    static {
        byte[] bArr = new byte[0];
        try {
            bArr = "Exif\u0000\u0000".getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        b = bArr;
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.a = new b(inputStream);
    }

    private static int a(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    private byte[] b() throws IOException {
        short c2;
        short c3;
        int b2;
        long j2;
        long e2;
        do {
            if (this.a.c() != 255) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unknown segmentId=" + ((int) c2));
                }
                return null;
            }
            c3 = this.a.c();
            if (c3 == 218) {
                return null;
            }
            if (c3 == 217) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return null;
            }
            b2 = this.a.b() - 2;
            if (c3 != 225) {
                j2 = b2;
                e2 = this.a.e(j2);
            } else {
                byte[] bArr = new byte[b2];
                int d2 = this.a.d(bArr);
                if (d2 != b2) {
                    if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Unable to read segment data, type: " + ((int) c3) + ", length: " + b2 + ", actually read: " + d2);
                    }
                    return null;
                }
                return bArr;
            }
        } while (e2 == j2);
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + ((int) c3) + ", wanted to skip: " + b2 + ", but actually skipped: " + e2);
        }
        return null;
    }

    private static boolean e(int i2) {
        return (i2 & 65496) == 65496 || i2 == 19789 || i2 == 18761;
    }

    private static int g(a aVar) {
        ByteOrder byteOrder;
        short a2 = aVar.a(6);
        if (a2 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (a2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + ((int) a2));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        aVar.d(byteOrder);
        int b2 = aVar.b(10) + 6;
        short a3 = aVar.a(b2);
        for (int i2 = 0; i2 < a3; i2++) {
            int a4 = a(b2, i2);
            short a5 = aVar.a(a4);
            if (a5 == 274) {
                short a6 = aVar.a(a4 + 2);
                if (a6 >= 1 && a6 <= 12) {
                    int b3 = aVar.b(a4 + 4);
                    if (b3 < 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + i2 + " tagType=" + ((int) a5) + " formatCode=" + ((int) a6) + " componentCount=" + b3);
                        }
                        int i3 = b3 + c[a6];
                        if (i3 > 4) {
                            if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) a6));
                            }
                        } else {
                            int i4 = a4 + 8;
                            if (i4 >= 0 && i4 <= aVar.c()) {
                                if (i3 >= 0 && i3 + i4 <= aVar.c()) {
                                    return aVar.a(i4);
                                }
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) a5));
                                }
                            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) a5));
                            }
                        }
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Got invalid format code=" + ((int) a6));
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int c() throws java.io.IOException {
        /*
            r7 = this;
            com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$b r0 = r7.a
            int r0 = r0.b()
            boolean r0 = e(r0)
            r1 = -1
            if (r0 != 0) goto Le
            return r1
        Le:
            byte[] r0 = r7.b()
            r2 = 0
            if (r0 == 0) goto L1d
            int r3 = r0.length
            byte[] r4 = com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.b
            int r4 = r4.length
            if (r3 <= r4) goto L1d
            r3 = 1
            goto L1e
        L1d:
            r3 = 0
        L1e:
            if (r3 == 0) goto L30
            r4 = 0
        L21:
            byte[] r5 = com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.b
            int r6 = r5.length
            if (r4 >= r6) goto L30
            r6 = r0[r4]
            r5 = r5[r4]
            if (r6 == r5) goto L2d
            goto L31
        L2d:
            int r4 = r4 + 1
            goto L21
        L30:
            r2 = r3
        L31:
            if (r2 == 0) goto L3d
            com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$a r1 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$a
            r1.<init>(r0)
            int r0 = g(r1)
            return r0
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.c():int");
    }

    public ImageType d() throws IOException {
        int b2 = this.a.b();
        if (b2 == 65496) {
            return ImageType.JPEG;
        }
        int b3 = ((b2 << 16) & SupportMenu.CATEGORY_MASK) | (this.a.b() & 65535);
        if (b3 == -1991225785) {
            this.a.e(21L);
            return this.a.a() >= 3 ? ImageType.PNG_A : ImageType.PNG;
        } else if ((b3 >> 8) == 4671814) {
            return ImageType.GIF;
        } else {
            return ImageType.UNKNOWN;
        }
    }

    public boolean f() throws IOException {
        return d().hasAlpha();
    }
}
