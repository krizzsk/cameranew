package us.pinguo.picker.image;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import us.pinguo.picker.image.gallery.o;
/* compiled from: PhotoPickData.kt */
/* loaded from: classes5.dex */
final class PhotoPickData$loadMediaItemData$1 extends Lambda implements kotlin.jvm.b.a<f> {
    final /* synthetic */ int $id;
    final /* synthetic */ o $mediaSet;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoPickData$loadMediaItemData$1(o oVar, int i2) {
        super(0);
        this.$mediaSet = oVar;
        this.$id = i2;
    }

    @Override // kotlin.jvm.b.a
    public final f invoke() {
        o oVar = this.$mediaSet;
        List g2 = oVar.g(0, oVar.h());
        if (g2 == null) {
            g2 = u.h();
        }
        return new f(this.$mediaSet, g2, null, -1, Integer.valueOf(this.$id));
    }
}
