package dev_java2.week2;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class NumberValidCheck {
    @DisplayName("입력받은 값 유효성 체크")
    @ParameterizedTest
    @ValueSource(strings = {"5","150","-10"})
    void 너정수니(String input){
        assertTrue(isNumber(input));
    }
    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}