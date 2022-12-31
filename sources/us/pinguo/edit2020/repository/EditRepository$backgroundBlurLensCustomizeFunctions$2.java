package us.pinguo.edit2020.repository;

import java.util.ArrayList;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.e;
/* compiled from: EditRepository.kt */
/* loaded from: classes4.dex */
final class EditRepository$backgroundBlurLensCustomizeFunctions$2 extends Lambda implements kotlin.jvm.b.a<ArrayList<e>> {
    public static final EditRepository$backgroundBlurLensCustomizeFunctions$2 INSTANCE = new EditRepository$backgroundBlurLensCustomizeFunctions$2();

    EditRepository$backgroundBlurLensCustomizeFunctions$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final ArrayList<e> invoke() {
        ArrayList<e> f2;
        f2 = u.f(new e("background_blur_intensity", R.string.background_blur_intensity, R.drawable.ic_background_blur_intensity, -15, 15, 0), new e("background_blur_shape", R.string.background_blur_shape, R.drawable.ic_background_blur_shape, 0, 0, 0), new e("background_blur_quantity", R.string.background_blur_quantity, R.drawable.ic_background_blur_quantity, 0, 100, 65), new e("background_blur_creamy", R.string.background_blur_creamy, R.drawable.ic_background_blur_creamy, 0, 100, 0), new e("background_blur_soft", R.string.background_blur_soft, R.drawable.ic_background_blur_soft, 0, 100, 0), new e("background_blur_reflex", R.string.background_blur_reflex, R.drawable.ic_background_blur_reflex, 0, 100, 0), new e("background_blur_bilinear", R.string.background_blur_bilinear, R.drawable.ic_background_blur_bilinear, 0, 100, 0), new e("background_blur_corrosion", R.string.background_blur_corrosion, R.drawable.ic_background_blur_corrosion, -100, 100, 0), new e("background_blur_swirly", R.string.background_blur_swirly, R.drawable.ic_background_blur_swirly, 0, 100, 0), new e("background_blur_radial", R.string.background_blur_radial, R.drawable.ic_background_blur_radial, 0, 100, 0), new e("background_blur_high_light", R.string.background_blur_high_light, R.drawable.ic_background_blur_high_light, 0, 100, 75), new e("background_blur_vivid", R.string.background_blur_vivid, R.drawable.ic_background_blur_vivid, 0, 100, 50));
        return f2;
    }
}
