package us.pinguo.picker.image;

import android.os.SystemClock;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import us.pinguo.picker.image.gallery.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhotoPickData.kt */
/* loaded from: classes5.dex */
public final class PhotoPickData$changeMediaSet$1 extends Lambda implements kotlin.jvm.b.a<f> {
    final /* synthetic */ Integer $id;
    final /* synthetic */ PhotoPickData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoPickData$changeMediaSet$1(PhotoPickData photoPickData, Integer num) {
        super(0);
        this.this$0 = photoPickData;
        this.$id = num;
    }

    @Override // kotlin.jvm.b.a
    public final f invoke() {
        boolean z;
        e eVar;
        boolean z2;
        e eVar2;
        e eVar3;
        boolean z3;
        Integer num;
        e eVar4;
        e eVar5;
        z = this.this$0.c;
        if (z) {
            return null;
        }
        eVar = this.this$0.b;
        int B = eVar.B();
        int i2 = 0;
        while (i2 <= B) {
            z3 = this.this$0.c;
            if (z3) {
                return null;
            }
            num = this.this$0.f11638d;
            if (num == null || i2 < num.intValue()) {
                eVar4 = this.this$0.b;
                o w = eVar4.w(i2);
                if (w == null) {
                    continue;
                } else {
                    eVar5 = this.this$0.b;
                    int u = eVar5.u(i2);
                    Integer num2 = this.$id;
                    if (num2 == null) {
                        if (s.c("Camera", w.i())) {
                            List g2 = w.g(0, w.h());
                            if (g2 == null) {
                                g2 = u.h();
                            }
                            return new f(w, g2, null, -1, Integer.valueOf(u));
                        }
                    } else if (num2 != null && num2.intValue() == u) {
                        List g3 = w.g(0, w.h());
                        if (g3 == null) {
                            g3 = u.h();
                        }
                        return new f(w, g3, null, -1, Integer.valueOf(u));
                    }
                    i2++;
                }
            } else {
                SystemClock.sleep(20L);
            }
        }
        z2 = this.this$0.c;
        if (z2) {
            return null;
        }
        eVar2 = this.this$0.b;
        o mediaSet = eVar2.w(0);
        List g4 = mediaSet.g(0, mediaSet.h());
        if (g4 == null) {
            g4 = u.h();
        }
        s.g(mediaSet, "mediaSet");
        eVar3 = this.this$0.b;
        return new f(mediaSet, g4, null, -1, Integer.valueOf(eVar3.u(0)));
    }
}
