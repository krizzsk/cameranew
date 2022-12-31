package com.facebook.login;

import com.facebook.AccessToken;
import java.util.Set;
/* compiled from: LoginResult.java */
/* loaded from: classes.dex */
public class d {
    private final AccessToken a;
    private final Set<String> b;

    public d(AccessToken accessToken, Set<String> set, Set<String> set2) {
        this.a = accessToken;
        this.b = set;
    }

    public AccessToken a() {
        return this.a;
    }

    public Set<String> b() {
        return this.b;
    }
}
