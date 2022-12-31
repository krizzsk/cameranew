package us.pinguo.repository2020.manager;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.BackgroundBlurMaterial;
/* compiled from: BackgroundBlurDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BackgroundBlurDataManager$downloadBlurMaterial$1$1$onComplete$1", f = "BackgroundBlurDataManager.kt", i = {}, l = {413, 414, TypedValues.CycleType.TYPE_WAVE_PERIOD}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class BackgroundBlurDataManager$downloadBlurMaterial$1$1$onComplete$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ BackgroundBlurMaterial $blurMaterial;
    final /* synthetic */ p<Boolean, BackgroundBlurMaterial, u> $completeAction;
    final /* synthetic */ String $materialUnzipPath;
    final /* synthetic */ String $materialZipFilePath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BackgroundBlurDataManager$downloadBlurMaterial$1$1$onComplete$1(String str, String str2, p<? super Boolean, ? super BackgroundBlurMaterial, u> pVar, BackgroundBlurMaterial backgroundBlurMaterial, Continuation<? super BackgroundBlurDataManager$downloadBlurMaterial$1$1$onComplete$1> continuation) {
        super(2, continuation);
        this.$materialUnzipPath = str;
        this.$materialZipFilePath = str2;
        this.$completeAction = pVar;
        this.$blurMaterial = backgroundBlurMaterial;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundBlurDataManager$downloadBlurMaterial$1$1$onComplete$1(this.$materialUnzipPath, this.$materialZipFilePath, this.$completeAction, this.$blurMaterial, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BackgroundBlurDataManager$downloadBlurMaterial$1$1$onComplete$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005d A[Catch: Exception -> 0x009e, TryCatch #0 {Exception -> 0x009e, blocks: (B:7:0x0012, B:11:0x001f, B:21:0x0040, B:23:0x005d, B:25:0x006e, B:26:0x0083, B:28:0x0087, B:29:0x008f, B:31:0x0093, B:12:0x0023, B:18:0x0035, B:15:0x002a), top: B:37:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0093 A[Catch: Exception -> 0x009e, TRY_LEAVE, TryCatch #0 {Exception -> 0x009e, blocks: (B:7:0x0012, B:11:0x001f, B:21:0x0040, B:23:0x005d, B:25:0x006e, B:26:0x0083, B:28:0x0087, B:29:0x008f, B:31:0x0093, B:12:0x0023, B:18:0x0035, B:15:0x002a), top: B:37:0x000a }] */
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
            kotlin.j.b(r14)     // Catch: java.lang.Exception -> L9e
            goto Lb0
        L17:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L1f:
            kotlin.j.b(r14)     // Catch: java.lang.Exception -> L9e
            goto L40
        L23:
            kotlin.j.b(r14)     // Catch: java.lang.Exception -> L9e
            goto L35
        L27:
            kotlin.j.b(r14)
            java.lang.String r14 = r13.$materialUnzipPath     // Catch: java.lang.Exception -> L9e
            r13.label = r5     // Catch: java.lang.Exception -> L9e
            java.lang.Object r14 = us.pinguo.util.FileUtils.l(r14, r13)     // Catch: java.lang.Exception -> L9e
            if (r14 != r0) goto L35
            return r0
        L35:
            java.lang.String r14 = r13.$materialUnzipPath     // Catch: java.lang.Exception -> L9e
            r13.label = r3     // Catch: java.lang.Exception -> L9e
            java.lang.Object r14 = us.pinguo.util.FileUtils.f(r14, r13)     // Catch: java.lang.Exception -> L9e
            if (r14 != r0) goto L40
            return r0
        L40:
            java.lang.String r14 = r13.$materialZipFilePath     // Catch: java.lang.Exception -> L9e
            java.lang.String r1 = r13.$materialUnzipPath     // Catch: java.lang.Exception -> L9e
            us.pinguo.foundation.utils.m0.c(r14, r1)     // Catch: java.lang.Exception -> L9e
            java.io.File r14 = new java.io.File     // Catch: java.lang.Exception -> L9e
            java.lang.String r1 = r13.$materialUnzipPath     // Catch: java.lang.Exception -> L9e
            r14.<init>(r1)     // Catch: java.lang.Exception -> L9e
            java.io.File[] r14 = r14.listFiles()     // Catch: java.lang.Exception -> L9e
            java.lang.String r1 = "childFiles"
            kotlin.jvm.internal.s.g(r14, r1)     // Catch: java.lang.Exception -> L9e
            java.lang.String r1 = r13.$materialUnzipPath     // Catch: java.lang.Exception -> L9e
            int r3 = r14.length     // Catch: java.lang.Exception -> L9e
            r6 = 0
        L5b:
            if (r6 >= r3) goto L8f
            r7 = r14[r6]     // Catch: java.lang.Exception -> L9e
            int r6 = r6 + 1
            java.io.File[] r7 = r7.listFiles()     // Catch: java.lang.Exception -> L9e
            java.lang.String r8 = "files"
            kotlin.jvm.internal.s.g(r7, r8)     // Catch: java.lang.Exception -> L9e
            int r8 = r7.length     // Catch: java.lang.Exception -> L9e
            r9 = 0
        L6c:
            if (r9 >= r8) goto L83
            r10 = r7[r9]     // Catch: java.lang.Exception -> L9e
            int r9 = r9 + 1
            java.io.File r11 = new java.io.File     // Catch: java.lang.Exception -> L9e
            java.lang.String r12 = r10.getName()     // Catch: java.lang.Exception -> L9e
            java.lang.String r12 = kotlin.jvm.internal.s.q(r1, r12)     // Catch: java.lang.Exception -> L9e
            r11.<init>(r12)     // Catch: java.lang.Exception -> L9e
            r10.renameTo(r11)     // Catch: java.lang.Exception -> L9e
            goto L6c
        L83:
            int r8 = r7.length     // Catch: java.lang.Exception -> L9e
            r9 = 0
        L85:
            if (r9 >= r8) goto L5b
            r10 = r7[r9]     // Catch: java.lang.Exception -> L9e
            int r9 = r9 + 1
            r10.delete()     // Catch: java.lang.Exception -> L9e
            goto L85
        L8f:
            boolean r14 = us.pinguo.foundation.d.f10985d     // Catch: java.lang.Exception -> L9e
            if (r14 != 0) goto Lb0
            java.lang.String r14 = r13.$materialZipFilePath     // Catch: java.lang.Exception -> L9e
            r13.label = r2     // Catch: java.lang.Exception -> L9e
            java.lang.Object r14 = us.pinguo.util.FileUtils.l(r14, r13)     // Catch: java.lang.Exception -> L9e
            if (r14 != r0) goto Lb0
            return r0
        L9e:
            java.lang.Object[] r14 = new java.lang.Object[r4]
            java.lang.String r0 = "素材安装包解压失败"
            us.pinguo.common.log.a.e(r0, r14)
            kotlin.jvm.b.p<java.lang.Boolean, us.pinguo.repository2020.entity.BackgroundBlurMaterial, kotlin.u> r14 = r13.$completeAction
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            us.pinguo.repository2020.entity.BackgroundBlurMaterial r1 = r13.$blurMaterial
            r14.invoke(r0, r1)
        Lb0:
            kotlin.jvm.b.p<java.lang.Boolean, us.pinguo.repository2020.entity.BackgroundBlurMaterial, kotlin.u> r14 = r13.$completeAction
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            us.pinguo.repository2020.entity.BackgroundBlurMaterial r1 = r13.$blurMaterial
            r14.invoke(r0, r1)
            kotlin.u r14 = kotlin.u.a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BackgroundBlurDataManager$downloadBlurMaterial$1$1$onComplete$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
