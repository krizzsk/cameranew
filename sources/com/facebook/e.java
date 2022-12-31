package com.facebook;
/* compiled from: FacebookCallback.java */
/* loaded from: classes.dex */
public interface e<RESULT> {
    void onCancel();

    void onError(FacebookException facebookException);

    void onSuccess(RESULT result);
}
