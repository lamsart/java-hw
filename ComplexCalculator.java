работает вот в таком формате - import java.util.Scanner;

// Класс для работы с комплексными числами
class ComplexNumber {
    double real; // Действительная часть
    double imaginary; // Мнимая часть

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Сложение комплексных чисел
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Вычитание комплексных чисел
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    // Умножение комплексных чисел
    public ComplexNumber multiply(ComplexNumber other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    // Деление комплексных чисел
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        if (denominator == 0) {
            throw new ArithmeticException("Деление на ноль невозможно!");
        }
        double realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(realPart, imaginaryPart);
    }

   
}

// Основной класс с методом main
public class ComplexCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод первого комплексного числа
        System.out.println("Введите действительную часть первого числа:");
        double real1 = scanner.nextDouble();
        System.out.println("Введите мнимую часть первого числа:");
        double imaginary1 = scanner.nextDouble();
        ComplexNumber num1 = new ComplexNumber(real1, imaginary1);

        // Ввод второго комплексного числа
        System.out.println("Введите действительную часть второго числа:");
        double real2 = scanner.nextDouble();
        System.out.println("Введите мнимую часть второго числа:");
        double imaginary2 = scanner.nextDouble();
        ComplexNumber num2 = new ComplexNumber(real2, imaginary2);

        // Ввод операции
        System.out.println("Введите операцию (+, -, *, /):");
        char operator = scanner.next().charAt(0);

        // Выполнение операции
        ComplexNumber result;
        try {
            switch (operator) {
                case '+':
                    result = num1.add(num2);
                    break;
                case '-':
                    result = num1.subtract(num2);
                    break;
                case '*':
                    result = num1.multiply(num2);
                    break;
                case '/':
                    result = num1.divide(num2);
                    break;
                default:
                    System.out.println("Неверный оператор!");
                    return;
            }
            // Вывод результата
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
