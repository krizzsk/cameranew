package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import us.pinguo.blockbuster.BlockBuster;
/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes3.dex */
public final class AndroidDispatcherFactory implements MainDispatcherFactory {
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public /* bridge */ /* synthetic */ g2 createDispatcher(List list) {
        return createDispatcher((List<? extends MainDispatcherFactory>) list);
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public int getLoadPriority() {
        return BlockBuster.INVALID;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public HandlerContext createDispatcher(List<? extends MainDispatcherFactory> list) {
        return new HandlerContext(b.a(Looper.getMainLooper(), true), null, 2, null);
    }
}
