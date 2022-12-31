package com.tencent.tauth;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public interface IUiListener {
    void onCancel();

    void onComplete(Object obj);

    void onError(UiError uiError);

    void onWarning(int i2);
}
