package com.nato.panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NatoPhoneticAlphabetPanel extends JPanel {
    private final JFrame parent;
    private final List<String> symbolWordRelation;
    private final GridBagConstraints gridConstraints;
    private final JLabel enterLabel;

    public NatoPhoneticAlphabetPanel(JFrame parent) {
        this.gridConstraints = new GridBagConstraints();

        this.parent = parent;
        this.symbolWordRelation = new ArrayList<>();
        this.enterLabel = new JLabel("", SwingConstants.CENTER);

        initSymbolWordRelation();
    }

    private void initSymbolWordRelation() {
        symbolWordRelation.add("a = alpha");
        symbolWordRelation.add("b = bravo");
        symbolWordRelation.add("c = charlie");
        symbolWordRelation.add("d = delta");
        symbolWordRelation.add("e = echo");
        symbolWordRelation.add("f = foxtrot");
        symbolWordRelation.add("g = golf");
        symbolWordRelation.add("h = hotel");
        symbolWordRelation.add("i = india");
        symbolWordRelation.add("j = juliet");
        symbolWordRelation.add("k = kilo");
        symbolWordRelation.add("l = lima");
        symbolWordRelation.add("m = mike");
        symbolWordRelation.add("n = november");
        symbolWordRelation.add("o = oscar");
        symbolWordRelation.add("p = papa");
        symbolWordRelation.add("q = quebec");
        symbolWordRelation.add("r = romeo");
        symbolWordRelation.add("s = sierra");
        symbolWordRelation.add("t = tango");
        symbolWordRelation.add("u = uniform");
        symbolWordRelation.add("v = victor");
        symbolWordRelation.add("w = whiskey");
        symbolWordRelation.add("x = xray");
        symbolWordRelation.add("y = yankee");
        symbolWordRelation.add("z = zulu");
        symbolWordRelation.add("0 = zero");
        symbolWordRelation.add("1 = one");
        symbolWordRelation.add("2 = two");
        symbolWordRelation.add("3 = three");
        symbolWordRelation.add("4 = four");
        symbolWordRelation.add("5 = five");
        symbolWordRelation.add("6 = six");
        symbolWordRelation.add("7 = seven");
        symbolWordRelation.add("8 = eight");
        symbolWordRelation.add("9 = nine");
    }

    private void addSymbolWordRelation(String symbolWordRelationText, int x, int y) {
        gridConstraints.gridx = x;
        gridConstraints.gridy = y;
        gridConstraints.weightx = 1;
        gridConstraints.weighty = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.gridheight = 1;

        var label = new JLabel(symbolWordRelationText, SwingConstants.LEFT);
        add(label, gridConstraints);
    }

    private void setAlphabetLabel() {
        // add one third of the symbol word relations in the first column
        for (int i = 0; i < symbolWordRelation.size() / 3; i++) {
            addSymbolWordRelation(symbolWordRelation.get(i), 1, i + 1);
        }

        // add another third of the symbol word relations in the second column
        for (int i = 0; i < symbolWordRelation.size() / 3; i++) {
            addSymbolWordRelation(symbolWordRelation.get(i + symbolWordRelation.size() / 3), 2, i + 1);
        }

        // add another third of the symbol word relations in the third column
        for (int i = 0; i < symbolWordRelation.size() / 3; i++) {
            addSymbolWordRelation(symbolWordRelation.get(i + symbolWordRelation.size() / 3 * 2), 3, i + 1);
        }
    }

    private void setEnterToStartMessage() {
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 14;
        gridConstraints.weightx = 1;
        gridConstraints.weighty = 1;
        gridConstraints.gridwidth = 3;
        gridConstraints.gridheight = 1;

        enterLabel.setText("[PRESS ENTER TO CONTINUE]");
        add(enterLabel, gridConstraints);
    }

    private void setSelf() {
        setBackground(Color.white);
        setSize(parent.getSize());
        setLayout(new GridBagLayout());
    }

    public void set() {
        setSelf();
        setAlphabetLabel();
        setEnterToStartMessage();
    }
}
