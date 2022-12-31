package kotlinx.android.extensions;

import kotlin.jvm.internal.o;
/* compiled from: CacheImplementation.kt */
/* loaded from: classes3.dex */
public enum CacheImplementation {
    SPARSE_ARRAY,
    HASH_MAP,
    NO_CACHE;
    
    public static final a Companion = new a(null);
    private static final CacheImplementation DEFAULT;

    /* compiled from: CacheImplementation.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    static {
        DEFAULT = r0;
    }
}
