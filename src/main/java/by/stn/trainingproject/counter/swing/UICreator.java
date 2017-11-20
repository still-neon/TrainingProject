package by.stn.trainingproject.counter.swing;

//вопросы
//1. Доделать классы с коментами
//2. Ссылки васи в скайпе
//3. Tread Pool. а) переделать на ТП из одного потока b) ТП на 3 потока по одной кнопке запускалось в 3 разных места
//с) сделать 3 кнопки и 3 лэйбы на UI, привязать потоки к кнопкам, запуск по кнопкам, дизейблиться кнопка
//d) Update лэйбов числа закачки файла. проценты закачки. EDT e) Pause, приостановка потоков по кнопке Start/Hold/Resume/Finished
//4.
//5.


import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.Map;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UICreator {
    private JFrame frame;
    private JTextField inputField;

    public UICreator()  {
        // TODO execute on EDT and check the bug
        createUI();
    }

    private void createUI()  {
        frame = new JFrame("Symbols enter");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setVisible(true);

        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frame.setContentPane(contents);
        inputField = new JTextField(8);
        contents.add(inputField);

        inputField.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null)
                    return;
                if ((getLength() + str.length()) <= 10) {
                    super.insertString(offset, str, attr);
                }
            }
        });

        inputField.setToolTipText("Enter from 0 to 10 symbols");
        inputField.setHorizontalAlignment(JTextField.RIGHT);
        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Map<Character, Integer> symbols = SymbolsCounter.count(inputField.getText().toLowerCase());
                JOptionPane.showMessageDialog(frame, "You've entered: " + symbols);
            }
        });
    }
}