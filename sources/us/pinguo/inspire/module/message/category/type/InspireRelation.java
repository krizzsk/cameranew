package us.pinguo.inspire.module.message.category.type;
/* loaded from: classes9.dex */
public enum InspireRelation {
    NONE,
    FOLLOW,
    FANS,
    FOLLOW_AND_FANS,
    SELF;
    
    public static final int NOT_LOGIN = -1;

    public static boolean isFollowed(int i2) {
        return i2 == FOLLOW.ordinal() || i2 == FOLLOW_AND_FANS.ordinal();
    }
}
