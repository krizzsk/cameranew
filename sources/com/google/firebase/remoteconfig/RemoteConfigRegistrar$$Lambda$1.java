package com.google.firebase.remoteconfig;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
/* loaded from: classes2.dex */
final /* synthetic */ class RemoteConfigRegistrar$$Lambda$1 implements ComponentFactory {
    private static final RemoteConfigRegistrar$$Lambda$1 instance = new RemoteConfigRegistrar$$Lambda$1();

    private RemoteConfigRegistrar$$Lambda$1() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return RemoteConfigRegistrar.lambda$getComponents$0(componentContainer);
    }
}
