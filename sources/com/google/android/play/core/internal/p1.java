package com.google.android.play.core.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import com.adjust.sdk.Constants;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class p1 {
    private static int a(int i2) {
        if (i2 != 513) {
            if (i2 != 514) {
                if (i2 != 769) {
                    switch (i2) {
                        case 257:
                        case 259:
                            return 1;
                        case 258:
                        case 260:
                            return 2;
                        default:
                            String valueOf = String.valueOf(Long.toHexString(i2));
                            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(valueOf) : new String("Unknown signature algorithm: 0x"));
                    }
                }
                return 1;
            }
            return 2;
        }
        return 1;
    }

    public static long b(ByteBuffer byteBuffer) {
        s(byteBuffer);
        return c(byteBuffer, byteBuffer.position() + 16);
    }

    private static long c(ByteBuffer byteBuffer, int i2) {
        return byteBuffer.getInt(i2) & 4294967295L;
    }

    static Pair<ByteBuffer, Long> d(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> e2 = e(randomAccessFile, 0);
        return e2 != null ? e2 : e(randomAccessFile, 65535);
    }

    private static Pair<ByteBuffer, Long> e(RandomAccessFile randomAccessFile, int i2) throws IOException {
        int i3;
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i2, (-22) + length)) + 22);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long capacity = length - allocate.capacity();
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        s(allocate);
        int capacity2 = allocate.capacity();
        if (capacity2 >= 22) {
            int i4 = capacity2 - 22;
            int min = Math.min(i4, 65535);
            for (int i5 = 0; i5 < min; i5++) {
                i3 = i4 - i5;
                if (allocate.getInt(i3) == 101010256 && ((char) allocate.getShort(i3 + 20)) == i5) {
                    break;
                }
            }
        }
        i3 = -1;
        if (i3 == -1) {
            return null;
        }
        allocate.position(i3);
        ByteBuffer slice = allocate.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(slice, Long.valueOf(capacity + i3));
    }

    public static String f(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    public static String g(String str, String str2, String str3) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        sb.append(":");
        sb.append(str3);
        return sb.toString();
    }

    private static void h(int i2, byte[] bArr) {
        bArr[1] = (byte) (i2 & 255);
        bArr[2] = (byte) ((i2 >>> 8) & 255);
        bArr[3] = (byte) ((i2 >>> 16) & 255);
        bArr[4] = (byte) (i2 >> 24);
    }

    public static void i(ByteBuffer byteBuffer, long j2) {
        s(byteBuffer);
        int position = byteBuffer.position() + 16;
        if (j2 >= 0 && j2 <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + position, (int) j2);
            return;
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("uint32 value of out range: ");
        sb.append(j2);
        throw new IllegalArgumentException(sb.toString());
    }

    private static void j(Map<Integer, byte[]> map, FileChannel fileChannel, long j2, long j3, long j4, ByteBuffer byteBuffer) throws SecurityException {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        a1 a1Var = new a1(fileChannel, 0L, j2);
        a1 a1Var2 = new a1(fileChannel, j3, j4 - j3);
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        i(duplicate, j2);
        a aVar = new a(duplicate);
        int size = map.size();
        int[] iArr = new int[size];
        int i2 = 0;
        for (Integer num : map.keySet()) {
            iArr[i2] = num.intValue();
            i2++;
        }
        try {
            byte[][] l2 = l(iArr, new d0[]{a1Var, a1Var2, aVar});
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = iArr[i3];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i4)), l2[i3])) {
                    throw new SecurityException(p(i4).concat(" digest of contents did not verify"));
                }
            }
        } catch (DigestException e2) {
            throw new SecurityException("Failed to compute digest(s) of contents", e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
        r11 = a(r5);
        r12 = a(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r11 == 1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (r12 == 1) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014b A[Catch: SignatureException -> 0x026f, InvalidAlgorithmParameterException -> 0x0271, InvalidKeyException -> 0x0273, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x0275, NoSuchAlgorithmException -> 0x0277, TryCatch #5 {InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x0275, blocks: (B:68:0x0135, B:70:0x014b, B:71:0x014e), top: B:138:0x0135 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.security.cert.X509Certificate[] k(java.nio.ByteBuffer r22, java.util.Map<java.lang.Integer, byte[]> r23, java.security.cert.CertificateFactory r24) throws java.lang.SecurityException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.p1.k(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    private static byte[][] l(int[] iArr, d0[] d0VarArr) throws DigestException {
        long j2;
        int i2;
        int length;
        long j3 = 0;
        long j4 = 0;
        int i3 = 0;
        while (true) {
            j2 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            if (i3 >= 3) {
                break;
            }
            j4 += (d0VarArr[i3].a() + 1048575) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            i3++;
        }
        if (j4 >= 2097151) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Too many chunks: ");
            sb.append(j4);
            throw new DigestException(sb.toString());
        }
        int i4 = (int) j4;
        byte[][] bArr = new byte[iArr.length];
        int i5 = 0;
        while (true) {
            length = iArr.length;
            if (i5 >= length) {
                break;
            }
            byte[] bArr2 = new byte[(r(iArr[i5]) * i4) + 5];
            bArr2[0] = 90;
            h(i4, bArr2);
            bArr[i5] = bArr2;
            i5++;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            String p = p(iArr[i6]);
            try {
                messageDigestArr[i6] = MessageDigest.getInstance(p);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(p.concat(" digest not supported"), e2);
            }
        }
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (i2 = 3; i7 < i2; i2 = 3) {
            d0 d0Var = d0VarArr[i7];
            long j5 = j3;
            int i10 = i7;
            long a = d0Var.a();
            while (a > j3) {
                int min = (int) Math.min(a, j2);
                h(min, bArr3);
                for (int i11 = 0; i11 < length; i11++) {
                    messageDigestArr[i11].update(bArr3);
                }
                long j6 = j5;
                try {
                    d0Var.a(messageDigestArr, j6, min);
                    int i12 = 0;
                    while (i12 < iArr.length) {
                        int i13 = iArr[i12];
                        d0 d0Var2 = d0Var;
                        byte[] bArr4 = bArr[i12];
                        int r = r(i13);
                        byte[] bArr5 = bArr3;
                        MessageDigest messageDigest = messageDigestArr[i12];
                        MessageDigest[] messageDigestArr2 = messageDigestArr;
                        int digest = messageDigest.digest(bArr4, (i8 * r) + 5, r);
                        if (digest != r) {
                            String algorithm = messageDigest.getAlgorithm();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(algorithm).length() + 46);
                            sb2.append("Unexpected output size of ");
                            sb2.append(algorithm);
                            sb2.append(" digest: ");
                            sb2.append(digest);
                            throw new RuntimeException(sb2.toString());
                        }
                        i12++;
                        d0Var = d0Var2;
                        bArr3 = bArr5;
                        messageDigestArr = messageDigestArr2;
                    }
                    d0 d0Var3 = d0Var;
                    long j7 = min;
                    long j8 = j6 + j7;
                    a -= j7;
                    i8++;
                    j3 = 0;
                    j2 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    d0Var = d0Var3;
                    j5 = j8;
                    bArr3 = bArr3;
                } catch (IOException e3) {
                    StringBuilder sb3 = new StringBuilder(59);
                    sb3.append("Failed to digest chunk #");
                    sb3.append(i8);
                    sb3.append(" of section #");
                    sb3.append(i9);
                    throw new DigestException(sb3.toString(), e3);
                }
            }
            i9++;
            i7 = i10 + 1;
            j3 = 0;
            j2 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        byte[][] bArr6 = new byte[iArr.length];
        for (int i14 = 0; i14 < iArr.length; i14++) {
            int i15 = iArr[i14];
            byte[] bArr7 = bArr[i14];
            String p2 = p(i15);
            try {
                bArr6[i14] = MessageDigest.getInstance(p2).digest(bArr7);
            } catch (NoSuchAlgorithmException e4) {
                throw new RuntimeException(p2.concat(" digest not supported"), e4);
            }
        }
        return bArr6;
    }

    public static X509Certificate[][] m(String str) throws e, SecurityException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> d2 = d(randomAccessFile);
            if (d2 == null) {
                long length = randomAccessFile.length();
                StringBuilder sb = new StringBuilder(102);
                sb.append("Not an APK file: ZIP End of Central Directory record not found in file with ");
                sb.append(length);
                sb.append(" bytes");
                throw new e(sb.toString());
            }
            ByteBuffer byteBuffer = (ByteBuffer) d2.first;
            long longValue = ((Long) d2.second).longValue();
            long j2 = (-20) + longValue;
            if (j2 >= 0) {
                randomAccessFile.seek(j2);
                if (randomAccessFile.readInt() == 1347094023) {
                    throw new e("ZIP64 APK not supported");
                }
            }
            long b = b(byteBuffer);
            if (b >= longValue) {
                StringBuilder sb2 = new StringBuilder(122);
                sb2.append("ZIP Central Directory offset out of range: ");
                sb2.append(b);
                sb2.append(". ZIP End of Central Directory offset: ");
                sb2.append(longValue);
                throw new e(sb2.toString());
            } else if (o(byteBuffer) + b == longValue) {
                if (b < 32) {
                    StringBuilder sb3 = new StringBuilder(87);
                    sb3.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
                    sb3.append(b);
                    throw new e(sb3.toString());
                }
                ByteBuffer allocate = ByteBuffer.allocate(24);
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                allocate.order(byteOrder);
                randomAccessFile.seek(b - allocate.capacity());
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                    int i2 = 0;
                    long j3 = allocate.getLong(0);
                    if (j3 < allocate.capacity() || j3 > 2147483639) {
                        StringBuilder sb4 = new StringBuilder(57);
                        sb4.append("APK Signing Block size out of range: ");
                        sb4.append(j3);
                        throw new e(sb4.toString());
                    }
                    int i3 = (int) (8 + j3);
                    long j4 = b - i3;
                    if (j4 < 0) {
                        StringBuilder sb5 = new StringBuilder(59);
                        sb5.append("APK Signing Block offset out of range: ");
                        sb5.append(j4);
                        throw new e(sb5.toString());
                    }
                    ByteBuffer allocate2 = ByteBuffer.allocate(i3);
                    allocate2.order(byteOrder);
                    randomAccessFile.seek(j4);
                    randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                    long j5 = allocate2.getLong(0);
                    if (j5 != j3) {
                        StringBuilder sb6 = new StringBuilder(103);
                        sb6.append("APK Signing Block sizes in header and footer do not match: ");
                        sb6.append(j5);
                        sb6.append(" vs ");
                        sb6.append(j3);
                        throw new e(sb6.toString());
                    }
                    Pair create = Pair.create(allocate2, Long.valueOf(j4));
                    ByteBuffer byteBuffer2 = (ByteBuffer) create.first;
                    long longValue2 = ((Long) create.second).longValue();
                    if (byteBuffer2.order() == byteOrder) {
                        int capacity = byteBuffer2.capacity() - 24;
                        if (capacity < 8) {
                            StringBuilder sb7 = new StringBuilder(38);
                            sb7.append("end < start: ");
                            sb7.append(capacity);
                            sb7.append(" < ");
                            sb7.append(8);
                            throw new IllegalArgumentException(sb7.toString());
                        }
                        int capacity2 = byteBuffer2.capacity();
                        if (capacity > byteBuffer2.capacity()) {
                            StringBuilder sb8 = new StringBuilder(41);
                            sb8.append("end > capacity: ");
                            sb8.append(capacity);
                            sb8.append(" > ");
                            sb8.append(capacity2);
                            throw new IllegalArgumentException(sb8.toString());
                        }
                        int limit = byteBuffer2.limit();
                        int position = byteBuffer2.position();
                        byteBuffer2.position(0);
                        byteBuffer2.limit(capacity);
                        byteBuffer2.position(8);
                        ByteBuffer slice = byteBuffer2.slice();
                        slice.order(byteBuffer2.order());
                        byteBuffer2.position(0);
                        byteBuffer2.limit(limit);
                        byteBuffer2.position(position);
                        while (slice.hasRemaining()) {
                            i2++;
                            if (slice.remaining() < 8) {
                                StringBuilder sb9 = new StringBuilder(70);
                                sb9.append("Insufficient data to read size of APK Signing Block entry #");
                                sb9.append(i2);
                                throw new e(sb9.toString());
                            }
                            long j6 = slice.getLong();
                            if (j6 < 4 || j6 > 2147483647L) {
                                StringBuilder sb10 = new StringBuilder(76);
                                sb10.append("APK Signing Block entry #");
                                sb10.append(i2);
                                sb10.append(" size out of range: ");
                                sb10.append(j6);
                                throw new e(sb10.toString());
                            }
                            int i4 = (int) j6;
                            int position2 = slice.position() + i4;
                            if (i4 > slice.remaining()) {
                                int remaining = slice.remaining();
                                StringBuilder sb11 = new StringBuilder(91);
                                sb11.append("APK Signing Block entry #");
                                sb11.append(i2);
                                sb11.append(" size out of range: ");
                                sb11.append(i4);
                                sb11.append(", available: ");
                                sb11.append(remaining);
                                throw new e(sb11.toString());
                            } else if (slice.getInt() == 1896449818) {
                                X509Certificate[][] n = n(randomAccessFile.getChannel(), new o1(q(slice, i4 - 4), longValue2, b, longValue, byteBuffer));
                                randomAccessFile.close();
                                return n;
                            } else {
                                slice.position(position2);
                            }
                        }
                        throw new e("No APK Signature Scheme v2 block in APK Signing Block");
                    }
                    throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
                }
                throw new e("No APK Signing Block before ZIP Central Directory");
            } else {
                throw new e("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
        }
    }

    private static X509Certificate[][] n(FileChannel fileChannel, o1 o1Var) throws SecurityException {
        ByteBuffer byteBuffer;
        long j2;
        long j3;
        long j4;
        ByteBuffer byteBuffer2;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                byteBuffer = o1Var.a;
                ByteBuffer t = t(byteBuffer);
                int i2 = 0;
                while (t.hasRemaining()) {
                    i2++;
                    try {
                        arrayList.add(k(t(t), hashMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e2) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Failed to parse/verify signer #");
                        sb.append(i2);
                        sb.append(" block");
                        throw new SecurityException(sb.toString(), e2);
                    }
                }
                if (i2 > 0) {
                    if (hashMap.isEmpty()) {
                        throw new SecurityException("No content digests found");
                    }
                    j2 = o1Var.b;
                    j3 = o1Var.c;
                    j4 = o1Var.f4857d;
                    byteBuffer2 = o1Var.f4858e;
                    j(hashMap, fileChannel, j2, j3, j4, byteBuffer2);
                    return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                }
                throw new SecurityException("No signers found");
            } catch (IOException e3) {
                throw new SecurityException("Failed to read list of signers", e3);
            }
        } catch (CertificateException e4) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e4);
        }
    }

    public static long o(ByteBuffer byteBuffer) {
        s(byteBuffer);
        return c(byteBuffer, byteBuffer.position() + 12);
    }

    private static String p(int i2) {
        if (i2 != 1) {
            if (i2 == 2) {
                return "SHA-512";
            }
            StringBuilder sb = new StringBuilder(44);
            sb.append("Unknown content digest algorthm: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        return Constants.SHA256;
    }

    private static ByteBuffer q(ByteBuffer byteBuffer, int i2) throws BufferUnderflowException {
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(17);
            sb.append("size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i3 = i2 + position;
        if (i3 < position || i3 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i3);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i3);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    private static int r(int i2) {
        if (i2 != 1) {
            if (i2 == 2) {
                return 64;
            }
            StringBuilder sb = new StringBuilder(44);
            sb.append("Unknown content digest algorthm: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        return 32;
    }

    private static void s(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer t(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            int remaining = byteBuffer.remaining();
            StringBuilder sb = new StringBuilder(93);
            sb.append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
            sb.append(remaining);
            throw new IOException(sb.toString());
        }
        int i2 = byteBuffer.getInt();
        if (i2 >= 0) {
            if (i2 <= byteBuffer.remaining()) {
                return q(byteBuffer, i2);
            }
            int remaining2 = byteBuffer.remaining();
            StringBuilder sb2 = new StringBuilder(101);
            sb2.append("Length-prefixed field longer than remaining buffer. Field length: ");
            sb2.append(i2);
            sb2.append(", remaining: ");
            sb2.append(remaining2);
            throw new IOException(sb2.toString());
        }
        throw new IllegalArgumentException("Negative length");
    }

    private static byte[] u(ByteBuffer byteBuffer) throws IOException {
        int i2 = byteBuffer.getInt();
        if (i2 >= 0) {
            if (i2 <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i2];
                byteBuffer.get(bArr);
                return bArr;
            }
            int remaining = byteBuffer.remaining();
            StringBuilder sb = new StringBuilder(90);
            sb.append("Underflow while reading length-prefixed value. Length: ");
            sb.append(i2);
            sb.append(", available: ");
            sb.append(remaining);
            throw new IOException(sb.toString());
        }
        throw new IOException("Negative length");
    }
}
