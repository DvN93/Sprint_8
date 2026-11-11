package org.example;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть null");
        }
        String whitespace = " ";
        String nameWithoutWhitespaces = name.replace(whitespace, "");
        int spaceCount = name.length() - nameWithoutWhitespaces.length();
        return(!name.startsWith(whitespace) && (!name.endsWith(whitespace)) && name.length() >= 3 && name.length() <= 19 &&
                spaceCount == 1);
    }
}
