package us.pinguo.foundation;
/* loaded from: classes4.dex */
public enum PackageMode {
    DEV("dev"),
    QA("qa"),
    PUBLISH("publish");
    
    private String mode;

    PackageMode(String str) {
        this.mode = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "PackageMode{mode='" + this.mode + "'}";
    }
}
