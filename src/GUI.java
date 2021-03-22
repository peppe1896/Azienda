import azienda.Ruolo;
import azienda.Unità;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GUI {
    private Controller controller;

    private JFrame frameFirst = new JFrame();
    private JMenuBar menuBar = new JMenuBar();

    private JFrame frameControl = new JFrame("console");
    private JTextArea areaConsole = new JTextArea();

    private JPanel panelFirst = new JPanel();

    private JPanel panelAddUnita = new JPanel();
    private JTextField textFieldUnita = new JTextField(15);
    private JLabel labelAddUnita = new JLabel("");
    private JButton buttonAddUnità = new JButton();
    private JLabel labelUnitaAzienda = new JLabel();
    private JButton buttonAutoAssign = new JButton();

    private JPanel panelText = new JPanel();
    private JTextArea areaUnities = new JTextArea();

    private JPanel panelCheck = new JPanel();
    private JLabel labelCheck = new JLabel("");
    private JTextArea areaCheck = new JTextArea();

    private JPanel panelAnalista = new JPanel();
    private JButton buttonAnalizza = new JButton("Analizza");
    private JLabel labelAnalistaState = new JLabel("");
    private JTextField textFieldRuolo = new JTextField(15);
    private JTextField textFieldCompetenza = new JTextField(15);
    private JButton buttonAddCompetenzaRuolo = new JButton("Aggiungi");

    public GUI(Controller controller){
        this.controller = controller;

        frameFirst.setName(controller.getNomeAzienda());
        frameFirst.setTitle(controller.getNomeAzienda());

        setFrameFirst();
        setPanelFirst();
        setPanelAddUnita();
        setPanelText();
        setPanelAnalista();
        setPanelCheck();

        setFrameControl();

        frameFirst.add(panelFirst, BorderLayout.NORTH);
        frameFirst.add(panelAddUnita, BorderLayout.WEST);
        frameFirst.add(panelText, BorderLayout.CENTER);
        frameFirst.add(panelCheck, BorderLayout.EAST);
        frameFirst.add(panelAnalista, BorderLayout.SOUTH);

        frameFirst.setVisible(true);
        frameControl.setVisible(true);
    }

    private void setFrameFirst(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameFirst.setSize(dim.getSize());
        frameFirst.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Window opened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window closing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Window closed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("Window iconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("Window deiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("Window activated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("Window deactivated");
            }
        });
        frameFirst.setBackground(Color.BLACK);
        frameFirst.setLayout(new BorderLayout());

        setBarMenu();
    }

    private void setBarMenu(){

    }

    private void setFrameControl(){
        frameControl.setBackground(Color.BLACK);
        //frameControl.setLayout(new FlowLayout(FlowLayout.LEFT));
        frameControl.setSize(600,400);
        areaConsole.setBackground(Color.black);
        areaConsole.setForeground(Color.GREEN);
        areaConsole.setText("CONSOLE "+ ((JLabel)panelFirst.getComponent(0)).getText() +"\n \n \n");
        frameControl.add(areaConsole);
        frameControl.setLocation(-600,200);
    }

    private void setPanelFirst(){
        panelFirst.setLayout(new GridLayout(3,6));
        panelFirst.setBackground(Color.RED);
        panelFirst.add(new JLabel("PROGRAMMONE"));
    }

    private void setPanelAddUnita(){
        panelAddUnita.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        setButtonAddUnità();
        setTextFieldUnita();
        panelAddUnita.add(textFieldUnita);
        panelAddUnita.add(buttonAddUnità);
        panelAddUnita.add(labelAddUnita);
    }

    private void setPanelText(){
        panelText.setLayout(new GridLayout(1,1));

        setButtonAutoAssign();

        panelText.add(areaUnities);
        panelText.add(buttonAutoAssign);
    }

    private void setButtonAddUnità(){
        buttonAddUnità.setText("Aggiungi");
        buttonAddUnità.setSize(60,30);

        buttonAddUnità.setActionCommand("AGGIUNGI-UNITA");
        buttonAddUnità.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("AGGIUNGI-UNITA")) {
                    if(controller.addUnità(textFieldUnita.getText())) {
                        updatePanelText();
                        textFieldUnita.setText("");
                    }
                }
            }
        });
    }

    private void updatePanelText(){
        areaUnities.setText("");
        for(Unità unita: controller.getUnitaAzienda())
            areaUnities.append(unita.getNome() + "\n");
        // se il numero di unità in azienda è uguale al numero di ruoli, possiamo fare un autoset dei ruoli
        if(controller.getUnitaAzienda().size() == controller.getRuoliAzienda().size())
        {
            buttonAutoAssign.setActionCommand("AUTOASSIGN-ROLES");
        }
        frameFirst.setVisible(true);
    }

    private void setButtonAutoAssign(){
        buttonAutoAssign.setText("Auto Assegna Ruoli");
        buttonAutoAssign.setActionCommand("NOTHING");
        buttonAutoAssign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("AUTOASSIGN-ROLES")) {
                    controller.autoSetRuoli();
                    buttonAutoAssign.setActionCommand("ALREADY-SET");
                    areaConsole.append("ATTENZIONE: ruoli automatici impostati\n");
                }
                if(e.getActionCommand().equals("NOTHING"))
                    areaConsole.append("ERRORE: non puoi registrare ancora i ruoli\n");
                if(e.getActionCommand().equals("ALREADY-SET"))
                    areaConsole.append("ERRORE: ruoli automatici già impostati\n");
                frameFirst.setVisible(true);
            }
        });
    }

    private void setTextFieldUnita(){
        textFieldUnita.setSize(60,300);
        textFieldUnita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.addUnità(textFieldUnita.getText()))
                    textFieldUnita.setText("");
                    updatePanelText();
            }
        });
    }

    private void setPanelAnalista(){
        panelAnalista.setLayout(new FlowLayout(FlowLayout.LEFT));

        setButtonAddCompetenza();
        setButtonAnalizza();

        panelAnalista.add(textFieldRuolo);
        panelAnalista.add(textFieldCompetenza);
        panelAnalista.add(buttonAddCompetenzaRuolo);
        panelAnalista.add(new JLabel("Analista"));
        panelAnalista.getComponent(0).setForeground(Color.BLACK);
        panelAnalista.add(buttonAnalizza);
    }

    private void setButtonAnalizza(){
        buttonAnalizza.setActionCommand("NOTHING");
        buttonAnalizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean allRoleCovered = true;
                if(e.getActionCommand().equals("ANALIZZA")) {
                    controller.analizza(allRoleCovered);
                    areaConsole.append("ATTENZIONE: ruoli analizzati\n");
                }
            }
        });
    }

    private void setButtonAddCompetenza(){
        buttonAddCompetenzaRuolo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = textFieldRuolo.getText();
                String b = textFieldCompetenza.getText();
                if(!a.equals("") && !b.equals("")){
                    Ruolo r = controller.getRuolo(textFieldRuolo.getText());
                    if(r != null){
                        if(!controller.haveThisCompetenza(r, textFieldCompetenza.getText())){
                            controller.addCompetenzaRuolo(r, textFieldCompetenza.getText());
                            areaConsole.append("Aggiunto a "+r.getNome() + " la competenza " +
                                    textFieldCompetenza.getText());
                            textFieldRuolo.setText("");
                            textFieldCompetenza.setText("");
                        }
                    }
                    else{
                        controller.addRuolo(textFieldRuolo.getText());
                        controller.addCompetenzaRuolo(controller.getRuolo(textFieldRuolo.getText()), textFieldCompetenza.getText());
                        areaConsole.append("Creato ruolo " + textFieldRuolo.getText() +
                                "; aggiunta competenza richiesta " + textFieldCompetenza.getText());
                        textFieldRuolo.setText("");
                        textFieldCompetenza.setText("");
                    }
                }
                else{
                    areaConsole.append("WARNING\n");
                }
            }
        });
    }

    private void setPanelCheck(){
        panelCheck.setLayout(new GridLayout(2,1));
        panelCheck.add(new JPanel(new FlowLayout(FlowLayout.LEFT)));
        panelCheck.setBackground(Color.BLACK);

        labelCheck.setForeground(Color.GREEN);
        labelCheck.setBackground(Color.BLACK);
        labelCheck.setText("STATO AZIENDA");
        panelCheck.add(areaCheck);
        areaCheck.setBackground(Color.BLUE);
        areaCheck.setForeground(Color.GREEN);
        areaCheck.setText("\nasdasd\n\n");
    }
}
