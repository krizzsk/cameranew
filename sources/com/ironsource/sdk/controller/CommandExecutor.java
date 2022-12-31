package com.ironsource.sdk.controller;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class CommandExecutor {
    private CommandExecutorState a = CommandExecutorState.NOT_READY;
    private ArrayList b = new ArrayList();

    /* loaded from: classes2.dex */
    enum CommandExecutorState {
        NOT_READY,
        READY
    }

    public CommandExecutor(String str) {
    }

    public synchronized void a(Runnable runnable) {
        if (this.a != CommandExecutorState.READY) {
            this.b.add(runnable);
        } else {
            runnable.run();
        }
    }

    public synchronized void b() {
        Object[] array = this.b.toArray();
        for (int i2 = 0; i2 < array.length; i2++) {
            ((Runnable) array[i2]).run();
            array[i2] = null;
        }
        this.b.clear();
    }

    public synchronized void c() {
        this.a = CommandExecutorState.READY;
    }
}
