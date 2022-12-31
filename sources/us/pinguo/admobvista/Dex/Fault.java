package us.pinguo.admobvista.Dex;
/* loaded from: classes3.dex */
public class Fault extends RuntimeException {
    private String message;
    private int status;

    public Fault(int i2, String str) {
        super(str + "{" + i2 + "}");
        this.status = i2;
        this.message = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }
}
