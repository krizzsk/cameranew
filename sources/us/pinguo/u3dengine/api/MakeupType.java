package us.pinguo.u3dengine.api;
/* compiled from: UnityMethodData.kt */
/* loaded from: classes6.dex */
public enum MakeupType {
    NONE(0),
    EYEBROW(1),
    EYESHADOW(2),
    EYELASH(3),
    EYELINER(4),
    EYEBALL(5),
    LIP(6),
    FACE_BLUSHER(7),
    FACE_T_AREA(8),
    COMPLEXION(9);
    
    private final int key;

    MakeupType(int i2) {
        this.key = i2;
    }

    public final int getKey() {
        return this.key;
    }
}
