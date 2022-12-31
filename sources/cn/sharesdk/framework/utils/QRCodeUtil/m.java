package cn.sharesdk.framework.utils.QRCodeUtil;

import java.util.ArrayList;
import java.util.List;
/* compiled from: ReedSolomonEncoder.java */
/* loaded from: classes.dex */
public final class m {
    private final g a;
    private final List<h> b;

    public m(g gVar) {
        this.a = gVar;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new h(gVar, new int[]{1}));
    }

    private h a(int i2) {
        if (i2 >= this.b.size()) {
            List<h> list = this.b;
            h hVar = list.get(list.size() - 1);
            for (int size = this.b.size(); size <= i2; size++) {
                g gVar = this.a;
                hVar = hVar.b(new h(gVar, new int[]{1, gVar.a((size - 1) + gVar.b())}));
                this.b.add(hVar);
            }
        }
        return this.b.get(i2);
    }

    public void a(int[] iArr, int i2) {
        if (i2 != 0) {
            int length = iArr.length - i2;
            if (length > 0) {
                h a = a(i2);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] a2 = new h(this.a, iArr2).a(i2, 1).c(a)[1].a();
                int length2 = i2 - a2.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr[length + i3] = 0;
                }
                System.arraycopy(a2, 0, iArr, length + length2, a2.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
