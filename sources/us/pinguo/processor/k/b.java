package us.pinguo.processor.k;

import android.util.Size;
/* compiled from: ILiveRenderer.kt */
/* loaded from: classes6.dex */
public interface b {

    /* compiled from: ILiveRenderer.kt */
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ int a(b bVar, int i2, Size size, boolean z, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z = false;
                }
                return bVar.a(i2, size, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doRenderer");
        }
    }

    int a(int i2, Size size, boolean z);

    void init();
}
