package com.growingio.android.sdk.ipc;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class VariableEntity {
    private final int maxSize;
    private final String name;
    private Object obj;
    private boolean persistent = false;
    private int index = -1;
    private int start = -1;
    private int end = -1;
    private int modCount = -1;
    private boolean isChanged = false;
    private int lenSize = 2;

    public VariableEntity(@NonNull String str, int i2) {
        this.name = str;
        this.maxSize = i2;
    }

    public static VariableEntity createIntVariable(String str) {
        VariableEntity variableEntity = new VariableEntity(str, 4);
        variableEntity.setLenSize(0);
        return variableEntity;
    }

    public static VariableEntity createLongVariable(String str) {
        VariableEntity variableEntity = new VariableEntity(str, 8);
        variableEntity.setLenSize(0);
        return variableEntity;
    }

    public static VariableEntity createStringVariable(String str, int i2) {
        VariableEntity variableEntity = new VariableEntity(str, i2 * 4);
        variableEntity.setLenSize(2);
        return variableEntity;
    }

    public int getEnd() {
        return this.end;
    }

    public int getIndex() {
        return this.index;
    }

    public int getLenSize() {
        return this.lenSize;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getModCount() {
        return this.modCount;
    }

    public String getName() {
        return this.name;
    }

    public Object getObj() {
        return this.obj;
    }

    public int getStart() {
        return this.start;
    }

    public boolean isChanged() {
        return this.isChanged;
    }

    public boolean isPersistent() {
        return this.persistent;
    }

    public void setChanged(boolean z) {
        this.isChanged = z;
    }

    public void setEnd(int i2) {
        this.end = i2;
    }

    public void setIndex(int i2) {
        this.index = i2;
    }

    public void setLenSize(int i2) {
        this.lenSize = i2;
    }

    public void setModCount(int i2) {
        this.modCount = i2;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setPersistent(boolean z) {
        this.persistent = z;
    }

    public void setStart(int i2) {
        this.start = i2;
    }
}
