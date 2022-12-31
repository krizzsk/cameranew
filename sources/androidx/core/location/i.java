package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.lang.ref.WeakReference;
import java.util.function.Predicate;
/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements Predicate {
    public static final /* synthetic */ i a = new i();

    private /* synthetic */ i() {
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return LocationManagerCompat.LocationListenerTransport.m((WeakReference) obj);
    }
}
