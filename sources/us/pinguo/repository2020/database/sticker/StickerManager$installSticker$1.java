package us.pinguo.repository2020.database.sticker;

import com.tencent.matrix.trace.config.SharePluginInfo;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager", f = "StickerManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11}, l = {1110, 1112, 1114, 1121, 1122, 1129, 1150, 1158, 1162, 1164, 1166, 1168}, m = "installSticker", n = {SharePluginInfo.ISSUE_STACK_TYPE, "displayPath", "packagePath", "iconPath", "isUpdate", SharePluginInfo.ISSUE_STACK_TYPE, "displayPath", "packagePath", "iconPath", "isUpdate", SharePluginInfo.ISSUE_STACK_TYPE, "displayPath", "packagePath", "iconPath", "isUpdate", SharePluginInfo.ISSUE_STACK_TYPE, "packagePath", "iconPath", "displayJsonPath", "isUpdate", SharePluginInfo.ISSUE_STACK_TYPE, "packagePath", "iconPath", "displayJsonPath", "isUpdate", SharePluginInfo.ISSUE_STACK_TYPE, "packagePath", "iconPath", "isUpdate", SharePluginInfo.ISSUE_STACK_TYPE, "packagePath", "itemTableList", "item", "itemPath", "isUpdate", SharePluginInfo.ISSUE_STACK_TYPE, "packagePath", "itemTableList", "item", "itemPath", "subt", "isUpdate", SharePluginInfo.ISSUE_STACK_TYPE, "packagePath", "itemTableList", "item", "itemPath", "subt", "isUpdate", SharePluginInfo.ISSUE_STACK_TYPE, "packagePath", "itemTableList", "item", "itemPath", "subt", "packageDisplayJson", "pkgIconPath", "isUpdate", SharePluginInfo.ISSUE_STACK_TYPE, "packagePath", "itemTableList", "item", "itemPath", "subt", "packageDisplayJson", "pkgIconPath", "isUpdate", SharePluginInfo.ISSUE_STACK_TYPE, "packagePath", "itemTableList", "item", "subt", "packageDisplayJson", "pkgIconPath", "isUpdate"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$7", "Z$0"})
/* loaded from: classes6.dex */
public final class StickerManager$installSticker$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManager$installSticker$1(StickerManager stickerManager, Continuation<? super StickerManager$installSticker$1> continuation) {
        super(continuation);
        this.this$0 = stickerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object S;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        S = this.this$0.S(null, null, null, false, this);
        return S;
    }
}
