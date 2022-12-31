package okio;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
/* compiled from: Options.java */
/* loaded from: classes3.dex */
public final class f extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] a;
    final int[] b;

    private f(ByteString[] byteStringArr, int[] iArr) {
        this.a = byteStringArr;
        this.b = iArr;
    }

    private static void a(long j2, b bVar, int i2, List<ByteString> list, int i3, int i4, List<Integer> list2) {
        int i5;
        int i6;
        int i7;
        b bVar2;
        int i8 = i3;
        if (i8 < i4) {
            for (int i9 = i8; i9 < i4; i9++) {
                if (list.get(i9).size() < i2) {
                    throw new AssertionError();
                }
            }
            ByteString byteString = list.get(i3);
            ByteString byteString2 = list.get(i4 - 1);
            int i10 = -1;
            if (i2 == byteString.size()) {
                i10 = list2.get(i8).intValue();
                i8++;
                byteString = list.get(i8);
            }
            int i11 = i8;
            if (byteString.getByte(i2) != byteString2.getByte(i2)) {
                int i12 = 1;
                for (int i13 = i11 + 1; i13 < i4; i13++) {
                    if (list.get(i13 - 1).getByte(i2) != list.get(i13).getByte(i2)) {
                        i12++;
                    }
                }
                long d2 = j2 + d(bVar) + 2 + (i12 * 2);
                bVar.e0(i12);
                bVar.e0(i10);
                for (int i14 = i11; i14 < i4; i14++) {
                    byte b = list.get(i14).getByte(i2);
                    if (i14 == i11 || b != list.get(i14 - 1).getByte(i2)) {
                        bVar.e0(b & Draft_75.END_OF_FRAME);
                    }
                }
                b bVar3 = new b();
                int i15 = i11;
                while (i15 < i4) {
                    byte b2 = list.get(i15).getByte(i2);
                    int i16 = i15 + 1;
                    int i17 = i16;
                    while (true) {
                        if (i17 >= i4) {
                            i6 = i4;
                            break;
                        } else if (b2 != list.get(i17).getByte(i2)) {
                            i6 = i17;
                            break;
                        } else {
                            i17++;
                        }
                    }
                    if (i16 == i6 && i2 + 1 == list.get(i15).size()) {
                        bVar.e0(list2.get(i15).intValue());
                        i7 = i6;
                        bVar2 = bVar3;
                    } else {
                        bVar.e0((int) ((d(bVar3) + d2) * (-1)));
                        i7 = i6;
                        bVar2 = bVar3;
                        a(d2, bVar3, i2 + 1, list, i15, i6, list2);
                    }
                    bVar3 = bVar2;
                    i15 = i7;
                }
                b bVar4 = bVar3;
                bVar.c0(bVar4, bVar4.size());
                return;
            }
            int i18 = 0;
            int min = Math.min(byteString.size(), byteString2.size());
            for (int i19 = i2; i19 < min && byteString.getByte(i19) == byteString2.getByte(i19); i19++) {
                i18++;
            }
            long d3 = 1 + j2 + d(bVar) + 2 + i18;
            bVar.e0(-i18);
            bVar.e0(i10);
            int i20 = i2;
            while (true) {
                i5 = i2 + i18;
                if (i20 >= i5) {
                    break;
                }
                bVar.e0(byteString.getByte(i20) & Draft_75.END_OF_FRAME);
                i20++;
            }
            if (i11 + 1 == i4) {
                if (i5 == list.get(i11).size()) {
                    bVar.e0(list2.get(i11).intValue());
                    return;
                }
                throw new AssertionError();
            }
            b bVar5 = new b();
            bVar.e0((int) ((d(bVar5) + d3) * (-1)));
            a(d3, bVar5, i5, list, i11, i4, list2);
            bVar.c0(bVar5, bVar5.size());
            return;
        }
        throw new AssertionError();
    }

    private static int d(b bVar) {
        return (int) (bVar.size() / 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bc, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static okio.f e(okio.ByteString... r10) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.f.e(okio.ByteString[]):okio.f");
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c */
    public ByteString get(int i2) {
        return this.a[i2];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.length;
    }
}
