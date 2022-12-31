package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.MaterialDetail;
/* JADX WARN: Incorrect field signature: TT; */
/* compiled from: BeautyDownloadManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyDownloadManager$downloadStyleMakeupAsync$2$onComplete$1", f = "BeautyDownloadManager.kt", i = {}, l = {60, 61, 62, 63, 67, 68}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class BeautyDownloadManager$downloadStyleMakeupAsync$2$onComplete$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ p<Boolean, T, u> $completeAction;
    final /* synthetic */ String $displayUnzipPath;
    final /* synthetic */ String $displayZipFilePath;
    final /* synthetic */ MaterialDetail $materialDetail;
    final /* synthetic */ String $packageUnzipPath;
    final /* synthetic */ String $packageZipFilePath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/b/p<-Ljava/lang/Boolean;-TT;Lkotlin/u;>;TT;Lkotlin/coroutines/Continuation<-Lus/pinguo/repository2020/manager/BeautyDownloadManager$downloadStyleMakeupAsync$2$onComplete$1;>;)V */
    public BeautyDownloadManager$downloadStyleMakeupAsync$2$onComplete$1(String str, String str2, String str3, String str4, p pVar, MaterialDetail materialDetail, Continuation continuation) {
        super(2, continuation);
        this.$packageUnzipPath = str;
        this.$displayUnzipPath = str2;
        this.$packageZipFilePath = str3;
        this.$displayZipFilePath = str4;
        this.$completeAction = pVar;
        this.$materialDetail = materialDetail;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BeautyDownloadManager$downloadStyleMakeupAsync$2$onComplete$1(this.$packageUnzipPath, this.$displayUnzipPath, this.$packageZipFilePath, this.$displayZipFilePath, this.$completeAction, this.$materialDetail, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BeautyDownloadManager$downloadStyleMakeupAsync$2$onComplete$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f A[Catch: Exception -> 0x0087, TryCatch #0 {Exception -> 0x0087, blocks: (B:6:0x0012, B:7:0x0017, B:31:0x007b, B:8:0x001b, B:26:0x005d, B:28:0x006f, B:9:0x001f, B:23:0x0051, B:10:0x0023, B:20:0x0045, B:11:0x0027, B:17:0x0039, B:14:0x002e), top: B:37:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0086 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r3.label
            r2 = 1
            switch(r1) {
                case 0: goto L2b;
                case 1: goto L27;
                case 2: goto L23;
                case 3: goto L1f;
                case 4: goto L1b;
                case 5: goto L17;
                case 6: goto L12;
                default: goto La;
            }
        La:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L12:
            kotlin.j.b(r4)     // Catch: java.lang.Exception -> L87
            goto L9a
        L17:
            kotlin.j.b(r4)     // Catch: java.lang.Exception -> L87
            goto L7b
        L1b:
            kotlin.j.b(r4)     // Catch: java.lang.Exception -> L87
            goto L5d
        L1f:
            kotlin.j.b(r4)     // Catch: java.lang.Exception -> L87
            goto L51
        L23:
            kotlin.j.b(r4)     // Catch: java.lang.Exception -> L87
            goto L45
        L27:
            kotlin.j.b(r4)     // Catch: java.lang.Exception -> L87
            goto L39
        L2b:
            kotlin.j.b(r4)
            java.lang.String r4 = r3.$packageUnzipPath     // Catch: java.lang.Exception -> L87
            r3.label = r2     // Catch: java.lang.Exception -> L87
            java.lang.Object r4 = us.pinguo.util.FileUtils.l(r4, r3)     // Catch: java.lang.Exception -> L87
            if (r4 != r0) goto L39
            return r0
        L39:
            java.lang.String r4 = r3.$displayUnzipPath     // Catch: java.lang.Exception -> L87
            r1 = 2
            r3.label = r1     // Catch: java.lang.Exception -> L87
            java.lang.Object r4 = us.pinguo.util.FileUtils.l(r4, r3)     // Catch: java.lang.Exception -> L87
            if (r4 != r0) goto L45
            return r0
        L45:
            java.lang.String r4 = r3.$packageUnzipPath     // Catch: java.lang.Exception -> L87
            r1 = 3
            r3.label = r1     // Catch: java.lang.Exception -> L87
            java.lang.Object r4 = us.pinguo.util.FileUtils.f(r4, r3)     // Catch: java.lang.Exception -> L87
            if (r4 != r0) goto L51
            return r0
        L51:
            java.lang.String r4 = r3.$displayUnzipPath     // Catch: java.lang.Exception -> L87
            r1 = 4
            r3.label = r1     // Catch: java.lang.Exception -> L87
            java.lang.Object r4 = us.pinguo.util.FileUtils.f(r4, r3)     // Catch: java.lang.Exception -> L87
            if (r4 != r0) goto L5d
            return r0
        L5d:
            java.lang.String r4 = r3.$packageZipFilePath     // Catch: java.lang.Exception -> L87
            java.lang.String r1 = r3.$packageUnzipPath     // Catch: java.lang.Exception -> L87
            us.pinguo.foundation.utils.m0.c(r4, r1)     // Catch: java.lang.Exception -> L87
            java.lang.String r4 = r3.$displayZipFilePath     // Catch: java.lang.Exception -> L87
            java.lang.String r1 = r3.$displayUnzipPath     // Catch: java.lang.Exception -> L87
            us.pinguo.foundation.utils.m0.c(r4, r1)     // Catch: java.lang.Exception -> L87
            boolean r4 = us.pinguo.foundation.d.f10985d     // Catch: java.lang.Exception -> L87
            if (r4 != 0) goto L9a
            java.lang.String r4 = r3.$packageZipFilePath     // Catch: java.lang.Exception -> L87
            r1 = 5
            r3.label = r1     // Catch: java.lang.Exception -> L87
            java.lang.Object r4 = us.pinguo.util.FileUtils.l(r4, r3)     // Catch: java.lang.Exception -> L87
            if (r4 != r0) goto L7b
            return r0
        L7b:
            java.lang.String r4 = r3.$displayZipFilePath     // Catch: java.lang.Exception -> L87
            r1 = 6
            r3.label = r1     // Catch: java.lang.Exception -> L87
            java.lang.Object r4 = us.pinguo.util.FileUtils.l(r4, r3)     // Catch: java.lang.Exception -> L87
            if (r4 != r0) goto L9a
            return r0
        L87:
            r4 = 0
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r1 = "风格妆安装包解压失败"
            us.pinguo.common.log.a.e(r1, r0)
            kotlin.jvm.b.p<java.lang.Boolean, T, kotlin.u> r0 = r3.$completeAction
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            us.pinguo.repository2020.entity.MaterialDetail r1 = r3.$materialDetail
            r0.invoke(r4, r1)
        L9a:
            kotlin.jvm.b.p<java.lang.Boolean, T, kotlin.u> r4 = r3.$completeAction
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            us.pinguo.repository2020.entity.MaterialDetail r1 = r3.$materialDetail
            r4.invoke(r0, r1)
            kotlin.u r4 = kotlin.u.a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BeautyDownloadManager$downloadStyleMakeupAsync$2$onComplete$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
