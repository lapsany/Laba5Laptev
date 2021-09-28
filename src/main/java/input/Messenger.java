package input;

import java.util.Locale;
public interface Messenger {
    String getMessage(String msg);

    static Locale initLang() {
        Language language = Language.ru_RU;
        String[] array = language.toString().split("_");
        return new Locale(array[0], array[1]);
    }

}
