package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.datatransport.f;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import java.util.Collections;
import java.util.List;
@Keep
/* loaded from: classes2.dex */
public class TransportRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        ComponentFactory componentFactory;
        Component.Builder add = Component.builder(f.class).add(Dependency.required(Context.class));
        componentFactory = TransportRegistrar$$Lambda$1.instance;
        return Collections.singletonList(add.factory(componentFactory).build());
    }
}
