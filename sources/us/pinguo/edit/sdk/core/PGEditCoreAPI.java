package us.pinguo.edit.sdk.core;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.androidsdk.PGShaderHolder;
import us.pinguo.edit.sdk.core.effect.PGAbsEffect;
/* loaded from: classes4.dex */
public class PGEditCoreAPI {
    private static String b;
    private Context a;

    /* loaded from: classes4.dex */
    class a implements Comparator<PGAbsEffect> {
        a(PGEditCoreAPI pGEditCoreAPI) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(PGAbsEffect pGAbsEffect, PGAbsEffect pGAbsEffect2) {
            if (pGAbsEffect.getPriority() < pGAbsEffect2.getPriority()) {
                return -1;
            }
            return pGAbsEffect.getPriority() > pGAbsEffect2.getPriority() ? 1 : 0;
        }
    }

    public PGEditCoreAPI(Context context) {
        new PriorityBlockingQueue(11, new a(this));
        this.a = context;
        new PGImageSDK(context, a(context), PGShaderHolder.getShaderFile(context));
    }

    public static String a(Context context) {
        if (b == null) {
            b = b(context);
        }
        return new us.pinguo.edit.sdk.core.a().b(b, context);
    }

    private static String b(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("EDIT_SDK_KEY");
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (NullPointerException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static void c(Context context) {
        if (context instanceof Application) {
            b = b(context);
            return;
        }
        throw new IllegalArgumentException("Require application context!");
    }
}
