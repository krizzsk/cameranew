package us.pinguo.camera2020.f;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import kotlin.jvm.internal.s;
import us.pinguo.camera2020.R;
import us.pinguo.cameramanger.info.CameraFrame;
/* compiled from: FrameBindingAdapter.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final b a = new b();

    /* compiled from: FrameBindingAdapter.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CameraFrame.values().length];
            iArr[CameraFrame.FRAME_1_1.ordinal()] = 1;
            iArr[CameraFrame.FRAME_16_9.ordinal()] = 2;
            iArr[CameraFrame.FRAME_4_3.ordinal()] = 3;
            iArr[CameraFrame.FRAME_FULL.ordinal()] = 4;
            a = iArr;
        }
    }

    private b() {
    }

    @BindingAdapter({"frameIcon"})
    public static final void a(ImageView view, us.pinguo.camera2020.view.s2.a frameItem) {
        s.h(view, "view");
        s.h(frameItem, "frameItem");
        view.setImageResource(a.c(frameItem));
        if (!frameItem.b().get()) {
            us.pinguo.common.filter.util.b.a.a(view, R.color.color_camera_theme_dark);
        } else {
            us.pinguo.common.filter.util.b.a.a(view, R.color.color_camera_theme_light);
        }
    }

    @BindingAdapter({"frameRatio", "isDark"})
    public static final void b(ImageView view, us.pinguo.camera2020.view.s2.a frameItem, boolean z) {
        s.h(view, "view");
        s.h(frameItem, "frameItem");
        view.setImageResource(a.d(frameItem, z));
        us.pinguo.common.filter.util.b.a.a(view, 0);
    }

    private final int c(us.pinguo.camera2020.view.s2.a aVar) {
        int i2 = a.a[aVar.a().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return R.drawable.ic_frame_4x3_dark;
                    }
                    return R.drawable.ic_frame_full_dark;
                }
                return R.drawable.ic_frame_4x3_dark;
            }
            return R.drawable.ic_frame_16x9_dark;
        }
        return R.drawable.ic_frame_1x1_dark;
    }

    private final int d(us.pinguo.camera2020.view.s2.a aVar, boolean z) {
        int i2 = a.a[aVar.a().ordinal()];
        if (i2 == 1) {
            if (z) {
                return R.drawable.ic_frame_1x1_dark;
            }
            return R.drawable.ic_frame_1x1_light;
        } else if (i2 == 2) {
            if (z) {
                return R.drawable.ic_frame_16x9_dark;
            }
            return R.drawable.ic_frame_16x9_light;
        } else if (i2 == 3) {
            if (z) {
                return R.drawable.ic_frame_4x3_dark;
            }
            return R.drawable.ic_frame_4x3_light;
        } else if (i2 != 4) {
            if (z) {
                return R.drawable.ic_frame_4x3_dark;
            }
            return R.drawable.ic_frame_4x3_light;
        } else if (z) {
            return R.drawable.ic_frame_full_dark;
        } else {
            return R.drawable.ic_frame_full_light;
        }
    }
}
