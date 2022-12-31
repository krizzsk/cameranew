package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.g2;
/* compiled from: MainDispatcherFactory.kt */
/* loaded from: classes3.dex */
public interface MainDispatcherFactory {
    g2 createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
