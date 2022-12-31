package us.pinguo.foundation.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.lifecycle.LifecycleOwner;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.lang.reflect.Method;
import us.pinguo.foundation.R;
/* compiled from: MDDialogUtils.java */
/* loaded from: classes4.dex */
public class w {

    /* compiled from: MDDialogUtils.java */
    /* loaded from: classes4.dex */
    class a implements PopupMenu.OnMenuItemClickListener {
        final /* synthetic */ us.pinguo.foundation.h a;
        final /* synthetic */ View b;
        final /* synthetic */ Context c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ PopupMenu.OnMenuItemClickListener f11116d;

        a(us.pinguo.foundation.h hVar, View view, Context context, PopupMenu.OnMenuItemClickListener onMenuItemClickListener) {
            this.a = hVar;
            this.b = view;
            this.c = context;
            this.f11116d = onMenuItemClickListener;
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        @Instrumented
        public boolean onMenuItemClick(MenuItem menuItem) {
            VdsAgent.onMenuItemClick(this, menuItem);
            this.a.o(menuItem.getItemId());
            View view = this.b;
            if (view instanceof TextView) {
                ((TextView) view).setText(this.a.e(this.c));
            }
            PopupMenu.OnMenuItemClickListener onMenuItemClickListener = this.f11116d;
            boolean onMenuItemClick = onMenuItemClickListener != null ? onMenuItemClickListener.onMenuItemClick(menuItem) : true;
            VdsAgent.handleClickResult(new Boolean(onMenuItemClick));
            return onMenuItemClick;
        }
    }

    public static us.pinguo.foundation.ui.mddialog.a a(Context context, int i2, int i3, int i4, int i5, int i6, boolean z, DialogInterface.OnClickListener onClickListener) {
        us.pinguo.foundation.ui.mddialog.a aVar = new us.pinguo.foundation.ui.mddialog.a(context, i2);
        if (-999 != i3) {
            aVar.p(i3);
        }
        if (-999 != i4) {
            aVar.k(i4);
        }
        if (-999 != i5) {
            aVar.h(-1, context.getResources().getString(i5), onClickListener);
        }
        if (-999 != i6) {
            aVar.h(-2, context.getResources().getString(i6), onClickListener);
        }
        aVar.i(z);
        return aVar;
    }

    public static us.pinguo.foundation.ui.mddialog.a b(Context context, int i2, int i3, int i4, boolean z) {
        return a(context, i2, i3, i4, -999, -999, z, null);
    }

    public static us.pinguo.foundation.ui.mddialog.a c(Context context, int i2, boolean z) {
        return b(context, i2, -999, -999, z);
    }

    private static void d(Menu menu, boolean z) {
        if (menu != null) {
            try {
                Method declaredMethod = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(menu, Boolean.valueOf(z));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static AlertDialog e(Context context, View view, int i2, int i3, DialogInterface.OnClickListener onClickListener) {
        LifecycleDialogBuilder lifecycleDialogBuilder = new LifecycleDialogBuilder(context, R.style.AlertDialogCustom);
        lifecycleDialogBuilder.setView(view);
        if (i2 != -999) {
            lifecycleDialogBuilder.setPositiveButton(i2, onClickListener);
        }
        if (i3 != -999) {
            lifecycleDialogBuilder.setNegativeButton(i3, onClickListener);
        }
        LifecycleAwareDialog create = lifecycleDialogBuilder.create();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return create;
        }
        if (context instanceof LifecycleOwner) {
            create.a(((LifecycleOwner) context).getLifecycle());
        }
        create.show();
        return create;
    }

    private static AlertDialog f(Context context, int i2, int i3, int i4, int i5, int i6, DialogInterface.OnClickListener onClickListener) {
        LifecycleDialogBuilder lifecycleDialogBuilder = new LifecycleDialogBuilder(context, i2);
        if (i3 != -999) {
            lifecycleDialogBuilder.setTitle(i3);
        }
        if (i4 != -999) {
            lifecycleDialogBuilder.setMessage(i4);
        }
        if (i5 != -999) {
            lifecycleDialogBuilder.setPositiveButton(i5, onClickListener);
        }
        if (i6 != -999) {
            lifecycleDialogBuilder.setNegativeButton(i6, onClickListener);
        }
        LifecycleAwareDialog create = lifecycleDialogBuilder.create();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return create;
        }
        if (context instanceof LifecycleOwner) {
            create.a(((LifecycleOwner) context).getLifecycle());
        }
        create.show();
        return create;
    }

    public static AlertDialog g(Context context, int i2, int i3, int i4, int i5, DialogInterface.OnClickListener onClickListener) {
        return f(context, R.style.AlertDialogCustom, i2, i3, i4, i5, onClickListener);
    }

    public static AlertDialog h(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, DialogInterface.OnClickListener onClickListener) {
        LifecycleDialogBuilder lifecycleDialogBuilder = new LifecycleDialogBuilder(context, R.style.AlertDialogCustom);
        if (!TextUtils.isEmpty(charSequence)) {
            lifecycleDialogBuilder.setTitle(charSequence);
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            lifecycleDialogBuilder.setMessage(charSequence2);
        }
        if (!TextUtils.isEmpty(charSequence3)) {
            lifecycleDialogBuilder.setPositiveButton(charSequence3, onClickListener);
        }
        if (!TextUtils.isEmpty(charSequence4)) {
            lifecycleDialogBuilder.setNegativeButton(charSequence4, onClickListener);
        }
        LifecycleAwareDialog create = lifecycleDialogBuilder.create();
        create.setCanceledOnTouchOutside(false);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return create;
        }
        if (context instanceof LifecycleOwner) {
            create.a(((LifecycleOwner) context).getLifecycle());
        }
        create.show();
        return create;
    }

    public static AlertDialog i(Context context, int i2, int i3, int i4, DialogInterface.OnClickListener onClickListener) {
        return k(context, i2, i3, i4, true, onClickListener);
    }

    public static AlertDialog j(Context context, int i2, int i3, int i4, DialogInterface.OnClickListener onClickListener, int i5) {
        LifecycleDialogBuilder lifecycleDialogBuilder = new LifecycleDialogBuilder(context, i5);
        lifecycleDialogBuilder.setMessage(i2);
        if (i3 != -999) {
            lifecycleDialogBuilder.setPositiveButton(i3, onClickListener);
        }
        if (i4 != -999) {
            lifecycleDialogBuilder.setNegativeButton(i4, onClickListener);
        }
        LifecycleAwareDialog create = lifecycleDialogBuilder.create();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return create;
        }
        if (context instanceof LifecycleOwner) {
            create.a(((LifecycleOwner) context).getLifecycle());
        }
        create.show();
        return create;
    }

    public static AlertDialog k(Context context, int i2, int i3, int i4, boolean z, DialogInterface.OnClickListener onClickListener) {
        LifecycleDialogBuilder lifecycleDialogBuilder = new LifecycleDialogBuilder(context, R.style.AlertDialogCustom);
        lifecycleDialogBuilder.setMessage(i2);
        if (i3 != -999) {
            lifecycleDialogBuilder.setPositiveButton(i3, onClickListener);
        }
        if (i4 != -999) {
            lifecycleDialogBuilder.setNegativeButton(i4, onClickListener);
        }
        LifecycleAwareDialog create = lifecycleDialogBuilder.create();
        create.setCancelable(z);
        create.setCanceledOnTouchOutside(z);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return create;
        }
        if (context instanceof LifecycleOwner) {
            create.a(((LifecycleOwner) context).getLifecycle());
        }
        create.show();
        return create;
    }

    public static AlertDialog l(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, DialogInterface.OnClickListener onClickListener) {
        LifecycleDialogBuilder lifecycleDialogBuilder = new LifecycleDialogBuilder(context, R.style.AlertDialogCustom);
        lifecycleDialogBuilder.setMessage(charSequence);
        if (!TextUtils.isEmpty(charSequence2)) {
            lifecycleDialogBuilder.setPositiveButton(charSequence2, onClickListener);
        }
        if (!TextUtils.isEmpty(charSequence3)) {
            lifecycleDialogBuilder.setNegativeButton(charSequence3, onClickListener);
        }
        LifecycleAwareDialog create = lifecycleDialogBuilder.create();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return create;
        }
        if (context instanceof LifecycleOwner) {
            create.a(((LifecycleOwner) context).getLifecycle());
        }
        create.show();
        return create;
    }

    public static AlertDialog m(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, DialogInterface.OnClickListener onClickListener) {
        LifecycleDialogBuilder lifecycleDialogBuilder = new LifecycleDialogBuilder(context, R.style.AlertDialogCustom);
        lifecycleDialogBuilder.setMessage(charSequence);
        if (!TextUtils.isEmpty(charSequence2)) {
            lifecycleDialogBuilder.setPositiveButton(charSequence2, onClickListener);
        }
        if (!TextUtils.isEmpty(charSequence3)) {
            lifecycleDialogBuilder.setNeutralButton(charSequence3, onClickListener);
        }
        if (!TextUtils.isEmpty(charSequence4)) {
            lifecycleDialogBuilder.setNegativeButton(charSequence4, onClickListener);
        }
        LifecycleAwareDialog create = lifecycleDialogBuilder.create();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return create;
        }
        if (context instanceof LifecycleOwner) {
            create.a(((LifecycleOwner) context).getLifecycle());
        }
        create.show();
        return create;
    }

    public static AlertDialog n(Context context, int i2, int i3, DialogInterface.OnClickListener onClickListener) {
        LifecycleDialogBuilder lifecycleDialogBuilder = new LifecycleDialogBuilder(context, R.style.CustomGradeAlertDialog);
        lifecycleDialogBuilder.setView(R.layout.grade_alert_dialog);
        if (i2 != -999) {
            lifecycleDialogBuilder.setPositiveButton(i2, onClickListener);
        }
        if (i3 != -999) {
            lifecycleDialogBuilder.setNegativeButton(i3, onClickListener);
        }
        LifecycleAwareDialog create = lifecycleDialogBuilder.create();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return create;
        }
        if (context instanceof LifecycleOwner) {
            create.a(((LifecycleOwner) context).getLifecycle());
        }
        create.show();
        return create;
    }

    public static AlertDialog o(Context context, int i2, int i3, int i4, int i5, DialogInterface.OnClickListener onClickListener) {
        return f(context, R.style.CustomGradeAlertDialog, i2, i3, i4, i5, onClickListener);
    }

    public static AlertDialog p(Context context, int i2) {
        LifecycleDialogBuilder lifecycleDialogBuilder = new LifecycleDialogBuilder(context, R.style.AlertDialogCustom);
        View inflate = LayoutInflater.from(context).inflate(R.layout.progress_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.progress_text);
        if (-999 == i2) {
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
        } else {
            textView.setText(i2);
        }
        lifecycleDialogBuilder.setView(inflate);
        LifecycleAwareDialog create = lifecycleDialogBuilder.create();
        boolean z = context instanceof Activity;
        if (z) {
            create.setOwnerActivity((Activity) context);
        }
        if (z && ((Activity) context).isFinishing()) {
            return create;
        }
        if (context instanceof LifecycleOwner) {
            create.a(((LifecycleOwner) context).getLifecycle());
        }
        create.show();
        return create;
    }

    public static AlertDialog q(Context context, CharSequence charSequence) {
        LifecycleDialogBuilder lifecycleDialogBuilder = new LifecycleDialogBuilder(context, R.style.AlertDialogCustom);
        View inflate = LayoutInflater.from(context).inflate(R.layout.progress_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.progress_text);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
        } else {
            textView.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView, 0);
            textView.setText(charSequence);
        }
        lifecycleDialogBuilder.setView(inflate);
        LifecycleAwareDialog create = lifecycleDialogBuilder.create();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return create;
        }
        if (context instanceof LifecycleOwner) {
            create.a(((LifecycleOwner) context).getLifecycle());
        }
        create.show();
        return create;
    }

    public static AlertDialog r(Context context, int i2, int i3) {
        LifecycleDialogBuilder lifecycleDialogBuilder = new LifecycleDialogBuilder(context, R.style.AlertDialogCustom);
        lifecycleDialogBuilder.setTitle(i3);
        View inflate = LayoutInflater.from(context).inflate(R.layout.progress_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.progress_text);
        if (-999 == i2) {
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
        } else {
            textView.setText(i2);
        }
        lifecycleDialogBuilder.setView(inflate);
        LifecycleAwareDialog create = lifecycleDialogBuilder.create();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return create;
        }
        if (context instanceof LifecycleOwner) {
            create.a(((LifecycleOwner) context).getLifecycle());
        }
        create.show();
        return create;
    }

    public static Dialog s(Context context, CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        LifecycleDialogBuilder lifecycleDialogBuilder = new LifecycleDialogBuilder(context);
        lifecycleDialogBuilder.d(onDismissListener);
        AlertDialog create = lifecycleDialogBuilder.setItems(charSequenceArr, onClickListener).setCancelable(true).create();
        create.setCanceledOnTouchOutside(true);
        create.show();
        VdsAgent.showDialog(create);
        return create;
    }

    public static PopupMenu t(Context context, us.pinguo.foundation.h hVar, View view, PopupMenu.OnMenuItemClickListener onMenuItemClickListener) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        for (int i2 = 0; i2 < hVar.c().length; i2++) {
            popupMenu.getMenu().add(0, i2, i2, (String) hVar.c()[i2]);
        }
        popupMenu.setOnMenuItemClickListener(new a(hVar, view, context, onMenuItemClickListener));
        popupMenu.show();
        return popupMenu;
    }

    public static PopupMenu u(Context context, CharSequence[] charSequenceArr, View view, PopupMenu.OnMenuItemClickListener onMenuItemClickListener, int i2) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        for (int i3 = 0; i3 < charSequenceArr.length; i3++) {
            MenuItem add = popupMenu.getMenu().add(0, i3, i3, charSequenceArr[i3]);
            if (i2 == i3) {
                d(popupMenu.getMenu(), true);
                add.setIcon(R.drawable.facebook);
                d(popupMenu.getMenu(), true);
            } else {
                d(popupMenu.getMenu(), false);
            }
        }
        popupMenu.setOnMenuItemClickListener(onMenuItemClickListener);
        popupMenu.show();
        return popupMenu;
    }
}
