package us.pinguo.edit2020.repository;

import android.os.Build;
import java.util.ArrayList;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.n;
import us.pinguo.edit2020.manager.d;
import us.pinguo.edit2020.viewmodel.FunctionType;
/* compiled from: EditRepository.kt */
/* loaded from: classes4.dex */
final class EditRepository$editFunctions$2 extends Lambda implements kotlin.jvm.b.a<ArrayList<n>> {
    public static final EditRepository$editFunctions$2 INSTANCE = new EditRepository$editFunctions$2();

    EditRepository$editFunctions$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final ArrayList<n> invoke() {
        ArrayList<n> f2;
        if (Build.VERSION.SDK_INT >= 26) {
            f2 = u.f(new n("crop", R.string.compose, R.drawable.ic_crop, FunctionType.CROP), new n("elimination", R.string.edit_elimination, R.drawable.ic_elimination, FunctionType.ELIMINATION), new n("blur", R.string.blur, R.drawable.ic_blur, FunctionType.BLUR), new n("mosaic", R.string.mosaic, R.drawable.ic_mosaic, FunctionType.MOSAIC), new n("sticker", R.string.sticker, R.drawable.ic_sticker, FunctionType.STICKER), new n("graffiti", R.string.text_graffiti, R.drawable.ic_graffiti, FunctionType.GRAFFITI), new n("background_replacement", R.string.background_replacement, R.drawable.ic_magic_background, FunctionType.BACKGROUND_REPLACEMENT));
        } else {
            f2 = u.f(new n("crop", R.string.compose, R.drawable.ic_crop, FunctionType.CROP), new n("elimination", R.string.edit_elimination, R.drawable.ic_elimination, FunctionType.ELIMINATION), new n("blur", R.string.blur, R.drawable.ic_blur, FunctionType.BLUR), new n("mosaic", R.string.mosaic, R.drawable.ic_mosaic, FunctionType.MOSAIC), new n("sticker", R.string.sticker, R.drawable.ic_sticker, FunctionType.STICKER), new n("graffiti", R.string.text_graffiti, R.drawable.ic_graffiti, FunctionType.GRAFFITI));
        }
        if (d.a.a()) {
            f2.add(2, new n("background_blur", R.string.background_blur, R.drawable.ic_background_blur, FunctionType.BACKGROUND_BLUR));
        }
        return f2;
    }
}
