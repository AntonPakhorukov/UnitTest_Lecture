import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;
public class CalculatorTest {
    public static void main(String[] args) {
        assertThat(Calculator.calculation(2,2,'+')).isEqualTo(4);
        assertThat(Calculator.calculation(4,2,'-')).isEqualTo(2);
        assertThat(Calculator.calculation(8,2,'/')).isEqualTo(4);
        assertThat(Calculator.calculation(3,2,'*')).isEqualTo(6);

        /**
         * "() ->" синтаксис лямбда выражения или анонимных функций
         * "()" - специальный вызов функции без объявления, могут передаваться параметры, которые могут
         * использоваться в правой части, после стрелки
         */
        assertThatThrownBy(() -> Calculator.calculation(8,4,'_'))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void evaluatesExpression(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2,2,'+')).isEqualTo(4);
    }
    @Test
    void subsctractionExpression(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(4,2,'-')).isEqualTo(2);
    }
    @Test
    void multiplicationExpression(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(3,2,'*')).isEqualTo(6);
    }
    @Test
    void divisionExpression(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(8,2,'/')).isEqualTo(4);
    }
    @Test
    void expectedIllegalStateExceptionOnInvalidOperatorSymbol(){
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculation(8,2,'_'))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void getOperandCompletesCorrectlyWithNumbers() {
        // Создаем тестовое значение
        String testedValue = "9";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        // Сохраним ссылку на ввод с клавиатуры
        InputStream inputStream = System.in;
        // Подменяем ввод
        System.setIn(in);
        //Вызываем наш метод
        Calculator.getOperand();
        //Выведем для наглядности тестовое значение
        System.out.println(testedValue);
        // Подменим ссылку на ввод с клавиатуры обратно
        System.setIn(inputStream);
    }
    @Test
    void getOperandCompletesCorrectlyWithNotNumbers() {
        // Создаем тестовое значение
        String testedValue = "w";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // Сохраним ссылку на ввод с клавиатуры
        InputStream inputStream = System.in;
        // Подменяем ввод
        System.setIn(in);
        System.setOut(new PrintStream(out));
        //Вызываем наш метод
        assertThatThrownBy(() -> Calculator.getOperand()).isInstanceOf(IllegalStateException.class)
                .describedAs("Ошибка ввода данных");
        // Подменим ссылку на ввод с клавиатуры обратно
        System.setIn(inputStream);
        System.setOut(null);
    }

}
