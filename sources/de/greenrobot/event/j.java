package de.greenrobot.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriberMethodFinder.java */
/* loaded from: classes3.dex */
public class j {
    private static final Map<String, List<i>> a = new HashMap();
    private static final Map<Class<?>, Class<?>> b = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<i> a(Class<?> cls, String str) {
        List<i> list;
        Method[] declaredMethods;
        ThreadMode threadMode;
        String str2 = String.valueOf(cls.getName()) + '.' + str;
        Map<String, List<i>> map = a;
        synchronized (map) {
            list = map.get(str2);
        }
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            String name = cls2.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                break;
            }
            for (Method method : cls2.getDeclaredMethods()) {
                String name2 = method.getName();
                if (name2.startsWith(str)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        String substring = name2.substring(str.length());
                        if (substring.length() == 0) {
                            threadMode = ThreadMode.PostThread;
                        } else if (substring.equals("MainThread")) {
                            threadMode = ThreadMode.MainThread;
                        } else if (substring.equals("BackgroundThread")) {
                            threadMode = ThreadMode.BackgroundThread;
                        } else if (substring.equals("Async")) {
                            threadMode = ThreadMode.Async;
                        } else if (!b.containsKey(cls2)) {
                            throw new EventBusException("Illegal onEvent method, check for typos: " + method);
                        }
                        Class<?> cls3 = parameterTypes[0];
                        sb.setLength(0);
                        sb.append(name2);
                        sb.append('>');
                        sb.append(cls3.getName());
                        if (hashSet.add(sb.toString())) {
                            arrayList.add(new i(method, threadMode, cls3));
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Map<String, List<i>> map2 = a;
            synchronized (map2) {
                map2.put(str2, arrayList);
            }
            return arrayList;
        }
        throw new EventBusException("Subscriber " + cls + " has no methods called " + str);
    }
}
