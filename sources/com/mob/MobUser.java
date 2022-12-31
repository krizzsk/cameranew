package com.mob;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes2.dex */
public final class MobUser implements PublicMemberKeeper {
    private boolean a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f5844d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Object> f5845e;

    /* renamed from: f  reason: collision with root package name */
    private String f5846f;

    /* renamed from: g  reason: collision with root package name */
    private HashSet<UserWatcher> f5847g = new HashSet<>();

    /* loaded from: classes2.dex */
    public interface OnUserGotListener {
        void onUserGot(MobUser mobUser);
    }

    /* loaded from: classes2.dex */
    public interface UserWatcher {
        void onUserStateChange(MobUser mobUser);
    }

    private MobUser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HashMap<String, String> a(String[] strArr) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OnUserGotListener onUserGotListener) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(UserWatcher userWatcher) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, String str3, HashMap<String, Object> hashMap, String str4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(UserWatcher userWatcher) {
    }

    public String getAvatar() {
        return this.f5844d;
    }

    public HashMap<String, Object> getExtraInfo() {
        return this.f5845e;
    }

    public String getId() {
        return this.b;
    }

    public String getMobUserId() {
        return this.f5846f;
    }

    public String getNickName() {
        return this.c;
    }

    public boolean isAnonymous() {
        return this.a;
    }
}
