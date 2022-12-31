package us.pinguo.picker.image;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhotoPickData.kt */
/* loaded from: classes5.dex */
public final class PhotoPickData$findInMediaSet$2 extends Lambda implements l<f, u> {
    final /* synthetic */ PhotoPickData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoPickData$findInMediaSet$2(PhotoPickData photoPickData) {
        super(1);
        this.this$0 = photoPickData;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(f fVar) {
        invoke2(fVar);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(f fVar) {
        boolean z;
        z = this.this$0.c;
        if (z || fVar == null || fVar.a() == null) {
            return;
        }
        if (!s.c(this.this$0.m(), fVar.a())) {
            this.this$0.a = fVar.a();
            d n = this.this$0.n();
            if (n != null) {
                n.h();
            }
        }
        d n2 = this.this$0.n();
        if (n2 == null) {
            return;
        }
        n2.O(fVar.a().intValue(), fVar);
    }
}
