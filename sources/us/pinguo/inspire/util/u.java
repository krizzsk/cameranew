package us.pinguo.inspire.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.lib.AppContextProvider;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.bigalbum.BigAlbumConfig;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.permissionlib.PermissionManager;
import us.pinguo.permissionlib.b.a;
import us.pinguo.user.R;
/* compiled from: PermissionUtils.kt */
/* loaded from: classes4.dex */
public final class u {
    public static final u a = new u();

    /* compiled from: PermissionUtils.kt */
    /* loaded from: classes4.dex */
    public static final class a extends BigAlbumConfig {
        a() {
        }

        @Override // us.pinguo.bigalbum.BigAlbumConfig
        public String getAppChannel() {
            String a = us.pinguo.foundation.utils.i.a();
            kotlin.jvm.internal.s.g(a, "getChannelName()");
            return a;
        }

        @Override // us.pinguo.bigalbum.BigAlbumConfig
        public String getAppName() {
            return "camera360";
        }
    }

    private u() {
    }

    public static final us.pinguo.permissionlib.b.a a(PermissionManager manager) {
        kotlin.jvm.internal.s.h(manager, "manager");
        Context a2 = us.pinguo.util.v.a();
        if (manager.k("android.permission.RECORD_AUDIO")) {
            a.b bVar = new a.b(a2.getString(R.string.permission_audio_desc));
            bVar.i(a2.getString(R.string.permission_deny));
            bVar.j(a2.getString(R.string.permission_agree));
            bVar.m(a2.getString(R.string.permission_audio_title));
            bVar.l(R.color.light_colorAccent);
            bVar.k(R.color.primary_gray_color);
            us.pinguo.permissionlib.b.a h2 = bVar.h();
            kotlin.jvm.internal.s.g(h2, "Builder(context.getStrin…                 .build()");
            return h2;
        } else if (manager.o("android.permission.RECORD_AUDIO")) {
            a.b bVar2 = new a.b(a2.getString(R.string.permission_audio_desc_more));
            bVar2.i(a2.getString(R.string.permission_i_known));
            bVar2.m(a2.getString(R.string.permission_audio_title_more));
            int i2 = R.color.light_colorAccent;
            bVar2.l(i2);
            bVar2.k(i2);
            us.pinguo.permissionlib.b.a h3 = bVar2.h();
            kotlin.jvm.internal.s.g(h3, "Builder(context.getStrin…                 .build()");
            return h3;
        } else {
            a.b bVar3 = new a.b(a2.getString(R.string.permission_audio_desc_more));
            bVar3.i(a2.getString(R.string.agreement_not_permission));
            bVar3.j(a2.getString(R.string.granted_permission));
            bVar3.m(a2.getString(R.string.permission_audio_title_more));
            bVar3.l(R.color.light_colorAccent);
            bVar3.k(R.color.primary_gray_color);
            us.pinguo.permissionlib.b.a h4 = bVar3.h();
            kotlin.jvm.internal.s.g(h4, "Builder(context.getStrin…                 .build()");
            return h4;
        }
    }

    public static final us.pinguo.permissionlib.b.a b(PermissionManager manager) {
        us.pinguo.permissionlib.b.a h2;
        kotlin.jvm.internal.s.h(manager, "manager");
        Context a2 = us.pinguo.util.v.a();
        if (us.pinguo.user.util.n.i()) {
            if (manager.k("android.permission.ACCESS_FINE_LOCATION")) {
                a.b bVar = new a.b(a2.getString(R.string.permission_gps_desc));
                bVar.i(a2.getString(R.string.permission_deny));
                bVar.j(a2.getString(R.string.permission_agree));
                bVar.m(a2.getString(R.string.permission_gps_title));
                bVar.l(R.color.light_colorAccent);
                bVar.k(R.color.primary_gray_color);
                h2 = bVar.h();
            } else if (manager.o("android.permission.ACCESS_FINE_LOCATION")) {
                a.b bVar2 = new a.b(a2.getString(R.string.permission_gps_desc_more));
                bVar2.i(a2.getString(R.string.permission_i_known));
                bVar2.j(a2.getString(R.string.goto_set));
                bVar2.m(a2.getString(R.string.permission_gps_title_more));
                bVar2.l(R.color.light_colorAccent);
                bVar2.k(R.color.primary_gray_color);
                h2 = bVar2.h();
            } else {
                a.b bVar3 = new a.b(a2.getString(R.string.requesting_permission_location));
                bVar3.i(a2.getString(R.string.agreement_not_permission));
                bVar3.j(a2.getString(R.string.goto_set));
                bVar3.m(a2.getString(R.string.permission_gps_title_more));
                bVar3.l(R.color.light_colorAccent);
                bVar3.k(R.color.primary_gray_color);
                h2 = bVar3.h();
            }
            kotlin.jvm.internal.s.g(h2, "{\n            when {\n   …}\n            }\n        }");
            return h2;
        }
        a.b bVar4 = new a.b(a2.getString(R.string.requesting_permission_location));
        bVar4.i(a2.getString(R.string.remind_later));
        bVar4.j(a2.getString(R.string.goto_set));
        bVar4.m(a2.getString(R.string.permission_tips));
        bVar4.l(R.color.light_colorAccent);
        bVar4.k(R.color.primary_gray_color);
        us.pinguo.permissionlib.b.a h3 = bVar4.h();
        kotlin.jvm.internal.s.g(h3, "{\n            GuideInfo.…       .build()\n        }");
        return h3;
    }

    public static final us.pinguo.permissionlib.b.a c(boolean z, boolean z2) {
        String str;
        Context a2 = us.pinguo.util.v.a();
        String string = a2.getString(R.string.permission_tips);
        kotlin.jvm.internal.s.g(string, "ctx.getString(R.string.permission_tips)");
        if (z) {
            string = a2.getString(R.string.permission_audio_title_more);
            kotlin.jvm.internal.s.g(string, "ctx.getString(R.string.p…mission_audio_title_more)");
            str = a2.getString(R.string.permission_mic);
        } else if (z2) {
            str = a2.getString(R.string.need_sd_permission);
        } else {
            str = "-    " + a2.getString(R.string.need_sd_permission) + "\n-    " + a2.getString(R.string.permission_mic);
        }
        kotlin.jvm.internal.s.g(str, "when {\n            stora…ermission_mic)\n\n        }");
        a.b bVar = new a.b(str);
        bVar.i(a2.getString(R.string.remind_later));
        bVar.j(a2.getString(R.string.goto_set));
        bVar.l(R.color.light_colorAccent);
        bVar.k(R.color.primary_gray_color);
        bVar.m(string);
        us.pinguo.permissionlib.b.a h2 = bVar.h();
        kotlin.jvm.internal.s.g(h2, "Builder(msg)\n           …\n                .build()");
        return h2;
    }

    public static final us.pinguo.permissionlib.b.a d(PermissionManager manager) {
        us.pinguo.permissionlib.b.a h2;
        kotlin.jvm.internal.s.h(manager, "manager");
        Context a2 = us.pinguo.util.v.a();
        if (us.pinguo.user.util.n.i()) {
            if (manager.o("android.permission.WRITE_EXTERNAL_STORAGE")) {
                a.b bVar = new a.b(a2.getString(R.string.permission_storage_desc_more));
                bVar.i(a2.getString(R.string.goto_set));
                bVar.m(a2.getString(R.string.permission_storage_title_more));
                int i2 = R.color.light_colorAccent;
                bVar.l(i2);
                bVar.k(i2);
                h2 = bVar.h();
            } else {
                a.b bVar2 = new a.b(a2.getString(R.string.permission_storage_desc));
                bVar2.i(a2.getString(R.string.permission_deny));
                bVar2.j(a2.getString(R.string.permission_agree));
                bVar2.m(a2.getString(R.string.permission_storage_title));
                bVar2.l(R.color.light_colorAccent);
                bVar2.k(R.color.primary_gray_color);
                h2 = bVar2.h();
            }
            kotlin.jvm.internal.s.g(h2, "{\n            when {\n   …)\n            }\n        }");
            return h2;
        }
        a.b bVar3 = new a.b(a2.getString(R.string.permission_storage_desc));
        bVar3.i(a2.getString(R.string.permission_deny));
        bVar3.j(a2.getString(R.string.permission_agree));
        bVar3.m(a2.getString(R.string.permission_storage_title));
        bVar3.l(R.color.light_colorAccent);
        bVar3.k(R.color.primary_gray_color);
        us.pinguo.permissionlib.b.a h3 = bVar3.h();
        kotlin.jvm.internal.s.g(h3, "{\n            GuideInfo.…       .build()\n        }");
        return h3;
    }

    public static final void f() {
        BigAlbumManager.instance().init(us.pinguo.util.v.a(), new a());
    }

    public static final void i(Context context, PermissionManager manager) {
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(manager, "manager");
        k(context, manager, f.a, null, 8, null);
    }

    private static final void j(Context context, final PermissionManager permissionManager, final us.pinguo.permissionlib.c.a aVar, final t tVar) {
        us.pinguo.permissionlib.b.a d2 = d(permissionManager);
        permissionManager.w("android.permission.WRITE_EXTERNAL_STORAGE");
        us.pinguo.permissionlib.a.a.c(d2, context, new DialogInterface.OnClickListener() { // from class: us.pinguo.inspire.util.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                u.m(PermissionManager.this, aVar, r3, tVar, dialogInterface, i2);
            }
        });
    }

    static /* synthetic */ void k(Context context, PermissionManager permissionManager, us.pinguo.permissionlib.c.a aVar, t tVar, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            tVar = null;
        }
        j(context, permissionManager, aVar, tVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(String[] permissions, String[] strArr) {
        kotlin.jvm.internal.s.g(permissions, "permissions");
        if (!(permissions.length == 0)) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(PermissionManager manager, us.pinguo.permissionlib.c.a listener, String permission, t tVar, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(manager, "$manager");
        kotlin.jvm.internal.s.h(listener, "$listener");
        kotlin.jvm.internal.s.h(permission, "$permission");
        dialogInterface.dismiss();
        if (i2 == -1) {
            manager.u(listener, permission);
            if (tVar == null) {
                return;
            }
            tVar.b();
            return;
        }
        if (manager.o("android.permission.WRITE_EXTERNAL_STORAGE")) {
            manager.u(listener, permission);
        }
        if (tVar == null) {
            return;
        }
        tVar.a();
    }

    public final void e(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        Intent intent = new Intent();
        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", AppContextProvider.INSTANCE.getContext().getPackageName(), null));
        context.startActivity(intent);
    }
}
