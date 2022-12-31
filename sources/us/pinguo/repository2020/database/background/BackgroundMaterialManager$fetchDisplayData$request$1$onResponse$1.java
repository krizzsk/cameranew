package us.pinguo.repository2020.database.background;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundMaterialManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.background.BackgroundMaterialManager$fetchDisplayData$request$1$onResponse$1", f = "BackgroundMaterialManager.kt", i = {0, 1}, l = {TypedValues.AttributesType.TYPE_EASING, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 319}, m = "invokeSuspend", n = {"cacheFile", "cacheFile"}, s = {"L$0", "L$0"})
/* loaded from: classes6.dex */
public final class BackgroundMaterialManager$fetchDisplayData$request$1$onResponse$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ int $forceUpdateVersion;
    final /* synthetic */ String $response;
    final /* synthetic */ BackgroundResponseData $responseData;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundMaterialManager$fetchDisplayData$request$1$onResponse$1(int i2, BackgroundResponseData backgroundResponseData, String str, Continuation<? super BackgroundMaterialManager$fetchDisplayData$request$1$onResponse$1> continuation) {
        super(2, continuation);
        this.$forceUpdateVersion = i2;
        this.$responseData = backgroundResponseData;
        this.$response = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundMaterialManager$fetchDisplayData$request$1$onResponse$1(this.$forceUpdateVersion, this.$responseData, this.$response, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BackgroundMaterialManager$fetchDisplayData$request$1$onResponse$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a7 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L30
            if (r1 == r5) goto L28
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L17
            kotlin.j.b(r9)
            goto La8
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1f:
            java.lang.Object r1 = r8.L$0
            java.io.File r1 = (java.io.File) r1
            kotlin.j.b(r9)
            goto L9b
        L28:
            java.lang.Object r1 = r8.L$0
            java.io.File r1 = (java.io.File) r1
            kotlin.j.b(r9)
            goto L90
        L30:
            kotlin.j.b(r9)
            us.pinguo.foundation.j r9 = us.pinguo.foundation.j.e()
            int r1 = r8.$forceUpdateVersion
            java.lang.String r6 = "key_fource_update_background_version"
            r9.q(r6, r1)
            us.pinguo.repository2020.utils.RequestIntervalPref r9 = us.pinguo.repository2020.utils.RequestIntervalPref.a
            us.pinguo.repository2020.database.background.BackgroundResponseData r1 = r8.$responseData
            us.pinguo.repository2020.database.background.BackgroundJson r1 = r1.getData()
            int r1 = r1.getInterval()
            int r1 = r1 * 1000
            long r6 = (long) r1
            java.lang.String r1 = "/api/product/unity-background"
            r9.d(r1, r6, r2)
            us.pinguo.repository2020.database.background.BackgroundResponseData r9 = r8.$responseData
            us.pinguo.repository2020.database.background.BackgroundJson r9 = r9.getData()
            us.pinguo.repository2020.database.background.Background[] r9 = r9.getPackages()
            int r9 = r9.length
            r1 = 0
            if (r9 != 0) goto L62
            r9 = 1
            goto L63
        L62:
            r9 = 0
        L63:
            if (r9 != 0) goto Lab
            us.pinguo.repository2020.database.background.BackgroundResponseData r9 = r8.$responseData
            us.pinguo.repository2020.database.background.BackgroundJson r9 = r9.getData()
            us.pinguo.repository2020.database.background.BackgroundCategory[] r9 = r9.getTopics()
            int r9 = r9.length
            if (r9 != 0) goto L73
            r1 = 1
        L73:
            if (r1 == 0) goto L76
            goto Lab
        L76:
            java.io.File r1 = new java.io.File
            java.lang.String r9 = us.pinguo.repository2020.database.background.BackgroundMaterialManager.b()
            r1.<init>(r9)
            boolean r9 = r1.exists()
            if (r9 == 0) goto L90
            r8.L$0 = r1
            r8.label = r5
            java.lang.Object r9 = us.pinguo.util.FileUtils.j(r1, r8)
            if (r9 != r0) goto L90
            return r0
        L90:
            r8.L$0 = r1
            r8.label = r4
            java.lang.Object r9 = us.pinguo.util.FileUtils.g(r1, r8)
            if (r9 != r0) goto L9b
            return r0
        L9b:
            java.lang.String r9 = r8.$response
            r8.L$0 = r2
            r8.label = r3
            java.lang.Object r9 = us.pinguo.util.FileIOUtils.o(r1, r9, r8)
            if (r9 != r0) goto La8
            return r0
        La8:
            kotlin.u r9 = kotlin.u.a
            return r9
        Lab:
            kotlin.u r9 = kotlin.u.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.background.BackgroundMaterialManager$fetchDisplayData$request$1$onResponse$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
