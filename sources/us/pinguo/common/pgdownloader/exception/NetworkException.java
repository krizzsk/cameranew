package us.pinguo.common.pgdownloader.exception;
/* compiled from: NetworkException.kt */
/* loaded from: classes4.dex */
public final class NetworkException extends RuntimeException {
    private final int errorCode;

    public NetworkException(int i2) {
        this.errorCode = i2;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
