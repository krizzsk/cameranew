package us.pinguo.repository2020.database.sticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager", f = "StickerManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 9}, l = {963, 967, 972, 973, 983, 985, 987, 988, 998, 1000}, m = "copyStickerMaterialFromAssets", n = {"this", "completeAction", "stickerDetail", "displayFilePath", "displayUnzipDirPath", "packageFilePath", "packageUnzipDirPath", "this", "completeAction", "stickerDetail", "displayFilePath", "displayUnzipDirPath", "packageFilePath", "packageUnzipDirPath", "this", "completeAction", "stickerDetail", "displayFilePath", "displayUnzipDirPath", "packageFilePath", "packageUnzipDirPath", "this", "completeAction", "stickerDetail", "displayFilePath", "displayUnzipDirPath", "packageFilePath", "packageUnzipDirPath", "this", "completeAction", "stickerDetail", "displayFilePath", "displayUnzipDirPath", "packageFilePath", "packageUnzipDirPath", "this", "completeAction", "stickerDetail", "displayUnzipDirPath", "packageFilePath", "packageUnzipDirPath", "completeAction", "stickerDetail", "displayUnzipDirPath", "packageFilePath", "packageUnzipDirPath", "completeAction", "stickerDetail", "displayUnzipDirPath", "packageFilePath", "packageUnzipDirPath", "completeAction", "stickerDetail", "displayUnzipDirPath", "packageFilePath", "packageUnzipDirPath", "completeAction", "stickerDetail", "displayUnzipDirPath", "packageUnzipDirPath"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes6.dex */
public final class StickerManager$copyStickerMaterialFromAssets$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManager$copyStickerMaterialFromAssets$1(StickerManager stickerManager, Continuation<? super StickerManager$copyStickerMaterialFromAssets$1> continuation) {
        super(continuation);
        this.this$0 = stickerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object z;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        z = this.this$0.z(null, this);
        return z;
    }
}
