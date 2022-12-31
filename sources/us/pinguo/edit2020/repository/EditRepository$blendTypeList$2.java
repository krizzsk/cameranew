package us.pinguo.edit2020.repository;

import java.util.ArrayList;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.utils.d;
import us.pinguo.u3dengine.api.PGEditBlendMode;
/* compiled from: EditRepository.kt */
/* loaded from: classes4.dex */
final class EditRepository$blendTypeList$2 extends Lambda implements kotlin.jvm.b.a<ArrayList<us.pinguo.edit2020.model.f.a>> {
    public static final EditRepository$blendTypeList$2 INSTANCE = new EditRepository$blendTypeList$2();

    EditRepository$blendTypeList$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final ArrayList<us.pinguo.edit2020.model.f.a> invoke() {
        ArrayList<us.pinguo.edit2020.model.f.a> f2;
        f2 = u.f(new us.pinguo.edit2020.model.f.a(d.k(R.string.blend_type_normal), PGEditBlendMode.Normal), new us.pinguo.edit2020.model.f.a(d.k(R.string.blend_type_screen), PGEditBlendMode.Screen), new us.pinguo.edit2020.model.f.a(d.k(R.string.blend_type_darker_color), PGEditBlendMode.DarkerColor), new us.pinguo.edit2020.model.f.a(d.k(R.string.blend_type_overlay), PGEditBlendMode.Overlay), new us.pinguo.edit2020.model.f.a(d.k(R.string.blend_type_hard_light), PGEditBlendMode.HardLight), new us.pinguo.edit2020.model.f.a(d.k(R.string.blend_type_linear_light), PGEditBlendMode.LinearLight), new us.pinguo.edit2020.model.f.a(d.k(R.string.blend_type_darken), PGEditBlendMode.Darken), new us.pinguo.edit2020.model.f.a(d.k(R.string.blend_type_vivid_light), PGEditBlendMode.VividLight), new us.pinguo.edit2020.model.f.a(d.k(R.string.blend_type_soft_light), PGEditBlendMode.SoftLight), new us.pinguo.edit2020.model.f.a(d.k(R.string.blend_type_color_dodge), PGEditBlendMode.ColorDodge), new us.pinguo.edit2020.model.f.a(d.k(R.string.blend_type_lighten), PGEditBlendMode.Lighten));
        return f2;
    }
}
