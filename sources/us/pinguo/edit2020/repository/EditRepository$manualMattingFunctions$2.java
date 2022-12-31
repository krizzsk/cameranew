package us.pinguo.edit2020.repository;

import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.c0;
/* compiled from: EditRepository.kt */
/* loaded from: classes4.dex */
final class EditRepository$manualMattingFunctions$2 extends Lambda implements kotlin.jvm.b.a<ArrayList<c0>> {
    public static final EditRepository$manualMattingFunctions$2 INSTANCE = new EditRepository$manualMattingFunctions$2();

    EditRepository$manualMattingFunctions$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final ArrayList<c0> invoke() {
        ArrayList<c0> f2;
        c0 c0Var = new c0("key_rubbery", R.string.text_eraser, R.drawable.ic_manual_matting_rubbery);
        c0Var.o(25);
        c0Var.n(50);
        u uVar = u.a;
        c0 c0Var2 = new c0("key_paint", R.string.text_paint, R.drawable.ic_manual_matting_paint);
        c0Var2.o(50);
        c0Var2.o(25);
        f2 = kotlin.collections.u.f(new c0("key", R.string.manual_matting_auto, R.drawable.ic_manual_matting_auto), c0Var, c0Var2, new c0("key", R.string.manual_matting_reverse, R.drawable.ic_manual_matting_reverse));
        return f2;
    }
}
