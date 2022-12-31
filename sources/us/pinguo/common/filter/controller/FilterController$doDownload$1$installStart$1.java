package us.pinguo.common.filter.controller;

import java.util.HashSet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.PackageItem;
/* compiled from: FilterController.kt */
@DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$doDownload$1$installStart$1", f = "FilterController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class FilterController$doDownload$1$installStart$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ PackageItem $packageItem;
    int label;
    final /* synthetic */ FilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterController$doDownload$1$installStart$1(FilterController filterController, PackageItem packageItem, Continuation<? super FilterController$doDownload$1$installStart$1> continuation) {
        super(2, continuation);
        this.this$0 = filterController;
        this.$packageItem = packageItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterController$doDownload$1$installStart$1(this.this$0, this.$packageItem, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterController$doDownload$1$installStart$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HashSet hashSet;
        String str;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            hashSet = this.this$0.q;
            hashSet.add(this.$packageItem.getPackageId());
            if (this.this$0.b.R()) {
                us.pinguo.foundation.statistics.h.b.A(this.$packageItem.getPackageId(), "download_begin");
            }
            if (this.$packageItem.isFromEdit()) {
                str = "edit_page";
            } else {
                str = this.$packageItem.isAfterCapture().get() ? "picture_preview" : "camera_page";
            }
            us.pinguo.foundation.statistics.h.b.B(str, this.$packageItem.getPackageId(), "download_begin");
            this.this$0.v0().e0(this.$packageItem, 1);
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
