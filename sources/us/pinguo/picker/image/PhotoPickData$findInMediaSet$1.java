package us.pinguo.picker.image;

import android.os.SystemClock;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.h0;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.z.j;
import us.pinguo.picker.image.gallery.m;
import us.pinguo.picker.image.gallery.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhotoPickData.kt */
/* loaded from: classes5.dex */
public final class PhotoPickData$findInMediaSet$1 extends Lambda implements kotlin.jvm.b.a<f> {
    final /* synthetic */ String $filePath;
    final /* synthetic */ PhotoPickData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoPickData$findInMediaSet$1(PhotoPickData photoPickData, String str) {
        super(0);
        this.this$0 = photoPickData;
        this.$filePath = str;
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
        kotlin.z.d h2;
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
                o mediaSet = eVar4.w(i2);
                List g2 = mediaSet.g(0, mediaSet.h());
                if (g2 == null) {
                    g2 = u.h();
                }
                List list = g2;
                h2 = j.h(0, list.size());
                String str = this.$filePath;
                PhotoPickData photoPickData = this.this$0;
                Iterator<Integer> it = h2.iterator();
                while (it.hasNext()) {
                    int nextInt = ((h0) it).nextInt();
                    m mVar = (m) list.get(nextInt);
                    if (s.c(mVar.f(), str)) {
                        s.g(mediaSet, "mediaSet");
                        eVar5 = photoPickData.b;
                        return new f(mediaSet, list, mVar, nextInt, Integer.valueOf(eVar5.u(i2)));
                    }
                }
                i2++;
            } else {
                SystemClock.sleep(20L);
            }
        }
        z2 = this.this$0.c;
        if (z2) {
            return null;
        }
        eVar2 = this.this$0.b;
        o mediaSet2 = eVar2.w(0);
        List g3 = mediaSet2.g(0, mediaSet2.h());
        if (g3 == null) {
            g3 = u.h();
        }
        s.g(mediaSet2, "mediaSet");
        eVar3 = this.this$0.b;
        return new f(mediaSet2, g3, null, -1, Integer.valueOf(eVar3.u(0)));
    }
}
