package com.unity3d.player;

import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes3.dex */
final class r {
    private HashMap a = new HashMap();
    private Class b;
    private Object c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public Class[] a;
        public Method b = null;

        public a(Class[] clsArr) {
            this.a = clsArr;
        }
    }

    public r(Class cls, Object obj) {
        this.b = null;
        this.c = null;
        this.b = cls;
        this.c = obj;
    }

    private void a(String str, a aVar) {
        try {
            aVar.b = this.b.getMethod(str, aVar.a);
        } catch (Exception e2) {
            g.Log(6, "Exception while trying to get method " + str + ". " + e2.getLocalizedMessage());
            aVar.b = null;
        }
    }

    public final Object a(String str, Object... objArr) {
        StringBuilder sb;
        Object obj = null;
        if (this.a.containsKey(str)) {
            a aVar = (a) this.a.get(str);
            if (aVar.b == null) {
                a(str, aVar);
            }
            Method method = aVar.b;
            if (method != null) {
                try {
                    obj = objArr.length == 0 ? method.invoke(this.c, new Object[0]) : method.invoke(this.c, objArr);
                } catch (Exception e2) {
                    g.Log(6, "Error trying to call delegated method " + str + ". " + e2.getLocalizedMessage());
                }
                return obj;
            }
            sb = new StringBuilder("Unable to create method: ");
        } else {
            sb = new StringBuilder("No definition for method ");
            sb.append(str);
            str = " can be found";
        }
        sb.append(str);
        g.Log(6, sb.toString());
        return null;
    }

    public final void a(String str, Class[] clsArr) {
        this.a.put(str, new a(clsArr));
    }
}
