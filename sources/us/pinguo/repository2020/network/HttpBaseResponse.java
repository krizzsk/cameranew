package us.pinguo.repository2020.network;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: HttpBaseResponse.kt */
/* loaded from: classes6.dex */
public final class HttpBaseResponse<T> implements NoProguard {
    public static final a Companion = new a(null);
    public static final int STATUS_OK = 200;
    private final T data;
    private final String message;
    private final double serverTime;
    private final int status;

    /* compiled from: HttpBaseResponse.kt */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public HttpBaseResponse(T t, int i2, String message, double d2) {
        s.h(message, "message");
        this.data = t;
        this.status = i2;
        this.message = message;
        this.serverTime = d2;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final double getServerTime() {
        return this.serverTime;
    }

    public final int getStatus() {
        return this.status;
    }
}
