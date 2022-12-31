package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.MaterialDetail;
import us.pinguo.util.FileUtils;
/* JADX WARN: Incorrect field signature: TT; */
/* compiled from: BeautyDownloadManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyDownloadManager$downloadStyleMakeupAsync$1", f = "BeautyDownloadManager.kt", i = {}, l = {42, 43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class BeautyDownloadManager$downloadStyleMakeupAsync$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ p<Boolean, T, u> $completeAction;
    final /* synthetic */ String $displayZipDownloadPath;
    final /* synthetic */ MaterialDetail $materialDetail;
    final /* synthetic */ String $packageZipDownloadPath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/b/p<-Ljava/lang/Boolean;-TT;Lkotlin/u;>;TT;Lkotlin/coroutines/Continuation<-Lus/pinguo/repository2020/manager/BeautyDownloadManager$downloadStyleMakeupAsync$1;>;)V */
    public BeautyDownloadManager$downloadStyleMakeupAsync$1(String str, String str2, p pVar, MaterialDetail materialDetail, Continuation continuation) {
        super(2, continuation);
        this.$packageZipDownloadPath = str;
        this.$displayZipDownloadPath = str2;
        this.$completeAction = pVar;
        this.$materialDetail = materialDetail;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BeautyDownloadManager$downloadStyleMakeupAsync$1(this.$packageZipDownloadPath, this.$displayZipDownloadPath, this.$completeAction, this.$materialDetail, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BeautyDownloadManager$downloadStyleMakeupAsync$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
        } catch (Exception unused) {
            us.pinguo.common.log.a.e("删除风格妆package or display失败", new Object[0]);
            this.$completeAction.invoke(Boxing.boxBoolean(false), this.$materialDetail);
        }
        if (i2 == 0) {
            kotlin.j.b(obj);
            String str = this.$packageZipDownloadPath;
            this.label = 1;
            if (FileUtils.l(str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.j.b(obj);
            return u.a;
        } else {
            kotlin.j.b(obj);
        }
        String str2 = this.$displayZipDownloadPath;
        this.label = 2;
        if (FileUtils.l(str2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return u.a;
    }
}
