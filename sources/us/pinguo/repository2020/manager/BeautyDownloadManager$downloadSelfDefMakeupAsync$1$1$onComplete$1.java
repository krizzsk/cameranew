package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
/* compiled from: BeautyDownloadManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyDownloadManager$downloadSelfDefMakeupAsync$1$1$onComplete$1", f = "BeautyDownloadManager.kt", i = {}, l = {120, 121, 130}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class BeautyDownloadManager$downloadSelfDefMakeupAsync$1$1$onComplete$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ p<Boolean, SelfDefMakeupMaterial, u> $completeAction;
    final /* synthetic */ String $materialUnzipPath;
    final /* synthetic */ String $materialZipFilePath;
    final /* synthetic */ SelfDefMakeupMaterial $selfDefMakeupMaterial;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BeautyDownloadManager$downloadSelfDefMakeupAsync$1$1$onComplete$1(String str, String str2, p<? super Boolean, ? super SelfDefMakeupMaterial, u> pVar, SelfDefMakeupMaterial selfDefMakeupMaterial, Continuation<? super BeautyDownloadManager$downloadSelfDefMakeupAsync$1$1$onComplete$1> continuation) {
        super(2, continuation);
        this.$materialUnzipPath = str;
        this.$materialZipFilePath = str2;
        this.$completeAction = pVar;
        this.$selfDefMakeupMaterial = selfDefMakeupMaterial;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BeautyDownloadManager$downloadSelfDefMakeupAsync$1$1$onComplete$1(this.$materialUnzipPath, this.$materialZipFilePath, this.$completeAction, this.$selfDefMakeupMaterial, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BeautyDownloadManager$downloadSelfDefMakeupAsync$1$1$onComplete$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005d A[Catch: Exception -> 0x009c, TryCatch #0 {Exception -> 0x009c, blocks: (B:7:0x0014, B:11:0x0021, B:21:0x0042, B:23:0x005d, B:25:0x006c, B:26:0x0081, B:28:0x0085, B:29:0x008d, B:31:0x0091, B:12:0x0025, B:18:0x0037, B:15:0x002c), top: B:37:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0091 A[Catch: Exception -> 0x009c, TRY_LEAVE, TryCatch #0 {Exception -> 0x009c, blocks: (B:7:0x0014, B:11:0x0021, B:21:0x0042, B:23:0x005d, B:25:0x006c, B:26:0x0081, B:28:0x0085, B:29:0x008d, B:31:0x0091, B:12:0x0025, B:18:0x0037, B:15:0x002c), top: B:37:0x000c }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.String r0 = "childFiles"
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r14.label
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L29
            if (r2 == r6) goto L25
            if (r2 == r4) goto L21
            if (r2 != r3) goto L19
            kotlin.j.b(r15)     // Catch: java.lang.Exception -> L9c
            goto Lae
        L19:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L21:
            kotlin.j.b(r15)     // Catch: java.lang.Exception -> L9c
            goto L42
        L25:
            kotlin.j.b(r15)     // Catch: java.lang.Exception -> L9c
            goto L37
        L29:
            kotlin.j.b(r15)
            java.lang.String r15 = r14.$materialUnzipPath     // Catch: java.lang.Exception -> L9c
            r14.label = r6     // Catch: java.lang.Exception -> L9c
            java.lang.Object r15 = us.pinguo.util.FileUtils.l(r15, r14)     // Catch: java.lang.Exception -> L9c
            if (r15 != r1) goto L37
            return r1
        L37:
            java.lang.String r15 = r14.$materialUnzipPath     // Catch: java.lang.Exception -> L9c
            r14.label = r4     // Catch: java.lang.Exception -> L9c
            java.lang.Object r15 = us.pinguo.util.FileUtils.f(r15, r14)     // Catch: java.lang.Exception -> L9c
            if (r15 != r1) goto L42
            return r1
        L42:
            java.lang.String r15 = r14.$materialZipFilePath     // Catch: java.lang.Exception -> L9c
            java.lang.String r2 = r14.$materialUnzipPath     // Catch: java.lang.Exception -> L9c
            us.pinguo.foundation.utils.m0.c(r15, r2)     // Catch: java.lang.Exception -> L9c
            java.io.File r15 = new java.io.File     // Catch: java.lang.Exception -> L9c
            java.lang.String r2 = r14.$materialUnzipPath     // Catch: java.lang.Exception -> L9c
            r15.<init>(r2)     // Catch: java.lang.Exception -> L9c
            java.io.File[] r15 = r15.listFiles()     // Catch: java.lang.Exception -> L9c
            kotlin.jvm.internal.s.g(r15, r0)     // Catch: java.lang.Exception -> L9c
            java.lang.String r2 = r14.$materialUnzipPath     // Catch: java.lang.Exception -> L9c
            int r4 = r15.length     // Catch: java.lang.Exception -> L9c
            r7 = 0
        L5b:
            if (r7 >= r4) goto L8d
            r8 = r15[r7]     // Catch: java.lang.Exception -> L9c
            int r7 = r7 + 1
            java.io.File[] r8 = r8.listFiles()     // Catch: java.lang.Exception -> L9c
            kotlin.jvm.internal.s.g(r8, r0)     // Catch: java.lang.Exception -> L9c
            int r9 = r8.length     // Catch: java.lang.Exception -> L9c
            r10 = 0
        L6a:
            if (r10 >= r9) goto L81
            r11 = r8[r10]     // Catch: java.lang.Exception -> L9c
            int r10 = r10 + 1
            java.io.File r12 = new java.io.File     // Catch: java.lang.Exception -> L9c
            java.lang.String r13 = r11.getName()     // Catch: java.lang.Exception -> L9c
            java.lang.String r13 = kotlin.jvm.internal.s.q(r2, r13)     // Catch: java.lang.Exception -> L9c
            r12.<init>(r13)     // Catch: java.lang.Exception -> L9c
            r11.renameTo(r12)     // Catch: java.lang.Exception -> L9c
            goto L6a
        L81:
            int r9 = r8.length     // Catch: java.lang.Exception -> L9c
            r10 = 0
        L83:
            if (r10 >= r9) goto L5b
            r11 = r8[r10]     // Catch: java.lang.Exception -> L9c
            int r10 = r10 + 1
            r11.delete()     // Catch: java.lang.Exception -> L9c
            goto L83
        L8d:
            boolean r15 = us.pinguo.foundation.d.f10985d     // Catch: java.lang.Exception -> L9c
            if (r15 != 0) goto Lae
            java.lang.String r15 = r14.$materialZipFilePath     // Catch: java.lang.Exception -> L9c
            r14.label = r3     // Catch: java.lang.Exception -> L9c
            java.lang.Object r15 = us.pinguo.util.FileUtils.l(r15, r14)     // Catch: java.lang.Exception -> L9c
            if (r15 != r1) goto Lae
            return r1
        L9c:
            java.lang.Object[] r15 = new java.lang.Object[r5]
            java.lang.String r0 = "素材安装包解压失败"
            us.pinguo.common.log.a.e(r0, r15)
            kotlin.jvm.b.p<java.lang.Boolean, us.pinguo.repository2020.entity.SelfDefMakeupMaterial, kotlin.u> r15 = r14.$completeAction
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            us.pinguo.repository2020.entity.SelfDefMakeupMaterial r1 = r14.$selfDefMakeupMaterial
            r15.invoke(r0, r1)
        Lae:
            kotlin.jvm.b.p<java.lang.Boolean, us.pinguo.repository2020.entity.SelfDefMakeupMaterial, kotlin.u> r15 = r14.$completeAction
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            us.pinguo.repository2020.entity.SelfDefMakeupMaterial r1 = r14.$selfDefMakeupMaterial
            r15.invoke(r0, r1)
            kotlin.u r15 = kotlin.u.a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BeautyDownloadManager$downloadSelfDefMakeupAsync$1$1$onComplete$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
