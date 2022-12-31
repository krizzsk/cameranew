package us.pinguo.edit2020.repository;

import java.util.ArrayList;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.m;
/* compiled from: EditRepository.kt */
/* loaded from: classes4.dex */
final class EditRepository$correctFunctions$2 extends Lambda implements kotlin.jvm.b.a<ArrayList<m>> {
    public static final EditRepository$correctFunctions$2 INSTANCE = new EditRepository$correctFunctions$2();

    EditRepository$correctFunctions$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final ArrayList<m> invoke() {
        ArrayList<m> f2;
        f2 = u.f(new m("hPerspective", R.string.hPerspective, R.drawable.ic_crop_h_perpective), new m("vPerspective", R.string.vPerspective, R.drawable.ic_crop_v_perspective), new m("hStretch", R.string.hStretch, R.drawable.ic_crop_h_stretch), new m("vStretch", R.string.vStretch, R.drawable.ic_crop_v_stretch));
        return f2;
    }
}
