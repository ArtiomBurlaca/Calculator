import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class calculator {
    JPanel mainPanel;
    private JTextField textDisplay;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton a8Button;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton a00Button;
    private JButton a9Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a0Button;
    private JButton xButton;
    private JButton MRButton;
    private JButton cButton1;
    private JButton xButton1;
    private JButton a6Button;
    private JButton a3Button;
    private JButton button5;
    private JButton xXButton;
    private JButton button6;
    private JButton cosButton;
    private JButton ctgButton;
    private JButton octalButton;
    private JButton x2Button;
    private JButton xButton2;
    private JButton sinButton;
    private JButton tgButton;
    private JButton binarButton;
    private JButton hexButton;
    private JButton radicalButton;

    private Double num1, num2, result;
    private String operation, tempResult;
    private Integer temp;
    private Double temp1;

    public calculator() {
        cButton1.addActionListener(e -> textDisplay.setText(""));
        a7Button.addActionListener(e -> textDisplay.setText(textDisplay.getText() + a7Button.getText()));
        a8Button.addActionListener(e -> textDisplay.setText(textDisplay.getText() + a8Button.getText()));
        a9Button.addActionListener(e -> textDisplay.setText(textDisplay.getText() + a9Button.getText()));
        a4Button.addActionListener(e -> textDisplay.setText(textDisplay.getText() + a4Button.getText()));
        a5Button.addActionListener(e -> textDisplay.setText(textDisplay.getText() + a5Button.getText()));
        a6Button.addActionListener(e -> textDisplay.setText(textDisplay.getText() + a6Button.getText()));
        a1Button.addActionListener(e -> textDisplay.setText(textDisplay.getText() + a1Button.getText()));
        a2Button.addActionListener(e -> textDisplay.setText(textDisplay.getText() + a2Button.getText()));
        a3Button.addActionListener(e -> textDisplay.setText(textDisplay.getText() + a3Button.getText()));
        a0Button.addActionListener(e -> textDisplay.setText(textDisplay.getText() + a0Button.getText()));
        a00Button.addActionListener(e -> textDisplay.setText(textDisplay.getText() + a00Button.getText()));

        button5.addActionListener(e -> {
            if (!textDisplay.getText().contains(".")) {
                textDisplay.setText(textDisplay.getText() + button5.getText());
            }
        });

        xButton1.addActionListener(e -> {
            num1 = Double.parseDouble(textDisplay.getText());
            operation = "*";
            textDisplay.setText("");
        });

        xButton.addActionListener(e -> {
            num1 = Double.parseDouble(textDisplay.getText());
            operation = "/";
            textDisplay.setText("");
        });

        button3.addActionListener(e -> {
            num1 = Double.parseDouble(textDisplay.getText());
            operation = "+";
            textDisplay.setText("");
        });

        button2.addActionListener(e -> {
            if (textDisplay.getText().isEmpty()) {
                textDisplay.setText("-");
            } else {
                num1 = Double.parseDouble(textDisplay.getText());
                operation = "-";
                textDisplay.setText("");
            }
        });

        MRButton.addActionListener(e -> {
            String string;
            StringBuilder stringBuilder = new StringBuilder(textDisplay.getText());
            stringBuilder.deleteCharAt(textDisplay.getText().length() - 1);
            string = String.valueOf(stringBuilder);
            textDisplay.setText(string);
        });

        xXButton.addActionListener(e -> {
            temp1 = Double.parseDouble(textDisplay.getText());
            operation = "x^y";
            textDisplay.setText("");
        });

        button1.addActionListener(e ->{

            num2 = Double.parseDouble(textDisplay.getText());
            switch (operation) {
                case "+" -> {
                    result = num1 + num2;
                    textDisplay.setText(String.valueOf(result));
                }
                case "-" -> {
                    result = num1 - num2;
                    textDisplay.setText(String.valueOf(result));
                }
                case "*" -> {
                    result = num1 * num2;
                    textDisplay.setText(String.valueOf(result));
                }
                case "/" -> {
                    if (num1 == 0) {
                        textDisplay.setText("Dividing by 0");
                    } else {
                        result = num1 / num2;
                        textDisplay.setText(String.valueOf(result));
                    }
                }
                case "x^y" -> {
                    result = Math.pow(temp1, num2);
                    textDisplay.setText(String.valueOf(result));
                }
            }
        });

        x2Button.addActionListener(e -> {
            num1 = Double.parseDouble(textDisplay.getText());
            result = num1 * num1;
            textDisplay.setText(String.valueOf(result));
        });

        sinButton.addActionListener(e -> {
            num1 = Double.parseDouble(textDisplay.getText());
            result = Math.sin(num1);
            textDisplay.setText(String.valueOf(result));
        });

        cosButton.addActionListener(e -> {
            num1 = Double.parseDouble(textDisplay.getText());
            result = Math.cos(num1);
            textDisplay.setText(String.valueOf(result));
        });

        tgButton.addActionListener(e -> {
            num1 = Double.parseDouble(textDisplay.getText());
            result = Math.tan(num1);
            textDisplay.setText(String.valueOf(result));
        });

        ctgButton.addActionListener(e -> {
            num1 = Double.parseDouble(textDisplay.getText());
            result = 1 / Math.tan(num1);
            textDisplay.setText(String.valueOf(result));
        });

        binarButton.addActionListener(e -> {
            temp1 = Double.parseDouble(textDisplay.getText());
            tempResult = splitDoubleToBinary(temp1);
            textDisplay.setText(tempResult);
        });

        octalButton.addActionListener(e -> {
            temp1 = Double.parseDouble(textDisplay.getText());
            tempResult = splitDoubleToOctal(temp1);
            textDisplay.setText(tempResult);
        });

        hexButton.addActionListener(e -> {
            temp1 = Double.parseDouble(textDisplay.getText());
            tempResult = splitDoubleToHexadecimal(temp1);
            textDisplay.setText(tempResult);
        });

        xButton2.addActionListener(e -> {
            num1 = Double.parseDouble(textDisplay.getText());
            result = Math.abs(num1);
            textDisplay.setText(String.valueOf(result));
        });

        button6.addActionListener(e -> {
            temp = Integer.valueOf(textDisplay.getText());
            int result = 1;
            for (int i = 1; i <= temp; i++) {
                result *= i;
                textDisplay.setText(" " + result);
            }
        });

        radicalButton.addActionListener(e -> {
            num1 = Double.parseDouble(textDisplay.getText());
            if (num1 >= 0) {
                result = Math.sqrt(num1);
                textDisplay.setText(String.valueOf(result));
            } else {
                textDisplay.setText("Negative number");
            }
        });
        ActionListener listener = e -> {
            Pattern pattern = Pattern.compile("\\d+");

            // Create a Matcher and apply the pattern to the text
            Matcher matcher = pattern.matcher(textDisplay.getText());
            System.out.println(textDisplay.getText());

            if (!matcher.find() && !textDisplay.getText().equals("-")) {
                textDisplay.setText("");
            }
        };
        a8Button.addActionListener(listener);
        a4Button.addActionListener(listener);
        a1Button.addActionListener(listener);
        a9Button.addActionListener(listener);
        a5Button.addActionListener(listener);
        a2Button.addActionListener(listener);
        a7Button.addActionListener(listener);
        a6Button.addActionListener(listener);
        a3Button.addActionListener(listener);
    }

    //transform to binary function that is used
    public static String splitDoubleToBinary(double num) {
        long wholePart = (long) num;
        double fractionalPart = num - wholePart;

        String wholePartBinary = Long.toBinaryString(wholePart);
        String fractionalPartBinary = convertFractionalPartToBinary(fractionalPart);

        // Remove the decimal point from the fractional part
        fractionalPartBinary = fractionalPartBinary.replace(".", "");

        return wholePartBinary + "," + fractionalPartBinary;
    }

    private static String convertFractionalPartToBinary(double fractionalPart) {
        StringBuilder binaryFractional = new StringBuilder(".");

        while (fractionalPart > 0.0) {
            if (binaryFractional.length() > 32) { // Limit the precision to 32 bits for this example
                break;
            }
            fractionalPart *= 2;
            if (fractionalPart >= 1) {
                binaryFractional.append("1");
                fractionalPart -= 1;
            } else {
                binaryFractional.append("0");
            }
        }

        return binaryFractional.toString();
    }

    // Function that return octal code
    public static String splitDoubleToOctal(double num) {
        long wholePart = (long) num;
        double fractionalPart = num - wholePart;

        String wholePartOctal = Long.toOctalString(wholePart);
        String fractionalPartOctal = convertFractionalPartToOctal(fractionalPart);

        if (fractionalPartOctal.equals("0")) {
            return wholePartOctal;
        } else {
            return wholePartOctal + "," + fractionalPartOctal.substring(1); // Remove the leading zero
        }
    }

    private static String convertFractionalPartToOctal(double fractionalPart) {
        StringBuilder octalFractional = new StringBuilder("0");

        for (int i = 0; i < 10; i++) { // Limit the precision to 10 digits for this example
            fractionalPart *= 8;
            int digit = (int) fractionalPart;
            octalFractional.append(digit);
            fractionalPart -= digit;
        }

        return octalFractional.toString();
    }

    // Function that return hexadecimal cod
    public static String splitDoubleToHexadecimal(double num) {
        long wholePart = (long) num;
        double fractionalPart = num - wholePart;

        String wholePartHexadecimal = Long.toHexString(wholePart);
        String fractionalPartHexadecimal = convertFractionalPartToHexadecimal(fractionalPart);

        return wholePartHexadecimal + "," + fractionalPartHexadecimal;
    }

    private static String convertFractionalPartToHexadecimal(double fractionalPart) {
        StringBuilder hexadecimalFractional = new StringBuilder();

        for (int i = 0; i < 10; i++) { // Limit the precision to 10 digits for this example
            fractionalPart *= 16;
            int digit = (int) fractionalPart;
            hexadecimalFractional.append(Integer.toHexString(digit));
            fractionalPart -= digit;
        }

        return hexadecimalFractional.toString();
    }


    // The rest of your calculator class remains the same

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}




