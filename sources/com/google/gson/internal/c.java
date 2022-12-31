package com.google.gson.internal;

import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: Excluder.java */
/* loaded from: classes2.dex */
public final class c implements r, Cloneable {
    public static final c DEFAULT = new c();
    private static final double IGNORE_VERSIONS = -1.0d;
    private boolean requireExpose;
    private double version = IGNORE_VERSIONS;
    private int modifiers = 136;
    private boolean serializeInnerClasses = true;
    private List<com.google.gson.b> serializationStrategies = Collections.emptyList();
    private List<com.google.gson.b> deserializationStrategies = Collections.emptyList();

    /* compiled from: Excluder.java */
    /* loaded from: classes2.dex */
    class a extends q<T> {
        private q<T> delegate;
        final /* synthetic */ com.google.gson.e val$gson;
        final /* synthetic */ boolean val$skipDeserialize;
        final /* synthetic */ boolean val$skipSerialize;
        final /* synthetic */ com.google.gson.t.a val$type;

        a(boolean z, boolean z2, com.google.gson.e eVar, com.google.gson.t.a aVar) {
            this.val$skipDeserialize = z;
            this.val$skipSerialize = z2;
            this.val$gson = eVar;
            this.val$type = aVar;
        }

        private q<T> delegate() {
            q<T> qVar = this.delegate;
            if (qVar != 0) {
                return qVar;
            }
            q<T> n = this.val$gson.n(c.this, this.val$type);
            this.delegate = n;
            return n;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
        @Override // com.google.gson.q
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (this.val$skipDeserialize) {
                aVar.m0();
                return null;
            }
            return delegate().read(aVar);
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            if (this.val$skipSerialize) {
                bVar.S();
            } else {
                delegate().write(bVar, t);
            }
        }
    }

    private boolean excludeClassChecks(Class<?> cls) {
        if (this.version == IGNORE_VERSIONS || isValidVersion((com.google.gson.s.d) cls.getAnnotation(com.google.gson.s.d.class), (com.google.gson.s.e) cls.getAnnotation(com.google.gson.s.e.class))) {
            return (!this.serializeInnerClasses && isInnerClass(cls)) || isAnonymousOrLocal(cls);
        }
        return true;
    }

    private boolean excludeClassInStrategy(Class<?> cls, boolean z) {
        for (com.google.gson.b bVar : z ? this.serializationStrategies : this.deserializationStrategies) {
            if (bVar.b(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnonymousOrLocal(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean isInnerClass(Class<?> cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean isValidSince(com.google.gson.s.d dVar) {
        return dVar == null || dVar.value() <= this.version;
    }

    private boolean isValidUntil(com.google.gson.s.e eVar) {
        return eVar == null || eVar.value() > this.version;
    }

    private boolean isValidVersion(com.google.gson.s.d dVar, com.google.gson.s.e eVar) {
        return isValidSince(dVar) && isValidUntil(eVar);
    }

    @Override // com.google.gson.r
    public <T> q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean excludeClassChecks = excludeClassChecks(rawType);
        boolean z = excludeClassChecks || excludeClassInStrategy(rawType, true);
        boolean z2 = excludeClassChecks || excludeClassInStrategy(rawType, false);
        if (z || z2) {
            return new a(z2, z, eVar, aVar);
        }
        return null;
    }

    public c disableInnerClassSerialization() {
        c m19clone = m19clone();
        m19clone.serializeInnerClasses = false;
        return m19clone;
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        return excludeClassChecks(cls) || excludeClassInStrategy(cls, z);
    }

    public boolean excludeField(Field field, boolean z) {
        com.google.gson.s.a aVar;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version == IGNORE_VERSIONS || isValidVersion((com.google.gson.s.d) field.getAnnotation(com.google.gson.s.d.class), (com.google.gson.s.e) field.getAnnotation(com.google.gson.s.e.class))) && !field.isSynthetic()) {
            if (!this.requireExpose || ((aVar = (com.google.gson.s.a) field.getAnnotation(com.google.gson.s.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.serializeInnerClasses || !isInnerClass(field.getType())) && !isAnonymousOrLocal(field.getType())) {
                    List<com.google.gson.b> list = z ? this.serializationStrategies : this.deserializationStrategies;
                    if (list.isEmpty()) {
                        return false;
                    }
                    com.google.gson.c cVar = new com.google.gson.c(field);
                    for (com.google.gson.b bVar : list) {
                        if (bVar.a(cVar)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public c excludeFieldsWithoutExposeAnnotation() {
        c m19clone = m19clone();
        m19clone.requireExpose = true;
        return m19clone;
    }

    public c withExclusionStrategy(com.google.gson.b bVar, boolean z, boolean z2) {
        c m19clone = m19clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.serializationStrategies);
            m19clone.serializationStrategies = arrayList;
            arrayList.add(bVar);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
            m19clone.deserializationStrategies = arrayList2;
            arrayList2.add(bVar);
        }
        return m19clone;
    }

    public c withModifiers(int... iArr) {
        c m19clone = m19clone();
        m19clone.modifiers = 0;
        for (int i2 : iArr) {
            m19clone.modifiers = i2 | m19clone.modifiers;
        }
        return m19clone;
    }

    public c withVersion(double d2) {
        c m19clone = m19clone();
        m19clone.version = d2;
        return m19clone;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public c m19clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }
}
