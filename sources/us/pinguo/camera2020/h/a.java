package us.pinguo.camera2020.h;

import java.util.List;
import us.pinguo.foundation.h;
import us.pinguo.foundation.utils.r;
/* compiled from: IconListPreference.java */
/* loaded from: classes3.dex */
public class a extends h {

    /* renamed from: l  reason: collision with root package name */
    private int[] f9180l;

    public a(String str, String str2) {
        super(str, str2);
    }

    @Override // us.pinguo.foundation.h
    public void a(List<String> list) {
        int[] iArr;
        String[] f2 = f();
        r rVar = new r();
        int length = f2.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (list.indexOf(f2[i2].toString()) >= 0 && (iArr = this.f9180l) != null) {
                rVar.a(iArr[i2]);
            }
        }
        if (this.f9180l != null) {
            this.f9180l = rVar.f(new int[rVar.e()]);
        }
        super.a(list);
    }

    @Override // us.pinguo.foundation.h
    public Object clone() throws CloneNotSupportedException {
        a aVar = (a) super.clone();
        int[] iArr = this.f9180l;
        if (iArr != null) {
            aVar.f9180l = iArr;
        }
        return aVar;
    }

    public int[] p() {
        return this.f9180l;
    }

    public void q(int[] iArr) {
        this.f9180l = iArr;
    }
}
