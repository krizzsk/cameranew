package us.pinguo.camera2020.module.sticker;

import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.repository2020.database.sticker.StickerManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraStickerModule.kt */
/* loaded from: classes3.dex */
public final class CameraStickerModule$downloadAndInstallSticker$2 extends Lambda implements p<String, Boolean, u> {
    final /* synthetic */ l<Boolean, u> $action;
    final /* synthetic */ String $id;
    final /* synthetic */ boolean $switchTo;
    final /* synthetic */ CameraStickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CameraStickerModule$downloadAndInstallSticker$2(l<? super Boolean, u> lVar, boolean z, String str, CameraStickerModule cameraStickerModule) {
        super(2);
        this.$action = lVar;
        this.$switchTo = z;
        this.$id = str;
        this.this$0 = cameraStickerModule;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(String str, Boolean bool) {
        invoke(str, bool.booleanValue());
        return u.a;
    }

    public final void invoke(String stickerId, boolean z) {
        String str;
        s.h(stickerId, "stickerId");
        StickerManager.a.d0(stickerId);
        if (z) {
            this.$action.invoke(Boolean.TRUE);
            if (this.$switchTo) {
                String str2 = this.$id;
                str = this.this$0.f9246e;
                if (s.c(str2, str)) {
                    CameraStickerModule.L(this.this$0, this.$id, false, 2, null);
                    return;
                }
                return;
            }
            return;
        }
        this.$action.invoke(Boolean.FALSE);
        new Exception("下载安装失败").printStackTrace();
    }
}
