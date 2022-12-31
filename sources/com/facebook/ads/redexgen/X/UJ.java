package com.facebook.ads.redexgen.X;

import android.os.ConditionVariable;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;
/* loaded from: assets/audience_network.dex */
public final class UJ implements InterfaceC0902Hq {
    public static boolean A06;
    public static byte[] A07;
    public static String[] A08 = {"eH4syubUz2tR66H4aXOA", "1d5DSBS1mhWRL66KnLBZBpyHNgki7Rvu", "v9uLJ4dIwyz0Tb4FaO07wTfk2F9lBV8v", "E1Se3PKWItYNl2w7Z0lUvGDZb88eKAvD", "3tvSVqejLSP4DWhBG1hRQ7meIfhtlUpf", "obkGL38LbEEikSiwJ4pDHOfB9GOmWii2", "dwvV", "8LO"};
    public static final HashSet<File> A09;
    public long A00;
    public boolean A01;
    public final UL A02;
    public final C0910Hy A03;
    public final File A04;
    public final HashMap<String, ArrayList<InterfaceC0901Hp>> A05;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 71);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A07 = new byte[]{106, 69, 68, 95, 67, 78, 89, 11, 120, 66, 70, 91, 71, 78, 104, 74, 72, 67, 78, 11, 66, 69, 88, 95, 74, 69, 72, 78, 11, 94, 88, 78, 88, 11, 95, 67, 78, 11, 77, 68, 71, 79, 78, 89, 17, 11, 82, 104, 108, 113, 109, 100, 66, 96, 98, 105, 100, 94, 100, 96, 125, 97, 104, 78, 108, 110, 101, 104, 35, 100, 99, 100, 121, 100, 108, 97, 100, 119, 104, 37, 36, 0, 39, 60, 33, 58, 61, 52, 115, 58, 61, 55, 54, 43, 115, 53, 58, 63, 54, 115, 53, 50, 58, 63, 54, 55, 28, 30, 28, 23, 26, 27, 32, 28, 16, 17, 11, 26, 17, 11, 32, 22, 17, 27, 26, 7, 81, 26, 7, 22};
    }

    static {
        A06();
        A09 = new HashSet<>();
    }

    public UJ(File file, UL ul) {
        this(file, ul, null, false);
    }

    public UJ(File file, UL ul, C0910Hy c0910Hy) {
        if (A0D(file)) {
            this.A04 = file;
            this.A02 = ul;
            this.A03 = c0910Hy;
            this.A05 = new HashMap<>();
            ConditionVariable conditionVariable = new ConditionVariable();
            new I3(this, A03(57, 24, 74), conditionVariable).start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException(A03(0, 46, 108) + file);
    }

    public UJ(File file, UL ul, byte[] bArr, boolean z) {
        this(file, ul, new C0910Hy(file, bArr, z));
    }

    private UI A00(String str, long j2) throws C0900Ho {
        UI A062;
        C0909Hx A092 = this.A03.A09(str);
        if (A092 == null) {
            return UI.A02(str, j2);
        }
        while (true) {
            A062 = A092.A06(j2);
            if (!A062.A05 || A062.A03.exists()) {
                break;
            }
            A05();
        }
        return A062;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0902Hq
    /* renamed from: A01 */
    public final synchronized UI AEn(String str, long j2) throws InterruptedException, C0900Ho {
        UI AEo;
        while (true) {
            AEo = AEo(str, j2);
            if (AEo == null) {
                wait();
            }
        }
        return AEo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0902Hq
    /* renamed from: A02 */
    public final synchronized UI AEo(String str, long j2) throws C0900Ho {
        boolean z = this.A01;
        if (A08[0].length() != 10) {
            A08[3] = "i1JHZi6uUAd1FxW2ulRZEzuIvuRnbT2M";
            I6.A04(!z);
            UI A00 = A00(str, j2);
            if (A00.A05) {
                UI A072 = this.A03.A09(str).A07(A00);
                A0C(A00, A072);
                return A072;
            }
            C0909Hx A0A = this.A03.A0A(str);
            if (!A0A.A0D()) {
                A0A.A0B(true);
                return A00;
            }
            return null;
        }
        throw new RuntimeException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        if (!this.A04.exists()) {
            this.A04.mkdirs();
            return;
        }
        this.A03.A0E();
        File[] listFiles = this.A04.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (!file.getName().equals(A03(106, 24, 56))) {
                UI span = file.length() > 0 ? UI.A00(file, this.A03) : null;
                if (span != null) {
                    A0A(span);
                } else {
                    file.delete();
                }
            }
        }
        this.A03.A0F();
        try {
            this.A03.A0G();
        } catch (C0900Ho e2) {
            Log.e(A03(46, 11, 70), A03(81, 25, 20), e2);
        }
    }

    private void A05() throws C0900Ho {
        ArrayList arrayList = new ArrayList();
        for (C0909Hx cachedContent : this.A03.A0D()) {
            Iterator<UI> it = cachedContent.A08().iterator();
            while (it.hasNext()) {
                UI next = it.next();
                if (!next.A03.exists()) {
                    arrayList.add(next);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            A08((C0906Hu) arrayList.get(i2), false);
        }
        this.A03.A0F();
        this.A03.A0G();
    }

    private void A07(C0906Hu c0906Hu) {
        ArrayList<InterfaceC0901Hp> arrayList = this.A05.get(c0906Hu.A04);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).AC8(this, c0906Hu);
            }
        }
        this.A02.AC8(this, c0906Hu);
    }

    private void A08(C0906Hu c0906Hu, boolean z) throws C0900Ho {
        C0909Hx A092 = this.A03.A09(c0906Hu.A04);
        if (A092 == null || !A092.A0E(c0906Hu)) {
            return;
        }
        this.A00 -= c0906Hu.A01;
        if (z) {
            try {
                this.A03.A0H(A092.A03);
                this.A03.A0G();
            } finally {
                A07(c0906Hu);
            }
        }
    }

    private void A0A(UI ui) {
        this.A03.A0A(ui.A04).A09(ui);
        this.A00 += ui.A01;
        A0B(ui);
    }

    private void A0B(UI ui) {
        ArrayList<InterfaceC0901Hp> arrayList = this.A05.get(ui.A04);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).AC7(this, ui);
            }
        }
        this.A02.AC7(this, ui);
    }

    private void A0C(UI ui, C0906Hu c0906Hu) {
        ArrayList<InterfaceC0901Hp> arrayList = this.A05.get(ui.A04);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).AC9(this, ui, c0906Hu);
            }
        }
        this.A02.AC9(this, ui, c0906Hu);
    }

    public static synchronized boolean A0D(File file) {
        synchronized (UJ.class) {
            if (A06) {
                return true;
            }
            boolean add = A09.add(file.getAbsoluteFile());
            if (A08[3].charAt(1) != '1') {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[4] = "IKpjWyjLYfQpiBWntIG6MWMycmL9Fi0T";
            strArr[1] = "4yvCWPfRVkN5zdYzJ7yblhOZllwt9yTn";
            return add;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0902Hq
    public final synchronized void A3N(String str, I2 i2) throws C0900Ho {
        I6.A04(!this.A01);
        this.A03.A0I(str, i2);
        this.A03.A0G();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0902Hq
    public final synchronized void A42(File file) throws C0900Ho {
        I6.A04(!this.A01);
        UI A00 = UI.A00(file, this.A03);
        I6.A04(A00 != null);
        C0909Hx A092 = this.A03.A09(A00.A04);
        I6.A01(A092);
        I6.A04(A092.A0D());
        if (file.exists()) {
            if (file.length() == 0) {
                file.delete();
                return;
            }
            long A002 = I1.A00(A092.A05());
            if (A002 != -1) {
                long j2 = A00.A02;
                long length = A00.A01;
                I6.A04(j2 + length <= A002);
            }
            A0A(A00);
            this.A03.A0G();
            notifyAll();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0902Hq
    public final synchronized long A5r() {
        I6.A04(!this.A01);
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0902Hq
    public final synchronized long A5s(String str, long j2, long j3) {
        C0909Hx A092;
        I6.A04(!this.A01);
        A092 = this.A03.A09(str);
        return A092 != null ? A092.A04(j2, j3) : -j3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0902Hq
    @NonNull
    public final synchronized NavigableSet<C0906Hu> A5t(String str) {
        TreeSet treeSet;
        I6.A04(!this.A01);
        C0909Hx A092 = this.A03.A09(str);
        if (A092 == null || A092.A0C()) {
            treeSet = new TreeSet();
        } else {
            treeSet = new TreeSet((Collection) A092.A08());
        }
        return treeSet;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0902Hq
    public final synchronized long A64(String str) {
        return I1.A00(A65(str));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0902Hq
    public final synchronized I0 A65(String str) {
        I6.A04(!this.A01);
        return this.A03.A0B(str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0902Hq
    public final synchronized void ADW(C0906Hu c0906Hu) {
        I6.A04(!this.A01);
        C0909Hx A092 = this.A03.A09(c0906Hu.A04);
        I6.A01(A092);
        I6.A04(A092.A0D());
        A092.A0B(false);
        this.A03.A0H(A092.A03);
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0902Hq
    public final synchronized void ADd(C0906Hu c0906Hu) throws C0900Ho {
        I6.A04(!this.A01);
        A08(c0906Hu, true);
        if (A08[0].length() == 10) {
            throw new RuntimeException();
        }
        A08[2] = "mDPrx6EC7JunlTiRZIITWuDkOY6RMx2Q";
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0902Hq
    public final synchronized void AEK(String str, long j2) throws C0900Ho {
        I2 i2 = new I2();
        I1.A05(i2, j2);
        A3N(str, i2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0902Hq
    public final synchronized File AEl(String str, long j2, long j3) throws C0900Ho {
        C0909Hx A092;
        I6.A04(!this.A01);
        A092 = this.A03.A09(str);
        I6.A01(A092);
        I6.A04(A092.A0D());
        if (!this.A04.exists()) {
            this.A04.mkdirs();
            A05();
        }
        this.A02.ACA(this, str, j2, j3);
        return UI.A04(this.A04, A092.A02, j2, System.currentTimeMillis());
    }
}
