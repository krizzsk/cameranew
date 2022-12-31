package us.pinguo.permissionlib.a;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: DialogFactory.java */
/* loaded from: classes5.dex */
public class a {
    public static AlertDialog a(us.pinguo.permissionlib.b.a aVar, Context context, DialogInterface.OnClickListener onClickListener) {
        return b(aVar, aVar.d(), context, onClickListener);
    }

    private static AlertDialog b(us.pinguo.permissionlib.b.a aVar, String str, Context context, DialogInterface.OnClickListener onClickListener) {
        if (aVar == null || str == null || context == null) {
            return null;
        }
        return new AlertDialog.Builder(context).setMessage(str).setPositiveButton(aVar.b(), onClickListener).setNegativeButton(aVar.a(), onClickListener).setTitle(aVar.h()).setIcon(aVar.c()).setCancelable(false).create();
    }

    public static AlertDialog c(us.pinguo.permissionlib.b.a aVar, Context context, DialogInterface.OnClickListener onClickListener) {
        Button button;
        Button button2;
        AlertDialog b = b(aVar, aVar.d(), context, onClickListener);
        b.show();
        VdsAgent.showDialog(b);
        if (aVar.g() != 0 && (button2 = b.getButton(-1)) != null) {
            button2.setTextColor(context.getResources().getColor(aVar.g()));
        }
        if (aVar.f() != 0 && (button = b.getButton(-2)) != null) {
            button.setTextColor(context.getResources().getColor(aVar.f()));
        }
        return b;
    }
}
