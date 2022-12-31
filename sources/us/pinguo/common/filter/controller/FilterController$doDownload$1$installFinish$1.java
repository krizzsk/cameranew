package us.pinguo.common.filter.controller;

import android.content.Context;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.HashSet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.commonui.R;
import us.pinguo.repository2020.entity.PackageItem;
import us.pinguo.repository2020.q;
/* compiled from: FilterController.kt */
@DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$doDownload$1$installFinish$1", f = "FilterController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class FilterController$doDownload$1$installFinish$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ kotlin.jvm.b.l<PackageItem, u> $downloadSuccess;
    final /* synthetic */ PackageItem $packageItem;
    final /* synthetic */ int $resultCode;
    int label;
    final /* synthetic */ FilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FilterController$doDownload$1$installFinish$1(FilterController filterController, PackageItem packageItem, int i2, kotlin.jvm.b.l<? super PackageItem, u> lVar, Continuation<? super FilterController$doDownload$1$installFinish$1> continuation) {
        super(2, continuation);
        this.this$0 = filterController;
        this.$packageItem = packageItem;
        this.$resultCode = i2;
        this.$downloadSuccess = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterController$doDownload$1$installFinish$1(this.this$0, this.$packageItem, this.$resultCode, this.$downloadSuccess, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterController$doDownload$1$installFinish$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HashSet hashSet;
        Context context;
        PackageItem packageItem;
        String str;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            hashSet = this.this$0.q;
            hashSet.remove(this.$packageItem.getPackageId());
            if (this.$resultCode != q.b.g()) {
                context = this.this$0.f9831e;
                Toast makeText = Toast.makeText(context, R.string.filter_download_error_retry, 0);
                makeText.show();
                VdsAgent.showToast(makeText);
                this.this$0.v0().e0(this.$packageItem, 0);
            } else {
                this.this$0.v0().e0(this.$packageItem, 100);
                String packageId = this.$packageItem.getPackageId();
                packageItem = this.this$0.n;
                if (s.c(packageId, packageItem == null ? null : packageItem.getPackageId())) {
                    this.this$0.n = null;
                    FilterPanelView.L(this.this$0.v0(), this.$packageItem, null, 2, null);
                }
                kotlin.jvm.b.l<PackageItem, u> lVar = this.$downloadSuccess;
                if (lVar != null) {
                    lVar.invoke(this.$packageItem);
                }
                if (this.this$0.b.R()) {
                    us.pinguo.foundation.statistics.h.b.A(this.$packageItem.getPackageId(), "download_success");
                }
                if (this.$packageItem.isFromEdit()) {
                    str = "edit_page";
                } else {
                    str = this.$packageItem.isAfterCapture().get() ? "picture_preview" : "camera_page";
                }
                us.pinguo.foundation.statistics.h.b.B(str, this.$packageItem.getPackageId(), "download_success");
            }
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
