package us.pinguo.repository2020.database.sticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.b.r;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.common.pgdownloader.download.IDownloadTask;
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager$downloadStickerMaterialAsync$1$onComplete$1", f = "StickerManager.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6}, l = {1045, 1045, 1052, 1053, 1054, 1060, 1074, 1075}, m = "invokeSuspend", n = {"displayZipPath", "packageZipPath", "displayZipPath", "packageZipPath", "displayZipPath", "packageZipPath", "displayZipPath", "packageZipPath", "displayZipPath", "packageZipPath", "displayZipPath", "packageZipPath", "packageZipPath"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0"})
/* loaded from: classes6.dex */
final class StickerManager$downloadStickerMaterialAsync$1$onComplete$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ r<String, String, String, Boolean, u> $completeAction;
    final /* synthetic */ IDownloadTask $displayTask;
    final /* synthetic */ String $displayUnzipDirPath;
    final /* synthetic */ String $id;
    final /* synthetic */ IDownloadTask $packageTask;
    final /* synthetic */ String $packageUnzipDirPath;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StickerManager$downloadStickerMaterialAsync$1$onComplete$1(String str, IDownloadTask iDownloadTask, IDownloadTask iDownloadTask2, r<? super String, ? super String, ? super String, ? super Boolean, u> rVar, String str2, String str3, Continuation<? super StickerManager$downloadStickerMaterialAsync$1$onComplete$1> continuation) {
        super(2, continuation);
        this.$id = str;
        this.$displayTask = iDownloadTask;
        this.$packageTask = iDownloadTask2;
        this.$completeAction = rVar;
        this.$displayUnzipDirPath = str2;
        this.$packageUnzipDirPath = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StickerManager$downloadStickerMaterialAsync$1$onComplete$1(this.$id, this.$displayTask, this.$packageTask, this.$completeAction, this.$displayUnzipDirPath, this.$packageUnzipDirPath, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StickerManager$downloadStickerMaterialAsync$1$onComplete$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0113 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0145 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0152 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager$downloadStickerMaterialAsync$1$onComplete$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
