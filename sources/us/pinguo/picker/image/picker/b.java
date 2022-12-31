package us.pinguo.picker.image.picker;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.s;
import us.pinguo.picker.image.ui.ImagePickerActivity;
/* compiled from: ImagePickerConfig.kt */
/* loaded from: classes5.dex */
public final class b {
    private final a a;
    private final ImagePickerConfigModel b;

    public b(a imagePicker) {
        s.h(imagePicker, "imagePicker");
        this.a = imagePicker;
        this.b = new ImagePickerConfigModel(null, false, false, 0, 15, null);
    }

    public final void a(int i2) {
        Activity b = this.a.b();
        if (b == null || b.isFinishing()) {
            return;
        }
        Intent intent = new Intent(b, ImagePickerActivity.class);
        intent.putExtra(ImagePickerConfigModel.EXTRA_DATA, this.b);
        Fragment c = this.a.c();
        if (c == null) {
            b.startActivityForResult(intent, i2);
        } else {
            c.startActivityForResult(intent, i2);
        }
    }

    public final b b(boolean z) {
        this.b.g(z);
        return this;
    }

    public final b c(boolean z) {
        this.b.h(z);
        return this;
    }

    public final b d(String tipString) {
        s.h(tipString, "tipString");
        this.b.j(tipString);
        return this;
    }
}
