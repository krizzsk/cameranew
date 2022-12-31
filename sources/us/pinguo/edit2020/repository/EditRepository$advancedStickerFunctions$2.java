package us.pinguo.edit2020.repository;

import java.util.ArrayList;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.p0;
/* compiled from: EditRepository.kt */
/* loaded from: classes4.dex */
final class EditRepository$advancedStickerFunctions$2 extends Lambda implements kotlin.jvm.b.a<ArrayList<p0>> {
    public static final EditRepository$advancedStickerFunctions$2 INSTANCE = new EditRepository$advancedStickerFunctions$2();

    EditRepository$advancedStickerFunctions$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final ArrayList<p0> invoke() {
        ArrayList<p0> f2;
        f2 = u.f(new p0("key_paint", R.string.edit_area_protection_eraser, R.drawable.icon_beauty_skinrefresh_xiangpica), new p0("key_rubbery", R.string.str_sticker_recover, R.drawable.ic_sticker_adjust_recover), new p0("key_opacity", R.string.str_sticker_opacity, R.drawable.ic_sticker_adjust_opacity), new p0("key_blend", R.string.str_sticker_overlay, R.drawable.ic_sticker_adjust_overlay));
        return f2;
    }
}
