import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CampoEletrico implements ActionListener {

    JFrame frame;

    JButton calcularBtn, resetBtn;

    JTextField q4Input, q8Input, dInput;

    JTextField e4Output, e8Output, erOutput;

    double q4, q8, d;

    final double k = 8.99e9;
    final double e = 1.6e-19;

    CampoEletrico() {

        frame = new JFrame("Calculadora de Campo Elétrico");
        frame.setSize(520,430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        //Inputs

        JPanel inputPanel = new JPanel(null);

        inputPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                "Entradas",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial",Font.BOLD,14)));

        inputPanel.setBounds(20,20,460,160);

        JLabel q4Label = createLabel("Carga q4:",20,30,180,25);
        q4Input = createTextField("",250,30,120,25,true);

        JLabel q8Label = createLabel("Carga q8:",20,70,180,25);
        q8Input = createTextField("",250,70,120,25,true);

        JLabel dLabel = createLabel("Distância d (m):",20,110,180,25);
        dInput = createTextField("",250,110,120,25,true);

        inputPanel.add(q4Label);
        inputPanel.add(q4Input);

        inputPanel.add(q8Label);
        inputPanel.add(q8Input);

        inputPanel.add(dLabel);
        inputPanel.add(dInput);

        //Outputs

        JPanel outputPanel = new JPanel(null);

        outputPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                "Resultados",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14)));

        outputPanel.setBounds(20,190,460,120);

        e4Output = createOutput("Campo de q4:");
        e4Output.setBounds(20,25,410,25);

        e8Output = createOutput("Campo de q8:");
        e8Output.setBounds(20,55,410,25);

        erOutput = createOutput("Campo Resultante:");
        erOutput.setBounds(20,85,410,25);

        outputPanel.add(e4Output);
        outputPanel.add(e8Output);
        outputPanel.add(erOutput);

        //Botões

        JPanel buttonPanel = new JPanel(null);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        buttonPanel.setBounds(20,320,460,60);

        calcularBtn = new JButton("Calcular");
        calcularBtn.setBounds(80,15,120,30);
        calcularBtn.addActionListener(this);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(260,15,120,30);
        resetBtn.addActionListener(this);

        buttonPanel.add(calcularBtn);
        buttonPanel.add(resetBtn);

        frame.add(inputPanel);
        frame.add(outputPanel);
        frame.add(buttonPanel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CampoEletrico();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calcularBtn) {

            try {

                q4 = Double.parseDouble(q4Input.getText());
                q8 = Double.parseDouble(q8Input.getText());
                d = Double.parseDouble(dInput.getText());

                // Tratamento de erros

                if (q4 == 0 || q8 == 0) {
                    errorMsg("As cargas devem ser diferentes de zero.");
                    return;
                }

                if (d <= 0) {
                    errorMsg("A distância deve ser maior que zero.");
                    return;
                }

                // Cálculos

                double E4 = (k * (q4 * this.e)) / (d * d);
                double E8 = (k * (q8 * this.e)) / (d * d);
                double ER = E4 + E8;

                e4Output.setText("Campo de q4: " +
                        String.format("%.3e", E4));

                e8Output.setText("Campo de q8: " +
                        String.format("%.3e", E8));

                erOutput.setText("Campo Resultante: " +
                        String.format("%.3e", ER));

            } catch (Exception ex) {

                errorMsg("Digite valores válidos.");

            }

        }

        if (e.getSource() == resetBtn) {

            q4Input.setText("");
            q8Input.setText("");
            dInput.setText("");

            e4Output.setText("Campo de q4:");
            e8Output.setText("Campo de q8:");
            erOutput.setText("Campo Resultante:");
        }

    }
    // Campos
    private JTextField createTextField(String texto, int x, int y,
                                       int largura, int altura,
                                       boolean editar) {

        JTextField campo = new JTextField(texto);
        campo.setBounds(x, y, largura, altura);
        campo.setEditable(editar);

        return campo;
    }

    private JTextField createOutput(String texto) {

        JTextField campo = new JTextField(texto);
        campo.setEditable(false);
        campo.setBackground(new Color(230, 230, 230));
        campo.setFont(new Font("Arial", Font.BOLD, 12));

        return campo;
    }

    private JLabel createLabel(String texto, int x, int y,
                               int largura, int altura) {

        JLabel label = new JLabel(texto);
        label.setBounds(x, y, largura, altura);
        label.setFont(new Font("Arial", Font.BOLD, 12));

        return label;
    }

    // ERROS
    private void errorMsg(String msg) {

        JOptionPane.showMessageDialog(
                frame,
                msg,
                "Erro",
                JOptionPane.ERROR_MESSAGE);

    }

}