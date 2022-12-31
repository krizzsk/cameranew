package us.pinguo.bigdata.network.basic;
/* loaded from: classes3.dex */
public class NetworkException extends Exception {
    private final int mStatusCode;

    public NetworkException(int i2, String str) {
        super(str);
        this.mStatusCode = i2;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
