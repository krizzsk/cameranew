package com.tapjoy.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.adjust.sdk.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class d extends BroadcastReceiver {
    @Nullable
    public static String a(Intent intent) {
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            return intent.getStringExtra("referrer");
        }
        return null;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        String a = a(intent);
        if (a != null) {
            a(context, Constants.INSTALL_REFERRER, a);
        }
    }

    private static boolean a(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = context.openFileOutput(str, 0);
            } catch (FileNotFoundException unused) {
                return false;
            }
        } catch (IOException unused2) {
            fileOutputStream = null;
        }
        try {
            bg.a(fileOutputStream, str2);
            fileOutputStream.close();
            return true;
        } catch (IOException unused3) {
            jz.a(fileOutputStream);
            context.deleteFile(Constants.INSTALL_REFERRER);
            return false;
        }
    }
}
