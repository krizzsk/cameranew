package us.pinguo.repository2020.database.staticsticker;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
import us.pinguo.common.pgdownloader.download.IDownloadTask;
/* compiled from: StaticStickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager$downloadWholeStickerCategory$1$onComplete$1", f = "StaticStickerManager.kt", i = {0, 1, 1, 2, 3}, l = {TypedValues.PositionType.TYPE_PERCENT_X, InputDeviceCompat.SOURCE_DPAD, 514, 524}, m = "invokeSuspend", n = {"zipPath", "zipPath", PGEditResultActivity2.PATH, "zipPath", "result"}, s = {"L$0", "L$0", "L$2", "L$0", "I$0"})
/* loaded from: classes6.dex */
final class StaticStickerManager$downloadWholeStickerCategory$1$onComplete$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $cid;
    final /* synthetic */ p<String, Integer, u> $progressCallback;
    final /* synthetic */ p<String, Boolean, u> $resultCallback;
    final /* synthetic */ StaticStickerCategory $stickerCategory;
    final /* synthetic */ IDownloadTask $task;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StaticStickerManager$downloadWholeStickerCategory$1$onComplete$1(IDownloadTask iDownloadTask, p<? super String, ? super Integer, u> pVar, String str, p<? super String, ? super Boolean, u> pVar2, StaticStickerCategory staticStickerCategory, Continuation<? super StaticStickerManager$downloadWholeStickerCategory$1$onComplete$1> continuation) {
        super(2, continuation);
        this.$task = iDownloadTask;
        this.$progressCallback = pVar;
        this.$cid = str;
        this.$resultCallback = pVar2;
        this.$stickerCategory = staticStickerCategory;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerManager$downloadWholeStickerCategory$1$onComplete$1(this.$task, this.$progressCallback, this.$cid, this.$resultCallback, this.$stickerCategory, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StaticStickerManager$downloadWholeStickerCategory$1$onComplete$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0103 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01fd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00df -> B:27:0x009a). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 521
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$downloadWholeStickerCategory$1$onComplete$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
