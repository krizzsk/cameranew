package us.pinguo.edit2020.repository;

import java.util.ArrayList;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.c0;
/* compiled from: EditRepository.kt */
/* loaded from: classes4.dex */
final class EditRepository$backgroundBlurAdjustFunctions$2 extends Lambda implements kotlin.jvm.b.a<ArrayList<c0>> {
    public static final EditRepository$backgroundBlurAdjustFunctions$2 INSTANCE = new EditRepository$backgroundBlurAdjustFunctions$2();

    EditRepository$backgroundBlurAdjustFunctions$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final ArrayList<c0> invoke() {
        ArrayList<c0> f2;
        f2 = u.f(new c0("key", R.string.manual_matting_auto, R.drawable.ic_manual_matting_auto), new c0("key_rubbery", R.string.text_eraser, R.drawable.ic_manual_matting_rubbery), new c0("key_paint", R.string.text_paint, R.drawable.ic_manual_matting_paint), new c0("key", R.string.manual_matting_reverse, R.drawable.ic_manual_matting_reverse));
        return f2;
    }
}
