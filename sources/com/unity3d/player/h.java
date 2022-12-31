package com.unity3d.player;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes3.dex */
public final class h implements e {
    private static boolean a(PackageItemInfo packageItemInfo) {
        try {
            return packageItemInfo.metaData.getBoolean("unityplayer.SkipPermissionsDialog");
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.unity3d.player.e
    public final void a(Activity activity, String str) {
        if (activity == null || str == null) {
            return;
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("96489") == null) {
            i iVar = new i();
            Bundle bundle = new Bundle();
            bundle.putString("PermissionNames", str);
            iVar.setArguments(bundle);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            VdsAgent.onFragmentTransactionAdd(beginTransaction, 0, iVar, "96489", beginTransaction.add(0, iVar, "96489"));
            beginTransaction.commit();
        }
    }

    @Override // com.unity3d.player.e
    public final boolean a(Activity activity) {
        try {
            PackageManager packageManager = activity.getPackageManager();
            ActivityInfo activityInfo = packageManager.getActivityInfo(activity.getComponentName(), 128);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(activity.getPackageName(), 128);
            if (a(activityInfo)) {
                return true;
            }
            return a(applicationInfo);
        } catch (Exception unused) {
            return false;
        }
    }
}
