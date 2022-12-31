package com.growingio.android.sdk.monitor.jvmti;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class Frame {
    private final LocalVariable[] locals;
    private Method method;

    /* loaded from: classes2.dex */
    public static final class LocalVariable {
        final String name;
        final Object value;

        public LocalVariable(String str, Object obj) {
            this.name = str;
            this.value = obj;
        }

        public String getName() {
            return this.name;
        }

        public Object getValue() {
            return this.value;
        }

        public String toString() {
            return "LocalVariable{name='" + this.name + "', value=" + this.value + '}';
        }
    }

    public Frame(Method method, LocalVariable[] localVariableArr) {
        this.method = method;
        this.locals = localVariableArr;
    }

    public Map<String, Object> getLocals() {
        LocalVariable[] localVariableArr;
        LocalVariable[] localVariableArr2 = this.locals;
        if (localVariableArr2 != null && localVariableArr2.length != 0) {
            HashMap hashMap = new HashMap();
            for (LocalVariable localVariable : this.locals) {
                if (localVariable != null) {
                    hashMap.put(localVariable.getName(), localVariable.getValue());
                }
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    public Method getMethod() {
        return this.method;
    }

    public String toString() {
        return "Frame{, locals=" + Arrays.toString(this.locals) + '}';
    }
}
