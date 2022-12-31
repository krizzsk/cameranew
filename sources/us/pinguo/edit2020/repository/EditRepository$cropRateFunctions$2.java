package us.pinguo.edit2020.repository;

import java.util.ArrayList;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.m;
/* compiled from: EditRepository.kt */
/* loaded from: classes4.dex */
final class EditRepository$cropRateFunctions$2 extends Lambda implements kotlin.jvm.b.a<ArrayList<m>> {
    public static final EditRepository$cropRateFunctions$2 INSTANCE = new EditRepository$cropRateFunctions$2();

    EditRepository$cropRateFunctions$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final ArrayList<m> invoke() {
        ArrayList<m> f2;
        f2 = u.f(new m("cropFree", R.string.cropFree, R.drawable.ic_crop_rate_free), new m("cropOriginal", R.string.cropOriginal, R.drawable.ic_crop_rate_origin), new m("crop1b1", R.string.crop1b1, R.drawable.ic_crop_rate_1b1), new m("crop3b4", R.string.crop3b4, R.drawable.ic_crop_rate_3b4), new m("crop4b3", R.string.crop4b3, R.drawable.ic_crop_rate_4b3), new m("crop2b3", R.string.crop2b3, R.drawable.ic_crop_rate_2b3), new m("crop3b2", R.string.crop3b2, R.drawable.ic_crop_rate_3b2), new m("crop9b16", R.string.crop9b16, R.drawable.ic_crop_rate_9b16), new m("crop16b9", R.string.crop16b9, R.drawable.ic_crop_rate_16b9), new m("cropDevice", R.string.cropDevice, R.drawable.ic_crop_rate_device));
        return f2;
    }
}
