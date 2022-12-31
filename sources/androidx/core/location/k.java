package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.lang.ref.WeakReference;
import java.util.function.Predicate;
/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements Predicate {
    public static final /* synthetic */ k a = new k();

    private /* synthetic */ k() {
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return LocationManagerCompat.LocationListenerTransport.n((WeakReference) obj);
    }
}
