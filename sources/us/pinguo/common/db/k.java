package us.pinguo.common.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.common.db.f;
/* compiled from: TypeAdapter.java */
/* loaded from: classes4.dex */
public class k<T> {
    private static HashMap<Class, WeakReference<k>> c = new HashMap<>();
    private final j<T> a;
    private final Map<String, c> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapter.java */
    /* loaded from: classes4.dex */
    public static class a implements j<T> {
        final /* synthetic */ Constructor a;

        a(Constructor constructor) {
            this.a = constructor;
        }

        @Override // us.pinguo.common.db.j
        public T a() {
            try {
                return (T) this.a.newInstance(null);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e4.getTargetException());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapter.java */
    /* loaded from: classes4.dex */
    public static class b extends c {
        final /* synthetic */ Field b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Type type, Field field) {
            super(type);
            this.b = field;
        }

        @Override // us.pinguo.common.db.k.c
        Object a(Object obj) throws IllegalAccessException {
            return this.b.get(obj);
        }

        @Override // us.pinguo.common.db.k.c
        void b(Object obj, Object obj2) throws IllegalAccessException {
            this.b.set(obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeAdapter.java */
    /* loaded from: classes4.dex */
    public static abstract class c {
        Type a;

        protected c(Type type) {
            this.a = type;
        }

        abstract Object a(Object obj) throws IllegalAccessException;

        abstract void b(Object obj, Object obj2) throws IllegalAccessException;
    }

    private k(j<T> jVar, Map<String, c> map) {
        this.a = jVar;
        this.b = map;
    }

    public static <T> k<T> a(Class<? super T> cls) {
        if (Object.class.isAssignableFrom(cls)) {
            WeakReference<k> weakReference = c.get(cls);
            if (weakReference != null) {
                return weakReference.get();
            }
            k<T> kVar = new k<>(g(cls), c(cls));
            c.put(cls, new WeakReference<>(kVar));
            return kVar;
        }
        return null;
    }

    private static c b(Field field) {
        return new b(field.getType(), field);
    }

    private static Map<String, c> c(Class<?> cls) {
        Field[] declaredFields;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            linkedHashMap.put(f(field.getName()), b(field));
        }
        return linkedHashMap;
    }

    private static String f(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll("_", "").toLowerCase();
    }

    private static <T> j<T> g(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new a(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public T d(Cursor cursor, List<f.c> list) {
        int columnIndex;
        T a2 = this.a.a();
        try {
            for (f.c cVar : list) {
                String f2 = f(cVar.c);
                String str = cVar.a;
                c cVar2 = this.b.get(f2);
                if (cVar2 != null && (columnIndex = cursor.getColumnIndex(str)) >= 0) {
                    Type type = cVar2.a;
                    if (type != Integer.TYPE && type != Integer.class) {
                        if (type == String.class) {
                            cVar2.b(a2, cursor.getString(columnIndex));
                        } else {
                            if (type != Boolean.TYPE && type != Boolean.class) {
                                if (type != Double.TYPE && type != Double.class) {
                                    if (type != Long.TYPE && type != Long.class) {
                                        if (type != Float.TYPE && type != Float.class) {
                                            if (type == Short.TYPE || type == Short.class) {
                                                cVar2.b(a2, Short.valueOf(cursor.getShort(columnIndex)));
                                            }
                                        }
                                        cVar2.b(a2, Float.valueOf(cursor.getFloat(columnIndex)));
                                    }
                                    cVar2.b(a2, Long.valueOf(cursor.getLong(columnIndex)));
                                }
                                cVar2.b(a2, Double.valueOf(cursor.getDouble(columnIndex)));
                            }
                            boolean z = true;
                            if (1 != cursor.getInt(columnIndex)) {
                                z = false;
                            }
                            cVar2.b(a2, Boolean.valueOf(z));
                        }
                    }
                    cVar2.b(a2, Integer.valueOf(cursor.getInt(columnIndex)));
                }
            }
            return a2;
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    public ContentValues e(T t, List<f.c> list) {
        c cVar;
        ContentValues contentValues = new ContentValues();
        try {
            for (f.c cVar2 : list) {
                String f2 = f(cVar2.c);
                if (!TextUtils.isEmpty(f2) && (cVar = this.b.get(f2)) != null) {
                    Type type = cVar.a;
                    if (type != Boolean.TYPE && type != Boolean.class) {
                        Object a2 = cVar.a(t);
                        if (a2 != null) {
                            contentValues.put(cVar2.a, String.valueOf(a2));
                        }
                    }
                    contentValues.put(cVar2.a, Integer.valueOf(((Boolean) cVar.a(t)).booleanValue() ? 1 : 0));
                }
            }
            return contentValues;
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    public void h(T t, int i2, f.c cVar) {
        c cVar2 = this.b.get(f(cVar.c));
        if (cVar2 != null) {
            try {
                Type type = cVar2.a;
                if (type == Integer.TYPE || type == Integer.class) {
                    cVar2.b(t, Integer.valueOf(i2));
                }
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }
}
