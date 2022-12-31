package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.d;
import com.bytedance.sdk.openadsdk.utils.ac;
/* compiled from: ExpressClickCreativeListener.java */
/* loaded from: classes.dex */
public class d extends com.bytedance.sdk.openadsdk.core.a.a {
    private com.bytedance.sdk.openadsdk.core.d.f a;

    public d(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.d.h hVar, @NonNull String str, int i2) {
        super(context, hVar, str, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.a.b
    public com.bytedance.sdk.openadsdk.core.d.d a(int i2, int i3, int i4, int i5, long j2, long j3, View view, View view2) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        long j4;
        long j5;
        this.x = 1;
        this.y = 0;
        this.z = 0;
        int[] a = ac.a(view);
        if (a == null || a.length != 2) {
            i6 = i2;
            i7 = i3;
            i8 = i4;
            i9 = i5;
            i10 = 0;
            i11 = 0;
        } else {
            i10 = a[0];
            i11 = a[1];
            i6 = ((int) ac.a(this.c, i2)) + i10;
            i7 = ((int) ac.a(this.c, i3)) + i11;
            i8 = ((int) ac.a(this.c, i4)) + i10;
            i9 = ((int) ac.a(this.c, i5)) + i11;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        com.bytedance.sdk.openadsdk.core.d.f fVar = this.a;
        if (fVar != null) {
            j4 = fVar.f1575e;
            j5 = fVar.f1576f;
            iArr[0] = ((int) ac.a(this.c, fVar.f1577g)) + i10;
            iArr[1] = ((int) ac.a(this.c, this.a.f1578h)) + i11;
            iArr2[0] = (int) ac.a(this.c, this.a.f1579i);
            iArr2[1] = (int) ac.a(this.c, this.a.f1580j);
        } else {
            j4 = j2;
            j5 = j3;
        }
        return new d.a().d(i6).c(i7).b(i8).a(i9).b(j4).a(j5).b(a).a(iArr).c(ac.c(view)).d(iArr2).e(this.x).f(this.y).g(this.z).a();
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.f fVar) {
        this.a = fVar;
    }
}
