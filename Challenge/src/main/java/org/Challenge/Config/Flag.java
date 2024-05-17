package org.Challenge.Config;

public class Flag{
    private static final ThreadLocal<Boolean> saveFlag = ThreadLocal.withInitial(() -> true);

    public static void setSaveFlag(boolean flag) {
        saveFlag.set(flag);
    }

    public static boolean shouldSave() {
        return saveFlag.get();
    }

    public static void clear() {
        saveFlag.remove();
    }
}
