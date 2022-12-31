package us.pinguo.picker.image;

import android.graphics.BitmapFactory;
import android.graphics.Point;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.HashMap;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PickManager.kt */
/* loaded from: classes5.dex */
public final class PickManager$syncInRange$1 extends Lambda implements kotlin.jvm.b.a<Boolean> {
    final /* synthetic */ int $ori;
    final /* synthetic */ String $path;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickManager$syncInRange$1(String str, int i2) {
        super(0);
        this.$path = str;
        this.$ori = i2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final Boolean invoke() {
        Point point;
        HashMap hashMap;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.$path, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            if (i2 > 0 && i3 > 0) {
                if (this.$ori % BaseBlurEffect.ROTATION_180 == 90) {
                    point = new Point(i3, i2);
                } else {
                    point = new Point(i2, i3);
                }
                hashMap = PickManager.f11644g;
                hashMap.put(this.$path, point);
                return PickManager.a.e(point.x, point.y, this.$path);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
