package us.pinguo.camera2020.view;

import java.util.List;
import kotlin.jvm.internal.Lambda;
import us.pinguo.repository2020.database.sticker.Sticker;
/* compiled from: StickerViewController.kt */
/* loaded from: classes3.dex */
final class StickerViewController$showStickerManagement$4$1 extends Lambda implements kotlin.jvm.b.l<Sticker, Boolean> {
    final /* synthetic */ List<String> $toDeleteList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerViewController$showStickerManagement$4$1(List<String> list) {
        super(1);
        this.$toDeleteList = list;
    }

    @Override // kotlin.jvm.b.l
    public final Boolean invoke(Sticker it) {
        kotlin.jvm.internal.s.h(it, "it");
        return Boolean.valueOf(this.$toDeleteList.contains(it.getPid()));
    }
}
