package com.pinguo.camera360.adv.interaction;

import android.content.Context;
import android.net.Uri;
import us.pinguo.advconfigdata.database.AdvItem;
/* loaded from: classes3.dex */
public abstract class Interaction {
    public static final int CAN_GO = 0;
    private static final int CAN_NOT_GO = 2;
    public static final int WAIT_GO = 1;

    /* loaded from: classes3.dex */
    public interface InteractionListener {
        void valid(boolean z);
    }

    public static int asyncValidAndUpdate(String str, InteractionListener interactionListener) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        try {
            Uri.parse(str);
            if ("app://camera360/effect".equals(str)) {
            }
            return 0;
        } catch (Exception unused) {
            return 2;
        }
    }

    public static boolean isInspireGoTo(String str) {
        return "app://camera360/publish".equals(str) || str.contains("app://inspire/profile");
    }

    public static boolean isInteractionAppWall(AdvItem advItem) {
        int i2;
        return advItem != null && "appwall".equals(advItem.advType) && (8 == (i2 = advItem.advProvider) || 1 == i2);
    }

    public static boolean isValid(String str) {
        try {
            Uri.parse(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean syncValidAndUpdate(String str) {
        try {
            Uri.parse(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public abstract /* synthetic */ boolean onClick(Context context, String str, int i2);
}
