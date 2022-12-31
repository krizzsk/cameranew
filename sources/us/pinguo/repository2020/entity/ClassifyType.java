package us.pinguo.repository2020.entity;
/* compiled from: ClassifyDefault.kt */
/* loaded from: classes6.dex */
public enum ClassifyType {
    CLASSIFY_CAMERA_STICKER("sticker"),
    CLASSIFY_EDIT_FILTER("filter");
    
    private final String type;

    ClassifyType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
