package com.facebook.ads.redexgen.X;

import androidx.annotation.VisibleForTesting;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.9l  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C07059l implements Closeable {
    public static byte[] A03;
    public static String[] A04 = {"Gii7pzXwK3MpiHC8B9NJqbzL", "8Pqq6WSNf8vKrPOx7XSY9C7", "LI4waC8pDZc7B2Ob9Mw4umyD0YVp7Iep", "HQVOS1q9k5iJuCSZxlwiHtDpSPIo2CAf", "0wBrPWYDPAFL7IDgbo0bQ8s", "e5cW7wYXRGqKaYX8", "aNUR51q123XM3tsFczjtkJvp", "F8bzMC9kGkJ5CLi2olbpsia5Bq7Sq0"};
    public final C06959b A01;
    public final Deque<C07049k> A02 = new LinkedList();
    public boolean A00 = false;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            int i6 = copyOfRange[i5] ^ i4;
            if (A04[5].length() != 16) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[0] = "u097qyCEcqL0dCUFF3RqUSqj";
            strArr[6] = "TBb0mUAcLDsBFXHpNBOq9rzF";
            copyOfRange[i5] = (byte) (i6 ^ 113);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        byte[] bArr = {5, 41, 51, 42, 34, 102, 40, 41, 50, 102, 39, 34, 34, 102, 52, 35, 37, 41, 52, 34, 102, 50, 41, 102, 40, 35, 49, 42, 63, 102, 39, 34, 34, 35, 34, 102, 32, 47, 42, 35, 42, Draft_75.CR, 5, 0, 9, 8, 76, 24, 3, 76, 8, 9, 0, 9, 24, 9, 76, 10, 5, 0, 9, 76, 75, 73, 31, 75, 106, 77, 69, 64, 73, 72, 12, 88, 67, 12, 64, 69, 95, 88, 12, 74, 69, 64, 73, 72, 12, 69, 66, 12, 72, 69, 94, 73, 79, 88, 67, 94, 85, 12, 11, 9, 95, 11, 28, 59, 51, 54, 63, 62, 122, 46, 53, 122, 54, 53, 59, 62, 122, 60, 51, 54, 63, 122, 125, Byte.MAX_VALUE, 41, 125, 118, 122, 41, 49, 51, 42, 42, 51, 52, 61, 122, 59, 54, 54, 122, 42, 40, 63, 44, 51, 53, 47, 41, 122, 60, 51, 54, 63, 41, 122, 47, 52, 46, 51, 54, 122, Byte.MAX_VALUE, 62, 61, 28, 29, 94, 16, 28, 29, 7, 26, 20, 6, 28, 6, 0, 83, 29, 18, 30, 22, 23, 83, 21, 26, 31, 22, 83, 26, 29, 83, 31, 28, 20, 20, 26, 29, 20, 83, 23, 26, 1, 22, 16, 7, 28, 1, 10, 73, 83, 86, 23, 95, 83, 30, 26, 29, 83, 26, 0, 83, 86, 23, 29, 42, 44, 32, 61, 43, 9, 38, 35, 42, 28, 42, 62, 58, 42, 33, 44, 42, 111, 46, 35, 61, 42, 46, 43, 54, 111, 44, 35, 32, 60, 42, 43, 107, 80, 85, 80, 81, 73, 80, 30, 88, 87, 82, 91, 30, 87, 80, 30, 82, 81, 89, 89, 87, 80, 89, 30, 90, 87, 76, 91, 93, 74, 81, 76, 71, 4, 30, 25, 27, 77, 25};
        String[] strArr = A04;
        if (strArr[3].charAt(18) != strArr[2].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[3] = "rXUNYUFSY3Wwjf0Rt9wI3pKgcM0mrVi5";
        strArr2[2] = "NbfmFkvRWQfztm8Xt0wszzyUhHEjBSFU";
        A03 = bArr;
    }

    static {
        A03();
    }

    public C07059l(C06959b c06959b, InterfaceC07039j interfaceC07039j) throws IOException {
        this.A01 = c06959b;
        A05(c06959b, interfaceC07039j);
        if (this.A02.isEmpty()) {
            A00();
        }
    }

    private C07049k A00() throws IOException {
        int i2 = -1;
        if (!this.A02.isEmpty()) {
            i2 = this.A02.getLast().A00();
        }
        int i3 = i2 + 1;
        File newFile = new File(this.A01.A05(), A01(i3));
        this.A02.add(new C07049k(i3, new C07019h(newFile)));
        return this.A02.getLast();
    }

    @VisibleForTesting
    public static String A01(int i2) {
        return Integer.toString(i2);
    }

    private void A04(int i2, File file) throws IOException {
        C07019h c07019h = new C07019h(file);
        c07019h.A05();
        this.A02.addFirst(new C07049k(i2, c07019h));
    }

    private void A05(C06959b c06959b, InterfaceC07039j interfaceC07039j) throws IOException {
        File[] listFiles = c06959b.A05().listFiles();
        if (listFiles != null) {
            HashMap hashMap = new HashMap();
            HashSet<File> hashSet = new HashSet();
            int i2 = -1;
            for (File file : listFiles) {
                try {
                    int parseInt = Integer.parseInt(file.getName());
                    hashMap.put(Integer.valueOf(parseInt), file);
                    if (parseInt > i2) {
                        i2 = parseInt;
                    }
                } catch (NumberFormatException unused) {
                    hashSet.add(file);
                    interfaceC07039j.ADk(String.format(Locale.US, A02(260, 39, 79), file.getCanonicalPath()));
                }
            }
            if (!hashMap.isEmpty()) {
                int i3 = i2;
                while (hashMap.containsKey(Integer.valueOf(i3 - 1))) {
                    i3--;
                }
                Iterator it = new HashSet(hashMap.keySet()).iterator();
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    if (intValue < i3) {
                        interfaceC07039j.ADk(String.format(Locale.US, A02(166, 61, 2), Integer.valueOf(intValue), Integer.valueOf(i3)));
                        hashSet.add(hashMap.remove(Integer.valueOf(intValue)));
                    }
                }
                while (i2 >= i3) {
                    Integer valueOf = Integer.valueOf(i2);
                    if (A04[7].length() == 23) {
                        throw new RuntimeException();
                    }
                    A04[5] = "fmCLvQkSN3nY4ZJN";
                    File file2 = (File) hashMap.get(valueOf);
                    try {
                        A04(i2, file2);
                        hashMap.remove(Integer.valueOf(i2));
                        i2--;
                    } catch (IOException e2) {
                        interfaceC07039j.ADl(String.format(Locale.US, A02(104, 62, 43), file2.getCanonicalPath(), Integer.valueOf(i2)), e2);
                        hashSet.addAll(hashMap.values());
                    }
                }
            }
            for (File file3 : hashSet) {
                if (!file3.delete()) {
                    interfaceC07039j.ADk(String.format(Locale.US, A02(40, 26, 29), file3.getCanonicalPath()));
                }
            }
            return;
        }
        throw new IOException(String.format(Locale.US, A02(66, 38, 93), c06959b.A05().getCanonicalPath()));
    }

    public final synchronized int A06() throws IOException {
        if (!this.A00) {
            if (this.A02.isEmpty()) {
                return -1;
            }
            return this.A02.getFirst().A00();
        }
        throw new IOException(A02(227, 33, 62));
    }

    public final synchronized int A07() throws IOException {
        if (!this.A00) {
            if (this.A02.isEmpty()) {
                return 0;
            }
            return this.A02.getFirst().A01();
        }
        throw new IOException(A02(227, 33, 62));
    }

    public final synchronized int A08() throws IOException {
        if (!this.A00) {
        } else {
            throw new IOException(A02(227, 33, 62));
        }
        return this.A02.size();
    }

    public final synchronized int A09() throws IOException {
        int i2;
        if (!this.A00) {
            i2 = 0;
            for (C07049k c07049k : this.A02) {
                i2 += c07049k.A01();
            }
        } else {
            throw new IOException(A02(227, 33, 62));
        }
        return i2;
    }

    public final synchronized C9Z A0A(int i2, int i3, byte[] bArr, int i4, int[] iArr, int i5) throws IOException {
        if (!this.A00) {
            for (C07049k c07049k : this.A02) {
                if (c07049k.A00() == i2) {
                    return new C9Z(i2, c07049k.A02(i3, bArr, i4, iArr, i5));
                }
            }
            return new C9Z(-1, new C9Y(C9X.A04, -1, -1, 0));
        }
        throw new IOException(A02(227, 33, 62));
    }

    public final synchronized void A0B() throws IOException {
        if (!this.A00) {
            for (C07049k file : this.A02) {
                file.A04();
            }
            this.A02.clear();
            A00();
        } else {
            throw new IOException(A02(227, 33, 62));
        }
        String[] strArr = A04;
        if (strArr[0].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[0] = "Q8tRgYQjLjZu9wWv5pfP6FNK";
        strArr2[6] = "ZBO8PuR7N2UupXyTknUyfTWg";
    }

    public final synchronized void A0C(byte[] bArr) throws IOException {
        if (!this.A00) {
            if ((this.A02.isEmpty() || !this.A02.getLast().A05(bArr)) && !A00().A05(bArr)) {
                throw new IOException(A02(0, 40, 55));
            }
        } else {
            throw new IOException(A02(227, 33, 62));
        }
    }

    public final synchronized boolean A0D() throws IOException {
        if (!this.A00) {
            if (this.A02.size() > 1) {
                this.A02.removeFirst();
                this.A02.getFirst().A04();
                return true;
            }
            return false;
        }
        throw new IOException(A02(227, 33, 62));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.A00) {
            return;
        }
        this.A00 = true;
        for (C07049k file : this.A02) {
            file.A03();
        }
    }
}
