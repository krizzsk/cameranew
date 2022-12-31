package us.pinguo.push;
/* loaded from: classes6.dex */
public enum PushResult {
    UNDO(0),
    SUCCESS(1),
    FAIL(2),
    TIMEOUT(3);
    
    private int value;

    PushResult(int i2) {
        this.value = 0;
        this.value = i2;
    }

    public int getValue() {
        return this.value;
    }
}
