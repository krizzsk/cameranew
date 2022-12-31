package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.base.zap;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class j<L> {
    private final c a;
    private volatile L b;
    private volatile a<L> c;

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static final class a<L> {
        private final L a;
        private final String b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(L l2, String str) {
            this.a = l2;
            this.b = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.a == aVar.a && this.b.equals(aVar.b);
            }
            return false;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * 31) + this.b.hashCode();
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public interface b<L> {
        void notifyListener(L l2);

        void onNotifyListenerFailed();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    private final class c extends zap {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            com.google.android.gms.common.internal.q.a(message.what == 1);
            j.this.d((b) message.obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(@NonNull Looper looper, @NonNull L l2, @NonNull String str) {
        this.a = new c(looper);
        com.google.android.gms.common.internal.q.k(l2, "Listener must not be null");
        this.b = l2;
        com.google.android.gms.common.internal.q.f(str);
        this.c = new a<>(l2, str);
    }

    public final void a() {
        this.b = null;
        this.c = null;
    }

    @Nullable
    public final a<L> b() {
        return this.c;
    }

    public final void c(b<? super L> bVar) {
        com.google.android.gms.common.internal.q.k(bVar, "Notifier must not be null");
        this.a.sendMessage(this.a.obtainMessage(1, bVar));
    }

    final void d(b<? super L> bVar) {
        Object obj = (L) this.b;
        if (obj == null) {
            bVar.onNotifyListenerFailed();
            return;
        }
        try {
            bVar.notifyListener(obj);
        } catch (RuntimeException e2) {
            bVar.onNotifyListenerFailed();
            throw e2;
        }
    }
}
