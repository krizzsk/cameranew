package cn.sharesdk.framework.utils.QRCodeUtil.a;

import cn.sharesdk.framework.utils.QRCodeUtil.WriterException;
import cn.sharesdk.framework.utils.QRCodeUtil.g;
import cn.sharesdk.framework.utils.QRCodeUtil.i;
import cn.sharesdk.framework.utils.QRCodeUtil.m;
import cn.sharesdk.framework.utils.QRCodeUtil.n;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
/* compiled from: Encoder.java */
/* loaded from: classes.dex */
public final class c {
    private static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Encoder.java */
    /* renamed from: cn.sharesdk.framework.utils.QRCodeUtil.a.c$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.values().length];
            a = iArr;
            try {
                iArr[i.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[i.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static int a(b bVar) {
        return d.a(bVar) + d.b(bVar) + d.c(bVar) + d.d(bVar);
    }

    static void b(CharSequence charSequence, cn.sharesdk.framework.utils.QRCodeUtil.b bVar) throws WriterException {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int a2 = a(charSequence.charAt(i2));
            if (a2 == -1) {
                throw new WriterException();
            }
            int i3 = i2 + 1;
            if (i3 < length) {
                int a3 = a(charSequence.charAt(i3));
                if (a3 != -1) {
                    bVar.a((a2 * 45) + a3, 11);
                    i2 += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                bVar.a(a2, 6);
                i2 = i3;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static cn.sharesdk.framework.utils.QRCodeUtil.a.f a(java.lang.String r7, cn.sharesdk.framework.utils.QRCodeUtil.f r8, java.util.Map<cn.sharesdk.framework.utils.QRCodeUtil.e, ?> r9) throws cn.sharesdk.framework.utils.QRCodeUtil.WriterException {
        /*
            r0 = 1
            r1 = 0
            if (r9 == 0) goto Le
            cn.sharesdk.framework.utils.QRCodeUtil.e r2 = cn.sharesdk.framework.utils.QRCodeUtil.e.CHARACTER_SET
            boolean r2 = r9.containsKey(r2)
            if (r2 == 0) goto Le
            r2 = 1
            goto Lf
        Le:
            r2 = 0
        Lf:
            if (r2 == 0) goto L1c
            cn.sharesdk.framework.utils.QRCodeUtil.e r3 = cn.sharesdk.framework.utils.QRCodeUtil.e.CHARACTER_SET
            java.lang.Object r3 = r9.get(r3)
            java.lang.String r3 = r3.toString()
            goto L1e
        L1c:
            java.lang.String r3 = "ISO-8859-1"
        L1e:
            cn.sharesdk.framework.utils.QRCodeUtil.i r4 = a(r7, r3)
            cn.sharesdk.framework.utils.QRCodeUtil.b r5 = new cn.sharesdk.framework.utils.QRCodeUtil.b
            r5.<init>()
            cn.sharesdk.framework.utils.QRCodeUtil.i r6 = cn.sharesdk.framework.utils.QRCodeUtil.i.BYTE
            if (r4 != r6) goto L36
            if (r2 == 0) goto L36
            cn.sharesdk.framework.utils.QRCodeUtil.d r2 = cn.sharesdk.framework.utils.QRCodeUtil.d.a(r3)
            if (r2 == 0) goto L36
            a(r2, r5)
        L36:
            if (r9 == 0) goto L41
            cn.sharesdk.framework.utils.QRCodeUtil.e r2 = cn.sharesdk.framework.utils.QRCodeUtil.e.GS1_FORMAT
            boolean r2 = r9.containsKey(r2)
            if (r2 == 0) goto L41
            goto L42
        L41:
            r0 = 0
        L42:
            if (r0 == 0) goto L5d
            cn.sharesdk.framework.utils.QRCodeUtil.e r0 = cn.sharesdk.framework.utils.QRCodeUtil.e.GS1_FORMAT
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L5d
            cn.sharesdk.framework.utils.QRCodeUtil.i r0 = cn.sharesdk.framework.utils.QRCodeUtil.i.FNC1_FIRST_POSITION
            a(r0, r5)
        L5d:
            a(r4, r5)
            cn.sharesdk.framework.utils.QRCodeUtil.b r0 = new cn.sharesdk.framework.utils.QRCodeUtil.b
            r0.<init>()
            a(r7, r4, r0, r3)
            if (r9 == 0) goto L95
            cn.sharesdk.framework.utils.QRCodeUtil.e r1 = cn.sharesdk.framework.utils.QRCodeUtil.e.QR_VERSION
            boolean r2 = r9.containsKey(r1)
            if (r2 == 0) goto L95
            java.lang.Object r9 = r9.get(r1)
            java.lang.String r9 = r9.toString()
            int r9 = java.lang.Integer.parseInt(r9)
            cn.sharesdk.framework.utils.QRCodeUtil.n r9 = cn.sharesdk.framework.utils.QRCodeUtil.n.a(r9)
            int r1 = a(r4, r5, r0, r9)
            boolean r1 = a(r1, r9, r8)
            if (r1 == 0) goto L8d
            goto L99
        L8d:
            cn.sharesdk.framework.utils.QRCodeUtil.WriterException r7 = new cn.sharesdk.framework.utils.QRCodeUtil.WriterException
            java.lang.String r8 = "Data too big for requested version"
            r7.<init>(r8)
            throw r7
        L95:
            cn.sharesdk.framework.utils.QRCodeUtil.n r9 = a(r8, r4, r5, r0)
        L99:
            cn.sharesdk.framework.utils.QRCodeUtil.b r1 = new cn.sharesdk.framework.utils.QRCodeUtil.b
            r1.<init>()
            r1.a(r5)
            if (r4 != r6) goto La8
            int r7 = r0.b()
            goto Lac
        La8:
            int r7 = r7.length()
        Lac:
            a(r7, r9, r4, r1)
            r1.a(r0)
            cn.sharesdk.framework.utils.QRCodeUtil.n$b r7 = r9.a(r8)
            int r0 = r9.b()
            int r2 = r7.c()
            int r0 = r0 - r2
            a(r0, r1)
            int r2 = r9.b()
            int r7 = r7.b()
            cn.sharesdk.framework.utils.QRCodeUtil.b r7 = a(r1, r2, r0, r7)
            cn.sharesdk.framework.utils.QRCodeUtil.a.f r0 = new cn.sharesdk.framework.utils.QRCodeUtil.a.f
            r0.<init>()
            r0.a(r8)
            r0.a(r4)
            r0.a(r9)
            int r1 = r9.c()
            cn.sharesdk.framework.utils.QRCodeUtil.a.b r2 = new cn.sharesdk.framework.utils.QRCodeUtil.a.b
            r2.<init>(r1, r1)
            int r1 = a(r7, r8, r9, r2)
            r0.a(r1)
            cn.sharesdk.framework.utils.QRCodeUtil.a.e.a(r7, r8, r9, r1, r2)
            r0.a(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.utils.QRCodeUtil.a.c.a(java.lang.String, cn.sharesdk.framework.utils.QRCodeUtil.f, java.util.Map):cn.sharesdk.framework.utils.QRCodeUtil.a.f");
    }

    private static n a(cn.sharesdk.framework.utils.QRCodeUtil.f fVar, i iVar, cn.sharesdk.framework.utils.QRCodeUtil.b bVar, cn.sharesdk.framework.utils.QRCodeUtil.b bVar2) throws WriterException {
        return a(a(iVar, bVar, bVar2, a(a(iVar, bVar, bVar2, n.a(1)), fVar)), fVar);
    }

    private static int a(i iVar, cn.sharesdk.framework.utils.QRCodeUtil.b bVar, cn.sharesdk.framework.utils.QRCodeUtil.b bVar2, n nVar) {
        return bVar.a() + iVar.a(nVar) + bVar2.a();
    }

    static int a(int i2) {
        int[] iArr = a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    private static i a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && a(str)) {
            return i.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (a(charAt) == -1) {
                return i.BYTE;
            } else {
                z = true;
            }
        }
        if (z) {
            return i.ALPHANUMERIC;
        }
        if (z2) {
            return i.NUMERIC;
        }
        return i.BYTE;
    }

    private static boolean a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = bytes[i2] & Draft_75.END_OF_FRAME;
                if ((i3 < 129 || i3 > 159) && (i3 < 224 || i3 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(cn.sharesdk.framework.utils.QRCodeUtil.b bVar, cn.sharesdk.framework.utils.QRCodeUtil.f fVar, n nVar, b bVar2) throws WriterException {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            e.a(bVar, fVar, nVar, i4, bVar2);
            int a2 = a(bVar2);
            if (a2 < i2) {
                i3 = i4;
                i2 = a2;
            }
        }
        return i3;
    }

    private static n a(int i2, cn.sharesdk.framework.utils.QRCodeUtil.f fVar) throws WriterException {
        for (int i3 = 1; i3 <= 40; i3++) {
            n a2 = n.a(i3);
            if (a(i2, a2, fVar)) {
                return a2;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean a(int i2, n nVar, cn.sharesdk.framework.utils.QRCodeUtil.f fVar) {
        return nVar.b() - nVar.a(fVar).c() >= (i2 + 7) / 8;
    }

    static void a(int i2, cn.sharesdk.framework.utils.QRCodeUtil.b bVar) throws WriterException {
        int i3 = i2 * 8;
        if (bVar.a() <= i3) {
            for (int i4 = 0; i4 < 4 && bVar.a() < i3; i4++) {
                bVar.a(false);
            }
            int a2 = bVar.a() & 7;
            if (a2 > 0) {
                while (a2 < 8) {
                    bVar.a(false);
                    a2++;
                }
            }
            int b = i2 - bVar.b();
            for (int i5 = 0; i5 < b; i5++) {
                bVar.a((i5 & 1) == 0 ? 236 : 17, 8);
            }
            if (bVar.a() != i3) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + bVar.a() + " > " + i3);
    }

    static void a(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws WriterException {
        if (i5 < i4) {
            int i6 = i2 % i4;
            int i7 = i4 - i6;
            int i8 = i2 / i4;
            int i9 = i8 + 1;
            int i10 = i3 / i4;
            int i11 = i10 + 1;
            int i12 = i8 - i10;
            int i13 = i9 - i11;
            if (i12 != i13) {
                throw new WriterException("EC bytes mismatch");
            }
            if (i4 != i7 + i6) {
                throw new WriterException("RS blocks mismatch");
            }
            if (i2 != ((i10 + i12) * i7) + ((i11 + i13) * i6)) {
                throw new WriterException("Total bytes mismatch");
            }
            if (i5 < i7) {
                iArr[0] = i10;
                iArr2[0] = i12;
                return;
            }
            iArr[0] = i11;
            iArr2[0] = i13;
            return;
        }
        throw new WriterException("Block ID too large");
    }

    static cn.sharesdk.framework.utils.QRCodeUtil.b a(cn.sharesdk.framework.utils.QRCodeUtil.b bVar, int i2, int i3, int i4) throws WriterException {
        if (bVar.b() == i3) {
            ArrayList<a> arrayList = new ArrayList(i4);
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                a(i2, i3, i4, i8, iArr, iArr2);
                int i9 = iArr[0];
                byte[] bArr = new byte[i9];
                bVar.a(i5 * 8, bArr, 0, i9);
                byte[] a2 = a(bArr, iArr2[0]);
                arrayList.add(new a(bArr, a2));
                i6 = Math.max(i6, i9);
                i7 = Math.max(i7, a2.length);
                i5 += iArr[0];
            }
            if (i3 == i5) {
                cn.sharesdk.framework.utils.QRCodeUtil.b bVar2 = new cn.sharesdk.framework.utils.QRCodeUtil.b();
                for (int i10 = 0; i10 < i6; i10++) {
                    for (a aVar : arrayList) {
                        byte[] a3 = aVar.a();
                        if (i10 < a3.length) {
                            bVar2.a(a3[i10], 8);
                        }
                    }
                }
                for (int i11 = 0; i11 < i7; i11++) {
                    for (a aVar2 : arrayList) {
                        byte[] b = aVar2.b();
                        if (i11 < b.length) {
                            bVar2.a(b[i11], 8);
                        }
                    }
                }
                if (i2 == bVar2.b()) {
                    return bVar2;
                }
                throw new WriterException("Interleaving error: " + i2 + " and " + bVar2.b() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    static byte[] a(byte[] bArr, int i2) {
        int length = bArr.length;
        int[] iArr = new int[length + i2];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & Draft_75.END_OF_FRAME;
        }
        new m(g.f182e).a(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        return bArr2;
    }

    static void a(i iVar, cn.sharesdk.framework.utils.QRCodeUtil.b bVar) {
        bVar.a(iVar.a(), 4);
    }

    static void a(int i2, n nVar, i iVar, cn.sharesdk.framework.utils.QRCodeUtil.b bVar) throws WriterException {
        int a2 = iVar.a(nVar);
        int i3 = 1 << a2;
        if (i2 < i3) {
            bVar.a(i2, a2);
            return;
        }
        throw new WriterException(i2 + " is bigger than " + (i3 - 1));
    }

    static void a(String str, i iVar, cn.sharesdk.framework.utils.QRCodeUtil.b bVar, String str2) throws WriterException {
        int i2 = AnonymousClass1.a[iVar.ordinal()];
        if (i2 == 1) {
            a((CharSequence) str, bVar);
        } else if (i2 == 2) {
            b(str, bVar);
        } else if (i2 == 3) {
            a(str, bVar, str2);
        } else if (i2 == 4) {
            a(str, bVar);
        } else {
            throw new WriterException("Invalid mode: " + iVar);
        }
    }

    static void a(CharSequence charSequence, cn.sharesdk.framework.utils.QRCodeUtil.b bVar) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int charAt = charSequence.charAt(i2) - '0';
            int i3 = i2 + 2;
            if (i3 < length) {
                bVar.a((charAt * 100) + ((charSequence.charAt(i2 + 1) - '0') * 10) + (charSequence.charAt(i3) - '0'), 10);
                i2 += 3;
            } else {
                i2++;
                if (i2 < length) {
                    bVar.a((charAt * 10) + (charSequence.charAt(i2) - '0'), 7);
                    i2 = i3;
                } else {
                    bVar.a(charAt, 4);
                }
            }
        }
    }

    static void a(String str, cn.sharesdk.framework.utils.QRCodeUtil.b bVar, String str2) throws WriterException {
        try {
            for (byte b : str.getBytes(str2)) {
                bVar.a(b, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003c A[LOOP:0: B:6:0x000f->B:19:0x003c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void a(java.lang.String r6, cn.sharesdk.framework.utils.QRCodeUtil.b r7) throws cn.sharesdk.framework.utils.QRCodeUtil.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L5c
            int r0 = r6.length
            int r0 = r0 % 2
            if (r0 != 0) goto L54
            int r0 = r6.length
            int r0 = r0 + (-1)
            r1 = 0
        Lf:
            if (r1 >= r0) goto L53
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L2b
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L2b
        L29:
            int r2 = r2 - r3
            goto L3a
        L2b:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L39
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L39
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L29
        L39:
            r2 = -1
        L3a:
            if (r2 == r4) goto L4b
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.a(r3, r2)
            int r1 = r1 + 2
            goto Lf
        L4b:
            cn.sharesdk.framework.utils.QRCodeUtil.WriterException r6 = new cn.sharesdk.framework.utils.QRCodeUtil.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L53:
            return
        L54:
            cn.sharesdk.framework.utils.QRCodeUtil.WriterException r6 = new cn.sharesdk.framework.utils.QRCodeUtil.WriterException
            java.lang.String r7 = "Kanji byte size not even"
            r6.<init>(r7)
            throw r6
        L5c:
            r6 = move-exception
            cn.sharesdk.framework.utils.QRCodeUtil.WriterException r7 = new cn.sharesdk.framework.utils.QRCodeUtil.WriterException
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.utils.QRCodeUtil.a.c.a(java.lang.String, cn.sharesdk.framework.utils.QRCodeUtil.b):void");
    }

    private static void a(cn.sharesdk.framework.utils.QRCodeUtil.d dVar, cn.sharesdk.framework.utils.QRCodeUtil.b bVar) {
        bVar.a(i.ECI.a(), 4);
        bVar.a(dVar.a(), 8);
    }
}
