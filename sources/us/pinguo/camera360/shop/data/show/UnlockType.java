package us.pinguo.camera360.shop.data.show;
/* loaded from: classes4.dex */
public enum UnlockType {
    FREE,
    MEMBER,
    SHARE,
    PAY;

    public static UnlockType getType(int i2) {
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return FREE;
        }
        if (i2 != 4) {
            return null;
        }
        return PAY;
    }
}
