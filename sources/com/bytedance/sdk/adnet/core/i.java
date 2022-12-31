package com.bytedance.sdk.adnet.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* compiled from: NetworkResponse.java */
/* loaded from: classes.dex */
public class i {
    public final int a;
    public final byte[] b;
    public final Map<String, String> c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Header> f1243d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f1244e;

    /* renamed from: f  reason: collision with root package name */
    public final long f1245f;

    @Deprecated
    public i(int i2, byte[] bArr, Map<String, String> map, boolean z, long j2) {
        this(i2, bArr, map, a(map), z, j2);
    }

    private static Map<String, String> a(List<Header> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Header header : list) {
            treeMap.put(header.getName(), header.getValue());
        }
        return treeMap;
    }

    public i(int i2, byte[] bArr, boolean z, long j2, List<Header> list) {
        this(i2, bArr, a(list), list, z, j2);
    }

    @Deprecated
    public i(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private i(int i2, byte[] bArr, Map<String, String> map, List<Header> list, boolean z, long j2) {
        this.a = i2;
        this.b = bArr;
        this.c = map;
        if (list == null) {
            this.f1243d = null;
        } else {
            this.f1243d = Collections.unmodifiableList(list);
        }
        this.f1244e = z;
        this.f1245f = j2;
    }

    private static List<Header> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
