package com.pinguo.camera360.k.a.a.a;

import java.util.List;
import us.pinguo.foundation.h;
import us.pinguo.foundation.utils.r;
/* compiled from: IconListPreference.java */
/* loaded from: classes3.dex */
public class a extends h {

    /* renamed from: l  reason: collision with root package name */
    private int[] f6819l;
    protected String m;

    public a(String str, String str2) {
        super(str, str2);
        this.m = str;
    }

    @Override // us.pinguo.foundation.h
    public void a(List<String> list) {
        int[] iArr;
        String[] f2 = f();
        r rVar = new r();
        int length = f2.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (list.indexOf(f2[i2].toString()) >= 0 && (iArr = this.f6819l) != null) {
                rVar.a(iArr[i2]);
            }
        }
        if (this.f6819l != null) {
            this.f6819l = rVar.f(new int[rVar.e()]);
        }
        super.a(list);
    }

    @Override // us.pinguo.foundation.h
    public Object clone() throws CloneNotSupportedException {
        a aVar = (a) super.clone();
        int[] iArr = this.f6819l;
        if (iArr != null) {
            aVar.f6819l = iArr;
        }
        return aVar;
    }
}
