package com.facebook.core.internal.logging.dumpsys;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class AndroidRootResolver {

    /* renamed from: e  reason: collision with root package name */
    private static final String f2420e = "AndroidRootResolver";
    private boolean a;
    private Object b;
    private Field c;

    /* renamed from: d  reason: collision with root package name */
    private Field f2421d;

    /* loaded from: classes.dex */
    public static class ListenableArrayList extends ArrayList<View> {
        @Nullable
        private b listener;

        public void setListener(b bVar) {
            this.listener = bVar;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(View view) {
            b bVar;
            boolean add = super.add((ListenableArrayList) view);
            if (add && (bVar = this.listener) != null) {
                bVar.c(view);
                this.listener.a(this);
            }
            return add;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(@Nullable Object obj) {
            b bVar;
            boolean remove = super.remove(obj);
            if (remove && (bVar = this.listener) != null && (obj instanceof View)) {
                bVar.b((View) obj);
                this.listener.a(this);
            }
            return remove;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public View remove(int i2) {
            View view = (View) super.remove(i2);
            b bVar = this.listener;
            if (bVar != null) {
                bVar.b(view);
                this.listener.a(this);
            }
            return view;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(List<View> list);

        void b(View view);

        void c(View view);
    }

    /* loaded from: classes.dex */
    public static class c {
        public final View a;
        public final WindowManager.LayoutParams b;

        private c(View view, WindowManager.LayoutParams layoutParams) {
            this.a = view;
            this.b = layoutParams;
        }
    }

    private void a() {
        this.a = true;
        int i2 = Build.VERSION.SDK_INT;
        String str = i2 > 16 ? "android.view.WindowManagerGlobal" : "android.view.WindowManagerImpl";
        String str2 = i2 > 16 ? "getInstance" : "getDefault";
        try {
            Class<?> cls = Class.forName(str);
            this.b = cls.getMethod(str2, new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mViews");
            this.c = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("mParams");
            this.f2421d = declaredField2;
            declaredField2.setAccessible(true);
        } catch (ClassNotFoundException e2) {
            Log.d(f2420e, String.format("could not find class: %s", str), e2);
        } catch (IllegalAccessException e3) {
            Log.d(f2420e, String.format("reflective setup failed using obj: %s method: %s field: %s", str, str2, "mViews"), e3);
        } catch (NoSuchFieldException e4) {
            Log.d(f2420e, String.format("could not find field: %s or %s on %s", "mParams", "mViews", str), e4);
        } catch (NoSuchMethodException e5) {
            Log.d(f2420e, String.format("could not find method: %s on %s", str2, str), e5);
        } catch (RuntimeException e6) {
            Log.d(f2420e, String.format("reflective setup failed using obj: %s method: %s field: %s", str, str2, "mViews"), e6);
        } catch (InvocationTargetException e7) {
            Log.d(f2420e, String.format("could not invoke: %s on %s", str2, str), e7.getCause());
        }
    }

    @Nullable
    public List<c> b() {
        List list;
        List list2;
        if (!this.a) {
            a();
        }
        Object obj = this.b;
        if (obj == null) {
            Log.d(f2420e, "No reflective access to windowmanager object.");
            return null;
        }
        Field field = this.c;
        if (field == null) {
            Log.d(f2420e, "No reflective access to mViews");
            return null;
        } else if (this.f2421d == null) {
            Log.d(f2420e, "No reflective access to mPArams");
            return null;
        } else {
            try {
                if (Build.VERSION.SDK_INT < 19) {
                    list = Arrays.asList((View[]) field.get(obj));
                    list2 = Arrays.asList((WindowManager.LayoutParams[]) this.f2421d.get(this.b));
                } else {
                    list = (List) field.get(obj);
                    list2 = (List) this.f2421d.get(this.b);
                }
                ArrayList arrayList = new ArrayList();
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(new c((View) list.get(i2), (WindowManager.LayoutParams) list2.get(i2)));
                }
                return arrayList;
            } catch (IllegalAccessException e2) {
                Log.d(f2420e, String.format("Reflective access to %s or %s on %s failed.", this.c, this.f2421d, this.b), e2);
                return null;
            } catch (RuntimeException e3) {
                Log.d(f2420e, String.format("Reflective access to %s or %s on %s failed.", this.c, this.f2421d, this.b), e3);
                return null;
            }
        }
    }
}
