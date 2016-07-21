package com.cs102.recipegenerator.GUI2;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class Main2 extends JPanel {
   private List<DataPanel> dataPanelList = new ArrayList<DataPanel>();
   private JPanel dataPanelHolder = new JPanel();

   public Main2() {
      DataPanel dataPanel = new DataPanel();
      dataPanelList.add(dataPanel);
      setLayout(new BorderLayout());      
      dataPanelHolder.setLayout(new BoxLayout(dataPanelHolder, BoxLayout.PAGE_AXIS));
      dataPanelHolder.add(dataPanel);
      JPanel innerBorderLayoutPanel = new JPanel(new BorderLayout());
      innerBorderLayoutPanel.add(dataPanelHolder, BorderLayout.PAGE_START);

      JScrollPane scrollPane = new JScrollPane(innerBorderLayoutPanel);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      int w = dataPanel.getPreferredSize().width;
      int h = dataPanel.getPreferredSize().height * 4;
      Dimension viewPortSize = new Dimension(w, h);
      scrollPane.getViewport().setPreferredSize(viewPortSize);

      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      buttonPanel.add(new JButton(new AddDatatAction("Add")));
      buttonPanel.add(new JButton(new ExitAction("Exit", KeyEvent.VK_X)));

      add(scrollPane, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.PAGE_END);
   }

   private class AddDatatAction extends AbstractAction {
      private int maxCount = 4;
      public AddDatatAction(String name) {
         super(name);
         int mnemonic = (int)name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      
      public void actionPerformed(ActionEvent e) {
         if (dataPanelList.size() < maxCount) {
            DataPanel dataPanel = new DataPanel();
            dataPanelList.add(dataPanel);
            dataPanelHolder.add(dataPanel);
            dataPanelHolder.revalidate();
            dataPanelHolder.repaint();
         }
      }
   }

   private class ExitAction extends AbstractAction {
      public ExitAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

     
      public void actionPerformed(ActionEvent e) {
         Window win = SwingUtilities.getWindowAncestor(Main2.this);
         win.dispose();
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Main2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Main2());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

@SuppressWarnings("serial")
class DataPanel extends JPanel {
   private static final String[] TOOLS = {"Tool 1", "Tool 2", "Tool 3", "Tool 4"};
   private static final String[] FIELD_LABELS = {"Item", "Cost"};
   private static final String[] COMBO_LABELS = {"Foo", "Bar"};
   private JTextField[] fields = new JTextField[FIELD_LABELS.length];
   private List<JComboBox<String>> comboList = new ArrayList<JComboBox<String>>();

   public DataPanel() {
      setBorder(BorderFactory.createTitledBorder("Data"));
      setLayout(new GridBagLayout());
      for (int i = 0; i < FIELD_LABELS.length; i++) {
         add(new JLabel(FIELD_LABELS[i]), createGbc(0, i));
         fields[i] = new JTextField(10);
         add(fields[i], createGbc(1, i));

         JComboBox<String> combo = new JComboBox<String>(TOOLS);
         comboList.add(combo);
         add(combo, createGbc(2, i));
         add(new JLabel(COMBO_LABELS[i]), createGbc(3, i));         
      }
   }

   public static GridBagConstraints createGbc(int x, int y) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      int ins = 4;
      gbc.insets = new Insets(ins, ins, ins, ins);
      return gbc;
   }
}