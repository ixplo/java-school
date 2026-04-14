package unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldsSetter {
    private static final Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateFinalStatic(Class clazz, String fieldName, Object value) {
        final Field fieldToUpdate;
        try {
            fieldToUpdate = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            System.out.println("Ошибка при установке поля " + fieldName + " в классе " + clazz.getName());
            throw new IllegalStateException(e);
        }
        final Object base = unsafe.staticFieldBase(fieldToUpdate);
        final long offset = unsafe.staticFieldOffset(fieldToUpdate);
        unsafe.putObject(base, offset, value);
    }

    public static void updateByReflection(Class clazz, String fieldName, Object value) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            field.set(null, value);
        } catch (Exception e) {
            System.out.println("Ошибка при установке значения поля " + fieldName + " в классе " + clazz.getName());
            throw new IllegalStateException(e);
        }
    }

    public static void updateFinalInt(Class clazz, String fieldName, int value) {
        final Field fieldToUpdate;
        try {
            fieldToUpdate = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            System.out.println("Ошибка при установке значения поля " + fieldName + " в классе " + clazz.getName());
            throw new IllegalStateException(e);
        }
        final long offset = unsafe.objectFieldOffset(fieldToUpdate);
        unsafe.putInt(clazz, offset, value);
    }

}
