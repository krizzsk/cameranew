package us.pinguo.edit2020.viewmodel.module;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule;
import us.pinguo.repository2020.database.background.BackgroundDetail;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementModule.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule$fillOrUpdatePhotoItem$1", f = "BackgroundReplacementModule.kt", i = {0, 0, 0}, l = {830}, m = "invokeSuspend", n = {"displayRect", "imageFillSize", "imageCenter"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes4.dex */
public final class BackgroundReplacementModule$fillOrUpdatePhotoItem$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ BackgroundDetail $detail;
    final /* synthetic */ String $id;
    final /* synthetic */ BackgroundReplacementModule.a $info;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ BackgroundReplacementModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementModule$fillOrUpdatePhotoItem$1(BackgroundDetail backgroundDetail, BackgroundReplacementModule backgroundReplacementModule, BackgroundReplacementModule.a aVar, String str, Continuation<? super BackgroundReplacementModule$fillOrUpdatePhotoItem$1> continuation) {
        super(2, continuation);
        this.$detail = backgroundDetail;
        this.this$0 = backgroundReplacementModule;
        this.$info = aVar;
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundReplacementModule$fillOrUpdatePhotoItem$1(this.$detail, this.this$0, this.$info, this.$id, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BackgroundReplacementModule$fillOrUpdatePhotoItem$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x026f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) {
        /*
            Method dump skipped, instructions count: 633
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule$fillOrUpdatePhotoItem$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
