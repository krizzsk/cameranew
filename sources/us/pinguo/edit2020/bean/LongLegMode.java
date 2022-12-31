package us.pinguo.edit2020.bean;
/* compiled from: LongLegFunction.kt */
/* loaded from: classes4.dex */
public enum LongLegMode {
    Vertical("1"),
    Horizontal("2"),
    Free("3");
    
    private final String value;

    LongLegMode(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
