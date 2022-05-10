package my.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class InputOutputService {
    private final MessageSource messageSource;

    public void printString(String text, @Nullable Object[] params) {
        System.out.printf(text + "\n", params);
    }

    public String readString(String key, Object[] params) {
        printString(key, params);

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        else return "";
    }
}
