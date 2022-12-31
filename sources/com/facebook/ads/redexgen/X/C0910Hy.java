package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: com.facebook.ads.redexgen.X.Hy  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0910Hy {
    public static byte[] A08;
    public static String[] A09 = {"XONorMmEkuhCG9piVxKUh1vkXNNJ", "9nfZq9rsOYHCIqBCRPzuDpg7UYzPD2Yl", "Yz44fu3QSKzu2i5DyXETxtSOt38Z3WJk", "HOY3mHCHBdW1ht", "XI2xTZ9JkVa2GEn", "4OCnssyPGh2MUqheTrzmDcc0Epkw2MIq", "4Z9FwJdzaIh4z0baUKFOBcRAp1yx", "rZsSxCWfylE928lHlC5xkXC43RMRLxAb"};
    public C0914Ic A00;
    public boolean A01;
    public final SparseArray<String> A02;
    public final I8 A03;
    public final HashMap<String, C0909Hx> A04;
    public final Cipher A05;
    public final SecretKeySpec A06;
    public final boolean A07;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 116);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        String[] strArr = A09;
        if (strArr[6].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        strArr2[7] = "3hiG2MwLP1vY28w2jyIZHTbcKAlMPBPZ";
        strArr2[2] = "9NEv2gVVsGFA2BwX54IQqGQXEg3TAXQS";
        A08 = new byte[]{26, 30, 44, 32, 36, 50, 14, 34, 33, 34, 14, 47, 42, 34, 50, 20, 47, 32, 35, 35, 40, 45, 38, -48, -47, 26, 24, 26, 31, 28, 27, 22, 26, 38, 37, 43, 28, 37, 43, 22, 32, 37, 27, 28, 47, -27, 28, 47, 32};
    }

    static {
        A05();
    }

    public C0910Hy(File file, @Nullable byte[] bArr, boolean z) {
        this.A07 = z;
        if (bArr != null) {
            I6.A03(bArr.length == 16);
            try {
                this.A05 = A03();
                this.A06 = new SecretKeySpec(bArr, A02(0, 3, 101));
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            I6.A04(!z);
            this.A05 = null;
            this.A06 = null;
        }
        this.A04 = new HashMap<>();
        this.A02 = new SparseArray<>();
        this.A03 = new I8(new File(file, A02(25, 24, 67)));
    }

    public static int A00(SparseArray<String> sparseArray) {
        int keyAt;
        int id = sparseArray.size();
        if (id == 0) {
            keyAt = 0;
        } else {
            int i2 = id - 1;
            String[] strArr = A09;
            if (strArr[7].charAt(12) != strArr[2].charAt(12)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A09;
            strArr2[6] = "GpSMRVwbmVnvoZI5Ggc91zVjP9Ti";
            strArr2[0] = "f9953PfVQawIaiCUJ4cnumBLGdw9";
            keyAt = sparseArray.keyAt(i2) + 1;
        }
        if (keyAt < 0) {
            keyAt = 0;
            while (keyAt < id && keyAt == sparseArray.keyAt(keyAt)) {
                keyAt++;
            }
        }
        return keyAt;
    }

    private C0909Hx A01(String str) {
        C0909Hx c0909Hx = new C0909Hx(A00(this.A02), str);
        A06(c0909Hx);
        this.A01 = true;
        return c0909Hx;
    }

    public static Cipher A03() throws NoSuchPaddingException, NoSuchAlgorithmException {
        int i2 = C0923Il.A02;
        String A02 = A02(3, 20, 107);
        if (i2 == 18) {
            try {
                return Cipher.getInstance(A02, A02(23, 2, 26));
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance(A02);
    }

    private void A04() throws C0900Ho {
        try {
            try {
                OutputStream A04 = this.A03.A04();
                if (this.A00 == null) {
                    this.A00 = new C0914Ic(A04);
                } else {
                    this.A00.A00(A04);
                }
                DataOutputStream dataOutputStream = new DataOutputStream(this.A00);
                dataOutputStream.writeInt(2);
                dataOutputStream.writeInt(this.A07 ? 1 : 0);
                if (this.A07) {
                    byte[] bArr = new byte[16];
                    new Random().nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        this.A05.init(1, this.A06, new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(this.A00, this.A05));
                    } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                        throw new IllegalStateException(e2);
                    }
                }
                dataOutputStream.writeInt(this.A04.size());
                int i2 = 0;
                for (C0909Hx c0909Hx : this.A04.values()) {
                    c0909Hx.A0A(dataOutputStream);
                    int hashCode = c0909Hx.A03(2);
                    i2 += hashCode;
                }
                dataOutputStream.writeInt(i2);
                this.A03.A06(dataOutputStream);
                C0923Il.A0X(null);
            } catch (IOException e3) {
                throw new C0900Ho(e3);
            }
        } catch (Throwable th) {
            C0923Il.A0X(null);
            throw th;
        }
    }

    private void A06(C0909Hx c0909Hx) {
        this.A04.put(c0909Hx.A03, c0909Hx);
        this.A02.put(c0909Hx.A02, c0909Hx.A03);
    }

    private boolean A07() {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.A03.A03());
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
            int readInt = dataInputStream.readInt();
            if (readInt < 0 || readInt > 2) {
                C0923Il.A0X(dataInputStream);
                return false;
            }
            if ((dataInputStream.readInt() & 1) != 0) {
                if (this.A05 == null) {
                    C0923Il.A0X(dataInputStream);
                    return false;
                }
                byte[] initializationVector = new byte[16];
                dataInputStream.readFully(initializationVector);
                try {
                    this.A05.init(2, this.A06, new IvParameterSpec(initializationVector));
                    dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.A05));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                    throw new IllegalStateException(e2);
                }
            } else if (this.A07) {
                this.A01 = true;
            }
            int readInt2 = dataInputStream.readInt();
            int i2 = 0;
            for (int i3 = 0; i3 < readInt2; i3++) {
                C0909Hx cachedContent = C0909Hx.A00(readInt, dataInputStream);
                A06(cachedContent);
                i2 += cachedContent.A03(readInt);
            }
            int readInt3 = dataInputStream.readInt();
            boolean isEOF = dataInputStream.read() == -1;
            if (readInt3 != i2 || !isEOF) {
                C0923Il.A0X(dataInputStream);
                return false;
            }
            C0923Il.A0X(dataInputStream);
            return true;
        } catch (IOException unused) {
            if (0 != 0) {
                C0923Il.A0X(null);
            }
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                C0923Il.A0X(null);
            }
            throw th;
        }
    }

    public final int A08(String str) {
        return A0A(str).A02;
    }

    public final C0909Hx A09(String str) {
        return this.A04.get(str);
    }

    public final C0909Hx A0A(String str) {
        C0909Hx c0909Hx = this.A04.get(str);
        return c0909Hx == null ? A01(str) : c0909Hx;
    }

    public final I0 A0B(String str) {
        C0909Hx A092 = A09(str);
        return A092 != null ? A092.A05() : UK.A04;
    }

    public final String A0C(int i2) {
        return this.A02.get(i2);
    }

    public final Collection<C0909Hx> A0D() {
        return this.A04.values();
    }

    public final void A0E() {
        I6.A04(!this.A01);
        if (!A07()) {
            this.A03.A05();
            this.A04.clear();
            this.A02.clear();
        }
    }

    public final void A0F() {
        String[] strArr = new String[this.A04.size()];
        this.A04.keySet().toArray(strArr);
        for (String str : strArr) {
            A0H(str);
        }
    }

    public final void A0G() throws C0900Ho {
        if (!this.A01) {
            return;
        }
        A04();
        this.A01 = false;
    }

    public final void A0H(String str) {
        C0909Hx c0909Hx = this.A04.get(str);
        if (c0909Hx != null && c0909Hx.A0C() && !c0909Hx.A0D()) {
            this.A04.remove(str);
            this.A02.remove(c0909Hx.A02);
            this.A01 = true;
        }
    }

    public final void A0I(String str, I2 i2) {
        if (A0A(str).A0F(i2)) {
            this.A01 = true;
        }
    }
}
