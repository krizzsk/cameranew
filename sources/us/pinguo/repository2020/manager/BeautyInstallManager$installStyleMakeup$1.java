package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import us.pinguo.repository2020.entity.MaterialDetail;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautyInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyInstallManager", f = "BeautyInstallManager.kt", i = {1, 1, 1, 4, 4, 4, 4, 4, 4, 4, 4}, l = {27, 35, 37, 56, 68, 80, 92, 97}, m = "installStyleMakeup", n = {"materialDetail", "installAction", "msg", "materialDetail", "installAction", "msg", "materialTable", "packageUnzipPath", "materialItems", "item", "icon"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8"})
/* loaded from: classes6.dex */
public final class BeautyInstallManager$installStyleMakeup$1<T extends MaterialDetail> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BeautyInstallManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyInstallManager$installStyleMakeup$1(BeautyInstallManager beautyInstallManager, Continuation<? super BeautyInstallManager$installStyleMakeup$1> continuation) {
        super(continuation);
        this.this$0 = beautyInstallManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
