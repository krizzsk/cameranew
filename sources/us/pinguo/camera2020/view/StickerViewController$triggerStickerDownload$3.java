package us.pinguo.camera2020.view;

import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.R;
/* compiled from: StickerViewController.kt */
/* loaded from: classes3.dex */
final class StickerViewController$triggerStickerDownload$3 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    public static final StickerViewController$triggerStickerDownload$3 INSTANCE = new StickerViewController$triggerStickerDownload$3();

    StickerViewController$triggerStickerDownload$3() {
        super(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m73invoke$lambda0() {
        us.pinguo.foundation.utils.k0.a.a(R.string.sticker_download_failed);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        if (z) {
            return;
        }
        us.pinguo.foundation.utils.f.c(j1.a);
    }
}
