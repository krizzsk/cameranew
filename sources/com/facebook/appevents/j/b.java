package com.facebook.appevents.j;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MetadataMatcher.java */
/* loaded from: classes.dex */
final class b {
    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> a(View view) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            ViewGroup j2 = com.facebook.appevents.codeless.internal.d.j(view);
            if (j2 != null) {
                for (View view2 : com.facebook.appevents.codeless.internal.d.b(j2)) {
                    if (view != view2) {
                        arrayList.addAll(c(view2));
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> b(View view) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList();
            arrayList.add(com.facebook.appevents.codeless.internal.d.i(view));
            Object tag = view.getTag();
            if (tag != null) {
                arrayList.add(tag.toString());
            }
            CharSequence contentDescription = view.getContentDescription();
            if (contentDescription != null) {
                arrayList.add(contentDescription.toString());
            }
            try {
                if (view.getId() != -1) {
                    String[] split = view.getResources().getResourceName(view.getId()).split("/");
                    if (split.length == 2) {
                        arrayList.add(split[1]);
                    }
                }
            } catch (Resources.NotFoundException unused) {
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str : arrayList) {
                if (!str.isEmpty() && str.length() <= 100) {
                    arrayList2.add(str.toLowerCase());
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    static List<String> c(View view) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof EditText) {
                return arrayList;
            }
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!charSequence.isEmpty() && charSequence.length() < 100) {
                    arrayList.add(charSequence.toLowerCase());
                }
                return arrayList;
            }
            for (View view2 : com.facebook.appevents.codeless.internal.d.b(view)) {
                arrayList.addAll(c(view2));
            }
            return arrayList;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    static boolean d(String str, List<String> list) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return false;
        }
        try {
            for (String str2 : list) {
                if (str.contains(str2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(List<String> list, List<String> list2) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return false;
        }
        try {
            for (String str : list) {
                if (d(str, list2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return false;
        }
        try {
            return str.matches(str2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return false;
        }
    }
}
