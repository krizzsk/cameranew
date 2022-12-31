package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.PaintMaterial;
/* compiled from: MaterialDownloadManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.MaterialDownloadManager$downloadMaterialAsync$1$onComplete$1", f = "MaterialDownloadManager.kt", i = {}, l = {42, 43, 52}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class MaterialDownloadManager$downloadMaterialAsync$1$onComplete$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ p<Boolean, PaintMaterial, u> $completeAction;
    final /* synthetic */ PaintMaterial $material;
    final /* synthetic */ String $materialUnzipPath;
    final /* synthetic */ String $materialZipFilePath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MaterialDownloadManager$downloadMaterialAsync$1$onComplete$1(String str, String str2, p<? super Boolean, ? super PaintMaterial, u> pVar, PaintMaterial paintMaterial, Continuation<? super MaterialDownloadManager$downloadMaterialAsync$1$onComplete$1> continuation) {
        super(2, continuation);
        this.$materialUnzipPath = str;
        this.$materialZipFilePath = str2;
        this.$completeAction = pVar;
        this.$material = paintMaterial;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new MaterialDownloadManager$downloadMaterialAsync$1$onComplete$1(this.$materialUnzipPath, this.$materialZipFilePath, this.$completeAction, this.$material, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((MaterialDownloadManager$downloadMaterialAsync$1$onComplete$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055 A[Catch: Exception -> 0x009f, TryCatch #0 {Exception -> 0x009f, blocks: (B:7:0x0012, B:11:0x001f, B:21:0x0040, B:32:0x0082, B:34:0x0086, B:24:0x0055, B:26:0x005b, B:29:0x0066, B:31:0x006a, B:12:0x0023, B:18:0x0035, B:15:0x002a), top: B:41:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0086 A[Catch: Exception -> 0x009f, TRY_LEAVE, TryCatch #0 {Exception -> 0x009f, blocks: (B:7:0x0012, B:11:0x001f, B:21:0x0040, B:32:0x0082, B:34:0x0086, B:24:0x0055, B:26:0x005b, B:29:0x0066, B:31:0x006a, B:12:0x0023, B:18:0x0035, B:15:0x002a), top: B:41:0x000a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L27
            if (r1 == r5) goto L23
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            kotlin.j.b(r14)     // Catch: java.lang.Exception -> L9f
            goto L91
        L17:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L1f:
            kotlin.j.b(r14)     // Catch: java.lang.Exception -> L9f
            goto L40
        L23:
            kotlin.j.b(r14)     // Catch: java.lang.Exception -> L9f
            goto L35
        L27:
            kotlin.j.b(r14)
            java.lang.String r14 = r13.$materialUnzipPath     // Catch: java.lang.Exception -> L9f
            r13.label = r5     // Catch: java.lang.Exception -> L9f
            java.lang.Object r14 = us.pinguo.util.FileUtils.l(r14, r13)     // Catch: java.lang.Exception -> L9f
            if (r14 != r0) goto L35
            return r0
        L35:
            java.lang.String r14 = r13.$materialUnzipPath     // Catch: java.lang.Exception -> L9f
            r13.label = r3     // Catch: java.lang.Exception -> L9f
            java.lang.Object r14 = us.pinguo.util.FileUtils.f(r14, r13)     // Catch: java.lang.Exception -> L9f
            if (r14 != r0) goto L40
            return r0
        L40:
            java.lang.String r14 = r13.$materialZipFilePath     // Catch: java.lang.Exception -> L9f
            java.lang.String r1 = r13.$materialUnzipPath     // Catch: java.lang.Exception -> L9f
            us.pinguo.foundation.utils.m0.c(r14, r1)     // Catch: java.lang.Exception -> L9f
            java.io.File r14 = new java.io.File     // Catch: java.lang.Exception -> L9f
            java.lang.String r1 = r13.$materialUnzipPath     // Catch: java.lang.Exception -> L9f
            r14.<init>(r1)     // Catch: java.lang.Exception -> L9f
            java.io.File[] r14 = r14.listFiles()     // Catch: java.lang.Exception -> L9f
            if (r14 != 0) goto L55
            goto L82
        L55:
            java.lang.String r1 = r13.$materialUnzipPath     // Catch: java.lang.Exception -> L9f
            int r3 = r14.length     // Catch: java.lang.Exception -> L9f
            r6 = 0
        L59:
            if (r6 >= r3) goto L82
            r7 = r14[r6]     // Catch: java.lang.Exception -> L9f
            int r6 = r6 + 1
            java.io.File[] r7 = r7.listFiles()     // Catch: java.lang.Exception -> L9f
            if (r7 != 0) goto L66
            goto L59
        L66:
            int r8 = r7.length     // Catch: java.lang.Exception -> L9f
            r9 = 0
        L68:
            if (r9 >= r8) goto L59
            r10 = r7[r9]     // Catch: java.lang.Exception -> L9f
            int r9 = r9 + 1
            java.io.File r11 = new java.io.File     // Catch: java.lang.Exception -> L9f
            java.lang.String r12 = r10.getName()     // Catch: java.lang.Exception -> L9f
            java.lang.String r12 = kotlin.jvm.internal.s.q(r1, r12)     // Catch: java.lang.Exception -> L9f
            r11.<init>(r12)     // Catch: java.lang.Exception -> L9f
            r10.renameTo(r11)     // Catch: java.lang.Exception -> L9f
            r10.delete()     // Catch: java.lang.Exception -> L9f
            goto L68
        L82:
            boolean r14 = us.pinguo.foundation.d.f10985d     // Catch: java.lang.Exception -> L9f
            if (r14 != 0) goto L91
            java.lang.String r14 = r13.$materialZipFilePath     // Catch: java.lang.Exception -> L9f
            r13.label = r2     // Catch: java.lang.Exception -> L9f
            java.lang.Object r14 = us.pinguo.util.FileUtils.l(r14, r13)     // Catch: java.lang.Exception -> L9f
            if (r14 != r0) goto L91
            return r0
        L91:
            kotlin.jvm.b.p<java.lang.Boolean, us.pinguo.repository2020.entity.PaintMaterial, kotlin.u> r14 = r13.$completeAction
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            us.pinguo.repository2020.entity.PaintMaterial r1 = r13.$material
            r14.invoke(r0, r1)
            kotlin.u r14 = kotlin.u.a
            return r14
        L9f:
            java.lang.Object[] r14 = new java.lang.Object[r4]
            java.lang.String r0 = "素材安装包解压失败"
            us.pinguo.common.log.a.e(r0, r14)
            kotlin.jvm.b.p<java.lang.Boolean, us.pinguo.repository2020.entity.PaintMaterial, kotlin.u> r14 = r13.$completeAction
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            us.pinguo.repository2020.entity.PaintMaterial r1 = r13.$material
            r14.invoke(r0, r1)
            kotlin.u r14 = kotlin.u.a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.MaterialDownloadManager$downloadMaterialAsync$1$onComplete$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
