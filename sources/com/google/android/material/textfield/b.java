package com.google.android.material.textfield;

import androidx.annotation.NonNull;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomEndIconDelegate.java */
/* loaded from: classes2.dex */
public class b extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        this.a.setEndIconOnClickListener(null);
        this.a.setEndIconOnLongClickListener(null);
    }
}
