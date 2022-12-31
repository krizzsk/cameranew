package us.pinguo.edit2020.repository;

import java.util.ArrayList;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.o;
import us.pinguo.foundation.e;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: EditRepository.kt */
/* loaded from: classes4.dex */
final class EditRepository$eliminationFuncs$2 extends Lambda implements kotlin.jvm.b.a<ArrayList<o>> {
    public static final EditRepository$eliminationFuncs$2 INSTANCE = new EditRepository$eliminationFuncs$2();

    EditRepository$eliminationFuncs$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final ArrayList<o> invoke() {
        ArrayList<o> f2;
        String string = e.b().getResources().getString(R.string.key_remover_reset);
        s.g(string, "getAppContext().resource…string.key_remover_reset)");
        int i2 = R.string.edit_reset;
        int i3 = R.drawable.ic_edit_elimination_reset;
        UnityEditCaller.RemoveSpot.BrushMode brushMode = UnityEditCaller.RemoveSpot.BrushMode.BRUSH;
        String string2 = e.b().getResources().getString(R.string.key_remover_remove);
        s.g(string2, "getAppContext().resource…tring.key_remover_remove)");
        String string3 = e.b().getResources().getString(R.string.key_remover_recover);
        s.g(string3, "getAppContext().resource…ring.key_remover_recover)");
        f2 = u.f(new o(string, i2, i3, brushMode), new o(string2, R.string.edit_elimination, R.drawable.ic_edit_elimination_pen, brushMode), new o(string3, R.string.edit_recover, R.drawable.ic_edit_elimination_recover, UnityEditCaller.RemoveSpot.BrushMode.ERASE));
        return f2;
    }
}
