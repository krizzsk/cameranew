package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import com.adjust.sdk.Constants;
import java.io.IOException;
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
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzb {
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039 A[Catch: all -> 0x028d, TryCatch #2 {all -> 0x028d, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x0028, B:12:0x0039, B:14:0x0041, B:18:0x0050, B:20:0x0083, B:22:0x0092, B:26:0x00a6, B:28:0x00b3, B:30:0x00d4, B:32:0x00ee, B:33:0x00fb, B:35:0x0101, B:37:0x0108, B:43:0x011e, B:45:0x0129, B:47:0x0132, B:50:0x014f, B:51:0x0154, B:52:0x017c, B:53:0x017d, B:54:0x0199, B:55:0x019a, B:56:0x01b2, B:57:0x01b3, B:58:0x01ba, B:59:0x01bb, B:60:0x01c2, B:61:0x01c3, B:62:0x01e5, B:63:0x01e6, B:64:0x01fe, B:65:0x01ff, B:66:0x0218, B:67:0x0219, B:68:0x0220, B:69:0x0221, B:70:0x0239, B:71:0x023a, B:72:0x0241, B:73:0x0242, B:74:0x0262, B:75:0x0263, B:76:0x026a, B:77:0x026b, B:78:0x028c), top: B:88:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0263 A[Catch: all -> 0x028d, TryCatch #2 {all -> 0x028d, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x0028, B:12:0x0039, B:14:0x0041, B:18:0x0050, B:20:0x0083, B:22:0x0092, B:26:0x00a6, B:28:0x00b3, B:30:0x00d4, B:32:0x00ee, B:33:0x00fb, B:35:0x0101, B:37:0x0108, B:43:0x011e, B:45:0x0129, B:47:0x0132, B:50:0x014f, B:51:0x0154, B:52:0x017c, B:53:0x017d, B:54:0x0199, B:55:0x019a, B:56:0x01b2, B:57:0x01b3, B:58:0x01ba, B:59:0x01bb, B:60:0x01c2, B:61:0x01c3, B:62:0x01e5, B:63:0x01e6, B:64:0x01fe, B:65:0x01ff, B:66:0x0218, B:67:0x0219, B:68:0x0220, B:69:0x0221, B:70:0x0239, B:71:0x023a, B:72:0x0241, B:73:0x0242, B:74:0x0262, B:75:0x0263, B:76:0x026a, B:77:0x026b, B:78:0x028c), top: B:88:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.security.cert.X509Certificate[][] zza(java.lang.String r19) throws com.google.android.gms.internal.ads.zzh, java.lang.SecurityException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzb.zza(java.lang.String):java.security.cert.X509Certificate[][]");
    }

    private static String zzb(int i2) {
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

    private static int zzc(int i2) {
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

    private static byte[] zzb(ByteBuffer byteBuffer) throws IOException {
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

    private static X509Certificate[][] zza(FileChannel fileChannel, zze zzeVar) throws SecurityException {
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
                byteBuffer = zzeVar.zzb;
                ByteBuffer zza = zza(byteBuffer);
                int i2 = 0;
                while (zza.hasRemaining()) {
                    i2++;
                    try {
                        arrayList.add(zza(zza(zza), hashMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e2) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Failed to parse/verify signer #");
                        sb.append(i2);
                        sb.append(" block");
                        throw new SecurityException(sb.toString(), e2);
                    }
                }
                if (i2 > 0) {
                    if (!hashMap.isEmpty()) {
                        j2 = zzeVar.zzc;
                        j3 = zzeVar.zzd;
                        j4 = zzeVar.zze;
                        byteBuffer2 = zzeVar.zzf;
                        if (!hashMap.isEmpty()) {
                            zzf zzfVar = new zzf(fileChannel, 0L, j2);
                            zzf zzfVar2 = new zzf(fileChannel, j3, j4 - j3);
                            ByteBuffer duplicate = byteBuffer2.duplicate();
                            duplicate.order(ByteOrder.LITTLE_ENDIAN);
                            zzi.zza(duplicate, j2);
                            zzd zzdVar = new zzd(duplicate);
                            int size = hashMap.size();
                            int[] iArr = new int[size];
                            int i3 = 0;
                            for (Integer num : hashMap.keySet()) {
                                iArr[i3] = num.intValue();
                                i3++;
                            }
                            try {
                                byte[][] zza2 = zza(iArr, new zzc[]{zzfVar, zzfVar2, zzdVar});
                                for (int i4 = 0; i4 < size; i4++) {
                                    int i5 = iArr[i4];
                                    if (!MessageDigest.isEqual((byte[]) hashMap.get(Integer.valueOf(i5)), zza2[i4])) {
                                        throw new SecurityException(String.valueOf(zzb(i5)).concat(" digest of contents did not verify"));
                                    }
                                }
                                return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                            } catch (DigestException e3) {
                                throw new SecurityException("Failed to compute digest(s) of contents", e3);
                            }
                        }
                        throw new SecurityException("No digests provided");
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("No signers found");
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x004a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0015 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.security.cert.X509Certificate[] zza(java.nio.ByteBuffer r22, java.util.Map<java.lang.Integer, byte[]> r23, java.security.cert.CertificateFactory r24) throws java.lang.SecurityException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzb.zza(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    private static byte[][] zza(int[] iArr, zzc[] zzcVarArr) throws DigestException {
        long j2;
        zzc[] zzcVarArr2 = zzcVarArr;
        int length = zzcVarArr2.length;
        long j3 = 0;
        int i2 = 0;
        long j4 = 0;
        int i3 = 0;
        while (true) {
            j2 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            if (i3 >= length) {
                break;
            }
            j4 += ((zzcVarArr2[i3].size() + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) - 1) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            i3++;
        }
        if (j4 < 2097151) {
            int i4 = (int) j4;
            byte[][] bArr = new byte[iArr.length];
            for (int i5 = 0; i5 < iArr.length; i5++) {
                byte[] bArr2 = new byte[(zzc(iArr[i5]) * i4) + 5];
                bArr2[0] = 90;
                zza(i4, bArr2, 1);
                bArr[i5] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length2 = iArr.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length2];
            for (int i6 = 0; i6 < iArr.length; i6++) {
                String zzb = zzb(iArr[i6]);
                try {
                    messageDigestArr[i6] = MessageDigest.getInstance(zzb);
                } catch (NoSuchAlgorithmException e2) {
                    throw new RuntimeException(String.valueOf(zzb).concat(" digest not supported"), e2);
                }
            }
            int length3 = zzcVarArr2.length;
            int i7 = 0;
            int i8 = 0;
            while (i7 < length3) {
                zzc zzcVar = zzcVarArr2[i7];
                long j5 = j3;
                int i9 = i8;
                int i10 = length3;
                long size = zzcVar.size();
                while (size > j3) {
                    int min = (int) Math.min(size, j2);
                    zza(min, bArr3, 1);
                    for (int i11 = 0; i11 < length2; i11++) {
                        messageDigestArr[i11].update(bArr3);
                    }
                    long j6 = j5;
                    try {
                        zzcVar.zza(messageDigestArr, j6, min);
                        int i12 = 0;
                        while (i12 < iArr.length) {
                            int i13 = iArr[i12];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i12];
                            int zzc = zzc(i13);
                            int i14 = length2;
                            MessageDigest messageDigest = messageDigestArr[i12];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int i15 = i9;
                            zzc zzcVar2 = zzcVar;
                            int digest = messageDigest.digest(bArr5, (i15 * zzc) + 5, zzc);
                            if (digest != zzc) {
                                String algorithm = messageDigest.getAlgorithm();
                                StringBuilder sb = new StringBuilder(String.valueOf(algorithm).length() + 46);
                                sb.append("Unexpected output size of ");
                                sb.append(algorithm);
                                sb.append(" digest: ");
                                sb.append(digest);
                                throw new RuntimeException(sb.toString());
                            }
                            i12++;
                            i9 = i15;
                            bArr3 = bArr4;
                            length2 = i14;
                            messageDigestArr = messageDigestArr2;
                            zzcVar = zzcVar2;
                        }
                        long j7 = min;
                        long j8 = j6 + j7;
                        size -= j7;
                        i9++;
                        bArr3 = bArr3;
                        messageDigestArr = messageDigestArr;
                        j2 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                        j5 = j8;
                        j3 = 0;
                    } catch (IOException e3) {
                        StringBuilder sb2 = new StringBuilder(59);
                        sb2.append("Failed to digest chunk #");
                        sb2.append(i9);
                        sb2.append(" of section #");
                        sb2.append(i2);
                        throw new DigestException(sb2.toString(), e3);
                    }
                }
                i2++;
                i7++;
                zzcVarArr2 = zzcVarArr;
                i8 = i9;
                length3 = i10;
                messageDigestArr = messageDigestArr;
                j3 = 0;
                j2 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            byte[][] bArr6 = new byte[iArr.length];
            for (int i16 = 0; i16 < iArr.length; i16++) {
                int i17 = iArr[i16];
                byte[] bArr7 = bArr[i16];
                String zzb2 = zzb(i17);
                try {
                    bArr6[i16] = MessageDigest.getInstance(zzb2).digest(bArr7);
                } catch (NoSuchAlgorithmException e4) {
                    throw new RuntimeException(String.valueOf(zzb2).concat(" digest not supported"), e4);
                }
            }
            return bArr6;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Too many chunks: ");
        sb3.append(j4);
        throw new DigestException(sb3.toString());
    }

    private static int zza(int i2) {
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

    private static ByteBuffer zza(ByteBuffer byteBuffer, int i2, int i3) {
        if (i3 >= 8) {
            int capacity = byteBuffer.capacity();
            if (i3 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i3);
                    byteBuffer.position(8);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
            StringBuilder sb = new StringBuilder(41);
            sb.append("end > capacity: ");
            sb.append(i3);
            sb.append(" > ");
            sb.append(capacity);
            throw new IllegalArgumentException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("end < start: ");
        sb2.append(i3);
        sb2.append(" < 8");
        throw new IllegalArgumentException(sb2.toString());
    }

    private static ByteBuffer zza(ByteBuffer byteBuffer, int i2) throws BufferUnderflowException {
        if (i2 >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i3 = i2 + position;
            if (i3 >= position && i3 <= limit) {
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
            throw new BufferUnderflowException();
        }
        StringBuilder sb = new StringBuilder(17);
        sb.append("size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    private static ByteBuffer zza(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i2 = byteBuffer.getInt();
            if (i2 >= 0) {
                if (i2 <= byteBuffer.remaining()) {
                    return zza(byteBuffer, i2);
                }
                int remaining = byteBuffer.remaining();
                StringBuilder sb = new StringBuilder(101);
                sb.append("Length-prefixed field longer than remaining buffer. Field length: ");
                sb.append(i2);
                sb.append(", remaining: ");
                sb.append(remaining);
                throw new IOException(sb.toString());
            }
            throw new IllegalArgumentException("Negative length");
        }
        int remaining2 = byteBuffer.remaining();
        StringBuilder sb2 = new StringBuilder(93);
        sb2.append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
        sb2.append(remaining2);
        throw new IOException(sb2.toString());
    }

    private static void zza(int i2, byte[] bArr, int i3) {
        bArr[1] = (byte) i2;
        bArr[2] = (byte) (i2 >>> 8);
        bArr[3] = (byte) (i2 >>> 16);
        bArr[4] = (byte) (i2 >>> 24);
    }
}
